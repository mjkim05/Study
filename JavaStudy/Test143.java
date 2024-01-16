/*=============================================
  ■■■ 자바의 기본 프로그래밍 ■■■
  - 자바에서 기본적으로 제공하는 주요 클래스
  - Calendar 클래스
==============================================*/

/*
○ java.util.Calendar 클래스는 
   날짜와 시간을 객체 모델링와 한 클래스로 
   연, 월, 일, 요일, 시, 분, 초까지의 
   시간과 날짜와 관련된 정보를 제공한다.
   그리고, Calendar클래스는 추상클래스이므로 직접 객체를 생성할 수 없으며
   실제적인 메소드 구현은 Calendar 클래스의 서브 클래스인 
   GregorianCalendar 클래스에 정의되어 있다.

   시스템으로부터 현재 시스템 시간 정보를 얻어올 때
   getInstance()라는 정적(static) 메소드를 ㅣㅇ용하여 객체를 생성할 수 있다.
   생성된 Calendar 클래스 객체는 시스템의 현재 날자와 시간 정보를 가지며,
   이 객체가 생성되면 갖고있는 시간 정보들은
   get() 메소드를 이용하여 쉽게 가져올(사용할) 수 있다.

   getInstance() 메소드는 내부적으로 GregorianCalendar 객체를 생성하여 
   반환해주기 때문에 GregorianCalendar 객체를 직접 생성하여 날짜 시간 정보를 
   구할 수 있다.

○ 실습 문제
   
   사용자로부터 연, 월을 입력 받아
   달력을 그려주는 (출력하는) 프로그램을 구현한다.
   단, Calendar 클래스를 활용하여 작성 할 수 있도록 한다.
   ※ API Document 참조하여 getActualMaximum() 메소드 활용방법 검토할 것~~!!

실행 예)
연도 입력 : 0
연도 입력 : 2024
월 입력 : -10
월 입력 : 13
월 입력 : 5


	 [2024년 5월]

일 월 화 수 목 금 토
====================
          1  2  3  4
 5  6  7  8  9  10 11
 12 13 14 15 16 17 18
 19 20 21 22 23 24 25
 26 27 28 29 30 31
 =====================
 계속하려면 아무키나 누르세요...


*/
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Test143
{
	public static void main(String[] args) throws IOException
	{
		/*
		Calendar c = Calendar.getInstance();
		Scanner sc = new Scanner(System.in);
		
		int y, m;		// 연, 월

		// 사용자로부터 연,월 입력 받기
		do
		{
			System.out.print("연도 입력 : ");
			y = sc.nextInt();
		}
		while (y <= 0 );

		do
		{
			System.out.print("월 입력 : ");
			m = sc.nextInt();
		}
		while ( 12 < m || m < 0 );

		// 사용자로부터 입력 받은 값을 넣기
		c.set(y,m-1,1);
		
		// 요일정하기
		int w = c.get(Calendar.DAY_OF_WEEK);		
	

		// 출력문 작성
		System.out.println();
		System.out.printf("\t[%5d년 %2d월]\n", y, m);
		System.out.println();
		System.out.println("   일  월  화  수  목  금  토");
		System.out.println("  =============================");
		
		// 요일 시작 전까지 공백이 되도록 하기
		for (int i=0; i<w-1; i++)
		{	
			System.out.printf("%4c",' ');
		}
		
		// 1일부터 getActualMaximum(Calendar.DATE)까지 반복하도록 하기
		// getActualMaximum(Calendar.DATE) → DATE 맥시멈까지 반복되도록 하기
		for (int i = 1; i<=c.getActualMaximum(Calendar.DATE); i++)
		{	
			System.out.printf("%4d" , i);
			
			if (i == (c.getActualMaximum(Calendar.DATE)))
			{
				break;
			}

			//토요일마다 개행 되도록 하기
			if (w%7==0)
			{
				System.out.println(); 
			}
			w++;
		}
		
		// 달의 마지막 날짜가 출력 형식을 모두 채웠을 경우
		// (즉, 토요일까지 라인 전체 출력이 이루어졌을 경우)
		// 이미 일요일 개행이 이루어졌기 때문
		// 이 경우에는 추가 개행을 하지 않도록 처리~!!!
		if (w%7!=0)
			System.out.println();

		System.out.println("  =============================");
		*/
		// 함께 푼 코드 ---------------------------------------------------------------

		//BufferedReader 인스턴스 생성
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		//Calendar 인스턴스 생성
		Calendar cal = Calendar.getInstance();

		//주요 변수 선언
		int y,m;				//연월
		int w;					//요일
		int i;					// 루프변수

		do
		{
			System.out.print("연도 입력 : ");
			y = Integer.parseInt(br.readLine());
		}
		while (y<1);
		
		do
		{
			System.out.print("월 입력 : ");
			m = Integer.parseInt(br.readLine());
		}
		while (m<1 || 12<m);

		// 사용자로부터 입력받은 연(y),월(m)을 이용하여
		// 달력의 날짜 세팅
		cal.set(y,m-1,1);
		//-- 월 구성시 입력값을 그대로 사용하는 것이 아니라
		//   입력값에서 1을 뺀 으로 월을 설정해야한다.
		//-- 일 구성시 입력받은 연, 월에 해당하는 1일로 설정해야한다.
		//	 1일의 요일을 확인해야 달력을 그릴 수 있다.

		//세팅된 달력의 날짜로부터 요일 가져오기
		w = cal.get(Calendar.DAY_OF_WEEK);

		//테스트(확인)
		//System.out.println("w : " + w);
		//--==>> 연도 입력 : 2023
		//		 월 입력 : 12
		//		 w : 6						 2023년 12월 기준 → 금요일 → 2023년 12월 1일 금요일~!!

		// 결과 출력 → 달력 그리기
		System.out.println();
		System.out.println("\t["+y + "년 " + m + "월 ]\n");
		System.out.println("  일  월  화  수  목  금  토");
		System.out.println("==============================");
		for (i=1; i<w; i++)
		{
			System.out.print("    ");//공백 4칸 발생
		}

		//테스트(확인)
		//System.out.printf("%4d", 1);

		//System.out.println(cal.getActualMaximum(Calendar.DATE));
		
		//Calendar 클래스 『getActualMaximum()』메소드			check~~~!!	
		for (i=1; i<=cal.getActualMaximum(Calendar.DATE); i++)
		{
			System.out.printf("%4d",i);
			w++;								//-- 반복문을 수행하여 날짜가 증가할때마다
												//   요일도 함께 증가할 수 있도록 처리
			if (w%7==1)							//-- 이렇게 증가한 요일이 일요일이 될때마다									
				System.out.println();			//   개행후 출력될 수 있도록 처리
			
		}
		if (w%7!=1)
			System.out.println();
		
		System.out.println("==============================");





		
	}
}

//실행결과
/*
연도 입력 : 2023
월 입력 : 05

        [ 2023년  5월]

   일  월  화  수  목  금  토
  =============================
       1   2   3   4   5   6
   7   8   9  10  11  12  13
  14  15  16  17  18  19  20
  21  22  23  24  25  26  27
  28  29  30  31
  =============================
계속하려면 아무 키나 누르십시오 . . .

연도 입력 : 2024
월 입력 : 5

        [2024년 5월 ]

  일  월  화  수  목  금  토
==============================
               1   2   3   4
   5   6   7   8   9  10  11
  12  13  14  15  16  17  18
  19  20  21  22  23  24  25
  26  27  28  29  30  31
==============================
계속하려면 아무 키나 누르십시오 . . .

연도 입력 : 2024
월 입력 : 2

// 윤년 체크

        [2024년 2월 ]

  일  월  화  수  목  금  토
==============================
                   1   2   3
   4   5   6   7   8   9  10
  11  12  13  14  15  16  17
  18  19  20  21  22  23  24
  25  26  27  28  29
==============================
계속하려면 아무 키나 누르십시오 . . .

연도 입력 : 2023
월 입력 : 2

        [2023년 2월 ]

  일  월  화  수  목  금  토
==============================
               1   2   3   4
   5   6   7   8   9  10  11
  12  13  14  15  16  17  18
  19  20  21  22  23  24  25
  26  27  28
==============================
계속하려면 아무 키나 누르십시오 . . .



*/