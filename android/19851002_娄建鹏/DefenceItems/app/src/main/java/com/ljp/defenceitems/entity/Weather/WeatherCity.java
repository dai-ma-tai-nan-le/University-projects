package com.ljp.defenceitems.entity.Weather;

public class WeatherCity {
    private String city;
    private WeatherDetail realtime;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public WeatherDetail getRealtime() {
        return realtime;
    }

    public void setRealtime(WeatherDetail realtime) {
        this.realtime = realtime;
    }
}
