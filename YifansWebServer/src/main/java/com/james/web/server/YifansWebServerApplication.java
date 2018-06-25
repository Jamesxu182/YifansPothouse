package com.james.web.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.context.request.RequestContextListener;

@SpringBootApplication(
		scanBasePackages = {
				"com.james.web.server",
				"com.james.core.library.service.message",
				"com.james.core.library.bean.security"
			}
		)
public class YifansWebServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(YifansWebServerApplication.class, args);
	}
	
	@Bean
	public RequestContextListener requestContextListener() {
	    return new RequestContextListener();
	}
}
