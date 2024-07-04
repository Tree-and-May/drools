package com.qianye.drools.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;


/**
 * 描述：规则信息
 * CLASSPATH: com.sky.lli.model.BaseRuleInfo
 * VERSION:   1.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class BaseRuleInfo extends BaseModel {
    private Long ruleId;//主键

    @Positive(message = "场景 ID 必须是正整数")
    private Long sceneId;//场景

    @NotBlank(message = "规则名称不能为空")
    private String ruleName;//名称

    @NotBlank(message = "规则描述不能为空")
    private String ruleDesc;//描述

    @Positive(message = "必须是1(启用)/0(未启用)")
    private Integer ruleEnabled;//是否启用
}
