package com.example.demo1.msg.mq.producer;

import com.example.demo1.msg.mq.ConnectMqUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author jiaoguanping
 * @version 1.0.0
 * @ClassName Send
 * @date 2019/11/13  17:43
 */
public class Send {
    public static String QUEUEU_NAME = "queue_jgp";

    public static void main(String[] args) throws IOException, TimeoutException {
      Connection connect = ConnectMqUtils.getConnect();
        //从连接中获取渠道
        Channel channel = connect.createChannel();
        //创建队列申明
        channel.queueDeclare(QUEUEU_NAME, false, false, false, null);

        String str = "my name is jgp";

        channel.basicPublish("", QUEUEU_NAME,null, str.getBytes());

        channel.close();
        connect.close();
    }
}
