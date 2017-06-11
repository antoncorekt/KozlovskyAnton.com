package com.kozlovsky.common.resources.filereader;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by anton on 11.06.17.
 */
public class HashFileReaderTest {

    private FileReader fileReader  = new HashFileReader("/home/anton/Documents/AntonKozlovskyCom/Backend/basis/common-resources/srs/test/resources/pages/en/main.res");


    @Test
    public void getValue() throws Exception {

        fileReader.readFile();
        assertThat(fileReader.getValue("center"), is("Hello, my name in Anton."));
    }

}