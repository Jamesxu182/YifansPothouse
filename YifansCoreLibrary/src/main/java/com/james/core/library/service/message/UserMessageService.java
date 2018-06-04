package com.james.core.library.service.message;

import com.james.core.library.model.User;

public interface UserMessageService {
	public static final String USER_REGISTER_REQUEST_ROUTING_KEY = "user.register.request";

	public void sendUserRegisterRequest(User user);
}
