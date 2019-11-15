package com.example.demo1.msg.mq.transaction;

import com.example.demo1.msg.mq.ConnectMqUtils;
import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author jiaoguanping
 * @version 1.0.0
 * @ClassName TransactionRev1
 * @date 2019/11/15  8:56
 */
public class TransactionRev1 {

    private static final String QUEUE_NAME = "queueue_transaction";
    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connect = ConnectMqUtils.getConnect();
        Channel channel = connect.createChannel();
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);

        channel.basicQos(1);
        channel.basicConsume(QUEUE_NAME, false, new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                // super.handleDelivery(consumerTag, envelope, properties, body);

                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(new String(body));
            }
        });
/*
        channel.close();
        connect.close();*/

    }
}
