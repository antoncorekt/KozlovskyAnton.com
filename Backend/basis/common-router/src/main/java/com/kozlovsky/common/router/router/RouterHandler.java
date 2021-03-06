package com.kozlovsky.common.router.router;

import com.kozlovsky.common.protocol.Request;
import com.kozlovsky.common.router.api.Handler;

/**
 * Created by anton on 13.06.17.
 */
public interface RouterHandler extends Handler {

    String getRouteKey(final Request<?> msg);
}
