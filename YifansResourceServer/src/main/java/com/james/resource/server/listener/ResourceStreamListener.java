package com.james.resource.server.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import com.james.core.library.channel.UserRegisterProcessor;
import com.james.core.library.model.User;
import com.james.core.library.service.db.UserDatabaseService;

@Component
@ComponentScan(basePackages = {
	"com.james.core.library"
})
@EnableBinding(UserRegisterProcessor.class)
public class ResourceStreamListener {
	@Autowired
	UserDatabaseService userDatabaseService;
	
	@StreamListener(UserRegisterProcessor.USER_REGISTER_REQUEST_INPUT_CHANNEL)
    public void receiveUserRegisterRequest(Message<User> userRegisterMessage) {
		userDatabaseService.registerNewUser(userRegisterMessage.getPayload());
    }
}