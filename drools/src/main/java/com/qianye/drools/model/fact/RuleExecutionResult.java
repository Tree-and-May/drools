package com.qianye.drools.model.fact;

import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 描述：规则全局对象
 * CLASSPATH: com.sky.lli.model.fact.RuleExecutionResult
 * VERSION:   1.0
 */
@Data
public class RuleExecutionResult implements Serializable {

    //规则执行中需要保存的数据
    private Map<String,Object> map = new HashMap<>();
}
