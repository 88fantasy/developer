---
nav:
  title: 微信平台
  order: 3
---

# 微信平台

## 定位

- 为各个系统提供针对微信相关的公共接口和 SDK
- 集中管控公司内微信应用及其相关密钥
- 提供微信应用和小程序相关报表展示

## 包含服务

| 服务  | 接口地址 | 服务描述 |
| ------- | ----------- | ------------ |
| 发送文本信息 | `sendText` | 从特定应用发送文本信息给特定目标 |
| 发送文本卡片消息 | `sendTextcard` | 从特定应用发送文本卡片消息给特定目标 |
| 发送图片消息 | `sendImage` | 从特定应用发送图片消息给特定目标 |
| 发送图文消息 | `sendNews` | 发送图文消息给特定目标 |
| 发送小程序消息 | `sendMiniProgram` | 从特定应用发送可跳转小程序消息给特定目标 |
| 获取微信登录用户信息 | `getUserinfo` | 获取当前登录人的相关信息 |

## 使用方式

### 注入`proxy`进行调用

```java

import com.gzmpc.business.developer.core.proxy.WechatProxy;


@Service
public class DemoService {

  @Autowired
  WechatProxy wechatProxy;

  public void send() {
    wechatProxy.sendMiniProgram(request);
  }
}

```
