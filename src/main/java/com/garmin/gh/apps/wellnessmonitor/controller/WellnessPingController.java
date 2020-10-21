package com.garmin.gh.apps.wellnessmonitor.controller;

import java.io.IOException;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.garmin.gh.apps.wellnessmonitor.dao.h2.UserPartnerDao;
import com.garmin.gh.apps.wellnessmonitor.dao.h2.WellnessDao;
import com.garmin.gh.apps.wellnessmonitor.domain.UserPartner;
import com.garmin.gh.apps.wellnessmonitor.domain.ping.Deregistrations;
import com.garmin.gh.apps.wellnessmonitor.domain.ping.PingBody;
import com.garmin.gh.apps.wellnessmonitor.domain.ping.PingNotificationForDereg;
import com.garmin.gh.apps.wellnessmonitor.service.SummaryService;
import com.garmin.gh.apps.wellnessmonitor.util.Consts;


/**
 * This controller exercises the core ping/pull implementation.
 * It accepts change notifications from the Garmin Health servers and fetches data
 * based on the provided callback URL. You may choose to have an endpoint for each data type
 * or a single endpoint to handle them all - the target for these notifications is
 * configurable at /wellness-api/web/ping on a per-type basis. 
 *
 */

@RestController
@EnableAutoConfiguration
@Component
@RequestMapping("/ping")
public class WellnessPingController
{

    private static final Logger logger = LoggerFactory.getLogger(WellnessPingController.class);
  
    ObjectMapper jackson = new ObjectMapper();
    
    @Autowired
    SummaryService summaryService;
    
    @Autowired
    UserPartnerDao userPartnerDao;
    
    @Autowired
    WellnessDao wellnessDao;


    //Your Health API Consumer Key
    @Value("${oauth.consumerkey}")
    private String consumerkey;

    @Value("${oauth.consumerSecret}")
    private String consumerSecret;


    @RequestMapping(value = "/activities", method = RequestMethod.POST)
    public ResponseEntity<String> handleActivityPingNotification(@RequestBody @Valid PingBody activities)
    {
        logger.info("activities ping notification");
        if (activities != null && activities.getActivities() != null && activities.getActivities().size() > 0)
        {
            return  summaryService.invokeHealthApi(activities.getActivities(),Consts.ACTIVITIES);
        }
        else
        {
            logger.info("sending acknowledgement - 204  for activities ping notification service");
            return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
        }
    }
    
    @RequestMapping(value = "/activityDetails", method = RequestMethod.POST)
    public ResponseEntity<String> handleActivityDetailsPingNotification(@RequestBody @Valid PingBody activityDetails)
    {
        logger.info("activity details ping notification");
        if (activityDetails != null && activityDetails.getActivityDetails() != null && activityDetails.getActivityDetails().size() > 0)
        {
            return  summaryService.invokeHealthApi(activityDetails.getActivityDetails(),Consts.ACTIVITY_DETAILS);
        }
        else
        {
            logger.info("sending acknowledgement - 204  for activityDetails ping notification service");
            return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
        }
    }
    
    @RequestMapping(value = "/activityUpdates", method = RequestMethod.POST)
    public ResponseEntity<String> handleActivityUpdatePingNotification(
        @RequestBody @Valid PingBody manuallyUpdatedActivities)
    {
        logger.info("ActivityUpdate ping notification");
        if (manuallyUpdatedActivities != null && manuallyUpdatedActivities.getManuallyUpdatedActivities() != null
            && manuallyUpdatedActivities.getManuallyUpdatedActivities().size() > 0)
        {
            return  summaryService.invokeHealthApi(manuallyUpdatedActivities.getManuallyUpdatedActivities(),Consts.ACTIVITYUPDATES);
        }
        else
        {
            logger.info("sending acknowledgement - 204 for activityUpdates ping notification service");
            return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
        }
    }
    
    @RequestMapping(value = "/bodyComps", method = RequestMethod.POST)
    public ResponseEntity<String> handleBodyCompsPingNotification(@RequestBody @Valid PingBody bodyComps)
    {
        logger.info("BodyComps ping notification");
        if (bodyComps != null && bodyComps.getBodyComps() != null && bodyComps.getBodyComps().size() > 0)
        {
            return  summaryService.invokeHealthApi(bodyComps.getBodyComps(),Consts.BODYCOMPS);
        }
        else
        {
            logger.info("sending acknowledgement - 204 for bodyComps ping notification service");
            return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
        }
    }
    
    @RequestMapping(value = "/dailies", method = RequestMethod.POST)
    public ResponseEntity<String> handleDailiesPingNotification(@RequestBody @Valid PingBody dailies)

    {
        logger.info("Dailies ping notification");
        if (dailies != null && dailies.getDailies() != null && dailies.getDailies().size() > 0)
        {
            return  summaryService.invokeHealthApi( dailies.getDailies(),Consts.DAILIES);
        }
        else
        {
            logger.info("sending acknowledgement - 204 for dailies ping notification service");
            return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
        }
    }
    

    @RequestMapping(value = "/epochs", method = RequestMethod.POST)
    public ResponseEntity<String> handleEpochsPingNotification(@RequestBody @Valid PingBody epochs)
    {
        logger.info("epochs ping notification");
        if (epochs != null && epochs.getEpochs() != null && epochs.getEpochs().size() > 0)
        {
            return  summaryService.invokeHealthApi(epochs.getEpochs(),Consts.EPOCHS);
        }
        else
        {
            logger.info("sending acknowledgement - 204 for epochs ping notification service");
            return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
        }
    }
    
    @RequestMapping(value = "/moveIQ", method = RequestMethod.POST)
    public ResponseEntity<String> handleMoveIQPingNotification(@RequestBody @Valid PingBody moveIQActivities)
    {
        logger.info("moveIQ ping notification");
        if (moveIQActivities != null && moveIQActivities.getMoveIQActivities() != null && moveIQActivities.getMoveIQActivities().size() > 0)
        {
            return  summaryService.invokeHealthApi(moveIQActivities.getMoveIQActivities(),Consts.MOVEIQ);
        }
        else
        {
            logger.info("sending acknowledgement - 204 for moveIQ ping notification service");
            return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
        }
    }
    

    @RequestMapping(value = "/sleeps", method = RequestMethod.POST)
    public ResponseEntity<String> handleSleepsPingNotification(@RequestBody @Valid PingBody sleeps)
    {
        logger.info("sleeps ping notification");
        if (sleeps != null && sleeps.getSleeps() != null && sleeps.getSleeps().size() > 0)
        {
            return  summaryService.invokeHealthApi(sleeps.getSleeps(),Consts.SLEEPS);
        }
        else
        {
            logger.info("sending acknowledgement - 204 for sleeps ping notification service");
            return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
        }
    }
  
    
    @RequestMapping(value = "/stress", method = RequestMethod.POST)
    public ResponseEntity<String> handleStressPingNotification(@RequestBody @Valid PingBody stressDetails)
    {
        logger.info("Stress ping notification");
        if (stressDetails != null && stressDetails.getStressDetails()!= null && stressDetails.getStressDetails().size() > 0)
        {
            return  summaryService.invokeHealthApi(stressDetails.getStressDetails(),Consts.STRESS);
        }
        else
        {
            logger.info("sending acknowledgement - 204 for stress ping notification service");
            return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
        }
    }
    


    @RequestMapping(value = "/thirdPartyDailies", method = RequestMethod.POST)
    public ResponseEntity<String> handleThirdPartyDailiesPingNotification(
        @RequestBody @Valid PingBody thirdPartyDailies)

    {
        logger.info("thirdPartyDailies ping notification");
        if (thirdPartyDailies != null && thirdPartyDailies.getThirdPartyDailies() != null
            && thirdPartyDailies.getThirdPartyDailies().size() > 0)
        {
            return  summaryService.invokeHealthApi(thirdPartyDailies.getThirdPartyDailies(),Consts.THIRD_PARTY_DAILIES);
        }
        else
        {
            logger.info("sending acknowledgement - 204 for thirdpartydailies ping notification service");
            return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
        }
    }

    
    
    @RequestMapping(value = "/userMetrics", method = RequestMethod.POST)
    public ResponseEntity<String> handleUserMetricsPingNotification(@RequestBody @Valid PingBody userMetrics)
    {
        logger.info("UserMetrics ping notification");
        if (userMetrics != null && userMetrics.getUserMetrics()!= null && userMetrics.getUserMetrics().size() > 0)
        {
            return  summaryService.invokeHealthApi(userMetrics.getUserMetrics(),Consts.USERMETRICS);
        }
        else
        {
            logger.info("sending acknowledgement - 204 for usermetrics ping notification service");
            return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
        }
    }
    

    @RequestMapping(value = "/deRegistrations", method = RequestMethod.POST)
    public ResponseEntity<String> handleDeregistrationPingNotification(
        @RequestBody @Valid Deregistrations deregistrations)
    {
        logger.info("Deregistration ping notification");
        if (deregistrations != null && deregistrations.getDeregistrations() != null
            && deregistrations.getDeregistrations().size() > 0)
        {
            for(PingNotificationForDereg deregistration:deregistrations.getDeregistrations())
            {
                logger.info("Deregistration ping notification data:userAccessToken:{}", deregistration.getUserAccessToken());
                logger.info("Deleting useraccesstoken information in userpartner table");
                UserPartner userPartnerTable = userPartnerDao.findByToken(deregistration
                    .getUserAccessToken());
                if (userPartnerTable != null)
                {
                    userPartnerDao.delete(userPartnerTable.getUserId());
                }
                // have to go for oauthprocess for this user to get a new useraccesstoken
            }
            return new ResponseEntity<String>(HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
        }
    }
    
    
    
    // Endpoints to display ping data.

    @RequestMapping(value ="/activitySummary", method = RequestMethod.GET,produces = "application/json")
    private String displayActivitiesPingSummaryData() throws JsonParseException, JsonMappingException, JsonProcessingException,
        IOException
    {
        return summaryService.getCurrentPingSummary(Consts.ACTIVITIES);
        
    }
    
    @RequestMapping(value = "/activityDetailSummary", method = RequestMethod.GET,produces = "application/json")
    private String displayActivityDetailPingSummaryData() throws JsonParseException, JsonMappingException, JsonProcessingException,
        IOException
    {
        return summaryService.getCurrentPingSummary(Consts.ACTIVITY_DETAILS);
        
    }
    
    @RequestMapping(value = "/activityUpdateSummary", method = RequestMethod.GET, produces = "application/json")
    private String displayactivityUpdatesPingSummaryData() throws JsonParseException, JsonMappingException, JsonProcessingException,
        IOException
    {
        return summaryService.getCurrentPingSummary(Consts.ACTIVITYUPDATES);
    }
    
    @RequestMapping(value = "/bodyCompSummary", method = RequestMethod.GET, produces = "application/json")
    private String displayBodyCompsPingSummaryData() throws JsonParseException, JsonMappingException, JsonProcessingException,
        IOException
    {
        return summaryService.getCurrentPingSummary(Consts.BODYCOMPS);
    }

    @RequestMapping(value = "/dailySummary", method = RequestMethod.GET,produces = "application/json")
    private String displayDailiesPingSummaryData()
        throws JsonParseException, JsonMappingException, JsonProcessingException, IOException
    {
        return summaryService.getCurrentPingSummary(Consts.DAILIES);
    }

    @RequestMapping(value = "/epochSummary", method = RequestMethod.GET, produces = "application/json")
    private String displayEpochsPingSummaryData() throws IOException
       
    {
        return summaryService.getCurrentPingSummary(Consts.EPOCHS);
    }
    
    @RequestMapping(value = "/moveIQSummary", method = RequestMethod.GET, produces = "application/json")
    private String displayMoveIQPingSummaryData() throws IOException
       
    {
        return summaryService.getCurrentPingSummary(Consts.MOVEIQ);
    }

    @RequestMapping(value = "/sleepSummary", method = RequestMethod.GET, produces ="application/json")
    private String displaySleepsPingSummaryData()
        throws JsonParseException, JsonMappingException, JsonProcessingException, IOException
    {
        return summaryService.getCurrentPingSummary(Consts.SLEEPS);
    }

    
    @RequestMapping(value = "/stressSummary", method = RequestMethod.GET, produces = "application/json")
    private String displayStressPingSummaryData() throws JsonParseException, JsonMappingException, JsonProcessingException,
        IOException
    {
        return summaryService.getCurrentPingSummary(Consts.STRESS);
    }
   
    
    @RequestMapping(value = "/userMetricsSummary", method = RequestMethod.GET, produces = "application/json")
    private String displayUserMetricsPingSummaryData() throws JsonParseException, JsonMappingException, JsonProcessingException,
        IOException
    {
        return summaryService.getCurrentPingSummary(Consts.USERMETRICS);
    }
   
}
