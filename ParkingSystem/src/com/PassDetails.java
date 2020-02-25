package com;


import java.io.Console;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/PassDetails")
public class PassDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try
		{
			Connection con=ConnectionUtility.getConnection();
			String passType=request.getParameter("passes");
			String passPrice="";
				
			int empID = Integer.valueOf(request.getParameter("empId"));
			
			String idQuery="select VehicleID from vehicles where EmpID='"+empID+"'";
			Statement stm1 = (Statement) con.createStatement();
			ResultSet rs=stm1.executeQuery(idQuery);
			String vehID="";
			if(rs.next())
			{
				vehID=rs.getString("VehicleID");
			}
			
			String TypeQuery="select VehicleType from vehicles where VehicleID='"+vehID+"'";
			Statement stm2 = (Statement) con.createStatement();
			ResultSet rs2=stm2.executeQuery(TypeQuery);
			String VehicleType="";
			if(rs2.next())
			{
				VehicleType=rs2.getString("VehicleType");
			}
			
			if (VehicleType.equals("Cycle")) {
		        if(passType.equals("daily")) 
		        	passPrice="0.07";
		        else if(passType.equals("monthly")) 
		        	passPrice="1.40";
		        else if(passType.equals("yearly")) 
		        	passPrice="7.00";
		    }
			else if (VehicleType.equals("Bike")) {
		    	if(passType.equals("daily")) 
		    		passPrice="0.14";
		    	else if(passType.equals("monthly")) 
		    		passPrice="2.80";
		    	else if(passType.equals("yearly")) 
		    		passPrice="14.00";
		    }
			else if (VehicleType.equals("Car")) {
		        if(passType.equals("daily")) 
		        	passPrice="0.28";
		        else if(passType.equals("monthly")) 
		        	passPrice="7.00";
		        else if(passType.equals("yearly")) 
		        	passPrice="49.00";
		    }
			
			PreparedStatement stmt= con.prepareStatement("insert into passdata values(PassID,?,?,?,?)");
			stmt.setInt(1, empID);
			stmt.setString(2, vehID);
			stmt.setString(3, passType);
			stmt.setString(4, passPrice);
			stmt.executeUpdate();
			
			HttpSession session=request.getSession();
			session.setAttribute("id", empID);
			
			RequestDispatcher rd= request.getRequestDispatcher("HomePage.jsp");
			rd.forward(request, response);
			
		}
		catch(Exception e)
		{
			PrintWriter out=response.getWriter();
			e.printStackTrace();
			out.print("<html><body><p>"+e.getMessage()+"</p></body></html>");
		}
		
	}

}
