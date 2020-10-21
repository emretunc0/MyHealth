package com.garmin.gh.apps.wellnessmonitor.controller;

import java.io.IOException;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
import com.garmin.gh.apps.wellnessmonitor.dao.LoadSummaryDataDao;
import com.garmin.gh.apps.wellnessmonitor.dao.h2.WellnessDao;
import com.garmin.gh.apps.wellnessmonitor.domain.push.PushBody;
import com.garmin.gh.apps.wellnessmonitor.domain.eventpush.EventPushBody;
import com.garmin.gh.apps.wellnessmonitor.service.SummaryService;
import com.garmin.gh.apps.wellnessmonitor.util.Consts;

@RestController
@EnableAutoConfiguration
@Component
@RequestMapping("/push")
public class WellnessPushController
{

    private static final Logger logger = LoggerFactory.getLogger(WellnessPushController.class);
    
    @Autowired
    WellnessDao wellnessDao;
    
    @Autowired
    SummaryService summaryService;

    @Autowired
    LoadSummaryDataDao loadSummaryData;

   
    ObjectMapper jackson = new ObjectMapper();

    // Implementing Event-driven push model
    
    @RequestMapping(value = "/pushactivity", method = RequestMethod.POST)
    public ResponseEntity<String> acceptEventPushedActivities(@RequestBody @Valid EventPushBody activities)
        throws IOException
    {
        return summaryService.pullAndLoadEventPushSummaryData(Consts.ACTIVITIES,activities);
    }
    
    @RequestMapping(value = "/pushactivityDetails", method = RequestMethod.POST)
    public ResponseEntity<String> acceptEventPushedActivityDetails(@RequestBody @Valid EventPushBody activityDetails)
        throws IOException
    {
        return summaryService.pullAndLoadEventPushSummaryData(Consts.ACTIVITY_DETAILS,activityDetails);
    }
    
    @RequestMapping(value = "/pushmanualactivity", method = RequestMethod.POST)
    public ResponseEntity<String> acceptEventPushedManualActivities(@RequestBody @Valid EventPushBody manuallyUpdatedActivities)
        throws IOException
    {
        return summaryService.pullAndLoadEventPushSummaryData(Consts.ACTIVITYUPDATES,manuallyUpdatedActivities);
    }
    
    @RequestMapping(value = "/pushbodycomps", method = RequestMethod.POST)
    public ResponseEntity<String> acceptEventPushedBodyComps(@RequestBody @Valid EventPushBody bodyComps)
        throws IOException
    {
        return summaryService.pullAndLoadEventPushSummaryData(Consts.BODYCOMPS,bodyComps);
    }
    
    @RequestMapping(value = "/pushdaily", method = RequestMethod.POST)
    public ResponseEntity<String> acceptEventPushedDailies(@RequestBody @Valid EventPushBody dailies)
        throws IOException
    {
        return summaryService.pullAndLoadEventPushSummaryData(Consts.DAILIES,dailies);
    }

    @RequestMapping(value = "/pushepochs", method = RequestMethod.POST)
    public ResponseEntity<String> acceptEventPushedEpochs(@RequestBody @Valid EventPushBody epochs)
        throws IOException
    {
        return summaryService.pullAndLoadEventPushSummaryData(Consts.EPOCHS,epochs);
    }
    
    @RequestMapping(value = "/pushmoveIq", method = RequestMethod.POST)
    public ResponseEntity<String> acceptEventPushedMoveIq(@RequestBody @Valid EventPushBody moveIQActivities)
        throws IOException
    {
        return summaryService.pullAndLoadEventPushSummaryData(Consts.MOVEIQ,moveIQActivities);
    }
    
    @RequestMapping(value = "/pushsleeps", method = RequestMethod.POST)
    public ResponseEntity<String> acceptEventPushedSleeps(@RequestBody @Valid EventPushBody sleeps)
        throws IOException
    {
        return summaryService.pullAndLoadEventPushSummaryData(Consts.SLEEPS,sleeps);
    }
   
    @RequestMapping(value = "/pushstress", method = RequestMethod.POST)
    public ResponseEntity<String> acceptEventPushedStress(@RequestBody @Valid EventPushBody stressDetails)
        throws IOException
    {
        return summaryService.pullAndLoadEventPushSummaryData(Consts.STRESS,stressDetails);
    }
   
    @RequestMapping(value = "/pushusermetrics", method = RequestMethod.POST)
    public ResponseEntity<String> acceptEventPushedUserMetrics(@RequestBody @Valid EventPushBody userMetrics)
        throws IOException
    {
        return summaryService.pullAndLoadEventPushSummaryData(Consts.USERMETRICS,userMetrics);
    }
    
    
    // Implementing Legacy push model

    @RequestMapping(value = "/activitySummaries", method = RequestMethod.POST)
    public ResponseEntity<String> acceptPushedActivities(@RequestBody @Valid PushBody activitySummaries)
        throws IOException
    {
        return summaryService.pullAndLoadPushSummaryData(Consts.ACTIVITIES,activitySummaries);
    }


    @RequestMapping(value = "/activityUpdateSummaries", method = RequestMethod.POST)
    public ResponseEntity<String> acceptPushedActivityUpdates(
        @RequestBody @Valid PushBody manualActivitySummaries) throws IOException
    {
        return summaryService.pullAndLoadPushSummaryData(Consts.ACTIVITYUPDATES,manualActivitySummaries);

    }

    @RequestMapping(value = "/bodyCompSummaries", method = RequestMethod.POST)
    public ResponseEntity<String> acceptPushedBodyComposition(
        @RequestBody @Valid PushBody bodyCompSummaries) throws IOException
    {
        return summaryService.pullAndLoadPushSummaryData(Consts.BODYCOMPS,bodyCompSummaries);
    }

    @RequestMapping(value = "/dailySummaries", method = RequestMethod.POST)
    public ResponseEntity<String> acceptPushedDailies(@RequestBody @Valid PushBody dailySummaries)
        throws IOException
    {
        return summaryService.pullAndLoadPushSummaryData(Consts.DAILIES,dailySummaries);
    }
    
    @RequestMapping(value = "/monitoringSummaries", method = RequestMethod.POST)
    public ResponseEntity<String> acceptPushedEpochs(
        @RequestBody @Valid PushBody monitoringSummaries) throws IOException
    {
        return summaryService.pullAndLoadPushSummaryData(Consts.EPOCHS,monitoringSummaries);

    }

    @RequestMapping(value = "/sleepSummaries", method = RequestMethod.POST)
    public ResponseEntity<String> acceptPushedSleeps(@RequestBody @Valid PushBody sleepSummaries)
        throws IOException
    {
        return summaryService.pullAndLoadPushSummaryData(Consts.SLEEPS,sleepSummaries);

    }


    @RequestMapping(value = "/deregistrationSummaries", method = RequestMethod.POST)
    public ResponseEntity<String> acceptPushedDeregistrations(@RequestBody @Valid PushBody deregSummaries)
        throws IOException
    {
        logger.info("Deregistration pushed summary data:"
            + jackson.writerWithDefaultPrettyPrinter().writeValueAsString(deregSummaries));
        return new ResponseEntity<String>(HttpStatus.OK);

    }
    
    
 // endpoints to monitor event-driven  push data

    @RequestMapping(value = "/activityPushedSummary", method = RequestMethod.GET, produces = "application/json")
    private String displayActivityEventPushedSummaryData() throws JsonParseException,
        JsonMappingException, JsonProcessingException, IOException
    {
       return summaryService.getCurrentEventPushSummary(Consts.ACTIVITIES);

    }
    
    @RequestMapping(value = "/activityDetailPushedSummary", method = RequestMethod.GET, produces = "application/json")
    private String displayActivityDetailEventPushedSummaryData() throws JsonParseException,
        JsonMappingException, JsonProcessingException, IOException
    {
       return summaryService.getCurrentEventPushSummary(Consts.ACTIVITY_DETAILS);

    }

    @RequestMapping(value = "/activityUpdatePushedSummary", method = RequestMethod.GET, produces = "application/json")
    private String displayActivityUpdatesEventPushedSummaryData() throws JsonParseException,
        JsonMappingException, JsonProcessingException, IOException
    {
        return summaryService.getCurrentEventPushSummary(Consts.ACTIVITYUPDATES);
    }


    @RequestMapping(value = "/bodyCompPushedSummary", method = RequestMethod.GET, produces ="application/json")
    private String displayBodyCompsEventPushedSummaryData() throws JsonParseException,
        JsonMappingException, JsonProcessingException, IOException
    {
        return summaryService.getCurrentEventPushSummary(Consts.BODYCOMPS);
    }

    
    @RequestMapping(value = "/dailyPushedSummary", method = RequestMethod.GET, produces = "application/json")
    private String displayDailiesEventPushedSummaryData() throws JsonParseException,
        JsonMappingException, JsonProcessingException, IOException
    {
        return summaryService.getCurrentEventPushSummary(Consts.DAILIES);

    }

    @RequestMapping(value ="/epochPushedSummary", method = RequestMethod.GET, produces = "application/json")
    private String displayEpochsEventPushedSummaryData() throws JsonParseException,
        JsonMappingException, JsonProcessingException, IOException
    {
        return summaryService.getCurrentEventPushSummary(Consts.EPOCHS);
    }

    @RequestMapping(value ="/moveiqPushedSummary", method = RequestMethod.GET, produces = "application/json")
    private String displayMoveIqEventPushedSummaryData() throws JsonParseException,
        JsonMappingException, JsonProcessingException, IOException
    {
        return summaryService.getCurrentEventPushSummary(Consts.MOVEIQ);
    }
    
    @RequestMapping(value ="/sleepPushedSummary", method = RequestMethod.GET, produces = "application/json")
    private String displaySleepsEventPushedSummaryData() throws JsonParseException,
        JsonMappingException, JsonProcessingException, IOException
    {
        return summaryService.getCurrentEventPushSummary(Consts.SLEEPS);
    }
    
    @RequestMapping(value ="/stressPushedSummary", method = RequestMethod.GET, produces = "application/json")
    private String displayStressEventPushedSummaryData() throws JsonParseException,
        JsonMappingException, JsonProcessingException, IOException
    {
        return summaryService.getCurrentEventPushSummary(Consts.STRESS);
    }
    
    @RequestMapping(value ="/usermetricsPushedSummary", method = RequestMethod.GET, produces = "application/json")
    private String displayUserMetricsEventPushedSummaryData() throws JsonParseException,
        JsonMappingException, JsonProcessingException, IOException
    {
        return summaryService.getCurrentEventPushSummary(Consts.USERMETRICS);
    }
    
   
    
 // endpoints to monitor legacy  push data

    @RequestMapping(value = "/activitySummary", method = RequestMethod.GET, produces = "application/json")
    private String displayActivityPushedSummaryData() throws JsonParseException,
        JsonMappingException, JsonProcessingException, IOException
    {
       return summaryService.getCurrentPushSummary(Consts.ACTIVITIES);

    }
    
    @RequestMapping(value = "/activityDetailSummary", method = RequestMethod.GET, produces = "application/json")
    private String displayActivityDetailPushedSummaryData() throws JsonParseException,
        JsonMappingException, JsonProcessingException, IOException
    {
       return summaryService.getCurrentPushSummary(Consts.ACTIVITY_DETAILS);

    }

    @RequestMapping(value = "/activityUpdateSummary", method = RequestMethod.GET, produces = "application/json")
    private String displayActivityUpdatesPushedSummaryData() throws JsonParseException,
        JsonMappingException, JsonProcessingException, IOException
    {
        return summaryService.getCurrentPushSummary(Consts.ACTIVITYUPDATES);
    }


    @RequestMapping(value = "/bodyCompSummary", method = RequestMethod.GET, produces ="application/json")
    private String displayBodyCompsPushedSummaryData() throws JsonParseException,
        JsonMappingException, JsonProcessingException, IOException
    {
        return summaryService.getCurrentPushSummary(Consts.BODYCOMPS);
    }

    
    @RequestMapping(value = "/dailySummary", method = RequestMethod.GET, produces = "application/json")
    private String displayDailiesPushedSummaryData() throws JsonParseException,
        JsonMappingException, JsonProcessingException, IOException
    {
        return summaryService.getCurrentPushSummary(Consts.DAILIES);

    }

    @RequestMapping(value ="/epochSummary", method = RequestMethod.GET, produces = "application/json")
    private String displayEpochsPushedSummaryData() throws JsonParseException,
        JsonMappingException, JsonProcessingException, IOException
    {
        return summaryService.getCurrentPushSummary(Consts.EPOCHS);
    }

    @RequestMapping(value ="/moveiqSummary", method = RequestMethod.GET, produces = "application/json")
    private String displayMoveIqPushedSummaryData() throws JsonParseException,
        JsonMappingException, JsonProcessingException, IOException
    {
        return summaryService.getCurrentPushSummary(Consts.MOVEIQ);
    }
    
    @RequestMapping(value ="/sleepSummary", method = RequestMethod.GET, produces = "application/json")
    private String displaySleepsPushedSummaryData() throws JsonParseException,
        JsonMappingException, JsonProcessingException, IOException
    {
        return summaryService.getCurrentPushSummary(Consts.SLEEPS);
    }
    
    @RequestMapping(value ="/stressSummary", method = RequestMethod.GET, produces = "application/json")
    private String displayStressPushedSummaryData() throws JsonParseException,
        JsonMappingException, JsonProcessingException, IOException
    {
        return summaryService.getCurrentPushSummary(Consts.STRESS);
    }
    
    @RequestMapping(value ="/usermetricsSummary", method = RequestMethod.GET, produces = "application/json")
    private String displayUserMetricsPushedSummaryData() throws JsonParseException,
        JsonMappingException, JsonProcessingException, IOException
    {
        return summaryService.getCurrentPushSummary(Consts.USERMETRICS);
    }
    
}
