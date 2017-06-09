package com.kozlovsky.frontend.rest;

import com.kozlovsky.common.resources.Config;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

/**
 * Created by anton on 29.05.17.
 */

@SpringBootApplication
//@CrossOrigin(origins = "http://localhost:4200")
@EnableAutoConfiguration
@Import(value = {Config.class})
public class MainApp {

    public static void main(String[] args) {
        SpringApplication.run(MainApp.class, args);
    }


}
