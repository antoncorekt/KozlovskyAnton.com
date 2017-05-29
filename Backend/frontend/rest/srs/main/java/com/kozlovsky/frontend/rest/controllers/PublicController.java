package com.kozlovsky.frontend.rest.controllers;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Method;

/**
 * Created by anton on 29.05.17.
 */

@RestController
@CrossOrigin
//@EnableAutoConfiguration
@RequestMapping(value = "/api")
public class PublicController {


    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, path = "/test")
    public String test(){
        return "Hello word!";
    }

    //@ResponseBody
    @RequestMapping(value = "/id", method = RequestMethod.GET)
    public String getPerson() {

        return "Lol";
    }


}
