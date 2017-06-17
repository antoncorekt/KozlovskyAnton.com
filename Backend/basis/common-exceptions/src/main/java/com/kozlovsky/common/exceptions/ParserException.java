package com.kozlovsky.common.exceptions;

/**
 * Created by anton on 12.06.17.
 */
public class ParserException extends BaseException {

    public ParserException(String s) {
        super(s);
    }

    public ParserException(String s, Throwable throwable) {
        super(s, throwable);
    }
}
