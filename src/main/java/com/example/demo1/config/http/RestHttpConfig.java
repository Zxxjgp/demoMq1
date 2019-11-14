package com.example.demo1.config.http;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.TimeUnit;

/**
 * @author jiaoguanping
 * @version 1.0.0
 * @ClassName RestHttpConfig
 * @date 2019/10/31  13:38
 */
@Configuration
public class RestHttpConfig {


   /* @Bean
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setRequestFactory(requestFactory());
        restTemplate.setErrorHandler(new DefaultResponseErrorHandler());
        return restTemplate;
    }
    @Bean
    public HttpComponentsClientHttpRequestFactory requestFactory() {

        HttpClientBuilder clientBuilder = HttpClientBuilder.create();
        clientBuilder.disableAutomaticRetries();

        //连接管理器
        PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager(60, TimeUnit.SECONDS);
        //最大200个连接
        connectionManager.setMaxTotal(200);

        //最大保持20个
        connectionManager.setDefaultMaxPerRoute(100);

        CloseableHttpClient httpClient = HttpClients.custom()
                .setConnectionManager(connectionManager)
                //连接60秒之后把它关闭掉
                .evictIdleConnections(60, TimeUnit.SECONDS)
                //关闭掉自动重试
                .disableAutomaticRetries()
                //设置连接策略
                .setKeepAliveStrategy(new CustomConnecttionKeepAliiveStrategy())
                .build();

        return new HttpComponentsClientHttpRequestFactory(httpClient);
    }
*/
}
