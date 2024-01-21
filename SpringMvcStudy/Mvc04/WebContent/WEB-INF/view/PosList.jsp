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
</head>
<body>

<!------------------------------------------------------------
	#58. PosList.jsp
		 - 부서 리스트 출력 페이지
		 - 일반 직원이 접근하는 부서 데이터 출력 페이지
		   (관리자가 접근하는 부서 데이터 출력 페이지는 
		    PositionList.jsp 로 구성할 예정)
 -------------------------------------------------------------->
 
 <div>
 	<!-- 메뉴 영역-->
 	<c:import url="EmployeeMenu.jsp" ></c:import>
 </div>
 
 <div>
 	<!-- 콘텐츠 영역 -->
 	<h1>[직위 목록 (일반 직원 전용) ]</h1>
 	<hr/>
 	
 	<br><br>
 	
 	<table id="customers" class="table">
 		<tr>
 			<th>번호</th>
 			<th>이름</th>
 		</tr>
		<!--  		
		<tr>
 			<td>1</td>
 			<td>사원</td>
 		</tr> 
 		-->
 		
 		<c:forEach var="position" items="${positionList }">
 			<tr>
 				<td>${position.positionId }</td>
 				<td>${position.positionName }</td>
 			</tr>
 		</c:forEach>
 		
 	</table>
 	
 </div>



</body>
</html>