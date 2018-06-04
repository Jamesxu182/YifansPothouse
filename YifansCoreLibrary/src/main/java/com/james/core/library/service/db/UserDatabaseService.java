package com.james.core.library.service.db;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.james.core.library.model.User;

public interface UserDatabaseService extends UserDetailsService {
	void registerNewUser(User newUser);
}
