package com.service.service.Util.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorResponse {

    public String field;
    public String msg;

    public ErrorResponse() {
    }

    public ErrorResponse(String field, String msg) {
        if (field != null) {
            this.field = field;
        }
        if (msg != null) {
            this.msg = msg;
        }
    }
}
