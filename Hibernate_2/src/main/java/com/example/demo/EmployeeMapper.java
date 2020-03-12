package com.example.demo;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class EmployeeMapper implements RowMapper<Employee> {

	@Override
	public Employee mapRow(ResultSet resultSet, int i) throws SQLException {

		Employee employee = new Employee();
		employee.setEmpId(resultSet.getInt("empId"));
		employee.setName(resultSet.getString("name"));
		employee.setNumber(resultSet.getString("number"));
		employee.setEmailID(resultSet.getString("emailId"));
		employee.setGender(resultSet.getString("gender"));
		employee.setOrganization(resultSet.getString("organization"));
		return employee;
	}

}
