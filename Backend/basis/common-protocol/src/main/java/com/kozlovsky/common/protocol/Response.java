package com.kozlovsky.common.protocol;

import java.io.Serializable;

/**
 * Created by anton on 13.06.17.
 */
public class Response<T extends Serializable> extends RoutedAction<T> {

    private ResponseStatus status;

}
