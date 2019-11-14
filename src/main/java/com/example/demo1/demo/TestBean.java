package com.example.demo1.demo;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author jiaoguanping
 * @version 1.0.0
 * @ClassName TestBean
 * @date 2019/10/24  23:51
 */
@AllArgsConstructor
@Slf4j
public class TestBean {

    private String context;

    public void hello() {
        log.info("我拿到bean了"+context);
    }
}
