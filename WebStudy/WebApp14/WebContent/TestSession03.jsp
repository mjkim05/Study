<%@ page contentType="text/html; charset=UTF-8"%>
<% 
	// 이전페이지(TestSession02.jsp)로부터 넘어온 데이터 수신
	request.setCharacterEncoding("UTF-8");

	String id = request.getParameter("userId");
	String pwd = request.getParameter("userPwd");
	
	String name = (String)session.getAttribute("name");
	String tel = (String)session.getAttribute("tel");
	
	// session 비우기
	session.removeAttribute("name");
	session.removeAttribute("tel");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TestSession03.jsp</title>
<link rel="stylesheet" type="text/css" href="css/MemberScore.css">
</head>
<body>
	
<div>
	<h1>전달 받은 정보 출력</h1>
	<hr>
</div>	

<h4>이름 : <%=name %></h4>
<h4>전화번호 : <%=tel %></h4>
<h4>아이디 :  <%=id %></h4>
<h4>비밀번호 : <%=pwd %></h4>

<br>
<a href="TestSession01.jsp">
<button>처음으로 돌아가기!</button>
</a>
	
</body>
</html>