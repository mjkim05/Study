/* ======================================
   IGradeDAO.java
   -인터페이스
   -성적 데이터 액션 처리 메소드 선언
 ====================================== */

package com.test.mybatis;

import java.util.ArrayList;

public interface IGradeDAO
{
	public ArrayList<GradeDTO> list();			// 성적 리스트 조회 메소드 선언
	public int add(GradeDTO g);					// 성적 추가 메소드 선언
	public GradeDTO seachList(String sid);		// sid를 사용해 성적 정보 조회 메소드 선언
	public int modify(GradeDTO g);				// 성적 수정 메소드 선언 
	public int remove(String sid);				// 성적 삭제 메소드 선언

	
}
