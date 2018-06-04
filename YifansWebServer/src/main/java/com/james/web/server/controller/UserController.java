package com.james.web.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.james.core.library.service.message.UserMessageService;
import com.james.web.server.form.UserRegisterRequestForm;

@Controller
@RequestMapping("/user")
public class UserController {
	 @Autowired
	 private UserMessageService userMessageService;
	
	@RequestMapping(path="/register", method=RequestMethod.GET)
	public String registerPage() {
		return "register";
	}
	
	@RequestMapping(path="/register", method=RequestMethod.POST)
	public String registerUser(UserRegisterRequestForm form) {
		userMessageService.sendUserRegisterRequest(form.getUser());
		return "index";
	}
}