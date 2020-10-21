package com.garmin.gh.apps.wellnessmonitor.domain.push;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public final class BodyCompositionSummary
{
    private String userAccessToken;
    private String wellnessSummaryId;
    private Integer muscleMassInGrams;
    private Integer boneMassInGrams;
    private Float bodyWaterInPercent;
    private Float bodyFatInPercent;
    private Float bmi;
    private Integer weightInGrams;
    private Long measurementTime;
    private Long measurementTimeOffset;

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

    public Integer getMuscleMassInGrams()
    {
        return muscleMassInGrams;
    }

    public void setMuscleMassInGrams(Integer muscleMassInGrams)
    {
        this.muscleMassInGrams = muscleMassInGrams;
    }

    public Integer getBoneMassInGrams()
    {
        return boneMassInGrams;
    }

    public void setBoneMassInGrams(Integer boneMassInGrams)
    {
        this.boneMassInGrams = boneMassInGrams;
    }

    public Float getBodyWaterInPercent()
    {
        return bodyWaterInPercent;
    }

    public void setBodyWaterInPercent(Float bodyWaterInPercent)
    {
        this.bodyWaterInPercent = bodyWaterInPercent;
    }

    public Float getBodyFatInPercent()
    {
        return bodyFatInPercent;
    }

    public void setBodyFatInPercent(Float bodyFatInPercent)
    {
        this.bodyFatInPercent = bodyFatInPercent;
    }

    public Float getBmi()
    {
        return bmi;
    }

    public void setBmi(Float bmi)
    {
        this.bmi = bmi;
    }

    public Integer getWeightInGrams()
    {
        return weightInGrams;
    }

    public void setWeightInGrams(Integer weightInGrams)
    {
        this.weightInGrams = weightInGrams;
    }

    public Long getMeasurementTime()
    {
        return measurementTime;
    }

    public void setMeasurementTime(Long measurementTime)
    {
        this.measurementTime = measurementTime;
    }

    public Long getMeasurementTimeOffset()
    {
        return measurementTimeOffset;
    }

    public void setMeasurementTimeOffset(Long measurementTimeOffset)
    {
        this.measurementTimeOffset = measurementTimeOffset;
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
        hashCodeBuilder.append(this.muscleMassInGrams);
        hashCodeBuilder.append(this.boneMassInGrams);
        hashCodeBuilder.append(this.bodyWaterInPercent);
        hashCodeBuilder.append(this.bodyFatInPercent);
        hashCodeBuilder.append(this.bmi);
        hashCodeBuilder.append(this.weightInGrams);
        hashCodeBuilder.append(this.measurementTime);
        hashCodeBuilder.append(this.measurementTimeOffset);

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

        if (!(other instanceof BodyCompositionSummary))
        {
            return false;
        }

        final BodyCompositionSummary otherBodyCompositionSummary = (BodyCompositionSummary) other;

        EqualsBuilder equalsBuilder = new EqualsBuilder();
        equalsBuilder.append(this.userAccessToken, otherBodyCompositionSummary.userAccessToken);
        equalsBuilder.append(this.wellnessSummaryId, otherBodyCompositionSummary.wellnessSummaryId);
        equalsBuilder.append(this.muscleMassInGrams, otherBodyCompositionSummary.muscleMassInGrams);
        equalsBuilder.append(this.boneMassInGrams, otherBodyCompositionSummary.boneMassInGrams);
        equalsBuilder.append(this.bodyWaterInPercent, otherBodyCompositionSummary.bodyWaterInPercent);
        equalsBuilder.append(this.bodyFatInPercent, otherBodyCompositionSummary.bodyFatInPercent);
        equalsBuilder.append(this.bmi, otherBodyCompositionSummary.bmi);
        equalsBuilder.append(this.weightInGrams, otherBodyCompositionSummary.weightInGrams);
        equalsBuilder.append(this.measurementTime, otherBodyCompositionSummary.measurementTime);
        equalsBuilder.append(this.measurementTimeOffset, otherBodyCompositionSummary.measurementTimeOffset);

        return equalsBuilder.isEquals();
    }

}
