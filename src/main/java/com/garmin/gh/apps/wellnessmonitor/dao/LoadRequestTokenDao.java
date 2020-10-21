package com.garmin.gh.apps.wellnessmonitor.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.garmin.gh.apps.wellnessmonitor.dao.h2.RequestTokenDao;
import com.garmin.gh.apps.wellnessmonitor.domain.RequestToken;

@Component
public class LoadRequestTokenDao
{

    @Autowired
    RequestTokenDao requestTokenDao;

    // It stores request token and secret in the requestToken Repo
    public RequestToken saveRequestToken(Long userId, String userName, String token, String secret)
    {
        RequestToken reqToken = new RequestToken();
        reqToken.setToken(token);
        reqToken.setSecret(secret);
        reqToken.setUserId(userId);
        reqToken.setUserName(userName);
        requestTokenDao.save(reqToken);
        return reqToken;

    }

}
