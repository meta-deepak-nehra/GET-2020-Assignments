package com.example.demo;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {


	@Autowired
	private EmployeeDAO employeDAO;
	
	@Transactional
	public int addEmployee(Employee employee) throws SQLException, IOException {
		return employeDAO.addEmployee(employee);
	}

	@Transactional
	public Employee getEmployee(int empId) throws IOException, SQLException {
		return employeDAO.getEmployee(empId);
	}
	@Transactional
	public boolean checkEmailWithEmapid(int empId, String emailID) {
		return employeDAO.checkEmailWithEmapid(empId, emailID);
	}
	
	@Transactional
	public void updateEmployee(Employee employee) throws SQLException {
		employeDAO.updateEmployee(employee);
	}

	@Transactional
	public int checkAuthentication(String emailID, String password) throws SQLException, IOException {
		return employeDAO.checkAuthentication(emailID, password);
	}
	
	@Transactional
	public int checkEmailId(String emailID) throws SQLException, IOException {
		return employeDAO.checkEmailId(emailID);
	}

	@Transactional
	public List<Employee> getEmployeeFriends(int empId) throws SQLException {
		return employeDAO.getEmployeeFriends(empId);
	}

	@Transactional
	public void addVehicle(Vehicle vehicle) throws SQLException {
		employeDAO.addVehicle(vehicle);
	}

	@Transactional
	public void addVehiclePrice(GetPassModel getPassModel) throws SQLException {
		employeDAO.addVehiclePrice(getPassModel);
	}

	@Transactional
	public String getOldPassword(int empId) throws SQLException {
		return employeDAO.getOldPassword(empId);
	}
	
	@Transactional
	public void changePassword(Employee employee) throws SQLException {
		employeDAO.changePassword(employee);
	}

	@Transactional
	public void setEmployeeImage(ImageModel imageName, int empId) throws SQLException {
		employeDAO.setEmployeeImage(imageName, empId);
	}
	
	@Transactional
	public String getEmployeeImage(int empId) throws SQLException {
		return employeDAO.getEmployeeImage(empId);
	}
}
