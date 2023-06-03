package com.service.service.Util;

import java.util.Date;

public class PrintUtil {

    public static PrintUtil INSTANCE = new PrintUtil();

    public static PrintUtil getInstance() {
        if (INSTANCE != null) {
            return INSTANCE;
        } else {
            return new PrintUtil();
        }
    }

    public void println(String val) {
        System.out.println("" + new Date() + " : " + val + "\n");
    }

    public void print(String val) {
        System.out.println("" + new Date() + " : " + val);
    }
}
