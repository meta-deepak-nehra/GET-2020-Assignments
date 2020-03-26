package com.example.demo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;

@Entity
@Table(name="Price")
public class GetPassModel {
	
	@Column(name="emp_id")
	private int empId;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int Id;
	
	
	@Min(value = 1, message = "Select Price")
	@Column
	private double price;
	

	@ManyToOne(cascade =  CascadeType.ALL)
	@JoinColumn(name = "emp_id", referencedColumnName = "emp_id", insertable = false, updatable = false, nullable = false)
	private Employee employee;
	
	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}
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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}
