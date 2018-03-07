package com.ll.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class chaxunshibaiException extends RuntimeException {

    private String msg;
    private Integer code;

    public chaxunshibaiException(String msg, Integer code) {
        super(msg);
        this.code = code;
    }
}
