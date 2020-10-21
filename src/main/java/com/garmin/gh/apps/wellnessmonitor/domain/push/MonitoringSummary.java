package com.garmin.gh.apps.wellnessmonitor.domain.push;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public final class MonitoringSummary
{
    private String userAccessToken;
    private String wellnessSummaryId;
    private String deviceType;
    private String deviceId;
    private Long startTime;
    private Long startTimeOffset;
    private String activityType;
    private Long durationSecs;
    private Long activeSecs;
    private Long steps;
    private Double distance;
    private Double kcal;
    private Double met;
    private String intensity;
    private Double voltage;

    public String getUserAccessToken()
    {
        return userAccessToken;
    }

    public void setUserAccessToken(String userAccessToken)
    {
        this.userAccessToken = userAccessToken;
    }

    public String getWellnessSummaryId()
    {
        return wellnessSummaryId;
    }

    public void setWellnessSummaryId(String wellnessSummaryId)
    {
        this.wellnessSummaryId = wellnessSummaryId;
    }

    public String getDeviceType()
    {
        return deviceType;
    }

    public void setDeviceType(String deviceType)
    {
        this.deviceType = deviceType;
    }

    public String getDeviceId()
    {
        return deviceId;
    }

    public void setDeviceId(String deviceId)
    {
        this.deviceId = deviceId;
    }

    public Long getStartTime()
    {
        return startTime;
    }

    public void setStartTime(Long startTime)
    {
        this.startTime = startTime;
    }

    public Long getStartTimeOffset()
    {
        return startTimeOffset;
    }

    public void setStartTimeOffset(Long startTimeOffset)
    {
        this.startTimeOffset = startTimeOffset;
    }

    public String getActivityType()
    {
        return activityType;
    }

    public void setActivityType(String activityType)
    {
        this.activityType = activityType;
    }

    public Long getDurationSecs()
    {
        return durationSecs;
    }

    public void setDurationSecs(Long durationSecs)
    {
        this.durationSecs = durationSecs;
    }

    public Long getActiveSecs()
    {
        return activeSecs;
    }

    public void setActiveSecs(Long activeSecs)
    {
        this.activeSecs = activeSecs;
    }

    public Long getSteps()
    {
        return steps;
    }

    public void setSteps(Long steps)
    {
        this.steps = steps;
    }

    public Double getDistance()
    {
        return distance;
    }

    public void setDistance(Double distance)
    {
        this.distance = distance;
    }

    public Double getKcal()
    {
        return kcal;
    }

    public void setKcal(Double kcal)
    {
        this.kcal = kcal;
    }

    public Double getMet()
    {
        return met;
    }

    public void setMet(Double met)
    {
        this.met = met;
    }

    public String getIntensity()
    {
        return intensity;
    }

    public void setIntensity(String intensity)
    {
        this.intensity = intensity;
    }

    public Double getVoltage()
    {
        return voltage;
    }

    public void setVoltage(Double voltage)
    {
        this.voltage = voltage;
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

    /**
     * @author GCS Eclipse Plug-In
     * @see java.lang.Object#hashCode()
     * @return A hash code value for this object
     */
    @Override
    public int hashCode()
    {
        HashCodeBuilder hashCodeBuilder = new HashCodeBuilder();
        hashCodeBuilder.append(this.wellnessSummaryId);
        hashCodeBuilder.append(this.deviceType);
        hashCodeBuilder.append(this.deviceId);
        hashCodeBuilder.append(this.startTime);
        hashCodeBuilder.append(this.startTimeOffset);
        hashCodeBuilder.append(this.activityType);
        hashCodeBuilder.append(this.durationSecs);
        hashCodeBuilder.append(this.activeSecs);
        hashCodeBuilder.append(this.steps);
        hashCodeBuilder.append(this.distance);
        hashCodeBuilder.append(this.kcal);
        hashCodeBuilder.append(this.met);
        hashCodeBuilder.append(this.intensity);
        hashCodeBuilder.append(this.voltage);

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

        if (!(other instanceof MonitoringSummary))
        {
            return false;
        }

        final MonitoringSummary otherMonitoringSummary = (MonitoringSummary) other;

        EqualsBuilder equalsBuilder = new EqualsBuilder();
        equalsBuilder.append(this.wellnessSummaryId, otherMonitoringSummary.wellnessSummaryId);
        equalsBuilder.append(this.deviceType, otherMonitoringSummary.deviceType);
        equalsBuilder.append(this.deviceId, otherMonitoringSummary.deviceId);
        equalsBuilder.append(this.startTime, otherMonitoringSummary.startTime);
        equalsBuilder.append(this.startTimeOffset, otherMonitoringSummary.startTimeOffset);
        equalsBuilder.append(this.activityType, otherMonitoringSummary.activityType);
        equalsBuilder.append(this.durationSecs, otherMonitoringSummary.durationSecs);
        equalsBuilder.append(this.activeSecs, otherMonitoringSummary.activeSecs);
        equalsBuilder.append(this.steps, otherMonitoringSummary.steps);
        equalsBuilder.append(this.distance, otherMonitoringSummary.distance);
        equalsBuilder.append(this.kcal, otherMonitoringSummary.kcal);
        equalsBuilder.append(this.met, otherMonitoringSummary.met);
        equalsBuilder.append(this.intensity, otherMonitoringSummary.intensity);
        equalsBuilder.append(this.voltage, otherMonitoringSummary.voltage);

        return equalsBuilder.isEquals();
    }

}
