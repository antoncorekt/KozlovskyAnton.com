package com.kozlovsky.pages.about;

import com.kozlovsky.common.protocol.ActionHeader;
import com.kozlovsky.common.resources.ConfigResources;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;


/**
 * Created by anton on 17.06.17.
 */
@Component
@ComponentScan("com.kozlovsky.pages.main.impl")
@Import({ConfigResources.class})
public class Test {


    private ActionHeader handler;
}
