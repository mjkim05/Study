<%@ page contentType="text/html; charset=UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	/* 
	String[] love = request.getParameterValues("love");
	
	String str =""; 
	if (love != null)
	{	
		for (String s2 : love)
			str+= s2 + " ";
	} */
%>
<!-- 내가 푼거 -->
<%-- <jsp:setProperty property="*" name="ob"/>
<jsp:setProperty property="love" name="ob" value="<%=str %>"/> --%>

<jsp:useBean id="ob" class="com.test.FriendDTO"></jsp:useBean>
<jsp:setProperty property="*" name="ob"/>

<!-- 반복문 필요(다중 선택으로 넘어온 결과값을 출력하기 위한 처리) -->
<%
	String str = "";
	if (ob.getLove() != null)
	{
		for (String temp : ob.getLove())
			str += temp + " ";
	}	



%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Friend_ok.jsp</title>
<link rel="stylesheet" type="text/css" href="css/main.css">
</head>
<body>

<div>
	<h1>등록 수신 결과 확인</h1>
	<hr/>
</div>

<%-- <div>
	<h3>이름 : <%=ob.getName() %></h3>
	<h3>나이 : <%=ob.getAge() %></h3>
	<h3>성별 : <%=ob.getGender() %></h3>
	<h3>이상형 : <%=ob.getLove() %></h3>
</div> --%>

<div>
	<h3>이름 : <%=ob.getName() %></h3>
	<h3>나이 : <%=ob.getAge() %></h3>
	<h3>성별 : <%=ob.getGender() %></h3>
	<h3>이상형 : <%=str %></h3>
</div>


</body>
</html>