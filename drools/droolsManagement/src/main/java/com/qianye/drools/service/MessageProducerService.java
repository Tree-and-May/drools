package com.qianye.drools.service;


import com.qianye.drools.model.MessageInfo;

/**
 * MQ-消息生产者 Service
 */
public interface MessageProducerService {


    /**
     * 发送消息
     */
    public void sendMessage(MessageInfo messageInfo);
}
