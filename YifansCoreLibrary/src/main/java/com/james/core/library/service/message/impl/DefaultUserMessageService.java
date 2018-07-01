package com.james.core.library.service.message.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.james.core.library.channel.UserRegisterProcessor;
import com.james.core.library.message.UserRegisterMessage;
import com.james.core.library.model.User;
import com.james.core.library.service.message.UserMessageService;

@Service
@EnableBinding(UserRegisterProcessor.class)
public class DefaultUserMessageService implements UserMessageService {
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserRegisterProcessor userRegisterSource;
		
	@Override
	public void sendUserRegisterRequest(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		
		userRegisterSource.requestToCreateNewUser().send(new UserRegisterMessage(null, user));
	}
}







