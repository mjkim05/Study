<%@page import="com.test.MemberScoreDTO"%>
<%@page import="com.test.MemberScoreDAO"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%

	String sid = request.getParameter("sid");	
	String kor = request.getParameter("kor");
	String eng = request.getParameter("eng");
	String mat = request.getParameter("mat");
	
	MemberScoreDAO dao = new MemberScoreDAO();
	
	try
	{
		dao.connection();
		
		MemberScoreDTO dto = new MemberScoreDTO();
		
		dto.setSid(sid);
		dto.setKor(Integer.parseInt(kor));
		dto.setEng(Integer.parseInt(eng));
		dto.setMat(Integer.parseInt(mat));
		
		dao.modify(dto);
		
		// 위 메소드 호출 결과 반환값을 활용한 분기 처리 가능~~!!
		
	}
	catch (Exception e)
	{
		System.out.println(e.toString());
	}
	finally
	{
		try
		{
			dao.close();	
		}
		catch (Exception e)
		{
			System.out.println(e.toString());
		}	
	}

	response.sendRedirect("MemberScoreSelect.jsp");

%>
