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
import com.garmin.gh.apps.wellnessmonitor.domain.ping.PingBody;
import com.garmin.gh.apps.wellnessmonitor.domain.ping.PingNotificationData;


public class PingControllerTest {
    
    private static final Logger logger = LoggerFactory.getLogger(PingControllerTest.class);

        RestTemplate restTemplate = new RestTemplate();
        String invokationTargetUrl = "http://localhost:8080";
        int port = 8080;
        String callbackTargetUrl = "https://gcsapitest.garmin.com";
        ObjectMapper jackson = new ObjectMapper();
        
        Long currentTimeInSeconds = System.currentTimeMillis() / 1000l;
        Long yesterdayTimeInSeconds = (System.currentTimeMillis() / 1000l) - 86400;
        String consumerKey ="";// provide consumer key here
        String consumerSecret = "";// provide consumer secret here
        String uat = ""; // provide useraccesstoken here
        String uatSecret = "";//provide useraccesstoken secret here
        Socket s = null;
       
        
        @Test
        public void testPingDailies() throws Exception
        {
            PingBody pingBody = new PingBody();
            List<PingNotificationData> pingList = new ArrayList<>();
            
            PingNotificationData pingData1 = new PingNotificationData();
            pingData1.setCallbackURL(callbackTargetUrl+"/wellness-api/rest/dailies?uploadStartTimeInSeconds="+currentTimeInSeconds+"&uploadEndTimeInSeconds="+yesterdayTimeInSeconds);
            pingData1.setUploadStartTimeInSeconds(Long.toString(currentTimeInSeconds));
            pingData1.setUploadEndTimeInSeconds(Long.toString(yesterdayTimeInSeconds));
            pingData1.setUserAccessToken(uat);
            
            pingList.add(pingData1);
            
            pingBody.setDailies(pingList);
            
            HttpHeaders headers = new HttpHeaders();
            
            headers.setContentType(MediaType.APPLICATION_JSON);

            HttpEntity<String> entity = new HttpEntity<String>(jackson.writeValueAsString(pingBody) ,headers);
        
            try
            {  
                s = new Socket(Inet4Address.getLocalHost().getHostAddress(), port);
                restTemplate.postForEntity(invokationTargetUrl + "/ping/dailies", entity, String.class);
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
