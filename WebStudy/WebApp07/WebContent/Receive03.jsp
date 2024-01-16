<%@ page contentType="text/html; charset=UTF-8"%>
<%
	String num1Str = request.getParameter("su1");
	String num2Str = request.getParameter("su2");
	String cal = request.getParameter("cal");
	
	int num1, num2;
	num1=num2=0;
	
	// 방법① 나머지 포함 다 정수형태로
	/* int result=0;
	try
	{
		num1=Integer.parseInt(num1Str);
		num2=Integer.parseInt(num2Str);
		
		switch(cal)
		{
			case "+": result=num1+num2;break;
			case "-": result=num1-num2;break;
			case "*": result=num1*num2;break;
			case "/": result=num1/num2;break;
		}
	}
	catch(Exception e)
	{
		System.out.println(e.toString());
	} */
	
	// 방법② 나누기는 실수형태로
	double result=0;
	try
	{
		num1=Integer.parseInt(num1Str);
		num2=Integer.parseInt(num2Str);
		
		switch(cal)
		{
			case "+": result=num1+num2;break;
			case "-": result=num1-num2;break;
			case "*": result=num1*num2;break;
			case "/": result=num1/(num2*1.0);break;
		}
	}
	catch(Exception e)
	{
		System.out.println(e.toString());
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Receive03.jsp</title>
<link rel="stylesheet" type="text/css" href="css/main.css">
</head>
<body>

<div>
	입력하신 <%=num1 %>와(과) <%=num2 %>의
	연산 결과는 <% if(cal.equals("/")) {out.print(result);} else out.print(String.format("%.0f",result));%> 입니다.
</div>

</body>
</html>