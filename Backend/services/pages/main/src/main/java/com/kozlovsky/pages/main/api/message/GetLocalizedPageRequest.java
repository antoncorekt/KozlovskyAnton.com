package com.kozlovsky.pages.main.api.message;

import com.kozlovsky.common.protocol.RequestData;

import java.util.List;

/**
 * Created by anton on 05.07.17.
 */
public class GetLocalizedPageRequest implements RequestData {

    private List<String> page;

    public GetLocalizedPageRequest(List<String> page) {
        this.page = page;
    }

    public List<String> getPage() {
        return page;
    }

    public void setPage(List<String> page) {
        this.page = page;
    }
}
