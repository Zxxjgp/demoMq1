package com.example.demo1.web;

import com.example.demo1.core.ActionResult;
import com.example.demo1.demo.TestBean;
import com.example.demo1.entity.ModelAndViewEntity;
import com.example.demo1.entity.Product;
import com.example.demo1.exception.JgpException;
import com.example.demo1.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import org.weixin4j.Weixin;
import org.weixin4j.WeixinException;
import org.weixin4j.model.base.Token;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author jiaoguanping
 * @version 1.0.0
 * @ClassName WeixinCOntroller
 * @date 2019/10/19  18:27
 */

@RequestMapping("/weixin")
@RestController
@Slf4j
public class WeixinCOntroller {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private TestService testService;

    @Autowired
    private RestTemplate restTemplate;


/*    @Autowired
    private JedisPool jedisPool;*/


    @GetMapping("/weixin")
    public String getWeixin() throws WeixinException {
        Weixin weixin = new Weixin("wxb97266dfb271f554","d9fa2b5707d343522dbd6e53841cbcd8");
        Token token = weixin.getToken();
        System.out.println(token.getAccess_token());

/*        Jedis resource = jedisPool.getResource();
        resource.set("22","11111111110");*/
        return token.getAccess_token();
    }
    @GetMapping("index")
    public String getData() {
        log.info("开始获取数据");
        log.info("Count:{}",jdbcTemplate.queryForObject("select count(*) as countt from T_ETC_CAR", long.class));
        log.info("Count:111",jdbcTemplate.queryForObject("select count(*) as countt from T_ETC_CAR", long.class));
        return "";
    }

    @GetMapping("jps")
    public List<Product> jps() {
        log.info("开始获取数据");
        List<Product> all = testService.findAll();

        return all;
    }

    @GetMapping("redis")
    public List<Product> redis(String name) {
        log.info("开始获取数据");
        List<String> list = new ArrayList<>();
        list.add("大哥");
        List<Product> list1 = testService.list(list);
        return list1;
       // testService.redidHashCache(name);
        //return null;
    }

    @GetMapping("cache")
    public Long cache(String name) throws Exception {
        log.info("开始获取数据");
        Long list1 = testService.findAlls();
        return list1;
        // testService.redidHashCache(name);
        //return null;
    }
    @GetMapping("caches/{name}")
    public Long caches(@PathVariable  String name , @MatrixVariable(pathVar = "p") String p) throws Exception {
        log.info("开始获取数据");
        Long list1 = testService.findAlls();
        return list1;
    }

    @RequestMapping(value = "/m2/pets/{petId}", method = RequestMethod.GET)
    public String findPet2(@PathVariable String petId, @MatrixVariable int q) {
        System.out.println("petId:"+petId);
        System.out.println("q:"+q);
        return "user_list";
    }

    @PostMapping("model")
    public ActionResult model(@RequestBody @Valid ModelAndViewEntity modelAndViewEntity, BindingResult bd) {
        return new ActionResult();
    }

    /**
     * 相当于302 跳转
     * @return
     */
    @GetMapping("red")
    public String red() {
        return "redirect:"+"http://www.baidu.com";
    }
    @GetMapping("for1")
    public void for1(HttpServletResponse response) throws IOException {

        response.sendRedirect("http://www.baidu.com");
    }

    @GetMapping(value = "json", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Product adddd(HttpServletRequest request){
        String header = request.getHeader("token");
        Product re = new Product();
        re.setName("11111111111");
        re.setCreateTime(new Date());
        re.setId(10098L);
        return re;
    }

    @GetMapping("getUrl")
    public ActionResult getUrl() {
        ActionResult actionResult = new ActionResult();

        URI url = UriComponentsBuilder.fromUriString("http://127.0.0.1:1001/weixin/json").encode().build("");
      //   Product forObject = restTemplate.getForObject(url, Product.class);




        String uuuu = "http://127.0.0.1:1001/weixin/json";


        RequestEntity<Void> requestEntity = RequestEntity.get(url).header("token","123").build();

        ResponseEntity<Product> responseEntity = restTemplate.exchange(requestEntity, Product.class);

        Product body = responseEntity.getBody();
        System.out.println("body=======****=========="+body);

        String header = responseEntity.getHeaders().getFirst("token");

        System.out.println("header=======*****========="+header);

       // Product forObject1 = restTemplate.getForObject(u, Product.class);

        //System.out.println(forObject1);


        //list的时候要做特别的处理
        ParameterizedTypeReference<List<Product>> ptr = new ParameterizedTypeReference<List<Product>>() {
        };

        ResponseEntity<List<Product>> list = restTemplate.exchange(uuuu, HttpMethod.GET, null, ptr);

        return new ActionResult();
    }

/*
    @GetMapping(value = "js", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Product> addddq(){
        Product re = new Product();re.setName("11111111111");re.setCreateTime(new Date());re.setId(10098L);
        return ResponseEntity.ok().body(re);
    }
*/

    @GetMapping("exce")
    public String exce() {
        throw  new JgpException("我是真的错了啊 ", 10086);
    }

    @GetMapping("gprc")
    public String gprc() {
        throw  new JgpException("我是真的错了啊 ", 10086);
    }
}
