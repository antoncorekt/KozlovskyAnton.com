package com.kozlovsky.pages.about.impl.handler;

import com.kozlovsky.common.protocol.ActionHeader;
import com.kozlovsky.common.protocol.Request;
import com.kozlovsky.common.protocol.Response;
import com.kozlovsky.common.resources.Util.Lang;
import com.kozlovsky.common.resources.service.FileReaderService;
import com.kozlovsky.pages.about.api.message.GetSkillsRequest;
import com.kozlovsky.pages.about.api.message.GetSkillsResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by anton on 06.07.17.
 */
//@RunWith(MockitoJUnitRunner.class)
public class GetSkillsHandlerTest {

   /* @InjectMocks
    private GetSkillsHandler getSkillsHandler;

    @Spy
    private FileReaderService fileReaderService;

    @Test
    public void createAvaibleSkills() throws Exception {

        System.out.println(Arrays.toString(getSkillsHandler.createAvaibleSkills().toArray()));
    }

    @Test
    public void createMapFromMask() throws Exception {
        Map<String, String> res = getSkillsHandler.createMapFromMask("Java", Lang.ENG);

        for (String s: res.values()){
            System.out.println(s);
        }
    }*/
/*
    @Test
    public void getName() throws Exception {
        assertThat(getSkillsHandler.getName(), is("get_cv_skills"));
    }

    @Test
    public void handleWork() throws Exception {
        Request<GetSkillsRequest> request = new Request<>();
        ActionHeader header = new ActionHeader("uuid","en","about","get_cv_skills");

        request.setData(new GetSkillsRequest("Java"));
        request.setHeader(header);

        Response<GetSkillsResponse> response = getSkillsHandler.handleWork(request);

        System.out.println(response.getData().getSkills().get("Java"));

    }*/

}