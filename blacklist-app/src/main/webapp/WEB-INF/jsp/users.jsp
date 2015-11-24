<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="../layouts/header.jsp" %>

<table class="table table-bordered table-hover table-striped">
	<thead>
		<tr>
			<th>user name</th>
			<th>operations</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${users}" var="user">
			<tr>
				<td>
						<c:out value="${user.username}" />
					
				</td>
				<td>
					<a href="<spring:url value="/users/remove/${user.username}.html" />" class="btn btn-danger triggerRemove">
						remove
					</a>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<%@ include file="../layouts/footer.jsp" %>