package com.kozlovsky.common.protocol;

import java.io.Serializable;

/**
 * Created by anton on 13.06.17.
 */
public class Action<T extends Serializable> implements Serializable {

    private ActionHeader header;

    private T data;

}
