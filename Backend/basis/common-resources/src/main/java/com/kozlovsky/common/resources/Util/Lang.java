package com.kozlovsky.common.resources.Util;

import com.sun.org.apache.bcel.internal.generic.LADD;

/**
 * Created by anton on 12.06.17.
 */
public enum Lang {
    RUS,
    ENG,
    POL;

    public static Lang fromString(String text) {
        if(text.equals("ru")) return Lang.RUS;
        if(text.equals("pl")) return Lang.POL;
        return Lang.ENG;
    }
}
