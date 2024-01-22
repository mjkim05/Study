/*
 	MemberRecordController
  	- 사용자 정의 컨트롤러 클래스
  	
  	- 데이터베이스의 리스트를 읽어오는 액션 처리
  	- 『memberlist.action』 → 요청 → memberList() 처리
  	
  	- 데이터 입력(회원 등록)폼 요청 관련 액션 처리
  	- 『memberinsertform.action』 → 요청 → memberInsertForm() 처리
  	
  	- 데이터 입력(회원 등록) 액션 처리 
  	- 『memberinser.action』 →  요청 → memberInsert() 처리
 */

package com.test.mvc;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberRecordController
{
	// 데이터베이스의 리스트를 읽어오는 액션 처리
	@RequestMapping("/memberlist.action")
	public String memberList(Model model) throws SQLException, ClassNotFoundException
	{
		/*
		 * 내가 푼거
		ArrayList<MemberDTO> dto = new ArrayList<MemberDTO>();
	
		MemberDAO dao = new MemberDAO();
		dao.connection();
		dto = dao.lists();
		dao.close();
		
		model.addAttribute("dto",dto);
		result = "/WEB-INF/view/MemberList.jsp";
		
		return "/WEB-INF/view/MemberList.jsp";
		*/
		
		// 같이 푼거
		String result = "";
		ArrayList<MemberDTO> dto = new ArrayList<MemberDTO>();
		MemberDAO dao = new MemberDAO();
		
		try
		{
			dao.connection();
			dto = dao.lists();
			
		} catch (Exception e)
		{
			System.out.println(e.toString());
		}
		finally 
		{
			try
			{
				dao.close();
			
			} catch (Exception e2)
			{
				System.out.println(e2.toString());
			}
		}
		
		model.addAttribute("dto",dto);
		return result;
	}
	
	// 데이터 입력(회원 등록)폼 요청 관련 액션 처리
	@RequestMapping("/memberinsertform.action")
	public String memberInsertForm()
	{
		return "/WEB-INF/view/MemberInsertForm.jsp";
	}
	
	
	//데이터 입력(회원 등록) 액션 처리 
	// 폼에서 넘겨줄때 MemberDTO 클래스의 변수명과 폼 엘리먼트의 name이 같다면
	// 스프링 컨테이너가 알아서 짝꿍 맞춰서 잘 찾아준다^.^  
	// 따라서 매개변수로 MemberDTO member 로 받아도 문제 없음!
	// get방식도 가능!
	@RequestMapping("/memberinsert.action")
	public String memberInsert(MemberDTO member) throws SQLException, ClassNotFoundException
	{
		
		MemberDAO dao = new MemberDAO();
		dao.connection();
		int result = dao.insertQuery(member);
		//dao.insertQuery(member);		반환값이 있어도 안 받아도 됨!
		dao.close();
		
		return "redirect:memberlist.action";
	}

}
