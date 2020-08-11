package com.geekmake.groovy.rules.enums;

/**
 * 风控模式
 * @author pez1420@gmail.com
 * @version $Id: RiskModeEnum.java v 0.1 2020/7/29 9:44 下午 pez1420 Exp $$
 */
public enum RiskModeEnum {
    ASYN("asyn", "异步"),

    SYN("syn", "同步");

    /** 类型*/
    private String value;

    /** 描述 */
    private String message;

    RiskModeEnum(String value, String message) {
        this.value = value;
        this.message = message;
    }

    /**
     * Getter for property 'value'.
     *
     * @return value Value for property 'value'.
     */
    public String getValue() {
        return value;
    }

    /**
     * Getter for property 'message'.
     *
     * @return message Value for property 'message'.
     */
    public String getMessage() {
        return message;
    }
}
