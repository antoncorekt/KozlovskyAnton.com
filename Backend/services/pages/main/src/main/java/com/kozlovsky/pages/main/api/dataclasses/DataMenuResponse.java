package com.kozlovsky.pages.main.api.dataclasses;

import java.io.Serializable;

/**
 * Created by anton on 28.06.17.
 */
public class DataMenuResponse implements Serializable {

    private String nameMenu;
    private String nameMenuInfo;
    private String id;
    private String smallName;

    public DataMenuResponse(String nameMenu, String nameMenuInfo, String id, String smallName) {
        this.nameMenu = nameMenu;
        this.nameMenuInfo = nameMenuInfo;
        this.id = id;
        this.smallName = smallName;
    }

    public String getSmallName() {
        return smallName;
    }

    public void setSmallName(String smallName) {
        this.smallName = smallName;
    }

    public String getId() {

        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNameMenu() {
        return nameMenu;
    }

    public void setNameMenu(String nameMenu) {
        this.nameMenu = nameMenu;
    }

    public String getNameMenuInfo() {
        return nameMenuInfo;
    }

    public void setNameMenuInfo(String nameMenuInfo) {
        this.nameMenuInfo = nameMenuInfo;
    }
}
