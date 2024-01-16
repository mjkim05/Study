<%@ page contentType="text/html; charset=UTF-8"%>
<%-- 
<%
	// 스크립릿 영역
	
	request.setCharacterEncoding("UTF-8");
	
	String userId = request.getParameter("userId");
	String userPwd = request.getParameter("userPwd");
	String userName = request.getParameter("userName");
	String userTel = request.getParameter("userTel");
	String genderStr = request.getParameter("gender");
	String location = request.getParameter("location");
	String[] subjectStr = request.getParameterValues("subject");
	String gender ="";
	String subject ="";
	

	for (int i=0; i<subjectStr.length; i++)
		subject += subjectStr[i] + " ";
	
	if (genderStr.equals("F"))
		gender = "여자";
	else if (genderStr.equals("M"))
		gender = "남자";
	else
		gender = "판별 불가";
%> 
--%>

<%
	// 스크립릿 영역
	
	// 이전 페이지(Send04.html)로부터 넘어온 데이터 수신
	// → userId, userPw, userName, userTel, userGender, userCity, userSubject
	
	request.setCharacterEncoding("UTF-8");

	String userId = request.getParameter("userId");
	String userPw = request.getParameter("userPw");
	String userName = request.getParameter("userName");
	String userTel = request.getParameter("userTel");
	
	String userGender = request.getParameter("userGender");
	String userCity = request.getParameter("userCity");
	
	//String userSubject = request.getParameter("userSubject");
	
	//check~!!!
	String[] userSubjectArr = request.getParameterValues("userSubject");
	
	String subjectStr ="";
	
	if (userSubjectArr != null)
	{
		for (int i=0; i<userSubjectArr.length; i++)
		{
			subjectStr += "[" + userSubjectArr[i].toString() + "]";
		}
	}
	
	// ※ 추후에는 수신된 데이터를... 쿼리문을 통해 DB 에 입력하는
	//    처리 과정 등이 포함될 것임을 염두하며 작업을 진행할 수 있도록 하자.
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Receive04.jsp</title>
<link rel="stylesheet" type="text/css" href="css/main.css">
<style type="text/css">
	span {color: blue; font-size: 15pt; font-weight: bold;}
</style>


</head>
<body>

<div>
	<h1>데이터 송수신 실습 04</h1>
	<hr>
</div>

<%-- 
<div>
아이디   : <%=userId %><br>
패스워드 : <%=userPwd %><br>
이름     : <%=userName %><br>
전화번호 : <%=userTel %><br>
성별     : <%=gender %><br>
지역     : <%=location %><br>
수강과목 : <%=subject %>
</div> 
--%>

<div>
	<h2>가입 승인 내역</h2>
	
	<!-- <p>아이디 : <span>superman</span></p> -->
	<p>아이디 : <span><%=userId %></span></p>
	
	<!-- <p>패스워드 : <span>1234</span></p> -->
	<p>패스워드 : <span><%=userPw %></span></p>
	
	<!-- <p>이름 : <span>정현욱</span></p> -->
	<p>이름 : <span><%=userName %></span></p>
	
	<!-- <p>전화번호 : <span>010-1234-5678</span></p> -->
	<p>전화번호 : <span><%=userTel %></span></p>
	
	<!-- <p>성별 : <span>남성</span></p> -->
	<p>성별 : <span><%=userGender %></span></p>
	
	<!-- <p>지역 : <span>서울</span></p> -->
	<p>지역 : <span><%=userCity %></span></p>
	
	<!-- <p>수강과목 : <span>[자바기초] [오라클중급]</span></p> -->
	<p>수강과목 : <span><%=subjectStr %></span></p>
</div>



</body>
</html>