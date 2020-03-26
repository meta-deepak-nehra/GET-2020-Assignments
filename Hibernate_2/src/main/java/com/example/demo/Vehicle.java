package com.example.demo;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="Vehicle")
public class Vehicle {
	
	
	@Column(name="emp_id")
	private int empId;
	
	@ManyToOne(cascade =  CascadeType.ALL)
	@JoinColumn(name = "emp_id", referencedColumnName = "emp_id", insertable = false, updatable = false, nullable = false)
	private Employee employee;
	

	@NotBlank
	@Column
    String vehicleName;
	
	@NotBlank
	@Column
    String vehicleType;
	
	@Id
	@NotBlank
	@Column
    String vehicleNumber;
	
	@NotBlank
    String Identification;
	
	@NotBlank
	@Column
    String currency;
	
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public String getVehicleName() {
        return vehicleName;
    }
    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }
    public String getVehicleType() {
        return vehicleType;
    }
    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }
    public String getVehicleNumber() {
        return vehicleNumber;
    }
    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }
    public String getIdentification() {
        return Identification;
    }
    public void setIdentification(String identification) {
        Identification = identification;
    }
    public String getCurrency() {
        return currency;
    }
    public void setCurrency(String currency) {
        this.currency = currency;
    }
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
}
