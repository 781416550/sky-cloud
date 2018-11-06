package com.hsd.skycloud.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SkyEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SkyEurekaApplication.class, args);
	}
}
