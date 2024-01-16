/*=============================================
  ���� �ڹ��� �⺻ ���α׷��� ����
  - ��� ������
  - BufferedReader
  - printf()
==============================================*/

// ����ڷκ��� ������ ������ �ι� �Է¹޾�
// ��Ģ���� �� ������ ������ �����Ͽ�
// �� ����� ����ϴ� ���α׷��� �����Ѵ�.
// ��, �Է¹޴� ������ bufferedReader �� Ȱ�� �� �� �ֵ��� �ϰ�
// ��� �ϴ� ������ printf() �޼ҵ带 Ȱ���� �� �ֵ��� �Ѵ�
// ����, ������ ������ ���ǻ� ���� ������� ó���Ѵ�.

// ���� ��)
// ù ��° ���� �Է� : 10
// �� ��° ���� �Է� : 2
//
// =====[���]=====
// 10 + 2 = 12
// 10 - 2 = 8
// 10 * 2 = 20
// 10 / 2 = 5
// 10 % 2 = 0 

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Test021
{
	public static void main (String[] args) throws IOException
	{


		// ���� Ǯ� ���� ------------------------------------------------------------------
		/*
		//�ֿ� ���� ����
		//Ű���� ���� ����
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int a, b;		//����ڰ� �Է��� �ΰ��� ����
		int c, d, e, f, g; // ��Ģ���� ���� ����

		//���� �� ó��
		//����ڿ��� �ȳ� �޼��� ���
		System.out.print("ù ��° ���� �Է� : ");
		a = Integer.parseInt(br.readLine());
		System.out.print("�� ��° ���� �Է� : ");
		b = Integer.parseInt(br.readLine());

		c = a + b;			// ���� ����
		d = a - b;			// ���� ����
		e = a * b;			// ���� ���� 
		f = a / b;			// ������ ����
		g = a % b;			// ������ ����

		//��� ���
		System.out.printf("\n=====[���]=====\n");
		System.out.printf("%d + %d = %d\n", a, b, c);   //���� ��� ���
		System.out.printf("%d - %d = %d\n", a, b, d);	//���� ��� ���
		System.out.printf("%d * %d = %d\n", a, b, e);	//���� ��� ���
		System.out.printf("%d / %d = %d\n", a, b, f);	//������ ��� ���
		System.out.printf("%d %% %d = %d\n", a, b, g);	//������ ��� ���
		System.out.printf("================\n");
		*/
		
		//������
		/*
		ù ��° ���� �Է� : 10
		�� ��° ���� �Է� : 3

		=====[���]=====
		10 + 3 = 13
		10 - 3 = 7
		10 * 3 = 30
		10 / 3 = 3
		10 % 3 = 1
		================
		����Ϸ��� �ƹ� Ű�� �����ʽÿ� . . .

		*/
		//------------------------------------------------------------------------------------

		//�� ¦���� Ǯ� ���� --------------------------------------------------------------
		/*
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// �ֿ� ���� ����
		int num1, num2;
		int a, b, c, d, e;
      

		// ���� �� ó��
		System.out.print("ù ��° ���� �Է� : ");
		num1 = Integer.parseInt(br.readLine());
	
		System.out.print("�� ��° ���� �Է� : ");
		num2 = Integer.parseInt(br.readLine());

		a = num1 + num2;      // ����
		b = num1 - num2;      // ����
	    c = num1 * num2;      // ����
		d = num1 / num2;      // ������
		e = num1 % num2;      // ������


        // ��� ���
        System.out.printf("\n====[���]====");
        System.out.printf("\n%d + %d = %d", num1, num2, a);
        System.out.printf("\n%d - %d = %d", num1, num2, b);
        System.out.printf("\n%d * %d = %d", num1, num2, c);
        System.out.printf("\n%d / %d = %d", num1, num2, d);
        System.out.printf("\n%d %% %d = %d", num1, num2, e);
        System.out.printf("\n==============\n");
        */

		//------------------------------------------------------------------------------------

		// ���� �ϸ� ���� Ǯ�� �� ���� -------------------------------------------------------
		
		//�ֿ� ���� ����
		int num1 , num2;					// ����� �Է� ���� ���� ����
		int res1, res2, res3, res4, res5;	// ������ ���� ����� ���� ����

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//���� �� ó��
		System.out.print("ù ��° ���� �Է� : ");
		num1 = Integer.parseInt(br.readLine());
		
		System.out.print("�� ��° ���� �Է� : ");
		num2 = Integer.parseInt(br.readLine());

		res1 = num1 + num2;
		res2 = num1 - num2;
		res3 = num1 * num2;
		res4 = num1 / num2;
		res5 = num1 % num2;

		//��� ���
		System.out.printf("\n=====���=====\n");
		System.out.printf("%d + %d = %d\n", num1, num2, res1);
		System.out.printf("%d - %d = %d\n", num1, num2, res2);
		System.out.printf("%d * %d = %d\n", num1, num2, res3);
		System.out.printf("%d / %d = %d\n", num1, num2, res4);
		System.out.printf("%d %% %d = %d\n", num1, num2, res5); // --==>> %% �� %
		System.out.printf("================\n");
	

		

		//------------------------------------------------------------------------------------
					

	}

}

//������
/*
ù ��° ���� �Է� : 10
�� ��° ���� �Է� : 3

=====���=====
10 + 3 = 13
10 - 3 = 7
10 * 3 = 30
10 / 3 = 3
10 % 3 = 1
================
����Ϸ��� �ƹ� Ű�� �����ʽÿ� . . .
*/