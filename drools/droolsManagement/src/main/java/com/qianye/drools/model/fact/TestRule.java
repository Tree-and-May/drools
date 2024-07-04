package com.qianye.drools.model.fact;

import com.qianye.drools.model.BaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;


/**
 * 描述：
 * CLASSPATH: com.sky.lli.model.fact.TestRule
 * VERSION:   1.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class TestRule extends BaseModel {
    private String message;
    private Integer amount;
    private Integer score;
}
