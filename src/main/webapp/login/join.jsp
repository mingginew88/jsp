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
	<form class="form-signin" method="post" action="/jspTest/joinServlet">		
		<h1 class="h3 mb-6 font-weight-normal">회원가입</h1>
		<input type="text" id="joinId" name="joinId" class="form-control" placeholder="아이디" required autofocus> 
		<input type="text" id="joinName"  name="joinName" class="form-control" placeholder="이름" required>
		<input type="password" id="joinPassword"  name="joinPassword" class="form-control" placeholder="비밀번호" required>
		<input type="text" id="joinEmail"  name="joinEmail" class="form-control" placeholder="이메일" required>
		<input type="text" id="joinTel"  name="joinTel" class="form-control" placeholder="전화번호" required>
		<input type="text" id="joinAddr1"  name="joinAddr1" class="form-control" placeholder="주소" required>
		<input type="text" id="joinAddr2"  name="joinAddr2" class="form-control" placeholder="상세주소" required>
		<button class="btn btn-lg btn-primary btn-block" type="submit">가입하기</button>		
		<p class="mt-5 mb-6 text-muted">&copy; 2018-02 대덕인재개발원</p>
	</form>	
	
</body>
</html>