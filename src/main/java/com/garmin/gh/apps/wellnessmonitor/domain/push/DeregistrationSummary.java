package com.garmin.gh.apps.wellnessmonitor.domain.push;

import org.apache.commons.lang.builder.ToStringBuilder;

public final class DeregistrationSummary
{
    private String deregistrationId;
    private String userAccessToken;
    private long timestamp;

    public String getDeregistrationId()
    {
        return deregistrationId;
    }

    public void setDeregistrationId(String deregistrationId)
    {
        this.deregistrationId = deregistrationId;
    }

    public String getUserAccessToken()
    {
        return userAccessToken;
    }

    public void setUserAccessToken(String userAccessToken)
    {
        this.userAccessToken = userAccessToken;
    }

    public long getTimestamp()
    {
        return timestamp;
    }

    public void setTimestamp(long timestamp)
    {
        this.timestamp = timestamp;
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
