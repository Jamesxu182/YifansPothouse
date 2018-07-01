package com.james.core.library.channel;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface UserRegisterProcessor {	
	String USER_REGISTER_REQUEST_OUTPUT_CHANNEL = "user-register-request-channel-output";
	
	String USER_REGISTER_REQUEST_INPUT_CHANNEL = "user-register-request-channel-input";
	
	@Output(USER_REGISTER_REQUEST_OUTPUT_CHANNEL)
	MessageChannel requestToCreateNewUser();
	
	@Input(USER_REGISTER_REQUEST_INPUT_CHANNEL)
	SubscribableChannel processUserRegisterRequest();
}
