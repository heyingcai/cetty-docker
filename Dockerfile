# first stage
FROM registry.cn-hangzhou.aliyuncs.com/acs/maven AS maven-build
MAINTAINER bronson "admin@jibug.com"
ENV APP_HOME=/usr/src/app
WORKDIR $APP_HOME
ADD pom.xml $APP_HOME
RUN ["/usr/local/bin/mvn-entrypoint.sh","mvn","verify","clean","--fail-never"]
# add source
ADD . $APP_HOME
# run maven package
RUN ["/usr/local/bin/mvn-entrypoint.sh","mvn","package"]

# second stage
FROM java:8u111-jdk
COPY --from=maven-build /usr/src/app/docker/target/*.jar crawler.jar
ENTRYPOINT ["java","-jar","crawler.jar"]

