<%@page import="com.test.MemberScoreDTO"%>
<%@page import="com.test.MemberScoreDAO"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%
	
	// 이전 페이지(memberSelect.jsp)로부터 넘어온 데이터 수신
	// → sid
	
	// 수신한 sid를 가지고 회원 데이터 조회
	// 조회해서 얻어낸 데이터를 폼에 구성
	
	String sid = request.getParameter("sid");
	String name = "";
	int kor = 0;
	int eng = 0;
	int mat = 0;
	
	MemberScoreDAO dao = new MemberScoreDAO();
		
	try
	{
		dao.connection();
		
		MemberScoreDTO score = dao.search(sid);
		name = score.getName();
		kor = score.getKor();
		eng = score.getEng();
		mat = score.getMat();		
		
	}
	catch (Exception e)
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
<title>MemberScoreUpdateForm.jsp</title>
<link rel="stylesheet" type="text/css" href="css/MemberDTO.css">
<style type="text/css">
	a {text-decoration: none;}
</style>
<script type="text/javascript">

	// 입력하기 버튼 클릭시 호풀되는 자바 스크립트 함수
	function memberScoreSubmit()
	{
		// 확인 
		//alert ("함수호출~~~");
		
		var memberScoreForm = document.getElementById("memberScoreForm");
		var uKor = document.getElementById("kor");
		var uEng = document.getElementById("eng");
		var uMat = document.getElementById("mat");
		
		var korMsg = document.getElementById("korMsg");
		var engMsg = document.getElementById("engMsg");
		var matMsg = document.getElementById("matMsg");
		
 	 	korMsg.style.display = "none";
		engMsg.style.display = "none";
		matMsg.style.display = "none"; 
	
		if(uKor.value=="" || isNaN(uKor.value)|| Number(uKor.value)< 0 || Number(uKor.value) > 100)
		{
			korMsg.style.display = "inline";
			uKor.focus();
			return;
		}	
		
		if(uEng.value=="" ||isNaN(uEng.value) ||Number(uEng.value)<0 || Number(uEng.value) > 100)
		{
			engMsg.style.display = "inline";
			uEng.focus();
			return;
		}	
		
		if(uMat.value==""||isNaN(uMat.value)||Number(uMat.value)<0 || Number(uMat.value) > 100)
		{
			matMsg.style.display = "inline";
			uMat.focus();
			return;
		}	

		memberScoreForm.submit();
		
	}
	
	function memberScoreReset()
	{
		// 확인 
		//alert("함호~");
		
		var memberScoreForm = document.getElementById("memberScoreForm");
		
		var kor = document.getElementById("kor");
		
		var korMsg = document.getElementById("korMsg");
		var engMSg = document.getElementById("engMsg");
		var matMsg = document.getElementById("matMsg");
		
 		korMsg.style.display ="none";
		engMsg.style.display ="none";
		matMsg.style.display ="none"; 
		
		memberScoreForm.reset();
		kor.focus();
		
	}

</script>
</head>
<body>

<div>
	<h1>회원 <span style="color: red;">성적</span> 관리 
	    및 <span style="color: blue;">수정</span> 페이지</h1>
	<hr>
</div>

<div>
	<a href = "MemberScoreSelect.jsp"><button type ="button">회원 성적 관리</button></a>
</div>
<br>

<div>
	<!-- 회원 데이터 수정 폼 구성 -->
							  <!-- ③ sid 넘기는 방법 -->
	<form action="MemberScoreUpdate.jsp?sid=<%=sid %>" method="post" id="memberScoreForm">
		<table class = "table">
			<tr>
				<th>번호</th>
				<td> <%=sid %> </td>
				<%-- ① sid 넘기는 방법  <input type ="text" name ="sid" value ="<%= %>" disabled="disabled"> --%>
			</tr>
			<tr>
				<th>이름</th>
				<td>
					<%=name %>
				</td>
			</tr>
			<tr>
				<th>국어점수</th>
				<td>
					<input type="text" id="kor" name="kor" value="<%=kor %>">
				</td>
				<td>
					<span id = "korMsg" class = "errMsg">1 ~ 100 사이의 정수를 입력해주세요!</span>
				</td>
			</tr>
			<tr>
				<th>영어점수</th>
				<td>
					<input type="text" id="eng" name="eng" value="<%=eng %>">
				</td>
				<td>
					<span id = "engMsg" class = "errMsg">1 ~ 100 사이의 정수를 입력해주세요!</span>
				</td>
			</tr>
			<tr>
				<th>수학점수</th>
				<td>
					<input type="text" id="mat" name="mat" value="<%=mat%>">
				</td>
				<td>
					<span id = "matMsg" class = "errMsg">1 ~ 100 사이의 정수를 입력해주세요!</span>
				</td>
			</tr>
		</table>
		
		<%-- ② sid 넘기는 방법 <input type="hidden" name ="sid" value="<%=sid%>"> --%>
		
		
		<br>
		
		<a href ="javascript:memberScoreSubmit()"><button type="button">수정하기</button></a>
		<a href ="javascript:memberScoreReset()"><button type="button">취소하기</button></a>
		<a href ="MemberScoreSelect.jsp"><button type="button">목록으로</button></a>
	</form>
</div>
	
</body>
</html>