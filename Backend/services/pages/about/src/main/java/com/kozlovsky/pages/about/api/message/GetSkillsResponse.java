package com.kozlovsky.pages.about.api.message;

import com.kozlovsky.common.protocol.ResponseData;

import java.util.List;
import java.util.Map;

/**
 * Created by anton on 06.07.17.
 */
public class GetSkillsResponse implements ResponseData {

    private Map<String, String> skills;

    public Map<String, String> getSkills() {
        return skills;
    }

    public void setSkills(Map<String, String> skills) {
        this.skills = skills;
    }
}
