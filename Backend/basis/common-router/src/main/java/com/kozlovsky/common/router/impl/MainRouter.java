package com.kozlovsky.common.router.impl;

import com.kozlovsky.common.router.api.AbstractRouterHandler;
import com.kozlovsky.common.router.api.CommonRouterHandler;
import com.kozlovsky.common.router.router.RouterFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by anton on 13.06.17.
 */
@Component
public class MainRouter extends AbstractRouterHandler<CommonRouterHandler> {
    @Autowired
    private RouterFactory mainHandlerFactory;

    @Override
    public String getName() {
        return "mainRouter";
    }


    @Override
    protected RouterFactory<CommonRouterHandler> getFactoryClass() {
        return mainHandlerFactory;
    }
}
