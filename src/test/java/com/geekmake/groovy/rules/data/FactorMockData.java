package com.geekmake.groovy.rules.data;

import com.geekmake.groovy.rules.model.Factor;

/**
 * Factor
 *
 * @author pez1420@gmail.com
 * @version $Id: FactorMockData.java v 0.1 2020/7/30 1:46 下午 pez1420 Exp $$
 */
public class FactorMockData {

    public static Factor getFactor1() {
        Factor factor = new Factor();
        factor.setVarName("1小时内IP登陆大于50次");
        factor.setIndexKey("login_ip_1_hour_qty");
        // 从指标引擎获取
        factor.setIndexKeyValue(1);
        return factor;
    }


    public static Factor getFactor2() {
        Factor factor = new Factor();
        factor.setVarName("IP归属地城市与手机号码归属地城市不一致");
        factor.setIndexKey("login_ip_addr_not_eq_phone_addr");
        // 从指标引擎获取
        factor.setIndexKeyValue("北京");
        return factor;
    }


    public static Factor getFactor3() {
        Factor factor = new Factor();
        factor.setVarName("5分钟内密码错误次数");
        factor.setIndexKey("5_min_login_error_pwd_qty");
        // 从指标引擎获取
        factor.setIndexKeyValue(5);
        return factor;
    }
}
