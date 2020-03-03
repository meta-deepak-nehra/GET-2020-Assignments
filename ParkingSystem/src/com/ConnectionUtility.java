package com;
import java.sql.*;


public class ConnectionUtility 
{
	public static Connection con;
	
	public static Connection getConnection()
	{
		
		if(con==null)
		{
			try
			{
			Class.forName("com.mysql.jdbc.Driver");
			
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/MetacubeParking","root","root");
						
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
		
		return con;
	}
	

}
