/* ===============================================
 	StudentController.java
 	- mybatis 객체 활용한 Annotation 을 활용한
 	  Student(데이터베이스) 액션 처리 Controller
 =================================================*/

package com.test.mybatis;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class StudentController
{
	// 주요 속성 구성
	// mybatis 객체 의존성 (자동) 주입
	@Autowired
	private SqlSession sqlSession;
	
	// 학생 리스트 조회 메소드
	@RequestMapping(value = "/studentlist.action", method = RequestMethod.GET)
	public String studentList(ModelMap model)
	{
		IStudentDAO dao = sqlSession.getMapper(IStudentDAO.class);
	
		model.addAttribute("studentList",dao.list());
		model.addAttribute("count", dao.count());
				
		return "/WEB-INF/view/StudentList.jsp";		
				
	}
	
	// 학생 입력 폼 메소드
	@RequestMapping(value = "/studentinsertform.action")
	public String studentInsertForm(ModelMap model)
	{
		IStudentDAO dao = sqlSession.getMapper(IStudentDAO.class);
		
		model.addAttribute("maxId", dao.maxId());
		
		return "/WEB-INF/view/StudentInsertForm.jsp";
	}
	
	
	// 학생 입력 메소드
	@RequestMapping(value="/studentinsert.action", method = RequestMethod.POST)
	public String studentInsert(StudentDTO studnet)
	{
		IStudentDAO dao = sqlSession.getMapper(IStudentDAO.class);
		
		dao.add(studnet);
		
		return "redirect:studentlist.action";
	}
	
	// 학생 업데이트 폼 메소드
	@RequestMapping(value="/studentupdateform.action", method = RequestMethod.GET)
	public String studentUpdateForm(String sid, ModelMap model)
	{
		IStudentDAO dao = sqlSession.getMapper(IStudentDAO.class);
		
		model.addAttribute("list",dao.seachList(sid));
		
		return "/WEB-INF/view/StudentUpdateForm.jsp";
	}
	
	// 학생 업데이트 메소드
	@RequestMapping(value = "/studentupdate.action", method = RequestMethod.POST)
	public String studentUpdate(StudentDTO dto)
	{
		IStudentDAO dao = sqlSession.getMapper(IStudentDAO.class);
			
		dao.modify(dto);
		
		return "redirect:studentlist.action";
	}
	
	// 학생 삭제 메소드
	@RequestMapping(value = "/studentdelete.action", method = RequestMethod.GET)
	public String studentDelete(String sid)
	{
		IStudentDAO dao = sqlSession.getMapper(IStudentDAO.class);
		
		dao.remove(sid);
		
		return "redirect:studentlist.action";
	}
	
}
