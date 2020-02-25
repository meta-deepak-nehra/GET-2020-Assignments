<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*,com.*"
	
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>HomePage</title>
</head>
<body>

<h1 align="right">
<a href="logout.jsp">Logout</a>
</h1>
<fieldset>
<legend name="formTitle"> Details </legend>
<%
String fullName="";
String lastName="";
String email="";
String contactNumber="";
String organization="";
try
{
	
		Connection con = ConnectionUtility.getConnection();
		String id=""+session.getAttribute("id");
		String query = "select * from employees where EmployeeID='"+id+"'";

		Statement stm1 = (Statement) con.createStatement();
		ResultSet rs = stm1.executeQuery(query);
	if(rs.next())
	{
		fullName = rs.getString("FullName");
		lastName = rs.getString("Gender");
		email = rs.getString("Email");
		contactNumber = rs.getString("ContactNumber");
		organization = rs.getString("Organization");
	}
	} 
catch (Exception e) {
		e.printStackTrace();
	}
%>
<table>
<tr><th>Full Name</th><th>Gender</th><th>Email</th><th>Contact Number </th><th>Organization</th></tr>

<tr><td><%=fullName%></td><td><%=lastName%></td><td><%=email%></td><td><%=contactNumber%></td><td><%=organization%></td><td>
</fieldset>
<form action="Update.jsp" method="post">
<input type="submit" value="update">
</form></td><td>

<form action="Friends.jsp" method="post">
<input type="submit" value="Friends">
</form>

</td>
</tr>
</table>
</body>
</html>