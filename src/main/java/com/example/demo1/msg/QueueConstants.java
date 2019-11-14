package com.example.demo1.msg;

public interface QueueConstants {

    // 消息交换
    String MESSAGE_EXCHANGE = "my-mq-exchange_A";
    // 消息队列名称
    String MESSAGE_QUEUE_NAME = "QUEUE_A";
    // 消息路由键
    String MESSAGE_ROUTE_KEY = "spring-boot-routingKey_A";

    // 死信消息交换
    String MESSAGE_EXCHANGE_DL = "message.direct.dlexchange";
    // 死信消息队列名称
    String MESSAGE_QUEUE_NAME_DL = "message.dlqueue";
    // 死信消息路由键
    String MESSAGE_ROUTE_KEY_DL = "message.dlroute";
}

