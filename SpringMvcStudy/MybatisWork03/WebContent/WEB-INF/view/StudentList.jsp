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
<title>StudentList.jsp</title>
<link rel="stylesheet" type="text/css" href="<%=cp%>/css/main.css">
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
		width: 150px;
		margin-right:15px;
		font-size: 13pt;
		float: right;
	}
	
	h4
	{
		float: left;
	}
	
</style>
<script type="text/javascript"
	src="http://code.jquery.com/jquery.min.js"></script>
<script type="text/javascript">

	// 수정버튼 클릭시 sid를 넘겨주며 업데이트 폼으로 이동 할 수 있게 처리
	$(function()
	{
		$(".update").click(
			function()
			{
				$(location).attr("href",
							"studentupdateform.action?sid=" + $(this).val());
			});

	});

	// 학생 정보를 실수로 삭제하지 않도록 처리
	$(function()
	{
		$(".delete").click(function()
		{
			if (confirm("현재 선택한 데이터를 정말 삭제하시겠습니까?"))
			{
				$(location).attr("href","studentdelete.action?sid=" + $(this).val());
			}
		});

	});
	
</script>

<!-- StudentList.jsp -->
<!-- View 페이지 (학생 리스트 출력 레이아웃 구성) -->

</head>
<body>

	<div>
		<h1>학생 리스트 조회 👩‍🎓👨‍🎓 </h1>
		<hr />
	</div>

	<div>
		<h2>
			<button type="button" class="btn btn2"
				onclick="location.href='gradelist.action'">성적리스트 조회</button>
			<button type="button" class="btn btn2" name="insert"
			onclick="location.href='studentinsertform.action'">학생 추가</button>
			<h4>전체 인원 수 : ${count }</h4>
		</h2>
	</div>
	

	<div>
		<table class="table">
			<tr>
				<th>번호</th>
				<th>이름</th>
				<th>전화번호</th>
				<th>수정/삭제</th>
			</tr>
			<c:forEach var="student" items="${studentList }">
				<tr>
					<td>${student.sid }</td>
					<td>${student.name }</td>
					<td>${student.tel }</td>
					<td>
						<button type="button" class="btn update" value="${student.sid }">수정</button>
						<button type="button" class="btn delete" value="${student.sid }"
							${student.sub > 0 ? "disabled=\"disabled\"":"" }>삭제</button>
					</td>
				</tr>
			</c:forEach>
		</table>

	</div>

</body>
</html>