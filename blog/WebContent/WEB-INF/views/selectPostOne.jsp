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
	<h1>List</h1>
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
	<table>
		<thead>
			<tr>
				<th>postNo</th>
				<th>memberId</th>
				<th>subjectName</th>
				<th>postTitle</th>
				<th>postContent</th>
				<th>postDate</th>
			</tr>
		</thead>
		<tbody>
			
			<tr>
				<td data-column="postNo">${post.postNo}</td>
				<td data-column="memberId">${post.memberId}</td>
				<td data-column="subjectName">${post.subjectName}</td>
				<td data-column="postTitle">${post.postTitle}</td>
				<td data-column="postContent">${post.postContent}</td>
				<td data-column="postDate">${post.postDate}</td>				
			</tr>
			
		</tbody>
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
	<c:if test="${currentPage>1}">
		<a href="${pageContext.request.contextPath}/SelectMemberAllServlet?currentPage=${currentPage-1}">이전페이지</a>
	</c:if>
	<c:if test="${currentPage<lastPage}">
		<a href="${pageContext.request.contextPath}/SelectMemberAllServlet?currentPage=${currentPage+1}">다음페이지</a>
	</c:if> 
</body>
</html>
