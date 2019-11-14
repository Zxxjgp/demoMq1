package com.example.demo1;

import com.example.demo1.demo.TestBean;
import com.example.demo1.demo6.foo.FooConfig;
import com.example.demo1.entity.Test;
import javafx.application.Application;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory;
import org.springframework.data.redis.core.ReactiveHashOperations;
import org.springframework.data.redis.core.ReactiveStringRedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.transaction.support.TransactionTemplate;
import org.springframework.web.servlet.DispatcherServlet;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.CountDownLatch;


/*(exclude = {
        DataSourceAutoConfiguration.class, DataSourceTransactionManagerAutoConfiguration.class
        , JdbcTemplateAutoConfiguration.class
})*/

@SpringBootApplication
@Slf4j
@EnableCaching
/*@EnableRedisHttpSession
@EnableRedisRepositories*/
public class Demo1Application implements CommandLineRunner {

    /**
     * 增加缓存
     */

/*    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private TransactionTemplate transactionTemplate;

    @Autowired
    private ReactiveStringRedisTemplate reactiveStringRedisTemplate;*/

    public static void main(String[] args) {
        SpringApplication.run(Demo1Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        srun();



/*        showConnetion();
        shouDate();*/
/*        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                Object list = getList();

                jdbcTemplate.execute("insert into T_TEST(ID, NAME) values ('123', '大哥3')");
                if (null != list ) {
                    log.info("111111111111111"+list.toString());
                }
                transactionStatus.setRollbackOnly();

                if (null != list ) {
                    log.info("22222222222222"+list.toString());
                }
            }
        });*/

    }

  //  private Object getList() {
 /*       return jdbcTemplate.queryForList("select * from T_TEST");
    }*/

    /**
     * redis 集成reative编程的redis配置
     */
/*    @Bean
    ReactiveStringRedisTemplate reactiveStringRedisTemplate(ReactiveRedisConnectionFactory factory) {
        return new ReactiveStringRedisTemplate(factory);
    }*/

    //内存数据库
/*
    private void showConnetion() throws Exception{
        Connection con = dataSource.getConnection();
        System.out.println(con.toString());
        con.close();
    }

    private void shouDate() {
        jdbcTemplate.queryForList("SELECT * from Fuu").forEach( x ->
                log.info(x.toString())
                );
    }*/


 /*   @Bean
    @ConfigurationProperties("foo.datasource")
    public DataSourceProperties fooDataSourceProperties() {
        return new DataSourceProperties();
    }
    @Bean
    public DataSource fooDataSource() {
        DataSourceProperties dataSourceProperties =fooDataSourceProperties();
        log.info(dataSourceProperties.getUrl());
        return dataSourceProperties.initializeDataSourceBuilder().build();
    }


    @Bean
    @ConfigurationProperties("bar.datasource")
    public DataSourceProperties barDataSourceProperties() {
        return new DataSourceProperties();
    }
    @Bean
    public DataSource barDataSource() {
        DataSourceProperties dataSourceProperties =barDataSourceProperties();
        log.info(dataSourceProperties.getUrl());
        return dataSourceProperties.initializeDataSourceBuilder().build();
    }*/

/*    public void runRedis() throws InterruptedException {
        ReactiveHashOperations<String, String, String> hashOperations =
                reactiveStringRedisTemplate.opsForHash();
        CountDownLatch downLatch = new CountDownLatch(1);
        List<Test> list = jdbcTemplate.query("select * from T_TEST",
                (rs, i) ->
                Test.builder()
                        .id(rs.getLong("id"))
                        .name(rs.getString("name"))
                        .createTime(rs.getDate("create_time"))
                        .build()
        );
        Flux.fromIterable(list)
                .publishOn(Schedulers.single())
                .doOnComplete(() -> log.info("list ok"))
                .flatMap(c -> {
                    log.info(" try to put {}, {},", c.getName(), c.getId());
                    return hashOperations.put("dooffe", c.getId().toString(), c.getName());
                })
                .doOnComplete(() -> log.info("set ok"))
                .concatWith(reactiveStringRedisTemplate.expire("dooffe", Duration.ofMinutes(2)))
                .onErrorResume( e -> {
                    log.error("exceptipon {}", e.getMessage());
                    return Mono.just(false);
                })
                .subscribe( b -> log.info("Boolean: {}", b),
                        e -> log.error("EXCception {}", e.getMessage()) ,
                        () -> downLatch.countDown());
        log.info(" waiting ");
        downLatch.await();

    }*/

    public void srun() {
   /*     ApplicationContext fooContext = new AnnotationConfigApplicationContext(FooConfig.class);
        ClassPathXmlApplicationContext barContext = new ClassPathXmlApplicationContext(
                new String[] {"applicationContext.xml"}, fooContext);
        TestBean bean = fooContext.getBean("testBeanX", TestBean.class);
        bean.hello();

        log.info("=============");

        bean = barContext.getBean("testBeanX", TestBean.class);
        bean.hello();

        bean = barContext.getBean("testBeanY", TestBean.class);
        bean.hello();*/
    }

    @Bean
    public Jackson2ObjectMapperBuilderCustomizer jackson2ObjectMapperBuilderCustomizer() {
        return builder -> builder.indentOutput(true);
    }
}
