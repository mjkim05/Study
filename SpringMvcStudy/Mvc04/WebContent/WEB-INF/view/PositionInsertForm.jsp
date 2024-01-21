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
<title>PositionInsertForm.jsp</title>
<link rel="stylesheet" type="text/css" href="css/main.css">
<script type="text/javascript" src="http://code.jquery.com/jquery.min.js"></script>
<script type="text/javascript">

	$(function()
	{
		$("#submitBtn").click(function()
		{
			if($("#positionName").val()=="")
			{
				$("#err").html("직위를 입력하세요");
				$("#err").css("display","inline");
				return;
			}	
			
			
			
			$("#positionForm").submit();
			
		});	
	});

</script>

</head>
<body>

<!--------------------------------- 
   #51. PositionInsertForm.jsp
       - 부서 데이터 입력 페이지
       - 관리자만 접근 허용
---------------------------------->


<!-- 메뉴 영역 -->
<div>
	<c:import url="EmployeeMenu.jsp"></c:import>
</div>

<!-- 콘텐츠 영역 -->
<div id=content>
	<h1>[ 직위 추가 ]</h1>
	<hr />
	
	<div>
		<form action="positioninsert.action" method="post" id="positionForm">
			<table>
				<tr>
					<th>이름</th>
					<td>
						<input type="text" id="positionName" name="positionName" placeholder="직위 이름"/>
					</td>
				</tr>
				<tr>
					<th>최소 기본급 </th>
					<td>
						<input type="text" id="minBasicPay" name="minBasicPay" placeholder="최소 기본급"/>
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<button type="button" class="btn" id="submitBtn"
						style="width: 40%; height: 50%;">직위 추가</button>
						<button type="button" class="btn" id="list"
						style="width: 40%; height: 50%;"
						onclick="location.href='positionlist.action'">직위 리스트</button>
						<br><br>
						
						<span id="err" style="color: red; display: none; font-weight: bold;"></span>
					</td>
				</tr>
			</table>
		</form>
	</div>
	
</div>

	<!-- 회사 소개 및 어플리케이션 소개 영역 -->
	<div id="footer">
	</div>


</body>
</html>