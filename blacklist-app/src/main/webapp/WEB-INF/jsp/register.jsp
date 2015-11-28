<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="../layouts/header.jsp"%>



<form:form commandName="user" cssClass="form-horizontal form-signin">

	<div class="form-group">
		<label for="name" class="control-label">Name</label><br>
		<form:input path="userName" cssClass="form-control" />
		<form:errors path="userName" cssClass="error"/>
	</div>

	<div class="form-group">
		<label for="password" class=" control-label">Password</label><br>
		<form:password path="password" cssClass="form-control" />
		<form:errors path="password" />
	</div>
	<div class="form-group">
		<label for="password" class=" control-label">Confirm Password</label><br>
		<form:password path="confirmPassword" cssClass="form-control" />
		<form:errors path="confirmPassword" />
	</div>

	<div class="form-group">
		<input type="submit" class="btn btn-default btn-primary" value="Save" />
	</div>

</form:form>




<%@ include file="../layouts/footer.jsp"%>