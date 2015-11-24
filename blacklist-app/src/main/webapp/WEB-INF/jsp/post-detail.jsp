<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ include file="../layouts/header.jsp" %>

<div class="blog-item">
<h1>${post.title}</h1>
<small>${post.company} / ${post.companyDescr}</small><br><br><br>
${post.content}
</div>

<%@ include file="../layouts/footer.jsp" %>