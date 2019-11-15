package com.example.demo1.msg.mq.confirm.yibu;

import com.example.demo1.msg.mq.ConnectMqUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.ConfirmListener;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.Collections;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.TimeoutException;

/**
 * @author jiaoguanping
 * @version 1.0.0
 * @ClassName ConfirmSend
 * @date 2019/11/15  10:41
 */
public class ConfirmSend {
    private static final String QUEUE_NAME = "queueue_confirm_5";

    public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {
        Connection connect = ConnectMqUtils.getConnect();
        Channel channel = connect.createChannel();
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);

        //将channel设置为confirm模式
        channel.confirmSelect();

        final SortedSet<Long> confirmSet = Collections.synchronizedSortedSet(new TreeSet<Long>());

        String msg = "hello word -------- confirm——异步消息啊";

        //监听通道
        channel.addConfirmListener(new ConfirmListener() {

            //这个是成功的
            @Override
            public void handleAck(long l, boolean b) throws IOException {

                //成功的回调函数
                if ( b ) {
                    System.out.println("222222222222222222-------handleAck------ multiple -- success");
                    confirmSet.headSet(l+1).clear();
                } else {
                    System.out.println("222222222222222222-------handleAck------ multiple -- fail ");
                    confirmSet.remove(l);
                }
            }

            //这个是失败
            @Override
            public void handleNack(long l, boolean b) throws IOException {
                if ( b ) {
                    System.out.println("111111111111-------handleAck------ multiple -- success");
                    confirmSet.headSet(l+1).clear();
                } else {
                    System.out.println("1111111111111-------handleAck------ multiple -- fail ");
                    confirmSet.remove(l);
                }
            }
        });

        while (true) {
            long seqNo = channel.getNextPublishSeqNo();
            channel.basicPublish("", QUEUE_NAME, null, msg.getBytes());
            confirmSet.headSet(seqNo);
        }
    }
}
