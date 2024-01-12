/* ===================================
	ReciveController.java
	- 사용자 정의 컨트롤러 클래스
=====================================*/

package com.test.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

//※ Spring 의 Controller 인터페이스를 구현하는 방법을 통해 
//사용자 정의 컨트롤러 클래스를 구상한다.
//cf. Controller Annotation 활용
public class ReciveController implements Controller
{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		// 액션 코드

		ModelAndView mav = new ModelAndView();

		request.setCharacterEncoding("UTF-8");

		String name = request.getParameter("userName");
		String msg = "안녕하세요, " + name + "님 반갑습니다.🎉🎊";
		mav.addObject("msg", msg);
		mav.setViewName("/WEB-INF/view/Receive.jsp");

		return mav;

	}

}
