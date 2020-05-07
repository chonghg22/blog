<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>admin</title>
<meta charset="UTF-8">

</head>
<body>
    <div id="aside">
		<jsp:include page="/WEB-INF/views/inc/side.jsp"></jsp:include>
    </div>
    <div id="section">
        <h1>관리자 메뉴</h1>
        <div>
            <ol>
            	<li>
            		<a href="${pageContext.request.contextPath}/SelectMemberAllServlet">멤버 관리</a>
            	</li>
            	<li>
            		<a href="${pageContext.request.contextPath}/SelectPostAllServlet">포스팅 관리</a>
            	</li>
            </ol>
        </div>
    </div>
</body>
</html>

