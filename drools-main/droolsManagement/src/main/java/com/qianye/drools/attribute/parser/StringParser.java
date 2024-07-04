package com.qianye.drools.attribute.parser;

import com.qianye.drools.attribute.parser.expression.StringExpressionEnum;
import lombok.Data;

/**
 * 字符型解析
 */
@Data
public class StringParser extends BaseParser{
    private String attributeValue;
    private StringExpressionEnum expression;

    @Override
    protected ParseTypeEnum support() {
        return ParseTypeEnum.STRING;
    }

    /**
     * StringParser(attributeName=="年龄" && attributeValue=="30")
     * @return
     */
    @Override
    public String buildAttributeCondition() {
        StringBuilder builder = CommonUtil.appendClassName(this.getClass());
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
                .append(Constants.QUOTATION)
                .append(this.getAttributeValue())
                .append(Constants.QUOTATION)

                .append(Constants.RIGHT_BRACKET);

        return attributeCondition.toString();
    }
}
