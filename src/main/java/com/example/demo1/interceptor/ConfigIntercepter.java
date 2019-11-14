package com.example.demo1.interceptor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author jiaoguanping
 * @version 1.0.0
 * @ClassName ConfigIntercepter
 * @date 2019/10/30  21:14
 */
@Configuration
public class ConfigIntercepter implements WebMvcConfigurer {

    @Bean
    public AuthorityInterceptor interceptor() {
        return new AuthorityInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(interceptor()).addPathPatterns("/wx/**");
    }
}
