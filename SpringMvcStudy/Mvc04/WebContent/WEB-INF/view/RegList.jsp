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
	#68. Reglist.jsp
		 - 지역 리스트 출력 페이지
		 - 일반 회원이 접근하는 지역 데이터 출력 페이지
		   (관리자가 접근하는 지역 데이터 출력 페이지는 
		   RegionList.jsp 로 구성)
 -------------------------------------------------------------->
 
 <div>
 	<!-- 메뉴 영역-->
 	<c:import url="EmployeeMenu.jsp" ></c:import>
 </div>
 
 <div>
 	<!-- 콘텐츠 영역 -->
 	<h1>[지역 관리 ]</h1>
 	<hr/>

 	<table id="customers" class="table">
 		<tr>
 			<th>번호</th>
 			<th>이름</th>
 		</tr>
		<!--  		
		<tr>
 			<td>1</td>
 			<td>서울</td>
 		</tr> 
 		-->
 		
 		<c:forEach var="region" items="${regionList }">
 			<tr>
 				<td>${region.regionId }</td>
 				<td>${region.regionName }</td>
 			</tr>
 		</c:forEach>
 	</table>
 </div>

</body>
</html>