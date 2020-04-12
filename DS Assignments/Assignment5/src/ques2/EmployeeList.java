package ques2;

public class EmployeeList 
{
   EmployeeNode  head = null;
   
   public void addEmployee(String name, int salary, int age) throws Exception
   {   
	   if(salary < 0)
	   {
		   throw new Exception("salary can't be negative ");
	   }
	   if(age <= 0)
	   {
		   throw new Exception("age can't be negative or zero");
	   }
	   
	   EmployeeNode employee =  new EmployeeNode(new Employee(name , salary, age));
	   
	   if(head == null)
	   {
		   head = employee;
	   }
	   else
	   {
		   sort(employee);
	   }
   }
   
   public void sort(EmployeeNode employee)
   {
	  EmployeeNode employeeNode = head;
	  try
	  {
		  while(employeeNode != null)
		  {
			  if(employeeNode.getEmployee().getSalary() == employee.getEmployee().getSalary() )
			  {
				 
				  if(employeeNode.getEmployee().getAge() > employee.getEmployee().getAge())
				  { 
					  swap(employeeNode, employee);
	 				  	  
					  break;
				  }
				  else if(employeeNode.getEmployee().getAge() < employee.getEmployee().getAge())
				  { 
					  if(employeeNode.next == null )
					  {
						  employeeNode.next = employee;
						  employee.previous = employeeNode;
					  }
					  else
					  {
						  employee.next = employeeNode.next;
						  employee.previous = employeeNode;
						  employeeNode.next.previous = employee;
						  employeeNode.next = employee;
					  }
	 				  	  
					  break;
				  }
				  
			  }
			  else if(employeeNode.getEmployee().getSalary() < employee.getEmployee().getSalary())
			  { 
				  swap(employeeNode, employee);
				  
				  break;
			  }
			  
			  if(employeeNode.next == null)
			  { 
				  employeeNode.next = employee;
				  employee.previous = employeeNode;
				  break;
			  }
			  
			  employeeNode = employeeNode.next;
		  } 
	  }
	  catch(Exception e)
	  {
		  System.out.println(e);
	  }	  
   }
   
   public EmployeeNode showEmployee()
   {
	   EmployeeNode employee = head;
	   
	   while(employee != null)
	   {
		   System.out.println("Employee Name = " + employee.getEmployee().getName() + "\n Employee Salary = " + employee.getEmployee().getSalary() + "\n Employee age = " + employee.getEmployee().getAge());
		   employee = employee.next;
	   }
	   
	   return head;
   }
   
   private void swap(EmployeeNode employeeNode, EmployeeNode employee)
   {
	   if(employeeNode.previous == null)
		  {
			employeeNode.previous = employee;
			employee.next = employeeNode;
			head = employee;
		  }
		  else
		  {
		     employee.previous = employeeNode.previous;
		     employeeNode.previous.next = employee;
		     employee.next = employeeNode;
		  }   
   }
   
   
   public static void main(String arg[]) throws Exception
   {
	   EmployeeList obj = new EmployeeList();
	   
	   obj.addEmployee("a", 16000, 28);
	   obj.addEmployee("a", 160, 25);
	   obj.addEmployee("a", 106, 35);
	   obj.addEmployee("a", 216, 30);
	   obj.addEmployee("a", 1, 40);
	   obj.addEmployee("a", 6, 30);
	   obj.addEmployee("a", 1600, 1);
	   obj.addEmployee("a", 1600, 3);
	   obj.addEmployee("a", 1060, 30);
	   obj.addEmployee("a", 16, 30);
		obj.showEmployee();
	
   }
}
