package com.kozlovsky.pages.main.impl.router;

import com.kozlovsky.common.router.api.AbstractRouterHandler;
import com.kozlovsky.common.router.api.CommonRouterHandler;
import com.kozlovsky.common.router.router.RouterFactory;
import com.kozlovsky.pages.main.api.router.MainPageRequestHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by anton on 13.06.17.
 */
@Component
public class MainPageRouter extends AbstractRouterHandler<MainPageRequestHandler> implements CommonRouterHandler {

    @Autowired
    private RouterFactory mainPageRequestHandlerFactory;

    @Override
    protected RouterFactory<MainPageRequestHandler> getFactoryClass()
    {
        return mainPageRequestHandlerFactory;
    }

    @Override
    public String getName() {
        return "main";
    }

}
