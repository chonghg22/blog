<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
  <script>
      function login(){
        var data = new FormData();
        data.append('email', document.getElementById("user-email").value);
        data.append('password', document.getElementById("user-pass").value);
        var xhr = new XMLHttpRequest();
        // @TODO - CHANGE "server-dummy.txt" TO YOUR SERVER SCRIPT
        xhr.open('POST', "server-dummy.txt", true);
        xhr.onload = function() {
          if (xhr.status == 200) {
            var response = JSON.parse(this.response);
            // VALID
            if (response.status) {
              // @TODO - WHERE TO REDIRECT THE USER ON SIGN IN?
              // location.href = "somewhere.html";
            }
            // INVALID EMAIL/PASSWORD
            else {
              alert(response.message);
            }
          } else {
            alert("SERVER ERROR!");
          }
        };
        xhr.send(data);
        return false;
      }
    </script>
<title>login</title>
<meta charset="UTF-8">
<style>
 #login-form {
        max-width: 400px;
        margin: 0 auto;
        padding: 40px;
        background: #f2f2f2;
      }
      #login-form h1 {
        text-align: center;
        margin: 0 0 10px 0;
      }
      #login-form button {
        box-sizing: border-box;
        width: 80%;
        margin: 10px;
        padding: 10px;
      }
      #login-form button[type=submit] {
        border: 0;
        background: #4367c4;
        color: #fff;
      }
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
	<jsp:include page="/WEB-INF/views/inc/side.jsp"></jsp:include>
	</div>
	<div id="section">		
		<div>
		<form id="login-form" onsubmit="return login()" method = "post" action="${pageContext.request.contextPath}/LoginServlet">
			<h3>로그인 폼</h3>
			<input type="text" placeholder="ID" name = "memberId"  required/>
	     	 <input type="text" placeholder="Pw" name = "memberPw" required/>
	      	<button type = "submit">로그인</button>		
		</form>
		</div>
	</div>
</body>
</html>

