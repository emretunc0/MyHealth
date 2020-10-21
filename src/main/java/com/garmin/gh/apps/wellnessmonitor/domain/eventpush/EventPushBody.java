package com.garmin.gh.apps.wellnessmonitor.domain.eventpush;

import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.garmin.gh.apps.wellnessmonitor.domain.ping.PingNotificationData;

public final class EventPushBody
{
    private List<Epoch> epochs;
    private List<Daily> dailies;
    private List<Sleep> sleeps;
    private List<BodyComp> bodyComps;
    private List<Activity> activities;
    private List<ActivityDetail> activityDetails;
    private List<Activity> manuallyUpdatedActivities;
    private List<AutoActivityMoveIq> moveIQActivities;
    private List<Stress> stressDetails;
    private List<UserMetrics> userMetrics;
    private List<UserInfo> userInfo;
    
    public List<Epoch> getEpochs()
    {
        return epochs;
    }
    public void setEpochs(List<Epoch> epochs)
    {
        this.epochs = epochs;
    }
    public List<Daily> getDailies()
    {
        return dailies;
    }
    public void setDailies(List<Daily> dailies)
    {
        this.dailies = dailies;
    }
    public List<AutoActivityMoveIq> getMoveIQActivities()
    {
        return moveIQActivities;
    }
    public void setMoveIQActivities(List<AutoActivityMoveIq> moveIQActivities)
    {
        this.moveIQActivities = moveIQActivities;
    }
    public List<Sleep> getSleeps()
    {
        return sleeps;
    }
    public void setSleeps(List<Sleep> sleeps)
    {
        this.sleeps = sleeps;
    }
    public List<BodyComp> getBodyComps()
    {
        return bodyComps;
    }
    public void setBodyComps(List<BodyComp> bodyComps)
    {
        this.bodyComps = bodyComps;
    }
    public List<Activity> getActivities()
    {
        return activities;
    }
    public void setActivities(List<Activity> activities)
    {
        this.activities = activities;
    }
    public List<Activity> getManuallyUpdatedActivities()
    {
        return manuallyUpdatedActivities;
    }
    public void setManuallyUpdatedActivities(List<Activity> manuallyUpdatedActivities)
    {
        this.manuallyUpdatedActivities = manuallyUpdatedActivities;
    }
    public List<ActivityDetail> getActivityDetails()
    {
        return activityDetails;
    }
    public void setActivityDetails(List<ActivityDetail> activityDetails)
    {
        this.activityDetails = activityDetails;
    }
    public List<Stress> getStressDetails()
    {
        return stressDetails;
    }
    public void setStressDetails(List<Stress> stressDetails)
    {
        this.stressDetails = stressDetails;
    }
    public List<UserMetrics> getUserMetrics()
    {
        return userMetrics;
    }
    public void setUserMetrics(List<UserMetrics> userMetrics)
    {
        this.userMetrics = userMetrics;
    }
    public List<UserInfo> getUserInfo()
    {
        return userInfo;
    }
    public void setUserInfo(List<UserInfo> userInfo)
    {
        this.userInfo = userInfo;
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
