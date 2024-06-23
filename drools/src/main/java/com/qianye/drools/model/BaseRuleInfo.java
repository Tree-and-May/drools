package com.qianye.drools.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;



/**
 * 描述：规则信息
 * CLASSPATH: com.sky.lli.model.BaseRuleInfo
 * VERSION:   1.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class BaseRuleInfo extends BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ruleId;//主键
    private Long sceneId;//场景
    private String ruleName;//名称
    private String ruleDesc;//描述
    private Integer ruleEnabled;//是否启用
}
