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
     <div id="aside">
		<jsp:include page ="/WEB-INF/views/inc/side.jsp"></jsp:include>
    </div>
	<h3>Select SubjectList</h3>
	<table>
		<thead>
			<tr>
				<th>subjectNo</th>
				<th>subjectName</th>
				<th>subjectDate</th>
				<th>국가추가</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var = "subject" items="${subjectList}">
			<tr>
				<td data-column="subjectNo">${subject.subjectNo}</td>
				<td data-column="subjectName">${subject.subjectName }</td>
				<td data-column="subjectDate">${subject.subjectDate}</td>	
				<td data-column="국가추가">
					<a href = "${pageContext.request.contextPath}/InsertSubjectListServlet">국가추가</a>
				</td>			
			</tr>
			</c:forEach>
		</tbody>
	</table>		
</body>
</html>