package com.kozlovsky.common.router.configurations;

import com.kozlovsky.common.datamapper.DataMapper;
import com.kozlovsky.common.datamapper.configuration.DataMapperConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by anton on 13.06.17.
 */
@Configuration
@ComponentScan("com.kozlovsky.common.router")
@Import({DataMapperConfig.class})
public class RouterConfig {
}
