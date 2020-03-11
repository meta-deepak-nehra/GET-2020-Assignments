<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
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

<meta charset="UTF-8">
<title>Home</title>
</head>
<body>
 <nav class="navbar"> 
 	<a href="#home" class="active">Home</a> 
 	<a	href="#">Vehicle Registration</a>
	<a href="#">Update</a> 
	<a href="#">Change Password</a> 
	<a href="#" class="right">Log Out</a> </nav>

<div class="container">
  
