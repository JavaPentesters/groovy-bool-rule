package com.geekmake.groovy.rules.core.sandbox;

import org.kohsuke.groovy.sandbox.GroovyInterceptor;

/**
 * @author pez1420@gmail.com
 * @version $Id: NoRunTimeSandbox.java v 0.1 2020/8/13 4:25 下午 pez1420 Exp $$
 */
public class NoRunTimeSandbox extends GroovyInterceptor {

    @Override
    public Object onStaticCall(GroovyInterceptor.Invoker invoker, Class receiver, String method,
                               Object... args) throws Throwable {

        if (receiver == Runtime.class) {
            throw new SecurityException("No call on RunTime please");
        }

        return super.onStaticCall(invoker, receiver, method, args);
    }
}
