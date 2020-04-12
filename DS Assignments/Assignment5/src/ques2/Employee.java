package ques2;

public class Employee 
{
	private int age;
    private String name;
    private int salary;  
    
    public Employee(String name, int salary, int age)
    {
    	this.setAge(age);
    	this.setName(name);
    	this.setSalary(salary);
    }
	public int getAge()
	{
		return age;
	}
	public void setAge(int age) 
	{
		this.age = age;
	}
	public String getName() 
	{
		return name;
	}
	public void setName(String name) 
	{
		this.name = name;
	}
	public int getSalary()
	{
		return salary;
	}
	public void setSalary(int salary) 
	{
		this.salary = salary;
	}
}