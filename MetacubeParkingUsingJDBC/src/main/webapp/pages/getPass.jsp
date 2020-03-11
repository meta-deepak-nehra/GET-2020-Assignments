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

<spring:url value="/getPass" var="userActionUrl" />
	<div id="containRegistrationForm" class="empForm">
		<form:form modelAttribute="getPassModel" action="${userActionUrl}" method = "post">
			<table>
				<tr>
					<th id="heading" colspan="3">${passType}</th>
				</tr>
				<tr>
					<th>Daily Pass</th>
					<th>Monthly Pass</th>
					<th>Yearly Pass</th>
				</tr>
				<tr>
					
					<td><label><form:radiobutton path="price" value = "${Daily}" id="r1" class="Price"/>
					<input id="price1" class="passinput" type="text" placeholder = "${Daily}" readonly/></label></td>
					
					
					<td><label><form:radiobutton path="price" value = "${Monthly}" id="r2" class="Price"/>
					<input id="price2" class="passinput" type="text" placeholder = "${Monthly}" readonly/></label></td>
					
					
					<td><label><form:radiobutton path="price" value = "${Yearly}" id="r3" class="Price"/>
					<input id="price3" class="passinput" type="text" placeholder = "${Yearly}" readonly/></label></td>
					
				</tr>
				<tr><form:errors path="price" cssClass="text-danger"/></tr>
			</table>
			<input id="submitRegistration" type="submit" value="GET PRICE"/> <br>
			<br>
			<br>

		</form:form>
	</div>
</body>
</html>