package com.example.demo;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Service layer for communication between controller layer and DAO layer.
 */
@Service
public class EmployeeService {


	@Autowired
	private EmployeeDAO employeDAO;
	
	/**
     * Function to add new employee in our database.
     * @param employee to be added in database.
     * @return Returns the empID after adding that employee to database.
     * @throws SQLException SQL Exception
     * @throws IOException IO Exception
     */
	public int addEmployee(Employee employee) throws SQLException, IOException {
		return employeDAO.addEmployee(employee);
	}

	/**
	 * Function to get the employee from database.
	 * @param empId of the user of which we have to retrieve the data from database.
	 * @return Return the data of the employee.
	 * @throws IOException IO Exception
	 * @throws SQLException SQL Exception
	 */
	public Employee getEmployee(int empId) throws IOException, SQLException {
		return employeDAO.getEmployee(empId);
	}

	/**
	 * Function to update the data of employee.
	 * @param updateModel data that will be updated for that employee.
	 * @return  Return boolean value depending on the data update.
	 * @throws SQLException SQL Exception
	 */
	public boolean updateEmployee(UpdateModel updateModel) throws SQLException {
		
		return employeDAO.updateEmployee(updateModel);
	}

	/**
	 * Function to authenticate the user while login.
	 * @param email of user to be authenticated.
	 * @param password of user to be authenticated.
	 * @return Return the employee ID of the user.
	 * @throws SQLException SQL Exception
	 * @throws IOException IO Exception
	 */
	public int checkAuthentication(String emailID, String password) throws SQLException, IOException {
		return employeDAO.checkAuthentication(emailID, password);
	}
	
	/**
	 * Function to check whether any user is registered with given emailID.
	 * @param emailID which is checked in our database.
	 * @return Return the empID if any employee is registered with given emailID.
	 * @throws SQLException SQL Exception
	 */
	public int checkEmailId(String emailID) throws SQLException, IOException {
		return employeDAO.checkEmailId(emailID);
	}

	/**
	 * Function to get the friends of the employee.
	 * @param empId of the employee whose friends we want to get.
	 * @return Return the list of friends of employee.
	 * @throws SQLException SQL Exception
	 */
	public List<Employee> getEmployeeFriends(int empId) throws SQLException {
		return employeDAO.getEmployeeFriends(empId);
	}

	/**
	 * Function to add vehicle in our database.
	 * @param vehicle to be added in database.
	 * @throws SQLException SQL Exception
	 */
	public void addVehicle(Vehicle vehicle) throws SQLException {
		employeDAO.addVehicle(vehicle);
	}

	/**
	 * Function for adding price for the pass of parking. 
	 * @param empId for which pass will be generated.
	 * @param price to be deposited by user.
	 * @throws SQLException SQL Exception
	 */
	public void addVehiclePrice(int empId, double price) throws SQLException {
		employeDAO.addVehiclePrice(empId, price);
	}

	/**
	 * Function to change the password.
	 * @param empId of employee whose password need to be changed.
	 * @param newPassword Password which we have to set. 
	 * @param oldPassword Old password which we are changing.
	 * @return Return boolean value depending on change of the password.
	 * @throws SQLException SQL Exception
	 */
	public boolean changePassword(int empId, String newPassword, String oldPassword) throws SQLException {
		return employeDAO.changePassword(empId, newPassword, oldPassword);
	}

	/**
	 * Function to set the image of the employee.
	 * @param empId of employee whose image will be uploaded.
	 * @param imageName Name of the image which we are uploading.
	 * @throws SQLException SQL Exception
	 */
	public void setEmployeeImage(int empId, String imageName) throws SQLException {
		employeDAO.setEmployeeImage(empId, imageName);
	}
	
	/**
	 * Function to get image from database which we have to show as profile picture.
	 * @param empId of employee whose image will be showed.
	 * @return Returns the name of the image.
	 * @throws SQLException SQL Exception
	 */
	public String getEmployeeImage(int empId) throws SQLException {
		return employeDAO.getEmployeeImage(empId);
	}

//	public void setEmployeeImage(int empId, byte[] bytes) throws SQLException {
//		employeDAO.setEmployeeImage(empId, bytes);
//	}
//	public String getEmployeeImage(int empId) throws SQLException {
//		return employeDAO.getEmployeeImage(empId);
//	}

}
