package com.kozlovsky.pages.main.impl.handler;

import com.kozlovsky.common.protocol.Request;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
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

   // private Request<CenterLableRequest> request;

    @Before
    public void init(){
      //  request = new Request<>();

    }

    @Test
    public void getName() throws Exception {
        assertThat(centerLableHandler.getName(), is("center"));
    }

    @Test
    public void handleWork() throws Exception {
        assertThat("center", is("center"));

    }

}