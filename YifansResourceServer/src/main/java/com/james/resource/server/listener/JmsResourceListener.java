package com.james.resource.server.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.james.core.library.model.User;
import com.james.core.library.service.db.UserDatabaseService;

@Component
@ComponentScan(basePackages = {
	"com.james.core.library"
})
public class JmsResourceListener {
	@Autowired
	UserDatabaseService userDatabaseService;
	
	@JmsListener(destination="YIFAN.POTHOUSE.USER.REGISTER")
    public void receiveUserRegisterRequest(User newUser) {
		userDatabaseService.registerNewUser(newUser);
    }
}