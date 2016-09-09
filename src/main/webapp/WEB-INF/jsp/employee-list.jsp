<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html lang="en">

<head>
	<title>Employee List</title>
	<link href="/css/app.css" type="text/css" rel="stylesheet"/>
	<link href="/css/bootstrap.min.css" type="text/css" rel="stylesheet"/>
</head>
<body>
	<table>
		<thead>
			<tr>
				<th>First Name</th>
				<th>Last Name</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${employees }" var="employee">
			<tr>
				<td>${employee.firstName }</td>
				<td>${employee.lastName }</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
</body>

</html>