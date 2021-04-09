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

- [x] 短信接口
- [x] 邮件接口
- [ ] OTRS

## 快速上手(微服务)

我们将通过一个简单的 Demo 来阐述如何使用消息平台，在此之前，我们假设您已经：

- 拥有 Java 开发环境以及相应 IDE
- 熟悉 Spring Boot
- 熟悉 Maven

---

### 初始化工程

创建一个空的 Spring Boot 工程

> Tips
>  
> 可以使用 [代码生成器](https://start.spring.io/) 快速初始化一个 Spring Boot 工程

### 为 pom.xml 引入源

> 如已设置 `profile` 可跳过

```xml
<repository>
 <id>gzmpc-public</id>
 <name>gzmpc public maven</name>
 <url>http://maven.gzmpc.com/repository/maven-public/</url>
 <snapshots>
 <enabled>false</enabled>
 </snapshots>
 <releases>
 </releases>
</repository>
```

### 添加依赖

引入 开发者中心微服务 工程依赖：

```xml
<dependency>
    <groupId>com.gzmpc.business.developer</groupId>
    <artifactId>developer-core</artifactId>
    <version>最新版请查看pom</version>
</dependency>
```

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

## Restful 接口
