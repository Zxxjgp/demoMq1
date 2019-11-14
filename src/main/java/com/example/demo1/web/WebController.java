package com.example.demo1.web;

import com.example.demo1.core.ActionResult;
import com.example.demo1.msg.MessageProducer;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * @author jiaoguanping
 * @version 1.0.0
 * @ClassName WebController
 * @date 2019/10/30  15:53
 */
@Controller
@RequestMapping("wx")
public class WebController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private MessageProducer messageProducer;

    @GetMapping("/message/{msg}")
    public ActionResult postMessage(@PathVariable String msg) {

        rabbitTemplate.convertAndSend("exchangeA","routingKeyA","qqqqqqqqqqqqqqqqqq");
        return new ActionResult();
    }


    @GetMapping("html")
    public String html(){
        return "index";
    }

    @GetMapping("session")
    @ResponseBody
    public ActionResult printSession(HttpSession session, String name) {
        String n = (String) session.getAttribute("name");
        if ( n == null ) {
            session.setAttribute("name", name);
            n =name;
        }
        return new ActionResult(n);
    }



    @RequestMapping(value = "/index")
    public String index(String str) {
        // 将实体实例写入消息队列
        messageProducer.sendMessage(str);
        return "Success";
    }

    @RequestMapping(value = "/index2")
    public String in2dex(String str) {
        // 将实体实例写入消息队列
        messageProducer.sendMessage(str);
        return "Success";
    }

}
