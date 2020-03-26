package com.example.demo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageDAOImp extends CrudRepository<ImageModel, Integer>{

	@Query("select imagename from ImageModel where empId = :empId")
	String getEmployeeImage(@Param("empId") int empId);

}
