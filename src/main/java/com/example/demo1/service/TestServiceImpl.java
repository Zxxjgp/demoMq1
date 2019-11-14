package com.example.demo1.service;

import com.example.demo1.dao.TestDao;
import com.example.demo1.entity.Product;
import com.example.demo1.entity.redis.CooffeCache;
import com.example.demo1.utils.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.exact;

/**
 * @author jiaoguanping
 * @version 1.0.0
 * @ClassName TestServiceImpl
 * @date 2019/10/20  17:44
 */
@Service
@Slf4j
@CacheConfig(cacheNames="TG")
public class TestServiceImpl implements  TestService{

    @Autowired
    private TestDao testDao;


    @Autowired
    private RedisUtil redisUtil;


    @Autowired
    private DataCacheReposity dataCacheReposity;


    @Override
    @Cacheable(value = "webAudit")
    public List<Product> findAll() {
  /*      Product product = new Product();
        product.setId("100861");
        product.setName("中国移动");
        testDao.save(product);*/
        return testDao.findAll();
    }

    @Override
    public void redidHashCache(String name) {
        Optional<CooffeCache> all = dataCacheReposity.findOneByName(name);
        if (all.isPresent()) {
            System.out.println("获取到数据了");
            CooffeCache cooffeCache = all.get();
            Product coffee = Product.builder()
                    .name(cooffeCache.getName())
                    .createTime(cooffeCache.getCreateTime())
                    .build();
            Optional.of(coffee);
        } else {
            Optional<Product> raw = findOneCoffee(name);
            raw.ifPresent(c -> {
                CooffeCache coffeeCache = CooffeCache.builder()
                        .id(c.getId())
                        .name(c.getName())
                        .createTime(c.getCreateTime())
                        .build();
                log.info("Save Coffee {} to cache.", coffeeCache);
                dataCacheReposity.save(coffeeCache);
            });
        }
         System.out.println(all);


    }

    @Override
    @Cacheable(value = "webAudit")
    public List<Product> list(List<String> names) {
        return testDao.findByName(names);
    }

    @Override
    @Cacheable(value = "webAudit")
    public Long findAlls() throws Exception {

        long count = testDao.count();
       // redisUtil.set("121","32323");
        log.info("------------------>"+count);
        return count;
    }

    public Optional<Product> findOneCoffee(String name) {
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withMatcher("name", exact().ignoreCase());
        Optional<Product> coffee = testDao.findOne(
                Example.of(Product.builder().name(name).build(), matcher));
        log.info("Coffee Found: {}", coffee);
        return coffee;
    }


}
