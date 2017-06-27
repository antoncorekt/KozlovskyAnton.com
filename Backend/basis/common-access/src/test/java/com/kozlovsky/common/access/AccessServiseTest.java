package com.kozlovsky.common.access;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by anton on 27.06.17.
 */
@RunWith(MockitoJUnitRunner.class)
public class AccessServiseTest {

    @InjectMocks
    private AccessServise accessServise;

    @Test
    public void getAccessLevel() throws Exception {

        assertThat(accessServise.getAccessLevel("admin"),is(AccessLevel.ADMIN));
        assertThat(accessServise.getAccessLevel("user"),is(AccessLevel.FRIEND));
        assertThat(accessServise.getAccessLevel("abracadabra"),is(AccessLevel.ALL));

    }

}