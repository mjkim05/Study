<%@ page contentType="text/html; charset=UTF-8"%>
<%

	session.invalidate();

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TestSession01.jsp</title>
<link rel="stylesheet" type="text/css" href="css/MemberScore.css">
<script type="text/javascript">

	function sendIt()
	{
		// 확인
		//alert("함수호출");
		
		// var f = document.sendForm[0];	이렇게 얻어오는 것도 가능	
		var f = document.sendForm
		
		if (!f.userName.value)
		{
			alert("이름을 입력해주세요");
			userName.focus();
			return;
		}
		if (!f.userTel.value)
		{
			alert("전화번호를 입력해주세요");
			userTel.focus();
			return;
		}
		
		f.submit();
		
	}

</script>
</head>
<body>

<!-- 
	○ TestSession01.jsp 에서 TestSession02.jsp 페이지로
	   이름과 전화번호를 입력받아 전송
	   
	   TestSession02.jsp 에서 TestSession03.jsp 페이지로 
	   아이디와 패스워드를 입력 받고
	   앞에서 전달받은 이름과 전화번호를 함께 전송
	   
	   TestSession03.jsp에서 전달받은 이름, 전화번호, 아이디, 패스워드 출력
	   
	   01 →→→→→→→→→→ 02 →→→→→→→→→→→ 03
	   이름, 전화			   아이디, 패스워드 		 이름, 전화, 아이디, 패스워드
	   입력					   입력 					 출력

	※ 즉 01에서 02로 넘겨 받을 땐 getParameter
	   02에서 03으로 넘겨 받을 땐 getParameter와 getAttribute 로 세션 활용
	   01에서 03에서 직접 넘겨줄 수 없기 때문에 세션(session)에 저장
	   
	※ session 외의 input 태그 hidden 속성을 이용한 정보 전달 가능~~!!!    

 -->


<div>
	<h1>정보(이름, 전화번호) 전달 실습</h1>
	<hr>
</div>

<div>
	<form action="TestSession02.jsp" method="post" name="sendForm">
	<table>
		<tr>
			<th>이름<th>
			<td>
			<input type ="text" name = "userName" calss ="txt">
			</td>
		</tr>	
		<tr>
			<th>전화번호<th>
			<td>
			<input type ="text" name = "userTel" calss ="txt">
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