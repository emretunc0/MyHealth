package com.garmin.gh.apps.wellnessmonitor.dao.h2;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.garmin.gh.apps.wellnessmonitor.domain.SummaryData;


public interface WellnessDao extends JpaRepository<SummaryData, Long> {
	@Query("select d from SummaryData d  where  d.summaryDomain =?1 and d.model =?2 and d.userAccessToken = ?3 order by d.timeStamp DESC")
	List<SummaryData> findPingSummaryDataByDomain(String domain,String model,String userAccessToken);
	
	@Query("select d from SummaryData d  where  d.summaryDomain =?1 and d.model =?2 order by d.timeStamp DESC")
	List<SummaryData> findPushSummaryDataByDomain(String domain,String model);
	
	}
