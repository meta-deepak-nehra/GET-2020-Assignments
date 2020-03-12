<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
html {
  scroll-behavior: smooth;
}
body {
	font-family: Arial, Helvetica, sans-serif;
	margin: 0;
}

* {
	box-sizing: border-box;
}
/* Header/logo Title */
.header {
	padding: 80px;
	text-align: center;
	background: #1abc9c;
	color: white;
}

/* Increase the font size of the heading */
.header h1 {
	font-size: 40px;
}

.navbar {
	overflow: hidden;
	background-color: #333;
	position: sticky;
	top: 0;
}

/* Style the navigation bar links */
.navbar a {
	float: left;
	display: block;
	color: white;
	text-align: center;
	padding: 14px 20px;
	text-decoration: none;
}

/* Right-aligned link */
.navbar a.right {
	float: right;
}

/* Change color on hover */
.navbar a:hover {
	background-color: #ddd;
	color: black;
}

/* Active/current link */
.navbar a.active {
	background-color: #666;
	color: white;
}

.avt {
	width: 100px;
	border: 1px solid black;
	border-radius: 50%;
	margin: 12px 0 12px 0;
	text-align: center;
	border: none;
}

fieldset {
	margin: 80px auto;
	padding: 20px;
	padding-bottom: 0px;
	width: 800px;
	height: auto;
	border-radius: 25px;
	border: none;
	background: rgba(175, 238, 238, 0.575);
	box-shadow: 5px 25px 25px rgba(175, 238, 238, 0.575);
}

legend {
	text-align: center;
}

.column {
	float: left;
	width: 25%;
	padding: 0 10px;
	display: inline-block;
}

.row:after {
	content: "";
	display: table;
	clear: both;
}

.row {
	margin: 0 10px;
	overflow: auto;
	width: 100%;
	height: 160px;
	white-space: nowrap;
}

.card {
	box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
	padding: 16px;
	text-align: center;
	background-color: #f1f1f1;
}

.footer {
	padding: 10px;
	text-align: center;
	background: #ddd;
}
.image_logo{
	border-radius: 50%;
	width : 28px;
	height : 28px;
}
table {
	margin-right: 205px;
}

table, th, td {
	border: none;
	border-collapse: collapse;
}

th, td {
	padding: 15px;
}

th {
	text-align: left;
}

table {
	margin: auto;
}
</style>
</head>
<body>
	<div class="header">
		<h1>Metacube Parking System</h1>
	</div>
	 <nav class="navbar"> 
 		<a href="#home" class="active">Home</a> 
 		<a href="/vehicleRegistration">Vehicle Registration</a>
		<a href="/update">Update</a> 
		<a href="/changePassword">Change Password</a> 
		<a href="/logout" class="right">Log Out</a>
		<a href="/upload" class="right" style="padding: 9px 5px 5px 5px"><img src="${imageName}" class="image_logo" /></a>
		<a href="#section1"class="right">Welcome ${employee.name}</a> 
		 
	</nav>
	<section>
		<img class="mySlides" src="po.jpg" style="width: 100%"> 
		<img class="mySlides" src="parking1.jpg" style="width: 100%"> 
		<img class="mySlides" src="parking2.jpg" style="width: 100%"> 
		<img class="mySlides" src="parking3.jpg" style="width: 100%"> 
		<img class="mySlides" src="parking4.jpg" style="width: 100%">
		<script>
			// Automatic Slideshow - change image every 3 seconds
			var myIndex = 0;
			carousel();

			function carousel() {
				var i;
				var x = document.getElementsByClassName("mySlides");
				for (i = 0; i < x.length; i++) {
					x[i].style.display = "none";
				}
				myIndex++;
				if (myIndex > x.length) {
					myIndex = 1
				}
				x[myIndex - 1].style.display = "block";
				setTimeout(carousel, 3000);
			}
	</script>
	<div class="empForm" id="section1">
		<fieldset>
			<legend>
				<img src="${imageName}" class="avt">
			</legend>
			<table id="information">
				<tr>
					<th colspan="3" id="personalInformText"><h2>Personal
							Information</h2></th>
				</tr>
				<tr>
					<th>Employee ID</th>
					<th>:</th>
					<td id="idInReceipt">${employee.empId}</td>

				</tr>
				<tr>
					<th>Name</th>
					<th>:</th>
					<td id="nameInReceipt">${employee.name}</td>

				</tr>
				<tr>
					<th>Email ID</th>
					<th>:</th>
					<td id="nameInReceipt">${employee.emailID}</td>

				</tr>
				<tr>
					<th>Organization</th>
					<th>:</th>
					<td id="nameInReceipt">${employee.organization}</td>

				</tr>
				<tr>
					<th>Mobile Number</th>
					<th>:</th>
					<td id="numberInReceipt">${employee.number}</td>
				</tr>
				<tr>
					<th>Gender</th>
					<th>:</th>
					<td id="genderInReceipt">${employee.gender}</td>

				</tr>

			</table>

		</fieldset>
	</div>
	</section>
	<h2>Friends</h2>

	<div class="row">

	<c:forEach items="${employeeFriends}" var="employeeFriend">
		<div class="column">
			<div class="card">
				<h3>${employeeFriend.name}</h3>
				<p>${employeeFriend.organization}</p>
				<p>${employeeFriend.emailID}</p>
			</div>
		</div>
	</c:forEach>

	</div>

	<div class="footer">
		<h2>Footer</h2>
	</div>

</body>
</html>

