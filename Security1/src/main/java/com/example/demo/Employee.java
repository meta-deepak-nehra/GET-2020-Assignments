package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Employee")
public class Employee {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="emp_id")
	private int empId;
    
	@NotBlank
	@Column
	private String name;
    
	@NotBlank
	@Email
	@Column
	private String emailID;
    
	@NotBlank
	@Column
	private String number;
    
	@NotBlank
	@Size(min = 1, max =  20)
	@Column//(updatable = true)
	private String password;
	
	@NotBlank
	@Size(min = 1, max =  20)
	@Transient
	private String ConfirmPassword;
	
	@NotBlank
	@Column
	private String gender;
    
	@NotBlank
	@Column
	private String Organization;

	@OneToMany(cascade =  CascadeType.ALL)
	@JoinColumn(name = "emp_id", referencedColumnName = "emp_id")
    private List<Vehicle> vehicle = new ArrayList<Vehicle>();
	
	@OneToMany(cascade =  CascadeType.ALL)
	@JoinColumn(name = "emp_id", referencedColumnName = "emp_id")
    private List<GetPassModel> GetPassModel = new ArrayList<GetPassModel>();
	
	@OneToOne(mappedBy="employee")
    private ImageModel imageModel;
	
	

	public List<GetPassModel> getGetPassModel() {
		return GetPassModel;
	}

	public void setGetPassModel(List<GetPassModel> getPassModel) {
		GetPassModel = getPassModel;
	}

	public void setImageModel(ImageModel imageModel) {
		this.imageModel = imageModel;
	}

	public List<Vehicle> getVehicle() {
		return vehicle;
	}

	public void setVehicle(List<Vehicle> vehicle) {
		this.vehicle = vehicle;
	}

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
