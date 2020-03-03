package com;


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


@WebServlet("/VehicleRegistration")
public class VehicleRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try
		{
			Connection con=ConnectionUtility.getConnection();
			String vehicleName=request.getParameter("vehicleName");
			String vehicleType=request.getParameter("vehicleType");
			String vehicleNumber=request.getParameter("vehicleNumber");
			String identification=request.getParameter("identification");
			String empId=request.getParameter("empId");
			
			PreparedStatement stmt= con.prepareStatement("insert into vehicles values(VehicleID,?,?,?,?,?)");
			
			stmt.setString(1, vehicleName);
			stmt.setString(2, vehicleType);
			stmt.setString(3, vehicleNumber);
			stmt.setString(4, empId);
			stmt.setString(5, identification);
			stmt.executeUpdate();
			
			String idQuery="select VehicleID from vehicles where EmpID='"+empId+"'";
			Statement stm1 = (Statement) con.createStatement();
			ResultSet rs=stm1.executeQuery(idQuery);
			String vehId="";
			if(rs.next())
			{
				vehId=rs.getString("VehicleID");
				request.setAttribute("vehId", vehId);
			}
			
			request.setAttribute("VehicleType", vehicleType);
			RequestDispatcher rd= request.getRequestDispatcher("Pass.jsp?empid="+empId+"&vehId="+vehId);
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
