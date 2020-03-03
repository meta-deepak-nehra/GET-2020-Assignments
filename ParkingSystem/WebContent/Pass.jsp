<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pass</title>
<script type="text/javascript">

function currencyChanger() {
    var currency = document.getElementById("currencySelector").value;
	var vehicleType='<%=request.getAttribute("VehicleType") %>';
	var factor;
    if (currency == "INR") {
        factor = 1;
    }
    if (currency == "USD") {
        factor = 0.014;
    }
    if (currency == "YEN") {
        factor = 1.54;
    }

    if (vehicleType == "Cycle") {
        document.getElementById("daily").value = (5 * factor).toFixed(2);
        document.getElementById("monthly").value = (100 * factor).toFixed(2);
        document.getElementById("yearly").value = (500 * factor).toFixed(2);
    }
    if (vehicleType == "Bike") {
        document.getElementById("daily").value = (100 * factor).toFixed(2);
        document.getElementById("monthly").value = (200 * factor).toFixed(2);
        document.getElementById("yearly").value = (1000 * factor).toFixed(2);
    }
    if (vehicleType == "Car") {
        document.getElementById("daily").value = (20 * factor).toFixed(2);
        document.getElementById("monthly").value = (500 * factor).toFixed(2);
        document.getElementById("yearly").value = (3500 * factor).toFixed(2);
    }

}


</script>
</head>
<body onload="currencyChanger()">
	<%
String empId = request.getParameter("empid");
String vehId=request.getParameter("vehId");
 %>
	<fieldset>
		<legend id="passes form">Passes</legend>



		<form id="passes" method="post" action="PassDetails">
			<input type="text" readonly required placeholder="Employee id" name="empId" value="<%=empId%>" style="display : none;"> <br><br>
			<input type="text" readonly required placeholder="vehicle id" name="vehId" value="<%=vehId%>" style="display : none;"> <br>
			<br> <select id="currencySelector" onchange="currencyChanger()">
				<!-- <option disabled selected hidden>Currency</option> -->
				<option value="INR" selected>INR</option>
				<option value="USD">USD</option>
				<option value="YEN">YEN</option>
			</select><br> 
			Daily : <input type="radio" name="passes" value="daily">
			<input type="text" id="daily" name="daily" disabled> <br>
			<br> 
			Monthly : <input type="radio" name="passes" value="monthly">
			<input type="text" id="monthly" name="monthly" disabled> <br>
			<br> 
			Yearly : <input type="radio" name="passes" value="yearly">
			<input type="text" id="yearly" name="yearly" disabled> <br>
			<br> 
			<br> <br> 
			<input type="submit" value="submit">
		</form>
	</fieldset>

</body>
</html>