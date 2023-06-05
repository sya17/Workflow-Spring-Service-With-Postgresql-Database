package com.service.service.Util.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Pagination<T> {

    private static Pagination instance;

    private Pagination() {
    }

    private Pagination(String next_page_url, String prev_page_url, int total, int per_page, int curr_page,
            int last_page, int from, int to) {
        this.prev_page_url = next_page_url;
        this.next_page_url = next_page_url;
        this.total = total;
        this.per_page = per_page;
        this.curr_page = curr_page;
        this.last_page = last_page;
        this.from = from;
        this.to = to;
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
