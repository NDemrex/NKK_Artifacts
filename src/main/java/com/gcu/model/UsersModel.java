package com.gcu.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UsersModel {

	int id;

	@NotNull(message = "Username is required")
	@Size(min = 1, max = 15, message = "you need 1 - 32 char")
	String username;

	@NotNull(message = "Password is required")
	@Size(min = 1, max = 15, message = "you need 1 - 32 char")
	String password;

	@NotNull(message = "Users have to have a role. Application has security restrictions")
	@Size(min = 1, max = 15, message = "you need 1 - 32 char")
	String role;

	public UsersModel() {

		this.id = 0;
		this.username = "";
		this.password = "";
		this.role = "";
	}

	public UsersModel(int id, String username, String password, String role) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.role = role;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "UsersModel [id=" + id + ", username=" + username + ", password=" + password + ", role=" + role + "]";
	}
}
