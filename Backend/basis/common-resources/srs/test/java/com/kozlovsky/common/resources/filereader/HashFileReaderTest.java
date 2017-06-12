package com.kozlovsky.common.resources.filereader;

import com.kozlovsky.common.exceptions.ParserException;
import org.junit.Test;

import java.io.File;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by anton on 11.06.17.
 */
public class HashFileReaderTest {

    private FileReader fileReader;

    private ClassLoader classLoader = getClass().getClassLoader();
    private File file ;

    @Test
    public void getValue() throws Exception {

        file = new File(classLoader.getResource("pages/en/main.res").getFile());
        fileReader  = new HashFileReader(file.getAbsolutePath());

        fileReader.readFile();
        assertThat(fileReader.getValue("center"), is("Hello, my name in Anton."));
        assertThat(fileReader.getValue("hero"), is("My hero is Batman"));
        assertThat(fileReader.getValue("hello"), is("Hello world"));
    }

    @Test(expected = ParserException.class)
    public void getValueError() throws Exception {
        file = new File(classLoader.getResource("pages/en/main-err.res").getFile());
        fileReader  = new HashFileReader(file.getAbsolutePath());
    }

    @Test(expected = ParserException.class)
    public void getValueError1() throws Exception {
        file = new File(classLoader.getResource("pages/en/main-err-1.res").getFile());
        fileReader  = new HashFileReader(file.getAbsolutePath());
    }

    @Test(expected = ParserException.class)
    public void getValueError2() throws Exception {
        file = new File(classLoader.getResource("pages/en/main-err-2.res").getFile());
        fileReader  = new HashFileReader(file.getAbsolutePath());
    }

}