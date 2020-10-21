package com.garmin.gh.apps.wellnessmonitor.dao.h2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.garmin.gh.apps.wellnessmonitor.domain.RequestToken;

public interface RequestTokenDao extends JpaRepository<RequestToken, Long> {
	@Query("select r from RequestToken r where r.token =?1")
	RequestToken findByToken(String requestToken);

}
