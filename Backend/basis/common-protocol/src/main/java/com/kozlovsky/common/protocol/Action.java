package com.kozlovsky.common.protocol;

import java.io.Serializable;

/**
 * Created by anton on 13.06.17.
 */
public class Action<T extends Serializable> implements Serializable {

    private ActionHeader header;

    private T data;

    public Action() {
    }

    public Action(ActionHeader header, T data) {
        this.header = header;
        this.data = data;
    }

    public ActionHeader getHeader() {
        return header;
    }

    public void setHeader(ActionHeader header) {
        this.header = header;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
