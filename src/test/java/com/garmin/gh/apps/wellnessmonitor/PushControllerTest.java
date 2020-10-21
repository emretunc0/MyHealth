package com.garmin.gh.apps.wellnessmonitor;

import java.net.Inet4Address;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.garmin.gh.apps.wellnessmonitor.domain.push.DailySummary;
import com.garmin.gh.apps.wellnessmonitor.domain.push.MonitoringSummary;
import com.garmin.gh.apps.wellnessmonitor.domain.push.PushBody;


public class PushControllerTest {
    
    private static final Logger logger = LoggerFactory.getLogger(PushControllerTest.class);

		
		        RestTemplate restTemplate = new RestTemplate();
		        String invokationTargetUrl="http://localhost:8080";
		        ObjectMapper jackson  = new ObjectMapper();
		        
		        Long currentTimeInSeconds  = System.currentTimeMillis() / 1000l;
		        Long yesterdayTimeInSeconds = (System.currentTimeMillis() / 1000l) - 86400;
		        String consumerKey ="";//provide consumer key here
		        String consumerSecret = "";// provide consumer secret here
		        String uat= "";// provide useraccesstoken here
		        String uatSecret = "";// provide useraccesstoken secret here
		        Socket s= null;
		        int port = 8080;
		    
		      
	
		@Test()
	    public void testPushDailies() throws Exception
	    {
	        PushBody pushBody = new PushBody();
	        DailySummary dailies = new DailySummary();
	        dailies.setActiveSecs(9L);
	        dailies.setActivityType("WALKING");
	        dailies.setDeviceType("UNKNOWN");
	        dailies.setDistance(82.0);
	        dailies.setDurationSecs(51441L);
	        dailies.setKcal(2.0);
	        dailies.setStartTime(currentTimeInSeconds);
	        dailies.setStartTimeOffset(-18000000L);
	        dailies.setSteps(100L);
	        List<DailySummary> dailySummaryList = new ArrayList<DailySummary>();
	        dailySummaryList.add(dailies);
	        pushBody.setCreationDate(Long.toString(currentTimeInSeconds));
	        pushBody.setReferenceId(12345);
	        pushBody.setDailySummaryList(dailySummaryList);
	       
	        HttpHeaders headers = new HttpHeaders();
            
            headers.setContentType(MediaType.APPLICATION_JSON);

            HttpEntity<String> entity = new HttpEntity<String>(jackson.writeValueAsString(pushBody) ,headers);
            logger.info("calling dailies pushsummaries endpoint");
            // checking if the localhost is running or not.
            try
            {  
                s = new Socket(Inet4Address.getLocalHost().getHostAddress(), port);
                restTemplate.postForEntity(invokationTargetUrl + "/push/dailySummaries", entity, String.class);
            }
            catch (Exception e)
            {
                logger.info("not listening port");
            }
            finally
            {
                if(s != null)
                    try {s.close();}
                    catch(Exception e){}
            }
          
            
	    } 
		

        @Test()
        public void testPushEpochs() throws Exception
        {
            PushBody pushBody = new PushBody();
            MonitoringSummary epochs = new MonitoringSummary();
            epochs.setUserAccessToken(""); // provide useraccesstoken here
            epochs.setActiveSecs(9L);
            epochs.setActivityType("WALKING");
            epochs.setDeviceType("UNKNOWN");
            epochs.setDistance(82.0);
            epochs.setDurationSecs(360L);
            epochs.setKcal(2.0);
            epochs.setStartTime(currentTimeInSeconds);
            epochs.setStartTimeOffset(-18000000L);
            epochs.setSteps(100L);
            List<MonitoringSummary> monitoringSummaryList = new ArrayList<MonitoringSummary>();
            monitoringSummaryList.add(epochs);
            pushBody.setCreationDate(Long.toString(currentTimeInSeconds));
            pushBody.setReferenceId(12345);
            pushBody.setMonitoringSummaryList(monitoringSummaryList);
           
            HttpHeaders headers = new HttpHeaders();
            
            headers.setContentType(MediaType.APPLICATION_JSON);

            HttpEntity<String> entity = new HttpEntity<String>(jackson.writeValueAsString(pushBody) ,headers);
            logger.info("calling epoch pushsummaries endpoint");
            try
            {  
                s = new Socket(Inet4Address.getLocalHost().getHostAddress(), port);
                restTemplate.postForEntity(invokationTargetUrl + "/push/monitoringSummaries", entity, String.class);
            }
            catch (Exception e)
            {
                logger.info("not listening port");
            }
            finally
            {
                if(s != null)
                    try {s.close();}
                    catch(Exception e){}
            }
            
          
            
        } 
}
