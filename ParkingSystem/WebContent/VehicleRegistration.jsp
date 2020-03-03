<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <%String empId = ""+request.getAttribute("empId");%>
 
<%--  <input type="text" value=<%=rs.getString("empId")%>></input> --%>

<h1> Vehicle Registration</h1>
    <fieldset>
        <legend id="formTitle"> Vehicle Registration Form </legend>

        <form name="vehicleRegistrationForm" method="post" action="VehicleRegistration">

            <br>
            <input type="text" required placeholder="Vehicle Name" name="vehicleName"> <br> <br>

            <select name="vehicleType">
                <option disabled selected hidden>
                    type
                </option>
                 <option value="Cycle">
                     Cycle
                 </option>
                 <option value="Bike">
                    Bike
                </option>
                <option value="Car">
                    Car
                </option>
             </select>
            <br> <br>

            <input type="text" required placeholder="Vehicle Number" name="vehicleNumber"> <br> <br>
            <input type="text" readonly required placeholder="Employee id" name="empId" value="<%=empId%>"> <br> <br>
            <textarea rows="5" placeholder="Identification" name="identification"></textarea> <br> <br>

            <input type="submit" value="submit">
            <br> <br>
        </form>
    </fieldset>
    
</body>
</html>