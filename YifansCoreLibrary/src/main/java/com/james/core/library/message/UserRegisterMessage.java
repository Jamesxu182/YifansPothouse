package com.james.core.library.message;

import java.util.HashMap;
import java.util.Map;

import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;

import com.james.core.library.model.User;

public class UserRegisterMessage implements Message<User> {
	private Map<String, Object> headers;
	private User payload;
	
	public UserRegisterMessage(Map<String, Object> headers, User user) {
		this.payload = user;
		this.headers = new HashMap<String, Object>();
		
		if(headers != null && !headers.isEmpty()) {
			this.headers.putAll(headers);;
		}
	}
	
	@Override
	public User getPayload() {
		return this.payload;
	}

	@Override
	public MessageHeaders getHeaders() {
		return new MessageHeaders(this.headers);
	}
	
}
