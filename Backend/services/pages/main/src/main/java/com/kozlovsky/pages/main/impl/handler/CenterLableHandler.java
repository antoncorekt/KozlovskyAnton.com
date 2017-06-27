package com.kozlovsky.pages.main.impl.handler;

import com.kozlovsky.common.protocol.ActionHeader;
import com.kozlovsky.common.protocol.Request;
import com.kozlovsky.common.protocol.Response;
import com.kozlovsky.common.protocol.util.ResponseFactory;
import com.kozlovsky.common.protocol.util.Status;
import com.kozlovsky.common.resources.Util.Lang;
import com.kozlovsky.common.resources.service.FileReaderService;
import com.kozlovsky.common.router.api.AbstractRequestHandler;
import com.kozlovsky.pages.main.api.message.CenterLableRequest;
import com.kozlovsky.pages.main.api.message.CenterLableResponse;
import com.kozlovsky.pages.main.api.router.MainPageRequestHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by anton on 13.06.17.
 */
@Component
public class CenterLableHandler extends AbstractRequestHandler<CenterLableRequest,CenterLableResponse> implements MainPageRequestHandler {

    private static final String COMMAND = "center";

    @Autowired
    private FileReaderService fileReaderService;

    @Override
    public String getName() {

        return COMMAND;
    }

    @Override
    public Response<CenterLableResponse> handleWork(Request<CenterLableRequest> msg) {

        try {
            ActionHeader header = new ActionHeader(msg.getHeader().getUuid(),
                    msg.getHeader().getLanguage(),
                    "main",
                    COMMAND);

            CenterLableResponse response = new CenterLableResponse();
            response.setLable(fileReaderService.getValue("main",
                    Lang.fromString(msg.getHeader().getLanguage()), "center"));

            return (Response<CenterLableResponse>) ResponseFactory.createResponse(header,response, Status.OK);

        }catch (Exception e){
            return (Response<CenterLableResponse>) ResponseFactory.createResponse(Status.INTERNAL_SERVER_ERROR, e.getMessage());
        }

    }
}
