package com.qianye.drools.attribute.parser;

import com.qianye.drools.attribute.parser.expression.IntegerExpressionEnum;
import com.qianye.drools.attribute.parser.expression.CollectionExpressionEnum;
import com.qianye.drools.attribute.parser.expression.StringExpressionEnum;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class ParserTest {
    private static String stringParserEqualDrl="StringParser(attributeName==\"年龄\" && attributeValue==\"18\")";
    private static String integerParserEqualDrl="IntegerParser(attributeName==\"年龄\" && attributeValue==18)";
    private static String collectionParser="CollectionParser(attributeName==\"国家\" && ((attributeValue contains \"中国\")||(attributeValue contains \"印度\")))";
    @Test
    public void StringParserEqualExpressionTest(){
        StringParser stringParser = new StringParser();
        stringParser.setAttributeName("年龄");
        stringParser.setAttributeValue("18");
        stringParser.setExpression(StringExpressionEnum.EQUAL);
        String drl = stringParser.buildAttributeCondition();
        System.out.println("stringParserEqualDrl: "+drl);
        Assert.assertTrue(stringParserEqualDrl.equals(drl));
    }
    @Test
    public void IntegerParserEqualExpressionTest(){
        IntegerParser parser = new IntegerParser();
        parser.setAttributeName("年龄");
        parser.setAttributeValue(BigDecimal.valueOf(18));
        parser.setExpression(IntegerExpressionEnum.EQUAL);
        String drl = parser.buildAttributeCondition();
        System.out.println("integerParserEqualDrl: "+drl);
        Assert.assertTrue(integerParserEqualDrl.equals(drl));
    }
    @Test
    public void CollectionParserEqualExpressionTest(){
        CollectionParser parser = new CollectionParser();
        parser.setAttributeName("国家");
        Set<String> strings = new HashSet<>();
        strings.add("中国");
        strings.add("印度");
        parser.setAttributeValue(strings);
        parser.setExpression(CollectionExpressionEnum.CONTAINS);
        String drl = parser.buildAttributeCondition();
        System.out.println("CollectionParser: "+drl);
        Assert.assertTrue(collectionParser.equals(drl));
    }
}
