package com.gcu.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class LoginModel {

	@NotNull(message = "user name is required")

	@Size(min = 1, max = 15, message = "you need 1 - 32 char")

	private String username;

	@NotNull(message = "password is required")

	@Size(min = 1, max = 15, message = "you need 1 - 32 char")

	private String password;

	@Override
	public String toString() {
		return "LoginModel [userName=" + username + ", password=" + password + "]";
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


}
