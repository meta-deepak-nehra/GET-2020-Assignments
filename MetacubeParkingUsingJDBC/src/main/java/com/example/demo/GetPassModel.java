package com.example.demo;

import javax.validation.constraints.Min;
/**
 * POJO class for getting Pass and getters and setters for its attributes.
 */
public class GetPassModel {
	
	private int empId;
	
	@Min(value = 1, message = "Select Price")
	private double price;

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}
