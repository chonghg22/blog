<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <h1>포스트 리스트</h1>   
	<table>
		<thead>
			<tr>
	       		<th>post_no</th>
	       		<th>member_id</th>
	       		<th>subject_name</th>
	       		<th>post_title</th>
	       		<th>post_date</th>
	       		<th>add_postList</th>      
	       	</tr>
		</thead>
       	<tbody>
       		<c:forEach var="p" items="${list}">
       		<tr>
      			<td data-column="post_no">${p.postNo}</td>
      			<td data-column="member_id">${p.memberId}</td>
      			<td data-column="subject_name">${p.subjectName}</td>
      			<td data-column="post_title"><a href = "${pageContext.request.contextPath}/SelectPostOneServlet?postNo=${p.postNo}">${p.postTitle}</a></td>
      			<td data-column="post_date">${p.postDate}</td>
      			<td data-column="add_postList"><a href="${pageContext.request.contextPath}/InsertSubjectServlet" >post list 추가</a> </td>
      			
      	 	</tr>
           </c:forEach>
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

