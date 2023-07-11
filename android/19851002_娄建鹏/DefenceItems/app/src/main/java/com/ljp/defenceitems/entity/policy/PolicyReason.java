package com.ljp.defenceitems.entity.policy;

public class PolicyReason {
    private String reason;
    private PolicyInfo result;
    private int error_code;

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public PolicyInfo getResult() {
        return result;
    }

    public void setResult(PolicyInfo result) {
        this.result = result;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }
}
