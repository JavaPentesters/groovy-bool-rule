package com.geekmake.groovy.rules;

import com.geekmake.groovy.rules.core.GroovyScriptManage;
import groovy.lang.GroovyObject;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author pez1420@gmail.com
 * @version $Id: TestGroovyScript.java v 0.1 2020/7/31 1:06 下午 pez1420 Exp $$
 */
public class TestGroovyScript {

    @Test
    public void testAdd() {
        String ruleScript = "package com.study.rule.groovy\n" +
                "class Compute {\n" +
                "    def add(int a, int b) {\n" +
                "        return a + b;\n" +
                "    }\n" +
                "}";
        Object[] params = { 1, 2 };
        GroovyObject groovyObject = GroovyScriptManage.loadScript(ruleScript);
        Object result = GroovyScriptManage.invokeMethod(groovyObject, "add", params);
        Assert.assertTrue(result.equals(3));
    }
}
