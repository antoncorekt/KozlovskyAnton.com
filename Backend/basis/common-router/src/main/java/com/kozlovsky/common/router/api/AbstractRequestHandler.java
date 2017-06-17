package com.kozlovsky.common.router.api;

import com.kozlovsky.common.datamapper.DataMapper;
import com.kozlovsky.common.datamapper.MapperException;
import com.kozlovsky.common.protocol.Request;
import com.kozlovsky.common.protocol.RequestData;
import com.kozlovsky.common.protocol.Response;
import com.kozlovsky.common.protocol.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.ParameterizedType;
import java.util.Map;

/**
 * Created by anton on 13.06.17.
 */
public abstract class AbstractRequestHandler<T extends RequestData, R extends ResponseData> implements RequestHandler {

    @Autowired
    private DataMapper dataMapper;

    private final Class<T> cl = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];

    @Override
    public Response<?> handle(Request<?> msg) throws MapperException{

        Request<T> request= new Request<>();
        request.setHeader(msg.getHeader());

        T t = dataMapper.convert((Map<String, Object>) msg.getData(),cl);

        request.setData(t);

        return handleWork(request);
    }


    public abstract Response<R> handleWork(Request<T> msg);
}
