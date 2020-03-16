<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<link rel="stylesheet" href="Styling.css">
</head>
<body>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url value="/loginuser" var="userActionUrl" />

	<div id="containRegistrationForm" class="empForm">
		<div class="empFormHeading">
			<h1>LOGIN</h1>
		</div>
		<form:form modelAttribute="LoginModel" action="${userActionUrl}" method = "post">
			<fieldset>
				<legend>Email ID</legend>
				<form:input path="emailID" type="email" class="input" id="EmailID" placeholder="Email ID" /><br>
				<form:errors path="emailID" cssClass="text-danger" /><br>
			</fieldset>
			<fieldset>
				<legend>Password</legend>
				<form:input path="password" type="Password" class="input" id="Password" placeholder="Password" /><br>
				<form:errors path="password" cssClass="text-danger" /><br>
			</fieldset>
			<input id="submitRegistration" type="submit" value="Login" /> 
			<a href="/signup"> <input id="submitLogin" type="button" value="SignUp" /></a> <br> <br> <br>
		</form:form>
	</div>

</body>
</html>