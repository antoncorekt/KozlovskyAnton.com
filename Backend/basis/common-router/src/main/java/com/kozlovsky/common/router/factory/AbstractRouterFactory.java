package com.kozlovsky.common.router.factory;

import com.kozlovsky.common.protocol.Request;
import com.kozlovsky.common.router.api.Handler;
import com.kozlovsky.common.router.router.RouterFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by anton on 13.06.17.
 */
public abstract class AbstractRouterFactory<T extends Handler> implements RouterFactory<T> {

    private Map<String, T> handlerMap;

    @Autowired
    private List<T> handlers;

    @PostConstruct
    public void init(){
        handlerMap = handlers.stream()
                .collect(Collectors.toMap(
                        T::getName,
                        Function.identity()));
    }

    public abstract String getKey(Request<?> msg);

    public T getHandler(Request msg){
        String key = getKey(msg);
        return handlerMap.get(key);
    }

}
