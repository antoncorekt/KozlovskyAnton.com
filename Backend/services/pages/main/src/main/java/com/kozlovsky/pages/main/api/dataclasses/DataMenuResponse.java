package com.kozlovsky.pages.main.api.dataclasses;

import java.io.Serializable;

/**
 * Created by anton on 28.06.17.
 */
public class DataMenuResponse implements Serializable {

    private String nameMenu;
    private String nameMenuInfo;

    public DataMenuResponse(String nameMenu, String nameMenuInfo) {
        this.nameMenu = nameMenu;
        this.nameMenuInfo = nameMenuInfo;
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
