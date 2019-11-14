package com.example.demo1.msg.mq.comuner;

import com.example.demo1.msg.mq.ConnectMqUtils;
import com.rabbitmq.client.*;
import com.sun.org.apache.regexp.internal.RE;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author jiaoguanping
 * @version 1.0.0
 * @ClassName GetMessage
 * @date 2019/11/13  17:58
 */
public class GetMessage {

    public static String QUEUEU_NAME = "queue_jgp";

    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connect = ConnectMqUtils.getConnect();
        //从连接中获取渠道
        Channel channel = connect.createChannel();
        //创建队列申明
        channel.queueDeclare(QUEUEU_NAME, false, false, false, null);

        //事件模型
        //消息进入队列里面
        DefaultConsumer  consumer= new DefaultConsumer(channel){

            //获取到达的消息
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body)
                    throws IOException {

                //super.handleDelivery(consumerTag, envelope, properties, body);
                String s = new String(body);

                System.out.println("receive:"+s);
            }
        };

        //监听队列（事件队列）
        channel.basicConsume(QUEUEU_NAME,true,consumer);
    }
}
