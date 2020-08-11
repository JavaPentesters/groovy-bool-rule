package com.geekmake.groovy.rules.core;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.alibaba.fastjson.JSON;
import com.geekmake.groovy.rules.common.Constants;
import com.geekmake.groovy.rules.context.DefaultContext;
import com.geekmake.groovy.rules.model.Rule;
import com.geekmake.groovy.rules.model.Strategy;
import com.geekmake.groovy.rules.utils.StringUtils;

/**
 * @author pez1420@gmail.com
 * @version $Id: RuleEngine.java v 0.1 2020/7/30 1:11 下午 pez1420 Exp $$
 */
public class RuleEngine {

    public static final String PREFIX   = "t";

    private static RuleEngine  INSTANCE = new RuleEngine();

    public static RuleEngine getInstance() {
        return INSTANCE;
    }

    public Boolean run(Strategy strategy) {
        long beg = System.currentTimeMillis();
        Map<String, Object> expMap = new TreeMap<>();
        List<Rule> rules = strategy.getRules();
        // 同步执行规则
        for (Rule rule : rules) {
            DefaultContext<String, Object> context = new DefaultContext<>();
            context.put(Constants.INDEX_KEY, rule.getLeftVar().getIndexKey());
            context.put(rule.getLeftVar().getIndexKey(), rule.getLeftVar().getIndexKeyValue());
            context.put(Constants.INDEX_THRESHOLD_VALUE, rule.getRightVar());
            Boolean ruleResult = (Boolean) GroovyScriptUtil.invokeMethod(rule.getScriptTemplate(),
                "execute", new Object[] { context });
            expMap.put(PREFIX + rule.getRuleId(), ruleResult);
        }

        System.out.println(JSON.toJSON(expMap));
        String boolExp = StringUtils.addPrefixBeforeNumber(strategy.getExecuteMethod(), PREFIX);
        Boolean executeResult = GroovyShellManage.executeExp(boolExp, expMap, Boolean.class);
        long end = System.currentTimeMillis();
        System.out.println(String.format("total consume: %dms", end - beg));
        return executeResult;
    }

}
