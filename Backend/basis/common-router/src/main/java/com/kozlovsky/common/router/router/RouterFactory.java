package com.kozlovsky.common.router.router;

import com.kozlovsky.common.protocol.Request;
import com.kozlovsky.common.router.api.Handler;

/**
 * Created by anton on 13.06.17.
 */
public interface RouterFactory<T extends Handler>  {

    T getHandler(Request msg);
}
