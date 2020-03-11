package com.example.demo;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
/**
 * POJO class for employee and getters and setters for its attributes.
 */
public class Employee {

	
	private int empId;
    
	@NotBlank
	private String name;
    
	@NotBlank
	@Email
	private String emailID;
    
	@NotBlank
	private String number;
    
	@NotBlank
	@Size(min = 1, max =  20)
	private String password;
	
	@NotBlank
	@Size(min = 1, max =  20)
	private String ConfirmPassword;
	
	@NotBlank
	private String gender;
    
	@NotBlank
	private String Organization;

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmailID() {
		return emailID;
	}

	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getConfirmPassword() {
		return ConfirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		ConfirmPassword = confirmPassword;
	}

//	public String getOldPassword() {
//		return OldPassword;
//	}
//
//	public void setOldPassword(String oldPassword) {
//		OldPassword = oldPassword;
//	}
//	
//	public String getNewPassword() {
//		return NewPassword;
//	}
//
//	public void setNewPassword(String newPassword) {
//		NewPassword = newPassword;
//	}
	
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getOrganization() {
		return Organization;
	}

	public void setOrganization(String organization) {
		Organization = organization;
	}
}
