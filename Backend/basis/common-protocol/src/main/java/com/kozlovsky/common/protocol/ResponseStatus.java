package com.kozlovsky.common.protocol;

import javax.persistence.criteria.CriteriaBuilder;
import java.io.Serializable;

/**
 * Created by anton on 13.06.17.
 */
public class ResponseStatus implements Serializable {

    private Integer code;
    private String message;
}