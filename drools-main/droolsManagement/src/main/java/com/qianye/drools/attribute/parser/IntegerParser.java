package com.qianye.drools.attribute.parser;

import com.qianye.drools.attribute.parser.expression.IntegerExpressionEnum;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 整形，长整形解析
 */
@Data
public class IntegerParser extends BaseParser{
    private BigDecimal attributeValue;
    private IntegerExpressionEnum expression;

    @Override
    protected ParseTypeEnum support() {
        return ParseTypeEnum.INTEGER;
    }

    @Override
    public String buildAttributeCondition() {
        String className = this.getClass().getSimpleName();
        StringBuilder builder = new StringBuilder(Character.toUpperCase(className.charAt(0))
                + className.substring(1));
        StringBuilder attributeCondition = builder.append(Constants.LEFT_BRACKET)
                .append(Constants.ATTRIBUTE_NAME)
                .append(Constants.EQUAL)
                .append(Constants.QUOTATION)
                .append(this.getAttributeName())
                .append(Constants.QUOTATION)
                .append(Constants.BLANK)

                .append(Constants.AND)
                .append(Constants.BLANK)

                .append(Constants.ATTRIBUTE_VALUE)
                .append(this.getExpression().getExpression())
                .append(this.getAttributeValue())

                .append(Constants.RIGHT_BRACKET);

        return attributeCondition.toString();
    }
}
