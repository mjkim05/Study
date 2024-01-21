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
<title>RegionUpdateForm.jsp</title>
<link rel="stylesheet" type="text/css" href="css/main.css">
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
			
			$("#regionForm").submit();
			
		});
	});

</script>

</head>
<body>

<!--------------------------------- 
   #64. RegionUpdateForm.jsp   
       - 지역 데이터 수정 페이지
       - 관리자만 접근 허용
---------------------------------->


<!-- 메뉴 구성 -->
<div>
	<c:import url="EmployeeMenu.jsp"></c:import>
</div>

<!-- 콘텐츠 구성 -->
<div>
	<form action="regionupdate.action" method="post" id="regionForm">
		<table>
			<tr>
				<th>지역번호</th>
				<td>
					<input type="text" id="regionId" name="regionId" value="${regionId }" readonly="readonly">
				</td>
			</tr>
			<tr>
				<th>지역이름</th>
				<td>
					<c:forEach var="region" items="${regionList }">
						<c:if test="${region.regionId == regionId}">
							<input type="text" value="${region.regionName }" id="regionName" name="regionName" />
						</c:if>						
					</c:forEach>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<button type="button" class="btn" id="submitBtn">수정하기</button>
					<button type="button" class="btn" id="list"
					onclick="location.href='regionlist.action'">지역목록</button>
				</td>
			</tr>
		</table>
	</form>
</div>



</body>
</html>