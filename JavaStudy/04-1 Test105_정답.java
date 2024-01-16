/*=======================================
■■■ 만년 달력 ■■■
- 다음과 같은 기능의 프로그램을 구현한다.
=======================================*/

// 실행 예)
// 『연도』를 입력하세요 : 2023
// 『월』을 입력하세요   : 9

/*
	[ 2023년 9월]

  일  월  화  수  목  금  토
============================
					  1   2
  3   4   5   6   7   8   9
 10  11  12  13  14  15  16
 17  18  19  20  27  22  23
 24  25  26  27  28  29  30
============================
계속하려면 아무 키나 누르세요...
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
public class Test105
{
	public static void main(String[] args) throws IOException
	{
		/* 내가 한거
		Scanner sc = new Scanner(System.in);
		
		int inputYear, inputMonth;
		int fullYear, fullMonth=0, fullDay;
		int start=1;
		int d; // 나머지
		int[] result;
		int[] monthDay = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

		System.out.print("『연도』를 입력하세요 : ");
		inputYear = sc.nextInt();
		System.out.print("『월』을 입력하세요   : ");
		inputMonth = sc.nextInt();
		System.out.println();

		if (inputYear%4==0 && inputYear%100!=0 || inputYear%400==0)	// 입력받은 연도가 윤년인지 평년인지 계산
		{
			monthDay[1] = 29;
		}

		fullYear = (inputYear-1)*365 + (inputYear-1)/4 - (inputYear-1)/100 + (inputYear-1)/400;	// 입력한 연도 전년도까지 일수 계산
		
		for (int i=0; i<inputMonth-1; i++)														// 입력하기 전 월까지 일수 계산
		{
			fullMonth+=monthDay[i];
		}

		fullDay = fullYear + fullMonth;
		d = fullDay%7;
		
		result = new int[monthDay[inputMonth-1]+d+1];

		for (int i=d+1; i<result.length; i++)
		{
			result[i] = start;
			start++;
		}
		

		System.out.printf("	[%5d년 %3d월]\n",inputYear,inputMonth);
		System.out.println("\n  일  월  화  수  목  금  토");
		System.out.print("============================\n");

		for (int i=0; i<result.length; i++)
		{
			if (i>0 && i%7==0)
				System.out.println();
			
			if (i<=d)
				System.out.printf("%4c", ' ');
			else if(i>d)
				System.out.printf("%4d",result[i]);
		}
		System.out.print("\n============================\n");*/

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		// 배열인덱스  0   1   2   3   4   5   6   7   8   9  10  11
		// 월		   1   2   3   4   5   6   7   8   9  10  11  12

		int nalsu, y, m, w;		//-- 날 수, 년, 월, 요일

		do
		{
			System.out.print("『연도』를 입력하세요 : ");
			y = Integer.parseInt(br.readLine());
		}
		while (y<1);

		do
		{
			System.out.print("『월』을 입력하세요   : ");
			m = Integer.parseInt(br.readLine());
		}
		while (m>12);


		if (y%4==0 && y%100!=0 || y%400==0)		// 윤년이라면...
		{
			days[1] = 29;
		}
		// else 구문은
		// 현재 days 배열의 1번째 요소(2월)가 28일로 구성되어 있는 상태이기 때문에
		// 생략이 가능한 구문이 된다.

		// 1년 1월 1일 ~ 입력받은 연도의 이전 년도 12월 31일 까지의 날 수 계산
		nalsu = (y-1)*365 + (y-1)/4 - (y-1)/100 + (y-1)/400;

		// 입력받은 연도(해당 연도) 1월 1일 ~ 입력받은 월의 이전 월까지의 날 수 계산
		for (int i=0; i<(m-1); i++)
		{
			nalsu += days[i];		// 날 수 하나에 계속 누적함 개천재야
		}

		// 입력받은 월의 1일을 날 수 누적연산 (앞까지는 전월 31일 혹은 30일 혹은 ...)
		nalsu += 1;			// ++nalsu;


		//---------------------------------------------------- 여기까지 수행하면 모든 날 수에 대한 종합 처리 완료

		// 요일 확인
		//-- 입력받은 연의 입력월의 1일이 무슨 요일인지 확인하기 위한 연산
		w = nalsu % 7;
		//-- w:0 → 일요일
		//   w:1 → 월요일
		//   w:2 → 화요일
		//       :

		//----------------------------------- 요기까지 수행하면 해당 연도 해당 월의 1일이 무슨 요일인지 확인 완료

		
		// 출력(달력 그리기)

		System.out.println();
		System.out.printf("\t[ %d년 %d월 ]\n",y,m);		// \t tab 한 번 만큼 띄움
		System.out.println();
		System.out.println("  일  월  화  수  목  금  토");
		System.out.println("============================");
		
		// 특정 요일부터 1일이 출발할 수 있도록 공백 발생(지정)
		for (int i=1; i<=w; i++)
		{
			System.out.print("    ");			//-- 공백 4칸 지정
		}

		//확인
		//System.out.printf("%4d",1);

		// 해당 월(입력한 월)의 날짜만 출력될 수 있도록 반복문 구성
		for (int i=1; i<=days[m-1]; i++)
		{
			System.out.printf("%4d",i);
			w++;
			//-- 반복문을 통해 날짜를 처리하는 동안
			//   그만큼의 요일도 함께 증가할 수 있도록 처리~!!!

			// 일요일을 구성하려는 경우...
			// (즉, 이번에 출력하고자 하는 날짜가 일요일인 경우...)
			if (w%7==0)
			{
				// 개행
				System.out.println();
			}
		}
		
		// 달의 마지막 날자가 출력 형식을 모두 채웠을 경우
		// (즉, 토요일까지 라인 전체 출력이 이루어졌을 경우)
		// 이미 일요일 개행이 이루어졌기 때문
		// 이 경우에는 추가 개행을 하지 않도록 처리~!!!
		if (w%7!=0)
			System.out.println();
		
		System.out.println("============================");

	}
}

// 최종 결과

/*
『연도』를 입력하세요 : 2023
『월』을 입력하세요   : 9

        [ 2023년 9월 ]

  일  월  화  수  목  금  토
============================
                       1   2
   3   4   5   6   7   8   9
  10  11  12  13  14  15  16
  17  18  19  20  21  22  23
  24  25  26  27  28  29  30
============================
계속하려면 아무 키나 누르십시오 . . .

*/