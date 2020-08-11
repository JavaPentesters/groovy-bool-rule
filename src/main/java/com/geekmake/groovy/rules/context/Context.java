package com.geekmake.groovy.rules.context;

/**
 * @author pez1420@gmail.com
 * @version $Id: Context.java v 0.1 2020/7/29 10:48 下午 pez1420 Exp $$
 */
public interface Context<K, V> {

    /**
     * 根据名称从属性列表中提取属性值。如果表达式中用到了Spring的对象，也是通过此方法获取
     *
     * @param key 属性名称
     * @return
     */
     V get(Object key);

    /**
     * 表达式计算的结果可以设置回调用系统，例如  userId = 3 + 4
     *
     * @param name 属性名称
     * @param object 属性值
     */
     V put(K name, V object);

}
