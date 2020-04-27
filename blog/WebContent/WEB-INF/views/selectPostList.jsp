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

    <h1>포스트 리스트</h1>
    <a href="${pageContext.request.contextPath}/InsertSubjectServlet" >post list 추가</a> 
    <div>
	<div class = "container-fluid">
		<table class="table table-bordered">
			<tr>
	       		<td>post_no</td>
	       		<td>member_id</td>
	       		<td>subject_name</td>
	       		<td>post_title</td>
	       		<td>post_date</td>
	       	</tr>
	       	<c:forEach var="p" items="${list}">
	       	<tr>
       			<td>${p.postNo}</td>
       			<td>${p.memberId}</td>
       			<td>${p.subjectName}</td>
       			<td><a href = "${pageContext.request.contextPath}/SelectPostOneServlet?postNo=${p.postNo}">${p.postTitle}</a></td>
       			<td>${p.postDate}</td>
	       	</tr>
            </c:forEach>
		</table>            
        </div>
        <c:if test="${currentPage>1}">
 			<a href="${pageContext.request.contextPath}/SelectPostAllServlet?currentPage=${currentPage-1}" class = "btn btn-secondary">이전페이지</a> 
        </c:if>
        <c:if test="${currentPage<lastPage}">
        
 			<a href="${pageContext.request.contextPath}/SelectPostAllServlet?currentPage=${currentPage+1}" class = "btn btn-secondary">다음페이지</a> 
        </c:if>
    </div>
    </div>
	<div class="col-sm-3"></div>
	</div>
</body>
</html>

