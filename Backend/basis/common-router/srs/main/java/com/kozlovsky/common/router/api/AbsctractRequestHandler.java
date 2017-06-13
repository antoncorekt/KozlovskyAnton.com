package com.kozlovsky.common.router.api;

import com.kozlovsky.common.protocol.RequestData;
import com.kozlovsky.common.protocol.ResponseData;

/**
 * Created by anton on 13.06.17.
 */
public abstract class AbsctractRequestHandler<T extends RequestData, R extends ResponseData> implements RequestHandler {
}
