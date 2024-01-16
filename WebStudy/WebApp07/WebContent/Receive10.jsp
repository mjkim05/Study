<%@ page contentType="text/html; charset=UTF-8"%>
<%
	
	// 이전 페이지로(Forward10.jsp)부터 넘어온 데이터 수신
	// → resultStr
	// 어트리뷰트로 넣은 것은 어트리뷰트로 꺼내서 써야한다.
	String result = (String)request.getAttribute("resultStr");		// 오브젝트 → 스트링 다운 캐스팅!!!


	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Receive10.jsp</title>
<link rel="stylesheet" type="text/css" href="css/main.css">
</head>
<body>

<div>
	<h1>데이터 송수신 실습 10</h1>
	<hr>
</div>

<div>
	<!-- <h2>연산 결과 : 235 </h2> -->
	<h2>연산 결과 : <%=result %> </h2>
</div>

</body>
</html>