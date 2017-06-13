package com.kozlovsky.pages.main.api.message;

import com.kozlovsky.common.protocol.ResponseData;

/**
 * Created by anton on 13.06.17.
 */
public class CenterLableResponse implements ResponseData {

    private String lable;

    public String getLable() {
        return lable;
    }

    public void setLable(String lable) {
        this.lable = lable;
    }
}
