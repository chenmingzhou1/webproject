package com.etc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SpringbootJpaRedisApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootJpaRedisApplication.class, args);
	}

}
