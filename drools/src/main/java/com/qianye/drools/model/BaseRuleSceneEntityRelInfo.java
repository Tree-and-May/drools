package com.qianye.drools.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 描述：
 * CLASSPATH: com.sky.lli.model.BaseRuleSceneEntityRelInfoMapper
 * VERSION:   1.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class BaseRuleSceneEntityRelInfo extends BaseModel {

    private Long sceneEntityRelId;//主键
    private Long sceneId;//场景id
    private Long entityId;//实体
}
