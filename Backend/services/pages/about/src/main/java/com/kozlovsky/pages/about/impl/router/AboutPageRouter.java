package com.kozlovsky.pages.about.impl.router;

import com.kozlovsky.common.router.api.AbstractRouterHandler;
import com.kozlovsky.common.router.api.CommonRouterHandler;
import com.kozlovsky.common.router.router.RouterFactory;
import com.kozlovsky.pages.about.api.router.AboutPageRequestHandler;
import com.kozlovsky.pages.about.impl.factory.AboutPageRequestFactory;
import org.omg.CORBA.PRIVATE_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by anton on 05.07.17.
 */
@Component
public class AboutPageRouter extends AbstractRouterHandler<AboutPageRequestHandler> implements CommonRouterHandler {

    @Autowired
    private RouterFactory aboutPageRequestFactory;

    @Override
    public String getName() {
        return "about";
    }

    @Override
    protected RouterFactory<AboutPageRequestHandler> getFactoryClass() {
        return aboutPageRequestFactory;
    }
}
