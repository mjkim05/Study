<%@page import="com.test.BoardDAO"%>
<%@page import="com.util.DBConn"%>
<%@page import="java.sql.Connection"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String cp = request.getContextPath();
%>
<jsp:useBean id="dto" class="com.test.BoardDTO"></jsp:useBean>
<jsp:setProperty property="pwd" name="dto"/>
<jsp:setProperty property="num" name="dto"/>
<%
	// Delete_ok.jsp
	/* String pwdSource = request.getParameter("pwdSource");
	String pageNum	= request.getParameter("pageNum");	
	String error = "";

	if (pwdSource.equals(dto.getPwd()))
	{
		
		Connection conn = DBConn.getConnection();
		BoardDAO dao = new BoardDAO(conn);
		
		int result = dao.deleteDate(dto.getNum());
					
		response.sendRedirect(cp+"/List.jsp?pageNum="+pageNum);
		
		DBConn.close();
	}
	else
	{	error = "-1";
		session.setAttribute("error", error);
		response.sendRedirect(cp+"/Article.jsp?pageNum="+pageNum+"&num="+dto.getNum());
		
	} */

	int num = Integer.parseInt(request.getParameter("num"));
	String pageNum = request.getParameter("pageNum");
	
	Connection conn = DBConn.getConnection();
	BoardDAO dao = new BoardDAO(conn);
	
	int result = dao.deleteDate(num);
	
	DBConn.close();
	
	response.sendRedirect(cp+"/List.jsp?pageNum="+pageNum);
	
	
%>
