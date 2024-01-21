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
<title>RegionList.jsp</title>
<link rel="stylesheet" type="text/css" href="<%=cp %>/css/main.css">
<script type="text/javascript" src="http://code.jquery.com/jquery.min.js"></script>
<script type="text/javascript">

	$(function()
	{
		$("#submitBtn").click(function()
		{
			if($("#regionName").val()=="")
			{
				$("#err").html("지역 이름을 입력해주세요");
				$("#err").css("display","inline");
				return;
			}	
			
			$("#submitForm").submit();
			
			
		});
	});


</script>
</head>
<body>

<!------------------------------------------------------------
	#61. RegionInsertForm.jsp
		 - 지역 입력 페이지
		 - 관리자만 접근할 수 있는 지역 데이터 입력 페이지
 -------------------------------------------------------------->
 
 <div>
 	<!-- 메뉴 영역-->
 	<c:import url="EmployeeMenu.jsp" ></c:import>
 </div>
 
 <div>
 	<!-- 콘텐츠 영역 -->
 	<h1>[지역 추가 (관리자 전용) ]</h1>
 	<hr/>
 	
	<div>
		<form action="regioninsert.action" method="post" id="submitForm">
			<table>
				<tr>
					<th>지역 이름</th>
					<td>
						<input type="text" name="regionName" id="regionName" placeholder="지역 이름 입력"/>
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<button type="button" id="submitBtn" class="btn">지역 추가</button>
						<button type="button" id="list" class="btn"
						onclick="location.href='regionlist.action'">지역 목록</button>
						<br><br>
					
						<span id="err" style="color: red; display: none; font-weight: bold;"></span>
					</td>
				</tr>
			</table>
		</form>
	</div>
	
	
 </div>



</body>
</html>