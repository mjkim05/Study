/* ==================================================
 	GradeController.java
 	- mybatis 객체와 Annotation 을 활용한
 	  GradeDAO(데이터베이스) 액션 처리 Controller
 ====================================================*/

package com.test.mybatis;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class GradeController
{
	// 주요 속성 구성
	// mybatis 객체 의존성 (자동) 주입
	@Autowired
	private SqlSession sqlSession;
	
	// 성적 리스트 조회 메소드
	@RequestMapping(value = "/gradelist.action", method = RequestMethod.GET)
	public String gradeList(ModelMap model)
	{
		IGradeDAO dao = sqlSession.getMapper(IGradeDAO.class);
		
		model.addAttribute("gradeList",dao.list());
		
		return "/WEB-INF/view/GradeList.jsp";
	}
	
	// 성적 입력 폼 메소드
	@RequestMapping(value="/gradeinsertform.action", method = RequestMethod.GET)
	public String gradeInsertForm(ModelMap model ,String sid)
	{
		IGradeDAO dao = sqlSession.getMapper(IGradeDAO.class);
		
		model.addAttribute("list",dao.seachList(sid));
		
		return "/WEB-INF/view/GradeInsertForm.jsp";
	}
	
	// 성적 입력 메소드
	@RequestMapping(value = "/gradeinsert.action", method = RequestMethod.POST)
	public String gradeInsert(GradeDTO dto)
	{
		IGradeDAO dao = sqlSession.getMapper(IGradeDAO.class);
		
		dao.add(dto);
		
		return "redirect:gradelist.action";
	}
	
	// 성적 업데이트 폼 메소드
	@RequestMapping(value = "/gradeupdateform.action" , method = RequestMethod.GET)
	public String gradeUpdateForm(String sid ,ModelMap model)
	{
		IGradeDAO dao = sqlSession.getMapper(IGradeDAO.class);
		
		model.addAttribute("list", dao.seachList(sid));
		
		return "/WEB-INF/view/GradeUpdateForm.jsp";
	}
	
	// 성적 업데이트 메소드
	@RequestMapping(value = "/gradeupdate.action", method = RequestMethod.POST)
	public String gradeUpdate(GradeDTO dto)
	{
		IGradeDAO dao = sqlSession.getMapper(IGradeDAO.class);
		
		dao.modify(dto);
		
		return "redirect:gradelist.action";
	}

	// 성적 삭제 메소드
	@RequestMapping(value = "/gradedelete.action", method = RequestMethod.GET )
	public String gradeDelete(String sid)
	{
		IGradeDAO dao = sqlSession.getMapper(IGradeDAO.class);
		
		dao.remove(sid);
		
		return "redirect:gradelist.action";
		
	}
	
}
