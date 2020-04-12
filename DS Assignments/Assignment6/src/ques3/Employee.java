package ques3;

public class Employee 
{
	private String empName;
	private int age;
	private int salary;
	
	public Employee(String empName, int age, int salary) 
	{
		this.empName = empName;
		this.age = age;
		this.salary = salary;
	}

	public int getSalary() 
	{
		return salary;
	}

	public int getAge()
	{
		return age;
	}

	public String getEmpName()
	{
		return empName;
	}
}
