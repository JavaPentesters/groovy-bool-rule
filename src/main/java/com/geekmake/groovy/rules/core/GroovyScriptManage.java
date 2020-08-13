package com.geekmake.groovy.rules.core;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.geekmake.groovy.rules.utils.LoggerUtils;

import cn.hutool.crypto.digest.MD5;
import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyObject;

/**
 * https://www.cnblogs.com/xrq730/p/6662232.html
 *
 * @author pez1420@gmail.com
 * @version $Id: GroovyScriptManage.java v 0.1 2020/8/11 2:59 下午 pez1420 Exp $$
 */
public class GroovyScriptManage {

    private static final Logger             LOGGER         = LoggerFactory
        .getLogger(GroovyScriptManage.class);

    public static Map<String, GroovyObject> GROOVY_OBJ_MAP = new HashMap<>();

    public static GroovyClassLoader         groovyClassLoader;
    static {
        groovyClassLoader = new GroovyClassLoader(GroovyScriptManage.class.getClassLoader());
    }

    /**
     * 加载 groovy 脚本对象
     *
     * @param script String
     *               groovy脚本
     * @return   GroovyObject
     */
    public static GroovyObject loadScript(String script) {
        String key = key(script);
        GroovyObject groovyObject = GROOVY_OBJ_MAP.get(key);
        if (groovyObject == null) {
            Class groovyClass = groovyClassLoader.parseClass(script);
            try {
                groovyObject = (GroovyObject) groovyClass.newInstance();
                GROOVY_OBJ_MAP.put(key, groovyObject);
            } catch (Exception e) {
                LoggerUtils.error(LOGGER, e, "failed to load groovyObject, cause:{0}",
                    e.getMessage());
            }
        }

        return groovyObject;
    }

    /**
     * 删除不再使用的groovy object，防止内存溢出
     * 
     * @param script String
     */
    public static void removeScript(String script) {
        GROOVY_OBJ_MAP.remove(key(script));
    }

    public static Object invokeMethod(GroovyObject object, String method, Object[] args) {
        return object.invokeMethod(method, args);
    }

    public static Object invokeMethod(String script, String method, Object[] args) {
        GroovyObject groovy = loadScript(script);
        if (groovy != null) {
            return invokeMethod(groovy, method, args);
        }

        return null;
    }

    private static String key(String script) {
        return MD5.create().digestHex(script);
    }

}
