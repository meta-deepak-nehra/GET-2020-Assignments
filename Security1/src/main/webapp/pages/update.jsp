<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
<link rel="stylesheet" href="Styling.css">
<script src = 'registration.js'></script>
</head>
<body>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url value="/update" var="userActionUrl" />
        <div id = "containRegistrationForm" class = "empForm">
            <div class = "empFormHeading">
                <h1>UPDATE</h1>
            </div>
            <form:form modelAttribute="employee" action="${userActionUrl}" onsubmit = "return varification()" method = "post">
                
                <form:errors />
				<form:hidden path="empId"/>
                <fieldset>
                <legend>Name</legend>
				<form:input path="name" type="text" class="input" id="Name" placeholder="Name" /><br>
				<form:errors path="name" cssClass="text-danger" /><br>
                
                </fieldset>
				
                <fieldset>
                    <legend>Email ID</legend>
                    <form:input path="emailID" type="email" class="input" id="EmailID" placeholder="Email ID" /><br>
					<form:errors path="emailID" cssClass="text-danger" /><br>
                </fieldset>
                
                <fieldset>
                    <legend>Mobile Number</legend>
                    <form:input path="number" type="text" class="input" id="MobileNumber" placeholder="Mobile Number" /><br>
					<form:errors path="number" cssClass="text-danger" /><br>
                </fieldset>
                
                	<label><form:radiobutton path="gender" class="gender" id="r1" value="Male" label="Male"/></label>
                	<label><form:radiobutton path="gender" class="gender" id="r2" value="Female" label="Female"/></label>
                	<label><form:radiobutton path="gender" class="gender" id="r3" value="Other" label="Other"/></label><br>
					<form:errors path="gender" cssClass="text-danger" /><br>
                
				<form:select path = "Organization" id = "Organization">
                    <form:option value = "M1" label = "M1"/>
                    <form:option value = "M2" label = "M2"/>
                    <form:option value = "M3" label = "M3"/>
                </form:select><br>
                
                <input id = "submitRegistration" type = "submit" value="SUBMIT"/>
                
                <br><br><br>
                
            </form:form>
        </div>
</body>
</html>