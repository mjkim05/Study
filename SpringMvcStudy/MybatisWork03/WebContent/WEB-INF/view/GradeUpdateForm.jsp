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
<title>GradeUpdateForm.jsp</title>
<link rel="stylesheet" type="text/css" href="css/main.css">
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
	
	//성적 정보 미기재시 성적 정보 수정이 불가능하도록 처리
	$(function()
	{
		$(".update").click(function()
		{
			if($("#sub1").val()=="" || Number($("#sub1").val())>100)
			{
				$(".err").html("1부터 100사이의 점수를 입력해주세요");
				$(".err").css("display","inline");
				$("#sub1").focus();
				return;
			}
			if($("#sub2").val()==""|| Number($("#sub2").val())>100)
			{
				$(".err").html("1부터 100사이의 점수를 입력해주세요");
				$(".err").css("display","inline");
				$("#sub2").focus();
				return;
			}
			if($("#sub3").val()==""|| Number($("#sub3").val())>100)
			{
				$(".err").html("1부터 100사이의 점수를 입력해주세요");
				$(".err").css("display","inline");
				$("#sub3").focus();
				return;
			}
			
			$(".submitForm").submit();
			
		});

	});


</script>

</head>
<body>

<!-- GradeUpdateForm.jsp -->
<!--  View 페이지 (성적 수정 입력 폼 구성) -->

<div>
	<h1 align="center">성적 수정</h1>
	<hr />
</div>

<div align="center">
	<form action="gradeupdate.action" method="post" class="submitForm">
		<table class="table" border="1">
			<tr>
				<td>
				번호
				<input type="text" id="sid" name="sid" class="txt" value="${list.sid }" readonly="readonly"/>
				</td>
			</tr>
			<tr>
				<td>
				이름
				<input type="text" id="name" name="name" class="txt" value="${list.name}" readonly="readonly"/>
				</td>
			</tr>
			<tr>
				<td>
				과목 1
				<input type="text" id="sub1" name="sub1" class="txt" value="${list.sub1 }"/>
				</td>
			</tr>
			<tr>
				<td>
				과목 2
				<input type="text" id="sub2" name="sub2" class="txt" value="${list.sub2 }"/>
				</td>
			</tr>
			<tr>
				<td>
				과목 3
				<input type="text" id="sub3" name="sub3" class="txt" value="${list.sub3 }"/>
				</td>
			</tr>
			<tr>
				<td colspan="2">
				<button type="button" class="btn update">성적 수정</button>
				<button type="reset" class="btn">다시 입력</button>
				<button type="button" class="btn"
				onclick="location.href='gradelist.action'">성적 목록</button>
				<span class="err" style="color: red; display: none;"></span>
				</td>
			</tr>
		</table>
	</form>
</div>

</body>
</html>