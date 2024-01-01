package com.fubaorobot.letsdo.framework.exception;

/**
 * @author：tanghengqi
 * @date：2021-06-08 13:55
 * @description：<描述>
 */
public class BizFailException extends Exception{

    private Integer status;

    private String message;

    public BizFailException() {
    }

    public BizFailException(Integer status, String message) {
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
