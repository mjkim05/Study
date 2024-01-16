<%@ page contentType="text/html; charset=UTF-8"%>
<%
	// 스크립릿 영역
	
	// 이전 페이지(Send02.html)로부터 넘어온 데이터 수신
	// → userName, kor, eng, mat
	
	request.setCharacterEncoding("UTF-8");
	
	String name=request.getParameter("name");
	String korStr=request.getParameter("kor");
	String engStr=request.getParameter("eng");
	String matStr=request.getParameter("mat");
	
	/* 
	int kor, eng, mat;
	kor=eng=mat=0;
	으로 할걸^^;;
	*/
	int kor=0;
	int eng=0;
	int mat=0;
	
	int tot=0;
	double avg=0;
	
	try
	{	// 놀랍게도... 진짜 똑같음 완전 또옥 같음 귀찮아서 필기 안 한거 아님
		kor=Integer.parseInt(korStr);
		eng=Integer.parseInt(engStr);
		mat=Integer.parseInt(matStr);
		tot=kor+eng+mat;
		avg=tot/3.0;
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
<title>Receive02.jsp</title>
<link rel="stylesheet" type="text/css" href="css/main.css">
<style type="text/css">
	span
	{
		color: blue;
		font-weight: bold;
		font-size: 15pt;
	}
</style>
</head>
<body>

<div>
	<h1>데이터 송수신 실습 02</h1>
	<hr>
</div>

<div>
	<span><%=name %></span>님, 성적 처리가 완료되었습니다.<br>
	회원님의 점수는 국어:<span><%=kor %></span>점, 영어:<span><%=eng %></span>점, 수학:<span><%=mat %></span>점 입니다.<br>
	총점은 <span><%=tot %></span>점, 평균은 <span><%=String.format("%.1f",avg) %></span>점 입니다.
	<!-- 강사님 방법도 String.format 임~ -->
	<%-- 총점은 <span><%=tot %></span>점, 평균은 <span><%=avg %></span>점 입니다. --%>
</div>

</body>
</html>