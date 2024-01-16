<%@page import="java.sql.Statement"%>
<%@page import="com.util.DBConn"%>
<%@page import="java.sql.Connection"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%
	
	request.setCharacterEncoding("UTF-8");
	
	String name = request.getParameter("name");
	String kor = request.getParameter("kor");
	String eng = request.getParameter("eng");
	String mat = request.getParameter("mat");
	
	Connection conn = DBConn.getConnection();
	
	// 쿼리문 구성
	String sql = String.format("INSERT INTO TBL_SCORE(SID, NAME, KOR,ENG,MAT) VALUES(SCORESEQ.NEXTVAL, '%s',%s,%s,%s)",name,kor,eng,mat);
	
	// 작업 객체 생성
	Statement stmt = conn.createStatement();
	
	int result = 0;
	
	result = stmt.executeUpdate(sql);
	
	if (result < 1)
	{
		response.sendRedirect("Error.jsp");
	}	
	else 
	{
		response.sendRedirect("ScoreList.jsp");
	}
	
	
	
	
%>