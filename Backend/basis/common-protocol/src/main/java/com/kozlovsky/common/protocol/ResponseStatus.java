package com.kozlovsky.common.protocol;

import javax.persistence.criteria.CriteriaBuilder;
import java.io.Serializable;

/**
 * Created by anton on 13.06.17.
 */
public class ResponseStatus implements Serializable {

    private Integer code;
    private String message;

    public ResponseStatus() {
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
