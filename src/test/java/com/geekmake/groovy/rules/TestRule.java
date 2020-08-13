package com.geekmake.groovy.rules;

import com.geekmake.groovy.rules.core.GroovyScriptManage;
import org.junit.Test;

import com.geekmake.groovy.rules.common.Constants;
import com.geekmake.groovy.rules.context.DefaultContext;
import com.geekmake.groovy.rules.data.RuleMockData;
import com.geekmake.groovy.rules.model.Rule;

import cn.hutool.core.lang.Assert;

/**
 * @author pez1420@gmail.com
 * @version $Id: TestRule.java v 0.1 2020/7/30 1:36 下午 pez1420 Exp $$
 */
public class TestRule {

    /**
     *
     * {
     *   "scriptTemplate": "package com.geekmake.groovy.rules\nimport com.geekmake.groovy.rules.context.*;\nclass  OperatorScript {\n     boolean execute(def context) {\n         def indexKeyName = context.indexKey;\n         def leftVarValue = context.\"${indexKeyName}\";\n         def rightVarValue = context.indexThresholdValue;\n         return leftVarValue >= 50 ? true:false;\n    }\n}\n",
     *   "id": -7435414678244955016,
     *   "operatorEnum": "GTE",
     *   "rightVar": 50,
     *   "ruleId": 1,
     *   "leftVar": {
     *     "varName": "1小时内IP登陆大于50次",
     *     "indexKeyValue": 20,
     *     "indexKey": "login_ip_1_hour_qty"
     *   }
     * }
     *
     */
    @Test
    public void testRule1() {
        Rule rule = RuleMockData.getRule1Data();
        DefaultContext<String, Object> context = new DefaultContext<>();
        context.put(Constants.INDEX_KEY, rule.getLeftVar().getIndexKey());
        context.put(rule.getLeftVar().getIndexKey(), rule.getLeftVar().getIndexKeyValue());
        context.put(Constants.RIGHT_VALUE, rule.getRightVar());
        Object[] params = {context};
        Boolean isTrue = (Boolean) GroovyScriptManage.invokeMethod(rule.getScriptTemplate(), "execute", params);
        Assert.isTrue(isTrue);
    }

    @Test
    public void testRule2() {
        Rule rule = RuleMockData.getRule2Data();
        DefaultContext<String, Object> context = new DefaultContext<>();
        context.put(Constants.INDEX_KEY, rule.getLeftVar().getIndexKey());
        context.put(rule.getLeftVar().getIndexKey(), rule.getLeftVar().getIndexKeyValue());
        context.put(Constants.RIGHT_VALUE, rule.getRightVar());
        Object[] params = {context};
        Boolean isTrue = (Boolean) GroovyScriptManage.invokeMethod(rule.getScriptTemplate(), "execute", params);
        Assert.isTrue(isTrue);
    }
}
