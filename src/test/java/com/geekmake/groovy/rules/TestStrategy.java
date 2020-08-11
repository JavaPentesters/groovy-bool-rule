package com.geekmake.groovy.rules;

import org.junit.Test;

import com.geekmake.groovy.rules.core.RuleEngine;
import com.geekmake.groovy.rules.data.StrategyMockData;
import com.geekmake.groovy.rules.model.Strategy;

import cn.hutool.core.lang.Assert;

/**
 * @author pez1420@gmail.com
 * @version $Id: TestStrategy.java v 0.1 2020/8/5 5:44 下午 pez1420 Exp $$
 */
public class TestStrategy {

    @Test
    public void testStrategy() {
        Strategy strategy = StrategyMockData.getStrategy1MockData();
        Boolean executeResult = false;
        for (int i = 0; i < 1000; i++) {
             executeResult = RuleEngine.getInstance().run(strategy);
        }
        Assert.isTrue(executeResult);
    }
}
