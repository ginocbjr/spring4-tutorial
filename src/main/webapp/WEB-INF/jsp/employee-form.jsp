<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html lang="en">

<head>
	<title>Employee Form</title>
</head>
<body>
	<form:form commandName="employee" modelAttribute="employee" action="/employee" method="POST">
		FIRST NAME <form:input path="firstName"/> <br/>
		MIDDLE NAME <form:input path="middleName"/> <br/>
		LAST NAME <form:input path="lastName"/> <br/>
		AGE <form:input path="age"/> <br/>
		
		<input type="submit" value="SUBMIT"/>
	</form:form>
</body>

</html>