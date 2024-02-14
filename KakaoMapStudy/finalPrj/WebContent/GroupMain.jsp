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
<title>GroupMain</title>
<link rel="stylesheet" type="text/css" href="<%=cp %>/css/groupMain.css">
<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
<script type="text/javascript" src="http://code.jquery.com/jquery.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>

</head>
<body>

<c:import url="GroupMenu.jsp"></c:import>


<div class="main">
		<div class="left">
			<div id="groupProfile">
			<img alt="" src="https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAxODEwMTJfMTg3%2FMDAxNTM5MjczODEzNzA5.WDsWslzOeGA5M-eLHxafxuzk8jCO0Z6I91JDqpdkY84g.nISulTECtGQQRjnq9yUb7t19ZzUfqTOK-tZ538E9Rrwg.PNG.box182%2F%25B9%25AB%25C1%25A6681.png&type=sc960_832"><br>
			고양이 좋아 멤버:100명<br>
			고양이를 사랑하는 사람들의 그룹 😺
			</div>
			<div id="groupMember">
				<h3 id="list">그룹원 목록<h3>
				<ul>
					<li>으나👑</li>
					<li>밍</li>
					<li>낑</li>
					<li>욱</li>
					<li>깡</li>
					<li>고양이</li>
					<li>나비</li>
					<li>:</li>
				</ul>
			</div>
		</div>
		<div class="center">2</div>
		<div class="right">3</div>
</div>
<div id="footer">
	<footer>
		<a>이용약관</a>
		<a>개인정보처리방침</a>
		<a>약속해조 정책</a>
		<a>고객센터</a>
		<a>ⓒ 약속해조</a>
	</footer>
</div>
</body>
</html>