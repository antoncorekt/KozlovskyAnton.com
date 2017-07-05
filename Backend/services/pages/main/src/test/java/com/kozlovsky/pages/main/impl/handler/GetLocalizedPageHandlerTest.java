package com.kozlovsky.pages.main.impl.handler;

import com.kozlovsky.common.protocol.ActionHeader;
import com.kozlovsky.common.protocol.Request;
import com.kozlovsky.common.protocol.Response;
import com.kozlovsky.common.resources.service.FileReaderService;
import com.kozlovsky.pages.main.api.message.CenterLableRequest;
import com.kozlovsky.pages.main.api.message.GetLocalizedPageRequest;
import com.kozlovsky.pages.main.api.message.GetLocalizedPageResponse;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.*;

/**
 * Created by anton on 05.07.17.
 */
@RunWith(MockitoJUnitRunner.class)
public class GetLocalizedPageHandlerTest {

    @InjectMocks
    private GetLocalizedPageHandler getLocalizedPageHandler;

    @Spy
    private FileReaderService fileReaderService;

    private Request<GetLocalizedPageRequest> request;

    @Before
    public void init(){
        request = new Request<>();
    }

    @Test
    public void getName() throws Exception {
        assertThat(getLocalizedPageHandler.getName(), is("get_localized_pages"));
    }

    @Test
    public void handleWork() throws Exception {
        request.setHeader(new ActionHeader("UUID","ru","main", "m"));
        request.setData(new GetLocalizedPageRequest(new ArrayList<String>(){{add("blog");}}));

        Response<GetLocalizedPageResponse> response = getLocalizedPageHandler.handleWork(request);

        System.out.println(response.getData().getLocPages().get(0));

    }

}