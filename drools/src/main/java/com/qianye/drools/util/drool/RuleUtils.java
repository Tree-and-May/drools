package com.qianye.drools.util.drool;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 描述：规则工具类
 * CLASSPATH: com.sky.bluesky.util.RuleUtils
 * VERSION:   1.0
 */
public class RuleUtils {

    private RuleUtils() {
    }

    /**
     * 字符串为 null 或者为  "" 时返回 true
     */
    private static boolean isEmpty(String str) {
        return str == null || "".equals(str.trim());
    }

    /**
     * 字符串不为 null 而且不为  "" 时返回 true
     */
    private static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }

    /**
     * <p>
     * 方法说明: 截取两个$之间的内容
     *
     * @param str 字符串
     */
    public static List<String> getConditionParamBetweenChar(String str) {

        Matcher m = Pattern.compile("\\$(.*?)\\$").matcher(str);
        List<String> list = new ArrayList<>();
        while (m.find()) {
            list.add(m.group(1));
        }
        return list;
    }

    /**
     * <p>
     * 方法说明:截取两个@之间的内容
     */
    public static List<String> getValueBetweenChar(String str) {

        Matcher m = Pattern.compile("\\@(.*?)\\@").matcher(str);
        List<String> list = new ArrayList<>();
        while (m.find()) {
            list.add(m.group(1));
        }
        return list;
    }

    /**
     * <p>
     * 方法说明: 截取两个#之间的内容
     */
    public static List<String> getActionParamBetweenChar(String str) {
        Matcher m = Pattern.compile("\\#(.*?)\\#").matcher(str);
        List<String> list = new ArrayList<>();
        while (m.find()) {
            list.add(m.group(1));
        }
        return list;
    }

    /**
     * <p>
     * 方法说明: 截取指定符号之间的内容(例如: #或者*等 )
     */
    public static List<String> getParamBetweenChar(String str, String charStr) {
        //获取正则表达式
        String preg = "\\₩(.*?)\\₩".replaceAll("₩", charStr);
        Matcher m = Pattern.compile(preg).matcher(str);
        List<String> list = new ArrayList<>();
        while (m.find()) {
            list.add(m.group(1));
        }
        return list;
    }

    /**
     * <p>
     * 方法说明: 如果是整数或者小数，则返回true，否则返回false
     */
    public static boolean checkStyleOfString(String str) {
        return str.matches("^(\\-|\\+)?\\d+(\\.\\d+)?$");
    }

    /**
     * <p>
     * 方法说明:得到 > >= < <= == != 后面的字符串
     */
    public static String getConditionOfVariable(String str) {

        String[] arr = str.split(">(=)?|<(=)?|={1,2}|!=");
        if (arr.length < 2) {
            return "";
        }
        return arr[1];
    }

    /**
     * <p>
     * 方法说明:检查是否包含 + - × / % 如果包含返回true
     */
    public static boolean checkContainOfOperator(String str) {
        return str.contains("+") || str.contains("-") || str.contains("*") ||
                str.contains("/") || str.contains("%");
    }

    /**
     * <p>
     * 方法说明:判断当前字符串是否包含指定符号(charStr)信息,如果包含返回true
     */
    public static boolean checkContainOfOperator(String str, String charStr) {
        return str.contains(charStr);
    }

    /**
     * <p>
     * 方法说明: 根据属性得到其get方法名
     */
    public static String getMethodByProperty(String property) {
        //为防止原参数发生变化，此处单独创建变量接收
        String tempStr = property;
        if (RuleUtils.isNotEmpty(property)) {
            tempStr = tempStr.substring(0, 1).toUpperCase() + tempStr.substring(1);
            return "get" + tempStr + "()";
        }
        return null;
    }

    /**
     * <p>
     * 方法说明: 根据属性得到其set方法名
     */
    public static String setMethodByProperty(String property) {
        //为防止原参数发生变化，此处单独创建变量接收
        String tempStr = property;
        if (RuleUtils.isNotEmpty(property)) {
            tempStr = tempStr.substring(0, 1).toUpperCase() + tempStr.substring(1);
            return "set" + tempStr;
        }
        return null;
    }
}
