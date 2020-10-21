package com.garmin.gh.apps.wellnessmonitor.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class RequestToken {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private long userId;
	private String userName;
	private String token;
	private String secret;

	public RequestToken() {
		super();
	}

	public RequestToken(String token, String secret) {
		super();

	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getSecret() {
		return secret;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}

}
