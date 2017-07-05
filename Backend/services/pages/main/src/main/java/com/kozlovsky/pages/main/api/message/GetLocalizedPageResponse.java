package com.kozlovsky.pages.main.api.message;

import com.kozlovsky.common.protocol.ResponseData;

import java.util.List;

/**
 * Created by anton on 05.07.17.
 */
public class GetLocalizedPageResponse implements ResponseData {

    private List<String> locPages;

    public GetLocalizedPageResponse(List<String> locPages) {
        this.locPages = locPages;
    }

    public List<String> getLocPages() {
        return locPages;
    }

    public void setLocPages(List<String> locPages) {
        this.locPages = locPages;
    }
}
