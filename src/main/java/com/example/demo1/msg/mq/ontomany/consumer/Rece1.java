package com.example.demo1.msg.mq.ontomany.consumer;

import com.example.demo1.msg.mq.ConnectMqUtils;
import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author jiaoguanping
 * @version 1.0.0
 * @ClassName Rece1
 * @date 2019/11/13  18:58
 */
public class Rece1 {
    public static String QUEUEU_NAME = "queue_jgp";

    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connect = ConnectMqUtils.getConnect();
        //从连接中获取渠道
        Channel channel = connect.createChannel();

        // 消息队列已经定义好了就不允许在进行任何的修改
        boolean durable = true; //消息是否持久化到内从中（true 持久化  false 否）


        //创建队列申明
        channel.queueDeclare(QUEUEU_NAME, durable, false, false, null);

        /**
         * 消息的持久化
         * 声明队列
         * channel.queueDeclare(QUEUEU_NAME, false, false, false, null);
         *
         */

        channel.basicQos(1); //保证每次只发一个

        //给同一个消费者每次只能发送一个消息
        //每个消费者发送确认消息之前 消息消息队列不发下一个哥消息到消费者，一次只处理一个消息（限制发送给同一个消费者的消息不能超过一条）
        channel.basicQos(1);
        //事件模型
        //消息进入队列里面
        DefaultConsumer consumer= new DefaultConsumer(channel){

            //获取到达的消息
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body)
                    throws IOException {

                //super.handleDelivery(consumerTag, envelope, properties, body);
                String s = new String(body);

                System.out.println("receive:"+s);

                //手动返回值高速消费者我已经收到消息了（可以公平分发）
                channel.basicAck(envelope.getDeliveryTag() , false);


            }
        };

        //是否关闭自动应答（true 如果消费者端挂了，消息就会删除）
        //false 返回给生产者说消息可以删除了，
        //消息应答默认是打开的 askQus = true
        boolean askQus = false;

        //mq的消息存储在内从中

        //如果mq服务器挂了，消息就没有了，解决办法， 支持持久化，写入磁盘



        //监听队列（事件队列）
        channel.basicConsume(QUEUEU_NAME,askQus,consumer);
    }
}
