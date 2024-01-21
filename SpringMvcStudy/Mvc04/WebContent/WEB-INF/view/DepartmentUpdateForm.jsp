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
			//alert("확인");
			
			if($("#departmentName").val()=="" || $("#departmentName").val()==null)
			{
				$("#err").html("부서 이름을 입력해주세요");
				$("#err").css("display","inline");
				
				return;
			}
		
			$("#departmentForm").submit();
			
		});
	});
	


</script>
</head>
<body>

<!--------------------------------- 
  #43. DepartmentUpdateForm.jsp
       - 부서 데이터 수정 페이지
       - 관리자만 접근 허용
---------------------------------->

<!-- 메뉴 부분 -->
<div>
	<c:import url="EmployeeMenu.jsp"></c:import>
</div>

<!-- 콘텐츠 부분 -->
<div>
	<h1>[ 부서 수정 ]</h1>
	<hr />
</div>

<div>
	<form action="departmentupdate.action" method="post" id="departmentForm">
		<table>
			<tr>
				<th>부서 번호</th>
				<td><input type="text" value="${departmentId }" id="departmentId" name="departmentId" readonly="readonly"/></td>
			</tr>	
			<tr>
				<th>부서 이름</th>
				<td>
					<c:forEach var="department" items="${departmentList }">
						<c:if test="${department.departmentId == departmentId}">
							<input type="text" value="${department.departmentName }" id="departmentName" name="departmentName" />
						</c:if>						
					</c:forEach>
				<td>
			</tr>		
			<tr>
				<td colspan="2">
					<button type="button" class="btn" id="submitBtn">수정하기</button>
					<button type="button" class="btn" id="list"
					onclick="location.href='departmentlist.action'">부서 목록</button>
				</td>
				
			</tr>
		</table>
	
	</form>
</div>


</body>
</html>