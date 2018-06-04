package com.james.web.server.form;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.james.core.library.model.User;

public class UserRegisterRequestForm {
	String username;
	String email;
	String password;
	
	@JsonIgnore
	String repeatedPassword;
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getRepeatedPassword() {
		return repeatedPassword;
	}
	
	public void setRepeated_password(String repeatedPassword) {
		this.repeatedPassword = repeatedPassword;
	}
	
	public User getUser() {
		return new User(this.username, this.email, this.password);
	}
}
