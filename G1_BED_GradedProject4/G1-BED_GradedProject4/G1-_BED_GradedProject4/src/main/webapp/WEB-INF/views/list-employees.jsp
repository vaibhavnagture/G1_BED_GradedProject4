<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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

<title>Employees Directory</title>
</head>

<body>

	<div class="container">

		<br>
		<h3>Employees Directory</h3>
		<hr>

		<!-- Add a button -->
		<a href="/EmployeeManagement/employees/list?sort=asc" class="btn btn-primary btn-sm mb-3 mx-auto"> Sort Asc </a> 
		<a href="/EmployeeManagement/employees/list?sort=desc" class="btn btn-primary btn-sm mb-3 mx-auto"> Sort Desc </a>
		<a href="/EmployeeManagement/employees/add" class="btn btn-primary btn-sm mb-3"> Add Employee </a>
		<a href="/EmployeeManagement/logout" class="btn btn-danger btn-sm mb-3 mx-auto"> Logout </a> 

		<!-- Add a search form -->
		<form action="/EmployeeManagement/employees/search" class="form-inline">
			
			<input type="search" name="firstName" placeholder="First Name"
				class="form-control-sm ml-5 mr-2 mb-3" />
			<button type="submit" class="btn btn-success btn-sm mb-3">Search</button>

		</form>
	

		<table class="table table-bordered table-striped">
			<thead class="thead-dark">
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Action</th>
				</tr>
			</thead>

			<tbody>
				<c:forEach items="${Employees}" var="employee">
					<tr>
						<td><c:out value="${employee.firstName}" /></td>
						<td><c:out value="${employee.lastName}" /></td>
						<td><c:out value="${employee.email}" /></td>
						<td>
							<!-- Add "view" button --> 
							<a href="/EmployeeManagement/employees/view?employeeId=${employee.id}" 
								class="btn btn-info btn-sm">
							View </a>
							
							<!-- Add "update" button --> 
							<a href="/EmployeeManagement/employees/update?employeeId=${employee.id}" 
								class="btn btn-info btn-sm">
							Update </a>

							<!-- Add "delete" button -->
							<a href="/EmployeeManagement/employees/delete?employeeId=${employee.id}"
								class="btn btn-danger btn-sm"
								onclick="if (!(confirm('Are you sure you want to delete this employee?'))) return false">
							Delete </a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</div>

</body>
</html>



