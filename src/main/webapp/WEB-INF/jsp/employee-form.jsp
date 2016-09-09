<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html lang="en">

<head>
	<title>Employee Form</title>
	<link href="/css/app.css" type="text/css" rel="stylesheet"/>
	<link href="/css/bootstrap.min.css" type="text/css" rel="stylesheet"/>
</head>
<body>
	<form:form commandName="employee" modelAttribute="employee" action="/employee" method="POST" cssClass="form-horizontal">
		<spring:hasBindErrors name="employee">
		<div class="has-error">
			<form:errors path="*" cssStyle="color: red">
			</form:errors>
		</div>
		</spring:hasBindErrors>
		<div class="form-group">
			<form:label path="firstName" cssClass="col-sm-2 control-label" cssErrorClass="col-sm-2 control-label has-error">
				<spring:message code="label.firstName"/>
			</form:label>
			<div class="col-sm-10">
				<form:input path="firstName" cssClass="form-control" cssErrorClass="error"/> <br/>
			</div>
		</div>
		
		<div class="form-group">
			<form:label path="middleName" cssClass="col-sm-2 control-label">
				<spring:message code="label.middleName"/>
			</form:label>
			<div class="col-sm-10">
				<form:input path="middleName" cssClass="form-control" cssErrorClass="error"/> <br/>
			</div>
		</div>
		
		<div class="form-group">
			<form:label path="lastName" cssClass="col-sm-2 control-label">
				<spring:message code="label.lastName"/>
			</form:label>
			<div class="col-sm-10">
				<form:input path="lastName" cssClass="form-control" cssErrorClass="error"/> <br/>
			</div>
		</div>
		
		<div class="form-group">
			<form:label path="age" cssClass="col-sm-2 control-label">
				<spring:message code="label.age"/>
			</form:label>
			<div class="col-sm-10">
				<form:input path="age" cssClass="form-control" cssErrorClass="error"/> <br/>
			</div>
		</div>
		
		<div class="form-group">
			<form:label path="email" cssClass="col-sm-2 control-label">
				<spring:message code="label.email"/>
			</form:label>
			<div class="col-sm-10">
				<form:input path="email" cssClass="form-control" cssErrorClass="error"/> <br/>
			</div>
		</div>
		
		
		
		<input type="submit" value="SUBMIT"/>
	</form:form>
</body>

</html>