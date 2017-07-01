package com.kozlovsky.pages.main.impl.handler;

import com.kozlovsky.common.access.AccessLevel;
import com.kozlovsky.common.access.AccessServise;
import com.kozlovsky.common.protocol.ActionHeader;
import com.kozlovsky.common.protocol.Request;
import com.kozlovsky.common.protocol.Response;
import com.kozlovsky.common.protocol.util.ResponseFactory;
import com.kozlovsky.common.protocol.util.Status;
import com.kozlovsky.common.resources.Util.Lang;
import com.kozlovsky.common.resources.service.FileReaderService;
import com.kozlovsky.common.router.api.AbstractRequestHandler;
import com.kozlovsky.pages.main.api.dataclasses.DataMenuResponse;
import com.kozlovsky.pages.main.api.message.MenuRequest;
import com.kozlovsky.pages.main.api.message.MenuResponse;
import com.kozlovsky.pages.main.api.router.MainPageRequestHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anton on 13.06.17.
 */
@Component
public class MenuHandler extends AbstractRequestHandler<MenuRequest, MenuResponse> implements MainPageRequestHandler {

    private static final String COMMAND = "menu";

    @Autowired
    private AccessServise accessServise;

    @Autowired
    private FileReaderService fileReaderService;

    @Override
    public String getName() {
        return COMMAND;
    }

    @Override
    public Response<MenuResponse> handleWork(Request<MenuRequest> msg) {
        try {
            ActionHeader header = new ActionHeader(msg.getHeader().getUuid(),
                    msg.getHeader().getLanguage(),
                    "main",
                    COMMAND);

            String accessID = msg.getHeader().getUuid();
            Lang lang = Lang.fromString(msg.getHeader().getLanguage());

            MenuResponse menuResponse = new MenuResponse();

            List<DataMenuResponse> nameList = new ArrayList<>();
            nameList.add(new DataMenuResponse(
                    fileReaderService.getValue("main",lang,"menu-blog"),
                    fileReaderService.getValue("main",lang,"menu-blog-info"),
                    "blog",
                    fileReaderService.getValue("main",lang,"menu-blog-small"))
            );
            nameList.add(new DataMenuResponse(
                    fileReaderService.getValue("main",lang,"menu-portfolio"),
                    fileReaderService.getValue("main",lang,"menu-portfolio-info"),
                    "portfolio",
                    fileReaderService.getValue("main",lang,"menu-portfolio-small"))
            );
            nameList.add(new DataMenuResponse(
                    fileReaderService.getValue("main",lang,"menu-cv"),
                    fileReaderService.getValue("main",lang,"menu-cv-info"),
                    "cv",
                    fileReaderService.getValue("main",lang,"menu-cv-small"))
            );
            nameList.add(new DataMenuResponse(
                    fileReaderService.getValue("main",lang,"menu-about"),
                    fileReaderService.getValue("main",lang,"menu-about-info"),
                    "about",
                    fileReaderService.getValue("main",lang,"menu-about-small"))
            );


            if(accessServise.getAccessLevel(accessID) == AccessLevel.ADMIN){
                nameList.add(new DataMenuResponse(
                        fileReaderService.getValue("main",lang,"menu-admin"),
                        fileReaderService.getValue("main",lang,"menu-admin-info"),
                        "admin",
                        fileReaderService.getValue("main",lang,"menu-admin-small"))
                );
            }

            menuResponse.setData(nameList);

            return (Response<MenuResponse>) ResponseFactory.createResponse(header,menuResponse, Status.OK);

        }catch (Exception e){
            System.out.println("MenuHandler error " + e.getMessage());
            return (Response<MenuResponse>) ResponseFactory.createResponse(Status.INTERNAL_SERVER_ERROR,e.getMessage());
        }

    }
}
