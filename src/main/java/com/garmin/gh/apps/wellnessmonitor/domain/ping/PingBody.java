package com.garmin.gh.apps.wellnessmonitor.domain.ping;

import java.util.List;

public final class PingBody
{

	 private List<PingNotificationData> epochs;
	    private List<PingNotificationData> dailies;
	    private List<PingNotificationData> sleeps;
	    private List<PingNotificationData> bodyComps;
	    private List<PingNotificationData> activities;
	    private List<PingNotificationData> activityDetails;
	    private List<PingNotificationData> manuallyUpdatedActivities;
	    private List<PingNotificationData> moveIQActivities;
	    private List<PingNotificationData> deregistrations;
	    private List<PingNotificationData> thirdPartyDailies;
	    private List<PingNotificationData> stressDetails;
	    private List<PingNotificationData> userMetrics;
	    
	    public List<PingNotificationData> getEpochs()
	    {
	        return epochs;
	    }
	    public void setEpochs(List<PingNotificationData> epochs)
	    {
	        this.epochs = epochs;
	    }
	    public List<PingNotificationData> getDailies()
	    {
	        return dailies;
	    }
	    public void setDailies(List<PingNotificationData> dailies)
	    {
	        this.dailies = dailies;
	    }
	    public List<PingNotificationData> getSleeps()
	    {
	        return sleeps;
	    }
	    public void setSleeps(List<PingNotificationData> sleeps)
	    {
	        this.sleeps = sleeps;
	    }
	    public List<PingNotificationData> getBodyComps()
	    {
	        return bodyComps;
	    }
	    public void setBodyComps(List<PingNotificationData> bodyComps)
	    {
	        this.bodyComps = bodyComps;
	    }
	    public List<PingNotificationData> getActivities()
	    {
	        return activities;
	    }
	    public void setActivities(List<PingNotificationData> activities)
	    {
	        this.activities = activities;
	    }
	    public List<PingNotificationData> getActivityDetails()
	    {
	        return activityDetails;
	    }
	    public void setActivityDetails(List<PingNotificationData> activityDetails)
	    {
	        this.activityDetails = activityDetails;
	    }
	    public List<PingNotificationData> getManuallyUpdatedActivities()
	    {
	        return manuallyUpdatedActivities;
	    }
	    public void setManuallyUpdatedActivities(List<PingNotificationData> manuallyUpdatedActivities)
	    {
	        this.manuallyUpdatedActivities = manuallyUpdatedActivities;
	    }
	    public List<PingNotificationData> getMoveIQActivities()
	    {
	        return moveIQActivities;
	    }
	    public void setMoveIQActivities(List<PingNotificationData> moveIQActivities)
	    {
	        this.moveIQActivities = moveIQActivities;
	    }
	    public List<PingNotificationData> getDeregistrations()
	    {
	        return deregistrations;
	    }
	    public void setDeregistrations(List<PingNotificationData> deregistrations)
	    {
	        this.deregistrations = deregistrations;
	    }
	    public List<PingNotificationData> getThirdPartyDailies()
	    {
	        return thirdPartyDailies;
	    }
	    public void setThirdPartyDailies(List<PingNotificationData> thirdPartyDailies)
	    {
	        this.thirdPartyDailies = thirdPartyDailies;
	    }
	    public List<PingNotificationData> getStressDetails()
	    {
	        return stressDetails;
	    }
	    public void setStressDetails(List<PingNotificationData> stressDetails)
	    {
	        this.stressDetails = stressDetails;
	    }
	   
	    public List<PingNotificationData> getUserMetrics()
	    {
	        return userMetrics;
	    }
	    public void setUserMetrics(List<PingNotificationData> userMetrics)
	    {
	        this.userMetrics = userMetrics;
	    }


}
