package com.example.demo;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class UpdateModel {

	private int empId;
    
	@NotBlank
	private String name;
    
	@NotBlank
	@Email
	private String emailID;
    
	@NotBlank
	private String number;
	
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
