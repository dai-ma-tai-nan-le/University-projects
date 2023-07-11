package com.ljp.defenceitems.entity.policy;

import java.util.List;

public class Citys {
    private String reason;
    private List<Province> result;
    private int error_code;

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public List<Province> getResult() {
        return result;
    }

    public void setResult(List<Province> result) {
        this.result = result;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }
}
