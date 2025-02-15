# Spring boot Demo说明

### 运行环境
```
OpenJDK版本：eclipse-temurin 17.0.14_7-jdk  
Spring Boot版本：3.0.2  
```


### 访问关系

浏览器访问consumer，consumer通过Kubernetes Service发现和调用Provider-A和Provider-B注册的服务.


### Demo显示效果
```
Welcome to visit the microservice demo application!

Operating environment: OpenJDK 17
Spring Boot environment: 3.0.2
Microservice architecture: Service Mesh

The currently accessed microservice is: consumer

Service Provider A
Service Name: ProviderA
Host Name: 8c1b6a64e38c
IP Address: 172.17.0.4
Star Rating: ★★★★★★

Service Provider B
Service Name: ProviderB
Host Name: c02de47ab60d
IP Address: 172.17.0.5
Star Rating: ★★★★★
```


### 配置说明
#### 环境变量说明：  
```
PROVIDERA_SERVICE_NAME: 配置调用providera的Kubernetes cluster ip或者service名字。  
示例：PROVIDERA_SERVICE_NAME=providera

PROVIDERB_SERVICE_NAME: 配置调用providerb的Kubernetes cluster ip或者service名字。  
示例：PROVIDERB_SERVICE_NAME=providerb

STAR_COUNT:配置provider展示的星星的数量  
示例：STAR_COUN=5  

STAR_COLOR: 配置provider展示的星星的颜色 red（红色）、blue（蓝色）、green（绿色）、yellow（黄色）、gold（金色）、silver（银色）、orange（橙色）、purple（紫色）、pink（粉色）、black（黑色）、white（白色）
示例：STAR_COLOR=blue
```
consumer需要通过修改环境变量调用provider提供的服务。
provider需要通过修改环境变量显示星星的颜色和数量


### 容器镜像
```
consumer镜像地址：registry.cn-beijing.aliyuncs.com/walkcloud/consumer:0.0.1-sm
providera镜像地址：registry.cn-beijing.aliyuncs.com/walkcloud/providera:0.0.1-sm
providerb镜像地址：registry.cn-beijing.aliyuncs.com/walkcloud/providerb:0.0.1-sm

```
