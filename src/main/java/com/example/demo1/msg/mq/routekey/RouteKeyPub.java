package com.example.demo1.msg.mq.routekey;

import com.example.demo1.msg.mq.ConnectMqUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author jiaoguanping
 * @version 1.0.0
 * @ClassName
 * @date 2019/11/14  16:34
 */
public class RouteKeyPub {

    public static String EXCHAGE_NAME = "test_direct_exchange_diret";

    public static String ROUTE_KEY = "info";
    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connect = ConnectMqUtils.getConnect();
        //从连接中获取渠道
        Channel channel = connect.createChannel();

        //声名交换机
        channel.exchangeDeclare(EXCHAGE_NAME,"direct");

        //fanout 不处理路由键，只需要将消息发送到队列（）这个时候就会将信息发送给和交换机绑定的所有队列



        String str = "my name is  tsest rabbit mq";

        channel.basicPublish(EXCHAGE_NAME, ROUTE_KEY,null, str.getBytes());

        channel.close();
        connect.close();
    }

}
