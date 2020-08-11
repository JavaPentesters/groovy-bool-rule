package com.geekmake.groovy.rules;

import cn.hutool.core.lang.Assert;
import org.junit.Test;

/**
 * @author pez1420@gmail.com
 * @version $Id: TestUtils.java v 0.1 2020/8/11 3:04 下午 pez1420 Exp $$
 */
public class TestUtils {

    @Test
    public void testIntern() {
        String s1 = new String("123") + new String("123");
        s1.intern();
        String s2 = "123123";
        Assert.isTrue(s1 == s2);
    }
}
