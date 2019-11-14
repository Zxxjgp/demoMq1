package com.example.demo1.service;

import com.example.demo1.entity.redis.CooffeCache;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * @author jiaoguanping
 * @version 1.0.0
 * @ClassName DataCacheReposity
 * @date 2019/10/23  19:45
 */
public interface DataCacheReposity extends CrudRepository<CooffeCache, Long>{
    Optional<CooffeCache> findOneByName(String name);
}
