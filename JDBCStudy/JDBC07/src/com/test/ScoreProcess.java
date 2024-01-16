package com.test;

import java.util.ArrayList;
import java.util.Scanner;

public class ScoreProcess
{
	private ScoreDAO dao;
	
	public ScoreProcess()
	{
		dao = new ScoreDAO();
	}
	
	//1. 성적처리 
	public void scoreInsert()
	{	
		Scanner sc = new Scanner(System.in);
		
		try
		{
			// 데이터베이스 연결
			dao.connection();
			
			
			
			do
			{
				int count = dao.count(); 
				
				System.out.println();
				System.out.printf("%d번 학생 성적 입력 (이름 국어 영어 수학) :", count+1);
				String name = sc.next();
				if (name.equals("."))
					break;
					
				int kor = sc.nextInt();
				int eng = sc.nextInt();
				int mat = sc.nextInt();
				
				ScoreDTO dto = new ScoreDTO();
				
				dto.setName(name);
				dto.setKor(kor);
				dto.setEng(eng);
				dto.setMat(mat);
				
				int result = dao.insert(dto);
				if (result > 0)
					System.out.println("성적 입력이 완료되었습니다.");
				
			} while (true);
			
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
		
	}
	//2. 성적 전체 출력
	public void scoreAllList()
	{
		try
		{
			dao.connection();
			
			System.out.printf(" 전체 인원 : %d\n" , dao.count());
			System.out.println(" 번호   이름   국어    영어   수학    총점    평균    석차");
			for (ScoreDTO dto  : dao.lists())
			{
				System.out.printf("%3d %6s %4d %7d %6d %7d %8.1f %6d\n"
								, dto.getSid(), dto.getName()
								, dto.getKor(), dto.getEng(),dto.getMat()
								, dto.getTot(), dto.getAvg(), dto.getRank());
			}
			
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
	}
	//3. 이름 검색 출력
	public void scoreNameList()
	{
		try
		{
			Scanner sc = new Scanner(System.in);
			
			System.out.print(" 검색할 이름 입력 : ");
			String name = sc.next();
			
			dao.connection();
			
			ArrayList<ScoreDTO> scoNameList = dao.searchList(name);
			if (scoNameList.size() > 0)
			{
				System.out.println(" 번호   이름   국어    영어   수학    총점    평균    석차");
				for (ScoreDTO dto : scoNameList)
				{
					System.out.printf("%3d , %4s , %3d, %3d, %3d, %4d, %4.1f , %3d\n"
									, dto.getSid(), dto.getName()
									, dto.getKor(), dto.getEng(),dto.getMat()
									, dto.getTot(), dto.getAvg(), dto.getRank());
				}
			}
			else 
				System.out.println("이름을 찾지 못했습니다.");
			
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
	}
	
	//4. 성적 수정
	public void scoreUpdate()
	{
		
		try
		{
			Scanner sc = new Scanner(System.in);
			System.out.print("수정 할 학생 번호 입력 : ");
			String sid = sc.next();
			if (sid.equals("."))
			{
				return;
			}
			System.out.print("수정 내용 입력 (이름, 국어, 영어, 수학) : ");
			String name = sc.next();
			int kor = sc.nextInt();
			int eng = sc.nextInt();
			int mat = sc.nextInt();
			
			// 데이터베이스 연결
			dao.connection();
			
			ScoreDTO dto = new ScoreDTO();
			dto.setSid(Integer.parseInt(sid));
			dto.setName(name);
			dto.setKor(kor);
			dto.setEng(eng);
			dto.setMat(mat);
			
			int result = dao.modify(dto);
			
			if (result > 0)
				System.out.println("성적 수정이 완료 되었습니다.");
			
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
	}
	
	//5. 성적 삭제
	public void scoreDlete()
	{
		try
		{
			Scanner sc = new Scanner(System.in);
			System.out.print("삭제 할 학생 학번 입력 : ");
			String sid = sc.next();
			if (sid.equals("."))
				return;
			
			//데이터베이스 연결 
			dao.connection();
			
			int result = dao.remove(Integer.parseInt(sid));
			if (result > 0)
				System.out.println("삭제가 완료되었습니다.");
			else 
				System.out.println("삭제 실패하였습니다.");
			
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
		
	}
	
}
