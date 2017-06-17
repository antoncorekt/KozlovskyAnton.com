package com.kozlovsky.common.protocol.util;

import com.kozlovsky.common.protocol.ActionHeader;
import com.kozlovsky.common.protocol.Response;
import com.kozlovsky.common.protocol.ResponseStatus;

import java.io.Serializable;

/**
 * Created by anton on 17.06.17.
 */
public class ResponseBuilder<T extends Serializable> {

    private ActionHeader header;
    private T data;
    private ResponseStatus status;

    public ResponseBuilder withData(T data){
        this.data = data;
        return this;
    }

    public ResponseBuilder withStatus(Status status){
        this.status = new ResponseStatus(status);
        return this;
    }

    public ResponseBuilder withStatus(Status status, String userMsg){
        this.status = new ResponseStatus(status, userMsg);
        return this;
    }

    public ResponseBuilder withStatus(ResponseStatus status){
        this.status = status;
        return this;
    }

    public ResponseBuilder withHeader(ActionHeader header){
        this.header = header;
        return this;
    }

    public ActionHeaderBuilder configureActionHeader(){
        return new ActionHeaderBuilder();
    }

    public Response<?> build() {
        return new Response<>(this);
    }

    public ActionHeader getHeader() {
        return header;
    }


    public T getData() {
        return data;
    }


    public ResponseStatus getStatus() {
        return status;
    }

}
