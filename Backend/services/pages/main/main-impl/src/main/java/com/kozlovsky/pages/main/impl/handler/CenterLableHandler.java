package com.kozlovsky.pages.main.impl.handler;

import com.kozlovsky.common.protocol.Request;
import com.kozlovsky.common.protocol.Response;
import com.kozlovsky.common.router.api.AbstractRequestHandler;
import com.kozlovsky.pages.main.api.message.CenterLableRequest;
import com.kozlovsky.pages.main.api.message.CenterLableResponse;
import com.kozlovsky.pages.main.api.router.MainPageRequestHandler;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

/**
 * Created by anton on 13.06.17.
 */
@Component
public class CenterLableHandler extends AbstractRequestHandler<CenterLableRequest,CenterLableResponse> implements MainPageRequestHandler {

    @Override
    public String getName() {
        return null;
    }

    @Override
    public Response<CenterLableResponse> handleWork(Request<CenterLableRequest> msg) {
        return null;
    }
}
