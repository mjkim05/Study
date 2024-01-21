/* ====================================================
   #30. EmployeeUpdateFormController.java
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

//※ Spring 의 Controller 인터페이스를 구현하는 방법을 통해 
//사용자 정의 컨트롤러 클래스를 구상한다.
//cf. Controller Annotation 활용
public class EmployeeUpdateFormController implements Controller
{
	// check~!!
	// EmployeeInsertFormController 구성과는 다른 방식으로 처리~~!!
	// ----------------------------
	// → 필요한 모든 메소드를 EmployeeDAO 에 정의해 두었던 상태 
	
	// 주요 속성 구성
	private IEmployeeDAO employeeDAO;
	private IRegionDAO regionDAO;
	private IDepartmentDAO departmentDAO;
	private IPositionDAO positionDAO;

	// setter 구성
	public void setEmployeeDAO(IEmployeeDAO employeeDAO)
	{
		this.employeeDAO = employeeDAO;
	}
	public void setRegionDAO(IRegionDAO regionDAO)
	{
		this.regionDAO = regionDAO;
	}
	public void setDepartmentDAO(IDepartmentDAO departmentDAO)
	{
		this.departmentDAO = departmentDAO;
	}
	public void setPositionDAO(IPositionDAO positionDAO)
	{
		this.positionDAO = positionDAO;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		// 액션 코드

		ModelAndView mav = new ModelAndView();

		// 세션 처리과정 추가 ----------------------------------------------------------
		HttpSession session = request.getSession();
		
		if (session.getAttribute("admin")==null)
		{
			mav.setViewName("redirect:loginform.action");
			return mav;
		}	
		// ---------------------------------------------------------- 세션 처리과정 추가
		
		ArrayList<Position>positionList = new ArrayList<Position>();
		ArrayList<Department>departmentList = new ArrayList<Department>();
		ArrayList<Region>regionList = new ArrayList<Region>();
		
		try
		{
			// 이전 페이지로(EmployeeList.jsp)로 부터 넘어온 데이터 수신
			// -- employeeId
			String employeeId = request.getParameter("employeeId");
			Employee employee = new Employee();
			employee = employeeDAO.searchId(employeeId);
			
			positionList = positionDAO.list();
			departmentList = departmentDAO.list();
			regionList = regionDAO.list();
			
			mav.addObject("employee",employee);
			mav.addObject("positionList",positionList);
			mav.addObject("departmentList",departmentList);
			mav.addObject("regionList",regionList);
			
			mav.setViewName("/WEB-INF/view/EmployeeUpdateForm.jsp");
			
		} catch (Exception e)
		{
			System.out.println(e.toString());
		}
		
		
		
		return mav;

	}
}
