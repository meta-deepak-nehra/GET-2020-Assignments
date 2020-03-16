package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeDAOImp extends CrudRepository<Employee, Integer> {

	@Query("Select empId from Employee where emailId = :emailId")
	int findEmpIdByEmailId(@Param("emailId") String emailId);

	@Query("from Employee where organization = :orgName and empId <> :empId")
	List<Employee> findFriends(@Param("orgName") String orgName, @Param("empId") int empId);

	@Query("SELECT empId FROM Employee where emailId=:emailId")
	int checkEmailId(@Param("emailId") String emailId);

	@Query("SELECT empId FROM Employee where emailId=:emailId AND password =:password")
	int checkAuthentication(@Param("emailId") String emailId, @Param("password") String password);

	@Query("SELECT password FROM Employee WHERE empId =:empId")
	String getOldPassword(@Param("empId") int empId);

	@Query("select empId from Employee where empId <> :empId AND emailId =:emailId")
	int checkEmailWithEmapid(@Param("empId") int empId, @Param("emailId") String emailID);

}