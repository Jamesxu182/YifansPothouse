package com.james.core.library.service.message;

import com.james.core.library.model.User;

public interface UserMessageService {
	public void sendUserRegisterRequest(User user);
}
