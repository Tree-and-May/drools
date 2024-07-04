package com.qianye.drools.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 描述：
 * CLASSPATH: com.sky.lli.model.BaseModel
 * VERSION:   1.0
 */
@Data
public class BaseModel implements Serializable {
    //创建人
    private Long creUserId = 1l;
    //创建时间
    private Date creTime = new Date();
    //是否有效
    private Integer isEffect = 1;
    //备注
    private String remark;
}
