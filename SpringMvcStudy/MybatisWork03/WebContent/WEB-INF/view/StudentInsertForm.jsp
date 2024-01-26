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
<title>StudentInsertForm.jsp</title>
<link rel="stylesheet" type="text/css" href="<%=cp %>/css/main.css">
<style type="text/css">

	*
	{
		font-family: 나눔고딕코딩;
		font-weight: bold;
	}

	.table
	{
		font-size: 15pt;
		text-align: center;
		width: 500px;
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

	//학생 정보 미기재시 학생 정보 입력이 불가능하도록 처리
	$(function()
	{
		$(".insert").click(function()
		{
			if($("#name").val()=="")
			{
				$(".err").html("이름을 입력해주세요");
				$(".err").css("display","inline");
				$("#name").focus();
				return;
			}
			
			if($("#tel").val()=="")
			{
				$(".err").html("번호를 입력해주세요");
				$(".err").css("display","inline");
				$("#tel").focus();
				return;
			}
			
			$(".submitForm").submit();
			
		});

	});


</script>
</head>
<body>

<!-- StudentInsertForm.jsp -->
<!--  View 페이지 (학생 데이터 입력 폼 구성) -->

<div>
	<h1 align="center">학생 입력</h1>
	<hr />
</div>

<div align="center">
	<form action="studentinsert.action" method="post" class="submitForm">
		<table class="table" border="1">
			<tr>
				<td>
				번호
				<input type="text" id="sid" name="sid" class="txt" value="${maxId }" readonly="readonly"/>
				</td>
			</tr>
			<tr>
				<td>
				이름
				<input type="text" id="name" name="name" class="txt" placeholder="이름을 입력해주세요"/>
				</td>
			</tr>
			<tr>
				<td>
				전화번호
				<input type="tel" id="tel" name="tel" class="txt" placeholder="전화번호를 입력해주세요"/>
				</td>
			</tr>
			<tr>
				<td colspan="2">
				<button type="button" class="btn insert">회원 추가</button>
				<button type="reset" class="btn">다시 입력</button>
				<button type="button" class="btn"
				onclick="location.href='studentlist.action'">회원 목록</button>
				<span class="err" style="color: red; display: none;"></span>
				</td>
			</tr>
		</table>
	</form>
</div>

</body>
</html>