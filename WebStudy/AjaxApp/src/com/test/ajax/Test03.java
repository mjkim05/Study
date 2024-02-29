/*=======================
 	Test03.java
 ========================*/

package com.test.ajax;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Test03 extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	// 사용자의 http 프로토콜 요청이 GET 방식일 경우 호출 되는 메소드
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doGetPost(request, response);
	}	
	// 사용자의 http 프로토콜 요청이 POST 방식일 경우 호출 되는 메소드
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doGetPost(request, response);
	}
	
	// 사용자 정의 메소드
	protected void doGetPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// GET 방식이든 POST 방식이든 
		// 어떤 방식의 요청에도 모두 처리 할 수 있는 사용자 정의 메소드

		// 이전페이지로부터 넘어온 데이터 수신
		String id = request.getParameter("id");

		// id 가 pbg 일 경우 
		// model → DB 액션 처리 요청 → DAO (처리요청)
		//								----------------
		//								DTO, Connection 활용
		// → SELECT COUNT(*) AS COUNT FROM MEMBER WHERE ID = 'pbg';
		//           -----------------						  -----
		//             수신 처리								넘겨주는 데이터
		//			 --==>> 1 or 0

		// ※ DB 구성을 별도로 하지 않았기 때문에 
		//    컬렉션 자료구조로 대신함~~!!

		//String result ="";
		/*
		 String[] test = {"superman","batman","admin"};

		 for (int i=0; i<test.length; i++)
		 {	 
			 for (String str : test)
				 userId.add(str);
		 }
		 */

		/*
		for (int i=0; i<3; i++)
		{
			if (userId.get(i).toString().equals(id))
			{
				result = "중복된 아이디로 사용이 불가능합니다.";
				break;			// check~~ 브레이크 잘 챙겨~~
			}
			else
				result = "사용가능한 아이디 입니다.";
		}
		 */
		List<String> userId = new ArrayList<String>();

		userId.add("superman");
		userId.add("admin");
		userId.add("batman");

		int result = 0;
		
		for (String item : userId)
		{
			if(item.equals(id))
				result = 1;
		}
		
		// 최종 result 에 1 이 남아있으면 이미 존재하는 id 		   → 사용불가
		// 1로 바뀌지 않고 0이 계속 남아있으면... 존재하지 않는 id → 사용가능
		request.setAttribute("result", result);

		RequestDispatcher dispatcher = request.getRequestDispatcher("Test03_ok.jsp");
		dispatcher.forward(request, response);

		
	}
	
}
