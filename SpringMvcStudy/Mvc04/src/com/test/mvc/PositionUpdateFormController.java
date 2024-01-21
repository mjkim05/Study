/* ====================================================
   #55. PositionUpdateFormController.java
		- 사용자 정의 컨트롤러 클래스
		- 직원 데이터 수정 폼 요청에 대한 액션 처리
		- DAO 객체에 대한 의존성 주입(DI)를 위한 준비
		  → 인터페이스 형태의 자료형을 속성으로 구성
		  → setter 메소드 준비
=======================================================*/
package com.test.mvc;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import oracle.net.aso.p;

//※ Spring 의 Controller 인터페이스를 구현하는 방법을 통해 
//사용자 정의 컨트롤러 클래스를 구상한다.
//cf. Controller Annotation 활용
public class PositionUpdateFormController implements Controller
{
	private IPositionDAO dao;
	
	public void setDao(IPositionDAO dao)
	{
		this.dao = dao;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		// 액션 코드

		ModelAndView mav = new ModelAndView();

		HttpSession session = request.getSession();
		
		if(session.getAttribute("admin")==null)
		{
			mav.setViewName("redirect:loginform.action");
			return mav;
		}
		
		try
		{
			String positionId = request.getParameter("positionId");
			
			ArrayList<Position> positionsList = new ArrayList<Position>();
			
			positionsList = dao.list();
			
			mav.addObject("positionId",positionId);
			mav.addObject("positionList",positionsList);
			mav.setViewName("/WEB-INF/view/PositionUpdateForm.jsp");
			
		} catch (Exception e)
		{
			System.out.println(e.toString());
		}
		
		return mav;

	}
}
