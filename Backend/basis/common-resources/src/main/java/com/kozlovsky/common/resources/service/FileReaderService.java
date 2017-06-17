package com.kozlovsky.common.resources.service;

import com.kozlovsky.common.resources.Util.Lang;
import com.kozlovsky.common.resources.filereader.FileReader;
import com.kozlovsky.common.resources.filereader.HashFileReader;
import org.springframework.stereotype.Component;

import java.io.File;

/**
 * Created by anton on 11.06.17.
 */
@Component
public class FileReaderService {


    public String getValue(String pageName, Lang lang, String key) throws Exception{
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("pages/"+ langToString(lang)+"/"+pageName+".res").getFile());;
        FileReader fileReader = new HashFileReader(file.getAbsolutePath());
        return fileReader.getValue(key);
    }


    private String langToString(Lang lang){
        if(lang == Lang.RUS)
            return "ru";
        if(lang == Lang.POL)
            return "pl";
        return "en";
    }

}
