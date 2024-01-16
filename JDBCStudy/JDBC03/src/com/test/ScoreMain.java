/*=====================
 	ScoreMain.java
 =====================*/

/*
 ○ 성적 처리 프로그램 구현 → 데이터베이스 연동 → ScoreDAO, ScoreDTO 클래스 활용
 
  	여러명의 이름, 국어점수, 영어점수, 수학점수를 입력받아
  	총점, 평균을 연산하여 내용을 출력하는 프로그램을 구현한다.
  	
 실행 예)
 
 1번째 학생 성적 입력 (이름 국어 영어 수학) : 강혜성 80 75 60 
 2번째 학생 성적 입력 (이름 국어 영어 수학) : 김동민 100 90 80
 3번째 학생 성적 입력 (이름 국어 영어 수학) : 이주형 80 85 80 
 4번째 학생 성적 입력 (이름 국어 영어 수학) : .
 
 ---------------------------------------------------------------
 번호 	이름 	국어	영어	수학	총점	평균
 ---------------------------------------------------------------
  1		강혜성	 80		 75		 60     xxx 	xx.x
  2		김동민	 100	 90		 80     xxx 	xx.x
  3		이주형	 80		 85		 80     xxx 	xx.x
 ---------------------------------------------------------------

 */

package com.test;

import java.sql.SQLException;
import java.util.Scanner;

public class ScoreMain
{
	public static void main(String[] args) throws SQLException, ClassNotFoundException
	{
		ScoreDAO dao = new ScoreDAO();
		ScoreDTO dto = new ScoreDTO();
		
		int count = 0;
		count = dao.count();
		Scanner sc = new Scanner(System.in);
		
		do
		{		
			try
			{
				System.out.printf("%d번째 학생 성적 입력 (이름 국어 영어 수학) : ", ++count);
				String name = sc.next();
				if(name.equals("."))
					break;
				int kor = sc.nextInt();
				int eng = sc.nextInt();
				int mat = sc.nextInt();
				
				dto.setName(name);
				dto.setKor(kor);
				dto.setEng(eng);
				dto.setMat(mat);
				
				dao.add(dto);
				
			} catch (Exception e)
			{
				System.out.println(e.toString());
			}
			
		} while (true);
		
		System.out.println();
		System.out.println(" ---------------------------------------------------------------");
		System.out.println(" 번호 	이름 	국어	영어	수학	총점	평균");
		System.out.println(" ---------------------------------------------------------------");
		
		// 출력 근데 총정 평균을 곁들인
		for (ScoreDTO obj : dao.print())
		{
			int sum = obj.getKor() + obj.getEng() + obj.getMat();
			double avg = sum / 3.0;
					
			System.out.printf("%3s %7s %4d \t%d \t%d \t%d \t%5.1f\n",obj.getSid(), obj.getName(), obj.getKor(), obj.getEng(), obj.getMat() , sum, avg);
		}
		
		
		
		
		
		System.out.println(" ---------------------------------------------------------------");
		
	}
	
	
}

//실행결과
/*
1번째 학생 성적 입력 (이름 국어 영어 수학) : 노은하 100 90 100
2번째 학생 성적 입력 (이름 국어 영어 수학) : 김민지 50 50 40
3번째 학생 성적 입력 (이름 국어 영어 수학) : 이윤수 10 8 7
4번째 학생 성적 입력 (이름 국어 영어 수학) : . 

---------------------------------------------------------------
 번호 	이름 	국어	영어	수학	총점	평균
 ---------------------------------------------------------------
  1     노은하  100 	90 		100 	290 	 96.7
  2     김민지   50 	50 		40 		140 	 46.7
  3     이윤수   10 	8 		7 		25 	 	 8.3
 ---------------------------------------------------------------


 */


























