package ques2;

public class EmployeeNode 
{
    private Employee employee;
    EmployeeNode previous;
    EmployeeNode next;
    
    public EmployeeNode(Employee employee)
    {
    	this.employee = employee;
    	next = null;
    	previous = null;
    }
    
    public Employee getEmployee()
    {
    	return employee;
    }
}