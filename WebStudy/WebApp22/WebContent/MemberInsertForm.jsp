<%@ page contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.test.MemberDTO"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	request.setCharacterEncoding("UTF-8");
	String cp = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MemberInsertForm.jsp</title>
<link rel="stylesheet" type="text/css" href="css/main.css">
</head>
<body>

<div>
	<h2>JSTL 코어(Core)를 활용한 회원 정보 입력</h2>
	<hr />
</div>

<div>
	<form action="MemberInsert.jsp" method="post">
		
		<!-- (이름, 전화번호, 주소) * 5명 분 -->
		<!-- → submit 액션 처리 -->
<%-- 		
		<c:forEach var ="a" begin="1" end="5" step="1">
			${a }번째 이름 
			<input type="text" name="name" id="name" class="txt"> <br>
			
			${a }번째 전화번호
			<input type="text" name="tel" id="tel" class="txt"> <br>
			
			${a }번째 주소
			<input type="text" name="addr" id="addr" class="txt"> <br>
			
			<c:set var = "nameArr" value="${name}" ></c:set>
			<c:set var = "telArr" value="${tel}"  ></c:set>
			<c:set var = "addrArr" value="${addr}" ></c:set>
			
			<br><br>
		
		</c:forEach>		
		<button type="submit" class="btn">정보 입력</button> --%>
		
		<table class="table">
			<tr>
			<th>이름</th>
				<td>
					<c:set var="i" value="1"></c:set>
					<c:forEach var="a" begin="1" end="5" step="1">
						<%-- <input type="text" name="name${a}" > --%>
						<input type="text" name="name${i }" >
						<c:set var="i" value="${i+1 }"></c:set>
					</c:forEach>
				</td>
			</tr>
			<tr>
			<th>전화번호</th>
				<td>
					<c:set var="i" value="1"></c:set>
					<c:forEach var="a" begin="1" end="5" step="1">
						<%-- <input type="text" name="tel${a}" > --%>
						<input type="text" name="tel${i }" >
						<c:set var="i" value="${i+1 }"></c:set>
					</c:forEach>
				</td>
			</tr>
			<tr>
			<th>주소</th>
				<td>
					<c:set var="i" value="1"></c:set>
					<c:forEach var="a" begin="1" end="5" step="1">
						<%-- <input type="text" name="addr${a}" > --%>
						<input type="text" name="addr${i }" >
						<c:set var="i" value="${i+1 }"></c:set>
					</c:forEach>
				</td>
			</tr>
			<tr>
				<td colspan="2">
				<button type="submit" class="btn" style="width: 100%;">입력</button>
				</td>
			</tr>
			
		</table>

	</form>
</div>

</body>
</html>