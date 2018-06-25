package com.james.auth.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(
		scanBasePackages = {
			"com.james.auth.server",
			"com.james.core.library.bean.security",
			"com.james.core.library.service.db",
			"com.james.core.library.service.db.impl"
		}
)
@EnableJpaRepositories(
		basePackages = {
			"com.james.core.library.repository"
		}
)
@EntityScan(basePackages="com.james.core.library.model")
public class YifansAuthServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(YifansAuthServerApplication.class, args);
	}
}
