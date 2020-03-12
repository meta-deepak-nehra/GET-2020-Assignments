package com.example.demo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Image")
public class ImageModel {
		
	@Id
	@Column(name="emp_id")
	private int empId;
	
//	@OneToOne
//	@JoinColumn(name = "empId")
//    @MapsId
	@OneToOne(cascade =  CascadeType.ALL)
	@JoinColumn(name = "emp_id", referencedColumnName = "emp_id")
	private Employee employee;
	
	@Column
	private String imagename;
	
	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	
	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public String getImagename() {
		return imagename;
	}

	public void setImagename(String imagename) {
		this.imagename = imagename;
	}
}
