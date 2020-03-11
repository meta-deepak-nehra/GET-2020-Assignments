package com.example.demo;

import javax.validation.constraints.NotBlank;

/**
 * POJO class for a vehicle and getters and setters for its attributes.
 */
public class Vehicle {
	
    int empId;
	
	@NotBlank
    String vehicleName;
	
	@NotBlank
    String vehicleType;
	
	@NotBlank
    String vehicleNumber;
	
	@NotBlank
    String Identification;
	
	@NotBlank
    String currency;
	
    public int getEmpId() {
        return empId;
    }
    public void setEmpId(int empId) {
        this.empId = empId;
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
}
