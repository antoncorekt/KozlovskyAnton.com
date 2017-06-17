package com.kozlovsky.common.protocol.util;

/**
 * Created by anton on 17.06.17.
 */
public class ActionHeaderBuilder {

    private String uuid;
    private String language;
    private String page;
    private String command;

    public ActionHeaderBuilder withUuid(String uuid){
        this.uuid = uuid;
        return this;
    }

    public ActionHeaderBuilder withLanguage(String language){
        this.language = language;
        return this;
    }

    public ActionHeaderBuilder withPage(String page){
        this.page = page;
        return this;
    }

    public ActionHeaderBuilder withCommand(String command){
        this.command = command;
        return this;
    }

    public String getUuid() {
        return uuid;
    }

    public String getLanguage() {
        return language;
    }

    public String getPage() {
        return page;
    }

    public String getCommand() {
        return command;
    }
}
