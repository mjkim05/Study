
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

		
		int y; // ī�� ����

		int x; // �ű�/�� �߱�
		int s; // �ſ�ī��/ üũī�� 

	    int a, b ,c , d, e, f, g, h, i , j, k, l, m, n, o;;  //-- ī���ȣ ����
		int p, q, r;									     //-- cvc ����
		 
		String name;// �̸�
		String card;

		String str; // �ֹι�ȣ
		String phone; // ��ȭ��ȣ
			
		int w = 0;



		while (w ==0)
		{

			System.out.print("�űԹ߱�(1) / ��߱�(2) : ");
			x = Integer.parseInt(br.readLine());
			System.out.println();

			if (x == 1)
			{
				System.out.print("�ſ�ī�� �߱� (1) / üũī�� �߱�(2) : ");
				s =  Integer.parseInt(br.readLine());
				System.out.println();

			


		if (s==1)
		{
			System.out.println("1�� ī��(���� ����) ");
			System.out.println("��������������������������������������������������������������������������������������������������");
			System.out.println("���� SS�ֿ�ī�� �ſ�                   ��������������   ��  ");
			System.out.println("��                                     �� visa��   ��  ");
			System.out.println("��                                     ��������������   ��  ");
			System.out.println("�� ����������������                                      ��  ");
			System.out.println("�� ���� ��   ��     ���������������������������������������������������������������� ��  ");
			System.out.println("�� ���Ѧ� ��  ��	                                ��  ");
			System.out.println("�� ����������������                                      ��  ");
			System.out.println("��                                               ��  ");
			System.out.println("��   ******-**-******    **/**                   ��  ");
			System.out.println("��   *********       CVC ***                     ��  ");
			System.out.println("��                                        [**]   ��  ");
			System.out.println("��������������������������������������������������������������������������������������������������");
			System.out.println();


			System.out.println("2�� ī��(����, ����ī�� ����) ");
			System.out.println("��������������������������������������������������������������������������������������������������");
			System.out.println("���� SS�ֿ�ī�� �ſ�                   ��������������   ��  ");
			System.out.println("��                                     �� visa��   ��  ");
			System.out.println("��                                     ��������������   ��  ");
			System.out.println("�� ����������������                                      ��  ");
			System.out.println("�� ���� ��   ��     ���������������������������������������������������������������� ��  ");
			System.out.println("�� ���Ѧ� ��  ��	                                ��  ");
			System.out.println("�� ����������������                                      ��  ");
			System.out.println("��                                               ��  ");
			System.out.println("��   ******-**-******    **/**                   ��  ");
			System.out.println("��   *********       CVC ***                     ��  ");
			System.out.println("��                                        [����] ��  ");
			System.out.println("��������������������������������������������������������������������������������������������������");



			System.out.print("ī�带 ������ �ּ���. (1, 2)          : ");
			y = Integer.parseInt(br.readLine());
		
			if (y == 1)
			{

				System.out.print("\n�̸��� �Է��ϼ���(���� ���� ����) : ");
				name = sc.nextLine();

	
		
		
		
		int[] chk = { 2, 3, 4, 5, 6, 7, 0, 8, 9, 2, 3, 4, 5};
								 
									 
		int tot=0;
		
		System.out.print("\n�ֹι�ȣ�Է�(XXXXXX-XXXXXXX)      : ");		
		str = br.readLine();

		System.out.print("\n��ȭ��ȣ�� �Է��ϼ���.( - ����)   : ");
		phone = sc.nextLine();


	   
	
		if (str.length() !=14)
		{
			System.out.print(">> �ֹι�ȣ �ڸ� �� �Է� ����~!!!");
					
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
			System.out.println(">> ��Ȯ�� ���� �Է����� ī�尡 �߱޵˴ϴ�"); 
			
			System.out.println("      �������� ī�尡 �߱��� �Դϴ�.��");
			System.out.println("      �� ��                       ���� ");
			System.out.println("      �� ��    ����������������������        ���� ");
			System.out.println("      �� ��    ��         ��        ���� ");
			System.out.println("      �� ��    ��  |   |  ��        ���� ");
			System.out.println("      �� ��    ��  |   |  ��        ���� ");
			System.out.println("      �� ��    ��  |   |  ��        ���� ");
			System.out.println("      �� ��    ��  |   |  ��        ���� ");
			System.out.println("      �� ��    ��  |   |  ��        ���� ");
			System.out.println("      �� ��    ��  |   |  ��        ���� ");
			System.out.println("      �� ��    ��  |   |  ��        ���� ");
			System.out.println("      �� ��    ��  V V V  ��        ���� ");
			System.out.println("      �� ��    ����������������������        ���� ");
			System.out.println("      �� ��                       ���� ");



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
		
		System.out.println(">> �����Ͻ� 1�� ī�尡 ���������� �߱޵Ǿ����ϴ�.\n");
		System.out.println("��������������������������������������������������������������������������������������������������");
		System.out.println("���� SS�ֿ�ī�� �ſ�                   ��������������   ��  ");
		System.out.println("��                                     �� VISA��   ��  ");
		System.out.println("��                                     ��������������   ��  ");
		System.out.println("�� ����������������                                      ��  ");
		System.out.println("�� ���� ��   ��     ���������������������������������������������������������������� ��  ");
		System.out.println("�� ���Ѧ� ��  ��	                                ��  ");
		System.out.println("�� ����������������                                      ��  ");
		System.out.println("��                                               ��  ");
		System.out.printf("��   %d%d%d%d%d%d-%d%d-%d%d%d%d%d%d%d    28/10                  ��  \n" ,a, b ,c , d, e, f, g, h, i , j, k, l, m, n, o);
		System.out.printf("��   %15s       CVC %d%d%d               ��  \n", name, p, q, r);
		System.out.println("��                                        [����] ��  ");
		System.out.println("��������������������������������������������������������������������������������������������������");
	
			
		}
	    else
		{
			System.out.println();
			System.out.println(">> �߸��� �ֹι�ȣ�� �������� ���� ");
			System.out.println(">> ó�� ȭ������ ���ư��ϴ�. ");
			
		}
		System.out.println();
		return;
		


			

			}

		}// end if

		}// end if

		if (x == 2)
		{
			System.out.print("ī�� ��ȣ�� �Է��ϼ��� : ");
			card = sc.nextLine();
		}

		}// end while

		
		









		
	

	}
}