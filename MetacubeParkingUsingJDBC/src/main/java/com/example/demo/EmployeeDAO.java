package com.example.demo;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * Class for the DAO layer.
 */
@Repository
public class EmployeeDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    //insert query
    private String SQL_INSERT_USER = "insert into Employee(empId,name, emailId,number, gender, password, Organization) values(empId,?,?,?,?,?,?)";
    private String SQL_INSERT_VEHICLE = "insert into vehicle(empId, vehicle_name, vehicle_type, vehicle_number, Identification, currency) values(?,?,?,?,?,?)";
    private String SQL_INSERT_PRICE = "insert into Price(empId, price) values(?,?)";
    private String SQL_INSERT_IMAGE = "insert into image values(?, ?)";

    //update query
    private String SQL_UPDATE_PASSWORD  = "update Employee set password = ? where empId = ?";
    private String SQL_UPDATE_EMPLOYEE = "update Employee set name = ?, emailId = ?, number = ?, organization = ? where empId = ?";
    private String SQL_UPDATE_IMAGE = "update image set imagename = ? where empId = ?";
    
    //get query
    private String SQL_GET_EMPID_IF_EMAIL_EXIST = "SELECT empId FROM Employee where emailId=?";
    private String SQL_GET_EMPLOYEE = "SELECT * FROM Employee where empId=?";
    private String SQL_GET_ORGANIZATION = "SELECT organization FROM Employee where empId=?";
    private String SQL_GET_FRIENDS = "SELECT * FROM Employee where organization=? order by name";
    private String SQl_GET_PASSWORD = "SELECT password FROM Employee where empId=?";
    private String SQL_GET_IMAGE = "SELECT imagename FROM image where empId=?";
    
    //check query
    private String SQl_CHECK_AUTHENTICATION = "SELECT empId FROM Employee where emailId=? && password = ?";
    private String SQL_CHECK_EMAILID_WITH_EMPID = "select empId from Employee where empId != ? && emailId = ?";
    private String SQL_CHECK_EMPID_IN_IMAGE = "select empId from image where empId = ?";
    
    /**
     * Function to add new employee in our database.
     * @param employee to be added in database.
     * @return Returns the empID after adding that employee to database.
     * @throws SQLException SQL Exception
     * @throws IOException IO Exception
     */
	public int addEmployee(Employee employee) throws SQLException, IOException {
		if(checkEmailId(employee.getEmailID())==0) {
		jdbcTemplate.update(SQL_INSERT_USER, employee.getName(), employee.getEmailID(),
				employee.getNumber(), employee.getGender(), employee.getPassword(),
				employee.getOrganization());
		int empId = jdbcTemplate.queryForObject(SQL_GET_EMPID_IF_EMAIL_EXIST, new Object[] { employee.getEmailID() }, Integer.class);
		return empId;
		}
		else
		return 0;
	}
	/**
	 * Function to check whether any user is registered with given emailID.
	 * @param emailID which is checked in our database.
	 * @return Return the empID if any employee is registered with given emailID.
	 * @throws SQLException SQL Exception
	 */
	public Integer checkEmailId(String emailID) throws SQLException {
		try {
			int empId = jdbcTemplate.queryForObject(SQL_GET_EMPID_IF_EMAIL_EXIST, new Object[] { emailID }, Integer.class);
			return empId;
		}catch(EmptyResultDataAccessException e) {
			return 0;
		}
	}
	/**
	 * Function to add vehicle in our database.
	 * @param vehicle to be added in database.
	 * @throws SQLException SQL Exception
	 */
	public void addVehicle(Vehicle vehicle) throws SQLException{
        jdbcTemplate.update(SQL_INSERT_VEHICLE, vehicle.getEmpId(), vehicle.getVehicleName(),
        		vehicle.getVehicleType(), vehicle.getVehicleNumber(), vehicle.getIdentification(),
        		vehicle.getCurrency());
        
    }
	/**
	 * Function for adding price for the pass of parking. 
	 * @param empId for which pass will be generated.
	 * @param price to be deposited by user.
	 * @throws SQLException SQL Exception
	 */
	public void addVehiclePrice(int empId, double price) throws SQLException{
		jdbcTemplate.update(SQL_INSERT_PRICE, empId, price);
    }
	/**
	 * Function to get the employee from database.
	 * @param empId of the user of which we have to retrieve the data from database.
	 * @return Return the data of the employee.
	 * @throws IOException IO Exception
	 * @throws SQLException SQL Exception
	 */
	public Employee getEmployee(int empId) throws  IOException, SQLException{
			return jdbcTemplate.queryForObject(SQL_GET_EMPLOYEE, new Object[] { empId }, new EmployeeMapper());
		
	}
	/**
	 * Function to authenticate the user while login.
	 * @param email of user to be authenticated.
	 * @param password of user to be authenticated.
	 * @return Return the employee ID of the user.
	 * @throws SQLException SQL Exception
	 * @throws IOException IO Exception
	 */
	public int checkAuthentication(String email, String password) throws SQLException, IOException{
        try{
        int empId = jdbcTemplate.queryForObject(SQl_CHECK_AUTHENTICATION, new Object[] { email, password }, Integer.class);
        return empId;
        }catch(EmptyResultDataAccessException e) {
        	return 0;
        }
    }
	/**
	 * Function to get the friends of the employee.
	 * @param empId of the employee whose friends we want to get.
	 * @return Return the list of friends of employee.
	 * @throws SQLException SQL Exception
	 */
	public List<Employee> getEmployeeFriends(int empId) throws SQLException {
        String organizarion = jdbcTemplate.queryForObject(SQL_GET_ORGANIZATION, new Object[] { empId }, String.class);
		return jdbcTemplate.query(SQL_GET_FRIENDS, new Object[] { organizarion }, new EmployeeMapper());
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
        String password = jdbcTemplate.queryForObject(SQl_GET_PASSWORD, new Object[] { empId }, String.class);
        
        if(oldPassword.equals(password)){
        	jdbcTemplate.update(SQL_UPDATE_PASSWORD, newPassword, empId);
            return true;
        }
        return false;
        
	}
	/**
	 * Function to check emailId with empID. 
	 * @param updateModel Model which we have to update.
	 * @return Return boolean value depending on the result.
	 */
	public boolean checkEmailWithEmpid(UpdateModel updateModel) {
		try {
			jdbcTemplate.queryForObject(SQL_CHECK_EMAILID_WITH_EMPID, new Object[] {updateModel.getEmpId(),updateModel.getEmailID()}, Integer.class);
			return true;
		}catch(EmptyResultDataAccessException e) {
			return false;
		}
	}
	/**
	 * Function to update the data of employee.
	 * @param updateModel data that will be updated for that employee.
	 * @return  Return boolean value depending on the data update.
	 * @throws SQLException SQL Exception
	 */
	public boolean updateEmployee(UpdateModel updateModel) throws SQLException {
		if(checkEmailWithEmpid(updateModel)){
			return false;
        }
        else {
            jdbcTemplate.update(SQL_UPDATE_EMPLOYEE, updateModel.getName(), updateModel.getEmailID(),
            		updateModel.getNumber(), updateModel.getOrganization(), updateModel.getEmpId());
            return true;
        }
	}
	/**
	 * Function to check whether image of following user is present in database or not.
	 * @param empId Id of employee whose image we have to find.
	 * @return Return boolean value after checking if image is present or not.
	 */
	public boolean checkEmpidInImage(int empId) {
		try {
			jdbcTemplate.queryForObject(SQL_CHECK_EMPID_IN_IMAGE, new Object[] {empId}, Integer.class);
			return true;
		}catch(EmptyResultDataAccessException e) {
			return false;
		}
	}
	/**
	 * Function to set the image of the employee.
	 * @param empId of employee whose image will be uploaded.
	 * @param imageName Name of the image which we are uploading.
	 * @throws SQLException SQL Exception
	 */
	public void setEmployeeImage(int empId, String imageName) throws SQLException {
		if(!checkEmpidInImage(empId))
	        jdbcTemplate.update(SQL_INSERT_IMAGE, empId, imageName);
		else 
		    jdbcTemplate.update(SQL_UPDATE_IMAGE, imageName, empId);
	}
	
	/**
	 * Function to get image from database which we have to show as profile picture.
	 * @param empId of employee whose image will be showed.
	 * @return Returns the name of the image.
	 * @throws SQLException SQL Exception
	 */
	public String getEmployeeImage(int empId) throws SQLException {
		try {
			String imageName = jdbcTemplate.queryForObject(SQL_GET_IMAGE, new Object[] {empId}, String.class);
			return imageName;
		}catch(EmptyResultDataAccessException e) {
			return "Avatar.jpg";
		}
	}
}