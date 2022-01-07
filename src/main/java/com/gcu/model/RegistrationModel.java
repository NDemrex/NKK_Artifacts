package com.gcu.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class RegistrationModel {
	//User Name
	@NotNull(message = "user name is required")
	@Size(min = 1, max = 15, message = "you need 1 - 32 char")
	private String UserName;
	//Password
	@NotNull(message = "password is required")
	@Size(min = 1, max = 15, message = "you need 1 - 32 char")
	private String Password;
	//First Name
	@NotNull(message = "First Name is Required")
	@Size(min = 1, max = 15, message = "you need 1 - 32 char")
	private String FirstName;
	//LastName
	@NotNull(message = "Last Name is Required")
	@Size(min = 1, max = 15, message = "you need 1 - 32 char")
	private String LastName;
	//Email
	@NotNull(message = "You Must Enter An Email")
	@Size(min = 1, max = 15, message = "you need 1 - 32 char")
	private String EmailAddress;
	//Phone Number
	@NotNull(message = "Give Me Your Number")
	@Size(min = 1, max = 15, message = "you need 1 - 32 char")
	private String PhoneNumber;

	

	@Override
	public String toString() {
		return "RegistrationModel [userName=" + UserName + ", password=" + Password + ", FirstName=" + FirstName
				+ ", LastName=" + LastName + ", EmailAddress=" + EmailAddress + ", PhoneNumber=" + PhoneNumber + "]";
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		this.UserName = userName;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		this.Password = password;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getEmailAddress() {
		return EmailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		EmailAddress = emailAddress;
	}

	public String getPhoneNumber() {
		return PhoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}

}
