FROM centos:7 
RUN echo "ip_resolve=4" >> /etc/yum.conf 
RUN yum update -y && yum install -y java-1.8.0-openjdk && yum install kde-l10n-Chinese -y && yum install glibc-common -y 
RUN localedef -c -f UTF-8 -i zh_CN zh_CN.utf8 
ENV LC_ALL zh_CN.UTF-8 
RUN /bin/cp /usr/share/zoneinfo/Asia/Shanghai /etc/localtime 
RUN echo "Asia/Shanghai" > /etc/timezone 
RUN mkdir -p /data/tsf_apm/monitor/jvm-metrics/
ENV workdir /app/
ENV agentjar TencentCloudJvmMonitor-1.1.0-RELEASE.jar
ARG jarpath
COPY $jarpath ${workdir}app.jar
COPY ${agentjar} ${workdir}
WORKDIR ${workdir}
ADD tsf-consul-template-docker.tar.gz /root/
CMD ["sh", "-ec", "sh /root/tsf-consul-template-docker/script/start.sh; exec java -Xloggc:/data/tsf_apm/monitor/jvm-metrics/gclog.log -XX:+PrintGCDateStamps -XX:+PrintGCDetails -verbose:gc -XX:+UseGCLogFileRotation -XX:NumberOfGCLogFiles=8 -XX:GCLogFileSize=50M -javaagent:${workdir}/${agentjar}=hascontroller=true ${JAVA_OPTS} -jar app.jar"]
