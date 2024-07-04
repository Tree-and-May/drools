package com.qianye.drools.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 描述：
 * CLASSPATH: com.sky.lli.model.BaseRuleEntityInfo
 * VERSION:   1.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class BaseRuleEntityInfo extends BaseModel {
    private Long entityId;//主键
    private String entityName;//名称
    private String entityDesc;//描述
    private String entityIdentify;//标识
    private String pkgName;//实体包路径

    /**
     * 方法说明:获取实体类名称
     */
    public String getEntityClazz() {
        int index = pkgName.lastIndexOf('.');
        return pkgName.substring(index + 1);
    }
}
