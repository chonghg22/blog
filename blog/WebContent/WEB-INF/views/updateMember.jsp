<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Colorlib Templates">
<meta name="author" content="Colorlib">
<meta name="keywords" content="Colorlib Templates">
<title>InsertForm</title>
<link href="vendor/mdi-font/css/material-design-iconic-font.min.css" rel="stylesheet" media="all">
<link href="vendor/font-awesome-4.7/css/font-awesome.min.css" rel="stylesheet" media="all">
<link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i" rel="stylesheet">
<link href="vendor/select2/select2.min.css" rel="stylesheet" media="all">
<link href="vendor/datepicker/daterangepicker.css" rel="stylesheet" media="all">
<link href="/blog/css/registerForm.css" rel="stylesheet" media="all">
</head>
<body>
	<div>		
	<jsp:include page="/WEB-INF/views/inc/side.jsp"></jsp:include>
	</div>
	<div class="page-wrapper bg-gra-03 p-t-45 p-b-50">
		<div class="wrapper wrapper--w790">
			<div class="card card-5">
				<div class="card-heading">
					<h2 class="title">회원정보 수정</h2>
				</div>
				<div class="card-body">
					<form method = "post" action="${pageContext.request.contextPath }/UpdateMember">				
						
						<div class="form-row">
							<div class="value">
								<div class="input-group">
									<input class="input--style-5" type="hidden" name="memberNo">
								</div>
							</div>
						</div>
						
						<div class="form-row">
							<div class="name">
							memberId:
							</div>
							<div class="value">
								<div class="input-group">
									<input class="input--style-5" type="text" name="memberId" value = "${member.memberId}" readonly = "readonly">
								</div>
							</div>
						</div>
						
						<div class="form-row">
							<div class="name">
							memberPw:
							</div>
							<div class="value">
								<div class="input-group">
									<input class="input--style-5" type="password" name="memberPw" >
								</div>
							</div>
						</div>
						
						<div class="form-row">
							<div class="name">
							memberPhone:
							</div>
							<div class="value">
								<div class="input-group">
									<input class="input--style-5" type="text" name="memberPhone" >
								</div>
							</div>
						</div>
						
						<div class="form-row">
							<div class="name">
							memberAddress:
							</div>
							<div class="value">
								<div class="input-group">
									<input class="input--style-5" type="text" name="memberAddress">
								</div>
							</div>
						</div>
						
						<div class="form-row">
							<div class="name">
							memberBirth:
							</div>
							<div class="value">
								<div class="input-group">
									<input class="input--style-5" type="text" name="memberBirth" >
								</div>
							</div>
						</div>	
						
											
						<div>
							<button class="btn btn--radius-2 btn--blue" type="submit">삭제</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<script src="vendor/jquery/jquery.min.js" type="4a061543b3ab991da7fc1126-text/javascript"></script>
	<script src="vendor/select2/select2.min.js" type="4a061543b3ab991da7fc1126-text/javascript"></script>
	<script src="vendor/datepicker/moment.min.js" type="4a061543b3ab991da7fc1126-text/javascript"></script>
	<script src="vendor/datepicker/daterangepicker.js" type="4a061543b3ab991da7fc1126-text/javascript"></script>
	<script src="js/global.js" type="4a061543b3ab991da7fc1126-text/javascript"></script>
	<script async src="https://www.googletagmanager.com/gtag/js?id=UA-23581568-13" type="4a061543b3ab991da7fc1126-text/javascript"></script>
	<script type="4a061543b3ab991da7fc1126-text/javascript">
	window.dataLayer = window.dataLayer || [];
	function gtag(){dataLayer.push(arguments);}
	gtag('js', new Date());
	gtag('config', 'UA-23581568-13');
	</script>
	<script src="https://ajax.cloudflare.com/cdn-cgi/scripts/7089c43e/cloudflare-static/rocket-loader.min.js" data-cf-settings="4a061543b3ab991da7fc1126-|49" defer=""></script>
</body>
</html>