---
nav:
  title: 消息平台
  order: 1
---

# 消息平台

## 定位

- 为各个系统提供针对消息方面的公共接口和 SDK
- 集中管控公司内所有消息,方便查找和审计
- 通过消息订阅功能,可让用户自定义消息推送接收的频率,提高用户体验

## 包含服务

| 服务  | 接口地址 | 服务描述 |
| ------- | ----------- | ------------ |
| 发送邮件 | `sendEmail` | 发送邮件到指定邮箱(可复数) |
| 发送短信 | `sendSns` | 发送短信到指定收集(可群发) |

## 使用方式

### 注入`proxy`进行调用

```java

import com.gzmpc.business.developer.core.proxy.MessageProxy;


@Service
public class DemoService {

  @Autowired
  MessageProxy messageProxy;

  public void send() {
    messageProxy.sendEmail(request);
  }
}

```

