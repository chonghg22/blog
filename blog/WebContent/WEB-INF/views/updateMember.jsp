<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>Update Member</h3>
	<form method = "post" action = "">
	<div>
		<input type = "hidden" name = "memberNo">
	</div>
	<div>
		memberId:
		<input type = "text" name = "memberId" value = "" readonly = "readonly">
	</div>
	<div>
		memberPw:
		<input type = "text" name ="memberPw">
	</div>
	<div>
		memberPhone:
		<input type = "text" name = "memberPhone">
	</div>
	<div>
		memberAddress
		<input type = "text" name = "memberAddress">
	</div>
	<div>
		memberBirth
		<input type = "date" name = "memberBirth">
	</div>
	<div>
		<button type = "submit">수정</button>
	</div>
	</form>
</body>
</html>