<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <title>index</title>
  <meta charset="utf-8">

</head>
<body>
<div class="container">
<div>MENU</div>
<ul>
	<li><a href = "${pageContext.request.contextPath}/HomeServlet" >Home</a></li>
	<c:forEach var="s" items="${subjectList}">
	<li>
	<a href="${pageContext.request.contextPath}/SelectPostBySubjectServlet?subjectName=${s.subjectName}" >${s.subjectName}</a>
	</li>
	</c:forEach>
</ul>
</div>
</body>
</html>