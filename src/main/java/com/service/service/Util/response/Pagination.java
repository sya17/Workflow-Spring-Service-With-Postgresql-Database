package com.service.service.Util.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Pagination<T> {

    private static Pagination instance;

    private Pagination() {
    }

    public static synchronized Pagination getInstance() {
        if (instance == null) {
            instance = new Pagination<>();
        }
        return instance;
    }

    private String next_page_url;
    private String prev_page_url;
    private int total;
    private int per_page;
    private int curr_page;
    private int last_page;
    private int from;
    private int to;
    
}
