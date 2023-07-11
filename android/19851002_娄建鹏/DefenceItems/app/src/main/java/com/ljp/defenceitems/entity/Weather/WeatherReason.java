package com.ljp.defenceitems.entity.Weather;

import java.util.List;

public class WeatherReason {
    private String reason;
    private WeatherCity result;
    private int error_code;

    public WeatherCity getResult() {
        return result;
    }

    public void setResult(WeatherCity result) {
        this.result = result;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }



    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }
}
