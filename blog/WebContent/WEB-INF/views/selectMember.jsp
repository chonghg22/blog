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
    <h1>회원정보</h1>   
	<table>
		<thead>
			<tr>
	       		<th>member_id</th>
	       		<th>member_level</th>  
	       		<th>정보수정</th>
	       		<th>회원탈퇴</th>    
	       	</tr>
		</thead>
       	<tbody>
       		<tr>
      			<td data-column="member_id"> ${member.memberId}</td>
      			<td data-column="member_level">${member.memberLevel}</td>
      			<td data-column="정보수정">
      				<a href = "${pageContext.request.contextPath}/UpdateMember?memberId=${member.memberId}">정보수정</a>
      			</td>
      			<td data-column="회원탈퇴">
      				 <a href="${pageContext.request.contextPath}/DeleteMemberServlet">회원탈퇴</a>
      			</td>      			
      	 	</tr>
		</tbody>
	</table>       
	<c:if test="${currentPage>1}">
		<a href="${pageContext.request.contextPath}/SelectPostAllServlet?currentPage=${currentPage-1}" class = "btn btn-secondary">이전페이지</a> 
	</c:if>
	<c:if test="${currentPage<lastPage}">        
		<a href="${pageContext.request.contextPath}/SelectPostAllServlet?currentPage=${currentPage+1}" class = "btn btn-secondary">다음페이지</a> 
	</c:if>
</body>
</html>
