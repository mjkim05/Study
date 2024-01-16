<%@page import="java.util.Calendar"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%

	// 자기 자신 페이지(SendAndReceive07.jsp)로부터 데이터 수신
	// → year, month
	String sYear = request.getParameter("year");
	String sMonth = request.getParameter("month");

	// Calender 객체 생성
	Calendar cal = Calendar.getInstance();
	
	// 현재 년,월,일 확인
	int nowYear = cal.get(Calendar.YEAR);			// --2023
	int nowMonth = cal.get(Calendar.MONTH)+1;		// --12
	int nowDay = cal.get(Calendar.DAY_OF_MONTH);	// --11
	
	// 표시할 달력의 년, 월 구성 → 페이지 최초 요청을 감안한 코드
	int selectYear = nowYear;
	int selectMonth = nowMonth;
	
	// 페이지에 대한 요청이 최초 요청이 아닐 경우
	// → Line 7~8 을 통해 수신한 데이터로 표시할 달력 의 년, 월 구성
	
	if (sYear != null || sMonth != null)
	{
		selectYear = Integer.parseInt(sYear);
		selectMonth = Integer.parseInt(sMonth);
	}	
	
	// 테스트
	//out.print("<h1>selectYear : " + selectYear + "</h1>");
	//out.print("<h1>selectMonth : " + selectMonth + "</h1>");
	
	// 확인 한 날짜로 년도 select option 구성
	
	String yOptions = " ";
	for (int year=(selectYear-10); year<=(selectYear+10); year++)	//2013 ~ 2033
	{
		// 관찰1. 
		// "<option value = " + 2013 + ">" + 2013 + "</option>"; 
		// "<option value ="2013">2013</option>"; 
		// yOptions += "<option value = '" + year + "'>" + year + "</option>";  //--  홑따옴표 잘 챙기자! 
	
		// 관찰2. 
		//if (year==nowYear)
		//	yOptions += "<option value = '" + year + "'selected = 'selected'>" + year + "</option>"; 
		//else			
		//	yOptions += "<option value = '" + year + "'>" + year + "</option>"; 
			
		// 상황1. 페이지 최초 요청 일때 		→ sYear는 null / 현재 년도와 옵션이 같을 때 → selected(○)
		// 상황2. 페이지 최초 요청이 아닐때	    → sYear는 null 아님 / 선택 년도와 옵션이 같을 때 → selected(○)
		// 상황3. 나머지 						→ selected(Ⅹ)
	
		if (sYear == null && year == nowYear)
			yOptions += "<option value = '" + year + "'selected = 'selected'>" + year + "</option>"; 
		else if (sYear != null && year == Integer.parseInt(sYear))
			yOptions += "<option value = '" + year + "'selected = 'selected'>" + year + "</option>"; 
		else	
			yOptions += "<option value = '" + year + "'>" + year + "</option>";
	}	
	
	
	// 확인 한 날짜로 월 select option 구성
	
	String mOptions = " ";
	for (int month=1; month<=12; month ++)
	{
		// 관찰1.
		//mOptions += "<option value = '" + month + "'>" + month + "</option>";
		
		// 관찰2. 
		//if (month == nowMonth)
		//	mOptions += "<option value = '" + month + "' selected = 'selected' >" + month + "</option>";
		//else
		//	mOptions += "<option value = '" + month + "'>" + month + "</option>";
			
		// 상황1. 페이지 최초 요청 일때 		→ sMonth는 null 	  / 현재 월과 옵션이 같을 때 → selected(○)
		// 상황2. 페이지 최초 요청이 아닐때	    → sMonth는 null 아님 / 선택 월과 옵션이 같을 때 → selected(○)
		// 상황3. 나머지 						→ selected(Ⅹ)	
			
		if(sMonth == null && month == nowMonth)
		  mOptions += "<option value = '" + month + "' selected = 'selected' >" + month + "</option>";	
		else if (sMonth != null && month == Integer.parseInt(sMonth))
		  mOptions += "<option value = '" + month + "' selected = 'selected' >" + month + "</option>";
		else
		  mOptions += "<option value = '" + month + "'>" + month + "</option>";
	}
	
	// 그려야 할 달력의 1일이 무슨 요일인지 확인 필요
	// (만년 달력)
	/* 
	int nYear = 0;
	int nMonth = 0;
	
	if (sYear != null || sMonth !=null)
	{	
		nYear = Integer.parseInt(sYear);
	 	nMonth = Integer.parseInt(sMonth);
	}
	else
	{
		nYear = nowYear;
	 	nMonth = nowMonth;
	}
	
	int[] day = {31,28,31,30,31,30,31,31,30,31,30,31};
	
	// 전체 년도 날 수 뽑기
	int nalsu = (nYear-1)*365 + (nYear-1)/4 - (nYear-1)/100 + (nYear-1)/400;
	
	// 윤년일 경우
	if (nYear%4==0 && nYear%100 !=0 || nYear%400 ==0)
		day[1] = 29;
	else 
		day[1] = 28;
	
	// 월 까지 날수 뽑기
	for (int i=0; i<nMonth-1; i++)
	{
		nalsu += day[i];
	}	
	
	nalsu +=1;
	
	// 몇요일 부터 시작인지 체크
	int w = nalsu%7;
	
	out.print(w);
	
	String[] week = {"일요일","월요일","화요일","수요일","목요일","금요일","토요일"};
	String table = "";
	
	table += "<tr>";
	
	for(int i=0; i<7; i++)
	{	
		table += "<th>";
		table += week[i];
		table += "</th>";
	}	
	
	table += "</tr>";
	table += "<tr>";
	
	// 1일 시작 전까지 공백 출력
	for (int i=1; i<=w; i++)
	{
		table += "<td>";
		table += "   ";
		table += "</td>";	
	}	
	
	for (int i=1; i<=day[nMonth-1]; i++)
	{
		table += "<td>";
		table += i;
		table += "</td>";
		w++;
		
		if (w%7==0)
		{
			table += "</tr>";
			table += "<tr>";
		}	
	}	
	
	table += "</tr>";
	 */
	 
	 // 각 달의 마지막 날짜 배열 구성
	 int[] months = {31,28,31,30,31,30,31,31,30,31,30,31};
	 
	 // 윤년인지 평년인지 확인
	 if (selectYear%4==0 && selectYear%100 != 0 || selectYear%400 ==0)
		 months[1] = 29;
	 
	 // 총 날 수 누적 변수
	 int nalsu;
	 
	 // 요일 항목 배열 구성
	 String[] weekNames = {"일요일","월요일","화요일","수요일","목요일","금요일","토요일"};
	 
	 // 현재 년도 → 입력받은 월 이전 월까지의 날 수 추가
	 nalsu = (selectYear-1)*365 + (selectYear-1)/4 - (selectYear-1)/100 + (selectYear-1)/400;
	 
	 // 현재 월 → 입력받은 월의 이전 월까지의 날 수 추가
	 for (int i =0; i<selectMonth-1; i++)
		 nalsu += months[i];
	 
	 nalsu ++;
	 
	 int week = nalsu%7;					// 요일 변수
	 int lastDay = months[selectMonth-1]; 	//마지막 날짜 변수
	 
	 //System.out.println(week);
	 //--==>> 5
	
	 // 달력 그리기 ------------------------------------------------------------------
	 String calStr = "";
	 calStr += "<table border='1'>";		// start table
	 
	 // 요일 이름 발생
	 calStr += "<tr>";
	 for (int i = 0; i<weekNames.length; i++)
	 {
		 if (i==0)						// 일요일
		 	calStr += "<th style='color:red;'>" + weekNames[i] + "</th>";
		 else if (i==6)
		 	calStr += "<th style='color:blue;'>" + weekNames[i] + "</th>";
		 else	
		 	calStr += "<th>" + weekNames[i] + "</th>";
	 } 
	 calStr += "</tr>";
	 // 빈 칸 공백 td 발생
	 calStr += "<tr>";
	 for (int i=1; i<=week; i++)
		 calStr += "<td></td>";
	 
	 
	 // 날짜 td 발생
	 for (int i=1; i<=lastDay; i++)
	 {
		 week ++;							// 날짜가 하루씩 찍힐 때 마다 (구성이 이루어질때 마다)
		 									// 요일도 함께 1씩 증가할 수 있도록 처리
		 //calStr += "<td>" + i + "</td>";
		
		 
		 if(selectYear==nowYear && selectMonth==nowMonth && i==nowDay && week%7==0)
		 {
			 // 토요일인 오늘
			 calStr += "<td class = 'nowSat'>" + i + "</td>";
		 }
		 else if (selectYear==nowYear && selectMonth==nowMonth && i==nowDay && week%7==1)
		 {
			 // 일요일인 오늘
			 calStr += "<td class = 'nowSun'>" + i + "</td>";
		 }	 
		 else if (selectYear==nowYear && selectMonth==nowMonth && i==nowDay)
		 {
			 // 평일인 오늘
			 calStr += "<td class = 'now'>" + i + "</td>";
		 } 
		 else if (week%7==0)
		 {
			 // 오늘이 아닌 토요일
			 calStr += "<td class = 'sat'>" + i + "</td>";
		 }	 
		 else if(week%7==1)
		 {
			 // 오늘이 아닌 일요일
			 calStr += "<td class = 'sun'>" + i + "</td>";
		 }	 
		 else 
		 {
			 // 오늘이 아닌 평일
			 calStr += "<td>" + i + "</td>";
		 }	 
		 
		 
		 if (week%7==0)
			calStr += "</tr><tr>";
	 
	 }	 
	 // 빈칸 공백 td 발생
	 for (int i=0; i<=week; i++, week++)
	 {
		 if(week%7==0)
		 	break;
		 calStr += "<td></td>";
	 }	 
	 
	 if (week%7!=0)
		 calStr += "</tr>";
	 
	 calStr += "<table>";					// end table
	 	
	 // 달력 그리기 ------------------------------------------------------------------
	 
	 
	 
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SendAndReceive07.jsp</title>
<link rel="stylesheet" type="text/css" href="css/main.css">

<style type="text/css">
	
	td {text-align: right;}
	td.sun {color:red;}
	td.sat {color: blue;}
	td.now {background-color: aqua; font-weight: bold;}	/* 평일인 오늘 */
	td.nowSat {background-color: aqua; font-weight: bold; color: blue;}	/* 토요일인 오늘 */
	td.nowSun {background-color: aqua; font-weight: bold; color: red;}	/* 일요일인 오늘 */
	 table {width: 500px;} 

</style>

<script type="text/javascript">

	function formCalendar(obj)
	{
		// 유효성 검사가 필요한 경우 삽입 할 수 있는 영역~!!
		
		// ...
		
		obj.submit();
		
	}

</script>

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
	<h1>데이터 송수신 실습 07</h1>
	<hr>
</div>  
  
<div>
	<form action="" method="get">
		<select id="year" name= "year" onchange="formCalendar(this.form)">
			<!-- <option selected="selected"></option> -->
			<%=yOptions %>
		</select>
		년
		<select id="month" name="month" onchange="formCalendar(this.form)">
			<!-- <option selected="selected"></option> -->
			<%=mOptions %>
		</select>
		월
		<br><br>
	</form>  
</div>
  
<div>
	<%-- <table border="2">
		<%=table %>
	</table> --%>
	
	<%=calStr %>

</div>  

</body>
</html>