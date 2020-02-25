package com;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/RegisterEmployee")
public class RegisterEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		try
		{
			String fullName=request.getParameter("empName");
			String gender=request.getParameter("gender");
			String email=request.getParameter("emailid");	
			String password= request.getParameter("empPassword");
			String contactNumber=request.getParameter("empPhoneNumber");
			String organization=request.getParameter("organization");
			Connection con=ConnectionUtility.getConnection();
			
			PreparedStatement stmt=con.prepareStatement("insert into employees values(EmployeeID,?,?,?,?,?,?)");
			
			stmt.setString(1, fullName);
			stmt.setString(2, gender);
			stmt.setString(3, email);
			stmt.setString(4, password);
			stmt.setString(5, contactNumber);
			stmt.setString(6, organization);
			
			stmt.executeUpdate();
			
			String idQuery="select EmployeeID from employees where ContactNumber='"+contactNumber+"'";
			Statement stm1 = (Statement) con.createStatement();
			ResultSet rs=stm1.executeQuery(idQuery);
			if(rs.next())
			{
				String empId=rs.getString("EmployeeID");
				
				request.setAttribute("empId", empId);
			}	
			
			
				RequestDispatcher rd= request.getRequestDispatcher("VehicleRegistration.jsp");
				rd.forward(request, response);
			
		}
		catch(Exception e)
		{
			PrintWriter out=response.getWriter();
			e.printStackTrace();
			System.out.println("Error in employee Registration");
			out.print("<html><body><p>"+e.getMessage()+"</p></body></html>");
		}
	}

}
