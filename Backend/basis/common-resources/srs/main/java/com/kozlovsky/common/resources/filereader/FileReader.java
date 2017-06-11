package com.kozlovsky.common.resources.filereader;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by anton on 11.06.17.
 */
public abstract class FileReader {

    protected final String fileName;

    protected FileReader(String fileName) {
        this.fileName = fileName;
    }


    abstract protected void readFile() throws IOException;


    abstract public String getValue(String key);


}
