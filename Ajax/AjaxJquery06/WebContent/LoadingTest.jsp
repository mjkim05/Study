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
<title>LoadingTest.jsp</title>
<link rel="stylesheet" type="text/css" href="css/main.css">
<script type="text/javascript" src="http://code.jquery.com/jquery.min.js"></script>
<script type="text/javascript">

	$(function()
	{
		$("#sendBtn").click(function()
		{
			//테스트
			//alert("확인~~!!");
			
			var params = "name=" + $.trim($("#name").val())
						+"&content=" + $.trim($("#content").val());
			
			$.ajax(
			{
				type:"post" 		// 대소문자 구별 Ⅹ				
				,url:"LoadingTest_Ok.jsp"
				,data:params
				,success:function(args)
				{
					$("#result").html(args);
					
					$("#name").val("");
					$("#content").val("");
					$("#name").focus();
					
				}
				,beforeSend:showRequest
				,error: function(e)
				{
					alert(e.responseText);
				}
				
			});
		});
		
		//check~~!!!
		
		//$(document).ajaxStart(기능,동작,행위).ajaxComplete(기능,동작,행위);
		$(document).ajaxStart(function()
		{
			// Ajax 요청이 시작 시...
			$("#loading").show();
			$("#result").hide();
			
		}).ajaxComplete(function()
		{
			// Ajax 요청이 종료(완료) 시...
			$("#loading").hide();
			$("#result").show();
			
		});
		
	});

	function showRequest()
	{
		var flag = true;
		
		if (!$.trim($("#name").val()))
		{
			alert("이름을 입력하세요");
			$("#name").focus;
			flag = false;
		}	
		
		if (!$.trim($("#content").val()))
		{
			alert("내용을 입력하세요");
			$("#content").focus;
			flag = false;
		}	
		
		return flag;
		
	}
	
	
</script>
</head>
<body>

<div>
	<h1>jQuery 의 ajax() 활용 실습</h1>
	<p>로딩 이미지 적용</p>
	<hr />
</div>

<div>
	이름<input type="text" id="name" class="txt" />
	<br><br>
	
	내용<input type="text" id="content" class="txt" />
	<br><br>
	
	<input type="button" value="등록하기" id="sendBtn" class="btn" />
</div>
<br><br>

<div id="loading" style="text-align: center; display: none;" >
	<img alt="loading" src="images/loading_01.gif" style="align-items: center;">
</div>

<div id="result">
</div>


</body>
</html>