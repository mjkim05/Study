/*=============================================
  ■■■ 자바의 기본 프로그래밍 ■■■
  - 자바에서 기본적으로 제공하는 주요 클래스
  - Calendar 클래스
==============================================*/

// ○ 오늘을 기준으로 입력받는 날짜만큼 후의 연, 월, 일, 요일을
//	  확인하여 결과를 출력하는 프로그램을 구현한다.

// 실행 예)
// 오늘 날짜 : 2023-9-19 화요일
// 몇 일 후의 날짜를 확인하고자 하십니까? : 200

// ===============[확인 결과]=============== 
// 200일 후 : XXXX. XX. XX. X요일
// =========================================

// Calendar와 관련 한 API Document 참조~~~
// 『add()』
//  : 현재 날짜를 기준으로 날 수 더하는 연산 메소드
//   → 『객체.add(Calendar.DATE, 날수);』

import java.util.Calendar;
import java.util.Scanner;

public class Test144
{
	public static void main(String[] args)
	{
		/*

		// Calendar 클래스 인스턴스 생성
		Calendar cal = Calendar.getInstance();

		Scanner sc = new Scanner(System.in);
		
		int n;				//날짜 변수
		
		int y = cal.get(Calendar.YEAR);
		int m = cal.get(Calendar.MONTH)+1;
		int d = cal.get(Calendar.DATE);
		int w = cal.get(Calendar.DAY_OF_WEEK);
		
		String[] strArr = {"일요일", "월요일", "화요일","수요일","목요일","금요일","토요일"};
		
		System.out.printf(" 오늘 날짜 : %d %d %d %s\n", y , m, d, strArr[w-1]);	

		System.out.print(" 몇 일 후의 날짜를 확인하고자 하십니까? :");
		n = sc.nextInt();

		//테스트(확인)
		//System.out.print(n);

		cal.add(Calendar.DATE, n);

		// 출력 문 작성
		// 200일 후 : XXXX. XX. XX. X요일
		System.out.println();
		System.out.println(" ===============[확인 결과]=============== ");
		System.out.printf(" %d일 후 : %d - %d - %d %s\n", n, cal.get(Calendar.YEAR),cal.get(Calendar.MONTH)+1,cal.get(Calendar.DATE),strArr[cal.get(Calendar.DAY_OF_WEEK)-1]);
		System.out.println(" ========================================= ");
		*/

		//Scanner 인스턴스 생성
		Scanner sc = new Scanner(System.in);

		//Calendar 인스턴스 생성
		Calendar now = Calendar.getInstance();

		//주요 변수 선언
		int nalsu;
		int y,m,d,w;
		String[] week = {"일","월","화","수","목","금","토"};

		//현재의 연, 월, 일, 요일(→ 가져오기 : get())
		y = now.get(Calendar.YEAR);
		m = now.get(Calendar.MONTH)+1;
		d = now.get(Calendar.DATE);
		w = now.get(Calendar.DAY_OF_WEEK);

		// 현재의 연 , 월, 일, 요일 확인 결과 출력
		System.out.println(" 오늘 날짜 : " + y +"-"+ m +"-"+ d + "-" + " " + week[w-1]+ "요일");
		
		do
		{
			System.out.print(" 몇 일 후의 날짜를 확인하고자 하십니까? : ");
			nalsu = sc.nextInt();
		}
		while (nalsu<1);
		
		//check~~!!
		now.add(Calendar.DATE, nalsu);
		
		// 결과 출력
		System.out.println();
		System.out.println(" ===============[확인 결과]=============== ");
		System.out.printf(" %d일 후: %tF %tA\n" , nalsu, now,now);
		System.out.println(" ========================================= ");
		
			
		// %t는 대체로 날짜 객체라고 생각하면 됨

		//String.format("%tF", 달력객체);
		// → 『년-월-일』 형태의 문자열 반환
		//String format("%tA", 달력 객체)
		// → 요일 형태의 문자열 반환


		
	}
}

//실행 결과
/*
 오늘 날짜 : 2023 9 19 화요일
 몇 일 후의 날짜를 확인하고자 하십니까? :200

 ===============[확인 결과]===============
 200일 후 : 2024 - 4 - 6 토요일
 =========================================
계속하려면 아무 키나 누르십시오 . . .

 오늘 날짜 : 2023-9-19- 화요일
 몇 일 후의 날짜를 확인하고자 하십니까? : -4
 몇 일 후의 날짜를 확인하고자 하십니까? : 5

 ===============[확인 결과]===============
 5일 후: 2023-09-24 일요일
 =========================================
계속하려면 아무 키나 누르십시오 . . .


*/