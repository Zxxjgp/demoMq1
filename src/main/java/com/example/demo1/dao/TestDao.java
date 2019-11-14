package com.example.demo1.dao;

import com.example.demo1.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author jiaoguanping
 * @version 1.0.0
 * @ClassName TestDao
 * @date 2019/10/20  17:43
 */
public interface TestDao extends JpaRepository<Product, String> {
    List<Product> findByName(List<String> names);
}
