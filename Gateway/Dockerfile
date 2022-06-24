FROM openjdk:11-jre-slim-buster
ARG DEPENDENCY=target/dependency
COPY ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY ${DEPENDENCY}/META-INF /app/META-INF
COPY ${DEPENDENCY}/BOOT-INF/classes /app
EXPOSE 8100
ENTRYPOINT ["java","-cp","app:app/lib/*","com.demo.infytel.GatewayApplication"] 