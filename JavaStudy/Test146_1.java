/*=============================================
  ■■■ 자바의 기본 프로그래밍 ■■■
  - 자바에서 기본적으로 제공하는 주요 클래스
  - Random 클래스
==============================================*/

/*
○ java.util.Random 클래스는 

   여러 형태의 난수를 발생시켜 제공하는 클래스이다.
   Math 클래스의 정적 메소드인 random()메소드도 난수를 제공하는 메소드이지만 
   0.0~ 1.0 사이의 실수 형태만 발생하게 되므로 
   필요한 형태의 난수를 만들어내기 위해서는 추가적인 연산을 여러 형태로 수행해야 한다.
   그래서 자바는 여러 형태의 난수를 발생시켜주는
   전용 클래스인 Random클래스를 별도로 제공하고 있다.	

*/

/*
 로또 번호 생성(난수 발생 프로그램)

 프로그램이 실행되면 
 기본적으로 로또 5게임을 수행하는 프로그램을 수현한다.

 실행 예 )
   3  12  15 24 31 41
   1  12  18 36 41 42
   4   9  12 13 22 30
   5  10  13 14 22 40
   22 31  36 40 43 44

계속하려면 아무니카 누르세요

*/

import java.util.Random;
import java.util.Arrays;

class Lotto
{
	//배열 변수 선언 및 메모리 할당 → 로또 번호를 담아둘 배열방 6칸
	private int[] num; 

	// 생성자
	Lotto()
	{
		num = new int[6];
	}

	//getter
	public int[] getNum()
	{	
		
		return num;
	}

	//6개의 난수를 발생시키는 메소드 정의
	public void start()
	{
	
		//Random 인스턴스 생성
		Random rd = new Random();
		int n; 
		int cnt = 0;

		jump:
		// 변수명 : 
		// 빈번 한 사용 Ⅹ 지이이잉이인짜 어쩌다 한번

		while (cnt < 6)					//cnt → 0 1 2 3 4 5
		{
			n = rd.nextInt(45) + 1;		//0~44 → 『+ 1』 → 1 ~ 45
			
			for (int i=0; i<cnt; i++)
			{
				// num[i] 번째 요소와 n울 비교
				if (num[i] == n)
					continue jump;
				   	// jump:라고 되어있는 위치로 이동 됨
					// 즉, 난수를 다시 만들어 보자는 뜻~!!
					// 이미 안에 들어있던 요소가 달라지는 것은 Ⅹ → cnt 값은 줄어들지 않기 때문에
			}

			num[cnt++] = n;
		}
		
		//정렬 메소드 호출
		sorting();
	}

	// 정렬 메소드 정의
	private void sorting() 
	{
		Arrays.sort(num);
	}

}

public class Test146_1
{
	public static void main(String[] args)
	{
		//Lotto 클래스 인스턴스 생성
		Lotto lotto = new Lotto();


		//기본 5게임 
		for (int i = 1; i<=5; i++)
		{
			//로또 1게임 수행
			lotto.start();
		
			
			//결과 출력
			for(int n : lotto.getNum())
				System.out.printf("%3d", n);
			System.out.println();
					
			
		}
		


	}
}

//실행결과

/*

  3  8 15 27 29 37
 18 25 26 37 41 44
  2  3  9 19 29 39
  8 13 22 24 28 30
 12 18 26 30 36 40
계속하려면 아무 키나 누르십시오 . . .

  1  3  8 16 30 39
 11 16 22 32 39 42
  2  3 29 33 36 39
  1 12 14 27 35 45
  2  3  5  9 15 18
계속하려면 아무 키나 누르십시오 . . .

  1  6  7 18 19 43
  6 10 14 23 33 45
  6 11 23 24 31 40
  1  3 10 15 34 38
  2  3 14 16 17 39
계속하려면 아무 키나 누르십시오 . . .


*/