package com.garmin.gh.apps.wellnessmonitor.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class SummaryData {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;	
	private String summaryDomain;
	private String model;
	@Column(length=1000000)
	@Lob
	private String dataLob;
	private long timeStamp;
	private String consumerKey;
	private String userAccessToken;

	
	public SummaryData() {
		super();
	}

	public SummaryData(String modelType, String summaryDomain,String summaryData) {
		super();

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}	

	public String getSummaryDomain() {
		return summaryDomain;
	}

	public void setSummaryDomain(String summaryDomain) {
		this.summaryDomain = summaryDomain;
	}

	public String getDataLob() {
		return dataLob;
	}

	public void setDataLob(String dataLob) {
		this.dataLob = dataLob;
	}
	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}
	
	public long getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}
	public String getConsumerKey() {
		return consumerKey;
	}

	public void setConsumerKey(String consumerKey) {
		this.consumerKey = consumerKey;
	}

	public String getUserAccessToken() {
		return userAccessToken;
	}

	public void setUserAccessToken(String userAccessToken) {
		this.userAccessToken = userAccessToken;
	}

	

}
