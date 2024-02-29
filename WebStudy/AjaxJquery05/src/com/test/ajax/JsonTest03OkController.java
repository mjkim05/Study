/*=======================
 	ServletSample.java
 ========================*/

package com.test.ajax;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JsonTest03OkController extends HttpServlet
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
		int su1 = Integer.parseInt(request.getParameter("su1"));
		int su2 = Integer.parseInt(request.getParameter("su2"));
		String op = request.getParameter("op");
		
		String view = "WEB-INF/view/JsonTest03_ok.jsp";
		
		/*
		 String result = "";
		
		if(op.equals("add"))
		{	
			result = String.format(" = %d",(su1+su2));
			op = " + ";
		}
		else if (op.equals("sub"))
		{
			result = String.format(" = %d",(su1-su2));
			op = " - ";
		}	
		else if (op.equals("mul"))
		{
			result = String.format(" = %d",(su1*su2));
			op = " * ";
		}	
		else if (op.equals("div"))
		{
			result = String.format(" = %.2f",((double)su1/su2));
			op =" / ";
		}	 
		 */
		
		request.setAttribute("su1", su1);
		request.setAttribute("su2", su2);
		request.setAttribute("op", op);
		//request.setAttribute("result", result);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);
		
	}
	
}
