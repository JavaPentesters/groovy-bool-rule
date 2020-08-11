package com.geekmake.groovy.rules.model;

import com.geekmake.groovy.rules.enums.OperatorEnum;

/**
 *
 * 事实，即被判断的主体和属性，如上面规则的账号及登陆次数、IP和注册次数等；
 * 条件，判断的逻辑，如某事实的某属性大于某个指标；
 * 指标阈值，判断的依据，比如登陆次数的临界阈值，注册账号数的临界阈值等；
 *
 * @author pez1420@gmail.com
 * @version $Id: Rule.java v 0.1 2020/7/29 9:05 下午 pez1420 Exp $$
 */
public class Rule {

    private Long         id;

    /** 规则编号（1，2，3，4，5，6） */
    private Long         ruleId;

    /** 左变量 */
    private Factor       leftVar;

    /** 操作符 */
    private OperatorEnum operatorEnum;

    /** 右变量 */
    private Object       rightVar;

    /** 脚本引擎模板 */
    private String       scriptTemplate;

    /**
     * Getter for property 'id'.
     *
     * @return id Value for property 'id'.
     */
    public Long getId() {
        return id;
    }

    /**
     * Setter for property 'id'.
     *
     * @param id Value to set for property 'id'.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Getter for property 'ruleId'.
     *
     * @return ruleId Value for property 'ruleId'.
     */
    public Long getRuleId() {
        return ruleId;
    }

    /**
     * Setter for property 'ruleId'.
     *
     * @param ruleId Value to set for property 'ruleId'.
     */
    public void setRuleId(Long ruleId) {
        this.ruleId = ruleId;
    }

    /**
     * Getter for property 'leftVar'.
     *
     * @return leftVar Value for property 'leftVar'.
     */
    public Factor getLeftVar() {
        return leftVar;
    }

    /**
     * Setter for property 'leftVar'.
     *
     * @param leftVar Value to set for property 'leftVar'.
     */
    public void setLeftVar(Factor leftVar) {
        this.leftVar = leftVar;
    }

    /**
     * Getter for property 'operatorEnum'.
     *
     * @return operatorEnum Value for property 'operatorEnum'.
     */
    public OperatorEnum getOperatorEnum() {
        return operatorEnum;
    }

    /**
     * Setter for property 'operatorEnum'.
     *
     * @param operatorEnum Value to set for property 'operatorEnum'.
     */
    public void setOperatorEnum(OperatorEnum operatorEnum) {
        this.operatorEnum = operatorEnum;
    }

    /**
     * Getter for property 'rightVar'.
     *
     * @return rightVar Value for property 'rightVar'.
     */
    public Object getRightVar() {
        return rightVar;
    }

    /**
     * Setter for property 'rightVar'.
     *
     * @param rightVar Value to set for property 'rightVar'.
     */
    public void setRightVar(Object rightVar) {
        this.rightVar = rightVar;
    }

    /**
     * Getter for property 'scriptTemplate'.
     *
     * @return scriptTemplate Value for property 'scriptTemplate'.
     */
    public String getScriptTemplate() {
        return scriptTemplate;
    }

    /**
     * Setter for property 'scriptTemplate'.
     *
     * @param scriptTemplate Value to set for property 'scriptTemplate'.
     */
    public void setScriptTemplate(String scriptTemplate) {
        this.scriptTemplate = scriptTemplate;
    }
}
