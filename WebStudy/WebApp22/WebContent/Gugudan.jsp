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
<title>Gugudan.jsp</title>
<link rel="stylesheet" type="text/css" href="css/main.css">
</head>
<body>

<div>
	<h1>JSTL 코어(Core)를 활용한 구구단 출력</h1>
	<hr />
</div>

<div>
	<form>
		원하는 단 입력
		<input type="text" name="dan" class="txt"/>
		<br><br>
		
		<button type="submit" class="btn">결과 확인</button>
	</form>
</div>

<%-- 
<div>
	<h2>결과 처리 1</h2>
	
	<h3>${param.dan } 단 결과</h3>
	
	<c:if test="${!empty param.dan }">
		<c:forEach var="a" begin="1" end="9" step="1">
			<p> ${param.dan } * ${a } = ${param.dan *a } </p>
		</c:forEach>
	</c:if>
</div>
 --%>

<div>
	<h2>결과 처리 2</h2> 
	
	<h3>${param.dan }단 결과 확인!🖥</h3>
	
	<c:if test="${!empty param.dan }">
		<c:set var = "result" value = "0"></c:set>
		<c:forEach var="a" begin="1" end="9" step="1">
			<c:set var = "result" value ="${param.dan * a}"></c:set>
			<p>${param.dan } * ${a } = ${result }</p>
		</c:forEach>
	</c:if>?
</div>

</body>
</html>















