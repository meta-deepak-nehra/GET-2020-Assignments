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

<spring:url value="/vehicleRegistration" var="userActionUrl" />
	<div id="containRegistrationForm" class="empForm">
		<div class="empFormHeading">
			<h1>Add Vehicle</h1>
		</div>
		<form:form modelAttribute="vehicle" action="${userActionUrl}" method="post">

			<fieldset>
				<legend>Vehicle Name</legend>
				<form:input path="vehicleName" type="text" class="input" id="inputVehicleName" placeholder="Vehicle Name" /><br>
				<form:errors path="vehicleName" cssClass="text-danger" /><br>
                
			</fieldset>
			<fieldset>
				<legend>Vehicle Number</legend>
				<form:input path="vehicleNumber" type="text" class="input" id="VehicleNumber" placeholder="Vehicle Number" /><br>
				<form:errors path="vehicleNumber" cssClass="text-danger" /><br>
                
			</fieldset>
			<fieldset>
				<legend>Employee ID</legend>
				<form:input path="empId" type="text" class="input" id="empId" value="${vehicle.getEmployee().getEmpId()}" readonly="true"/><br>
				<form:errors path="empId" cssClass="text-danger" /><br>
                
			</fieldset>
			<fieldset>
				<legend>Identification</legend>
				<form:textarea id="Identification" class="input" path="Identification" placeholder="Identification"/>
				<form:errors path="Identification" cssClass="text-danger" /><br>
                
			</fieldset>
			
			<form:select path = "vehicleType" id = "VehicleName">
                    <form:option value = "Cycle" label = "Cycle"/>
                    <form:option value = "MotorCycle" label = "MotorCycle"/>
                    <form:option value = "FourWheelers" label = "Four Wheelers"/>
            </form:select><br>
			<form:select path = "currency" id = "VehicleCurrency">
                    <form:option value = "INR" label = "INR"/>
                    <form:option value = "USD" label = "USD"/>
                    <form:option value = "YEN" label = "YEN"/>
            </form:select><br>
			 <input id="submitVehical" type="submit" /><br>
			<br> <br>
		</form:form>
	</div>
	<script>
//	let url = new URL(window.location);
//	let empId = url.searchParams.get("empId");
//	alert(empId);
//	document.getElementById("empId").placeholder = empId;
//	document.getElementById("empId").value = empId;
</script>
</body>
</html>