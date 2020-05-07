<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
  
<title>login</title>
<meta charset="UTF-8">
<style>
/* CSS for sky theme end*/
/*
css for login start
/*  #156DA9 blue
    #00BCD4
    #6FD653 bhover
    #F6F6F6 */

body{
    margin: 0;
    padding: 0;
    background:#156DA9;
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
   

}

.login-box{
    width: 320px;
    height: 300px;
    background: #ffffff;
    padding: 60px 30px;
    border-radius: 5px;
    text-align: center;
    border: 2px solid #6FD653;
    -webkit-box-shadow: 10px 10px 5px -4px rgba(0,0,0,0.75);
    -moz-box-shadow: 10px 10px 5px -4px rgba(0,0,0,0.75);
    box-shadow: 10px 10px 5px -4px rgba(0,0,0,0.75);

}

.login-box h1{
    text-transform: uppercase;
    font-weight: 500;
    color: #00BCD4;
}

.login-box input[type="text"],
.login-box input[type="password"]{
    width: 60%;
    margin-bottom: 20px;
}

.login-box input[type="text"],
.login-box input[type="password"]{
    border-radius: 30px;
    background: transparent;
    border: none;
    outline: none;
    border: 2px solid #00BCD4;
    font-size: 13px;
    height: 40px;
    text-align: center;
    transition: 0.27s;
}
.login-box input[type="text"]:focus,
.login-box input[type="password"]:focus{
width: 80%;
border-color:#6fd653;
}

.login-box input[type="submit"]{
    width: 40%;
    border: none;
    outline: none;
    background: #156DA9;
    padding: 10px 0;
    border-radius: 30px;
    color: #ffffff;
    font-weight: 500;
    text-transform: uppercase;
    cursor: pointer;
    margin-bottom: 20px;
}

.login-box input[type="submit"]:hover{
    background:#6FD653;
   transition: .2s;
}

.login-box input[type="submit"]:focus{
    transform: scaleX(1.1);
}

.login-box a {
    text-decoration: none;
    font-size: 12px;
    color: #00bcd4;
}

.login-box a:hover{
    color: #6FD653;
}
/*
css login end
*/
</style>
</head>
<body> 	
<div class="login-box">
        <h1>login</h1>
        <form  method = "post" action="${pageContext.request.contextPath}/LoginServlet">
            <input type="text"name = "memberId"  placeholder="Username"  required>
            <input type="password" name = "memberPw" placeholder="Password" required>
            <input type="submit" value="Log in">
        </form>
       <c:if test="${loginMember==null}">
   		<div>
   		<a href="${pageContext.request.contextPath}/HomeServlet" >홈으로</a>
   		</div>
   		<div>
   		<a href="${pageContext.request.contextPath}/InsertMemberServlet" >회원가입</a>
   		</div>   		
	</c:if>	
</div>
	

	
</body>
</html>

