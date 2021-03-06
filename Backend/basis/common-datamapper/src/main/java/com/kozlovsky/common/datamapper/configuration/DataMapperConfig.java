package com.kozlovsky.common.datamapper.configuration;

import com.kozlovsky.common.datamapper.DataMapper;
import com.kozlovsky.common.datamapper.JacksonDataMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by anton on 13.06.17.
 */
@Configuration
@ComponentScan(basePackages = "com.kozlovsky.common.datamapper")
public class DataMapperConfig {
    @Bean
    public DataMapper dataMapper() {
        return new JacksonDataMapper();
    }
}
