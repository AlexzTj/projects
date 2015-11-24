<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

 <%@ include file="../layouts/header.jsp" %>   



<c:forEach items="${getAllPosts}" var="post">
	<div class="blog-item clearfix " >
	<a href="" class="text-warning"><small><span class="glyphicon glyphicon-pencil " aria-hidden="true"></span> edit</small></a>&nbsp;&nbsp;
	<a href="<spring:url value="/posts/remove/${post.postId}.html" />"  class="triggerRemove text-danger"><small><span class="glyphicon glyphicon-remove " aria-hidden="true"></span> remove</small></a>&nbsp;&nbsp;
	<small>posted by ${post.user.username}</small>	
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