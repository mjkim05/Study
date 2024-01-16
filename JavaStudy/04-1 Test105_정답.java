/*=======================================
���� ���� �޷� ����
- ������ ���� ����� ���α׷��� �����Ѵ�.
=======================================*/

// ���� ��)
// ���������� �Է��ϼ��� : 2023
// �������� �Է��ϼ���   : 9

/*
	[ 2023�� 9��]

  ��  ��  ȭ  ��  ��  ��  ��
============================
					  1   2
  3   4   5   6   7   8   9
 10  11  12  13  14  15  16
 17  18  19  20  27  22  23
 24  25  26  27  28  29  30
============================
����Ϸ��� �ƹ� Ű�� ��������...
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
public class Test105
{
	public static void main(String[] args) throws IOException
	{
		/* ���� �Ѱ�
		Scanner sc = new Scanner(System.in);
		
		int inputYear, inputMonth;
		int fullYear, fullMonth=0, fullDay;
		int start=1;
		int d; // ������
		int[] result;
		int[] monthDay = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

		System.out.print("���������� �Է��ϼ��� : ");
		inputYear = sc.nextInt();
		System.out.print("�������� �Է��ϼ���   : ");
		inputMonth = sc.nextInt();
		System.out.println();

		if (inputYear%4==0 && inputYear%100!=0 || inputYear%400==0)	// �Է¹��� ������ �������� ������� ���
		{
			monthDay[1] = 29;
		}

		fullYear = (inputYear-1)*365 + (inputYear-1)/4 - (inputYear-1)/100 + (inputYear-1)/400;	// �Է��� ���� ���⵵���� �ϼ� ���
		
		for (int i=0; i<inputMonth-1; i++)														// �Է��ϱ� �� ������ �ϼ� ���
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
		

		System.out.printf("	[%5d�� %3d��]\n",inputYear,inputMonth);
		System.out.println("\n  ��  ��  ȭ  ��  ��  ��  ��");
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
		// �迭�ε���  0   1   2   3   4   5   6   7   8   9  10  11
		// ��		   1   2   3   4   5   6   7   8   9  10  11  12

		int nalsu, y, m, w;		//-- �� ��, ��, ��, ����

		do
		{
			System.out.print("���������� �Է��ϼ��� : ");
			y = Integer.parseInt(br.readLine());
		}
		while (y<1);

		do
		{
			System.out.print("�������� �Է��ϼ���   : ");
			m = Integer.parseInt(br.readLine());
		}
		while (m>12);


		if (y%4==0 && y%100!=0 || y%400==0)		// �����̶��...
		{
			days[1] = 29;
		}
		// else ������
		// ���� days �迭�� 1��° ���(2��)�� 28�Ϸ� �����Ǿ� �ִ� �����̱� ������
		// ������ ������ ������ �ȴ�.

		// 1�� 1�� 1�� ~ �Է¹��� ������ ���� �⵵ 12�� 31�� ������ �� �� ���
		nalsu = (y-1)*365 + (y-1)/4 - (y-1)/100 + (y-1)/400;

		// �Է¹��� ����(�ش� ����) 1�� 1�� ~ �Է¹��� ���� ���� �������� �� �� ���
		for (int i=0; i<(m-1); i++)
		{
			nalsu += days[i];		// �� �� �ϳ��� ��� ������ ��õ���
		}

		// �Է¹��� ���� 1���� �� �� �������� (�ձ����� ���� 31�� Ȥ�� 30�� Ȥ�� ...)
		nalsu += 1;			// ++nalsu;


		//---------------------------------------------------- ������� �����ϸ� ��� �� ���� ���� ���� ó�� �Ϸ�

		// ���� Ȯ��
		//-- �Է¹��� ���� �Է¿��� 1���� ���� �������� Ȯ���ϱ� ���� ����
		w = nalsu % 7;
		//-- w:0 �� �Ͽ���
		//   w:1 �� ������
		//   w:2 �� ȭ����
		//       :

		//----------------------------------- ������ �����ϸ� �ش� ���� �ش� ���� 1���� ���� �������� Ȯ�� �Ϸ�

		
		// ���(�޷� �׸���)

		System.out.println();
		System.out.printf("\t[ %d�� %d�� ]\n",y,m);		// \t tab �� �� ��ŭ ���
		System.out.println();
		System.out.println("  ��  ��  ȭ  ��  ��  ��  ��");
		System.out.println("============================");
		
		// Ư�� ���Ϻ��� 1���� ����� �� �ֵ��� ���� �߻�(����)
		for (int i=1; i<=w; i++)
		{
			System.out.print("    ");			//-- ���� 4ĭ ����
		}

		//Ȯ��
		//System.out.printf("%4d",1);

		// �ش� ��(�Է��� ��)�� ��¥�� ��µ� �� �ֵ��� �ݺ��� ����
		for (int i=1; i<=days[m-1]; i++)
		{
			System.out.printf("%4d",i);
			w++;
			//-- �ݺ����� ���� ��¥�� ó���ϴ� ����
			//   �׸�ŭ�� ���ϵ� �Բ� ������ �� �ֵ��� ó��~!!!

			// �Ͽ����� �����Ϸ��� ���...
			// (��, �̹��� ����ϰ��� �ϴ� ��¥�� �Ͽ����� ���...)
			if (w%7==0)
			{
				// ����
				System.out.println();
			}
		}
		
		// ���� ������ ���ڰ� ��� ������ ��� ä���� ���
		// (��, ����ϱ��� ���� ��ü ����� �̷������ ���)
		// �̹� �Ͽ��� ������ �̷������ ����
		// �� ��쿡�� �߰� ������ ���� �ʵ��� ó��~!!!
		if (w%7!=0)
			System.out.println();
		
		System.out.println("============================");

	}
}

// ���� ���

/*
���������� �Է��ϼ��� : 2023
�������� �Է��ϼ���   : 9

        [ 2023�� 9�� ]

  ��  ��  ȭ  ��  ��  ��  ��
============================
                       1   2
   3   4   5   6   7   8   9
  10  11  12  13  14  15  16
  17  18  19  20  21  22  23
  24  25  26  27  28  29  30
============================
����Ϸ��� �ƹ� Ű�� �����ʽÿ� . . .

*/