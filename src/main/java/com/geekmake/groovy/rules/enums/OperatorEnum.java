package com.geekmake.groovy.rules.enums;

import com.geekmake.groovy.rules.utils.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * 操作符枚举类
 *
 * @author pez1420@gmail.com
 * @version $Id: OperatorEnum.java v 0.1 2020/7/29 9:15 下午 pez1420 Exp $$
 */
public enum OperatorEnum {
    EQ("==","等于"),
    GT(">","大于"),
    LT("<","小于"),
    GTE(">=","大于等于"),
    LTE("<=","小于等于"),
    UNEQ("!=","不等于"),
    NOT("!","取反");

    /** 缓存MAP */
    private static final Map<String, OperatorEnum> OPERATOR_MAP = new HashMap<>();

    static{
        OperatorEnum[] arr = OperatorEnum.values();
        for (int i = 0, len = arr.length;  i < len; i++) {
            OperatorEnum item = arr[i];
            OPERATOR_MAP.put(item.getType(), item);
        }
    }

    /** 操作符 */
    private String type;

    /** 名称 */
    private String name;

    OperatorEnum(String type, String name) {
        this.type = type;
        this.name = name;
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
}
