package ques1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;


public class EmployeeList 
{
	private List<Employee> listOfEmployees = new LinkedList<Employee>();
	public void addEmployee(int id, String name, String address)
	{ 
		try
		{
		   Employee employee = new Employee(id, name, address);
		   listOfEmployees.add(employee);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	public List<Employee> sortByNaturalOrder()
	{
		try
		{
			Comparator<Employee> comparator = Comparator.comparing( employee -> (employee.getEmployeeID()));
			listOfEmployees.sort(comparator);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		return listOfEmployees;
	}
	
	public List<Employee> sortByEmployeeName()
	{
		try
		{
			Comparator<Employee> comparator = Comparator.comparing( employee -> (employee.getEmployeeName()));
			listOfEmployees.sort(comparator);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return listOfEmployees;
	}
	
	public List<Employee>  getUniqueEmployeesList()
	{
		try
		{
			Set<Employee> listOfUniqueEmployees = new LinkedHashSet<Employee>(listOfEmployees);
			return new ArrayList<Employee> (listOfUniqueEmployees);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		return null;
	}

	public static void main(String[] args) 
	{	
		EmployeeList employee = new EmployeeList();
	     employee.addEmployee(9, "deepak", "mansarover");	
	     employee.addEmployee(2, "rahul", "skit");	
	     employee.addEmployee(1, "rajat", "jagatpura");
	     employee.addEmployee(4, "ayush", "git");	
	     employee.addEmployee(10, "harshit", "sector 9");	
	     employee.addEmployee(8, "sharad", "vaishali");	


		List listOfEmployeesSortedByNaturalOrder = employee.sortByNaturalOrder();
		List listOfEmployessSortedByEmployeeName = employee.sortByEmployeeName();
		List listOfUniqueEmployees = employee.getUniqueEmployeesList();
		
		System.out.println(listOfUniqueEmployees);
		System.out.println("-------------------------------");
		System.out.println(listOfEmployeesSortedByNaturalOrder);
		System.out.println("-------------------------------");
		System.out.println(listOfEmployessSortedByEmployeeName);
	}
}	
	
