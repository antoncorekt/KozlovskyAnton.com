package com.kozlovsky.common.access;

/**
 * Created by anton on 27.06.17.
 */

public enum AccessLevel {

    ALL,
    FRIEND,
    ADMIN;

    public static AccessLevel stringToAccessLevel(String s){
        if ("admin".equals(s) || "ADMIN".equals(s))
            return AccessLevel.ADMIN;

        if ("friend".equals(s) || "FRIEND".equals(s))
            return AccessLevel.FRIEND;

        return AccessLevel.ALL;
    }

}
