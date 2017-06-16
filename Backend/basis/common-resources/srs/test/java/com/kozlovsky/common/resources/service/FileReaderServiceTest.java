package com.kozlovsky.common.resources.service;

import com.kozlovsky.common.resources.ConfigResources;
import com.kozlovsky.common.resources.Util.Lang;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by anton on 12.06.17.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@Import(ConfigResources.class)
public class FileReaderServiceTest {

    @Autowired
    private FileReaderService fileReaderService;

    @Test
    public void testGetValue() throws Exception {

       String s = fileReaderService.getValue("main", Lang.ENG,"hello");

       assertThat(s,is("Hello world"));
    }
}