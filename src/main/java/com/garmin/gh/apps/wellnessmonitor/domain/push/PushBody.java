package com.garmin.gh.apps.wellnessmonitor.domain.push;

import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;

public final class PushBody
{

    private long referenceId;
    private String creationDate;
    private List<ActivitySummary> activitySummaryList;
    private List<BodyCompositionSummary> bodyCompSummaryList;
    private List<DailySummary> dailySummaryList;
    private List<DeregistrationSummary> deregistrationSummaryList;
    private List<ActivitySummary> manuallyUpdatedActivitySummaryList;
    private List<MonitoringSummary> monitoringSummaryList;
    private List<SleepSummary> sleepSummaryList;
    private List<StressSummary> stressSummaryList;
    
    
    
    public List<BodyCompositionSummary> getBodyCompSummaryList()
    {
        return bodyCompSummaryList;
    }

    public void setBodyCompSummaryList(List<BodyCompositionSummary> bodyCompSummaryList)
    {
        this.bodyCompSummaryList = bodyCompSummaryList;
    }

    public List<DailySummary> getDailySummaryList()
    {
        return dailySummaryList;
    }

    public void setDailySummaryList(List<DailySummary> dailySummaryList)
    {
        this.dailySummaryList = dailySummaryList;
    }

    public List<DeregistrationSummary> getDeregistrationSummaryList()
    {
        return deregistrationSummaryList;
    }

    public void setDeregistrationSummaryList(List<DeregistrationSummary> deregistrationSummaryList)
    {
        this.deregistrationSummaryList = deregistrationSummaryList;
    }

    public List<ActivitySummary> getManuallyUpdatedActivitySummaryList()
    {
        return manuallyUpdatedActivitySummaryList;
    }

    public void setManuallyUpdatedActivitySummaryList(List<ActivitySummary> manuallyUpdatedActivitySummaryList)
    {
        this.manuallyUpdatedActivitySummaryList = manuallyUpdatedActivitySummaryList;
    }

    public List<MonitoringSummary> getMonitoringSummaryList()
    {
        return monitoringSummaryList;
    }

    public void setMonitoringSummaryList(List<MonitoringSummary> monitoringSummaryList)
    {
        this.monitoringSummaryList = monitoringSummaryList;
    }

    public List<SleepSummary> getSleepSummaryList()
    {
        return sleepSummaryList;
    }

    public void setSleepSummaryList(List<SleepSummary> sleepSummaryList)
    {
        this.sleepSummaryList = sleepSummaryList;
    }
    
    public List<StressSummary> getStressSummaryList()
    {
        return stressSummaryList;
    }

    public void setStressSummaryList(List<StressSummary> stressSummaryList)
    {
        this.stressSummaryList = stressSummaryList;
    }

    public long getReferenceId()
    {
        return referenceId;
    }

    public void setReferenceId(long referenceId)
    {
        this.referenceId = referenceId;
    }

    public String getCreationDate()
    {
        return creationDate;
    }

    public void setCreationDate(String creationDate)
    {
        this.creationDate = creationDate;
    }

    public List<ActivitySummary> getActivitySummaryList()
    {
        return activitySummaryList;
    }

    public void setActivitySummaryList(List<ActivitySummary> activitySummaryList)
    {
        this.activitySummaryList = activitySummaryList;
    }

    /**
     * @author GCS Eclipse Plug-In
     * @see java.lang.Object#toString()
     * @return A string representation of the object
     */
    @Override
    public String toString()
    {
        return ToStringBuilder.reflectionToString(this);
    }

}
