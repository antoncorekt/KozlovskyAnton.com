package com.kozlovsky.common.resources;

import org.springframework.stereotype.Component;

/**
 * Created by anton on 09.06.17.
 */


@Component
public class ResourcesService {

    ClassLoader classLoader = getClass().getClassLoader();

    public String getService(){
        return classLoader.getResource("pages/en/main.xml").;
    }

}
