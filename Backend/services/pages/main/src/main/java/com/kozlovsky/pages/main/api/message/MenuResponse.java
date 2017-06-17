package com.kozlovsky.pages.main.api.message;

import com.kozlovsky.common.protocol.ResponseData;

import java.util.List;

/**
 * Created by anton on 13.06.17.
 */
public class MenuResponse implements ResponseData {

    private List<String> menuName;
    private List<String> menuComment;

    public List<String> getMenuName() {
        return menuName;
    }

    public void setMenuName(List<String> menuName) {
        this.menuName = menuName;
    }

    public List<String> getMenuComment() {
        return menuComment;
    }

    public void setMenuComment(List<String> menuComment) {
        this.menuComment = menuComment;
    }
}
