package com.geekmake.groovy.rules.core.sandbox;

import org.kohsuke.groovy.sandbox.GroovyInterceptor;

/**
 * @author pez1420@gmail.com
 * @version $Id: NoSystemExitSandbox.java v 0.1 2020/8/13 4:25 下午 pez1420 Exp $$
 */
public class NoSystemExitSandbox extends GroovyInterceptor {
    @Override
    public Object onStaticCall(GroovyInterceptor.Invoker invoker, Class receiver, String method,
                               Object... args) throws Throwable {
        if (receiver == System.class && method == "exit") {
            throw new SecurityException("No call on System.exit() please");
        }

        return super.onStaticCall(invoker, receiver, method, args);
    }

}
