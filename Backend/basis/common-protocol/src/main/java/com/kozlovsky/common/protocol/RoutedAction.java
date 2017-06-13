package com.kozlovsky.common.protocol;

import java.io.Serializable;

/**
 * Created by anton on 13.06.17.
 */
public class RoutedAction<T extends Serializable> extends Action<T>{

    private RoutedData routedData;
    

    public RoutedAction(RoutedData routedData) {
        this.routedData = routedData;
    }

    public RoutedAction(ActionHeader header, T data, RoutedData routedData) {
        super(header, data);
        this.routedData = routedData;
    }

    public RoutedData getRoutedData() {
        return routedData;
    }

    public void setRoutedData(RoutedData routedData) {
        this.routedData = routedData;
    }
}
