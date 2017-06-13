package com.kozlovsky.common.router.factory;

import com.kozlovsky.common.router.api.RequestHandler;
import org.springframework.stereotype.Component;

/**
 * Created by anton on 13.06.17.
 */
@Component
public class RequestHandlerFactory<T extends RequestHandler> extends AbstractRouterFactory<T> {


}
