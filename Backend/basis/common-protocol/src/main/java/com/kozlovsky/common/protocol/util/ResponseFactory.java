package com.kozlovsky.common.protocol.util;

import com.kozlovsky.common.protocol.ActionHeader;
import com.kozlovsky.common.protocol.Response;
import com.kozlovsky.common.protocol.ResponseData;
import com.kozlovsky.common.protocol.ResponseStatus;

/**
 * Created by anton on 17.06.17.
 */
public class ResponseFactory {

    public static <T extends ResponseData> Response<?> createResponse(ActionHeader header, T data, Status status){
        return new ResponseBuilder<>()
                .withData(data)
                .withHeader(header)
                .withStatus(status)
                .build();
    }

    public static  Response<?> createResponse( Status status){
        return new ResponseBuilder<>()
                .withStatus(status)
                .build();
    }

    public static  Response<?> createResponse( Status status, String userMsg){
        return new ResponseBuilder<>()
                .withStatus(new ResponseStatus(status,userMsg))
                .build();
    }
}
