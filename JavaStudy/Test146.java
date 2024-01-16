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
	public int[] getnum()
	{	
		
		return num;
	}

	//6개의 난수를 발생시키는 메소드 정의
	public void start()
	{
		//Random rd = new Random();
		
		Random rd = new Random();
		
		for (int i=0; i<num.length; i++)
		{			
			num[i] = rd.nextInt(45)+1;

			for 
				(int j=0; j<i; j++)
			{
				if (num[i] == num[j])
				{
					i--;
					
	
				}
			}
		}
		
		/* 나중에 다시 풀어보기.....언제???ㅎㅎ....
		for (int i = 0 ; i<num.length; i++)
		{	
			boolean flag;
			int n;

			do
			{	
			  n = rd.nextInt(45)+1;
			  flag = false;

				for (int j = 0; j<i; j++)
				{
					if (num[j] == n );
					{
						flag = true;
						break;
					}					
				}	
						
			} while (flag);
			num[i] = n;
		}
		*/
		sorting();
	}

	// 정렬 메소드 정의
	private void sorting() 
	{
		for (int i=1; i<num.length; i++)				
		{																		
			for (int j=0; j<num.length -i ; j++)		
			{													
				if (num[j] > num[j+1])					
				{
					// 자리 바꾸기
					num[j] = num[j]^num[j+1];
					num[j+1] = num[j+1]^num[j];
					num[j] = num[j]^num[j+1];

				}
			}
		}
	}
}

public class Test146
{
	public static void main(String[] args)
	{
		//Lotto 클래스 인스턴스 생성
		Lotto lotto = new Lotto();
		int[] num = lotto.getnum();

		//기본 5게임 
		for (int i = 1; i<=5; i++)
		{
			//로또 1게임 수행
			lotto.start();
		
			
			//결과 출력
			for (int j=0; j<num.length; j++)
			{		
				System.out.printf("%3d", num[j]);
			}
			System.out.println();
			
		}
		


	}
}

//실행결과
/*
  5 11 13 28 32 35
  2  5 10 12 16 19
 16 18 20 24 31 42
  1  2  4  8 21 32
  4  8  9 13 21 45

   4 11 15 18 25 29
  2 22 27 30 35 38
  5 16 22 31 38 42
  9 12 30 32 40 45
  3  5 19 29 43 45
계속하려면 아무 키나 누르십시오 . . .
*/