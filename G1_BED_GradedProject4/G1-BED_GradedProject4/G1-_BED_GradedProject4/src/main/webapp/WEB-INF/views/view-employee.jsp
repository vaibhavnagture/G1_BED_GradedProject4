<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">

<title>View Employee</title>
</head>

<body>

	<div class="container">

		<br>
		<h3>Employee Details</h3>
		<hr>
		
	    <div class="card">
	      <div class="container">
	        <h2>${Employee.firstName} ${Employee.lastName}</h2>
	        <p>${Employee.email}</p>
	      </div>
	    </div>

		<hr>
		<a href="/EmployeeManagement/employees/list" class="btn btn-primary btn-sm mb-3" >Back to Employees List</a>
	</div>
</body>

</html>










