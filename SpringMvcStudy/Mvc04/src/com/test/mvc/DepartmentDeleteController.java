/* ====================================================
   #47. DepartmentDeleteController.java	
		- 사용자 정의 컨트롤러 클래스
		- 부서 데이터 삭제 액션 수행 → DAO 필요
		- 이후 deparmentlist.action 을 다시 요청 할 수 있도록 안내
		- DAO 객체에 대한 의존성 주입(DI)를 위한 준비
		  → 인터페이스 형태의 자료형을 속성으로 구성
		  → setter 메소드 준비
=======================================================*/

package com.test.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

//※ Spring 의 Controller 인터페이스를 구현하는 방법을 통해 
//사용자 정의 컨트롤러 클래스를 구상한다.
//cf. Controller Annotation 활용
public class DepartmentDeleteController implements Controller
{
	private IDepartmentDAO dao;
	
	public void setDao(IDepartmentDAO dao)
	{
		this.dao = dao;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		// 액션 코드

		ModelAndView mav = new ModelAndView();

		// 세션 설정 추가
		HttpSession session = request.getSession();
		
		if (session.getAttribute("admin")==null)
		{
			mav.setViewName("redirect:loginform.action");
			return mav;
		}
		
		try
		{
			String departmentId = request.getParameter("departmentId");
			
			dao.remove(departmentId);
			
			mav.setViewName("redirect:departmentlist.action");
			
		} catch (Exception e)
		{
			System.out.println(e.toString());
		}
		
		return mav;

	}
}
