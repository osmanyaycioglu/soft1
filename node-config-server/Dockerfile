FROM openjdk:8-jdk-alpine
WORKDIR /config
COPY target/node-config-server-0.0.1-SNAPSHOT.jar config-server.jar
CMD echo File copied
ENV XYZ="-Xmx256m -Xms256m"
EXPOSE 8888
ENTRYPOINT ["sh","-c","java ${XYZ} -Dgit.dir=${GIT_DIR} -jar config-server.jar"]
