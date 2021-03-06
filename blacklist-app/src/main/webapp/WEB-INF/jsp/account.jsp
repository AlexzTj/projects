<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

 <%@ include file="../layouts/header.jsp" %>   


<h1>Hi, <security:authentication property="principal.username" /> <button type="button" class="pull-right btn btn-primary btn-default" data-toggle="modal" data-target="#myModal">
  New post
</button></h1>

    <!-- Button trigger modal -->

<br><br><br>
<form:form commandName="post" action="/blacklist-app/posts.html" method="POST">
<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel"> New post</h4>
        ${post.postId }
      </div>
      <div class="modal-body">
        
		<div class="form-group">
		<label for="title" class="control-label">Title</label><br>
		<form:input path="title" cssClass="form-control" />
		<form:errors path="title" />
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
		<form:errors path="content" />
		</div>
	
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <input type="submit" class="btn btn-primary" value="Save"/>
      </div>
    </div>
  </div>
</div>
</form:form>
<c:if test="${not empty message}">
<div class="alert alert-success alert-dismissible fade in" role="alert">
  <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
  ${message}
</div>
</c:if>
<c:forEach items="${user.posts}" var="post">
	<div class="blog-item clearfix " >
	<a href="<spring:url value="/posts/edit/${post.postId}.html" />" class="text-warning"><small><span class="glyphicon glyphicon-pencil " aria-hidden="true"></span> edit</small></a>&nbsp;&nbsp;
	<a href="<spring:url value="/posts/remove/${post.postId}.html" />"  class="triggerRemove text-danger"><small><span class="glyphicon glyphicon-remove " aria-hidden="true"></span> remove</small></a>
		<h3>${post.title}</h3>
		<p>${post.content}</p>
		<a class="btn btn-info btn-xs pull-left" href="<spring:url value="/posts/${post.postId}.html" />">Read more</a>
		<small class="b-footer  pull-right text-muted">${post.company} / ${post.companyDescr}</small>
	</div> 
</c:forEach>


<!-- Modal -->
<div class="modal fade" id="modalRemove" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">Modal title</h4>
      </div>
      <div class="modal-body">
        Do you want to remove?
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
        <a href="" class="btn btn-danger removeBtn">Remove</a>
      </div>
    </div>
  </div>
</div>

<%@ include file="../layouts/footer.jsp" %>
<script type="text/javascript">
$(document).ready(function() {
	$(".triggerRemove").click(function(e) {
		e.preventDefault();
		$("#modalRemove .removeBtn").attr("href", $(this).attr("href"));
		$("#modalRemove").modal();
	});
});
</script>