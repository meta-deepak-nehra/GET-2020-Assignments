package com.example.demo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

/**
 * Class for the DAO layer.
 */
@Repository
public class EmployeeDAO {
	private final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private final String DB_URL = "jdbc:mysql://localhost/metacubeparkingspring";
    private final String DB_user  = "root";
    private final String DB_PASS = "root";
    private Connection con = null;
    private Statement stm = null;
    private ResultSet rs = null;
    private ResultSet friendsList = null;
    
    /**
     * Function to establish connection with database.
     */
    public void connection(){
        try {
            Class.forName(JDBC_DRIVER);
            con = (Connection) DriverManager.getConnection(DB_URL, DB_user,
                    DB_PASS);
        } catch (Exception e) {
            System.out.println("Error : "+e.getMessage());
        }
    }

    /**
     * Function to add new employee in our database.
     * @param employee to be added in database.
     * @return Returns the empID after adding that employee to database.
     * @throws SQLException SQL Exception
     * @throws IOException IO Exception
     */
	public int addEmployee(Employee employee) throws SQLException, IOException {
		if( checkEmailId(employee.getEmailID())==0) {
			PreparedStatement ps = con
	                .prepareStatement("insert into Employee(empId,name, emailId,number, gender, password, Organization) values(empId,?,?,?,?,?,?)");
	        ps.setString(1, employee.getName());
	        ps.setString(2, employee.getEmailID());
	        ps.setString(3, employee.getNumber());
	        ps.setString(4, employee.getGender());
	        ps.setString(5, employee.getPassword());
	        ps.setString(6, employee.getOrganization());
	        ps.executeUpdate();
	        connection();
        	stm = (Statement) con.createStatement();
        	rs = stm.executeQuery("select empId from Employee where emailId ='"+employee.getEmailID()+"'");
        	rs.next();
        	System.out.println(rs.getInt("empId"));
        	return rs.getInt("empId");
        }
		else {
			return 0;
		}
	}

	/**
	 * Function to check whether any user is registered with given emailID.
	 * @param emailID which is checked in our database.
	 * @return Return the empID if any employee is registered with given emailID.
	 * @throws SQLException SQL Exception
	 */
	public int checkEmailId(String emailID) throws SQLException {
		connection();
			stm = null;
			int empId = 0;
			
	        stm = (Statement) con.createStatement();
	        String strQuery = "SELECT empId FROM Employee where emailId='"+emailID+"'";
	        rs = stm.executeQuery(strQuery);
	        while(rs.next()) {
	        	empId = (int)rs.getLong("empId");
	        	System.out.println(empId);
	        	return empId;
	        }
	        return empId;
	}

	/**
	 * Function to add vehicle in our database.
	 * @param vehicle to be added in database.
	 * @throws SQLException SQL Exception
	 */
	public void addVehicle(Vehicle vehicle) throws SQLException{
        PreparedStatement ps = con
                .prepareStatement("insert into vehicle(empId, vehicle_name, vehicle_type, vehicle_number, Identification, currency) values(?,?,?,?,?,?)");
        ps.setLong(1, vehicle.getEmpId());
        ps.setString(2, vehicle.getVehicleName());
        ps.setString(3, vehicle.getVehicleType());
        ps.setString(4, vehicle.getVehicleNumber());
        ps.setString(5, vehicle.getIdentification());
        ps.setString(6, vehicle.getCurrency());
        ps.executeUpdate();
        
    }
	
	/**
	 * Function for adding price for the pass of parking. 
	 * @param empId for which pass will be generated.
	 * @param price to be deposited by user.
	 * @throws SQLException SQL Exception
	 */
	public void addVehiclePrice(int empId, double price) throws SQLException{
        PreparedStatement ps = con
                .prepareStatement("insert into Price(empId, price) values(?,?)");
        ps.setLong(1, empId);
        ps.setDouble(2, price);
        ps.executeUpdate();
    }
	
	/**
	 * Function to get the employee from database.
	 * @param empId of the user of which we have to retrieve the data from database.
	 * @return Return the data of the employee.
	 * @throws IOException IO Exception
	 * @throws SQLException SQL Exception
	 */
	public Employee getEmployee(int empId) throws  IOException, SQLException{
		connection();
		Employee employee = new Employee();
			stm = null;
	        stm = (Statement) con.createStatement();
	        String strQuery = "SELECT * FROM Employee where empId="+empId;
	        rs = stm.executeQuery(strQuery);
	        rs.next();
	        employee.setEmpId(Integer.parseInt(rs.getString("empId")));
	        employee.setName(rs.getString("name"));
	        employee.setEmailID(rs.getString("emailId"));
	        employee.setGender(rs.getString("gender"));
	        employee.setNumber(rs.getString("number"));
	        employee.setOrganization(rs.getString("organization"));
	        
			return employee;
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
		connection();
        stm = null; 
        int empId = 0;
        stm = (Statement) con.createStatement();
        String strQuery = "SELECT empId FROM Employee where emailId='"
                + email + "' && password = '"+password+"'";
        rs = stm.executeQuery(strQuery);
        while (rs.next()) { 
        	empId = Integer.parseInt(rs.getString("empId"));
        	return empId; 
        }
        return empId;
    }
	
	/**
	 * Function to get the friends of the employee.
	 * @param empId of the employee whose friends we want to get.
	 * @return Return the list of friends of employee.
	 * @throws SQLException SQL Exception
	 */
	public List<Employee> getEmployeeFriends(int empId) throws SQLException {
		connection();
		stm = null;        
        stm = (Statement) con.createStatement();
        List<Employee> employees = new ArrayList<Employee>();
        
        String strQuery = "SELECT organization FROM Employee where empId="+empId;
        rs = stm.executeQuery(strQuery);
        rs.next();
        String friendListQuery = "SELECT * FROM Employee where organization='"
                + rs.getString("organization")+"'  order by name";
        friendsList = stm.executeQuery(friendListQuery);
        
        while(friendsList.next()) {
        	Employee employee = new Employee();
        	employee.setEmpId((int)friendsList.getLong("empId"));
	        employee.setName(friendsList.getString("name"));
	        employee.setEmailID(friendsList.getString("emailId"));
	        employee.setGender(friendsList.getString("gender"));
	        employee.setNumber(friendsList.getString("number"));
	        employee.setOrganization(friendsList.getString("organization"));
	        employees.add(employee);
        }
        return employees;
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
		connection();
		stm = null;        
        stm = (Statement) con.createStatement();
        String strQuery = "SELECT password FROM Employee where empId="
                + empId;
        String updateQuery = "update Employee set password = '"+newPassword+"' where empId = "+empId;
        rs = stm.executeQuery(strQuery);
        rs.next();
        if(oldPassword.equals(rs.getString("password"))){
            stm.execute(updateQuery);
            return true;
        }
        return false;
	}
	
	/**
	 * Function to close connection of database.
	 * @throws SQLException SQL Exception
	 */
	public void close() throws SQLException{
        con.close();
    }

	/**
	 * Function to update the data of employee.
	 * @param updateModel data that will be updated for that employee.
	 * @return  Return boolean value depending on the data update.
	 * @throws SQLException SQL Exception
	 */
	public boolean updateEmployee(UpdateModel updateModel) throws SQLException {	
		String checkQuery = "select emailId from Employee where empId != "+updateModel.getEmpId()+" && "
				+ "emailId = '"+updateModel.getEmailID()+"'";
		rs = stm.executeQuery(checkQuery);
		if(rs.next()){
            return false;
        }
        else {
            String Query = "update Employee set name = '"+updateModel.getName()+"', "
                            + "emailId = '"+updateModel.getEmailID()+"', "
                                    + "number = '"+updateModel.getNumber()+"' , "
                                            + "organization = '"+updateModel.getOrganization()+"' where empId = "+updateModel.getEmpId();
            stm.execute(Query);
            return true;
            
        }
	}

	/**
	 * Function to set the image of the employee.
	 * @param empId of employee whose image will be uploaded.
	 * @param imageName Name of the image which we are uploading.
	 * @throws SQLException SQL Exception
	 */
	public void setEmployeeImage(int empId, String imageName) throws SQLException {
		connection();
		stm = null;
				
		stm = (Statement) con.createStatement();
		String checkQuery = "select empId from image where empId = "+empId;
		rs = stm.executeQuery(checkQuery);
		if(!rs.next()) {
			PreparedStatement insert = con
                .prepareStatement("insert into image values(?, ?)");
	        insert.setLong(1, empId);
	        insert.setString(2, imageName);
	        insert.executeUpdate();
		}
		else {
			PreparedStatement insert = con
	                .prepareStatement("update image set imagename = ? where empId = "+empId);
		    insert.setString(1, imageName);
		    insert.executeUpdate();
		}
    
	}
	
	/**
	 * Function to get image from database which we have to show as profile picture.
	 * @param empId of employee whose image will be showed.
	 * @return Returns the name of the image.
	 * @throws SQLException SQL Exception
	 */
	public String getEmployeeImage(int empId) throws SQLException {
		connection();
		stm = null;
		String imageName = "Avatar.jpg";
				
		stm = (Statement) con.createStatement();
		String strQuery = "SELECT imagename FROM image where empId="+empId;
		rs = stm.executeQuery(strQuery);
		while(rs.next()) {
		   	imageName = rs.getString("imagename");
		}
		return imageName;
	}


}

