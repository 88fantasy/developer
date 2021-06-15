---
nav:
  title: 业务规则引擎
  order: 4
---

# 业务规则引擎

## 定位

- 在部分的业务场景(如预售单检查,进货合同检查)下,需要进行单据检查(质量或业务)
- 可通过静态代码或动态配置的方式实现一条规则, 并根据顺序和规则包策略配置组成一个规则包
- 在配置规则包后, 外部业务系统(或模块)可提交业务单据调用接口启动加载规则包内的规则进行运算
- 支持分布式,批量运算

## 规则引擎概念

通过高效的抽象来定义业务规则, 每一条规则都会包含 Condition(条件) 和 Action(动作), 当满足 Condition 时会执行 Action
并可以通过原始规则创建复合规则(比如规则的组合)
也可以通过规则器创建规则, 保存为表达式规则, 然后内部用表达式语言定义规则进行运算

> - 事实（Fact）：业务数据；
> - 规则（Rule）：业务规则，包含条件评估、动作执行，条件评估结果为true，则执行对应动作；
> - 规则引擎（Rule Engine）：以指定的方式执行规则；
> - 规则监听（Rule Listener）：监听规则的执行情况；
> - 规则引擎监听（Rule Engine Listener）：监听规则引擎的执行情况；

## 包含服务

| 服务     | 接口地址 | 服务描述                                  |
| -------- | -------- | ----------------------------------------- |
| 执行规则 | `submit` | 根据业务 code 执行相应规则运算,并返回结果 |

## 使用方式

### 注入`proxy`进行调用

```java

import com.gzmpc.business.developer.core.proxy.RuleProxy;


@Service
public class DemoService {

  @Autowired
  RuleProxy ruleProxy;

  public void send() {
    ruleProxy.submit(request);
  }
}

```

## 编写规则

### 程序规则

新建 class 添加 `Rule` 注解, 在启动时即会通过扫描器自动加载到规则库

```java
@RuleProperties(input = "输入", output = "输出", tags = {"标签一", "标签二"})
@Rule(name = "规则名称", description = "规则描述")
public class CheckGoodsInfoRule {
 
  //判断规则,如果返回 true 才会执行 action
  @Condition
  public boolean isUse(@Fact("goodsid") long goodsid, @Fact("cpid") long cpid, Facts facts) {
    return true;
  }
 
  //处理逻辑
  @Action
  public void doAction(Facts facts) {
  
  }
}

```

