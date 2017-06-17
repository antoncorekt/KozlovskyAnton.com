package com.kozlovsky.common.exceptions;

/**
 * Created by anton on 13.06.17.
 */
public class BaseException extends Exception {

    public BaseException() {
    }

    public BaseException(String s) {
        super(s);
    }

    public BaseException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public BaseException(Throwable throwable) {
        super(throwable);
    }

    public BaseException(String s, Throwable throwable, boolean b, boolean b1) {
        super(s, throwable, b, b1);
    }
}
