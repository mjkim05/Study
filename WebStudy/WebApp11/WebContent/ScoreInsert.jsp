
<%@page import="com.test.ScoreDTO"%>
<%@page import="com.test.ScoreDAO"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%

	
	request.setCharacterEncoding("UTF-8");

	String name = request.getParameter("userName");
	String kor = request.getParameter("kor");
	String eng = request.getParameter("eng");
	String mat = request.getParameter("mat");

	ScoreDAO dao = new ScoreDAO();
	ScoreDTO dto = new ScoreDTO();
	
	dto.setName(name);
	dto.setKor(Integer.parseInt(kor));
	dto.setEng(Integer.parseInt(eng));
	dto.setMat(Integer.parseInt(mat));
	
	dao.add(dto);
	
	response.sendRedirect("ScoreList.jsp");	
	
	dao.close();

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/main.css">
</head>
<body>

</body>
</html>