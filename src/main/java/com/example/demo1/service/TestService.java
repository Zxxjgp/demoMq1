package com.example.demo1.service;

import com.example.demo1.entity.Product;

import java.util.List;

/**
 * @author jiaoguanping
 * @version 1.0.0
 * @ClassName TestService
 * @date 2019/10/20  17:44
 */
public interface TestService {

    List<Product> findAll();

    void redidHashCache(String name);

    List<Product> list(List<String> names);

    Long findAlls() throws Exception;
}
