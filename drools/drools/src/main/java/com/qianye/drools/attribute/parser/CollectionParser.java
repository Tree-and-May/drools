package com.qianye.drools.attribute.parser;

import com.qianye.drools.attribute.parser.expression.CollectionExpressionEnum;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 集合解析器
 */
@Data
public class CollectionParser extends BaseParser {
    private Set<String> attributeValue;
    private CollectionExpressionEnum expression;

    @Override
    protected ParseTypeEnum support() {
        return ParseTypeEnum.COLLECTION;
    }

    /**
     *  CollectionParser(attributeName=="国家" && ((attributeValue contains "中国")||(attributeValue contains "印度")))
     *
     * @return
     */
    @Override
    public String buildAttributeCondition() {

        return new StringBuilder(CommonUtil.appendClassName(this.getClass()))
                .append(Constants.LEFT_BRACKET)
                .append(CommonUtil.appendAttributeName(this.getAttributeName()))
                .append(Constants.BLANK)
                .append(Constants.AND)
                .append(Constants.BLANK)
                .append(Constants.LEFT_BRACKET)
                .append(appendMultiValue())
                .append(Constants.RIGHT_BRACKET)
                .append(Constants.RIGHT_BRACKET)
                .toString();

    }

    private String appendMultiValue() {
        Set<String> values = this.getAttributeValue();
        List<StringBuilder> valueCondition = new ArrayList<>();
        for (String value : values) {
            valueCondition.add(new StringBuilder()
                    .append(Constants.ATTRIBUTE_VALUE)
                    .append(Constants.BLANK)
                    .append(this.getExpression().getExpression())
                    .append(Constants.BLANK)
                    .append(Constants.QUOTATION)
                    .append(value)
                    .append(Constants.QUOTATION));
        }
        return valueCondition.stream().map(data ->
                        new StringBuilder(Constants.LEFT_BRACKET)
                                .append(data)
                                .append(Constants.RIGHT_BRACKET))
                .collect(Collectors.joining(Constants.OR));

    }
}
