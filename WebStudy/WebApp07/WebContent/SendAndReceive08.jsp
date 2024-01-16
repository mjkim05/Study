<%@page import="java.time.Year"%>
<%@page import="java.util.Calendar"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%

	// 캘린더 객체 구성
	Calendar cal = Calendar.getInstance();

	int nowYear = cal.get(Calendar.YEAR);
	int nowMonth = cal.get(Calendar.MONTH)+1;
	int nowDay = cal.get(Calendar.DAY_OF_MONTH);
	
	// 이전 페이지(SendAndReceive08.jsp)로부터 넘어온 데이터 수신
	// → year , monthl
	
	String strYear = request.getParameter("year");
	String strMonth = request.getParameter("month");

	
	// 표시 할 달력
	
	int selectYear = nowYear;
	int selectMonth = nowMonth;
	
	if (strYear!=null)
		selectYear = Integer.parseInt(strYear);
	if (strMonth!=null)
		selectMonth = Integer.parseInt(strMonth);
	
	// 이전과 이후 구성
	int preYear = selectYear;
	int preMonth = selectMonth-1;
	
	if (preMonth < 1)
	{
		preYear = selectYear -1;
		preMonth = 12;
	}	
	
	int nextYear = selectYear;
	int nextMonth = selectMonth+1;
	
	if (nextMonth > 12)
	{
		nextYear = selectYear+1;
		nextMonth = 1;
	}	
	
	// 날짜 배열 구성
	int[] months = {31,28,31,30,31,30,31,31,30,31,30,31};
	
	// 윤년 평년 구분
	if (selectYear%4==0 && selectYear%100 !=0 || selectYear%400==0)
		months[1] = 29;
	
	// 달력 만들기
	int nalsu = (selectYear-1)*365 + (selectYear-1)/4 - (selectYear-1)/100 + (selectYear)/400;
	
	// 월 더하기
	for (int i=0; i<selectMonth-1; i++)
	{
		nalsu += months[i];
	}	

	nalsu ++;
	
	// 요일 구하기
	String[] weekNames = {"일요일","월요일","화요일","수요일","목요일","금요일","토요일"};
	
	int week = nalsu%7;
	int lastDay = months[selectMonth-1];
	
	String table ="";
		
	// 테이블 만들기
	table += "<table border = '1'><tr>";
	
	// 요일 구성하기
	for (int i = 0; i<weekNames.length; i++)
	{
		table += "<th>"+ weekNames[i] + "</th>";
	}
	table += "</tr>";
	
	 // 빈칸 넣기
	table += "<tr>";
	for (int i=0; i<week; i++)
		table += "<td></td>";
		
	// 날짜 td 발생
	for (int i=1; i<=lastDay; i++)
	{
		week ++;
		table += "<td>" + i + "</td>";
		
		if (week%7==0)
			table += "</tr><tr>";
	}
	
	// 빈칸 td 넣기
	 for (int i=0; i<=week; i++, week++)
	 {
		 if(week%7==0)
		 	break;
		 table += "<td></td>";
	 }	 
	
	table += "</tr>";
	 
	table += "</table>";
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SendAndRecive08.jsp</title>
</head>
<body>

<!--
	○ 데이터 송수신 실습 07
	   
	   - 달력을 출력하는 JSP 페이지를 구성한다.
	   - 전송한 내용을 수신해서 출력해주는 형태의 단독 페이지로 구성한다.
	   - submit 버튼 없이 이벤트 처리를 한다.
	   
	   ◀ 2023년 12월 ▶
	   
	   -------------------------------------
	   -------------------------------------
	   -------------------------------------
	   
	   -- 『◀』 이나 『▶』 클릭시
	      해당 년 월의 달력을 출력해주는 형태의 페이지로 구현한다.
	      
	   -- 사용자 최초 요청 주소는
	  	  http://localhost:3306/WebApp07/SendReceive08.jsp 로 한다.
	  	 
	 ○ SendAndReceive08.jsp 	 
-->	   
	   
<div>
	<h1>데이터 송수신 실습 08</h1>
	<hr>
</div>	

<div>
	<form action="" method="get">
		<%-- <a href="http://localhost:3306/WebApp07/SendAndReceive08.jsp?selectYear=<%=nowYear%>&selectMonth=<%=nowMonth%>" name="down" id="up">◀</a> --%>
		<a href ="SendAndReceive08.jsp?year=<%=preYear %>&month=<%=preMonth%>">◀</a>
		<%=selectYear %>년
		<%=selectMonth %>월
		<a href ="SendAndReceive08.jsp?year=<%=nextYear %>&month=<%=nextMonth%>">▶</a>
		<%-- <a href="http://localhost:3306/WebApp07/SendAndReceive08.jsp?selectYear=<%=nowYear%>&selectMonth=<%=nowMonth%>" name="up" id="up">▶</a> --%>
		<br><br>
		 <%=table %> 
	<%-- 	<%=calStr %> --%>
	</form>
</div>    

</body>
</html>