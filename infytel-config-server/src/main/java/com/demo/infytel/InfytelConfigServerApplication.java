package com.demo.infytel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class InfytelConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(InfytelConfigServerApplication.class, args);
	}

}
