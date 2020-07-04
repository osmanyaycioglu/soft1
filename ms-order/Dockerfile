FROM openjdk:8-jdk-alpine
WORKDIR /config
COPY target/ms-order-0.0.1-SNAPSHOT.jar ms-order-0.0.1-SNAPSHOT.jar
CMD echo File copied
ENV XYZ="-Xmx256m -Xms256m"
EXPOSE 10000
ENTRYPOINT ["sh","-c","java ${XYZ} -Ddiscovery.server=${DISCOVERY_SERVER} -Dconfig.server=${CONFIG_SERVER} -jar ms-order-0.0.1-SNAPSHOT.jar"]
