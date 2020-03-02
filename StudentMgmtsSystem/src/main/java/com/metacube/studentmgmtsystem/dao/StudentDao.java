package com.metacube.studentmgmtsystem.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.metacube.studentmgmtsystem.model.Student;

@Repository
public class StudentDao {
	private static List<Student> studentsList = new ArrayList<Student>();
	private static int counter = 1;
	
	/**
	 * For adding student in list.
	 * @param newStudent Student to be added.
	 * @return Return the acknowledge.
	 */
	public boolean addStudent(Student newStudent) {
		newStudent.setId(counter);
		studentsList.add(newStudent);
		System.out.println(newStudent.getId()+"	"+newStudent.getFirst_name()+"	"+newStudent.getLast_name()+"	"+newStudent.getFather_name()+"	"+newStudent.getEmail()+"	"+newStudent.getStd()+"	"+newStudent.getAge());
		counter++;
		return true;
	}

	/**
	 * Function to get list of all students.
	 */
	public List<Student> getAllStudents() {
		return studentsList;
	}
	
	
}
