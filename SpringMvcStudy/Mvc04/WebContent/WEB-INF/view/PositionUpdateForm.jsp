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
<title>DepartmentUpdateForm.jsp</title>
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
  #54. PositionUpdateForm.jsp  
       - 직위 데이터 수정 페이지
       - 관리자만 접근 허용
---------------------------------->

<!-- 메뉴 부분 -->
<div>
	<c:import url="EmployeeMenu.jsp"></c:import>
</div>

<!-- 콘텐츠 부분 -->
<div>
	<h1>[ 직위 수정 ]</h1>
	<hr />
</div>

<div>
	<form action="positionupdate.action" method="post" id="positionForm">
		<table>
			<tr>
				<th>직위 번호</th>
				<td><input type="text" value="${positionId }" id="positionId" name="positionId" readonly="readonly"/></td>
			</tr>	
			<tr>
				<th>직위 이름</th>
				<td>
					<c:forEach var="position" items="${positionList }">
						<c:if test="${position.positionId == positionId}">
							<input type="text" id="positionName" name="positionName" value="${position.positionName }"/>
						</c:if>						
					</c:forEach>
				<td>
			</tr>		
			<tr>
				<th>최소 급여</th>
				<td>
					<c:forEach var="position" items="${positionList }">
						<c:if test="${position.positionId == positionId}">
							<input type="text" id="minBasicPay" name="minBasicPay" value="${position.minBasicPay }"/>
						</c:if>						
					</c:forEach>
				<td>
			</tr>		
			<tr>
				<td colspan="2">
					<button type="button" class="btn" id="submitBtn">수정하기</button>
					<button type="button" class="btn" id="list"
					onclick="location.href='positionlist.action'">직위 목록</button>
					<br><br>
					
					<span id="err" style="color: red; display: none; font-weight: bold;"></span>
				</td>
			</tr>
		</table>
	</form>
</div>


</body>
</html>