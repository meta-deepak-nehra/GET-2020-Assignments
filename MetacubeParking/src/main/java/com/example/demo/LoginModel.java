package com.example.demo;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * POJO class for login and getters and setters for it's attributes.
 */
public class LoginModel {

	@NotBlank
	@Email
	private String emailID;
    
	@NotBlank
	@Size(min = 1, max =  20)
	private String password;

	public String getEmailID() {
		return emailID;
	}

	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
