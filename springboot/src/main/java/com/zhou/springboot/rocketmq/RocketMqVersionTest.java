package com.zhou.springboot.rocketmq;

import com.zhou.springboot.dao.VersionBiz;
import java.io.UnsupportedEncodingException;
import java.util.List;
import lombok.SneakyThrows;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.apache.rocketmq.spring.autoconfigure.RocketMQProperties;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//幂等测试
@Component
public class RocketMqVersionTest {

    @Autowired
    private RocketMQProperties rocketMQProperties;

    @Autowired
    private VersionBiz versionBiz;

    @Test
    public void produceMessage() throws Exception {
        DefaultMQProducer producer = new DefaultMQProducer("version_group");
        producer.setNamesrvAddr("127.0.0.1:9876");
        producer.start();

        for (int i = 0; i < 1000; i++) {
            producer.send(new Message("VersionTopic", String.valueOf(i).getBytes(RemotingHelper.DEFAULT_CHARSET)));
        }

    }

    public void consumeMessage() throws MQClientException {
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("version_consume_group");

        consumer.setNamesrvAddr("127.0.0.1:9876");
        consumer.subscribe("VersionTopic", "*");
        consumer.setMessageListener(new MessageListenerConcurrently() {
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
                String s = null;
                try {
                    s = new String(msgs.get(0).getBody(), "UTF-8");
                } catch (UnsupportedEncodingException e) {
                }
//                versionBiz.test(s);
                versionBiz.testVersion(s);
                System.out.println("收到消息：" + s);
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });

        consumer.start();
    }


}
