<%@page import="com.test.MemberDTO"%>
<%@page import="com.test.MemberDAO"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%
	// MemberInsert.jsp
	// -- 데이터베이스의 테이블(TBL_MEMBER)에 
	//    회원 데이터 추가 액션 처리 수행 
	//    ... 이후.. 
	//    클라이언트가 다시 리스트 페이지(MemberSelect.jsp)를 
	//    요청할 수 있도록 안내
	
	request.setCharacterEncoding("UTF-8");			// 잘 챙기세요~!!
	
	String name = request.getParameter("uName");
	String tel = request.getParameter("uTel");
	
	MemberDAO dao = new MemberDAO();
	
	try
	{
		dao.connection();
	
		// MemberDAO 객체 생성 및 속성 구성 (→ add() 메소드 호출을 위해 필요)
		MemberDTO dto = new MemberDTO();
		dto.setName(name);
		dto.setTel(tel);
		
		// Insert 쿼리문을 수행하는 dao의 add() 메소드 호출
		dao.add(dto);
		
	}
	catch (Exception e)
	{
		System.out.print(e.toString());
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

	
	//check~~!!
	// 클라이언트가 MemberSelect.jsp 페이지를 다시 요청할 수 있도록 안내
	response.sendRedirect("MemberSelect.jsp");
	

%>