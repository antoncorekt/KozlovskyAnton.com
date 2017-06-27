package com.kozlovsky.pages.main.impl.configuration;

import com.kozlovsky.common.access.ConfigAccess;
import com.kozlovsky.common.resources.ConfigResources;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;

/**
 * Created by anton on 13.06.17.
 */
@Configuration
@ComponentScan("com.kozlovsky.pages.main.impl")
@Import(value = {ConfigResources.class, ConfigAccess.class})
public class MainPageConfig {
}
