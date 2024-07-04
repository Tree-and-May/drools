package com.qianye.drools.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.Positive;


/**
 * 管理态 发送给MQ的消息信息
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class MessageInfo {
    private Long ruleId;//规则ID

    @Positive(message = "场景 ID 必须是正整数")
    private Long sceneId;//场景ID

    private MessaeTypeEnum messageType; //消息类型
}
