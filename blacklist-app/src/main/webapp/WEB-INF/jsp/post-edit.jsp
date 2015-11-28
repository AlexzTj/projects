<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ include file="../layouts/header.jsp" %>
<h1>Edit post</h1>
<form:form commandName="post" method="POST">

		<div class="form-group">
		<label for="title" class="control-label">Title</label><br>
		<form:input path="title" cssClass="form-control" />
		<form:errors path="title" cssclass="error" />
		</div>
		
		<div class="form-group">
		<label for="company" class="control-label">Company name</label><br>
		<form:input path="company" cssClass="form-control" />
		</div>
		
		<div class="form-group">
		<label for="companyDescr" class="control-label">Company domain</label><br>
		<form:input path="companyDescr" cssClass="form-control" />
		</div>

		<div class="form-group">
		<label for="content" class=" control-label">My complain</label><br>
		<form:textarea path="content" cssClass="form-control" />
		<form:errors path="content" cssclass="error" />
		</div>
	
    
        <input type="submit" class="btn btn-primary" value="Save"/>
     
</form:form>
<%@ include file="../layouts/footer.jsp" %>