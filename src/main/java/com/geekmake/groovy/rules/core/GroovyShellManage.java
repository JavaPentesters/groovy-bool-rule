package com.geekmake.groovy.rules.core;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.codehaus.groovy.runtime.InvokerHelper;

import com.geekmake.groovy.rules.utils.StringUtils;

import cn.hutool.crypto.digest.MD5;
import groovy.lang.Binding;
import groovy.lang.GroovyClassLoader;

/**
 *
 * @author pez1420@gmail.com
 * @version $Id: GroovyShellManage.java v 0.1 2020/8/11 2:59 下午 pez1420 Exp $$
 */
public class GroovyShellManage {

    private static final Map<String, Class> SCRIPT_CLASS_MAP = new ConcurrentHashMap<>();

    public static <T> T executeExp(String expScript, Map<String, Object> params,
                                   Class<T> returnType) {
        if (StringUtils.isBlank(expScript)) {
            return null;
        }

        Object result;
        try {
            Class aClass = loadClass(expScript);
            result = InvokerHelper.createScript(aClass, new Binding(params)).run();
            return (T) result;
        } catch (Exception e) {
            return null;
        }

    }

    public static Class loadClass(String script) {
        String key = key(script);
        Class clazz = SCRIPT_CLASS_MAP.get(key);
        if (clazz == null) {
            synchronized (key.intern()) {
                clazz = SCRIPT_CLASS_MAP.get(key);
                if (clazz == null) {
                    GroovyClassLoader groovyClassLoader = new GroovyClassLoader(
                        Thread.currentThread().getContextClassLoader());
                    clazz = groovyClassLoader.parseClass(script);
                    return clazz;
                }
            }
        }

        return SCRIPT_CLASS_MAP.get(key);
    }

    public static String key(String script) {
        return MD5.create().digestHex(script);
    }
}
