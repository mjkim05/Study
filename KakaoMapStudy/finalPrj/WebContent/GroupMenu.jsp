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
<link rel="stylesheet" type="text/css" href="<%=cp %>/css/groupMenu.css">

</head>
<body>

<div>
	<h1>약속해조<span>✉️</span><span>🔔</span></h1>

</div>

<div id="menu">
	<ul>
		<li>
			<a href="" class="menu">모임</a>
		</li>
		<li>
			<a href="" class="menu">친구</a>
		</li>
		<li>
			<a href="" class="menu">그룹원</a>
		</li>
		<li>
			<a href="" class="menu">기타 등등</a>
		</li>
		
	</ul>
</div>




</body>
</html>