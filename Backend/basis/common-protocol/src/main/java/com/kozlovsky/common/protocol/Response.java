package com.kozlovsky.common.protocol;

import com.kozlovsky.common.protocol.util.ResponseBuilder;

import java.io.Serializable;

/**
 * Created by anton on 13.06.17.
 */
public class Response<T extends Serializable> extends RoutedAction<T> {

    private ResponseStatus status;

    public Response(){

    }

    public Response(ResponseBuilder<T> responseBuilder) {
        setHeader(responseBuilder.getHeader());
        setStatus(responseBuilder.getStatus());
        setData(responseBuilder.getData());
    }

    public Response(ResponseStatus status) {
        this.status = status;
    }

    public ResponseStatus getStatus() {
        return status;
    }

    public void setStatus(ResponseStatus status) {
        this.status = status;
    }
}
