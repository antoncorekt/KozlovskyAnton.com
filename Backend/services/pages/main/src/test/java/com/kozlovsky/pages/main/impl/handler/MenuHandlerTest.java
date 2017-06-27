package com.kozlovsky.pages.main.impl.handler;

import com.kozlovsky.common.access.AccessServise;
import com.kozlovsky.common.protocol.ActionHeader;
import com.kozlovsky.common.protocol.Request;
import com.kozlovsky.common.protocol.Response;
import com.kozlovsky.common.resources.service.FileReaderService;
import com.kozlovsky.pages.main.api.message.CenterLableRequest;
import com.kozlovsky.pages.main.api.message.CenterLableResponse;
import com.kozlovsky.pages.main.api.message.MenuRequest;
import com.kozlovsky.pages.main.api.message.MenuResponse;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by anton on 13.06.17.
 */
@RunWith(MockitoJUnitRunner.class)
public class MenuHandlerTest {

    @InjectMocks
    private MenuHandler menuHandler;

    @InjectMocks
    private FileReaderService fileReader;

    @Spy
    private AccessServise accessServise;

    @Spy
    private FileReaderService fileReaderService;

    private Request<MenuRequest> request;

    @Before
    public void init(){
        request = new Request<>();
    }

    @Test
    public void getName() throws Exception {
        assertThat(menuHandler.getName(),is("menu"));
    }

    @Test
    public void handleWork() throws Exception {
        request.setHeader(new ActionHeader("uuid","en","main","menu"));


        Response<MenuResponse> response = menuHandler.handleWork(request);

        if(response!=null && response.getData()!=null) {

            List<String> nameList = response.getData().getMenuName();

            System.out.println(nameList.get(nameList.size() - 1));

        }
    }

}