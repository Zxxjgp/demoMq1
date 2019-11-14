package com.example.demo1.config;

import com.example.demo1.web.WebClientController;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author jiaoguanping
 * @version 1.0.0
 * @ClassName RestConfig
 * @date 2019/10/30  21:46
 */
@Configuration
public class RestConfig {
    @Autowired
    private RestTemplate restTemplate;

    @Bean
    public  RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    public static WebClientController webClientController() {
        return new WebClientController();
    }
}
