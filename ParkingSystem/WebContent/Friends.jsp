<%-- <%@page import="com.mysql.jdbc.ResultSet"%> --%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1 "
    pageEncoding="ISO-8859-1"%>
   <%@ page import="java.sql.*,com.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Friends</title>
</head>
<body>

<h1 align="right">
<a href="logout.jsp">Logout</a>
</h1>

<%
try
{
	Connection con = ConnectionUtility.getConnection();
	Statement stmt = (Statement) con.createStatement();
	
	String id=""+session.getAttribute("id");
	
	System.out.println(id);
	String queryGetOrganaization="Select * from employees where EmployeeID='"+id+"'";
	ResultSet rs1= (ResultSet)stmt.executeQuery(queryGetOrganaization);
	
	rs1.next();
	String organization=rs1.getString("Organization");
	
	
	String queryGetNames="Select * from employees where Organization='"+organization+"' AND EmployeeID!='"+id+"'";
	ResultSet rs2= (ResultSet)stmt.executeQuery(queryGetNames);
	
	
	out.print("<html><body><table>");
	out.println("<tr><th>Names</th></tr>");
	while(rs2.next())
	{
		out.print("<tr><td>"+rs2.getString("FullName"));
	}
	out.print("</table></body></html>");
		
}
catch(Exception e)
{
	
	e.printStackTrace();
}
%>
</body>
</html>