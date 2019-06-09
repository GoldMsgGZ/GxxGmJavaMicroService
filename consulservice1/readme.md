# Consul Service 1 服务开发范例说明

## 本服务的实现目标
将服务注册到Consul上；

## Java Spring-Boot的实现方式

### 基本步骤
#### 项目依赖组件

```
    <!-- consul-client -->
    <dependency>
        <groupId>com.orbitz.consul</groupId>
        <artifactId>consul-client</artifactId>
        <version>0.13.8</version>
    </dependency>

    <dependency>
        <groupId>org.glassfish.jersey.core</groupId>
        <artifactId>jersey-client</artifactId>
        <version>2.22.2</version>
    </dependency>

    <!-- 健康检查要用的依赖 -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-actuator</artifactId>
    </dependency>
```

#### 配置服务注册信息

```
    service.name=consulservice1
    service.port=8080
    service.tag=dev
    health.url=http://localhost:${service.port}/actuator/health
    health.interval=10
```

#### 实现一个Bean

```$xslt
    Java的Bean实际上是一个实体类，定义了数据字段以及对应的数据字段操作方法，例如get方法、set方法。
    具体实现参考ConsulProperties.java
    
    ConsulProperties.java中采用了"${a.b:val}"的方式获取配置文件中的配置参数，以及设置默认值。
```

## 其他语言实现方式