<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	request.setCharacterEncoding("UTF-8");
	String cp = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
<script type="text/javascript" src="http://code.jquery.com/jquery.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/groupMenu_Boot.css">


</head>
<body>

<div class="basic">
	<span style="margin: 5px;"></span>
	<h1>약속해조
		<i class="bi bi-envelope-heart"></i>
		<i class="bi bi-bell-fill"></i>
	</h1>
	<br>
</div>

<div class="row">
	<div class="col-xs-3 col-sm-3 col-md-3"><a>모임</a></div>
	<div class="col-xs-3 col-sm-3 col-md-3"><a>그룹원</a></div>
	<div class="col-xs-3 col-sm-3 col-md-3"><a>자유 게시판</a></div>
	<div class="col-xs-3 col-sm-3 col-md-3"><a>후기 게시판</a></div>
</div>


</body>
</html>