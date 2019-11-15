package com.example.demo1.msg.mq.confirm.putong;

import com.example.demo1.msg.mq.ConnectMqUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author jiaoguanping
 * @version 1.0.0
 * @ClassName ConfirmSend
 * @date 2019/11/15  10:41
 */
public class ConfirmSend {

    private static final String QUEUE_NAME = "queueue_confirm_1";

    public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {
        Connection connect = ConnectMqUtils.getConnect();
        Channel channel = connect.createChannel();
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);

        //将channel设置为confirm模式
        channel.confirmSelect();

        String msg = "hello word -------- confirm——普通模式";
        channel.basicPublish("",QUEUE_NAME, null , msg.getBytes());
        if ( !channel.waitForConfirms()) {
            System.out.println("messgae send fail");
        } else {
            System.out.println("messgae send success");
        }

        channel.close();
        connect.close();
    }
}
