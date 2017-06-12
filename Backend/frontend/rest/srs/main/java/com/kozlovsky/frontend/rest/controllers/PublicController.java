package com.kozlovsky.frontend.rest.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.kozlovsky.common.resources.Util.Lang;
import com.kozlovsky.common.resources.service.FileReaderService;
import com.kozlovsky.common.resources.service.ResourcesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * Created by anton on 29.05.17.
 */

@RestController
@CrossOrigin
//@EnableAutoConfiguration
@RequestMapping(value = "/api")
public class PublicController {

    @Autowired
    private ResourcesService resourceService;

    @Autowired
    private FileReaderService fileReaderService;

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, path = "/test", produces = MediaType.APPLICATION_JSON_VALUE)
    public String test() throws Exception{
        ObjectMapper mapper = new ObjectMapper();

        ArrayNode arrayNode = mapper.createArrayNode();

        ObjectNode objectNode1 = mapper.createObjectNode();
        objectNode1.put("data", fileReaderService.getValue("main", Lang.POL,"center"));
        objectNode1.put("data2", "Hello Word2!!!");

        ObjectNode objectNode2 = mapper.createObjectNode();
        objectNode2.put("lol", "Hello Lol!!!");
        objectNode2.put("lool2", "Hello Lol2!!!");
        /**
         * Array contains JSON Objects
         */
        arrayNode.add(objectNode1);
        arrayNode.add(objectNode2);

        return arrayNode.toString();
    }

    @ResponseBody
    @RequestMapping(value = "/id", method = RequestMethod.GET)
    public String getPerson() throws Exception { //handle it!!

        return fileReaderService.getValue("main", Lang.POL,"center");
    }


}
