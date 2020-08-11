package com.geekmake.groovy.rules.model;

/**
 * @author pez1420@gmail.com
 * @version $ID: Action.java v 0.1 2020/8/4 1:04 下午 pez1420 Exp $$
 */
public class Action {

    private Long   id;

    /** 动作唯一标识 */
    private String actionId;

    /** 动作名称 */
    private String actionName;

    /** 动作描述 */
    private String actionDesc;

    /** 创建人 */
    private String creator;

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
     * Getter for property 'actionId'.
     *
     * @return actionId Value for property 'actionId'.
     */
    public String getActionId() {
        return actionId;
    }

    /**
     * Setter for property 'actionId'.
     *
     * @param actionId Value to set for property 'actionId'.
     */
    public void setActionId(String actionId) {
        this.actionId = actionId;
    }

    /**
     * Getter for property 'actionName'.
     *
     * @return actionName Value for property 'actionName'.
     */
    public String getActionName() {
        return actionName;
    }

    /**
     * Setter for property 'actionName'.
     *
     * @param actionName Value to set for property 'actionName'.
     */
    public void setActionName(String actionName) {
        this.actionName = actionName;
    }

    /**
     * Getter for property 'actionDesc'.
     *
     * @return actionDesc Value for property 'actionDesc'.
     */
    public String getActionDesc() {
        return actionDesc;
    }

    /**
     * Setter for property 'actionDesc'.
     *
     * @param actionDesc Value to set for property 'actionDesc'.
     */
    public void setActionDesc(String actionDesc) {
        this.actionDesc = actionDesc;
    }

    /**
     * Getter for property 'creator'.
     *
     * @return creator Value for property 'creator'.
     */
    public String getCreator() {
        return creator;
    }

    /**
     * Setter for property 'creator'.
     *
     * @param creator Value to set for property 'creator'.
     */
    public void setCreator(String creator) {
        this.creator = creator;
    }
}
