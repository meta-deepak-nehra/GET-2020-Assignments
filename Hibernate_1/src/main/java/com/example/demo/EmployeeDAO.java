package com.example.demo;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;


@Repository
public class EmployeeDAO {

    @Autowired
    private EntityManager entityManager;
    
    
	public int addEmployee(Employee employee) throws SQLException, IOException {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.save(employee);		
		return checkEmailId(employee.getEmailID());	
	}

	public Integer checkEmailId(String emailID) throws SQLException {
		try {
			Session currentSession = entityManager.unwrap(Session.class);
			@SuppressWarnings("rawtypes")
			Query query = currentSession.createQuery("SELECT empId FROM Employee WHERE emailId =:emailID");
		    query.setParameter("emailID", emailID);
		    System.out.println("sdfghjkl");
		    System.out.println((int)query.uniqueResult());
		    return (int)query.uniqueResult();
		}catch(NullPointerException e) {
			return 0;
		}
	}

	public void addVehicle(Vehicle vehicle) throws SQLException{
		Session currentSession = entityManager.unwrap(Session.class);
		System.out.println(vehicle.getEmpId());
		currentSession.save(vehicle);		
    }
	
	public void addVehiclePrice(GetPassModel getPassModel) throws SQLException{
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.save(getPassModel);
    }
	
	public Employee getEmployee(int empId) throws  IOException, SQLException{
		
		Session currentSession = entityManager.unwrap(Session.class);
		Query query = currentSession.createQuery("FROM Employee WHERE empId =:empId");
	    query.setParameter("empId", empId);
	    return (Employee) query.uniqueResult();
	}
	
	public int checkAuthentication(String email, String password) throws SQLException, IOException{
        try{
        	Session currentSession = entityManager.unwrap(Session.class);
			@SuppressWarnings("rawtypes")
			Query query = currentSession.createQuery("SELECT empId FROM Employee WHERE emailId =:email AND password =:password");
		    query.setParameter("email", email);
		    query.setParameter("password", password);
		    System.out.println("email password");
		    System.out.println((int)query.uniqueResult());
		    return (int)query.uniqueResult();
        }catch(NullPointerException e) {
        	return 0;
        }
    }
	
	public List<Employee> getEmployeeFriends(int empId) throws SQLException {
		Session currentSession = entityManager.unwrap(Session.class);
		Query query = currentSession.createQuery("SELECT Organization from Employee WHERE empId =:empId");
		query.setParameter("empId", empId);
		String organizarion =  (String) query.uniqueResult();
		System.out.println((String) query.uniqueResult());
		
		Session currentSession1 = entityManager.unwrap(Session.class);
		Query<Employee> query1 = currentSession1.createQuery("from Employee where Organization=:organizarion order by name");
		query1.setParameter("organizarion", organizarion);
		List<Employee> employeeLlist = query1.getResultList();
		return employeeLlist;
	}

	public String getOldPassword(int empId) throws SQLException {
        Session currentSession = entityManager.unwrap(Session.class);
		@SuppressWarnings("rawtypes")
		Query query = currentSession.createQuery("SELECT password FROM Employee WHERE empId =:empId");
	    query.setParameter("empId", empId);
	    System.out.println((String)query.uniqueResult());
	    return (String)query.uniqueResult();
	}
	
	public void changePassword(Employee employee) {
        	Session currentSession1 = entityManager.unwrap(Session.class);
        	currentSession1.update(employee);
	}

	public boolean checkEmailWithEmapid(int empId, String emailId) {
		try {
			Session currentSession = entityManager.unwrap(Session.class);
			@SuppressWarnings("rawtypes")
			Query query = currentSession.createQuery("select empId from Employee where empId !=:empId AND emailId =:emailId");
		    query.setParameter("empId", empId);
		    query.setParameter("emailId", emailId);
		    System.out.println((String)query.uniqueResult());
		    query.uniqueResult();
			return true;
		}catch(NullPointerException e) {
			return false;
		}
	}
	public void updateEmployee(Employee employee) {
    	Session currentSession1 = entityManager.unwrap(Session.class);
    	currentSession1.update(employee);
	}

	public boolean checkEmpidInImage(int empId) {
		try {
			Session currentSession = entityManager.unwrap(Session.class);
			@SuppressWarnings("rawtypes")
			Query query = currentSession.createQuery("select empId from ImageModel where empId =:empId");
		    query.setParameter("empId", empId);
		    System.out.println((int)query.uniqueResult());
		    query.uniqueResult();
			return true;
		}catch(NullPointerException e) {
			return false;
		}
	}
	
	public void setEmployeeImage(ImageModel image, int empId) throws SQLException {
		if(!checkEmpidInImage(empId)) {
		Session currentSession1 = entityManager.unwrap(Session.class);
    	currentSession1.save(image);
		}
		else {
		Session currentSession1 = entityManager.unwrap(Session.class);
    	currentSession1.update(image);
		}
	}
	
	
	public String getEmployeeImage(int empId) throws SQLException {
		try {
			Session currentSession = entityManager.unwrap(Session.class);
			@SuppressWarnings("rawtypes")
			Query query = currentSession.createQuery("select imagename from ImageModel where empId = :empId");
		    query.setParameter("empId", empId);
		    System.out.println((String)query.uniqueResult());
		    
			return (String)query.uniqueResult();
		}catch(NullPointerException e) {
			return "Avatar.jpg";
		}
	}
}