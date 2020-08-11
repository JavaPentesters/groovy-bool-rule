package com.geekmake.groovy.rules.utils;

import com.geekmake.groovy.rules.enums.OperatorEnum;

/**
 * @author pez1420@gmail.com
 * @version $Id: GroovyScriptUtils.java v 0.1 2020/7/29 11:55 下午 pez1420 Exp $$
 */
public class ScriptTemplateUtil {

    /**
     * package com.geekmake.groovy.rules
     *
     * import com.geekmake.groovy.rules.context.*;
     *
     * class  OperatorScript {
     *     boolean execute(def context) {
     *         def indexKeyName = context.indexKey;
     *         def leftVarValue = context."${indexKeyName}";
     *         def rightVarValue = context.rightVarValue;
     *         return leftVarValue > rightVarValue ? true:false;
     *     }
     * }
     *
     * @param operator OperatorEnum
     *                 操作符
     * @return String
     */
    public static String generateOperatorScript(OperatorEnum operator) {
        StringBuilder execScript = new StringBuilder();
        execScript.append("package com.geekmake.groovy.rules").append("\n");
        execScript.append("import com.geekmake.groovy.rules.context.*;").append("\n");
        execScript.append("class  OperatorScript {").append("\n");
        execScript.append("     boolean execute(def context) {").append("\n");
        execScript.append("         def indexKeyName = context.indexKey;").append("\n");
        execScript.append("         def leftVarValue = context.\"${indexKeyName}\";").append("\n");
        execScript.append("         def rightVarValue = context.indexThresholdValue;").append("\n");
        execScript.append("         return leftVarValue ").append(operator.getType())
            .append(" rightVarValue ").append(" ? true:false;").append("\n");

        execScript.append("    }").append("\n");
        execScript.append("}").append("\n");

        return execScript.toString();
    }

    public static String getGlobleScript(String script) {
        StringBuilder execScript = new StringBuilder();
        //增加一个日期处理方法
        execScript.append("import java.text.SimpleDateFormat").append("\n");
        execScript.append("import java.text.ParseException").append("\n");

        execScript.append("def to_date(_date){").append("\n");
        execScript.append("    try{").append("\n");
        execScript
            .append("        return (new SimpleDateFormat(\"yyyy/MM/dd hh:mm:ss\")).parse(_date);")
            .append("\n");
        execScript.append("    }catch(ParseException e){").append("\n");
        execScript.append("        return (new SimpleDateFormat(\"yyyy/MM/dd\")).parse(_date);")
            .append("\n");
        execScript.append("    }").append("\n");
        execScript.append("}").append("\n");

        execScript.append(script);

        return execScript.toString();
    }

}
