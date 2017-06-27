package com.kozlovsky.common.access;

import org.springframework.stereotype.Component;

/**
 * Created by anton on 27.06.17.
 */

@Component
public class AccessServise {

    private final static String ADMIN_ACCESS_LOGIN = "admin";
    private final static String USER_ACCESS_LOGIN = "user";


    public AccessLevel getAccessLevel(String uuid){

        if(uuid.equals(ADMIN_ACCESS_LOGIN)){
            return AccessLevel.ADMIN;
        }

        if(uuid.equals(USER_ACCESS_LOGIN)){
            return AccessLevel.FRIEND;
        }


        return AccessLevel.ALL;
    }

}
