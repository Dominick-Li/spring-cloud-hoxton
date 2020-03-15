###########项目名称  
微服务架构base 

###########功能特效  
这套架构包含服务注册中心,统一配置中心,网关(包含限流熔断),监控中心
producer项目用于重数据库读取数据
consumer项目在服务内部调用producer获取消息

###########环境依赖  
jdk 1.8以上   
spring cloud版本 -> Hoxton.SR3 
springboot 版本  -> 2.2.5 

###########各模块说明  
模块介绍    
register         服务注册中心         8761 
configuration    配置注册中心         8762 
gateway          微服务网关           8763 
monitor          监控中心             8764 
producer         服务提供者           8765 
consumer         服务消费者           8766 
distribution    服务编译后的程序集目录 

###########编译后的目录描述  
distribution
├─bin        放程序的启动脚本 
├─conf       配置目录 
│  ├─config  统一配置中心管理的目录 
│  │  └─db   数据库配置文件目录 
│  └─logback 日志文件目录 
├─lib        微服务编译后的jar 
└─logs       程序的日志输出目录 
    ├─dump   存放程序oom溢出日志 
    └─gc     存放程序gc的日志,如果不需要打印gc日志,可以在启动脚本中删掉 打印gc的参数 -XX:+PrintGCDetails -XX:+PrintGCTimeStamps -XX:+PrintGCDateStamps -Xloggc:logs/gc/%SERVER_NAME%-gc.log 
    
###########部署 
1.数据库配置
1.1创建数据库
create database cloud;  
1.2.修改数据库用户名和密码
修改 distribution>conf>config/db>mysql-producer.yml 配置文件 
修改username和password保持和你数据的一直,表结构会在producer程序启动后自动生成 

2.修改服务上线或离线通知邮件配置
修改 distribution>conf>config>monitor-info.yml 配置文件      
spring.mail.host                邮箱服务器
spring.mail.username            发送邮件的帐号
spring.mail.password            授权码
client.notify.mail.subject      邮件的标题
client.notify.mail.to           通知的对象的邮箱号(多个以','隔开)

3.启动程序 
window是bat脚本,linux是shell脚本 

 3.1window环境   
 
  3.1.1 启动注册中心  
  双击  distribution\bin\目录下的 register.bat   
  
  3.1.2 启动配置中心 
  双击 distribution\bin\目录下的 configuration.bat    
  
  3.1.3 启动网关 
  双击 distribution\bin\目录下的 gateway.bat    
  
  3.1.4 启动监控中心 
  双击  distribution\bin\目录下的 monitor.bat    
  
  3.1.5 启动消息提供者 
  双击  distribution\bin\目录下的 producer.bat    
  
  3.1.6 启动消息消费者 
  双击  distribution\bin\目录下的 consumer.bat    
  
 3.2linux环境
 
  ${user.home}需要换成你放在服务器对应的位置,需要在启动脚本名字后面加参数 start 
  sh启动脚本参数描述 
  start   启动应用 
  stop    停止应用 
  restart 重启应用 
  
  3.2.1 启动注册中心 
  ${user.home}/distribution/bin/register.sh  start 
  
  3.2.2 启动配置中心
  ${user.home}/distribution/bin/configuration.sh start   
  
  3.2.3 启动网关 
  ${user.home}/distribution/bin/gateway.sh start   
  
  3.2.4 启动监控中心 
  ${user.home}/distribution/bin/monitor.sh start   
  
  3.2.5 启动消息提供者 
  ${user.home}/distribution/bin/producer.sh start   
  
  3.2.6 启动消息消费者 
  ${user.home}/distribution/bin/consumer.sh start  

