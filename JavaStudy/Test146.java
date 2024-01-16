/*=============================================
  ���� �ڹ��� �⺻ ���α׷��� ����
  - �ڹٿ��� �⺻������ �����ϴ� �ֿ� Ŭ����
  - Random Ŭ����
==============================================*/

/*
�� java.util.Random Ŭ������ 

   ���� ������ ������ �߻����� �����ϴ� Ŭ�����̴�.
   Math Ŭ������ ���� �޼ҵ��� random()�޼ҵ嵵 ������ �����ϴ� �޼ҵ������� 
   0.0~ 1.0 ������ �Ǽ� ���¸� �߻��ϰ� �ǹǷ� 
   �ʿ��� ������ ������ ������ ���ؼ��� �߰����� ������ ���� ���·� �����ؾ� �Ѵ�.
   �׷��� �ڹٴ� ���� ������ ������ �߻������ִ�
   ���� Ŭ������ RandomŬ������ ������ �����ϰ� �ִ�.	

*/

/*
 �ζ� ��ȣ ����(���� �߻� ���α׷�)

 ���α׷��� ����Ǹ� 
 �⺻������ �ζ� 5������ �����ϴ� ���α׷��� �����Ѵ�.

 ���� �� )
   3  12  15 24 31 41
   1  12  18 36 41 42
   4   9  12 13 22 30
   5  10  13 14 22 40
   22 31  36 40 43 44

����Ϸ��� �ƹ���ī ��������

*/

import java.util.Random;

class Lotto
{
	//�迭 ���� ���� �� �޸� �Ҵ� �� �ζ� ��ȣ�� ��Ƶ� �迭�� 6ĭ
	private int[] num; 

	// ������
	Lotto()
	{
		num = new int[6];
	}

	//getter
	public int[] getnum()
	{	
		
		return num;
	}

	//6���� ������ �߻���Ű�� �޼ҵ� ����
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
		
		/* ���߿� �ٽ� Ǯ���.....����???����....
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

	// ���� �޼ҵ� ����
	private void sorting() 
	{
		for (int i=1; i<num.length; i++)				
		{																		
			for (int j=0; j<num.length -i ; j++)		
			{													
				if (num[j] > num[j+1])					
				{
					// �ڸ� �ٲٱ�
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
		//Lotto Ŭ���� �ν��Ͻ� ����
		Lotto lotto = new Lotto();
		int[] num = lotto.getnum();

		//�⺻ 5���� 
		for (int i = 1; i<=5; i++)
		{
			//�ζ� 1���� ����
			lotto.start();
		
			
			//��� ���
			for (int j=0; j<num.length; j++)
			{		
				System.out.printf("%3d", num[j]);
			}
			System.out.println();
			
		}
		


	}
}

//������
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
����Ϸ��� �ƹ� Ű�� �����ʽÿ� . . .
*/