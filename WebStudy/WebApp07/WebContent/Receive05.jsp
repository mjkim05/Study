<%@ page contentType="text/html; charset=UTF-8"%>
<%
	String danStr = request.getParameter("dan");
	StringBuilder sb = new StringBuilder();
	int dan = 0;
	try
	{
		dan = Integer.parseInt(danStr);
		for(int i=1; i<=9; i++)
		{
			sb.append(String.format("%d * %d = %d<br>",dan, i, dan*i));
		}
	}
	catch(Exception e)
	{
		System.out.println(e.toString());
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Receive05.jsp</title>
<link rel="stylesheet" type="text/css" href="css/main.css">
</head>
<body>

<div>
	<h1>데이터 송수신 실습 05</h1>
	<hr>
</div>

<div>
	<h2>구구단 출력</h2>
	<div>
		결과물...
		<br>
		<%=sb.toString() %>
	</div>
</div>

</body>
</html>