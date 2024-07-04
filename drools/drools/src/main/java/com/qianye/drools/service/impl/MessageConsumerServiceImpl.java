package com.qianye.drools.service.impl;

import com.qianye.drools.model.MessageInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

/**
 * MQ-消息消费者 Service实现类
 */
@RocketMQMessageListener(topic = "RocketMQ-drools",consumerGroup = "${rocketmq.consumer.group}")
@Component
@Slf4j
public class MessageConsumerServiceImpl implements RocketMQListener<MessageInfo> {

    /**
     * 接收消息
     * @param messageInfo
     */
    @Override
    public void onMessage(MessageInfo messageInfo) {
        log.info("收到消息...");
        System.out.println(messageInfo.toString());
    }
}
