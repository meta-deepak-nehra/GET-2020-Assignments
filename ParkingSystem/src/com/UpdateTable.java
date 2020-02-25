package com;


import java.io.IOException;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*import com.connection.*;
import com.mysql.jdbc.Statement;
*/

@WebServlet("/UpdateTable")
public class UpdateTable extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try
		{
	
			Connection con = ConnectionUtility.getConnection();
			Statement stmt = (Statement) con.createStatement();
			String fullName=request.getParameter("fullname");
			String gender=request.getParameter("gender");
			String email=request.getParameter("email");
			String contactNumber=request.getParameter("contactNumber");
			String organization=request.getParameter("organization");
			
			HttpSession session=request.getSession(false);
			String id= ""+session .getAttribute("id");
			
			String query="update employees set FullName='"+fullName+"',Gender='"+gender+"',Email='"+email+"',"
						 + "ContactNumber='"+contactNumber+"',Organization='"+organization+"' where EmployeeID='"+id+"'";
			
			stmt.executeUpdate(query);
			
			RequestDispatcher rd=request.getRequestDispatcher("HomePage.jsp");
			rd.forward(request,response);
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	
	}

}
