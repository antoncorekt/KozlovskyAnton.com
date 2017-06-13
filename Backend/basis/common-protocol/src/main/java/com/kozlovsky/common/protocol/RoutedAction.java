package com.kozlovsky.common.protocol;

import java.io.Serializable;

/**
 * Created by anton on 13.06.17.
 */
public class RoutedAction<T extends Serializable> extends Action<T>{

    private RoutedData routedData;
}
