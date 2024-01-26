/* ======================================
   IStudentDAO.java
   -인터페이스
   -학생 데이터 액션 처리 메소드 선언
 ====================================== */

package com.test.mybatis;

import java.util.ArrayList;

public interface IStudentDAO
{
	public ArrayList<StudentDTO> list();			// 학생 조회 메소드 선언
	public int add(StudentDTO s);					// 학생 추가 메소드 선언
	public int count();								// 학생 인원수 조회 메소드 선언
	public int maxId();								// 학생 MaxId 조회 메소드 선언
	public int modify(StudentDTO dto);				// 학생 수정 메소드 선언
	public int remove(String sid);					// 학생 삭제 메소드 선언
	public StudentDTO seachList(String sid);		// sid를 사용해 학생 정보 조회 메소드 선언
}
