package com.geekmake.groovy.rules.data;

import com.geekmake.groovy.rules.model.Rule;
import com.geekmake.groovy.rules.model.Strategy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author pez1420@gmail.com
 * @version $Id: StrategyData.java v 0.1 2020/8/5 5:45 下午 pez1420 Exp $$
 */
public class StrategyMockData {

    public static Strategy getStrategy1MockData() {
        Strategy strategy = new Strategy();
        strategy.setId(1L);
        strategy.setStrategyId(1L);
        strategy.setStrategyName("IP登陆异常检测");
        strategy.setEventId(1L);
        strategy.setEventName("登陆");
        strategy.setExecuteMethod("((1 || 2) && 3)");

        List<Rule> rules = new ArrayList<>();
        rules.add(RuleMockData.getRule1Data());
        rules.add(RuleMockData.getRule2Data());
        rules.add(RuleMockData.getRule3Data());

        strategy.setRules(rules);

        return strategy;
    }
}
