package com.example.demo;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.aop.AopInvocationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {


	@Autowired
	private EmployeeDAOImp employeDAO;
	
	@Autowired
	private VehicleDAOImp vehicleDAO;
	
	@Autowired
	private PriceDAOImp priceDAO;
	
	@Autowired
	private ImageDAOImp imageDAO;
	
	@Transactional
	public int addEmployee(Employee employee) throws SQLException, IOException {
		return employeDAO.save(employee).getEmpId();
	}

	@Transactional
	public Employee getEmployee(int empId) throws IOException, SQLException {
		return employeDAO.findById(empId).orElse(null);
	}
	
	@Transactional
	public boolean checkEmailWithEmapid(int empId, String emailID) {
		try {
			int Id = (int) employeDAO.checkEmailWithEmapid(empId, emailID);
			System.out.println("ser "+Id);
			return false;
		}catch(AopInvocationException e){
			return true;
		}
	}
	
	@Transactional
	public void updateEmployee(Employee employee) throws SQLException {
		employeDAO.save(employee);
	}

	@Transactional
	public int checkAuthentication(String emailID, String password) throws SQLException, IOException {
		try {
			return employeDAO.checkAuthentication(emailID, password);
		}catch(AopInvocationException e) {
			return 0;
		}
	}
	
	@Transactional
	public int checkEmailId(String emailID) throws SQLException, IOException {
		try {
			return employeDAO.checkEmailId(emailID);
		}catch(AopInvocationException e) {
			return 0;
		}
	}

	@Transactional
	public List<Employee> getEmployeeFriends(int empId) throws SQLException {
		Employee employee = employeDAO.findById(empId).orElse(new Employee());
		return employeDAO.findFriends(employee.getOrganization(), empId);
	}

	@Transactional
	public void addVehicle(Vehicle vehicle) throws SQLException {
		vehicleDAO.save(vehicle);
	}

	@Transactional
	public void addVehiclePrice(GetPassModel getPassModel) throws SQLException {
		priceDAO.save(getPassModel);
	}

	@Transactional
	public String getOldPassword(int empId) throws SQLException {
		return employeDAO.getOldPassword(empId);
	}
	
	@Transactional
	public void changePassword(Employee employee) throws SQLException {
		employeDAO.save(employee);
	}

	@Transactional
	public void setEmployeeImage(ImageModel imageName) throws SQLException {
		imageDAO.save(imageName);
	}
	
	@Transactional
	public String getEmployeeImage(int empId) throws SQLException {
		String name = imageDAO.getEmployeeImage(empId);
		System.out.println(name);
		
		if((String.valueOf(name).equals("NaN"))) {
			System.out.println("Avtar");
			return "Avatar.jpg";
		}
		return name;
	}
}
