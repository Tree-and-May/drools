package com.qianye.drools.request;

import lombok.Data;

@Data
public class FactorRequest {
    private String attributeName;
    private String attributeValue;
    private String attributeType;
}
