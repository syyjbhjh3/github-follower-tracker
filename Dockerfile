FROM openjdk:22-jdk-slim
ADD ./build/libs/demo-0.0.1-SNAPSHOT.jar /
WORKDIR /

ENTRYPOINT ["java", "-Dfile.encoding=UTF8", "-Duser.timezone=Asia/Seoul", "-jar", "demo-0.0.1-SNAPSHOT.jar"]