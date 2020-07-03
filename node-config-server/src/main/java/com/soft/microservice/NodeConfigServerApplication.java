package com.soft.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class NodeConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(NodeConfigServerApplication.class, args);
	}

}
