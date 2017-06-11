package com.kozlovsky.common.resources.filereader;

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

    public HashFileReader(String fileName) throws IOException {
        super(fileName);

        readFile();
    }

    @Override
    protected void readFile() throws IOException {
        try {
            StringBuilder res = new StringBuilder();
            Files.lines(Paths.get(fileName), StandardCharsets.UTF_8).forEach(res::append);
            stringFile = res.toString();
            parseFile();
        }catch (IOException ex){
            throw ex;
        }

    }

    private void parseFile(){
        String key="";
        String value = "";
        System.out.println(stringFile);
        while (!"".equals(stringFile)){
            key = stringFile.substring(stringFile.indexOf("BEGIN ")+6,stringFile.indexOf('^'));
            value = stringFile.substring(stringFile.indexOf('^')+1, stringFile.indexOf("END"));
            map.put(key,value);
            stringFile = stringFile.substring(stringFile.indexOf("END")+3);
        }
    }

    @Override
    public String getValue(String key) {
        return map.get(key);
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
