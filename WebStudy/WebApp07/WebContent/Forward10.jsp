<%@ page contentType="text/html; charset=UTF-8"%>
<%
	
	// 이전 페이지(Send10.jsp)로부터 넘어온 데이터 수신
	// → num1, calResult, num2

	String num1Str = request.getParameter("num1");
	String num2Str = request.getParameter("num2");
	String calResult = request.getParameter("calResult");
	
	int num1 = 0;
	int num2 = 0;
	String result = "";
	
	try
	{
		num1 = Integer.parseInt(num1Str);
		num2 = Integer.parseInt(num2Str);
		
		if (calResult.equals("1"))
			result = String.format("%d + %d = %d", num1, num2, (num1+num2));
		else if (calResult.equals("2"))
			result = String.format("%d - %d = %d", num1, num2, (num1-num2));
		else if (calResult.equals("3"))
			result = String.format("%d * %d = %d", num1, num2, (num1 * num2));
		else if (calResult.equals("4"))
			result = String.format("%d / %d = %.1f", num1, num2, (num1/(double)num2));
	}
	catch (Exception e)
	{
		System.out.println(e.toString());
	}
	
	// 요청에 내용 추가
	request.setAttribute("resultStr", result);		// 파라미터 말고 어트리뷰트로 넣어야한다. 
													// 이때 들어가는 타입은 object 타입이다!!!
	
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Forward10.jsp</title>
<link rel="stylesheet" type="text/css" href="css/main.css">
</head>
<body>

<!-- JSP 액션 태그를 이용한 forward 처리 -->
<jsp:forward page="Receive10.jsp"></jsp:forward>


</body>
</html>