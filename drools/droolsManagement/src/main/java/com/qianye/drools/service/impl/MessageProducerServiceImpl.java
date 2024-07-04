package com.qianye.drools.service.impl;


import com.qianye.drools.model.MessageInfo;
import com.qianye.drools.service.MessageProducerService;
import org.apache.rocketmq.spring.core.RocketMQTemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * MQ-消息生产者 Service实现类
 */
@Component("producerService")
public class MessageProducerServiceImpl implements MessageProducerService {

//    @Resource(name = "RocketMqTemplate")
    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    /**
     * 发送消息
     * @param messageInfo
     */
    @Override
    public void sendMessage(MessageInfo messageInfo) {

        rocketMQTemplate.convertAndSend("RocketMQ-drools",messageInfo);
    }
}
