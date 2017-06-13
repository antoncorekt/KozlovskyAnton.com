package com.kozlovsky.common.router.api;

import com.kozlovsky.common.exceptions.MapperException;
import com.kozlovsky.common.protocol.Request;
import com.kozlovsky.common.protocol.Response;
import com.kozlovsky.common.router.router.RouterFactory;
import com.kozlovsky.common.router.router.RouterHandler;

/**
 * Created by anton on 13.06.17.
 */
public abstract class AbstractRouterHandler<T extends Handler> implements RouterHandler {

    @Override
    public Response<?> handle(Request<?> msg) throws MapperException {
        return getFactoryClass().getHandler(msg).handle(msg);
    }

    protected abstract RouterFactory<T> getFactoryClass();

}
