package com.garmin.gh.apps.wellnessmonitor.domain.ping;

/**
 * A notification of data availability.
 * Perform an HTTP GET on the provided callback URL, signed with your credentials, to
 * get all changed data for this user. 
 * Other fields are provided for backwards compatibility and debugging but contain all the same data
 * already present in the callback URL.
 */

public final class PingNotificationData
{

    private String userAccessToken;
    private String uploadStartTimeInSeconds;
    private String uploadEndTimeInSeconds;
    private String callbackURL;
    
   

    public String getCallbackURL()
    {
        return callbackURL;
    }

    public void setCallbackURL(String callbackURL)
    {
        this.callbackURL = callbackURL;
    }

    public String getUserAccessToken()
    {
        return userAccessToken;
    }

    public void setUserAccessToken(String userAccessToken)
    {
        this.userAccessToken = userAccessToken;
    }

    public String getUploadStartTimeInSeconds()
    {
        return uploadStartTimeInSeconds;
    }

    public void setUploadStartTimeInSeconds(String uploadStartTimeInSeconds)
    {
        this.uploadStartTimeInSeconds = uploadStartTimeInSeconds;
    }

    public String getUploadEndTimeInSeconds()
    {
        return uploadEndTimeInSeconds;
    }

    public void setUploadEndTimeInSeconds(String uploadEndTimeInSeconds)
    {
        this.uploadEndTimeInSeconds = uploadEndTimeInSeconds;
    }

}
