<%@ page contentType="text/html; charset=UTF-8"
%><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"
%><%
	request.setCharacterEncoding("UTF-8");
	String cp = request.getContextPath();
	
	response.setContentType("text/xml");		// 잘 챙기기
	
%><?xml version="1.0" encoding="UTF-8"?>
<list>
	<c:forEach var="item" items="${lists}">
		<item>${item.word }</item>
		<!-- 
		<item>둘째 자식</item>
		<item>마지막 자식</item> 
		-->
	</c:forEach>
</list>
