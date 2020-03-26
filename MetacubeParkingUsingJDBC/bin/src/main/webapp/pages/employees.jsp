<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<%@include file="../includes/header.jsp" %>


<table class="table table-striped">
    <thead>
      <tr>
      	<th>Id</th>
        <th>Name</th>
        <th>Email</th>
        <th>Password</th>
        <th>Action</th>
      </tr>
    </thead>
    <tbody>
    <c:forEach items="${employees}" var="employee">


 <tr>   <td>${employee.id}</td>
        <td>${employee.name}</td>
        <td>${employee.email}</td>
        <td>${employee.password}</td>
         <td><a href="/employees/${employee.id}" class="btn btn-primary">Edit</a> </td>
      </tr>

</c:forEach>
     
      
    </tbody>
  </table>



<%@include file="../includes/footer.jsp" %>

