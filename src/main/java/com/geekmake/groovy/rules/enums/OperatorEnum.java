package com.geekmake.groovy.rules.enums;

import com.geekmake.groovy.rules.utils.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * 操作符枚举类
 * <ul>
 *      <li>
 *          1、数值运算的操作符 ：等于(==/EQUAL), 大于(>/GREATER)， 小于（</LESS）,不等于(!=),大于等于（>=）,小于等于（<=）；
 *      </li>
 *      <li>
 *          2、字符串运算的操作符： 包含（CONTAINS）、不包含（NOT CONTAINS）、字符串相等（STRING_EQUAL）、字符串不等（NOTSTRING_EQUAL）、不区分大小写的字符串等于（EQUAL_IGNORE_CASE），
 *          不区分大小写的字符串不等（NOT_EQUAL_IGNORE_CASE）、匹配（MATCHES）、不匹配（NOT_MATCHES）
 *      </li>
 *  </ul>
 * @author pez1420@gmail.com
 * @version $Id: OperatorEnum.java v 0.1 2020/7/29 9:15 下午 pez1420 Exp $$
 */
public enum OperatorEnum {
    EQ("==","等于", 1),
    GT(">","大于", 1),
    LT("<","小于",1),
    GTE(">=","大于等于", 1),
    LTE("<=","小于等于", 1),
    UNEQ("!=","不等于", 1),
    NOT("!","取反", 1),
    STRING_EQUAL("STRING_EQUAL", "字符串相等", 2),
    NOTSTRING_EQUAL("NOTSTRING_EQUAL", "字符串不等",2),
    CONTAINS("CONTAINS", "包含", 2),
    NOT_CONTAINS("NOT_CONTAINS", "不包含", 2),
    EQUAL_IGNORE_CASE("EQUAL_IGNORE_CASE", "不区分大小写的字符串等于", 2),
    NOT_EQUAL_IGNORE_CASE("NOT_EQUAL_IGNORE_CASE", "不区分大小写的字符串不等", 2),
    MATCHES("MATCHES", "正则匹配", 2),
    NOT_MATCHES("NOT_MATCHES", "正则不匹配", 2 );
    
    /** 缓存MAP */
    private static final Map<String, OperatorEnum> OPERATOR_MAP = new HashMap<>();

    /** 数学运算符号 */
    private static final Map<String, OperatorEnum> OPERATOR_MATH_MAP = new HashMap<>();

    /** 字符串运算符号 */
    private static final Map<String, OperatorEnum> OPERATOR_STR_MAP = new HashMap<>();


    static{
        OperatorEnum[] arr = OperatorEnum.values();
        for (int i = 0, len = arr.length;  i < len; i++) {
            OperatorEnum item = arr[i];
            if (item.category == 1) {
                OPERATOR_MATH_MAP.put(item.getType(), item);
            } else if (item.category == 2) {
                OPERATOR_STR_MAP.put(item.getType(), item);
            }
        }
        OPERATOR_MAP.putAll(OPERATOR_MATH_MAP);
        OPERATOR_MAP.putAll(OPERATOR_STR_MAP);
    }

    /** 操作符 */
    private String type;

    /** 名称 */
    private String name;

    /** 种类 */
    private int category;

    OperatorEnum(String type, String name, int category) {
        this.type = type;
        this.name = name;
        this.category = category;
    }

    public static OperatorEnum getInstance(String type) {
        for (OperatorEnum item : values()) {
            if (type.equals(item.getType())) {
                return item;
            }
        }
        return null;
    }

    public static OperatorEnum getOperatorEnum(String type){
        if(StringUtils.isBlank(type)){
            throw new IllegalArgumentException("type不能为空！");
        }
        if ( OPERATOR_MAP.containsKey(type)){
            return OPERATOR_MAP.get(type);
        }

        throw new IllegalArgumentException(String.format("枚举类OperatorEnum对应枚举不存在【%s】！", type));
    }


    /**
     * Getter for property 'type'.
     *
     * @return type Value for property 'type'.
     */
    public String getType() {
        return type;
    }

    /**
     * Getter for property 'name'.
     *
     * @return name Value for property 'name'.
     */
    public String getName() {
        return name;
    }

    /**
     * Getter for property 'category'.
     *
     * @return category Value for property 'category'.
     */
    public int getCategory() {
        return category;
    }
}
