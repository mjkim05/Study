/*========================================
  ���� ���� �帧�� ��Ʈ�� (���) ����
  - if ��
  - if ~ else ��
==========================================*/
//1. ���α׷��� �ۼ��Ҷ� �־��� ���ǿ� ����
//   �б� ������ ���ϱ� ���� ����ϴ� �������
//   if��, if ~ else��, ���ǿ�����, ����if��(if�� ��ø), switch���� �ִ�.
//	 

//2. if���� if������ ������ ���� ���
//   Ư�� ������ �����ϰ��� �� �� ���Ǵ� �����̴�.

// ����ڷκ��� ������ �� ������ �����ڸ� �Է� �޾�
// �ش� �������� ���� ó�� ����� ����ϴ� ���α׷��� �����Ѵ�.
// ��, if ���ǹ��� Ȱ���Ͽ� ó�� �� �� �ֵ��� �ϸ�,
// ���� ����� ���ǻ� ���� ������� ó�� �� �� �ֵ��� �Ѵ�.

// ���� ��)
// ù ��° ���� �Է� : 10
// ù ��° ���� �Է� : 3
// ������ �Է�[+ - * /] : +

// >> 10 + 3 = 13
// ����Ϸ��� �ƹ�Ű�� ��������...


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;


public class Test035
{
	public static void main(String[] args) throws IOException
	{
		/*
		
		//�ֿ� ���� ����
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		//���� �ۼ��� �ڵ� -------------------------------------------------------------------------------------------------
		
		int num1, num2;			//����ڰ� �Է��� �ΰ��� ����
		int result = 0;			// ���� ���
		char ch;				//����ڰ� �Է��� ������
		
		//���� �� ó��
		//����ڿ��� ���� �Է¹ޱ�
		System.out.print("ù ��° ���� �Է� : ");
		num1 = Integer.parseInt(br.readLine());
		System.out.print("�� ��° ���� �Է� : ");
		num2 = Integer.parseInt(br.readLine());

		//����ڿ��� ������ �Է¹ޱ�
		System.out.print("������ �Է�[+ - * /] : ");
		ch = (char)System.in.read();

		if (ch == '+')
		{
			result = num1 + num2;
		}
		else if (ch == '-')
		{
			result = num1 - num2;
		}
		else if (ch == '*')
		{
			result = num1 * num2;
		}
		else if (ch == '/')
		{
			result = num1 /num2;
		}
		else 
		{
			System.out.println("�Ǻ� �Ұ�");
		}

		System.out.println();
		System.out.printf(" >> %d %c %d = %d \n ", num1, ch, num2, result);
		*/
		//------------------------------------------------------------------------------------------------------------------

		// �����ϸ� ���� �ۼ��� �ڵ� ---------------------------------------------------------------------------------------

		// �����
		/*
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	   
	    int a, b, op;				//ù ��°, �� ��° ����, ������

	    System.out.print("ù ��° ���� �Է� : ");
	    a = Integer.parseInt(br.readLine());
	    System.out.print("�� ��° ���� �Է� : ");
	    b = Integer.parseInt(br.readLine());
	   
	    //Integer.parseInt
	    // "1234" �� Integer.parseInt �� 1234
	    // "abcd" �� Integer.parseInt ��	 (��)

	    System.out.print("������ �Է�[+ - * /] : ");
	    //op = (char)Integer.parseInt(br.readLine());	�õ����� ����
		//op = (char)System.in.read();				//(char)���� �� ��ȯ ���� ���� ~~!!! 
		op = System.in.read();						//op�� int�� �� ��� �̷��� �ϱ�

		//�׽�Ʈ (Ȯ��)
		//System.out.println("�Է��� ������ : " + op);

		//'+' �� 43 / '-' �� 45 / '*' �� 42 /'/' �� 47

		if (op==43)			//����ڰ� �Է��� �����ڰ� '+'�̶��
		{
			//a�� b�� ���� ������ �����Ͽ� ��� ���
			System.out.printf("\n >> %d + %d = %d\n", a, b, (a+b));
		}
		else if (op==45)	//����ڰ� �Է��� �����ڰ� '-'�̶��
		{
			//a�� b�� ���� ������ �����Ͽ� ��� ���
			System.out.printf("\n >> %d - %d = %d\n", a, b, (a-b));
		}
		else if (op==42)	//����ڰ� �Է��� �����ڰ� '*'�̶��
		{
			//a�� b�� ���� ������ �����Ͽ� ��� ���
			System.out.printf("\n >> %d * %d = %d\n", a, b ,(a*b));
		}
		else if (op==47)	//����ڰ� �Է��� �����ڰ� '/'�̶��
		{
			//a�� b�� ������ ������ �����Ͽ� ��� ���
			System.out.printf("\n >> %d / %d = %d\n", a,b,(a/b));
		}
		else				//����ڰ� �Է��� �����ڰ� �⺻ ��Ģ �����ڰ� �ƴ϶��....
		{
			System.out.println("\n �Է� ������ ������ �����մϴ�.");
		}

		*/
		
		//��� ��
		/*
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	   
	    int a, b;			// ù ��°, �� ��° ����
		char op;			// ������												

	    System.out.print("ù ��° ���� �Է� : ");
	    a = Integer.parseInt(br.readLine());
	    System.out.print("�� ��° ���� �Է� : ");
	    b = Integer.parseInt(br.readLine());
	   
	   
	    System.out.print("������ �Է�[+ - * /] : ");
		op = (char)System.in.read();				

		
		if (op == '+')			
			System.out.printf("\n >> %d + %d = %d\n", a, b, (a+b));
		else if (op == '-')	
			System.out.printf("\n >> %d - %d = %d\n", a, b, (a-b));
		else if (op == '*')	
			System.out.printf("\n >> %d * %d = %d\n", a, b ,(a*b));
		else if (op == '/')
			System.out.printf("\n >> %d / %d = %d\n", a,b,(a/b));
		else				
			System.out.println("\n �Է� ������ ������ �����մϴ�.");

		*/
		//��� ��
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int a, b, result=0;
		char op;

		System.out.print("ù ��° ���� �Է� : ");
		a = Integer.parseInt(br.readLine());
		System.out.print("�� ��° ���� �Է� : ");
		b = Integer.parseInt(br.readLine());
		System.out.print("������ �Է� [+ - * /] : ");
		op = (char)System.in.read();

		if (op == '+')
			result = a + b;
		else if (op == '-')
			result = a - b;
		else if (op == '*')
			result = a * b;
		else if (op == '/')
			result = a / b;

		System.out.printf("%d %c %d = %d\n", a, op, b, result);


		//------------------------------------------------------------------------------------------------------------------
	}
}

/*
��� �� ������
ù ��° ���� �Է� : 50
�� ��° ���� �Է� : 2
������ �Է�[+ - * /] : /

 >> 50 / 2 = 25
����Ϸ��� �ƹ� Ű�� �����ʽÿ� . . .

��� �� ������
ù ��° ���� �Է� : 50
�� ��° ���� �Է� : 2
������ �Է�[+ - * /] : /

 >> 50 / 2 = 25
����Ϸ��� �ƹ� Ű�� �����ʽÿ� . . .

����� ���� ���
ù ��° ���� �Է� : 50
�� ��° ���� �Է� : 2
������ �Է� [+ - * /] : /
50 / 2 = 25
����Ϸ��� �ƹ� Ű�� �����ʽÿ� . . .

*/


//���� �ڵ� ���� ���
/*
ù ��° ���� �Է� : 10
�� ��° ���� �Է� : 8
������ �Է�[+ - * /] : +

 >> 10 + 8 = 18
 ����Ϸ��� �ƹ� Ű�� �����ʽÿ� . . .

ù ��° ���� �Է� : 8
�� ��° ���� �Է� : 2
������ �Է�[+ - * /] : -

 >> 8 - 2 = 6
 ����Ϸ��� �ƹ� Ű�� �����ʽÿ� . . .

ù ��° ���� �Է� : 9
�� ��° ���� �Է� : 3
������ �Է�[+ - * /] : *

 >> 9 * 3 = 27
 ����Ϸ��� �ƹ� Ű�� �����ʽÿ� . . .

ù ��° ���� �Է� : 25
�� ��° ���� �Է� : 5
������ �Է�[+ - * /] : /

 >> 25 / 5 = 5
 ����Ϸ��� �ƹ� Ű�� �����ʽÿ� . . .

 */
