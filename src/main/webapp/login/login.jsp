<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../../../favicon.ico">

<title>Signin Template for Bootstrap</title>

<!-- Bootstrap core CSS -->
<link href="${pageContext.servletContext.contextPath}/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<!-- Custom styles for this template -->
<link href="${pageContext.servletContext.contextPath}/css/signin.css" rel="stylesheet">

</head>

<body class="text-center">	
	<form class="form-signin" method="post" action="/jspTest/loginServlet">		
		<h1 class="h3 mb-3 font-weight-normal">로그인 화면</h1>
		<input type="text" id="loginId" name="loginId" class="form-control" placeholder="아이디" required autofocus> 
		<input type="password" id="loginPassword"  name="loginPassword" class="form-control" placeholder="비밀번호" required>
		<div class="checkbox mb-3">
			<label> <input type="checkbox" value="remember-me">아이디 저장	</label>
		</div>
		<button class="btn btn-lg btn-primary btn-block" type="submit">Sign	in</button>
		
	</form>
	<form class="form-signin" action="/jspTest/login/join.jsp">
		<button class="btn btn-lg btn-primary btn-block" type="submit">회원가입</button>
		<p class="mt-5 mb-3 text-muted">&copy; 2018-02 대덕인재개발원</p>
	</form>
	
	
</body>
</html>