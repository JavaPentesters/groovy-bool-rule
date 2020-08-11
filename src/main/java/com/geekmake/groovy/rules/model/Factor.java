package com.geekmake.groovy.rules.model;

/**
 * 规则事实对象
 *
 * @author pez1420@gmail.com
 * @version $Id: Factor.java v 0.1 2020/7/29 9:35 下午 pez1420 Exp $$
 */
public class Factor {

    /** 编号 */
    private Long   id;

    /** 左变量名称（事实） */
    private String varName;

    /** 指标key */
    private String indexKey;

    /** 指标key值（从Redis、Hbase等存储引擎获取） */
    private Object indexKeyValue;

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
     * Getter for property 'varName'.
     *
     * @return varName Value for property 'varName'.
     */
    public String getVarName() {
        return varName;
    }

    /**
     * Setter for property 'varName'.
     *
     * @param varName Value to set for property 'varName'.
     */
    public void setVarName(String varName) {
        this.varName = varName;
    }

    /**
     * Getter for property 'indexKey'.
     *
     * @return indexKey Value for property 'indexKey'.
     */
    public String getIndexKey() {
        return indexKey;
    }

    /**
     * Setter for property 'indexKey'.
     *
     * @param indexKey Value to set for property 'indexKey'.
     */
    public void setIndexKey(String indexKey) {
        this.indexKey = indexKey;
    }

    /**
     * Getter for property 'indexKeyValue'.
     *
     * @return indexKeyValue Value for property 'indexKeyValue'.
     */
    public Object getIndexKeyValue() {
        return indexKeyValue;
    }

    /**
     * Setter for property 'indexKeyValue'.
     *
     * @param indexKeyValue Value to set for property 'indexKeyValue'.
     */
    public void setIndexKeyValue(Object indexKeyValue) {
        this.indexKeyValue = indexKeyValue;
    }
}
