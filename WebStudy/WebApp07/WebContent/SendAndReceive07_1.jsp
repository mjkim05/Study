
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Calendar"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%
	// Calender 객체 생성
	
	Calendar cal = Calendar.getInstance();

	int year = cal.get(Calendar.YEAR);
	int month = cal.get(Calendar.MONTH);
	int day = cal.get(Calendar.DAY_OF_MONTH);
	
	int[] arrDate = {31,28,31,30,31,30,31,31,30,31,30,31};
	
	// 만년 달력 그리기
	if (year%4 ==0 && year %100 !=0 || year % 400 == 0)
		arrDate[1] = 29;
	else 
		arrDate[1] = 28;
	
	int nalsu = (year-1)*365 + (year-1)/4 - (year-1)/100 + (year-1)/400;
	
	for(int i=0; i<month-1; i++)
		nalsu += arrDate[i];
	
	int temp = nalsu%7;
	
	// 확인
	//table += arrDay[11];  -- 31
	//table += arrDay[month];

	String table = "";
	table += "<tr>";
	for (int i = 0, n =1; i<arrDate[month]; i++)
	{
		if (i<=temp+1)
		{
			table += "<td>";
			table += "  ";
			table += "</td>";
		}

		
			
	}

	table += "</tr>";

	/* 	String yearStr = request.getParameter("year");
		String monthStr = request.getParameter("month");
		
		
		String str = "";
		String strM = "";
		
		for (int i = 0; i<=10; i++)
		{	
	str += "<option value=" + year + ">";
	str += year;
	str += "</option>";
	//year ++;
		}
		
		month = 12;
		
		for (int i = 0; i<12; i++)
		{	
		
	strM += "<option value=" + month + ">";
	strM += month;
	strM += "</option>";
	//month ++;
		}  */
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SendAndReceive07_1.jsp</title>



</head>
<body>


<!--
	○ 데이터 송수신 실습 07
	   
	   - 달력을 출력하는 JSP 페이지를 구성한다.
	   - 페이지 레이아웃은 연도와 월을 입력 받아
	     화면에 출력해주는 형태의 페이지로 구성한다.
	   - 단, submit 버튼 없이 이벤트 처리를 할 수 있도록 한다.
	   - 전송한 내용을 스스로 수신해서 출력해주는 형태의 페이지로 구성한다.
	   - 연도 선택 기본 구성은 현재의 연도를 기준으로 
	     이전 10년, 이후 10년으로 구성한다.
	     (기본적으로 만년달력 형태로 구성하는데
	      햔재의 연,월은 달력 객체로부터 확인할 수 있도록 한다.)
	   - 월 선택 기본 구성은 1월부터 12월 까지로 구성한다.
	   
	   	   2013
	   	    :
	   	 [ 2023 ▼ ] 년 [12 ▼ ] 월
	        :
	       2033             
	       
	     ---------------------------
	     ---------------------------  
		 ---------------------------
		 
	  - 연도 select 나 월 select 내용이 변화되면
	    해당 연 월월의 달력을 출력해주는 형태의 페이지로 구성한다.
	    
	  - 사용자 최초 요청 주소는 
	    http://localhost:3306/WebApp07/SendAndReceive07.jsp
	    
	 ○ SendAndReceive07.jsp      
	    	 	        
  -->
  
  
<div>
	<form method="post">
		<select id="year" name= year">
			<%-- <option selected="selected"><%=year %></option> --%>
			<%-- <%=str %> --%>
		</select>
		년
		<select id="month" name="month">
			<%-- <option selected="selected"><%=month %></option> --%>
			<%-- <%=strM %> --%>
		</select>
		월
		<br><br>
	</form>  
</div>
  
<div>

	<table border="2" id = table>
		<tr>
			<th>일</th>
			<th>월</th>
			<th>화</th>
			<th>수</th>
			<th>목</th>
			<th>금</th>
			<th>토</th>
		</tr>
		<%=table %>
	</table>

</div>  

</body>
</html>