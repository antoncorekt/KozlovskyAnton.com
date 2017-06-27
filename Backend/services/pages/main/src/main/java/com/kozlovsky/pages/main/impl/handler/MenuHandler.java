package com.kozlovsky.pages.main.impl.handler;

import com.kozlovsky.common.protocol.Request;
import com.kozlovsky.common.protocol.Response;
import com.kozlovsky.common.router.api.AbstractRequestHandler;
import com.kozlovsky.pages.main.api.message.MenuRequest;
import com.kozlovsky.pages.main.api.message.MenuResponse;
import com.kozlovsky.pages.main.api.router.MainPageRequestHandler;
import org.springframework.stereotype.Component;

/**
 * Created by anton on 13.06.17.
 */
@Component
public class MenuHandler extends AbstractRequestHandler<MenuRequest, MenuResponse> implements MainPageRequestHandler {

    private static final String COMMAND = "menu";

    @Override
    public String getName() {
        return COMMAND;
    }

    @Override
    public Response<MenuResponse> handleWork(Request<MenuRequest> msg) {

        return null;
    }
}
