package com.ljp.defenceitems.entity.Weather;

public class WeatherDetail {
    private String temperature;
    private String humidity;
    private String info;
    private String wid;
    private String direct;
    private String power;
    private String aqi;

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getWid() {
        return wid;
    }

    public void setWid(String wid) {
        this.wid = wid;
    }

    public String getDirect() {
        return direct;
    }

    public void setDirect(String direct) {
        this.direct = direct;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public String getAqi() {
        return aqi;
    }

    public void setAqi(String aqi) {
        this.aqi = aqi;
    }

    @Override
    public String toString() {
        return "温度：" + temperature + '\n' +
                " 湿度：" + humidity + '\n' +
                " 天气情况：" + info + '\n' +
                " 天气标识：" + wid + '\n' +
                " 风向：" + direct + '\n' +
                " 风力：" + power + '\n' +
                " 空气质量指数：" + aqi;
    }
}
