package com.geekmake.groovy.rules.data;

import static com.geekmake.groovy.rules.utils.ScriptTemplateUtil.generateOperatorScript;

import java.util.Random;

import com.alibaba.fastjson.JSON;
import com.geekmake.groovy.rules.enums.OperatorEnum;
import com.geekmake.groovy.rules.model.Rule;

/**
 * @author pez1420@gmail.com
 * @version $Id: RuleMockData.java v 0.1 2020/7/30 2:38 下午 pez1420 Exp $$
 */
public class RuleMockData {

    public static Rule getRule1Data() {
        Rule rule = new Rule();
        rule.setId(new Random().nextLong());
        rule.setRuleId(1L);
        rule.setLeftVar(FactorMockData.getFactor1());
        rule.setOperatorEnum(OperatorEnum.GTE);
        rule.setRightVar(50);
        String script = generateOperatorScript(rule.getOperatorEnum());
        rule.setScriptTemplate(script);
        System.out.println(script);
        return rule;
    }

    public static Rule getRule2Data() {
        Rule rule = new Rule();
        rule.setId(new Random().nextLong());
        rule.setRuleId(2L);
        rule.setLeftVar(FactorMockData.getFactor2());
        rule.setOperatorEnum(OperatorEnum.EQ);
        rule.setRightVar("北京");
        String script = generateOperatorScript(rule.getOperatorEnum());
        rule.setScriptTemplate(script);
        System.out.println(script);
        return rule;
    }

    public static Rule getRule3Data() {
        Rule rule = new Rule();
        rule.setId(new Random().nextLong());
        rule.setRuleId(3L);
        rule.setLeftVar(FactorMockData.getFactor3());
        rule.setOperatorEnum(OperatorEnum.LT);
        rule.setRightVar(20);
        String script = generateOperatorScript(rule.getOperatorEnum());
        rule.setScriptTemplate(script);
        System.out.println(script);
        return rule;
    }

    public static void main(String[] args) {
        System.out.println(JSON.toJSON(getRule1Data()));
    }
}
