package com.james.zuul.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class YifansZuulServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(YifansZuulServerApplication.class, args);
	}
}
