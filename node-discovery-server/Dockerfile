FROM openjdk:8-jdk-alpine
WORKDIR /config
COPY target/node-discovery-server-0.0.1-SNAPSHOT.jar node-discovery-server.jar
CMD echo File copied
ENV XYZ="-Xmx256m -Xms256m"
EXPOSE 5555
ENTRYPOINT ["sh","-c","java ${XYZ} -Ddiscovery.server=${DISCOVERY_SERVER} -Dconfig.server=${CONFIG_SERVER} -jar node-discovery-server.jar"]
