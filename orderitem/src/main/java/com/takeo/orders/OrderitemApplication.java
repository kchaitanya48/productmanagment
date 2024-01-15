package com.takeo.orders;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.takeo")
@EnableJpaRepositories
public class OrderitemApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderitemApplication.class, args);
	}

}
