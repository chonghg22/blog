<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>login</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>

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
	<jsp:include page="/WEB-INF/views/inc/side.jsp"></jsp:include>
	</div>
	<div id="section" class="row">
	<div class="col-sm-3"></div>	
	<div class="col-sm-6" >
	<h1>List</h1>
	<div class = "container-fluid">
		<table class="table table-bordered">
			<tr>
				<td>memberId</td>
				<td>memberPw</td>
				<td>memberLevel</td>
				<td>memberDate</td>
				<td>Level변경</td>
				<td>회원삭제</td>
			</tr>
			<c:forEach var="m" items="${memberList}">
			<tr>
				<td>${m.memberId}</td>
				<td>${m.memberPw}</td>
				<td>${m.memberLevel} 
				<c:if test="${m.memberLevel <10}">
    			관리자
    			</c:if> 
    			<c:if test="${m.memberLevel >=10}">
    			일반멤버
    			</c:if>
				</td>
				<td>${m.memberDate}</td>
				<td><a href="${pageContext.request.contextPath}/UpdateMemberLevel?memberId=${m.memberId}">변경</a></td>
				<td><a href = "${pageContext.request.contextPath}/DeleteMemberServlet">삭제</a>
			</tr>
			</c:forEach>
		</table>
		<c:if test="${currentPage>1}">
			<a href="${pageContext.request.contextPath}/SelectMemberAllServlet?currentPage=${currentPage-1}">이전페이지</a>
		</c:if>
		<c:if test="${currentPage<lastPage}">
			<a href="${pageContext.request.contextPath}/SelectMemberAllServlet?currentPage=${currentPage+1}">다음페이지</a>
		</c:if>  
	<div class="col-sm-3"></div>
	</div>
	</div>
	</div>
</body>
</html>

