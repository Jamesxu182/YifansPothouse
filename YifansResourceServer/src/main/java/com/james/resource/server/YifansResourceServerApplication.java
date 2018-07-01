package com.james.resource.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(
		scanBasePackages = {
			"com.james.resource.server",
			"com.james.core.library"
		}
)
@EnableJpaRepositories(
		basePackages = {
			"com.james.core.library.repository"
		}
)
@EntityScan(basePackages="com.james.core.library.model")
public class YifansResourceServerApplication {
	public static void main(String[] args) {
		SpringApplication.run(YifansResourceServerApplication.class, args);
	}
}