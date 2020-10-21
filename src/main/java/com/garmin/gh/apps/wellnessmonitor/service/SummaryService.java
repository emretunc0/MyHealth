package com.garmin.gh.apps.wellnessmonitor.service;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.garmin.gh.apps.wellnessmonitor.dao.LoadSummaryDataDao;
import com.garmin.gh.apps.wellnessmonitor.dao.h2.UserPartnerDao;
import com.garmin.gh.apps.wellnessmonitor.dao.h2.WellnessDao;
import com.garmin.gh.apps.wellnessmonitor.domain.SummaryData;
import com.garmin.gh.apps.wellnessmonitor.domain.ping.PingNotificationData;
import com.garmin.gh.apps.wellnessmonitor.domain.push.PushBody;
import com.garmin.gh.apps.wellnessmonitor.domain.eventpush.EventPushBody;
import com.garmin.gh.apps.wellnessmonitor.util.Consts;

@Service
@Component
public class SummaryService {

	private static Logger pingLogger = LoggerFactory.getLogger("ping-log");
	private static Logger pushLogger = LoggerFactory.getLogger("push-log");
	private static Logger eventPushLogger = LoggerFactory.getLogger("event-push-log");
	
	ExecutorService executor = Executors.newFixedThreadPool(100);

	@Autowired
	UserPartnerDao userPartnerDao;

	@Autowired
	WellnessDao wellnessDao;

	@Autowired
	LoadSummaryDataDao loadSummaryData;
	
	@Autowired
    OauthConfiguration oauthConfig;

	@Value("${ping.userAccessToken}")
    private String userToken;
	
	@Value("${eventPush.consumerkey}")
    private String eventPushCK;

    @Value("${legacyPush.consumerkey}")
    private String legacyPushCK;

	ObjectMapper jackson = new ObjectMapper();

	// processing each ping notification and calling healthapi to get summary
	// data.
	
	public ResponseEntity<String> invokeHealthApi(List<PingNotificationData> pingNotifications, String summaryDomain) {
		for (PingNotificationData notification : pingNotifications) {
			executor.execute(new Runnable() {

				@Override
				public void run() {
					try {
					    pingLogger.info(
                            " {} ping notification data:userAccessToken:{}uploadStartTime:{}uploadEndTime:{}callBackUrl{}",
                            summaryDomain, notification.getUserAccessToken(),
                            notification.getUploadStartTimeInSeconds(), notification.getUploadEndTimeInSeconds(),
                            notification.getCallbackURL());
						String summaryData = retrieveSummaryDataByUploadTime(summaryDomain,
								notification.getUserAccessToken(), notification.getCallbackURL());
						int i=0;
						while(summaryData == null && i< 5){ // retry logic
						    pingLogger.info("inside retrylogic");
						    summaryData = retrieveSummaryDataByUploadTime(summaryDomain,
                                notification.getUserAccessToken(), notification.getCallbackURL()); 
						    i++;
						}
						if(summaryData != null){
						    long timeStamp = System.currentTimeMillis()/1000;
						    pingLogger.info("{} info for userAccessToken:{}:-{}", summaryDomain,
								notification.getUserAccessToken(), summaryData);
						    loadSummaryData.savePingData(summaryDomain,notification.getUserAccessToken(), timeStamp, summaryData);
						}
					} catch (Exception e) {
					        pingLogger.error("error in exception:" + e.getMessage());
					}
				}
			}

			);

		}
		pingLogger.info("sending acknowledgement - 200  for {} ping notification service", summaryDomain);
		return new ResponseEntity<String>(HttpStatus.OK);
	}

	/*
	 * calling Rest APIs to get Summary data for each Summary Domain.
	 */
	public String retrieveSummaryDataByUploadTime(String summaryName, String userAccessToken, String callbackURL) {
		String summaryInfo = null;
		try {
		    RestTemplate restTemplate = oauthConfig.getRestTemplate(userAccessToken, userPartnerDao.getUserAccessSecret(userAccessToken));
			ResponseEntity<String> result =  restTemplate.exchange(callbackURL, HttpMethod.GET, oauthConfig.httpEntity(), String.class);
			summaryInfo = prettyPrint(result.getBody().toString());
		}

		catch (Exception e) {
		    pingLogger.error("failed to get summary data:" + e.getMessage());
		}
		
		return summaryInfo;
	}
	
	public ResponseEntity<String> pullAndLoadEventPushSummaryData(String summaryDomain,EventPushBody summaryData) throws IOException{
        if(summaryData != null){
            String summaryInfo =  jackson.writerWithDefaultPrettyPrinter().writeValueAsString(summaryData);
            long timeStamp = System.currentTimeMillis()/1000;
            eventPushLogger.info("{} pushed summary data:-{}",summaryDomain,summaryInfo);
            loadSummaryData.savePushData(summaryDomain,timeStamp,summaryInfo,Consts.EVENT_PUSH,eventPushCK);
            eventPushLogger.info("sending acknowledgement 200 to {} push notification service",summaryDomain);
            return new ResponseEntity<String>(HttpStatus.OK);
        }
        else{
            eventPushLogger.info("sending acknowledgement - 204 for {} push summary",summaryDomain);
            return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
        }
    }
	
		
	public ResponseEntity<String> pullAndLoadPushSummaryData(String summaryDomain,PushBody summaryData) throws IOException{
	    if(summaryData != null){
	        String summaryInfo =  jackson.writerWithDefaultPrettyPrinter().writeValueAsString(summaryData);
	        long timeStamp = System.currentTimeMillis()/1000;
            pushLogger.info("{} pushed summary data:-{}",summaryDomain,summaryInfo);
            loadSummaryData.savePushData(summaryDomain,timeStamp,summaryInfo,Consts.LEGACY_PUSH,legacyPushCK);
            pushLogger.info("sending acknowledgement 200 to {} push notification service",summaryDomain);
	        return new ResponseEntity<String>(HttpStatus.OK);
	    }
	    else{
            pushLogger.info("sending acknowledgement - 204 for {} push summary",summaryDomain);
            return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
	    }
	}
	
   // It displays ping summary data for the default useraccesstoken(userToken)
	
	public String getCurrentPingSummary(String summaryDomain) throws IOException{
	    
	    String pingSummaryInfo;
	    List<SummaryData> pingSummaryDataList = wellnessDao.findPingSummaryDataByDomain(summaryDomain,Consts.PING,userToken);
        if (pingSummaryDataList.size() > 0)
        {
            pingSummaryInfo = pingSummaryDataList.get(0).getDataLob();
        }
        else
        {
            pingSummaryInfo = jackson.writerWithDefaultPrettyPrinter().writeValueAsString(summaryDomain +Consts.PING+ Consts.WARNING_MESSAGE);
        }
        return pingSummaryInfo;
	}
	
	
	//It displays the Event-driven push summary for default event driven push consumerkey
    public String getCurrentEventPushSummary(String summaryDomain)throws IOException{
        
        String eventPushSummaryInfo;
        List<SummaryData> eventPushSummaryDataList = wellnessDao.findPushSummaryDataByDomain(summaryDomain,Consts.EVENT_PUSH);
        if (eventPushSummaryDataList.size() > 0)
        {
        	eventPushSummaryInfo = eventPushSummaryDataList.get(0).getDataLob();
        }
        else
        {
        	eventPushSummaryInfo = jackson.writerWithDefaultPrettyPrinter().writeValueAsString(summaryDomain +Consts.EVENT_PUSH+ Consts.WARNING_MESSAGE);
        }
        return eventPushSummaryInfo;
       
    }
	
	//It displays the push summary for default push consumerkey (legacyPushCK)
    public String getCurrentPushSummary(String summaryDomain)throws IOException{
        
        String pushSummaryInfo;
        List<SummaryData> pushSummaryDataList = wellnessDao.findPushSummaryDataByDomain(summaryDomain,Consts.LEGACY_PUSH);
        if (pushSummaryDataList.size() > 0)
        {
            pushSummaryInfo = pushSummaryDataList.get(0).getDataLob();
        }
        else
        {
            pushSummaryInfo = jackson.writerWithDefaultPrettyPrinter().writeValueAsString(summaryDomain +Consts.LEGACY_PUSH+ Consts.WARNING_MESSAGE);
        }
        return pushSummaryInfo;
       
    }
    
	private String prettyPrint(String data)
			throws JsonParseException, JsonMappingException, JsonProcessingException, IOException {
		return jackson.writerWithDefaultPrettyPrinter().writeValueAsString(jackson.readValue(data, Object.class));
	}
	
	
}