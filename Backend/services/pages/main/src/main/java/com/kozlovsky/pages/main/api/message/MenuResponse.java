package com.kozlovsky.pages.main.api.message;

import com.kozlovsky.common.protocol.ResponseData;
import com.kozlovsky.pages.main.api.dataclasses.DataMenuResponse;

import java.util.List;

/**
 * Created by anton on 13.06.17.
 */
public class MenuResponse implements ResponseData {

    private List<DataMenuResponse> data;

    public List<DataMenuResponse> getData() {
        return data;
    }

    public void setData(List<DataMenuResponse> data) {
        this.data = data;
    }
}
