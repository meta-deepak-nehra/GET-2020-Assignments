package com.example.demo;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
/**
 * POJO class for changing password and getters and setters for old  password, new password and confirm password.
 */
public class ChangePasswordModel {
	
	@NotBlank
	@Size(min = 1, max =  20)
	private String OldPassword;
	
	@NotBlank
	@Size(min = 1, max =  20)
	private String NewPassword;
	
	@NotBlank
	@Size(min = 1, max =  20)
	private String ConfirmPassword;
	
	public String getOldPassword() {
		return OldPassword;
	}
	public void setOldPassword(String oldPassword) {
		OldPassword = oldPassword;
	}
	public String getNewPassword() {
		return NewPassword;
	}
	public void setNewPassword(String newPassword) {
		NewPassword = newPassword;
	}
	public String getConfirmPassword() {
		return ConfirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		ConfirmPassword = confirmPassword;
	}
}
