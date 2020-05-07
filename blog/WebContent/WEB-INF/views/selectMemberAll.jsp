<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>ordersList</title>
<meta charset="utf-8">
<link href="/blog/css/listForm.css" rel="stylesheet" media="all">
</head>
<body>
	<div>	
		<jsp:include page="/WEB-INF/views/inc/side.jsp"></jsp:include>
	</div>
	<h1>List</h1>
	<table class="table table-bordered">
		<thead>
			<tr>
				<th>memberId</th>
				<th>memberPw</th>
				<th>memberLevel</th>
				<th>memberPhone</th>
				<th>memberAddress</th>
				<th>memberBirth</th>
				<th>memberDate</th>
				<th>Level변경</th>
				<th>회원삭제</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="m" items="${memberList}">
			<tr>
				<td data-column="memberId">${m.memberId}</td>
				<td data-column="memberPw">${m.memberPw}</td>
				<td data-column="memberLevel">${m.memberLevel} 
				<c:if test="${m.memberLevel <10}">
	   			관리자
	   			</c:if> 
	   			<c:if test="${m.memberLevel >=10}">
	   			일반멤버
	   			</c:if>
				</td>
				<td data-column="memberPhone">${m.memberPhone }</td>
				<td data-column="memberAddress">${m.memberAddress }</td>
				<td data-column="memberBirth">${m.memberBirth }</td>
				<td data-column="memberDate">${m.memberDate}</td>
				<td data-column="Level변경">
					<a href="${pageContext.request.contextPath}/UpdateMemberLevel?memberId=${m.memberId}">변경</a>
				</td>
				<td data-column="회원삭제">
					<a href = "${pageContext.request.contextPath}/DeleteMemberServlet">삭제</a>
				</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	<c:if test="${currentPage>1}">
		<a href="${pageContext.request.contextPath}/SelectMemberAllServlet?currentPage=${currentPage-1}">이전페이지</a>
	</c:if>
	<c:if test="${currentPage<lastPage}">
		<a href="${pageContext.request.contextPath}/SelectMemberAllServlet?currentPage=${currentPage+1}">다음페이지</a>
	</c:if> 
</body>
</html>

