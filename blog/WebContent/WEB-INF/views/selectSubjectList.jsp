<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<title>ordersList</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>

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
  </head>
<body>
     <div id="aside">
		<!-- subject(나라이름) List 출력 -->
	<jsp:include page ="/WEB-INF/views/inc/side.jsp"></jsp:include>
    </div>
    
    <div id="section" class="row">
	<div class="col-sm-3"></div>	
	<div class="col-sm-6" >
	
	<h3>Select SubjectList</h3>
	<a href = "${pageContext.request.contextPath}/InsertSubjectListServlet">국가추가</a>
	<div class = "container-fluid">
	<table class="table table-bordered">
		<thead>
			<tr>
				<th>subjectNo</th>
				<th>subjectName</th>
				<th>subjectDate</th>
				
			</tr>
		</thead>
		<tbody>
			<c:forEach var = "subject" items="${subjectList}">
			<tr>
				<td>${subject.subjectNo}</td>
				<td>${subject.subjectName }</td>
				<td>${subject.subjectDate}</td>				
			</tr>
			</c:forEach>
		</tbody>
	</table>	
	</div>
	</div>
	</div>
	<div class="col-sm-3"></div>	
</body>
</html>