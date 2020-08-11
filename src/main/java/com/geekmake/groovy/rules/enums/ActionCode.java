package com.geekmake.groovy.rules.enums;

/**
 * @author pez1420@gmail.com
 * @version $Id: ActionCode.java v 0.1 2020/7/29 9:55 下午 pez1420 Exp $$
 */
public enum ActionCode {

    FAIL("11000", "补贴失败");

    /** 类型*/
    private String value;

    /** 描述 */
    private String message;

    ActionCode(String value, String message) {
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
