<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="../layouts/header.jsp"%>


<c:if test="${param.success eq true}">
	<div class="alert alert-success">Registration successful</div>
</c:if>

<form:form commandName="user" cssClass="form-horizontal form-signin">

	<div class="form-group">
		<label for="name" class="control-label">Name</label><br>
		<form:input path="username" cssClass="form-control" />
	</div>

	<div class="form-group">
		<label for="password" class=" control-label">Password</label><br>
		<form:password path="password" cssClass="form-control" />
	</div>

	<div class="form-group">
		<input type="submit" class="btn btn-default btn-primary" value="Save" />
	</div>

</form:form>




<%@ include file="../layouts/footer.jsp"%>