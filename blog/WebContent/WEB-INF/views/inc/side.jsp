<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta content="width=device-width, initial-scale=1" name="viewport" />
<meta charset="UTF-8">
<link rel="stylesheet" href = "/blog/css/test.css">
<link rel="apple-touch-icon" type="image/png" href="https://static.codepen.io/assets/favicon/apple-touch-icon-5ae1a0698dcc2402e9712f7d01ed509a57814f994c660df9f7a952f3060705ee.png" />
<link rel="shortcut icon" type="image/x-icon" href="https://static.codepen.io/assets/favicon/favicon-aec34940fbc1a6e787974dcd360f2c6b63348d4b1f4e06c77743096d55480f33.ico" />
<link rel="mask-icon" type="" href="https://static.codepen.io/assets/favicon/logo-pin-8f3771b1072e3c38bd662872f6b673a722f4b3ca2421637d5596661b4e2132cc.svg" color="#111" />
<title>Blog Home</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
</head>
<body>
	<div class="nav nav-sky">
   <!--  
   <div class="menu-btn">000000 <i class="fas fa-bars"></i> </div>
    -->
	<div class="nav-elements">    
	<ul class="nav-content">      
		<li>
			<a href= "${pageContext.request.contextPath}/HomeServlet" title="Home" class="active"> <i class="ion-ios-medical-outline"></i> Home </a>
		</li>
		<li>
			<a href= "${pageContext.request.contextPath}/HomeServlet" > <i class="ion-ios-briefcase-outline"></i> About </a>
		</li>		
		<li>
		<div class="dropdown">   
			<a href="#" class="dropdown-link" title="About"><i  class="ion-ios-settings">Project</i></a>   
			<div class="dropdown-menu">					
				<a href="" title="Option 1" ><i class="ion-ios-settings"></i>employees</a>
				<a href="" title="Option 2" ><i class="ion-ios-settings"></i>shopdb</a>
				<a href="" title="Option 3" ><i class="ion-ios-settings"></i>sakila</a>
				<a href="" title="Option 4" ><i class="ion-ios-settings"></i>blog</a>
				<a href="" title="Option 5" ><i class="ion-ios-settings"></i>mybatis</a>
				<a href="" title="Option 6" ><i class="ion-ios-settings"></i>moneyBook</a>			
			</div>    
		</div>   
		</li>	 
		<li>
		<div class="dropdown">   
			<a href="#" class="dropdown-link" title="Gallery"><i class="ion-ios-location-outline">Country</i></a>   
			<div class="dropdown-menu">
			<c:forEach var="s" items="${subjectList}">	
				<a href="${pageContext.request.contextPath}/SelectPostBySubjectServlet?subjectName=${s.subjectName}" title="Option 1" ><i class="ion-ios-location-outline"></i>${s.subjectName}</a>
			</c:forEach>      
			</div>    
		</div>   
		</li>
		<li> 
	</ul>
	<form class="search-area" id = "login" action = "${pageContext.request.contextPath}/LoginServlet" >
	<c:if test="${loginMember==null}">
		<button id = "loginBtn" class="btn-search">로그인</button>		
	</c:if>
	</form>
	<form class = "search-area" id = "userOption" action = "${pageContext.request.contextPath}/SelectMemberServlet">
	<c:if test="${loginMember!=null}"> 
		<!-- 로그인상태 -->
		<button id = "userOptionBtn" class="btn-search">회원정보</button>	
	</c:if>	
	</form>
	<form class = "search-area" id = "logout" action = "${pageContext.request.contextPath}/LogoutServlet">
	<c:if test="${loginMember!=null}"> 
		<button id = "logoutBtn" class="btn-search">로그아웃</button>		
	</c:if>
	</form>
	</div>  
	</div>
	<script data-src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
	<script defer data-src="https://use.fontawesome.com/releases/v5.8.2/js/all.js" integrity="sha384-DJ25uNYET2XCl5ZF++U8eNxPWqcKohUUBUpKGlNLMchM7q4Wjg2CUpjHLaL8yYPH" crossorigin="anonymous"></script>
	<script>
		let loginBtn = document.getElementById("loginBtn");
		btn.addEventListener("click",function(){
			document.getElementById("login").submit(); 	
		});
		let userOptionBtn = document.getElementById("userOptionBtn");
		btn.addEventListener("click",function(){
			document.getElementById("userOption").submit(); 	
		});
		let logoutBtn = document.getElementById("logoutBtn");
		btn.addEventListener("click",function(){
			document.getElementById("logout").submit(); 	
		});
	</script>
</body>
</html>
<!--

			
	<li>
	<a href="#"><i class="ion-ios-briefcase-outline"></i> <span class="">Folio</span></a>
	<ul class="navbar-flyout">
	<li>
	<a href="#"><i class="ion-ios-flame-outline"></i>Burn</a>
	</li>
	<li>
	<a href="#"><i class="ion-ios-lightbulb-outline"></i>Bulbs</a>
	</li>
	<li>
	<a href="#"><i class="ion-ios-location-outline"></i>Where You</a>
	</li>
	<li>
	<a href="#"><i class="ion-ios-locked-outline"></i>On Lock</a>
	</li>
	<li>
	<a href="#"><i class="ion-ios-navigate-outline"></i>Ghostface</a>
	</li>
	</ul>
	</li>
	<li>
	<a href="#"><i class="ion-ios-analytics-outline"></i> <span class="">Graphicals</span></a>
	<ul class="navbar-flyout">
	<li>
	<a href="#"><i class="ion-ios-timer-outline"></i>Timers</a>
	</li>
	<li>
	<a href="#"><i class="ion-arrow-graph-down-left"></i>You Lose</a>
	</li>
	<li>
	<a href="#"><i class="ion-ios-partlysunny-outline"></i>Stormy</a>
	</li>
	<li>
	<a href="#"><i class="ion-ios-timer-outline"></i>Lookie Look</a>
	</li>
	<li>
	<a href="#"><i class="ion-ios-game-controller-a-outline"></i>Dork Mfer</a>
	</li>
	</ul>
	</li>
	<li>
	<a href="#"><i class="ion-ios-paper-outline"></i> <span class="">Papers</span></a>
	<ul class="navbar-flyout">
	<li>
	<a href="#"><i class="ion-ios-filing-outline"></i>File Cab</a>
	</li>
	<li>
	<a href="#"><i class="ion-ios-information-outline"></i>Infos</a>
	</li>
	<li>
	<a href="#"><i class="ion-ios-paperplane-outline"></i>Planes</a>
	</li>
	<li>
	<a href="#"><i class="ion-android-star-outline"></i>Shop</a>
	</li>
	</ul>
	</li>
	<li>
	<a href="#"><i class="ion-ios-navigate-outline"></i> <span class="">Ass Finder</span></a>
	<ul class="navbar-flyout">
	<li>
	<a href="#"><i class="ion-ios-flame-outline"></i>Burn</a>
	</li>
	<li>
	<a href="#"><i class="ion-ios-lightbulb-outline"></i>Bulbs</a>
	</li>
	<li>
	<a href="#"><i class="ion-ios-location-outline"></i>Where You</a>
	</li>
	<li>
	<a href="#"><i class="ion-ios-locked-outline"></i>On Lock</a>
	</li>
	<li>
	<a href="#"><i class="ion-ios-navigate-outline"></i>Ghostface</a>
	</li>
	</ul>
	</li>
	<li>
	<a href="#"><i class="ion-ios-medical-outline"></i> <span class="">Cocaine</span></a>
	</li>
</ul>
</nav>
</aside>
</section>
<input type="text" name="search" placeholder="Search Item" title="Search Item">
     <button class="btn-search" name="search-button" title="Search">Search</button>
-->