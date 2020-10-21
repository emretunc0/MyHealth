package com.garmin.gh.apps.wellnessmonitor.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.garmin.gh.apps.wellnessmonitor.dao.h2.WellnessDao;
import com.garmin.gh.apps.wellnessmonitor.domain.SummaryData;
import com.garmin.gh.apps.wellnessmonitor.util.Consts;

@Component
public class LoadSummaryDataDao
{
    @Autowired
    WellnessDao wellnessDao;
    
    @Value("${oauth.consumerkey}")
    private String pingConsumerkey;

    public void savePingData(String summary_domain,String userAccessToken,
            long timeStamp, String data_lob)
        {
            SummaryData summaryData = new SummaryData();
            summaryData.setSummaryDomain(summary_domain);
            summaryData.setModel(Consts.PING);
            summaryData.setConsumerKey(pingConsumerkey);
            summaryData.setUserAccessToken(userAccessToken);
            summaryData.setTimeStamp(timeStamp);
            summaryData.setDataLob(data_lob);
            wellnessDao.save(summaryData);
        }

        public void savePushData(String summaryDomain,long timeStamp,
            String dataLob,String pushType, String consumerKey)
        {
            SummaryData summaryData = new SummaryData();
            summaryData.setSummaryDomain(summaryDomain);
            summaryData.setModel(pushType);
            summaryData.setConsumerKey(consumerKey);
            summaryData.setTimeStamp(timeStamp);
            summaryData.setDataLob(dataLob);
            wellnessDao.save(summaryData);
        }
}
