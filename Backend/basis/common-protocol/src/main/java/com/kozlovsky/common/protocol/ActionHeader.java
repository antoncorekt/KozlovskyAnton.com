package com.kozlovsky.common.protocol;

import java.io.Serializable;

/**
 * Created by anton on 13.06.17.
 */
public class ActionHeader implements Serializable {

    private String uuid;
    private String language;
    private String page;
    private String command;

    public ActionHeader(String uuid) {
        this.uuid = uuid;
    }

    public ActionHeader(String uuid, String language, String page, String command) {
        this.uuid = uuid;
        this.language = language;
        this.page = page;
        this.command = command;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }
}
