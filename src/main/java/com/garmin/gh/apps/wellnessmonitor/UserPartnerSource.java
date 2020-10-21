package com.garmin.gh.apps.wellnessmonitor;

import java.util.List;

import com.garmin.gh.apps.wellnessmonitor.domain.UserPartner;

public interface UserPartnerSource
{

    List<UserPartner> getUsers();

}