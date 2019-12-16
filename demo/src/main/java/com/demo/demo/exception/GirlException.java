package com.demo.demo.exception;

public class GirlException extends RuntimeException {
    private Integer code;

    public void setCode(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public GirlException(Integer code, String message){
        super(message);
        this.code = code;
    }
}
