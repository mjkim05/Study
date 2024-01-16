
import java.util.Random;
import java.util.Scanner;

import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedReader;

public class card1
{


	public static void main(String[] args) throws IOException
	{
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		Random rd = new Random();

		
		int y; // 카드 선택

		int x; // 신규/재 발급
		int s; // 신용카드/ 체크카드 

	    int a, b ,c , d, e, f, g, h, i , j, k, l, m, n, o;;  //-- 카드번호 변수
		int p, q, r;									     //-- cvc 변수
		 
		String name;// 이름
		String card;

		String str; // 주민번호
		String phone; // 전화번호
			
		int w = 0;



		while (w ==0)
		{

			System.out.print("신규발급(1) / 재발급(2) : ");
			x = Integer.parseInt(br.readLine());
			System.out.println();

			if (x == 1)
			{
				System.out.print("신용카드 발급 (1) / 체크카드 발급(2) : ");
				s =  Integer.parseInt(br.readLine());
				System.out.println();

			


		if (s==1)
		{
			System.out.println("1번 카드(비자 가능) ");
			System.out.println("┌───────────────────────────────────────────────┐");
			System.out.println("│◀ SS쌍용카드 신용                   ┌─────┐   │  ");
			System.out.println("│                                     │ visa│   │  ");
			System.out.println("│                                     └─────┘   │  ");
			System.out.println("│ ┌──────┐                                      │  ");
			System.out.println("│ │┙ ━   │     ──────────────────────────────── │  ");
			System.out.println("│ │┭┼ ┐  │	                                │  ");
			System.out.println("│ └──────┘                                      │  ");
			System.out.println("│                                               │  ");
			System.out.println("│   ******-**-******    **/**                   │  ");
			System.out.println("│   *********       CVC ***                     │  ");
			System.out.println("│                                        [**]   │  ");
			System.out.println("└───────────────────────────────────────────────┘");
			System.out.println();


			System.out.println("2번 카드(비자, 교통카드 가능) ");
			System.out.println("┌───────────────────────────────────────────────┐");
			System.out.println("│◀ SS쌍용카드 신용                   ┌─────┐   │  ");
			System.out.println("│                                     │ visa│   │  ");
			System.out.println("│                                     └─────┘   │  ");
			System.out.println("│ ┌──────┐                                      │  ");
			System.out.println("│ │┙ ━   │     ──────────────────────────────── │  ");
			System.out.println("│ │┭┼ ┐  │	                                │  ");
			System.out.println("│ └──────┘                                      │  ");
			System.out.println("│                                               │  ");
			System.out.println("│   ******-**-******    **/**                   │  ");
			System.out.println("│   *********       CVC ***                     │  ");
			System.out.println("│                                        [교통] │  ");
			System.out.println("└───────────────────────────────────────────────┘");



			System.out.print("카드를 선택해 주세요. (1, 2)          : ");
			y = Integer.parseInt(br.readLine());
		
			if (y == 1)
			{

				System.out.print("\n이름을 입력하세요(영문 공백 구분) : ");
				name = sc.nextLine();

	
		
		
		
		int[] chk = { 2, 3, 4, 5, 6, 7, 0, 8, 9, 2, 3, 4, 5};
								 
									 
		int tot=0;
		
		System.out.print("\n주민번호입력(XXXXXX-XXXXXXX)      : ");		
		str = br.readLine();

		System.out.print("\n전화번호를 입력하세요.( - 구분)   : ");
		phone = sc.nextLine();


	   
	
		if (str.length() !=14)
		{
			System.out.print(">> 주민번호 자릿 수 입력 오류~!!!");
					
		}

		
		for (int z=0; z<13; z++)
		{
			
			if (z==6)
			{
				continue;
			}

			tot += chk[z] * Integer.parseInt(str.substring(z, (z+1)));	
		}

	

		int su = 11 - tot % 11;


		su = su % 10;	

		
		
		if (su == Integer.parseInt(str.substring(13)))
		{
			w = 1;

			System.out.println();
			System.out.println(">> 정확한 정보 입력으로 카드가 발급됩니다"); 
			
			System.out.println("      《고객님의 카드가 발급중 입니다.》");
			System.out.println("      ˇ ˇ                       ˇˇ ");
			System.out.println("      ˇ ˇ    ┌─────────┐        ˇˇ ");
			System.out.println("      ˇ ˇ    │         │        ˇˇ ");
			System.out.println("      ˇ ˇ    │  |   |  │        ˇˇ ");
			System.out.println("      ˇ ˇ    │  |   |  │        ˇˇ ");
			System.out.println("      ˇ ˇ    │  |   |  │        ˇˇ ");
			System.out.println("      ˇ ˇ    │  |   |  │        ˇˇ ");
			System.out.println("      ˇ ˇ    │  |   |  │        ˇˇ ");
			System.out.println("      ˇ ˇ    │  |   |  │        ˇˇ ");
			System.out.println("      ˇ ˇ    │  |   |  │        ˇˇ ");
			System.out.println("      ˇ ˇ    │  V V V  │        ˇˇ ");
			System.out.println("      ˇ ˇ    └─────────┘        ˇˇ ");
			System.out.println("      ˇ ˇ                       ˇˇ ");



			a = rd.nextInt(8) + 1;
			b = rd.nextInt(9);
			c = rd.nextInt(9);
			d = rd.nextInt(9);
			e = rd.nextInt(9);
			f = rd.nextInt(9);
			g = rd.nextInt(9);
			h = rd.nextInt(9);
			i = rd.nextInt(9);
			j = rd.nextInt(9);
			k = rd.nextInt(9);
			l = rd.nextInt(9);
			m = rd.nextInt(9);
			n = rd.nextInt(9);
			o = rd.nextInt(9);



			p = rd.nextInt(9);
			q = rd.nextInt(9);
			r = rd.nextInt(9);
		
		System.out.println(">> 선택하신 1번 카드가 정상적으로 발급되었습니다.\n");
		System.out.println("┌───────────────────────────────────────────────┐");
		System.out.println("│◀ SS쌍용카드 신용                   ┌─────┐   │  ");
		System.out.println("│                                     │ VISA│   │  ");
		System.out.println("│                                     └─────┘   │  ");
		System.out.println("│ ┌──────┐                                      │  ");
		System.out.println("│ │┙ ━   │     ──────────────────────────────── │  ");
		System.out.println("│ │┭┼ ┐  │	                                │  ");
		System.out.println("│ └──────┘                                      │  ");
		System.out.println("│                                               │  ");
		System.out.printf("│   %d%d%d%d%d%d-%d%d-%d%d%d%d%d%d%d    28/10                  │  \n" ,a, b ,c , d, e, f, g, h, i , j, k, l, m, n, o);
		System.out.printf("│   %15s       CVC %d%d%d               │  \n", name, p, q, r);
		System.out.println("│                                        [교통] │  ");
		System.out.println("└───────────────────────────────────────────────┘");
	
			
		}
	    else
		{
			System.out.println();
			System.out.println(">> 잘못된 주민번호로 본인인증 실패 ");
			System.out.println(">> 처음 화면으로 돌아갑니다. ");
			
		}
		System.out.println();
		return;
		


			

			}

		}// end if

		}// end if

		if (x == 2)
		{
			System.out.print("카드 번호를 입력하세요 : ");
			card = sc.nextLine();
		}

		}// end while

		
		









		
	

	}
}