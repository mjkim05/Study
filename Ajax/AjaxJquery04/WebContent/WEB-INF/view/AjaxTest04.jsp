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
<title>AjaxTest04.jsp</title>
<link rel="stylesheet" type="text/css" href="css/main.css">
<script type="text/javascript" src="http://code.jquery.com/jquery.min.js"></script>
<script type="text/javascript">

	$(function()
	{
		$("#sendButton").click(function()
		{
			var params = "title=" + $("#title").val()
						+ "&content=" + $("#content").val();
			
			$.ajax(
			{
				type:"POST"
				,url:"ajaxtest04ok.do"
				,data:params
				,dataType:"xml"
				,success:function(args)
				{
					var out = "";
					
					$(args).find("records").each(function()
					{
						var item = $(this);
						var id = item.attr("id");						// 속성값 접근
						var title = item.find("title").text();			// 태그 사이에 있는 텍스트 접근
						var content = item.find("content").text();
		
						out += "<br>>> id =  " + id;
						out += "<br>- title = " + title;
						out += "<br>- content = " + content + "<br>";
					});
					
					$("#resultDiv").html(out);
					$("#title").val("");
					$("#content").val("");
					$("#title").focus();
				}
				,beforeSend:check
				,error:function(e)
				{
					alert(e.responesText);
				}
						
						
			});
			
		});
	});
	
	function check()
	{
		if(!$.trim($("#title").val()))
		{
			alert("제목을 작성해주세요.");
			$("#title").focus();
			return false;
		}	
		
		if(!$.trim($("#content").val()))
		{
			alert("내용을 작성해주세요.");
			$("#content").focus();
			return false;
		}	
		
		return true;
	}
	
	
</script>
</head>
<body>

<div>
	<h1>jQuery의 ajax() 활용 실습</h1>
	<p>xml control</p>
	<hr />
</div>

<div>
	제목 <input type="text" id="title" class="txt" />
	<br><br>

	내용 <input type="text" id="content" class="txt" />
	<br><br>
	
	<input type="button" value="등록하기" id="sendButton" class="btn" />
</div>
<br>

<div id="resultDiv">
</div>
<!-- 
>> id=1
- title = 테스트
- content = 작성내용
>> id=2
- title = 테스트
- content = 작성내용
 -->


</body>
</html>