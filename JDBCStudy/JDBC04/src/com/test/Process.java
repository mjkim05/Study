/* ================
 	Process.java
 =============== */

/*
1. 성적 입력
2. 성적 전체 출력
3. 이름 검색 출력
4. 성적 수정
5. 성적 삭제
 */


package com.test;

import java.util.ArrayList;
import java.util.Scanner;

public class Process
{
	
	// 주요 속성 구성 → 데이터베이스 액션 처리 전담 객체 → ScoreDAO
	private ScoreDAO dao; 
	
	// 생성자 정의 (사용자 정의 생성자)
	public Process()
	{
		dao = new ScoreDAO();
	}
	
	// 성적 입력 기능
	public void sungjukInsert()
	{
		try
		{
			// 데이터 베이스 연결
			dao.connection();
			
			// 레코드 수 확인
			int count = dao.count();
			
			Scanner sc = new Scanner(System.in);
			
			// 반복문 구성
			do
			{
				System.out.println();
				System.out.printf("%d번째 학생 성적 입력(이름 국어 영어 수학) : ", ++count);
				String name = sc.next();
				
				if (name.equals("."))
					break;
				
				int kor = sc.nextInt();
				int eng = sc.nextInt();
				int mat = sc.nextInt();
				
				// 입력값을 활용하여 ScoreDTO 객체 구성
				ScoreDTO dto = new ScoreDTO();
				dto.setName(name);
				dto.setKor(kor);
				dto.setEng(eng);
				dto.setMat(mat);
			
				//dao의 add() 메소드 호출
				int result = dao.add(dto);
				
				if (result > 0)
				{
					System.out.println("성적 입력이 완료되었습니다.");
				}
				
			} while (true);
			
			// 데이터베이스 연결 종료
			dao.Close();
			
		} catch (Exception e)
		{
			System.out.println(e.toString());
		}
		
	}
	
	// 성적 전체 출력 기능
	public void sungjukSelectAll()
	{
		try
		{
			// dao 의 connection() 메소드 호출 → 데이터베이스 연결
			dao.connection();
			
			// dao 의 count() 메소드 호출 → 인원수 확인
			int count = dao.count();
			
			System.out.println();
			System.out.printf("전체 인원 : %d 명\n", count);
			System.out.println("번호   이름   국어    영어   수학    총점     평균    석차");
			
			for (ScoreDTO dto : dao.lists())
			{
				System.out.printf("%3s %5s %5d %7d %6d %7d %8.1f %5d \n"
								 ,dto.getSid() , dto.getName() 
								 ,dto.getKor() , dto.getEng(), dto.getMat()
								 ,dto.getTot() , dto.getAvg(), dto.getRank());
			}
			
			// dao 의 close() 메소드 호출 → 데이터베이스 연결 종료
			dao.Close();
			
		} catch (Exception e)
		{
			System.out.println(e.toString());
		}	
		
	}

	// 이름 검색 출력 기능
	public void sungjukSearchName()
	{
		try
		{
			// 검색할 이름 입력
			Scanner sc = new Scanner(System.in);
			System.out.print("검색할 이름 입력 : ");
			String name = sc.next();
			
			//-- 필요한 경우 이 과정에서 입력한 이름에 대한 유효성 검사 수행 가능
			
			// 데이터베이스 연결
			dao.connection();
			
			// dao.lists() 메소드 호출 → 매개변수로 검색할 이름을 문자열 형태로 넘겨주기
			ArrayList<ScoreDTO> arrayList = dao.lists(name);
			
			if (arrayList.size() > 0)
			{
				// 수신된 내용 출력
				System.out.println("번호   이름   국어    영어   수학    총점     평균    석차");
				
				for (ScoreDTO dto : arrayList)
				{
					System.out.printf("%3s %5s %5d %7d %6d %7d %8.1f %5d\n"
							 ,dto.getSid() , dto.getName() 
							 ,dto.getKor() , dto.getEng(), dto.getMat()
							 ,dto.getTot() , dto.getAvg(), dto.getRank());
				}
				
				
			} else
			{
				// 수신된 내용이 없다는 상황을 사용자에게 안내
				System.out.println("검색 결과가 존재하지 않습니다.");
			}
			
			//데이터베이스 연결 종료
			dao.Close();
			
		} catch (Exception e)
		{
			System.out.println(e.toString());
		}
		
		
	}
	
	// 성적 수정 기능
	public void sungjukUpdate()
	{
		try
		{
			// 수정할 대상의 번호 입력 받기
			Scanner sc = new Scanner(System.in);
			System.out.print("수정할 번호를 입력하세요 : ");
			int sid = sc.nextInt();
			
			//-- 입력받은 번호로 체크해야 할 로직 적용 삽입 가능
			
			// 데이터 베이스 연결 
			dao.connection();
			
			// 수정할 대상 수신 → 데이터 수정을 위한 대상 검색
			ArrayList<ScoreDTO> arrayList =  dao.lists(sid);
			
			if (arrayList.size() > 0)
			{
				// 수신된 내용 출력
				System.out.println("번호   이름   국어    영어   수학    총점     평균    석차");

				for (ScoreDTO dto : arrayList)
				{
					System.out.printf("%3s %5s %5d %7d %6d %7d %8.1f %5d\n"
							,dto.getSid() , dto.getName() 
							,dto.getKor() , dto.getEng(), dto.getMat()
							,dto.getTot() , dto.getAvg(), dto.getRank());
				}
				
				System.out.println();
				System.out.print("수정 데이터 입력(이름 국어 영어 수학) : ");
				String name = sc.next();
				int kor = sc.nextInt();
				int eng = sc.nextInt();
				int mat = sc.nextInt();
				
				// dto 구성
				ScoreDTO dto = new ScoreDTO();
				dto.setName(name);
				dto.setKor(kor);
				dto.setEng(eng);
				dto.setMat(mat);
				dto.setSid(String.valueOf(sid));		// check~~!!!
				
				// 구성된 dto 를 넘겨주며 dao 의 modify() 메소드 호출
				int result = dao.modify(dto);
				if (result > 0)
					System.out.println("수정이 완료되었습니다.");
			}	
			else
			{
				// 수신된 내용이 존재하지 않는 상황 전달 (안내)
				System.out.println("수정 대상이 존재하지 않습니다.");
			}
			
			// 데이터베이스 연결 종료
			dao.Close();
			
		} catch (Exception e)
		{
			System.out.println(e.toString());
		}
	}
	
	// 성적 삭제 기능
	public void sungjukDelete()
	{
		try
		{
			// 삭제할 대상 받기
			Scanner sc = new Scanner(System.in);
			System.out.print("삭제할 대상 번호를 입력하세요 : ");
			int sid = sc.nextInt();
			
			// ~ 유효성 검사 ~
			
			// 데이터베이스 연결
			dao.connection();
			
			// 삭제 데이터 확인
			ArrayList<ScoreDTO> arrayList = dao.lists(sid);
			
			if (arrayList.size() > 0)
			{
				// 삭제될 데이터 출력
				System.out.println();
				System.out.println("번호   이름   국어    영어   수학    총점     평균    석차");
				
				for (ScoreDTO dto : arrayList)
				{
					System.out.printf("%3s %5s %5d %7d %6d %7d %8.1f %5d\n" 
									   ,dto.getSid(), dto.getName(), dto.getKor() , dto.getEng(), dto.getMat()
									   ,dto.getTot(), dto.getAvg(), dto.getRank());
					
				}
				System.out.print("정말 삭제하시겠습니까? (Y/N) : ");
				String response =sc.next();
				
				if (response.equals("Y") || response.equals("y"))
				{
					// dao 의 삭제 메소드 호출
					int result = dao.remove(sid);
					if (result > 0)
						System.out.println("삭제가 완료되었습니다.");	
				} else
				{
					System.out.println("취소되었습니다.");
				}
	
			
			} else
			{
				// 삭제할 데이터가 없다는 것을 안내
				System.out.println("삭제할 대상이 존재하지 않습니다.");
			}
			
			//데이터베이스 연결 해제 
			dao.Close();

		} catch (Exception e)
		{
			System.out.println(e.toString());
		}
	}
	
}




















