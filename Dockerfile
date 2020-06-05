# Docker image for springboot file run
# VERSION 0.0.1
# Author: ltz
# 基础镜像使用java
FROM java:8
# 作者
MAINTAINER liaotianzheng <liaotianzheng@qq.com>
VOLUME /work/logs/config/:/logs/
ADD ltzusercenter-1.0-SNAPSHOT.jar ltzusercenter.jar
EXPOSE 9997
RUN bash -c "touch /ltzusercenter.jar"
ENTRYPOINT ["java", "-jar", "ltzusercenter.jar","> /logs/ltzusercenter.log"]