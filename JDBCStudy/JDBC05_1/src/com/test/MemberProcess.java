/* ===========================================
 	MemberProcess.java
 	- 콘솔 기반 서브 메뉴 입출력 전용 클래스
 ============================================*/

/*
   ==========[직원 관리]==========
 1. 직원 정보 입력
 2. 직원 전체 출력
 	- 사번 정렬
 	- 이름 정렬
 	- 부서 정렬
 	- 직위 정렬
 	- 급여 내림차순 정렬
 	
 3. 직원 검색 출력
 	- 사번 검색 
 	- 이름 검색
 	- 부서 검색
 	- 직위 검색
 	
 4. 직원 정보 수정
 5. 직원 정보 삭제
 =============================
 >> 메뉴 선택 (1~5, -1 종료) : 
 */


package com.test;

import java.util.ArrayList;
import java.util.Scanner;

public class MemberProcess
{
	// 주요 속성 구성
	private MemberDAO dao;
	
	// 생성자 정의 (사용자 정의 생성자)
	public MemberProcess()
	{
		dao = new MemberDAO();
	}
	
	// 직원 정보 입력 메소드 정의 
	public void memberInsert()
	{
		Scanner sc = new Scanner(System.in);
		
		try
		{
			// 데이터 베이스 연결 
			dao.connection();
			
			// 지역 리스트 구성 
			ArrayList<String> citys = dao.searchCity();
			StringBuilder citystr = new StringBuilder();
			for (String city : citys)
				citystr.append(city+"/");		
			// "강원/경기/경남/경북/부산/서울/인천/전남/전북/제주/충남/충북/"
			
			// 부서 리스트 구성
			ArrayList<String> buseos = dao.searchBuseo();
			StringBuilder buseostr = new StringBuilder();
			for (String buseo : buseos)
					buseostr.append(buseo + "/");
			//"개발부/기획부/영업부/인사부/자재부/총무부/홍보부/"
			
			// 직위 리스트 구성
			ArrayList<String> jikwis = dao.searchJikwi();
			StringBuilder jikwistr = new StringBuilder();
			for (String jikwi : jikwis)
				jikwistr.append(jikwi + "/");
			//"사장/전무/상무/이사/부장/차장/과장/대리/사원/"
			
			// 사용자에게 보여지는 화면 처리
			/*
			 직원 정보 입력 ------------------------------------------------------
			 이름 : 김민지
			 주민등록번호 (yymmdd-nnnnnnn) : 980528-2234567
			 입사일 (yyyy-mm-dd) : 2019-06-08
			 지역(강원/경기/경남/경북/부산/서울/인천/전남/전북/제주/충남/충북/) : 경기
			 전화번호 : 010-1111-1111
			 부서입력(개발부/기획부/영업부/인사부/자재부/총무부/홍보부/) : 개발부
			 직위(사장/전무/상무/이사/부장/차장/과장/대리/사원/) : 대리
			 기본급(최소 1800000 이상) : 2500000
			 수당 : 1000000
			
			직원 정보 입력 완료~!!
			------------------------------------------------------ 직원 정보 입력
			 */
			
			System.out.println("직원 정보 입력 --------------------");
			System.out.print("이름 :");
			String empName = sc.next();
			System.out.print("주민등록번호 (yymmdd-nnnnnnn) :");
			String ssn = sc.next();
			System.out.print("입사일 (yyyy-mm-dd) : ");
			String ibsaDate = sc.next();
			System.out.printf("지역 (%s ):",citystr);
			String cityName = sc.next();
			System.out.print("전화번호 : ");
			String tel = sc.next();
			System.out.printf("부서입력 (%s ): ",buseostr);
			String buseoName = sc.next();
			System.out.printf("직위 (%s ): ",jikwistr);
			String jikwiName = sc.next();
			System.out.printf("기본급(최소 %d 이상) :",dao.searchBasicPay(jikwiName));
			int basicPay = sc.nextInt();
			System.out.print("수당 :");
			int sudang = sc.nextInt();
			System.out.println();
			
			MemberDTO dto = new MemberDTO();
			dto.setEmpName(empName);
			dto.setSsn(ssn);
			dto.setIbsadate(ibsaDate);
			dto.setCityName(cityName);
			dto.setTel(tel);
			dto.setBuseoName(buseoName);
			dto.setJikwiName(jikwiName);
			dto.setBasicPay(basicPay);
			dto.setSudang(sudang);
			
			int result = dao.add(dto);
			if (result > 0)
				System.out.println("직원정보 입력 완료~~!!");
			System.out.println("----------------------- 직원 정보 입력");
			
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
	}// end memberInsert()
	
	// 직원 전체 출력 메소드 정의 
	public void memberLists()
	{
		Scanner sc = new Scanner(System.in);
		
		// 서브메뉴 출력 (안내)
		System.out.println("1. 사번 정렬      ");			// EMP_ID
		System.out.println("2. 이름 정렬      ");			// EMP_NAME
		System.out.println("3. 부서 정렬      ");			// BUSEO_NAME
		System.out.println("4. 직위 정렬      ");			// JIKWI_NAME
		System.out.println("5. 급여 내림차순 정렬 ");		// PAY DESC
		System.out.print(">> 메뉴 선택 (1~5, -1 종료) : ");
		String menuStr = sc.next();
		
		try
		{
			int menu = Integer.parseInt(menuStr);
			if (menu == -1)
				return;
			
			String key = "";
			
			switch (menu)
			{	
				case 1:
					key = "EMP_ID";
					break;
				case 2:
					key = "EMP_NAME";
					break;
				case 3:
					key = "BUSEO_NAME";
					break;
				case 4:
					key = "JIKWI_NAME";
					break;
				case 5:
					key = "PAY DESC";
					break;
			}
			
			dao.connection();
			
			// 직원 리스트 출력
			System.out.println();
			System.out.printf("전체 인원 : %d명" ,dao.memberCount());
			System.out.println();
			System.out.println("사번 이름 주민번호 입사일 지역 전화번호 부서 직위 기본급 수당 급여");

			ArrayList<MemberDTO> memList = dao.lists(key);
			if (memList.size() > 0) 
			{
			   for (MemberDTO dto : memList)
			   {
				   System.out.printf("%4d %3s %14s %10s %s %13s %s %s %8d %d %7d\n"
						   ,dto.getEmpId(), dto.getEmpName(),dto.getSsn(),dto.getIbsadate()
						   ,dto.getCityName(), dto.getTel(),dto.getBuseoName(),dto.getJikwiName()
						   ,dto.getBasicPay(),dto.getSudang(),dto.getPay());
			   }	
			   
			}
			else 
			{
				System.out.println("등록된 직원이 존재하지 않습니다");
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
		
	}// end memberLists()
	
	// 직원 검색 출력 메소드 정의
	public void memberSearch()
	{
		Scanner sc = new Scanner(System.in);
		
		//서브 메뉴 출력
		
		System.out.println("1. 사번 검색 ");
		System.out.println("2. 이름 검색");
		System.out.println("3. 부서 검색");
		System.out.println("4. 직위 검색");
		System.out.print(">> 메뉴 선택 (1~4, -1 종료) : ");
		String menustr = sc.next();
				
		int menu = Integer.parseInt(menustr);
	
		try
		{
			if (menu == -1)
			{
				return;	// 메인 메뉴로 돌아감
			}
			
			String key = "";
			String value = "";
			
			switch (menu)
			{
			case 1:
				key = "EMP_ID";
				System.out.print("검색할 사원번호 입력 : ");
				value = sc.next();
				break;
			case 2:
				key = "EMP_NAME";
				System.out.print("검색할 이름 입력 : ");
				value = sc.next();
				break;
			case 3:
				key = "BUSEO_NAME";
				System.out.print("검색할 부서명 입력 : ");
				value = sc.next();
				break;
			case 4:
				key = "JIKWI_NAME";
				System.out.print("검색할 직위명 입력 : ");
				value = sc.next();
				break;
			}
			
			// 데이터 베이스 연결
			dao.connection();
			
			System.out.println();
			System.out.printf("검색 인원 : %d 명\n" , dao.memberCount(key,value));
			System.out.println("사번 이름 주민번호 입사일 지역 전화번호 부서 직위 기본급 수당 급여");
			ArrayList<MemberDTO> memList =dao.searchLists(key, value);
			if (memList.size() > 0)
			{
				for (MemberDTO dto: memList)
				{
					System.out.printf("%4d %3s %14s %10s %s %13s %s %s %8d %d %7d\n"
							,dto.getEmpId(), dto.getEmpName(),dto.getSsn(),dto.getIbsadate()
							,dto.getCityName(), dto.getTel(),dto.getBuseoName(),dto.getJikwiName()
							,dto.getBasicPay(),dto.getSudang(),dto.getPay());
				}	
			}
			else 
			{
				System.out.println("검색 결과가 존재하지 않습니다.");
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
				
			} catch (Exception e)
			{
				System.out.println(e.toString());
			}
		}
	}
	
	
	
	// 직원 정보 수정 메소드 정의
	public void memberUpdate()
	{
		Scanner sc = new Scanner(System.in);
		try
		{
			// 수정할 대상 찾기
			System.out.print("수정할 직원의 사원번호 입력 : ");
			String value = sc.next();
					
			// 데이터베이스 연결
			dao.connection();
			ArrayList<MemberDTO> memList = dao.searchLists("EMP_ID", value);
			
			// 수정 대상을 찾은 경우
			if (memList.size() > 0)
			{
				// 지역 리스트 구성
				ArrayList<String> arraycity = dao.searchCity();
				StringBuilder citystr = new StringBuilder();
				for (String str : arraycity)
					citystr.append(str + "/");
				
				// 부서 리스트 구성
				ArrayList<String> arrayBuseo = dao.searchBuseo();
				StringBuilder buseostr = new StringBuilder();
				for(String buseo : arrayBuseo)
					buseostr.append(buseo + "/");
				
				// 직위 리스트 구성
				ArrayList<String> arrayjikwi = dao.searchJikwi();
				StringBuilder jikwistr = new StringBuilder();
				for (String jikwi : arrayjikwi)
					jikwistr.append(jikwi +"/");
			
				// 사용자에게 보여지는 화면 처리
				/*
				 직원 정보 수정 ------------------------------------------------------
				 기존 이름 : 채다선
				 수정 이름 : - 
				 기존 주민등록번호 (yymmdd-nnnnnnn) : 961023-2234567
				 수정 주민등록번호 (yymmdd-nnnnnnn) : -
				 기존 입사일 (yyyy-mm-dd) : 2019-06-08
				 수정 입사일 (yyyy-mm-dd) : 2020-11-24
				 기존 지역 : 경기
				 수정 지역(강원/경기/경남/경북/부산/서울/인천/전남/전북/제주/충남/충북/) : -
				 기존 전화번호 : 010-1111-1111
				 수정 전화번호 : - 
				 기존 부서 : 개발부
				 수정 부서(개발부/기획부/영업부/인사부/자재부/총무부/홍보부/) : -
				 기존 직위 : 대리
				 수정 직위(사장/전무/상무/이사/부장/차장/과장/대리/사원/) : -
				 기존 기본급 : 2500000
				 수정 기본급(최소 1800000 이상) : 3000000
				 기존 수당 : 1000000
				 수정 수당 : -
				 
				직원 정보 수정 완료~!!
				------------------------------------------------------ 직원 정보 수정
				 */
				
					MemberDTO mMeber = memList.get(0);
					int mEmpId = mMeber.getEmpId();
					String mEmpName = mMeber.getEmpName();
					String mSsn =mMeber.getSsn();
					String mIbsaDate = mMeber.getIbsadate();
					String mCityName = mMeber.getCityName();
					String mTel = mMeber.getTel();
					String mBuseoName = mMeber.getBuseoName();
					String mJikwiName = mMeber.getJikwiName();
					int mBasicPay = mMeber.getBasicPay();
					int mSudang = mMeber.getSudang();
					
					System.out.println();
					System.out.println(" 직원 정보 수정 ------------------------------------------------------");
					System.out.printf(" 기존 이름 : %s\n",mEmpName);
					System.out.print(" 수정 이름 : ");
					String empName = sc.next();
					if (empName.equals("-"))
						empName = mEmpName;
					
					System.out.printf(" 기존 주민등록번호 (yymmdd-nnnnnnn) : %s\n",mSsn);
					System.out.print(" 수정 주민등록번호 (yymmdd-nnnnnnn) : ");
					String ssn = sc.next();
					if (ssn.equals("-"))
						ssn = mSsn;
					
					System.out.printf(" 기존 입사일 (yyyy-mm-dd) : %s\n" , mIbsaDate);
					System.out.print(" 수정 입사일 (yyyy-mm-dd) :");
					String ibsaDate = sc.next();
					if (ibsaDate.equals("-"))
						ibsaDate = mIbsaDate;
					
					System.out.printf(" 기존 지역 : %s\n",mCityName);
					System.out.printf(" 수정 지역 (%s) : ", citystr.toString());
					String cityName = sc.next();
					if (cityName.equals("-"))
						cityName = mCityName;
					
					System.out.printf(" 기존 전화번호 : %s\n",mTel);
					System.out.print(" 수정 전화번호 : ");
					String tel = sc.next();
					if (tel.equals("-"))
						tel = mTel;
					
					System.out.printf(" 기존 부서 : %s\n",mBuseoName);
					System.out.printf(" 수정 부서 (%s) : ",buseostr.toString());
					String buseoName = sc.next();
					if (buseoName.equals("-"))
						buseoName = mBuseoName;
					
					System.out.printf(" 기존 직위 : %s\n",mJikwiName);
					System.out.printf(" 수정 직위  (%s) :",jikwistr.toString());
					String jikwiName = sc.next();
					if (jikwiName.equals("-"))
						jikwiName = mJikwiName;
					
					System.out.printf(" 기존 기본급 : %d\n",mBasicPay);
					System.out.printf(" 수정 기본급 (최소 %d 이상) : ",dao.searchBasicPay(jikwiName));
					String basicPaystr = sc.next();
					int basicPay = 0;
					if (basicPaystr.equals("-"))
						basicPay = mBasicPay;
					else
						basicPay = Integer.parseInt(basicPaystr);
					
					System.out.printf(" 기존 수당 : %d\n",mSudang);
					System.out.print(" 수정 수당 : ");
					String sudangStr = sc.next();
					int sudang = 0;
					if (sudangStr.equals("-"))
						sudang = mSudang;
					else 
						sudang = Integer.parseInt(sudangStr);
					
					// 새로 입력받은(수정한) 내용을 통해 DTO 구성
					MemberDTO member = new MemberDTO();
					member.setEmpId(mEmpId);				//check~~!!
					member.setEmpName(empName);
					member.setSsn(ssn);
					member.setIbsadate(ibsaDate);
					member.setCityName(cityName);
					member.setTel(tel);
					member.setBuseoName(buseoName);
					member.setJikwiName(jikwiName);
					member.setBasicPay(basicPay);
					member.setSudang(sudang);
					
					int result = dao.modify(member);
					if (result > 0)
						System.out.println(" 직원 정보 수정 완료~~!!");
					
					System.out.println(" ------------------------------------------------------ 직원 정보 수정");
			}
			else
			{
				System.out.println("수정 대상을 검색하지 못했습니다.");
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
			} catch (Exception e)
			{
				System.out.println(e.toString());
			}
		}
		
	} // end memberUpdate()
	
	// 직원 정보 삭제 메소드 정의
	public void memberDelete()
	{
		Scanner sc = new Scanner(System.in);
		
		try
		{
			System.out.print("삭제할 직원의 사원번호 입력 : ");
			String value = sc.next();
			
			// 사용자가 입력한 직원의 사원번호에 대한 유효성 검사 코드 삽입 가능~~!!
			
			// 직원 정보 확인 후 삭제 여부 결정
			
			// 데이터베이스 연결 
			dao.connection();
			
			ArrayList<MemberDTO> members = dao.searchLists("EMP_ID", value);
			
			if(members.size() > 0 )
			{
				// 삭제할 대상 확인
				System.out.println("사번 이름 주민번호 입사일 지역 전화번호 부서 직위 기본급 수당 급여");
				   for (MemberDTO dto : members)
				   {
					   System.out.printf("%4d %3s %14s %10s %s %13s %s %s %8d %d %7d\n"
							   ,dto.getEmpId(), dto.getEmpName(),dto.getSsn(),dto.getIbsadate()
							   ,dto.getCityName(), dto.getTel(),dto.getBuseoName(),dto.getJikwiName()
							   ,dto.getBasicPay(),dto.getSudang(),dto.getPay());
				   }	
				
				// 삭제 여부 결정 및 처리
				  System.out.print("\n정말 삭제하시겠습니까? (Y/N) : ");
				  String response = sc.next();
				  if (response.equals("Y") || response.equals("y"))
				  {
					  int result = dao.remove(Integer.parseInt(value));
					  
					  if (result > 0)
						  System.out.println("직원 정보가 정상적으로 삭제되었습니다.");
				  }
				   
			}
			else 
				System.out.println("삭제할 대상을 찾기 못했습니다.");
			
			
		} catch (Exception e)
		{
			System.out.println(e.toString());
		}
		finally 
		{
			try
			{	// 데이터베이스 연결 해제~>.<
				dao.close();
				
			} catch (Exception e2)
			{
				System.out.println(e2.toString());
			}
		}
	}
}













