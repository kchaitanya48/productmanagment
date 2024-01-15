package com.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.sample")
@EnableDiscoveryClient
public class IdentityServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(IdentityServiceApplication.class, args);
	}
}
