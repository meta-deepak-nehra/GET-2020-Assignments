package ques1;

public class Employee 
{
	private int employeeID = 0;
	private String employeeName = null;
	private String employeeAddress = null;
	
	public Employee(int employeeID, String employeeName, String employeeAddress)
	{
		this.employeeID = employeeID;
		this.employeeName = employeeName;
		this.employeeAddress = employeeAddress;
	}
	
	public boolean equals(Object e)
	{
		return this.employeeID == ((Employee)e).employeeID;
	}
	
	 public int hashCode() 
	 { 
	     return this.employeeID; 
         } 
	
	public String toString() 
	{ 
	    return "\nName: '" + this.employeeName + "', ID: '" + this.employeeID + "', address: '" + this.employeeAddress + "'";
	} 
	
	public int getEmployeeID() 
	{
		return employeeID;
	}

	public String getEmployeeName() 
	{
		return employeeName;
	}

	public String getEmployeeAddress() 
	{
		return employeeAddress;
	}
}
