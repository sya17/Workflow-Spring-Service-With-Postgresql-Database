package com.service.service.Util;

public class StringUtil {

    public static StringUtil INSTANCE = new StringUtil();

    public static StringUtil getInstance() {
        if (INSTANCE != null) {
            return INSTANCE;
        } else {
            return new StringUtil();
        }
    }

    public boolean isNullOrEmpty(String value) {
        return value == null || value.equalsIgnoreCase("");
    }
}
