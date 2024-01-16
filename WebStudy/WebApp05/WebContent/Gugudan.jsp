<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gugudan.jsp</title>

<link rel = "stylesheet" type="text/css" href ="css/main.css">

</head>
<body>

<div>
	<h1>JSP를 이용한 데이터 송수신 실습 02</h1>
	<hr>	
	<p>Gugudan.jsp → GugudanOk.jsp</p>
</div>

<!-- html 주석문 브라우저한테 이부분은 보여주지마~ 라는 의미! (인식 못하는거 아님!) -->
<%-- jsp 주석문 서블릿 컨테이너가 인식하지 못하도록 하는 주석--%>

<div>
	<form action ="GugudanOk.jsp" method="post">
		<table class = "table">
			<tr>
				<th>원하는 단 입력</th>
				<td>
					<input type="text" name = "dan" class="txt">
				</td>
			</tr>
			<tr>
				<td colspan="2">
				<input type="submit" value="결과 확인" class="btn control"
				style ="width: 100%;"> 
			</tr>
		</table>
	</form>
	

</div>


</body>
</html>