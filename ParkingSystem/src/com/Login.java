package com;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.*;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try
		{
			Connection con = ConnectionUtility.getConnection();
			String email=request.getParameter("email");
			String password=request.getParameter("password");
			String query="select EmployeeID, Password from employees where Email='"+email+"'";
			Statement stmt= con.createStatement();
			ResultSet rs= stmt.executeQuery(query);
			String dbPassword="";
			PrintWriter out=response.getWriter();
			String id="";
			
			if(rs.next())
			{
				dbPassword=rs.getString("Password");
				id=rs.getString("EmployeeID");
				
				if(password.equals(dbPassword))
				{	
					HttpSession session=request.getSession();
					session.setAttribute("id", id);
					
					RequestDispatcher rd=request.getRequestDispatcher("HomePage.jsp");
					rd.forward(request,response);
				
				}
				else
				{
					out.print("Invalid password");
				}
				
			}
			else
			{
				out.print("User not found");
			}
			
			
			
		}
		
		catch(Exception e)
		{
			PrintWriter out=response.getWriter();
			out.print(e.getMessage());
			e.printStackTrace();
		}
		
		
	}

}
