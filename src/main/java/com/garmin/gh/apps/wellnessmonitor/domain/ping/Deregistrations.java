package com.garmin.gh.apps.wellnessmonitor.domain.ping;

import java.util.List;

public final class Deregistrations
{

    private List<PingNotificationForDereg> deregistrations;

    public List<PingNotificationForDereg> getDeregistrations()
    {
        return deregistrations;
    }

    public void setDeregistrations(List<PingNotificationForDereg> deregistrations)
    {
        this.deregistrations = deregistrations;
    }

}
