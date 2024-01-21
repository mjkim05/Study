<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
		// 삭제 버튼 클릭 시 액션 처리
		$(".deleteBtn").click(function()
		{

			//테스트 
			//alert("확인");
			//alert($(this).val());
			
			if (confirm("현재 선택한 데이터를 정말 삭제하시겠습니까?"))
			{
				// 테스트
				//alert("삭제 처리");
				$(location).attr("href","positiondelete.action?positionId="+$(this).val());
			}
			
		});

	});

</script>
</head>
<body>

<!------------------------------------------------------------
	#. PositionList.jsp
		 - 부서 리스트 출력 페이지
		 - 관리자가 접근하는 부서 데이터 출력 페이지
		   (일반 직원이 접근하는 부서 데이터 출력 페이지는 
		   depList.jsp 로 구성할 예정)
 -------------------------------------------------------------->
 
 <div>
 	<!-- 메뉴 영역-->
 	<c:import url="EmployeeMenu.jsp" ></c:import>
 </div>
 
 <div>
 	<!-- 콘텐츠 영역 -->
 	<h1>[직위 관리 (관리자 전용) ]</h1>
 	<hr/>
 	
 	<div>
 		<form>
 			<input type="button" value="직위 추가" class="btn"
 			onclick="location.href='positioninsertform.action'"/>
 		</form>
 	</div>
 	<br><br>
 	
 	<table id="customers" class="table">
 		<tr>
 			<th>번호</th>
 			<th>이름</th>
 			<th>최소급여</th>
 			<th>수정</th>
 			<th>삭제</th>
 		</tr>
		<!--  		
		<tr>
 			<td>1</td>
 			<td>사원</td>
 			<td>1000000</td>
 			<td><button type="button" class="btn">수정</button></td>
 			<td><button type="button" class="btn">삭제</button></td>
 		</tr> 
 		-->
 		
 		<c:forEach var="position" items="${positionList }">
 			<tr>
 				<td>${position.positionId }</td>
 				<td>${position.positionName }</td>
 				<td>
 					<fmt:formatNumber value="${position.minBasicPay }" 
 						groupingUsed="true"></fmt:formatNumber>
 					</td>
 					
 				<td><button type="button" class="btn"
 				onclick="location.href='positionupdateform.action?positionId='+${position.positionId }">수정</button></td>
				
				<c:choose>
					<c:when test="${position.delCheck!=0 }">
 					<td>
 					<button type="button" class="btn deleteBtn" disabled="disabled" >삭제</button>
 					</td>
					</c:when>
					<c:otherwise>
 					<td>
 					<button type="button" class="btn deleteBtn" value="${position.positionId }">삭제</button>
 					</td>
					</c:otherwise>
				</c:choose>
 			</tr>
 		</c:forEach>
 		
 	</table>
 	
 </div>



</body>
</html>