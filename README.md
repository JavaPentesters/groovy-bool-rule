## groovy-bool-rule

### 1、基于groovy实现的复杂布尔表达式规则引擎

在规则引擎决策中，规则往往涉及到多个复杂布尔表达式条件的逻辑计算。
条件(condition)通过或与非逻辑运算符组合成复杂的布尔表达式。这类布尔表达式有两种特点：一是条件及表达式是动态可配置的；二是表达式是条件的组合，所以相对是比较复杂的。
本项目基于groovy动态脚本引擎实现了计算复杂性布尔表达式的规则引擎。

#### 1.1 规则与条件模型
Drools规则引擎中定义的规则包含两个部分：`LHS(Left Hand Side)和RHS(Right Hand Side)`，一条规则可以抽象成if-then语句。
```
when <LHS>
then <RHS>
```

一条规则也可以理解为包含多个条件的复杂布尔表达式, 其中每一个条件执行的结果要么是true,要么是false。
规则中的条件可以简化为三个部分： "左变量"、"操作符"、"右变量"。比如，某个用户的登陆次数大于10次。
用户的登陆次数就是左变量，"大于"就是,登陆次数的阈值10次就是右变量。
```
用户的登陆次数> 10次
```
       
例如,某个具体的规则：
```
    boolean result = exp1 || exp2 && (exp3 || exp4) 
```

其中每一条条件exp1、exp2、exp3、exp4的形式可能如下：
```
    exp1  = var1 > 5
    exp2  = var2 < 5
    exp3  = var3 != "北京"
    exp4  = var4 >= 20
```

为方便规则的计算，我们将规则简化成：
```
    boolean result = 1 || 2 && (3 || 4) 
```

从`1 || 2 && (3 || 4)`可以看出，规则就是多个条件语句与或非的组合。

规则的运算操作包括数值运算和字符串运算两大类：

+ 数值运算操作符
序号   |  符号  | 说明 |
-     | :-:     | -: | -: 
1     |   ==                |              等于            | 
2     |   >                 |               大于           | 
3     |   <                 |               小于           | 
4     |   >=                |              大于等于           | 
5     |   <=                |              小于等于           | 
6     |   !=                |              不等于           | 

+ 字符串运算操作符
序号   |  符号  | 说明 |
-     | :-:     | -: | -: 
1     |   CONTAINS                        |      包含                       | 
2     |   NOT_CONTAINS                    |      不包含                     | 
3     |   EQUAL_IGNORE_CASE               |      不区分大小写的字符串等于     | 
4     |   STRING_EQUAL                    |     字符串相等                   | 
5     |   NOTSTRING_EQUAL                 |     字符串不等                    | 
6     |   NOT_EQUAL_IGNORE_CASE           |      不区分大小写的字符串不等      | 
7     |   MATCHES                         |      正则匹配                    | 
8     |    NOT_MATCHES                    |      正则不匹配                  | 


#### 1.2 Reference

+ 1、What about == in Groovy?
https://objectpartners.com/2018/11/07/equals-is-compareto-and-the-groovy-identity-operator/

This description fails to clarify something that it should: == is not always calling equals().
Thankfully, a different portion of the Groovy Language Documentation saves the day:

>   Behaviour of ==
      In Java == means equality of primitive types or identity for objects.
      In Groovy == translates to a.compareTo(b)==0, if they are Comparable, and a.equals(b) otherwise.
>





