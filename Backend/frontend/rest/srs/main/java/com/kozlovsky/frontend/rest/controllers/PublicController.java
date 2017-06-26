package com.kozlovsky.frontend.rest.controllers;


import com.kozlovsky.common.protocol.*;
import com.kozlovsky.common.protocol.util.ResponseBuilder;
import com.kozlovsky.common.protocol.util.ResponseFactory;
import com.kozlovsky.common.protocol.util.Status;
import com.kozlovsky.common.router.api.Handler;
import com.kozlovsky.pages.main.api.message.CenterLableRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


/**
 * Created by anton on 29.05.17.
 */

@RestController
@CrossOrigin
//@EnableAutoConfiguration
@RequestMapping(path = "/root",
        method = RequestMethod.POST,
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
public class PublicController {

    @Autowired
    private Handler mainRouter;

    @RequestMapping(path = "/public")
    public Response<?> getPublicMessage(@RequestBody Request<?> request){
        try{
            return mainRouter.handle(request);
        }
        catch (Exception e){
            return ResponseFactory.createResponse(Status.BAD_REQUEST);
        }
    }

    @RequestMapping(path = "/test", method = RequestMethod.GET)
    public Request<?> test(){
        return new Request<CenterLableRequest>(new ActionHeader("id1","pl","main","center")
        ,null,new RoutedData("user1"));    }


}
