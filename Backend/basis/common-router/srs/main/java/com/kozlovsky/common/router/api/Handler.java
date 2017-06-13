package com.kozlovsky.common.router.api;

import com.kozlovsky.common.exceptions.MapperException;
import com.kozlovsky.common.protocol.Request;
import com.kozlovsky.common.protocol.Response;

/**
 * Created by anton on 13.06.17.
 */
public interface Handler {
    String getName();

    Response<?> handle(final Request<?> msg) throws MapperException;
}
