package com.kozlovsky.pages.main.impl.handler;

import com.kozlovsky.common.protocol.ActionHeader;
import com.kozlovsky.common.protocol.Request;
import com.kozlovsky.common.protocol.Response;
import com.kozlovsky.common.resources.service.FileReaderService;
import com.kozlovsky.pages.main.api.message.CenterLableRequest;
import com.kozlovsky.pages.main.api.message.CenterLableResponse;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by anton on 13.06.17.
 */
@RunWith(MockitoJUnitRunner.class)
public class CenterLableHandlerTest {

    @InjectMocks
    private CenterLableHandler centerLableHandler;

    @Spy
    private FileReaderService fileReaderService;

    private Request<CenterLableRequest> request;

    @Before
    public void init(){
        request = new Request<>();

    }

    @Test
    public void getName() throws Exception {
        assertThat(centerLableHandler.getName(), is("center"));
    }

    @Test
    public void handleWork() throws Exception {
        request.setHeader(new ActionHeader("uuid","en","main","center"));


        Response<CenterLableResponse> response = centerLableHandler.handleWork(request);

        System.out.println(response.getData().getLable());

        assertThat(response.getData().getLable(), is("Hello, my name is Anton."));

    }

}