package com.garmin.gh.apps.wellnessmonitor.domain.push;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import java.util.List;
import java.util.Map;

public final class SleepSummary
{
    private String userAccessToken;
    private String wellnessSummaryId;
    private String deviceType;
    private String deviceId;
    private Long startTime;
    private Long startTimeOffset;
    private Long durationSecs;
    private Integer deepSleepSecs;
    private Integer lightSleepSecs;
    private Integer awakeSecs;
    private Map<String, List<WellnessSleepRange>> sleepLevelsMap;
    private String validation;

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

    public Long getDurationSecs()
    {
        return durationSecs;
    }

    public void setDurationSecs(Long durationSecs)
    {
        this.durationSecs = durationSecs;
    }

    public Integer getDeepSleepSecs()
    {
        return deepSleepSecs;
    }

    public void setDeepSleepSecs(Integer deepSleepSecs)
    {
        this.deepSleepSecs = deepSleepSecs;
    }

    public Integer getLightSleepSecs()
    {
        return lightSleepSecs;
    }

    public void setLightSleepSecs(Integer lightSleepSecs)
    {
        this.lightSleepSecs = lightSleepSecs;
    }

    public Integer getAwakeSecs()
    {
        return awakeSecs;
    }

    public void setAwakeSecs(Integer awakeSecs)
    {
        this.awakeSecs = awakeSecs;
    }

    public Map<String, List<WellnessSleepRange>> getSleepLevelsMap()
    {
        return sleepLevelsMap;
    }

    public void setSleepLevelsMap(Map<String, List<WellnessSleepRange>> sleepLevelsMap)
    {
        this.sleepLevelsMap = sleepLevelsMap;
    }

    public String getValidation()
    {
        return validation;
    }

    public void setValidation(String validation)
    {
        this.validation = validation;
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
        hashCodeBuilder.append(this.userAccessToken);
        hashCodeBuilder.append(this.wellnessSummaryId);
        hashCodeBuilder.append(this.deviceType);
        hashCodeBuilder.append(this.deviceId);
        hashCodeBuilder.append(this.startTime);
        hashCodeBuilder.append(this.startTimeOffset);
        hashCodeBuilder.append(this.durationSecs);
        hashCodeBuilder.append(this.deepSleepSecs);
        hashCodeBuilder.append(this.lightSleepSecs);
        hashCodeBuilder.append(this.awakeSecs);
        hashCodeBuilder.append(this.sleepLevelsMap);
        hashCodeBuilder.append(this.validation);

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

        if (!(other instanceof SleepSummary))
        {
            return false;
        }

        final SleepSummary otherSleepSummary = (SleepSummary) other;

        EqualsBuilder equalsBuilder = new EqualsBuilder();
        equalsBuilder.append(this.userAccessToken, otherSleepSummary.userAccessToken);
        equalsBuilder.append(this.wellnessSummaryId, otherSleepSummary.wellnessSummaryId);
        equalsBuilder.append(this.deviceType, otherSleepSummary.deviceType);
        equalsBuilder.append(this.deviceId, otherSleepSummary.deviceId);
        equalsBuilder.append(this.startTime, otherSleepSummary.startTime);
        equalsBuilder.append(this.startTimeOffset, otherSleepSummary.startTimeOffset);
        equalsBuilder.append(this.durationSecs, otherSleepSummary.durationSecs);
        equalsBuilder.append(this.deepSleepSecs, otherSleepSummary.deepSleepSecs);
        equalsBuilder.append(this.lightSleepSecs, otherSleepSummary.lightSleepSecs);
        equalsBuilder.append(this.awakeSecs, otherSleepSummary.awakeSecs);
        equalsBuilder.append(this.sleepLevelsMap, otherSleepSummary.sleepLevelsMap);
        equalsBuilder.append(this.validation, otherSleepSummary.validation);

        return equalsBuilder.isEquals();
    }

}
