FROM openjdk:8-jdk-alpine
WORKDIR /config
COPY target/node-api-gateway-0.0.1-SNAPSHOT.jar node-api-gateway-0.0.1-SNAPSHOT.jar
CMD echo File copied
ENV XYZ="-Xmx256m -Xms256m"
EXPOSE 8080
ENTRYPOINT ["sh","-c","java ${XYZ} -Ddiscovery.server=${DISCOVERY_SERVER} -Dconfig.server=${CONFIG_SERVER} -jar node-api-gateway-0.0.1-SNAPSHOT.jar"]
