<%@ page contentType="text/html; charset=UTF-8"%>
<%

	String numStr1 = request.getParameter("su1");
	String numStr2 = request.getParameter("su2");
	int sum = 0;
	
	int num1 = Integer.parseInt(numStr1);
	int num2 = Integer.parseInt(numStr2);
	String str ="";
	sum = num1 * num2;
	
	str += "<tr>";
	
	for (int i = 1; i<=sum; i++)
	{
		str += "<td>";
		str += i;
		str += "</td>";
		//str += "</tr>";
		
		if (i%num1==0)
		{
			str += "</tr>";
			str += "<tr>";
		}
		
	}
	
	str += "</tr>";
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TableOk.jsp</title>
</head>
<body>

<div>
	<h1>JSP를 이용한 데이터 송수신 실습05</h1>
	<hr>
	<p>Table.jsp → TableOk.jsp</p>
</div>

<div>
	
	<table border ="1">
<!-- 	<tr>
		<td>1</td>
		<td>2</td>
		<td>3</td>
		<td>4</td>
		<td>5</td>
		</tr>
		
		<tr>
		<td>6</td>
		<td>7</td>
		<td>8</td>
		<td>9</td>
		<td>10</td>
		</tr>
		<tr>
		<td>11</td>
		<td>12</td>
		<td>13</td>
		<td>14</td>
		<td>15</td>
		</tr> -->
	<%= str %>
	
	</table>

</div>

</body>
</html>