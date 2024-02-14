<%@page import="java.time.Year"%>
<%@page import="java.util.Calendar"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	request.setCharacterEncoding("UTF-8");
	String cp = request.getContextPath();
%>
<%

	// 캘린더 객체 구성
	Calendar cal = Calendar.getInstance();

	int nowYear = cal.get(Calendar.YEAR);
	int nowMonth = cal.get(Calendar.MONTH)+1;
	int nowDay = cal.get(Calendar.DAY_OF_MONTH);
	
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
	String[] weekNames = {"일","월","화","수","목","금","토"};
	
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
<title>캘린더</title>
</head>
<body>

<div>
	<form action="" method="get">
		<a href ="GroupMain_Boot.jsp?year=<%=preYear %>&month=<%=preMonth%>">◀</a>
		<%=selectYear %>년
		<%=selectMonth %>월
		<a href ="GroupMain_Boot.jsp?year=<%=nextYear %>&month=<%=nextMonth%>">▶</a>
		<br><br>
		 <%=table %> 
	<%-- 	<%=calStr %> --%>
	</form>
</div>    

</body>
</html>