
## groovy-rules

###  基于groovy实现的复杂布尔表达式规则引擎

在规则引擎决策中，规则往往涉及到多个复杂布尔表达式条件的逻辑计算。
条件(condition)通过或与非逻辑运算符组合成复杂的布尔表达式。这类布尔表达式有两种特点：一是条件及表达式是动态可配置的；二是表达式是条件的组合，所以相对是比较复杂的。
本项目基于groovy动态脚本引擎实现了计算复杂性布尔表达式的规则引擎。

#### 规则与条件模型

一条规则可以理解为包含多个条件的复杂布尔表达式, 每一条条件执行的结果要么是true,要么是false。
规则中的条件可以抽象出三个部分： "左变量"、"操作符"、"右变量"。比如，某个用户的登陆次数大于10次。
左边的左变量是指用户的登陆次数，中间的操作符就是"大于",右边的右变量就是登陆次数的阈值10次。
Drools定义的规则包含两个部分：LHS和RHS
a Left Hand Side (LHS) and a Right Hand Side (RHS) 
when <LHS>
then <RHS>
        

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


#### Reference

+ 1、What about == in Groovy?
https://objectpartners.com/2018/11/07/equals-is-compareto-and-the-groovy-identity-operator/






