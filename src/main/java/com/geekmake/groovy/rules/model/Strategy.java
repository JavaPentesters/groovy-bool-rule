package com.geekmake.groovy.rules.model;

import java.util.List;

/**
 * 策略是规则(特征)的集合，一条策略包含多条规则。每条规则定义是左变量（客户经理1天领取积分的次数）、操作符（><=）、右变量(次数)
 * 策略可以对多条规则进行任意的或与非组合。例如，某条策略包含5条规则(1、2、3、4、5)，策略= (1 || 2 || 3) && 4 && 5
 * 
 * @author pez1420@gmail.com
 * @version $Id: Strategy.java v 0.1 2020/7/29 9:10 下午 pez1420 Exp $$
 */
public class Strategy {

    /** 主键ID */
    private Long         id;

    /** 策略ID */
    private Long         strategyId;

    /** 策略名称 */
    private String       strategyName;

    /** 事件ID */
    private Long         eventId;

    /** 事件名称 */
    private String       eventName;

    /** 策略描述 */
    private String       strategyDesc;

    /** 规则列表 */
    private List<Rule>   rules;

    /** 执行方式(1 || (2&&3) || 4) */
    private String       executeMethod;

    /** 惩罚干预列表 */
    private List<Action> actions;

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
     * Getter for property 'strategyId'.
     *
     * @return strategyId Value for property 'strategyId'.
     */
    public Long getStrategyId() {
        return strategyId;
    }

    /**
     * Setter for property 'strategyId'.
     *
     * @param strategyId Value to set for property 'strategyId'.
     */
    public void setStrategyId(Long strategyId) {
        this.strategyId = strategyId;
    }

    /**
     * Getter for property 'strategyName'.
     *
     * @return strategyName Value for property 'strategyName'.
     */
    public String getStrategyName() {
        return strategyName;
    }

    /**
     * Setter for property 'strategyName'.
     *
     * @param strategyName Value to set for property 'strategyName'.
     */
    public void setStrategyName(String strategyName) {
        this.strategyName = strategyName;
    }

    /**
     * Getter for property 'eventId'.
     *
     * @return eventId Value for property 'eventId'.
     */
    public Long getEventId() {
        return eventId;
    }

    /**
     * Setter for property 'eventId'.
     *
     * @param eventId Value to set for property 'eventId'.
     */
    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    /**
     * Getter for property 'eventName'.
     *
     * @return eventName Value for property 'eventName'.
     */
    public String getEventName() {
        return eventName;
    }

    /**
     * Setter for property 'eventName'.
     *
     * @param eventName Value to set for property 'eventName'.
     */
    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    /**
     * Getter for property 'strategyDesc'.
     *
     * @return strategyDesc Value for property 'strategyDesc'.
     */
    public String getStrategyDesc() {
        return strategyDesc;
    }

    /**
     * Setter for property 'strategyDesc'.
     *
     * @param strategyDesc Value to set for property 'strategyDesc'.
     */
    public void setStrategyDesc(String strategyDesc) {
        this.strategyDesc = strategyDesc;
    }

    /**
     * Getter for property 'rules'.
     *
     * @return rules Value for property 'rules'.
     */
    public List<Rule> getRules() {
        return rules;
    }

    /**
     * Setter for property 'rules'.
     *
     * @param rules Value to set for property 'rules'.
     */
    public void setRules(List<Rule> rules) {
        this.rules = rules;
    }

    /**
     * Getter for property 'executeMethod'.
     *
     * @return executeMethod Value for property 'executeMethod'.
     */
    public String getExecuteMethod() {
        return executeMethod;
    }

    /**
     * Setter for property 'executeMethod'.
     *
     * @param executeMethod Value to set for property 'executeMethod'.
     */
    public void setExecuteMethod(String executeMethod) {
        this.executeMethod = executeMethod;
    }

    /**
     * Getter for property 'actions'.
     *
     * @return actions Value for property 'actions'.
     */
    public List<Action> getActions() {
        return actions;
    }

    /**
     * Setter for property 'actions'.
     *
     * @param actions Value to set for property 'actions'.
     */
    public void setActions(List<Action> actions) {
        this.actions = actions;
    }
}
