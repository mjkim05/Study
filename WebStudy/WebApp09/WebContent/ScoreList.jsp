<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="com.util.DBConn"%>
<%@page import="java.sql.Connection"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%
	
 	Connection conn = DBConn.getConnection();
	String str ="";
	
	String db ="";
	if (conn!=null)
	{
		db = "데이터베이스 연결 성공";
	}
	

	// 쿼리문 구성
	String sql = "SELECT SID, NAME, KOR, ENG, MAT, (KOR+ENG+MAT) AS TOT, (KOR+ENG+MAT)/3 AS AVG FROM TBL_SCORE ORDER BY SID";
	
	
	// 작업 객체 생성
	Statement stmt = conn.createStatement();
	ResultSet rs = stmt.executeQuery(sql);
	

	// 테이블 생성
	
	str += "<table border='1'>";
	str += "<tr>";
	str += "<th>번호</th>";
	str += "<th>이름</th>";
	str += "<th>국어점수</th>";
	str += "<th>영어점수</th>";
	str += "<th>수학점수</th>";
	str += "<th>총점</th>";
	str += "<th>평균</th>";
	str += "</tr>";
	
	while (rs.next())
	{
		str += "<tr>";
		str += "<td>"+ rs.getString("SID") + "</td>";
		str += "<td>"+ rs.getString("NAME") + "</td>";
		str += "<td>"+ rs.getString("KOR") + "</td>";
		str += "<td>"+ rs.getString("ENG") + "</td>";
		str += "<td>"+ rs.getString("MAT") + "</td>";
		str += "<td>"+ rs.getString("TOT") + "</td>";
		str += "<td>"+ rs.getString("AVG") + "</td>";
		
		str += "</tr>";
	}

	str += "</table>";


%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ScoreList.jsp</title>
<link rel="stylesheet" type="text/css" href="css/main.css">
<style type="text/css">
	
	span.error {color: red; display: none;}
	
</style>

<script type="text/javascript">

	function actionScore()
	{
		var name = document.getElementById("name");
		var kor = document.getElementById("kor");
		var eng = document.getElementById("eng");
		var mat = document.getElementById("mat");
		
		var eName = document.getElementById("nameErr");
		var eKor = document.getElementById("korErr");
		var eEng = document.getElementById("engErr");
		var eMat = document.getElementById("matErr");
		
	  	eName.style.display = "none";
		if (name.value == "")
		{
			eName.style.display = "inline";
			return false;
		}
		eKor.style.display = "none";
		else if (parseInt(kor.value) > 100 || parseInt(kor.value) < 0 )
		{
			eKor.style.display = "inline";
			return false;
		}
		
		else if (parseInt(eng.value) > 100 || parseInt(eng.value) < 0 )
		{
			eEng.style.display = "inline";
			return false;
		}
		else if (parseInt(mat.value) > 100 || parseInt(mat.value) < 0 )
		{
			eMat.style.display = "inline";
			return false;
		}
	
		return true;
	}

</script>

</head>
<body>

<!-- 
	○ WebApp09
	
	- 여러 명의 이름, 국어점수, 영어점수, 수학점수를 입력 받아
	  총점과 평균을 계산하여 리스트를 출력해줄 수 있는 프로그램을 구현한다.
	- 리스트 출력시 번호 오름차순 정렬 하여 출력할 수 있도록 한다.
	- 데이터베이스 연동하여 처리한다.
	  (TBL_SCORE, SCORESEQ 활용)
	- 즉, 성적 처리프로그램을 데이터베이스 연동하여 
	  JSP 로 구성할 수 있도록 한다.
	  
	  ---------------------------------------------------------------------------
	  성적처리
	  
	  이름(*)	[textbox] → 이름 입력 확인
	  국어점수 	[textbox] → 0 ~ 100 사이의 정수가 입력되었는지 확인 
	  영어점수 	[textbox] → 0 ~ 100 사이의 정수가 입력되었는지 확인 
	  수학점수 	[textbox] → 0 ~ 100 사이의 정수가 입력되었는지 확인 
	  
	  <성적 추가> → button
	  
	  번호 		이름 	국어점수 	영어점수 	수학점수 	총점 	평균
	  	1	   임하성	  90			80			70		 xxx	xx.x	
	  	2	   이윤수	  90			80			70		 xxx	xx.x	
	  ---------------------------------------------------------------------------
	  
	  ○ WebApp09_scott.sql
		 ScoreList.jsp
		 ScoreInsert.jsp
		 com.util.DBConn.java	  
	  
 -->

<div>
	<h1>성적처리</h1>
	<hr>
</div>

<div>
	<form action="ScoreInsert.jsp" method="post" onsubmit="return actionScore()">
		이름(*) 
		<input type="text" id = "name" name ="name">
		<span class ="error" id ="nameErr" >이름을 입력해주세요!</span>
		<br>
		국어점수
		<input type="text" id = "kor" name = "kor">
		<span class ="error" id= "korErr">1~100사이의 정수만 입력해주세요!</span>
		<br>
		영어점수
		<input type="text" id = "eng" name = "eng">
		<span class="error" id ="engErr">1~100사이의 정수만 입력해주세요!</span>
		<br>
		수학점수
		<input type="text" id = "mat" name ="mat">
		<span class="error" id = matErr>1~100사이의 정수만 입력해주세요!</span>
		<br><br>
		
		<button type="submit" class="btn control">성적 추가</button>
	</form>
</div>

<div>
	<!-- 테이블 자리 -->
	 <%=str %> 
</div>

</body>
</html>