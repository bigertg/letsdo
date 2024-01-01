package com.fubaorobot.letsdo.framework.exception;

/**
 * @author：tanghengqi
 * @date：2021-06-08 13:55
 * @description：<描述>
 */
public class BaseException extends RuntimeException{

    private Integer status;

    private String message;

    public BaseException() {
    }

    public BaseException(String message) {
        this.status = 500;
        this.message = message;
    }

    public BaseException(Integer status, String message) {
        this.status = status;
        this.message = message;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
