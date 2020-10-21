package com.garmin.gh.apps.wellnessmonitor.dao.h2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.garmin.gh.apps.wellnessmonitor.domain.UserPartner;

public interface UserPartnerDao extends JpaRepository<UserPartner, Long> {
	@Query("select u from UserPartner u  where u.userAccessToken =?1")
	UserPartner findByToken(String accessToken);
	
	@Query("select u.userAccessSecret from UserPartner u  where u.userAccessToken =?1")
	String getUserAccessSecret(String accessToken);
	
}
