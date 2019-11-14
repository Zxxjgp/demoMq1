package com.example.demo1.web;

import com.example.demo1.core.ActionResult;

import com.example.demo1.utils.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author jiaoguanping
 * @version 1.0.0
 * @ClassName WebClientController
 * @date 2019/10/31  14:19
 */
/*@RestController
@RequestMapping("/hp")
@Slf4j*/
public class WebClientController implements BeanFactoryPostProcessor {

/*    @Autowired
    private WebClient webClient;*/

/*    @GetMapping("tt")*/
    public ActionResult webHttp() {
      /*  CountDownLatch countDownLatch = new CountDownLatch(4);
        Disposable subscribe = webClient.get().uri("/weixin/json")
                .accept(MediaType.ALL)
                .retrieve()
                .bodyToMono(Product.class)
                .doOnError(t -> log.error(t.getMessage()))
                .doFinally(x -> countDownLatch.countDown())
                .subscribeOn(Schedulers.single())
                .subscribe(c -> log.info("======product" + c));*/


        return new ActionResult();
    }
/*
    public static void main(String[] args) {

        //判断这个bean存在不存在
        boolean present = ClassUtils.isPresent("com.example.demo1.utils.RedisUtil", null);
        ConfigurableListableBeanFactory beanFactory = null;
        System.out.println(present);
    }*/

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        boolean present = ClassUtils.isPresent("com.example.demo1.utils.RedisUtil", null);
        if ( !present) {
            System.out.println("类不存在");
            return;
        }
        if ( beanFactory.containsBeanDefinition("redisUtil")) {
            System.out.println("已经存在");
            return;
        }
        resgin(beanFactory);
    }

    private void resgin(ConfigurableListableBeanFactory beanFactory) {
        if ( beanFactory instanceof BeanDefinitionRegistry) {
            GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
            beanDefinition.setBeanClass(RedisUtil.class);
            ((BeanDefinitionRegistry) beanFactory).registerBeanDefinition("redisUtil", beanDefinition);
        } else {
            beanFactory.registerSingleton("redisUtil", new RedisUtil());
        }
    }
}
