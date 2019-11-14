package com.example.demo1.config;

import org.springframework.dao.DuplicateKeyException;

/**
 * @author jiaoguanping
 * @version 1.0.0
 * @ClassName CustomDuplicatedKeyException
 * @date 2019/10/20  16:35
 */
public class CustomDuplicatedKeyException extends DuplicateKeyException {
    public CustomDuplicatedKeyException(String msg) {
        super("12306");
    }

    public CustomDuplicatedKeyException(String msg, Throwable cause) {
        super("12306", cause);
    }
}
