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
<title>DepartmentInsertForm.jsp</title>
<link rel="stylesheet" type="text/css" href="<%=cp %>/css/main.css">
<script type="text/javascript" src="http://code.jquery.com/jquery.min.js"></script>
<script type="text/javascript">

	$(function()
	{
		
		$("#submitBtn").click(function()
		{
			//alert("확인");
		
			// 부서 이름을 비워둘 경우
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
  #41. DepartmentInsertForm.jsp
       - 부서 데이터 입력 페이지
       - 관리자만 접근 허용
---------------------------------->

<!-- 메뉴 영역 -->
<div>
	<c:import url="EmployeeMenu.jsp"></c:import>
</div>

<!-- 콘텐츠 영역 -->
<div id=content>
	<h1>[ 부서 추가 ]</h1>
	<hr />
	
	<div>
		<form action="departmentinsert.action" method="post" id="departmentForm">
			<table>
				<tr>
					<th>이름</th>
					<td>
						<input type="text" id="departmentName" name="departmentName" placeholder="부서 이름"/>
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<button type="button" class="btn" id="submitBtn"
						style="width: 40%; height: 50%;">부서 추가</button>
						<button type="button" class="btn" id="list"
						style="width: 40%; height: 50%;"
						onclick="location.href='departmentlist.action'">부서 리스트</button>
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