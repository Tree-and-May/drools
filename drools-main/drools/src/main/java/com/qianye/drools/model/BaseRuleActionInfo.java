package com.qianye.drools.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 描述：规则动作定义信息
 * CLASSPATH: com.sky.lli.model.BaseRuleActionInfo
 * VERSION:   1.0
 */
@Data
@EqualsAndHashCode(callSuper = false)  // 能自动生成equals()和hashCode()方法的实现代码，false：不考虑父类字段
public class BaseRuleActionInfo extends BaseModel {

    private Long actionId;//主键

    private Integer actionType;//动作类型
    /*
    =1：实现动作类 -> 比如复杂的数学计算
    =2：测试自身类 -> 比如变量赋值 （现阶段主要）
     */

    private String actionName;//动作名称
    private String actionDesc;//动作描述
    private String actionClass;//动作实现类

    /**
     * 获取实体标识(例如：com.sky.lli.model.TestRule  最后得到 testRule)
     */
    public String getActionClazzIdentify() {
        int index = actionClass.lastIndexOf('.');
        return actionClass.substring(index + 1).substring(0, 1).toLowerCase() +
                actionClass.substring(index + 1).substring(1);
    }
}
