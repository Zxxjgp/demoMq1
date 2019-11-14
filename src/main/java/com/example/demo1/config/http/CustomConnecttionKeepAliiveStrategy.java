package com.example.demo1.config.http;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.http.HttpResponse;
import org.apache.http.conn.ConnectionKeepAliveStrategy;
import org.apache.http.protocol.HTTP;
import org.apache.http.protocol.HttpContext;

import java.util.Arrays;

/**
 *
 * 连接的复用  -1代表永久有效
 * @author jiaoguanping
 * @version 1.0.0
 * @ClassName CustomConnecttionKeepAliiveStrategy
 * @date 2019/10/31  13:39
 */
public class CustomConnecttionKeepAliiveStrategy implements ConnectionKeepAliveStrategy {

    private final long DEFAULT_SECONDS = 30 ;

    @Override
    public long getKeepAliveDuration(HttpResponse httpResponse, HttpContext httpContext) {

        return Arrays.asList( httpResponse.getHeaders(HTTP.CONN_KEEP_ALIVE))
                .stream()
                .filter( x -> StringUtils.equals(x.getName(), "timeout") && StringUtils.isNumeric(x.getValue()))
                .findFirst()
                .map( x -> NumberUtils.toLong( x.getValue(), DEFAULT_SECONDS))
                .orElse(DEFAULT_SECONDS)  * 1000;
    }
}
