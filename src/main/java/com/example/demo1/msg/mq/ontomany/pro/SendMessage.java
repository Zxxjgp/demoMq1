package com.example.demo1.msg.mq.ontomany.pro;

import com.example.demo1.msg.mq.ConnectMqUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author jiaoguanping
 * @version 1.0.0
 * @ClassName SendMessage
 * @date 2019/11/13  18:53
 */
public class SendMessage {
    public static String QUEUEU_NAME = "queue_jgp";

    public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {
        Connection connect = ConnectMqUtils.getConnect();
        //从连接中获取渠道
        Channel channel = connect.createChannel();
        //创建队列申明
        channel.queueDeclare(QUEUEU_NAME, false, false, false, null);

        String str = "my name is jgp1";

        for (int i =0 ; i< 50 ; i++) {
            str=str+i;
            channel.basicPublish("", QUEUEU_NAME,null, str.getBytes());
            Thread.sleep(i*20);
        }

        channel.close();
        connect.close();
    }
}
