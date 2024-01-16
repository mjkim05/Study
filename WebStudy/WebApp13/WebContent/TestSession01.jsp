<%@ page contentType="text/html; charset=UTF-8"%>
<%

	// 최초 요청일 경우.... 아무것도 없겠지만....
	// TestSession01_ok.jsp 페이지에서
	// 로그인 성공 후에 요청된 페이지라면...
	// session 의 userId 에 superman 을...
	//            userName 에 문정환을 담아서 보낸 상황
	
	
	String userId = (String)session.getAttribute("userId");			// "superman"
	String userName = (String)session.getAttribute("userName");		// "문정환"
	//--session.getAttribute("userId")는 
	//  Object 타입으로 반환하므로 
	//  String 타입으로 변환하는 과정 필요
	
	
	// 추가~!!!
	// 세션 활성화 시간 변경 ---------------------------------------------------------
	
	// ※ 세션 기본(default) 시간은 1800초.
	
	session.setMaxInactiveInterval(10);
	//-- 세션이 유지되는 시간을 10초로 설정한 상태
	//   이로인해...
	//   로그인 후 10초동안 아무 액션도 없는 상태에서...
	//   다시 기능을 이용하려 하거나, 페이지 새로고침을 수행하면
	//   로그아웃 처리 된 것을 확인할 수 있다.
	
	
	// --------------------------------------------------------- 세션 활성화 시간 변경
	
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TestSession01</title>
<link rel="stylesheet" type="text/css" href="css/MemberScore.css">
<style type="text/css">
	a {text-decoration: none;}
	.btnMenu
	{
		border: 1px solid gray;
		border-radius: 3px;
		font-size: 8pt;
		width: 60px;
		height: 20px;
	}

</style>

<script type="text/javascript">

	function sendIt()
	{
		// 확인
		//alert ("함수호출~");
		
		var f = document.myForm;
		
		if (!f.userId.value)
		{
			alert("아이디를 입력해야 합니다~~!!");
			f.userId.focus();
			return;
		}
		if (!f.userPwd.value)
		{
			alert("패스워드를 입력해야 합니다~!!");
			f.userPwd.focuns();
			return;
		}	
		
		f.submit();
		
	
	}


</script>


</head>
<body>

<div>
	<h1>세션 처리 - 로그인</h1>
	<hr>
</div>

<div>
	<table>
		<tr>
			<td>
				<a href = "">
					<button type="button" class="btnMenu btn01" >게시판</button>
				</a> |
				
				<%
				if(userId==null)
				{	
				%>
				<a href = "">
					<button type="button" class="btnMenu btn02">일정관리</button>
				</a> |
				<a href = "">
					<button type="button" class="btnMenu btn02">친구관리</button>
				</a> | ...
				<%
				}
				else
				{
				%>
				<a href = "Sca.jsp">
					<button type="button" class="btnMenu btn01">일정관리</button>
				</a> |
				<a href = "Fri.jsp">
					<button type="button" class="btnMenu btn01">친구관리</button>
				</a> | ...
				<%
				}
				%>
				
			</td>
		</tr>
	</table>
	<br><br>
	
	<table>
		<tr>
			<td>
				<%
				if (userId==null)
				{	
				%>
				<form action="TestSession01_ok.jsp" method="post" name="myForm">
				<table>
					<tr>
						<th>아이디</th>
						<td>
							<input type="text" name="userId" class="txt">
						</td>
					</tr>
					<tr>
						<th>패스워드</th>
						<td>
							<input type="text" name="userPwd" class="txt">
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<button type="button" class="btn" style="width: 100%;"
							onclick="sendIt()">로그인</button>
						</td>
					</tr>
				</table>
				</form>
				<%
				}
				else
				{	
				%>
				<h2><%=userName%>(<%=userId %>)님, 환영합니다!!!!!!!!🎉🎃🎉🎃</h2>
				<p>이제, 일정관리와 친구관리 서비스를 이용할 수 있습니다.</p>
				<p>
					<a href="Logout.jsp">
						<button type="button" class="btnMenu btn01">로그아웃</button>					
					</a>
				</p>
				<%
				}
				%>
			</td>
		</tr>
	</table>
</div>





</body>
</html>