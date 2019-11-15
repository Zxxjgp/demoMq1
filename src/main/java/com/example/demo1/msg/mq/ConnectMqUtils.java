package com.example.demo1.msg.mq;

import com.rabbitmq.client.*;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author jiaoguanping
 * @version 1.0.0
 * @ClassName ConnectMqUtils
 * @date 2019/11/13  17:38
 */
public class ConnectMqUtils {

    public static Connection getConnect() throws IOException, TimeoutException {
        ConnectionFactory factory =new ConnectionFactory();
        factory.setHost("192.168.1.219");
        factory.setPort(5672);
        factory.setVirtualHost("/jgp_db");

        factory.setUsername("admin");
        factory.setPassword("admin");

        return factory.newConnection();

    }
}
