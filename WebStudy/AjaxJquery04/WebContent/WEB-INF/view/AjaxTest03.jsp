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
<title>AjaxTest03.jsp</title>
<link rel="stylesheet" type="text/css" href="css/main.css">
<script type="text/javascript" src="http://code.jquery.com/jquery.min.js"></script>
<script type="text/javascript">

	$(function()
	{
		$("#sendButton").click(function()
		{
			var params = "su1=" + $.trim($("#su1").val())
					   + "&su2=" + $.trim($("#su2").val())
					   + "&op=" + $.trim($("#oper").val());
			
			$.ajax(
			{
				type:"POST"
				,url:"ajaxtest03ok.do"
				,data:params
				,success: function(args)
				{
					$("#result").html(args);
				}
				,beforeSend:showRequest
				//,beforeSend:function()			// 별다른 검증과정 없이 넘길려면 함수로 선언해서 진행해야함.
				//{									   beforeSend 에게 넘겨줘야하는 값이 함수기 때문이다.
				//	return true 	
				//}
				,error:function(e)
				{
					alert(e.responseText);
				}
			});
			
		});
		
	});
	
	function showRequest()
	{
		if ($("#su1").val()=="")
		{
			alert("첫번째 정수를 입력해주세요");
			$("#su1").focus();			
			return false;
		}
		
		if ($("#su2").val()=="")
		{
			alert("두번째 정수를 입력해주세요");
			$("#su2").focus();			
			return false;
		}
		
		return true;
	}


</script>
</head>
<body>

<div>
	<h1>jQuery 의 ajax() 활용 실습</h1>
	<hr />
</div>

<div>
	<input type="text" id="su1" class="txt txtNum"/>
	
	<select id="oper">
		<option value="add">덧셈</option>
		<option value="sub">뺄셈</option>
		<option value="mul">곱셈</option>
		<option value="div">나눗셈</option>
	</select>
	
	<input type="text" id="su2" class="txt txtNum"/>
	<input type="button" value=" = " id="sendButton" class="btn"/>	
</div>
<br>

<br><br>
<div id="result">
</div>

<br />
<br />

<div>
	<input type="radio" name="rdo"/>rdo1
	<input type="radio" name="rdo"/>rdo2
</div>

<div>
	<input type="checkbox" name="chk" />chk1
	<input type="checkbox" name="chk" />chk2
</div>

<div>
	<input type="text" />
</div>


</body>
</html>