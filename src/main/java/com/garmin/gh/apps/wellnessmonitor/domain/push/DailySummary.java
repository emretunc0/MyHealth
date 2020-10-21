package com.garmin.gh.apps.wellnessmonitor.domain.push;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public final class DailySummary
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
    private Double voltage;
    private Integer moderateIntensityMinutes;
    private Integer vigorousIntensityMinutes;
    private Short floorsClimbed;
    private Short minHeartRate;
    private Short maxHeartRate;
    private Float averageHeartRate;
    private String source;
    private Integer stepsGoal;
    private Integer netCaloriesGoal;
    private Integer intensityMinuteGoal;
    private Integer floorsClimbedGoal;
    private Integer averageStressLevel;
    private Integer maxStressLevel;
    private Integer stressDuration;
    private Integer restStressDuration;
    private Integer activityStressDuration;
    private Integer lowStressDuration;
    private Integer mediumStressDuration;
    private Integer highStressDuration;
	public String getUserAccessToken() {
		return userAccessToken;
	}
	public void setUserAccessToken(String userAccessToken) {
		this.userAccessToken = userAccessToken;
	}
	public String getWellnessSummaryId() {
		return wellnessSummaryId;
	}
	public void setWellnessSummaryId(String wellnessSummaryId) {
		this.wellnessSummaryId = wellnessSummaryId;
	}
	public String getDeviceType() {
		return deviceType;
	}
	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}
	public String getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	public Long getStartTime() {
		return startTime;
	}
	public void setStartTime(Long startTime) {
		this.startTime = startTime;
	}
	public Long getStartTimeOffset() {
		return startTimeOffset;
	}
	public void setStartTimeOffset(Long startTimeOffset) {
		this.startTimeOffset = startTimeOffset;
	}
	public String getActivityType() {
		return activityType;
	}
	public void setActivityType(String activityType) {
		this.activityType = activityType;
	}
	public Long getDurationSecs() {
		return durationSecs;
	}
	public void setDurationSecs(Long durationSecs) {
		this.durationSecs = durationSecs;
	}
	public Long getActiveSecs() {
		return activeSecs;
	}
	public void setActiveSecs(Long activeSecs) {
		this.activeSecs = activeSecs;
	}
	public Long getSteps() {
		return steps;
	}
	public void setSteps(Long steps) {
		this.steps = steps;
	}
	public Double getDistance() {
		return distance;
	}
	public void setDistance(Double distance) {
		this.distance = distance;
	}
	public Double getKcal() {
		return kcal;
	}
	public void setKcal(Double kcal) {
		this.kcal = kcal;
	}
	public Double getVoltage() {
		return voltage;
	}
	public void setVoltage(Double voltage) {
		this.voltage = voltage;
	}
	public Integer getModerateIntensityMinutes() {
		return moderateIntensityMinutes;
	}
	public void setModerateIntensityMinutes(Integer moderateIntensityMinutes) {
		this.moderateIntensityMinutes = moderateIntensityMinutes;
	}
	public Integer getVigorousIntensityMinutes() {
		return vigorousIntensityMinutes;
	}
	public void setVigorousIntensityMinutes(Integer vigorousIntensityMinutes) {
		this.vigorousIntensityMinutes = vigorousIntensityMinutes;
	}
	public Short getFloorsClimbed() {
		return floorsClimbed;
	}
	public void setFloorsClimbed(Short floorsClimbed) {
		this.floorsClimbed = floorsClimbed;
	}
	public Short getMinHeartRate() {
		return minHeartRate;
	}
	public void setMinHeartRate(Short minHeartRate) {
		this.minHeartRate = minHeartRate;
	}
	public Short getMaxHeartRate() {
		return maxHeartRate;
	}
	public void setMaxHeartRate(Short maxHeartRate) {
		this.maxHeartRate = maxHeartRate;
	}
	public Float getAverageHeartRate() {
		return averageHeartRate;
	}
	public void setAverageHeartRate(Float averageHeartRate) {
		this.averageHeartRate = averageHeartRate;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public Integer getStepsGoal() {
		return stepsGoal;
	}
	public void setStepsGoal(Integer stepsGoal) {
		this.stepsGoal = stepsGoal;
	}
	public Integer getNetCaloriesGoal() {
		return netCaloriesGoal;
	}
	public void setNetCaloriesGoal(Integer netCaloriesGoal) {
		this.netCaloriesGoal = netCaloriesGoal;
	}
	public Integer getIntensityMinuteGoal() {
		return intensityMinuteGoal;
	}
	public void setIntensityMinuteGoal(Integer intensityMinuteGoal) {
		this.intensityMinuteGoal = intensityMinuteGoal;
	}
	public Integer getFloorsClimbedGoal() {
		return floorsClimbedGoal;
	}
	public void setFloorsClimbedGoal(Integer floorsClimbedGoal) {
		this.floorsClimbedGoal = floorsClimbedGoal;
	}
	public Integer getAverageStressLevel() {
		return averageStressLevel;
	}
	public void setAverageStressLevel(Integer averageStressLevel) {
		this.averageStressLevel = averageStressLevel;
	}
	public Integer getMaxStressLevel() {
		return maxStressLevel;
	}
	public void setMaxStressLevel(Integer maxStressLevel) {
		this.maxStressLevel = maxStressLevel;
	}
	public Integer getStressDuration() {
		return stressDuration;
	}
	public void setStressDuration(Integer stressDuration) {
		this.stressDuration = stressDuration;
	}
	public Integer getRestStressDuration() {
		return restStressDuration;
	}
	public void setRestStressDuration(Integer restStressDuration) {
		this.restStressDuration = restStressDuration;
	}
	public Integer getActivityStressDuration() {
		return activityStressDuration;
	}
	public void setActivityStressDuration(Integer activityStressDuration) {
		this.activityStressDuration = activityStressDuration;
	}
	public Integer getLowStressDuration() {
		return lowStressDuration;
	}
	public void setLowStressDuration(Integer lowStressDuration) {
		this.lowStressDuration = lowStressDuration;
	}
	public Integer getMediumStressDuration() {
		return mediumStressDuration;
	}
	public void setMediumStressDuration(Integer mediumStressDuration) {
		this.mediumStressDuration = mediumStressDuration;
	}
	public Integer getHighStressDuration() {
		return highStressDuration;
	}
	public void setHighStressDuration(Integer highStressDuration) {
		this.highStressDuration = highStressDuration;
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
	    hashCodeBuilder.append(this.activityType);
	    hashCodeBuilder.append(this.durationSecs);
	    hashCodeBuilder.append(this.activeSecs);
	    hashCodeBuilder.append(this.steps);
	    hashCodeBuilder.append(this.distance);
	    hashCodeBuilder.append(this.kcal);
	    hashCodeBuilder.append(this.voltage);
	    hashCodeBuilder.append(this.moderateIntensityMinutes);
	    hashCodeBuilder.append(this.vigorousIntensityMinutes);
	    hashCodeBuilder.append(this.floorsClimbed);
	    hashCodeBuilder.append(this.minHeartRate);
	    hashCodeBuilder.append(this.maxHeartRate);
	    hashCodeBuilder.append(this.averageHeartRate);
	    hashCodeBuilder.append(this.source);
	    hashCodeBuilder.append(this.stepsGoal);
	    hashCodeBuilder.append(this.netCaloriesGoal);
	    hashCodeBuilder.append(this.intensityMinuteGoal);
	    hashCodeBuilder.append(this.floorsClimbedGoal);
	    hashCodeBuilder.append(this.averageStressLevel);
	    hashCodeBuilder.append(this.maxStressLevel);
	    hashCodeBuilder.append(this.stressDuration);
	    hashCodeBuilder.append(this.restStressDuration);
	    hashCodeBuilder.append(this.activityStressDuration);
	    hashCodeBuilder.append(this.lowStressDuration);
	    hashCodeBuilder.append(this.mediumStressDuration);
	    hashCodeBuilder.append(this.highStressDuration);
	    
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
	    
	    if (!(other instanceof DailySummary))
	    {
	        return false;
	    }
	    
	    final DailySummary otherDailySummary = (DailySummary) other;
	    
	    EqualsBuilder equalsBuilder = new EqualsBuilder();
	    equalsBuilder.append(this.userAccessToken, otherDailySummary.userAccessToken);
	    equalsBuilder.append(this.wellnessSummaryId, otherDailySummary.wellnessSummaryId);
	    equalsBuilder.append(this.deviceType, otherDailySummary.deviceType);
	    equalsBuilder.append(this.deviceId, otherDailySummary.deviceId);
	    equalsBuilder.append(this.startTime, otherDailySummary.startTime);
	    equalsBuilder.append(this.startTimeOffset, otherDailySummary.startTimeOffset);
	    equalsBuilder.append(this.activityType, otherDailySummary.activityType);
	    equalsBuilder.append(this.durationSecs, otherDailySummary.durationSecs);
	    equalsBuilder.append(this.activeSecs, otherDailySummary.activeSecs);
	    equalsBuilder.append(this.steps, otherDailySummary.steps);
	    equalsBuilder.append(this.distance, otherDailySummary.distance);
	    equalsBuilder.append(this.kcal, otherDailySummary.kcal);
	    equalsBuilder.append(this.voltage, otherDailySummary.voltage);
	    equalsBuilder.append(this.moderateIntensityMinutes, otherDailySummary.moderateIntensityMinutes);
	    equalsBuilder.append(this.vigorousIntensityMinutes, otherDailySummary.vigorousIntensityMinutes);
	    equalsBuilder.append(this.floorsClimbed, otherDailySummary.floorsClimbed);
	    equalsBuilder.append(this.minHeartRate, otherDailySummary.minHeartRate);
	    equalsBuilder.append(this.maxHeartRate, otherDailySummary.maxHeartRate);
	    equalsBuilder.append(this.averageHeartRate, otherDailySummary.averageHeartRate);
	    equalsBuilder.append(this.source, otherDailySummary.source);
	    equalsBuilder.append(this.stepsGoal, otherDailySummary.stepsGoal);
	    equalsBuilder.append(this.netCaloriesGoal, otherDailySummary.netCaloriesGoal);
	    equalsBuilder.append(this.intensityMinuteGoal, otherDailySummary.intensityMinuteGoal);
	    equalsBuilder.append(this.floorsClimbedGoal, otherDailySummary.floorsClimbedGoal);
	    equalsBuilder.append(this.averageStressLevel, otherDailySummary.averageStressLevel);
	    equalsBuilder.append(this.maxStressLevel, otherDailySummary.maxStressLevel);
	    equalsBuilder.append(this.stressDuration, otherDailySummary.stressDuration);
	    equalsBuilder.append(this.restStressDuration, otherDailySummary.restStressDuration);
	    equalsBuilder.append(this.activityStressDuration, otherDailySummary.activityStressDuration);
	    equalsBuilder.append(this.lowStressDuration, otherDailySummary.lowStressDuration);
	    equalsBuilder.append(this.mediumStressDuration, otherDailySummary.mediumStressDuration);
	    equalsBuilder.append(this.highStressDuration, otherDailySummary.highStressDuration);
	    
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
