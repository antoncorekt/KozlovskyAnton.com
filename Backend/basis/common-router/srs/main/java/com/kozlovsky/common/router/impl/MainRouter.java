package com.kozlovsky.common.router.impl;

import com.kozlovsky.common.protocol.Request;
import com.kozlovsky.common.protocol.Response;
import com.kozlovsky.common.router.api.AbsctractRouterHandler;
import com.kozlovsky.common.router.api.CommonRouterHandler;
import org.springframework.stereotype.Component;

/**
 * Created by anton on 13.06.17.
 */
@Component
public class MainRouter extends AbsctractRouterHandler<CommonRouterHandler> {
    @Override
    public String getName() {
        return null;
    }

    @Override
    public Response<?> handle(Request<?> msg) {
        return null;
    }
}
