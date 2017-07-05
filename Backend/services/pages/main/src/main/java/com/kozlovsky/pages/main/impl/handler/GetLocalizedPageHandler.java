package com.kozlovsky.pages.main.impl.handler;

import com.kozlovsky.common.protocol.ActionHeader;
import com.kozlovsky.common.protocol.Request;
import com.kozlovsky.common.protocol.Response;
import com.kozlovsky.common.protocol.util.ResponseFactory;
import com.kozlovsky.common.protocol.util.Status;
import com.kozlovsky.common.resources.Util.Lang;
import com.kozlovsky.common.resources.service.FileReaderService;
import com.kozlovsky.common.router.api.AbstractRequestHandler;
import com.kozlovsky.pages.main.api.message.CenterLableResponse;
import com.kozlovsky.pages.main.api.message.GetLocalizedPageRequest;
import com.kozlovsky.pages.main.api.message.GetLocalizedPageResponse;
import com.kozlovsky.pages.main.api.router.MainPageRequestHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anton on 05.07.17.
 */
@Component
public class GetLocalizedPageHandler extends AbstractRequestHandler<GetLocalizedPageRequest, GetLocalizedPageResponse> implements MainPageRequestHandler {

    private static final String COMMAND = "get_localized_pages";

    @Autowired
    private FileReaderService fileReaderService;

    @Override
    public String getName() {
        return "get_localized_pages";
    }

    @Override
    public Response<GetLocalizedPageResponse> handleWork(Request<GetLocalizedPageRequest> msg) {
        try{
            ActionHeader header = new ActionHeader(msg.getHeader().getUuid(),
                    msg.getHeader().getLanguage(),
                    "main",
                    COMMAND);

            List<String> pages = msg.getData().getPage();
            List<String> localPages = new ArrayList<>();

            String s, tempLocalPage;
            for(String page: pages){
                s = (page.charAt(0)=='/')?page.substring(1):page; // if page has format like "/about"

                tempLocalPage = fileReaderService.getValue(msg.getHeader().getPage(),
                        Lang.fromString(msg.getHeader().getLanguage()),
                        "menu"+"-"+s+"-small");

                if(tempLocalPage.equals(FileReaderService.NOT_TRANSLATE)){
                    localPages.add(s);
                }
                else {
                    localPages.add(tempLocalPage);
                }
            }

            GetLocalizedPageResponse respone = new GetLocalizedPageResponse(localPages);


            return (Response<GetLocalizedPageResponse>) ResponseFactory.createResponse(header,respone, Status.OK);
        }
        catch (Exception e){
            return (Response<GetLocalizedPageResponse>) ResponseFactory.createResponse(Status.INTERNAL_SERVER_ERROR, e.getMessage());
        }

    }
}
