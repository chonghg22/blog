<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>Home</title>
<meta charset="UTF-8">
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
    <div id="section">
        <h1>Home</h1>
        <div>
        	<!-- 로그아웃 -->
            <c:if test="${loginMember==null}">
            	<a href="${pageContext.request.contextPath}/LoginServlet" class="btn btn-primary">로그인</a>
            	<a href="${pageContext.request.contextPath}/InsertMemberServlet" class="btn btn-primary">회원가입</a>
            </c:if>
            <!-- 로그인상태 -->
            <c:if test="${loginMember!=null}">
            	<a href="${pageContext.request.contextPath}/SelectMemberServlet" class="btn btn-primary">${loginMember.memberId}님 회원정보수정</a>
            	<a href="${pageContext.request.contextPath}/LogoutServlet" class="btn btn-primary">로그아웃</a>  	
            </c:if>
        </div>
        <div>
        	<c:if test="${loginMember.memberLevel<10}">
        		<a href="${pageContext.request.contextPath}/SelectSubjectAllServlet" class="btn btn-primary">Subject List</a> 
        	</c:if>
        </div>
    	<!-- 홈과 관련된 내용 -->
    	<div>
    		<c:if test="${loginMember != null && loginMember.memberLevel<10}">
    			<a href="${pageContext.request.contextPath}/AdminServlet" class="btn btn-primary">관리자 페이지</a>
    		</c:if>
    	</div>
    </div>
</body>
</html>

