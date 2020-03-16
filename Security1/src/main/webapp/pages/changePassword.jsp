<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<link rel="stylesheet" href="Styling.css">
<script src = 'registration.js'></script>
</head>
<body>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url value="/changePassword" var="userActionUrl" />
		<div id = "containRegistrationForm" class = "empForm">
            <div class = "empFormHeading">
                <h1>Change Password</h1>
            </div>
            
            <form:form modelAttribute="changePasswordModel" action="${userActionUrl}" onsubmit = "return varification()" method = "post">
              
           		<fieldset>
                    <legend>Old Password</legend>
                    <form:input path="OldPassword" type="Password" class="input" id="OldPassword" placeholder="Old Password" /><br>
					<form:errors path="OldPassword" cssClass="text-danger" /><br>
                </fieldset>

                <fieldset>
                    <legend>New Password</legend>
                    <form:input path="NewPassword" type="Password" class="input" id="Password" placeholder="New Password" /><br>
					<form:errors path="NewPassword" cssClass="text-danger" /><br>
                </fieldset>

                <fieldset>
                    <legend>Confirm Password</legend>
                    <form:input path="ConfirmPassword" type="Password" class="input" id="ConfirmPassword" placeholder="Confirm Password" /><br>
					<form:errors path="ConfirmPassword" cssClass="text-danger" /><br>
                </fieldset>
                
                
                <input id = "submitRegistration" type = "submit" value="SUBMIT" onclick = "registration()"/>
                
                <br><br><br>
                
            </form:form>
        </div>
</body>
</html>