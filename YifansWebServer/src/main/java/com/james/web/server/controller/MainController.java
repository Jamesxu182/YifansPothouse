package com.james.web.server.controller;

import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
	@GetMapping("/index")
	public String index() {
		return "index";
	}
	
	@GetMapping("/test")
	public String test() {
		return "test";
	}
	
	@GetMapping("/hello")
	@ResponseBody
	public String hello(OAuth2Authentication authentication) {
		return "Hello, " + authentication.getName();
	}
}
