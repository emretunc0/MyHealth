package com.garmin.gh.apps.wellnessmonitor.domain.push;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public final class ActivitySummary
{

    private long activityId;

    private long activityDateMillis;

    private String consumerToken;

    private String userAccessToken;

    private String jsonData;

    public long getActivityId()
    {
        return activityId;
    }

    public void setActivityId(long activityId)
    {
        this.activityId = activityId;
    }

    public long getActivityDateMillis()
    {
        return activityDateMillis;
    }

    public void setActivityDateMillis(long activityDateMillis)
    {
        this.activityDateMillis = activityDateMillis;
    }

    public String getConsumerToken()
    {
        return consumerToken;
    }

    public void setConsumerToken(String consumerToken)
    {
        this.consumerToken = consumerToken;
    }

    public String getUserAccessToken()
    {
        return userAccessToken;
    }

    public void setUserAccessToken(String userAccessToken)
    {
        this.userAccessToken = userAccessToken;
    }

    public String getJsonData()
    {
        return jsonData;
    }

    public void setJsonData(String jsonData)
    {
        this.jsonData = jsonData;
    }

    /**
     * @author GCS Eclipse Plug-In
     * @see java.lang.Object#hashCode()
     * @return A hash code value for this object
     */
    @Override
    public int hashCode()
    {
        HashCodeBuilder hashCodeBuilder = new HashCodeBuilder();
        hashCodeBuilder.append(this.activityId);
        hashCodeBuilder.append(this.activityDateMillis);
        hashCodeBuilder.append(this.consumerToken);
        hashCodeBuilder.append(this.userAccessToken);
        hashCodeBuilder.append(this.jsonData);

        return hashCodeBuilder.toHashCode();
    }

    /**
     * @author GCS Eclipse Plug-In
     * @see java.lang.Object#equals(java.lang.Object)
     * @param other The reference object with which to compare
     * @return True if this object is the same as the other argument
     */
    @Override
    public boolean equals(final Object other)
    {
        if (other == this)
        {
            return true;
        }

        if (!(other instanceof ActivitySummary))
        {
            return false;
        }

        final ActivitySummary otherActivitySummary = (ActivitySummary) other;

        EqualsBuilder equalsBuilder = new EqualsBuilder();
        equalsBuilder.append(this.activityId, otherActivitySummary.activityId);
        equalsBuilder.append(this.activityDateMillis, otherActivitySummary.activityDateMillis);
        equalsBuilder.append(this.consumerToken, otherActivitySummary.consumerToken);
        equalsBuilder.append(this.userAccessToken, otherActivitySummary.userAccessToken);
        equalsBuilder.append(this.jsonData, otherActivitySummary.jsonData);

        return equalsBuilder.isEquals();
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
