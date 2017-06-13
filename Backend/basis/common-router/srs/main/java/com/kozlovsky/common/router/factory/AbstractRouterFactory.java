package com.kozlovsky.common.router.factory;

import com.kozlovsky.common.router.api.Handler;
import com.kozlovsky.common.router.router.RouterFactory;

/**
 * Created by anton on 13.06.17.
 */
public abstract class AbstractRouterFactory<T extends Handler> extends RouterFactory<T> {
}
