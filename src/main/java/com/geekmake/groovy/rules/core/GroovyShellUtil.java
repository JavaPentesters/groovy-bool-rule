package com.geekmake.groovy.rules.core;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.codehaus.groovy.control.CompilationFailedException;
import org.codehaus.groovy.runtime.InvokerHelper;

import groovy.lang.Binding;
import groovy.lang.GroovyClassLoader;

/**
 * https://www.cnblogs.com/mumuxinfei/p/8480179.html
 *
 * @author pez1420@gmail.com
 * @version $Id: GroovyShellUtil.java v 0.1 2020/8/7 4:54 下午 pez1420 Exp $$
 */
public class GroovyShellUtil {

    private static ConcurrentHashMap<String, Class> scriptClassMap = new ConcurrentHashMap();

    public static <T> T execExpr(String expr, Map<String, Object> params, Class<T> returnType) {
        if (expr == null || expr.length() == 0) {
            return null;
        } else {
            Object result = null;

            try {
                Class e = parseClass(expr);
                result = InvokerHelper.createScript(e, new Binding(params)).run();
                return (T) result;
            } catch (Exception var5) {
                return null;
            }
        }
    }

    public static Class parseClass(String scriptText) throws CompilationFailedException {
        String key = keyGen(scriptText);
        Class value = (Class) scriptClassMap.get(key);
        if (value != null) {
            return value;
        } else {
            synchronized (scriptText.intern()) {
                if (scriptClassMap.get(key) == null) {
                    GroovyClassLoader groovyClassLoader = new GroovyClassLoader(
                        Thread.currentThread().getContextClassLoader());
                    Class scriptClass = groovyClassLoader.parseClass(scriptText);
                    scriptClassMap.put(key, scriptClass);
                    return scriptClass;
                }
            }

            return (Class) scriptClassMap.get(key);
        }
    }

    private static String keyGen(String script) {
        return String.valueOf(script.intern().hashCode());
    }
}
