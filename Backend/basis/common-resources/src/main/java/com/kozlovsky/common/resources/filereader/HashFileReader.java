package com.kozlovsky.common.resources.filereader;

import com.kozlovsky.common.exceptions.ParserException;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by anton on 11.06.17.
 */

public class HashFileReader extends FileReader {

    private Map<String, String> map = new HashMap<>();
    private String stringFile;

    public HashFileReader(String fileName) throws IOException,ParserException {
        super(fileName);

        readFile();
    }

    @Override
    protected void readFile() throws IOException,ParserException {
        try {
            StringBuilder res = new StringBuilder();
            Files.lines(Paths.get(fileName), StandardCharsets.UTF_8).forEach(res::append);
            stringFile = res.toString();
            parseFile();
        }catch (IOException ex){
            throw ex;
        }

    }

    private void parseFile() throws ParserException {
        String key="";
        String value = "";
        int indexBEGIN, indexEND_NAME, indexEND;
        //System.out.println(stringFile);
        if(stringFile.length()==0)
            throw new ParserException("Empty file " + fileName);

        while (!"".equals(stringFile)){
            indexBEGIN = stringFile.indexOf("BEGIN ");
            if(indexBEGIN!=0)
                throw new ParserException("BEGIN_ construction in not at start on document" + fileName);

            indexEND_NAME = stringFile.indexOf('^');
            if(indexEND_NAME==-1)
                throw new ParserException("Not find ^ symbol. Please enter this symbol at end position in key value" + fileName);

            indexEND = stringFile.indexOf("END");
            if(indexEND==-1)
                throw new ParserException("NOT found END constructor" + fileName);

            if(indexBEGIN>=indexEND || indexBEGIN>=indexEND_NAME || indexEND_NAME >= indexEND)
                throw new ParserException("Format error [indexBEGIN>=indexEND || indexBEGIN>=indexEND_NAME || indexEND_NAME >= indexEND]" + fileName);

            key = stringFile.substring(indexBEGIN+6,indexEND_NAME);
            value = stringFile.substring(stringFile.indexOf('^')+1, indexEND);
            map.put(key,value);
            stringFile = stringFile.substring(indexEND+3);
        }
    }

    @Override
    public String getValue(String key) {
        String s = map.get(key);
        return (s!=null)?s:"Not found text with key "+key;
    }

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public String getStringFile() {
        return stringFile;
    }

    public void setStringFile(String stringFile) {
        this.stringFile = stringFile;
    }
}
