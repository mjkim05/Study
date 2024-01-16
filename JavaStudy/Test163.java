/*================================
  ■■■ 컬렉션(Collection) ■■■		
=================================*/

// Test163 클래스를 완성하여 다음 기능을 가진 프로그램을 구현한다.

/*
실행 예)
	
	[메뉴 선택]==============
	1. 요소 추가 
	2. 요소 출력
	3. 요소 검색
	4. 요소 삭제
	5. 요소 변경
	6. 종료 
	=========================
 >> 메뉴 선택(1~6) : 1
 
 1번째 요소 입력 : 최혜인
 1번째 요소 입력 성공~!!!
 요소 입력 계속(Y/N)? : y

 2번째 요소 입력 : 채다선
 2번째 요소 입력 성공~!!
 요소 입력 계속(Y/N)? : n

 	[메뉴 선택]==============
	1. 요소 추가 
	2. 요소 출력
	3. 요소 검색
	4. 요소 삭제
	5. 요소 변경
	6. 종료 
	=========================
 >> 메뉴 선택(1~6) : 2
 
 [벡터 전체 출력]
 최혜인
 채다선
 벡터 전체 출력 완료~!!

  	[메뉴 선택]==============
	1. 요소 추가 
	2. 요소 출력
	3. 요소 검색
	4. 요소 삭제
	5. 요소 변경
	6. 종료 
	=========================
 >> 메뉴 선택(1~6) : 3

 검색할 요소 입력 : 채다선

 [검색 결과 출력]
 항목이 존재합니다.

  	[메뉴 선택]==============
	1. 요소 추가 
	2. 요소 출력
	3. 요소 검색
	4. 요소 삭제
	5. 요소 변경
	6. 종료 
	=========================
 >> 메뉴 선택(1~6) : 3

 검색할 요소 입력 : 정현욱
 
 [검색 결과 출력]
 항목이 존재하지 않습니다.

   	[메뉴 선택]==============
	1. 요소 추가 
	2. 요소 출력
	3. 요소 검색
	4. 요소 삭제
	5. 요소 변경
	6. 종료 
	=========================
 >> 메뉴 선택(1~6) : 4

 삭제할 요소 입력 : 정한울

 [삭제 결과 출력]
 항목이 존재하지 않아 삭제할 수 없습니다.

   	[메뉴 선택]==============
	1. 요소 추가 
	2. 요소 출력
	3. 요소 검색
	4. 요소 삭제
	5. 요소 변경
	6. 종료 
	=========================
 >> 메뉴 선택(1~6) : 4

 삭제할 요소 입력 : 최혜인

 [삭제 결과 출력]
 최혜인 항목이 삭제 되었습니다.

   	[메뉴 선택]==============
	1. 요소 추가 
	2. 요소 출력
	3. 요소 검색
	4. 요소 삭제
	5. 요소 변경
	6. 종료 
	=========================
 >> 메뉴 선택(1~6) : 5

 변경할 요소 입력 : 임하성

 [변경 결과 출력]
 변경할 대상이 존재하지 않습니다.

   	[메뉴 선택]==============
	1. 요소 추가 
	2. 요소 출력
	3. 요소 검색
	4. 요소 삭제
	5. 요소 변경
	6. 종료 
	=========================
 >> 메뉴 선택(1~6) : 5

 변경할 요소 입력 : 채다선
 수정할 내용 입력 : 이주형

 [변경 결과 출력]
 변경이 완료되었습니다.

   	[메뉴 선택]==============
	1. 요소 추가 
	2. 요소 출력
	3. 요소 검색
	4. 요소 삭제
	5. 요소 변경
	6. 종료 
	=========================
 >> 메뉴 선택(1~6) : 2

 [벡터 전체 출력]
 이주형
 벡터 전체 출력 완료~~!!

   	[메뉴 선택]==============
	1. 요소 추가 
	2. 요소 출력
	3. 요소 검색
	4. 요소 삭제
	5. 요소 변경
	6. 종료 
	=========================
 >> 메뉴 선택(1~6) : 6

 프로그램 종료~~!! 
 계속하려면 아무키나 누르세요...

*/

import java.util.Vector;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Enumeration;

class Menus			// → 완성 / Menus.E_ADD 라면? 이런식으로 쓰십쇼~~~
{
	public static final int E_ADD  = 1;		// 요소 추가
	public static final int E_DISP = 2;		// 요소 출력
	public static final int E_FIND = 3;		// 요소 검색
	public static final int E_DEL  = 4;		// 요소 삭제
	public static final int E_CHA  = 5;		// 요소 변경
	public static final int E_EXIT = 6;		// 종료 

}


public class Test163
{

	// 주요 속성 구성 → 완료 
	private static final Vector<Object> vt; // 자료구조
	private static  BufferedReader br;      // 입력 시 활용
	private static  Integer sel;		    // 선택 값
	private static  String con;		        // 계속 진행 여부
		
	
	// static 초기화 블럭 완성
	static			
	{
		// -- Vector 자료구조 생성
		vt = new Vector<Object>();
		
		// BufferedReader 객체 생성
		br = new BufferedReader(new InputStreamReader(System.in));

		//사용자 입력 값 초기화
		sel = 1; 
		con = "Y";
	}
	
	// 메뉴 출력 메소드
	public static void menuDisp()
	{
		// 사용자에게 안내하기 위한 메세지만을 출력하는 기능
		// 메뉴를 선택하는 기능의 메소드(menuSelect())를 별도로 정의했기 때문에
		// 이 과정에서는 사용자의 선택값을 받아오지 않아도 무방함
		System.out.println("\n	[메뉴 선택]==============");
		System.out.println("	1. 요소 추가 ");
		System.out.println("	2. 요소 출력 ");
		System.out.println("	3. 요소 검색 ");
		System.out.println("	4. 요소 삭제 ");
		System.out.println("	5. 요소 변경 ");
		System.out.println("	6. 종료 ");
		System.out.println("	=========================");
	
	}
	
	// 메뉴 선택 메소드
	public static void menuSelect() throws IOException, NumberFormatException
	{		
			
			// 선택한 메뉴에 따른 기능 분기는 
			// menuRun에서 처리할 예정이기 때문에 
			// 입력 값을 받아오는 기능만 정의

			
			try
			{
				System.out.print("\n\t >> 메뉴 선택(1~6) : ");
				sel = Integer.parseInt(br.readLine());
				//System.out.println();
			}
			catch (NumberFormatException e)
			{
				//System.out.println(e.toString());
				//System.out.println("숫자로 입력하세요!!");
				sel = 0;
			}
			
			
	}
	
	//선택된 메뉴 실행에 따른 기능 호출 메소드
	public static void menuRun() throws IOException
	{
		switch (sel)
		{
			case Menus.E_ADD : addElement(); break;
			case Menus.E_DISP: dispElement(); break;
			case Menus.E_FIND: findElement(); break;
			case Menus.E_DEL : delElement(); break;
			case Menus.E_CHA : chaElement(); break;
			case Menus.E_EXIT: exit(); break;
			default : System.out.println("\n\t 메뉴 선택 오류~");
		}
	}

	// 자료구조에 요소 추가(입력) 메소드
	public static void addElement() throws IOException
	{
		/*	내 코드
		do
		{		
				System.out.printf("%d번째 요소 입력 : " , vt.size()+1);
				String str = br.readLine();
				vt.add(str); 
				System.out.printf("%d번째 요소 입력 성공~~!!\n" , vt.size());
				System.out.print("요소 입력 계속 (Y/N) : ");
				con = br.readLine();	
				System.out.println();
		
		}
		while (con.equals("Y")  || con.equals("y"));
		*/

		// 수업 코드
		do
		{	System.out.printf("\n\t%d번째 요소 입력 : " , vt.size()+1);
			String element = br.readLine();
			boolean b = vt. add(element);
			if (b)
			{
				System.out.printf("\n\t %d번째 요소 입력 성공~~!!\n" , vt.size());
			}
			System.out.print("\n\t 요소 입력 계속 (Y/N) : ");
			con = br.readLine().toUpperCase();		// br.readLine.toUpperCase() → String 클래스 메소드 → toUpperCase - 소문자가 들어와도 대문자로 바꿔줌!! 
		}
		while (con.equals("Y"));		// 대문자 Y만 넣어도 가능 why? → toUpperCase()가 대문자로 바꿔주니까~
		
	
	}
	
	// 자료구조 전체 요소 출력 메소드
	public static void dispElement() 
	{	
		/* 내 코드
		System.out.println("\n [벡터 전체 출력]");
		for(Object obj : vt)
			System.out.println(" " + obj);
		System.out.println(" 벡터 전체 출력 완료~!!");	
		*/
		// 수업 코드
		System.out.println("\n\t [벡터 전체 출력]");
		for (Enumeration e = vt.elements(); e.hasMoreElements(); )				// hasMoreElements() 와 hasNext() 기능 똑같음!!!
		{
			System.out.printf("\t%10s\n", e.nextElement());						// nextElement() 와 next() 기능 똑같음!! 
		}
		System.out.println("\n\t 벡터 전체 출력 완료~!!");

	}

	// 자료구조 내 요소 검색 메소드
	public static void findElement() throws IOException
	{	
		System.out.print("\n\t 검색할 요소 입력 :");
		String str = br.readLine();
		
		//System.out.println("[검색 결과 출력]"); 여기에 써도 됨!! 
	

		if (vt.contains(str))
		{
			System.out.println("\n\t [검색 결과 출력]");
			System.out.println("\n\t 항목이 존재합니다.");

			// 수업 코드 
			// 추가 확인!!
			System.out.println("\n\t"+ str + " 인덱스 위치 :" + vt.indexOf(str));
		}
		else
		{
			System.out.println("\n\t[검색 결과 출력]");
			System.out.println("\n\t 항목이 존재하지 않습니다.");
		}

	}	

	// 자료구조 내 요소 삭제 메소드
	public static void delElement() throws IOException
	{
		System.out.print("\n\t 삭제할 요소 입력 : ");
		String str = br.readLine();

		int i = vt.indexOf(str);
		
		//System.out.prtinln("\n [삭제 결과 출력]");		// 위에 써도 됨 그러면 밑에 안써도 ㄱㅊ 

		if (vt.contains(str))
		{			
			System.out.println("\n\t [삭제 결과 출력]");

			//int i = vt.indexOf(str);						// 여기에 써도 된다!!
			vt.remove(i);

			System.out.printf("\n\t%s 항목이 삭제 되었습니다.\n" , str);
		}
		else
		{
			System.out.println("\n\t [삭제 결과 출력]");
			System.out.println("\n\t 항목이 존재하지 않아 삭제할 수 없습니다.");
		}
		
	}
	
	// 자료구조 내 요소 수정(변경) 메소드
	public static void chaElement() throws IOException
	{		
		System.out.print("\n\t 변경할 요소 입력 : ");
		String str = br.readLine();
		int i = vt.indexOf(str);
		System.out.println();

		if (vt.contains(str))
		{
			System.out.print("\n\t 수정할 내용 입력 : ");
			String str2 = br.readLine();
			vt.set(i, str2);
			System.out.println();
			
			System.out.println("\n\t [변경 결과 출력]");
			System.out.println("\n\t 변경이 완료되었습니다.");
		}
		else
		{
			System.out.println("\n\t [변경 결과 출력]");
			System.out.println("\n\t 변경할 대상이 존재하지 않습니다.");
		}
	}
	
	// 프로그램 종료 메소드 → 완성
	public static void exit()
	{
		System.out.println("\n\t프로그램을 종료");
		System.exit(-1);
	}
	
	// main() 메소드	→ 완성
	public static void main(String[] args) throws IOException, NumberFormatException
	{

		do
		{
			menuDisp();
			menuSelect();
			menuRun();
		}
		while (true);
		
	}
}