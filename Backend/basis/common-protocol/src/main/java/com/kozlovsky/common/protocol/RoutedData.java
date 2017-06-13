package com.kozlovsky.common.protocol;

/**
 * Created by anton on 13.06.17.
 */
public class RoutedData {

    private String userID;

    public RoutedData() {
    }

    public RoutedData(String userID) {
        this.userID = userID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }
}
