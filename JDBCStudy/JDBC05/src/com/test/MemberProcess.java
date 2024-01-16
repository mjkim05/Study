/* ===========================================
 	MemberProcess.java
 	- 콘솔 기반 서브 메뉴 입출력 전용 클래스
 ============================================*/
package com.test;

import java.util.Scanner;

public class MemberProcess
{
	private static final boolean Scanner = false;
	MemberDAO dao = new MemberDAO();
	
	//직원 정보 입력
	public void prcInsert()
	{
		//데이터베이스 연결
		dao.connection();
		
		try
		{
			//인원수 받기
			int count = dao.count();
			
			//입력 받을 데이터 
			Scanner sc = new Scanner(System.in);
			 
			do
			{
				System.out.println();
				System.out.println(" 직원 정보 입력 ------------------------------------------------------");
				System.out.print(" 이름 : ");
				String name = sc.next();
				
				if (name.equals("."))
					break;
		
				System.out.print(" 주민등록번호 (yymmdd-nnnnnnn) : ");
				String ssn = sc.next();
			
				System.out.print(" 입사일 (yyyy-mm-dd) : ");
				String ibsa = sc.next();
				
				System.out.print(" 지역(");
				for (MemberDTO dtocity : dao.city())
					System.out.printf("%s/",dtocity.getCityName());
				System.out.print(") : ");
				String city = sc.next();

				System.out.print(" 전화번호 : ");
				String tel = sc.next();
				
				System.out.print(" 부서입력(");
				for (MemberDTO dtobuseo : dao.buseo())
					System.out.printf("%s/",dtobuseo.getBuseoName());
				System.out.print(") : ");
				String buseo = sc.next();
				
				System.out.print(" 직위(");
				for (MemberDTO dtojikwi : dao.jikwi())
					System.out.printf("%s/",dtojikwi.getJikwiName());
				System.out.print(") : ");
				String jikwi = sc.next();
				
				System.out.print(" 기본급(최소" );
				for (MemberDTO dtomin : dao.jikwi(jikwi))
					System.out.printf("%s 이상) : ",dtomin.getMinBasic());
				int pay = sc.nextInt();
				
				System.out.print(" 수당 : ");
				int sudang = sc.nextInt();	
				
				MemberDTO dto = new MemberDTO();
				
				//EMP_ID, EMP_NAME, SSN, IBSADATE, CITY_ID, TEL, BUSEO_ID, JIKWI_ID, BASICPAY, SUDANG
				//받은 데이터 처리 (name → id)
				for (MemberDTO chBuseo : dao.buseo(buseo))
					dto.setBuseoId(chBuseo.getBuseoId());
				for (MemberDTO chCity : dao.city(city))
					dto.setCityId(chCity.getCityId());
				for (MemberDTO chjikwi : dao.jikwi(jikwi))
					dto.setJikwiId(chjikwi.getJikwiId());

				dto.setEmpName(name);
				dto.setSsn(ssn);
				dto.setIbsaDate(ibsa);
				dto.setTel(tel);
				dto.setBasicPay(pay);
				dto.setSudang(sudang);
				
				//dao 입력 메소드 호출
				int result = dao.add(dto);
				
				if (result > 0)
					System.out.println(" 직원정보가 입력되었습니다!");
				else 
					System.out.println(" 입력이 실패되었습니다.");
				System.out.println(" ------------------------------------------------------ 직원 정보 입력");
				
			} while (true);
			
		} catch (Exception e)
		{
			System.out.println(e.toString());
		}
		
		//데이터베이스 연결해제
		dao.close();
	}
	
	//직원 전체 출력 
	public void empSelete()
	{	
		dao.connection();
		
		try
		{	

			do
			{
				Scanner sc = new Scanner(System.in);
				
				System.out.println(" 1. 사번 정렬      ");
				System.out.println(" 2. 이름 정렬      ");
				System.out.println(" 3. 부서 정렬      ");
				System.out.println(" 4. 직위 정렬      ");
				System.out.println(" 5. 급여 내림차순 정렬 ");
				System.out.print(">> 메뉴 선택 (1~5, -1 종료) : ");
				int num = sc.nextInt();
				
				if (num == -1)
				{
					break;
				}
					
				System.out.println("사번  이름    주민번호       입사일   지역     전화번호   부서  직위  기본급   수당   급여");

		        for (MemberDTO dto : dao.lists(num))
		        {
		        	int tot = dto.getBasicPay() + dto.getSudang();
		        	
		           System.out.printf("%4s %3s %14s %10s %s %13s %s %s %8d %d %7d\n",
		        		   			dto.getEmpId(), dto.getEmpName(),dto.getSsn(),dto.getIbsaDate(),dto.getCityName()
		        		   			,dto.getTel(),dto.getBuseoName(),dto.getJikwiName(),dto.getBasicPay(),dto.getSudang(),tot);
		        }
		        break;
		        
			} while (true);
			
		} catch (Exception e)
		{
			System.out.println(e.toString());
		}
		
		dao.close();
	}
	
	//직원 검색 출력 
	public void empResearch()
	{
		dao.connection();
		
		try
		{
			Scanner sc = new Scanner(System.in);
			
			System.out.println(" 1. 사번 검색 ");
			System.out.println(" 2. 이름 검색 ");
			System.out.println(" 3. 부서 검색 ");
			System.out.println(" 4. 직위 검색 ");
			System.out.print(" >> 메뉴 선택 (1~4, -1 종료) : ");
			int num = sc.nextInt();
			
			do
			{	
				if (num == -1)
				{
					break;
				}
				
				switch (num)
				{
				case 1:
					System.out.print(" 검색할 사번 : ");
					String empId = sc.next();
					
					System.out.println(" 사번  이름    주민번호       입사일   지역     전화번호   부서  직위  기본급   수당   급여");
					for (MemberDTO dto : dao.researchId(empId))
					{
						int tot = dto.getBasicPay() + dto.getSudang();
			        	
				        System.out.printf(" %4s %3s %14s %10s %s %13s %s %s %8d %d %7d\n",
				        		   		 dto.getEmpId(), dto.getEmpName(),dto.getSsn(),dto.getIbsaDate(),dto.getCityName()
				        		   		,dto.getTel(),dto.getBuseoName(),dto.getJikwiName(),dto.getBasicPay(),dto.getSudang(),tot);
					}	
					break;
				case 2:
					System.out.print(" 검색할 이름 : ");
					String name = sc.next();
					System.out.println(" 사번  이름    주민번호       입사일   지역     전화번호   부서  직위  기본급   수당   급여");
					for (MemberDTO dto : dao.researchName(name))
					{
						int tot = dto.getBasicPay() + dto.getSudang();
			        	
				           System.out.printf(" %4s %3s %14s %10s %s %13s %s %s %8d %d %7d\n",
		        		   			dto.getEmpId(), dto.getEmpName(),dto.getSsn(),dto.getIbsaDate(),dto.getCityName()
		        		   			,dto.getTel(),dto.getBuseoName(),dto.getJikwiName(),dto.getBasicPay(),dto.getSudang(),tot);
					}	
					break;
				case 3:
					System.out.print(" 검색할 부서 : ");
					String buseo = sc.next();
					System.out.println(" 사번  이름    주민번호       입사일   지역     전화번호   부서  직위  기본급   수당   급여");
					for (MemberDTO dto : dao.researchBuseo(buseo))
					{
						int tot = dto.getBasicPay() + dto.getSudang();
			        	
				           System.out.printf(" %4s %3s %14s %10s %s %13s %s %s %8d %d %7d\n",
		        		   			dto.getEmpId(), dto.getEmpName(),dto.getSsn(),dto.getIbsaDate(),dto.getCityName()
		        		   			,dto.getTel(),dto.getBuseoName(),dto.getJikwiName(),dto.getBasicPay(),dto.getSudang(),tot);
					}	
					break;
				case 4:
					System.out.print(" 검색할 직위 : ");
					String jikwi = sc.next();
					System.out.println(" 사번  이름    주민번호       입사일   지역     전화번호   부서  직위  기본급   수당   급여");
					for (MemberDTO dto : dao.researchJikwi(jikwi))
					{
						int tot = dto.getBasicPay() + dto.getSudang();
			        	
				           System.out.printf(" %4s %3s %14s %10s %s %13s %s %s %8d %d %7d\n",
		        		   			dto.getEmpId(), dto.getEmpName(),dto.getSsn(),dto.getIbsaDate(),dto.getCityName()
		        		   			,dto.getTel(),dto.getBuseoName(),dto.getJikwiName(),dto.getBasicPay(),dto.getSudang(),tot);
					}	
					break;
				}
				break;
			} while (true);

		} catch (Exception e)
		{
			System.out.println(e.toString());
		}
		
		dao.close();
	}
	
	//직원 정보 수정 
	public void empUpdate()
	{
		dao.connection();
		
		try
		{
			Scanner sc = new Scanner(System.in);
			MemberDTO dto = new MemberDTO();
			
			System.out.print(" 수정할 직원의 사번을 입력하세요 : ");
			String empid = sc.next();
			
			while (true)
			{
				if (empid.equals("."))
				{
					break;
				}
				
				dto.setEmpId(empid);	
				System.out.print(" 이름 : ");
				dto.setEmpName(sc.next());
				System.out.print(" 주민등록번호 (yymmdd-nnnnnnn) : ");
				dto.setSsn(sc.next());
				
				System.out.print(" 입사일 (yyyy-mm-dd) : ");                                                      
				dto.setIbsaDate(sc.next());                                                             
				                                                                                               
				System.out.print(" 지역(");                                                                      
				for (MemberDTO dtocity : dao.city())                                                           
					System.out.printf("%s/",dtocity.getCityName());                                            
				System.out.print(") : ");                                                                      
				String city = sc.next();                                                                       
				                                                                                               
				System.out.print(" 전화번호 : ");                                                                  
				dto.setTel(sc.next());                                                                     
				                                                                                               
				System.out.print(" 부서입력(");                                                                    
				for (MemberDTO dtobuseo : dao.buseo())                                                         
					System.out.printf("%s/",dtobuseo.getBuseoName());                                          
				System.out.print(") : ");                                                                      
				String buseo = sc.next();                                                                      
				                                                                                               
				System.out.print(" 직위(");                                                                      
				for (MemberDTO dtojikwi : dao.jikwi())                                                         
					System.out.printf("%s/",dtojikwi.getJikwiName());                                          
				System.out.print(") : ");                                                                      
				String jikwi = sc.next();                                                                      
				                                                                                               
				System.out.print(" 기본급(최소" );                                                                  
				for (MemberDTO dtomin : dao.jikwi(jikwi))                                                      
					System.out.printf("%s 이상) : ",dtomin.getMinBasic());                                       
				dto.setBasicPay(sc.nextInt());                                                                      
				                                                                                               
				System.out.print(" 수당 : ");                                                                    
				dto.setSudang(sc.nextInt());
				                                                                                               
				//EMP_ID, EMP_NAME, SSN, IBSADATE, CITY_ID, TEL, BUSEO_ID, JIKWI_ID, BASICPAY, SUDANG          
				//받은 데이터 처리 (name → id)                                                                        
				for (MemberDTO chBuseo : dao.buseo(buseo))                                                     
					dto.setBuseoId(chBuseo.getBuseoId());                                                      
				for (MemberDTO chCity : dao.city(city))                                                        
					dto.setCityId(chCity.getCityId());                                                         
				for (MemberDTO chjikwi : dao.jikwi(jikwi))                                                     
					dto.setJikwiId(chjikwi.getJikwiId());
				
				int result = dao.modify(dto);
				
				if (result > 0)
					System.out.println(" 직원정보가 수정되었습니다.");
				else 
					System.out.println(" 수정이 실패했습니다.");
				
				break;
			}
		} catch (Exception e)
		{
			System.out.println(e.toString());
		}
		
		dao.close();
	}
	
	//직원 정보 삭제 
	public void empDelete()
	{
		dao.connection();
		
		try
		{
			do
			{
				Scanner sc = new Scanner(System.in);
				System.out.print(" 삭제할 직원의 사번을 입력해주세요 : ");
				String empid = sc.next();
				
				System.out.print(" 정말로 삭제하시겠습니까? 되돌릴 수 없습니다. (Y/N) : ");
				String str = sc.next();
				
				if (str.equals("Y") || str.equals("y"))
				{
					int result = dao.remove(empid);
					if(result > 0 )
						System.out.println(" 삭제 완료되었습니다.");
					else 
						System.out.println(" 삭제 되지 않았습니다.");
				}
				else
				{
					System.out.println(" 취소되었습니다.");
					break;
					
				}
				
			} while (true);
			
		} catch (Exception e)
		{
			System.out.println(e.toString());
		}
		
		dao.close();
	}
	
	
	
}
