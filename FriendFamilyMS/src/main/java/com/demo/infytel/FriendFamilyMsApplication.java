package com.demo.infytel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class FriendFamilyMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(FriendFamilyMsApplication.class, args);
	}

}
