<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	request.setCharacterEncoding("utf-8");
%>
<%
	String id = request.getParameter("id");
	String pw1 = request.getParameter("pw1");
	String gender = request.getParameter("gender");
	String[] hobby = request.getParameterValues("hobby");
	out.println(id + "<--id");
	out.println(pw1 + "<--pw");
	out.println(gender + "<--gender");
	for(String h : hobby){
		out.println(h + "<--hobby");
	}
	
%>


</body>
</html>