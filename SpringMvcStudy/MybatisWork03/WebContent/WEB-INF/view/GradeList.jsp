<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	request.setCharacterEncoding("UTF-8");
	String cp = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>GradeList.jsp</title>
<link rel="stylesheet" type="text/css" href="<%=cp %>/css/main.css">
<style type="text/css">

	*
	{
		text-align: center;
		font-family: 나눔고딕코딩;
		font-weight: bold;
	}

	.table td 
	{
		font-size: 15pt;
		text-align: center;
	}
	
	.btn
	{
		font-size: 14pt;
	}
	
	.btn2
	{
		padding: 8px;
		width: 180px;
		margin-right:15px;
		font-size: 16pt;
		float: right;
	}
	
	h4
	{
		float: left;
	}

</style>

<script type="text/javascript" src="http://code.jquery.com/jquery.min.js"></script>
<script type="text/javascript">

	//성적 입력 버튼 클릭시 sid를 넘겨주며 입력 폼으로 이동 할 수 있게 처리
	$(function()
	{
		$(".insert").click(function()
		{
			$(location).attr("href","gradeinsertform.action?sid="+$(this).val());
		});
	});
	
	// 성적 수정버튼 클릭시 sid를 넘겨주며 업데이트 폼으로 이동 할 수 있게 처리
	$(function()
	{
		$(".update").click(function()
		{
			$(location).attr("href","gradeupdateform.action?sid="+$(this).val());
		});
	});

	// 성적 데이터를 실수로 삭제하지 않도록 처리
	$(function()
	{
		$(".delete").click(function()
		{
			if (confirm("현재 선택한 데이터를 정말 삭제하시겠습니까?"))
			{
				$(location).attr("href","gradedelete.action?sid=" + $(this).val());
			}
		});

	});
	
</script>

</head>
<body>

<!-- GradeList.jsp -->
<!-- View 페이지 (성적 리스트 출력 레이아웃 구성) -->


<div>
	<h1>성적 리스트 조회 📝💯 </h1>
	<hr />
</div>

<div>
	<h2>
		<button type="button" class="btn btn2" 
		onclick="location.href='studentlist.action'">학생리스트 조회</button>
		<br>
	</h2>
</div>

<div>
<!-- SID, NAME, SUB1,SUB2,SUB3,TOT,AVG,CH -->

	<table class="table">
		<tr>
			<th>번호</th>
			<th>이름</th>
			<th>과목1</th>
			<th>과목2</th>
			<th>과목3</th>
			<th>총점</th>
			<th>평균</th>
			<th>합격여부</th>
			<th>입력/수정/삭제</th>
		</tr>
		<c:forEach var="grade" items="${gradeList }">
			<tr>
				<td>${grade.sid }</td>
				<td>${grade.name }</td>
				<td>${grade.sub1 }</td>
				<td>${grade.sub2 }</td>
				<td>${grade.sub3 }</td>
				<td>${grade.tot }</td>
				<td>${grade.avg }</td>
				<td>${grade.ch }</td>
				<td colspan="3">
					<button type="button" class="btn insert" value="${grade.sid }"
					${grade.sub1 > -1 ? "disabled=\"disabled\"":"" }>성적 추가</button>
					<button type="button" class="btn update" value="${grade.sid }"
					${grade.sub1 < 0 ? "disabled=\"disabled\"":"" }>수정</button>
					<button type="button" class="btn delete" value="${grade.sid }"
					${grade.sub1 < 0 ? "disabled=\"disabled\"":"" }>삭제</button>
				</td>
			</tr>
		</c:forEach>
	</table>

</div>


</body>
</html>