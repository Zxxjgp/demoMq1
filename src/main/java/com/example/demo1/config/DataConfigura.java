package com.example.demo1.config;


import com.alibaba.druid.filter.FilterChain;
import com.alibaba.druid.filter.FilterEventAdapter;
import com.alibaba.druid.proxy.jdbc.ConnectionProxy;
import lombok.extern.slf4j.Slf4j;

import java.util.Properties;

/**
 * @author jiaoguanping
 * @version 1.0.0
 * @ClassName DataConfigura
 * @date 2019/10/19  17:21
 */
@Slf4j
public class DataConfigura extends FilterEventAdapter {

    @Override
    public void connection_connectBefore(FilterChain chain, Properties info) {
        log.info("1111111111111111111111111111111111111111111111111111");
    }

    @Override
    public void connection_connectAfter(ConnectionProxy connection) {

    }
}
