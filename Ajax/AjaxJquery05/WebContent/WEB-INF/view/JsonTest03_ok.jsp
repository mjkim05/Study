<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	request.setCharacterEncoding("UTF-8");
	String cp = request.getContextPath();
	
	// JsonTest03_ok.jsp
	
	//String su1 = request.getParameter("su1");
	//String su2 = request.getParameter("su1");
	int su1 = (int)request.getAttribute("su1");
	int su2 = (int)request.getAttribute("su2");
	String op = (String)request.getAttribute("op");
	
	String result = "";
	
	if(op.equals("add"))
	{	
		result = String.format(" = %d",(su1+su2));
		op = " + ";
	}
	else if (op.equals("sub"))
	{
		result = String.format(" = %d",(su1-su2));
		op = " - ";
	}	
	else if (op.equals("mul"))
	{
		result = String.format(" = %d",(su1*su2));
		op = " * ";
	}	
	else if (op.equals("div"))
	{
		result = String.format(" = %.2f",((double)su1/su2));
		op =" / ";
	}	
		
	StringBuffer sb = new StringBuffer();
	
	sb.append("{\"su1\":\""+su1+"\"");
	sb.append(",\"su2\":\""+su2+"\"");
	sb.append(",\"op\":\""+op+"\"");
	sb.append(",\"result\":\""+result+"\"}");
	
	String jsonResult = sb.toString();
	
	out.println(jsonResult);
	
%>
