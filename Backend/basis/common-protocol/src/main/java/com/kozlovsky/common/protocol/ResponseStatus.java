package com.kozlovsky.common.protocol;

import com.kozlovsky.common.protocol.util.Status;

import java.io.Serializable;

/**
 * Created by anton on 13.06.17.
 */
public class ResponseStatus implements Serializable {

    private Integer code;
    private String message;

    public ResponseStatus() {
    }

    public ResponseStatus(Status status, String userMsg) {
        code = status.getCode();
        message = status.getMsg() + " " + userMsg;
    }

    public ResponseStatus(Status status) {
        code = status.getCode();
        message = status.getMsg();
    }

    public ResponseStatus(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
