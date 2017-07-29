package com.kozlovsky.pages.about.impl.handler;

import com.kozlovsky.common.protocol.ActionHeader;
import com.kozlovsky.common.protocol.Request;
import com.kozlovsky.common.protocol.Response;
import com.kozlovsky.common.protocol.util.ResponseFactory;
import com.kozlovsky.common.protocol.util.Status;
import com.kozlovsky.common.resources.Util.Lang;
import com.kozlovsky.common.resources.service.FileReaderService;
import com.kozlovsky.common.router.api.AbstractRequestHandler;
import com.kozlovsky.pages.about.api.message.GetSkillsRequest;
import com.kozlovsky.pages.about.api.message.GetSkillsResponse;
import com.kozlovsky.pages.about.api.router.AboutPageRequestHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * Created by anton on 06.07.17.
 */
@Component
public class GetSkillsHandler extends AbstractRequestHandler<GetSkillsRequest, GetSkillsResponse> implements AboutPageRequestHandler {

    private final static String COMMAND = "get_cv_skills";

    @Autowired
    private FileReaderService fileReaderService;

    public List<String> createAvaibleSkills() throws Exception{
        String avSkilStr = fileReaderService.getValue("about", Lang.ENG,"available-skills");

        return Arrays.asList(avSkilStr.split(" "));
    }

    public Map<String,String> createMapFromMask(String mask, Lang lang) throws Exception{
        Map<String, String> res = new HashMap<>();

        List<String> clientSkills = new ArrayList<>();
        if("*".equals(mask)){
            clientSkills = createAvaibleSkills();
        }
        else {
            for(String s: mask.split(" ")){
                List<String> availableSkills = createAvaibleSkills();
                if (availableSkills.contains(s)){
                    clientSkills.add(s);
                }
            }
        }

        for(String skill: clientSkills){
            res.put(skill, fileReaderService.getValue("about", lang, "cv-"+skill));
        }

        return res;
    }

    @Override
    public String getName() {
        return COMMAND;
    }

    @Override
    public Response<GetSkillsResponse> handleWork(Request<GetSkillsRequest> msg) {
        try{
            ActionHeader header = new ActionHeader(msg.getHeader().getUuid(),
                    msg.getHeader().getLanguage(),
                    "about",
                    COMMAND);

            GetSkillsResponse response = new GetSkillsResponse();
            response.setSkills(createMapFromMask(msg.getData().getQuery(),Lang.fromString(msg.getHeader().getLanguage())));

            return (Response<GetSkillsResponse>) ResponseFactory.createResponse(header, response, Status.OK);
        }catch (Exception e){
            return (Response<GetSkillsResponse>) ResponseFactory.createResponse(Status.INTERNAL_SERVER_ERROR, e.getMessage());
        }

    }
}
