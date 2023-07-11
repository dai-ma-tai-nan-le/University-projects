package com.ljp.demo.utils.Exception;

import lombok.Getter;

//自定义异常
@Getter
public class ServiceException extends RuntimeException {
    private int code;

    public ServiceException(int code,String msg){
        super(msg);
        this.code=code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
