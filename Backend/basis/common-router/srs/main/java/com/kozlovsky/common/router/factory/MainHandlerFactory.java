package com.kozlovsky.common.router.factory;

import com.kozlovsky.common.protocol.Request;
import com.kozlovsky.common.router.api.CommonRouterHandler;
import org.springframework.stereotype.Component;

/**
 * Created by anton on 13.06.17.
 */
@Component
public class MainHandlerFactory extends AbstractRouterFactory<CommonRouterHandler> {
    @Override
    public String getKey(Request<?> msg) {
        return msg.getHeader().getPage();
    }
}
