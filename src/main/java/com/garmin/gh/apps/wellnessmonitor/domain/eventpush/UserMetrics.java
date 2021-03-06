package com.garmin.gh.apps.wellnessmonitor.domain.eventpush;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserMetrics
{
    private String userAccessToken;
    private String summaryId;
    private String calendarDate;
    private Double vo2Max;
    private Integer fitnessAge;

    
    public String getUserAccessToken()
    {
        return userAccessToken;
    }

    public void setUserAccessToken(String userAccessToken)
    {
        this.userAccessToken = userAccessToken;
    }

    public String getSummaryId()
    {
        return summaryId;
    }

    public void setSummaryId(String summaryId)
    {
        this.summaryId = summaryId;
    }

    public String getCalendarDate()
    {
        return calendarDate;
    }

    public void setCalendarDate(final String calendarDate)
    {
        this.calendarDate = calendarDate;
    }

    public Double getVo2Max()
    {
        return vo2Max;
    }

    public void setVo2Max(final Double vo2Max)
    {
        this.vo2Max = vo2Max;
    }

    public Integer getFitnessAge()
    {
        return fitnessAge;
    }

    public void setFitnessAge(final Integer fitnessAge)
    {
        this.fitnessAge = fitnessAge;
    }
   
}
