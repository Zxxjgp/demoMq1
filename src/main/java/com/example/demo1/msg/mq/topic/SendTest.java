package com.example.demo1.msg.mq.topic;

import com.example.demo1.msg.mq.ConnectMqUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author jiaoguanping
 * @version 1.0.0
 * @ClassName SendTest
 * @date 2019/11/14  20:03
 */
public class SendTest {

    private static final String EXCHANGE_NAME = "text_exchange_topic";

    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connect = ConnectMqUtils.getConnect();
        Channel channel = connect.createChannel();

        channel.exchangeDeclare(EXCHANGE_NAME,"topic");

        String str = "我是商品信息====================";

        //发布消息
        channel.basicPublish(EXCHANGE_NAME, "goods.add",null, str.getBytes());
        System.out.println("send");
        channel.close();
        connect.close();
    }
}
