package com.coffang.springboot2_coffang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class                                               Springboot2CoffangApplication {

	public static void main(String[] args) {
		SpringApplication.run(Springboot2CoffangApplication.class, args);
	}

}
