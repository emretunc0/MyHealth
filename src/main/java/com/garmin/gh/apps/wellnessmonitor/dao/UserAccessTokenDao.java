package com.garmin.gh.apps.wellnessmonitor.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.garmin.gh.apps.wellnessmonitor.dao.h2.UserPartnerDao;
import com.garmin.gh.apps.wellnessmonitor.domain.UserPartner;

@Component
public class UserAccessTokenDao
{

    @Autowired
    UserPartnerDao userPartnerDao;

    // It stores user access token with the user name.
    public void saveAccessToken(String token, String secret, Long userId, String userName)
    {
        UserPartner newUser = new UserPartner();
        newUser.setUserId(userId);
        newUser.setUserName(userName);
        newUser.setUserAccessToken(token);
        newUser.setUserAccessSecret(secret);
        userPartnerDao.save(newUser);

    }

}
