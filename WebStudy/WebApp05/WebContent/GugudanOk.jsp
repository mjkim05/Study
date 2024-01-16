<%@ page contentType="text/html; charset=UTF-8"%>
<%--  
<%
	
	// 스크립 릿 영역
	
	// 이전 페이지(Gugudan.jsp)로부터 데이터 수신 → dan

	String numStr = request.getParameter("dan");
	String str  ="";
	try
	{
		int num = Integer.parseInt(numStr);
		
		for (int i = 1; i<=9; i++)
		{
			
			int sum = 0;
			sum = num * i;
			str += num + " * " + i + " = " + sum + "\n";
			// out.print( num + " * " + i + " = " + sum + "<br>");
		}	
		
	}
	catch (Exception e)
	{
		System.out.println(e.toString());
		getServletContext().log("오류발생!! : " + e.toString());
	}

%>
--%>
<%

	String numStr = request.getParameter("dan");
	String str  ="";
	int n=0;
	try
	{
		 n = Integer.parseInt(numStr);
		
		
	}
	catch (Exception e)
	{
		System.out.println(e.toString());
		getServletContext().log("오류발생!! : " + e.toString());
	}

%>

<style>

	textarea 
	{
		font-size: 17pt;
		font-family: 나눔고딕코딩;
		font-weight: bold;
	}

</style>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>GugudanOk.jsp</title>
</head>
<body>

<div>
	<h1>JSP를 이용한 데이터 송수신 실습 02</h1>
	<hr>	
	<p>Gugudan.jsp → GugudanOk.jsp</p>
</div>


<div>
	<h2>결과 </h2>
	<h2>[<%= numStr%>단]<h2>
	<textarea rows="10" cols="15" ><%=str %></textarea>
</div>

<%for (int i=1; i<=9; i++)
  {%>
	<%=n %> * <%=i %> = <%=(n*i) %> <br>
<%}%>


</body>
</html>