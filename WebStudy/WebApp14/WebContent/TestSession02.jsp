<%@ page contentType="text/html; charset=UTF-8"%>
<%
	// 이전 페이지로부터 넘어온 데이터 수신
	// → userName, userTel
	
	// 한글깨짐 방지
	request.setCharacterEncoding("UTF-8");

	String name = request.getParameter("userName");
	String tel = request.getParameter("userTel");
	
	// check~!! 
	// 추가
	session.setAttribute("name",name);
	session.setAttribute("tel" ,tel);


%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TestSession02.jsp</title>
<link rel="stylesheet" type="text/css" href="css/MemberScore.css">

<script type="text/javascript">

	function sendIt()
	{
		//alert("함수호출");
		
		var f = document.sendForm
		
		if(!f.userId.value)
		{
			alert("아이디를 입력하세요!");
			userId.focus();
			return;
		}	
		
		if(!f.userPwd.value)
		{
			alert("비밀번호를 입력하세요!");
			userPwd.focus();
			return;
		}	
		
		f.submit();
		
	}
</script>

</head>
<body>

<div>
	<h1>정보(아이디,비밀번호) 전달 실습</h1>
	<hr>
</div>

	<div>
	<form action="TestSession03.jsp" method="post" name="sendForm">
	<table>
		<tr>
			<th>아이디<th>
			<td>
			<input type ="text" name = "userId" calss ="txt">
			</td>
		</tr>	
		<tr>
			<th>패스워드<th>
			<td>
			<input type ="text" name = "userPwd" calss ="txt">
			</td>
		</tr>	
		<tr>
			<td colspan="2">
				<button type="button" class="btn" style="width: 100%;"
				onclick="sendIt()">입력하기</button>
			</td>
		</tr>	
	</table>
	</form>
</div>
</body>
</html>