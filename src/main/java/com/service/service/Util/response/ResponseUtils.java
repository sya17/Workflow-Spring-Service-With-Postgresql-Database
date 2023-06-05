package com.service.service.Util.response;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseUtils<T> {

    private static ResponseUtils Instance;

    public ResponseUtils() {
    }

    public static synchronized ResponseUtils getInstance() {
        if (Instance == null)
            Instance = new ResponseUtils();
        return Instance;
    }

    private String service;
    private String message;
    private Object err_message;
    // private List<ErrorResponse> err_message;
    private Pagination page;
    private T data;
}
