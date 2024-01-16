
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.lang.reflect.Array"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%
	// 스크립릿 영역
		
	// 한글 깨짐 방지 처리
	request.setCharacterEncoding("UTF-8"); //check~~!!
	
	// 이전 페이지(RadioSelect.jsp)로부터 데이터수신
	String nameStr = request.getParameter("name");			// 텍스트 박스.. 단일 값 수신
	String genderStr = request.getParameter("gender");			// 라디오 버튼.. 단일 값 수신
	String majorStr = request.getParameter("major");			// 선택 상자... 단일 값 수신
	//String hobbyStr = request.getParameter("hobby");			// 선택 상자... 다중 데이터 수신
	String[] hobbyArr = request.getParameterValues("hobby");			
	// 다중 선택이 가능한 선택상자일 경우...
	// 『getParameterValues』 로 데이터 수신
	// → 배열 반환
	
	// gender 수신 및 처리
	String gender = "";
	if(genderStr.equals("M"))
		gender = "남자";
	else if(genderStr.equals("F"))
		gender = "여자";
	else
		gender= "확인불가";
	
	// hobby 수신 및 처리
	String hobby ="";
	if(hobbyArr != null)
	{
		for (String hob: hobbyArr)
			hobby += "[" + hob + "]";
	}
	
/* 	
	String hobStr = "";
	
	for (int i = 0; i < hobbyArr.length; i++)
	{
		hobStr += hobbyArr[i] + " ";
	}
	
	String str = "";
	
	str = "이름: " + nameStr + " 성별: " + gender + " 전공: " + major + " 취미 :" + hobStr; */
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>RadioSelectOk.jsp</title>
</head>
<body>

<div>
	<h1>JSP를 이용한 데이터 송수신 실습03</h1>
	<hr>
	<p>RadioSelect.jsp → RadioSelectOk.jsp</p>
</div>

<div>

	<%= str %>
	
</div>

</body>
</html>