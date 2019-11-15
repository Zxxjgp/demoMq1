package com.example.demo1.msg.mq.transaction;

import com.example.demo1.msg.mq.ConnectMqUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author jiaoguanping
 * @version 1.0.0
 * @ClassName TransactionSend
 * @date 2019/11/15  8:56
 */
public class TransactionSend {

    private static final String QUEUE_NAME = "queueue_transaction";

    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connect = ConnectMqUtils.getConnect();
        Channel channel = connect.createChannel();
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);

        String msg = "hello word -------- transactw11w1ion";

        try {
            channel.txSelect();
            channel.basicPublish("",QUEUE_NAME, null , msg.getBytes());
            channel.txCommit();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("事务已经回滚了，消息回滚了哈");
            channel.txRollback();
        } finally {
            channel.close();
            connect.close();
        }


    }
}
