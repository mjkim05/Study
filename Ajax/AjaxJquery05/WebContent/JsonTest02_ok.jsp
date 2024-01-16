<%@page import="java.util.ArrayList"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	request.setCharacterEncoding("UTF-8");
	String cp = request.getContextPath();
	
	String name = request.getParameter("name");
	String content = request.getParameter("content");
	
	StringBuffer str = new StringBuffer();
	
	// str.append("[");
	
	/* 
	for (int i=1; i<=5; i++)
	{
		
		if (i<=4)
		{	
			str.append("{\"num\": \"" + i + "\"");
			str.append(",\"name\":\"" + name + i + "\"");
			str.append(",\"content\":\""+content+i+"\"},");				// check~~!!! 『,』위치 잘 확인!!
		}
		else if(i==5)
		{
			str.append("{\"num\": \"" + i + "\"");
			str.append(",\"name\":\"" + name + i + "\"");
			str.append(",\"content\":\""+content+i+"\"}]");
		}	
	}
	*/
	for (int i=1; i<=5; i++)
	{
		str.append("{\"num\": \"" + i + "\"");
		str.append(",\"name\":\"" + name + i + "\"");
		str.append(",\"content\":\""+content+i+"\"},");				// check~~!!! 『,』위치 잘 확인!!
	}
	
	String result = str.toString();
	
	// 마지막 컴마 제거
	result = result.substring(0,result.length()-1);	//제일 마지막에 있는 컴마 제거됨!
	
	// JSON 배열 객체 구성
	result = "[" +result + "]";
	
	out.println(result);
	
	
	
	
	
%>
