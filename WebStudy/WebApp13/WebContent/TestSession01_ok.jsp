<%@ page contentType="text/html; charset=UTF-8"%>
<%

	// TestSession_ok.jsp
	
	// 이전 페이지(TestSession01.jsp)로 부터 넘어온 데이터 수신
	String userId = request.getParameter("userId");
	String userPwd = request.getParameter("userPwd");
	
	// DB 활용 → dao 로그인 처리 → dto 활용
	// → 로그인 관련 테이블의 데이터와 비교 → 최종적으로 로그인 액션 처리

	String memberId = "superman";
	String memberPwd = "1234567";
	String memberName = "문정환";
	
	if (userId.equals(memberId) && userPwd.equals(memberPwd))
	{
		// 로그인 액션 처리
		session.setAttribute("userId", userId);			//-- userId 	→ superman
		session.setAttribute("userName", memberName);	//-- memberName → 문정환
		
		// 클라이언트가 페이지를 다시 요청할 수 있도록 안내
		response.sendRedirect("TestSession01.jsp");
	}
	
	
	
	

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TestSession01_ok.jsp</title>
<link rel="stylesheet" type="text/css" href="css/main.css">
</head>
<body>

<div>
	<h1>로그인 실패~~!!</h1>
	<hr>
</div>

<a href="TestSession01.jsp">로그인 페이지로 돌아가기</a>


</body>
</html>





















