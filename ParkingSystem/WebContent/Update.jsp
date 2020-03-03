<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*,com.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update</title>
</head>
<body>

	<h1 align="right">
		<a href="logout.jsp">Logout</a>
	</h1>

	<% 
String fullName="";
String gender="";
String email="";
String contactNumber="";
String organization="";
try
{
	Connection con = ConnectionUtility.getConnection();
	Statement stmt = (Statement) con.createStatement();
	
	String id= ""+session .getAttribute("id");
	String query= "select * from employees where EmployeeID='"+id+"'";
	ResultSet rs =stmt.executeQuery(query);
	
	
		rs.next();

		fullName = rs.getString("FullName");
		gender = rs.getString("Gender");
		email = rs.getString("Email");
		contactNumber = rs.getString("ContactNumber");
		organization = rs.getString("Organization");
 

}
catch(Exception e)
{
	e.printStackTrace();
}

%>
	<form action=UpdateTable method=post>
		<input type=text name="fullname" value=<%=fullName%>><br /> <input
			type=text name="gender" value=<%= gender%>> <br /> <input
			type=text name="email" value=<%=email%>><br /> <input
			type=text name="contactNumber" value=<%=contactNumber %>><br />
		<select name="organization" id="organization">
			<option disabled selected hidden>Organization</option>
			<option>Metacube</option>
			<option>Thrillophilia</option>
			<option>ATCS</option>
			<option>Infosys</option>
			<option>Mahindra</option>
		</select> <input type=submit value=update>
	</form>
	<%


%>
</body>
</html>