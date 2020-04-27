<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<style>
body {
	padding: 0;
	margin: 0;
	width: 100%;
	height: 100%;
	overflow: hidden;
	background-position: 0 0;
	background-repeat: no-repeat;
	background-attachment: fixed;
	background-size: cover;
	position: relative;
	overflow-y: auto;
}

#aside {
	width: 200px;
	height: 3000px;
	position: fixed;
	background: orange;
	overflow: hidden;
	float: left;
}

#section {
	margin-left: 300px;
	background: white;
}
</style>
  <title>ordersList</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</head>
<body>
    <div id="aside">
		<!-- subject(나라이름) List 출력 -->
	<jsp:include page="/WEB-INF/views/inc/side.jsp"></jsp:include>
	</div>
    <div id="section" class="row">
	<div class="col-sm-3"></div>	
	<div class="col-sm-6" >
		<h1>List</h1>
		 <div class = "container-fluid">
    <div>
    <c:if test = "${loginMember == null}">
	좋아요
    </c:if>
    <c:if test = "${loginMember != null }">    
    <a href = "${pageContext.request.contextPath}/AddLikeyServlet?postNo=${post.postNo}&likeyCk=1">좋아요</a>
    </c:if>
    ${map.goodCount}
    
    </div>
     <div>
    <c:if test = "${loginMember == null}">
	싫어요
    </c:if>
    <c:if test = "${loginMember != null }">    
    <a href = "${pageContext.request.contextPath}/AddLikeyServlet?postNo=${post.postNo}&likeyCk=0">싫어요</a>
    </c:if>
    ${map.badCount}
    
    </div>
	<table class="table table-bordered">		
		<tr>
			<td>post_no</td>
			<td>${post.postNo}</td>
		</tr>
		<tr>
			<td>member_id</td>
			<td>${post.memberId}</td>
		</tr>
		<tr>
			<td>subject_name</td>
			<td>${post.subjectName}</td>
		</tr>
		<tr>
			<td>post_title</td>
			<td>${post.postTitle}</td>
		</tr>
		<tr>
			<td>post_content</td>
			<td>${post.postContent}</td>
		</tr>
		<tr>
			<td>post_date</td>
			<td>${post.postDate}</td>
		</tr>		
	</table>	
	<div>		
	<form method = "post" action = "${pageContext.request.contextPath}/AddCommentServlet">
		<input type = "hidden" name = "postNo" value = "${post.postNo}">
		<textarea rows = "2" cols = "80" name = "commentContent"></textarea>
		<button type = "submit">입력</button>
	</form>
	</div>
	<div>
         <c:forEach var="c" items="${commentList}">
            <div>
               ${c.commentContent} / ${c.memberId}
            </div>
         </c:forEach>
      </div>
	</div>
		<div class="col-sm-3"></div>
	</div>
	</div>
</body>
</html>