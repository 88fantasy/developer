---
nav:
  title: 对象存储
  order: 2
---

# 对象存储

## 定位

- 基于腾讯云的分布式文件存储系统, 对接腾讯云的 COS
- 云端内网上传无需流量, 外部公网下载更省流量费
- 支持容灾和 CDN

## 包含服务

| 服务  | 接口地址 | 服务描述 |
| ------- | ----------- | ------------ |
| 上传文件 | `upload` |  上传文件到配置种的存储桶 |
| 下载文件 | `download` | 从存储桶指定的路径下载文件到本地 |
| 删除文件 | `delFile` | 删除桶上指定路径的文件 |

## 使用方式

### 配置文件

在 application.yml (或 properties) 填写相关桶的信息


```xml
tencentcloud:
  cos:
    bucket:
      name: xxxxx
      path: https://xxxxx.cos.ap-guangzhou.myqcloud.com
    region: ap-guangzhou

```

### 注入 `CosProperties` 和 `CosClientBuilder` 进行调用

```java

import com.gzmpc.business.developer.core.proxy.MessageProxy;


@Service
public class DemoService {

  @Autowired
  private CosProperties cosProperties;
  
  @Autowired
  CosClientBuilder cosClientBuilder;

  public void send() {
    String cosRegion = cosProperties.getCos().getRegion(),
      bucketName = cosProperties.getCos().getBucket().getName(),
      path = cosProperties.getCos().getBucket().getPath();
    CosClient cosClient = cosClientBuilder.build(cosRegion, bucketName, path);
    //进行操作....
  }
}

```

##  SpringBoot Starter(非微服务)

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

引入 cos starter 依赖：

```xml
<dependency>
    <groupId>com.gzmpc.exframework</groupId>
    <artifactId>cos-spring-boot-starter</artifactId>
    <version>最新版请查看pom</version>
</dependency>
```

### 配置文件

在 application.yml (或 properties) 填写相关桶的信息


```xml
tencentcloud:
  cos:
    bucket:
      name: xxxxx
      path: https://xxxxx.cos.ap-guangzhou.myqcloud.com
    region: ap-guangzhou
  secret:
    id: xxxxxx
    key: xxxxxx

```

### 注入 `CosClient` 进行调用

```java

import com.gzmpc.business.developer.core.proxy.MessageProxy;


@Service
public class DemoService {

  @Autowired
  private CosClient cosClient;

  public void run() {
    //进行操作....
    //cosClient....;
   
  }
}

```
