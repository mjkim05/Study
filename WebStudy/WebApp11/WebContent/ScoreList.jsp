<%@page import="com.util.DBConn"%>
<%@page import="com.test.ScoreDTO"%>
<%@page import="com.test.ScoreDAO"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%

	StringBuffer str = new StringBuffer();
	ScoreDAO dao = null;
	
	String count = "<p>전체 인원 : "; 
	
	try
	{
		dao = new ScoreDAO();
		
		count += dao.count() + "명</p>"; 
		
		str.append("<table border = '2' >");
		str.append("<tr>");
		str.append("<th>번호</th>");
		str.append("<th>이름</th>");
		str.append("<th>국어 점수</th>");
		str.append("<th>영어 점수</th>");
		str.append("<th>수학 점수</th>");
		str.append("<th>총점</th>");
		str.append("<th>평균</th>");
		str.append("</tr>");
		
		for (ScoreDTO dto : dao.lists())
		{
			str.append("<tr>");
			str.append("<td>" +dto.getSid() + "</td>");
			str.append("<td>" +dto.getName()+ "</td>");
			str.append("<td>" +dto.getKor()+ "</td>");
			str.append("<td>" +dto.getEng()+ "</td>");
			str.append("<td>" +dto.getMat()+ "</td>");
			str.append("<td>" +dto.getTot()+ "</td>");
			str.append("<td>" +dto.getAvg()+ "</td>");
			str.append("</tr>");
		}	
	}
	catch (Exception  e)
	{
		System.out.println(e.toString());
	}
	finally
	{
		
		try
		{
			dao.close();
		}
		catch (Exception e)
		{
			System.out.println(e.toString());
		}
	}



%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/main.css">
<style type="text/css">
	
	.error {color : red; display: none;}

</style>

<script type="text/javascript">
	
	function formCheck()
	{
		var name = document.getElementById("userName");
		var nameMsg = document.getElementById("nameMsg");
		
		var kor = document.getElementById("kor");
		var korMsg = document.getElementById("korMsg");
		
		var eng = document.getElementById("eng");
		var engMsg = document.getElementById("engMsg");
		
		var mat = document.getElementById("mat");
		var matMsg = document.getElementById("matMsg");
		
		nameMsg.style.display = "none";
		if (name.value == "")
		{
			nameMsg.style.display = "inline";
			return false;
		}
		korMsg.style.display = "none";
		if (kor.value=="" || parseInt(kor.value) > 100 || parseInt(kor.value) < 0)
		{
			korMsg.style.display = "inline";
			return false;
		} 
		engMsg.style.display = "none";
		if (eng.value=="" || parseInt(eng.value) > 100 || parseInt(eng.value) < 0)
		{
			engMsg.style.display = "inline";
			return false;
		} 
		matMsg.style.display = "none";
		if (mat.value=="" || parseInt(mat.value) > 100 || parseInt(mat.value) < 0)
		{
			matMsg.style.display = "inline";
			return false;
		} 
		
		return true;
		
	}

</script>


</head>
<body>

<div>
	<h1>성적 처리 구성</h1>
	<hr>
</div>

<div>
	<form action="ScoreInsert.jsp" method="post" onsubmit="return formCheck()">
		<tr>
			<th>이름(*)</th>
			<input type="text" id = "userName" name = "userName" class="txt">
			<span id= "nameMsg" class = "error" >이름을 작성해주세요!</span>
		</tr>
		<br>
		<tr>
			<th>국어 점수</th>
			<input type="text" id = "kor" name ="kor" class ="txt">
			<span id = "korMsg" class="error">1~100사이의 정수를 입력해주세요</span>
		</tr>
		<br>
		<tr>
			<th>영어 점수</th>
			<input type="text" id= "eng" name = "eng" class= "txt">
			<span id = "engMsg" class ="error">1~100사이의 정수를 입력해주세요</span>
		</tr>
		<br>
		<tr>
			<th>수학 점수</th>
			<input type="text" id= "mat" name = "mat" class= "txt">
			<span id = "matMsg" class ="error">1~100사이의 정수를 입력해주세요</span>
		</tr>
		<br>
		<button type="submit" id = "btn" class = "btn control">성적 추가!</button>
	</form>
</div>

<!-- <div>
	전체 인원 구하기
	<p>전체 인원 : 5명</p>
	데이터 출력
	<table border = "2" >
		<tr>
			<th>번호</th>
			<th>이름</th>
			<th>국어 점수</th>
			<th>수학 점수</th>
			<th>영어 점수</th>
			<th>총점</th>
			<th>평균</th>
		</tr>
		<tr>
			<td>3</td>
			<td>김민지</td>
			<td>100</td>
			<td>100</td>
			<td>100</td>
			<td>300</td>
			<td>100</td>
		</tr>
	</table>
</div>
 -->
 
 <div>
	<%=count %>
 	<%=str %>
 </div>
 
</body>
</html>