package com.qianye.drools.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 描述：动作参数信息
 * 引入变量（paramIdentify）
 * CLASSPATH: com.sky.lli.model.BaseRuleActionParamInfo
 * VERSION:   1.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class BaseRuleActionParamInfo extends BaseModel {
    private Long actionParamId;//主键
    private Long actionId;//动作id
    private String actionParamName;//参数名称(中文名称)
    private String actionParamDesc;//参数描述
    private String paramIdentify;//标识(引入变量)
}
