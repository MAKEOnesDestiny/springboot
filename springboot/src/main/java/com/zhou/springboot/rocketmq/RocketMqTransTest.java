package com.zhou.springboot.rocketmq;

import com.zhou.springboot.bean.TimeOut;
import com.zhou.springboot.dao.TimeOutMapper;
import java.io.UnsupportedEncodingException;
import java.util.Random;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.LocalTransactionState;
import org.apache.rocketmq.client.producer.TransactionListener;
import org.apache.rocketmq.client.producer.TransactionMQProducer;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.apache.rocketmq.spring.autoconfigure.RocketMQProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class RocketMqTransTest {

    @Autowired
    private RocketMQProperties rocketMQProperties;

    @Autowired
    private TimeOutMapper timeOutMapper;

    @Autowired
    private RocketMqTransTest rocketMqTransTest;

    public void test()
            throws MQClientException, RemotingException, InterruptedException, MQBrokerException, UnsupportedEncodingException {
        int id = new Random().nextInt();

        DefaultMQProducer producer = new TransactionMQProducer("transaction_group");
        producer.setNamesrvAddr(rocketMQProperties.getNameServer());
        ((TransactionMQProducer) producer).setTransactionListener(new TransactionListener() {
            @Override
            public LocalTransactionState executeLocalTransaction(Message message, Object o) {
                System.out.println("执行本地事务");
                return LocalTransactionState.UNKNOW;
            }

            @Override
            public LocalTransactionState checkLocalTransaction(MessageExt messageExt) {
                TimeOut timeOut = timeOutMapper.selectByPrimaryKey(id);
                if (timeOut != null) {
                    //事务成功
                    System.out.println("回查成功,消息提交");
                    return LocalTransactionState.ROLLBACK_MESSAGE;
                } else {
                    System.out.println("回查失败,消息回滚");
                    return LocalTransactionState.ROLLBACK_MESSAGE;
                }
            }
        });
        producer.start();

        producer.sendMessageInTransaction(new Message("TransactionMessage" /* Topic */,
                                                      "TagA||TagB" /* Tag */,
                                                      "Hello RocketMQ ".getBytes(RemotingHelper.DEFAULT_CHARSET)), null);

        //业务落库
//        doTrans(id);
        rocketMqTransTest.doTrans(id);
    }

    @Transactional
    public void doTrans(int id) {
        TimeOut timeOut = new TimeOut();
        timeOut.setId(id);
        timeOut.setTestName("我是name");
        timeOutMapper.insertTimeOut(timeOut);
    }



}
