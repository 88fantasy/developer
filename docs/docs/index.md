---
hero:
  title: 开发者中心
  desc: 为技术人员提供公共的平台服务
  actions:
    - text: 消息平台
      link: /message
    - text:  对象存储
      link: /cos
footer: 阮伟儿 | Copyright © 2021
---

# 简介

## 定位

- 为技术人员提供公共的平台服务


## 包含服务

- [x] 分布式文件服务(对象存储)
- [x] 消息服务
- [x] 微信服务
- [x] 规则引擎

## 核心功能

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
