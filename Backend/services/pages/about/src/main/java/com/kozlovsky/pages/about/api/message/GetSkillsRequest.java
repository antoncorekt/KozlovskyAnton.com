package com.kozlovsky.pages.about.api.message;

import com.kozlovsky.common.protocol.RequestData;
import com.kozlovsky.pages.about.impl.handler.GetSkillsHandler;

import java.util.List;

/**
 * Created by anton on 06.07.17.
 */
public class GetSkillsRequest implements RequestData {

    private String query;

    public GetSkillsRequest(){

    }

    public GetSkillsRequest(String query) {
        this.query = query;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

}
