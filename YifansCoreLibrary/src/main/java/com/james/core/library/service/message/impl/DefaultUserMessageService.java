package com.james.core.library.service.message.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.james.core.library.model.User;
import com.james.core.library.service.message.UserMessageService;

@Service
public class DefaultUserMessageService implements UserMessageService {
	@Autowired
	JmsTemplate jmsTemplate;
	
	@Autowired
	PasswordEncoder passwordEncoder;
		
	@Override
	public void sendUserRegisterRequest(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		jmsTemplate.convertAndSend("YIFAN.POTHOUSE.USER.REGISTER", user);
	}
}







