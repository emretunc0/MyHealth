package com.garmin.gh.apps.wellnessmonitor;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import com.garmin.gh.apps.wellnessmonitor.domain.UserPartner;


@Component
@ConfigurationProperties(prefix="partner")
public class StaticUserPartnerSource implements UserPartnerSource
{
    private List<UserPartner> users;

    
    @Override
    public List<UserPartner> getUsers()
    {
        return users;
    }

    public void setUsers(List<UserPartner> users)
    {
        this.users = users;
    }

}