package com.example.demo1.interceptor;

import lombok.Builder;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author jiaoguanping
 * @version 1.0.0
 * @ClassName AuthorityInterceptor
 * @date 2019/10/30  21:10
 */
@Builder
public class AuthorityInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        //实现具体的业务逻辑
        System.out.println("我终于等待你了，看看你怎么办呢");

        return true;
    }
}
