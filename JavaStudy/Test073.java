/*======================================
	���� Ŭ������ �ν��Ͻ� ����
  ======================================*/

// ����ڷκ��� ������ �� ������ �����ڸ� �Է¹޾�
// �ش� ������ �����ϴ� ���α׷��� �����Ѵ�.
// ��, Ŭ������ �ν��Ͻ��� ������ Ȱ���Ͽ� �ۼ� �� �� �ֵ��� �Ѵ�.
// (Calculate) Ŭ���� ����

// ���� ��)
// ������ �� ���� �Է� (���� ����) : 100 51
// ������ ������ (+ - * /)		   : +

// >> 100 + 51 = 151;
// ����Ϸ��� �ƹ�Ű�� ��������

/*
import java.util.Scanner;
import java.io.IOException;


class Calculate
{
	int num1, num2;						// ������ �� ����
	char op;							// ������ ������
		

	// �Է� ��� �޼ҵ�
	void input()	throws IOException
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("������ �� ���� �Է�(���� ����) : ");
		num1 = sc.nextInt();
		num2 = sc.nextInt();

		System.out.print("������ ������ (+ - * /)	: ");
		op = (char)System.in.read();
	}

	// ���� ��� �޼ҵ�

	int result()
	{
		int sum = 0;

		if (op == '+')
		{
			sum = num1 + num2; 
		}

		else if (op == '-')
		{
			sum = num1 - num2;
		}
		else if (op == '*')
		{
			sum = num1 * num2;
		}
		else if (op == '/')
		{
			sum = num1 / num2;
		}

		return sum;
	}

	//��� ��� �޼ҵ�
	void print(int s)
	{
	System.out.printf("\n>> %d %c %d = %d\n", num1, op, num2, s);
	}
}

public class Test073
{
	public static void main(String[] args)	throws IOException
	{
	
		//Calculate Ŭ���� �ν��Ͻ� ����
		Calculate ob = new Calculate();
		
		// �Է� ��� �޼ҵ� ȣ��
		ob.input();

		// ���� ��� �޼ҵ� ȣ��
		int sum = ob.result();

		// ��� ��� �޼ҵ� ȣ��
		ob.print(sum);

	}

}

*/

//���� ���
/*
������ �� ���� �Է�(���� ����) : 80 8
������ ������ (+ - * /) : /

>> 80 / 8 = 10
����Ϸ��� �ƹ� Ű�� �����ʽÿ� . . .

������ �� ���� �Է�(���� ����) : 100 50
������ ������ (+ - * /) : +

>> 100 + 50 = 150
����Ϸ��� �ƹ� Ű�� �����ʽÿ� . . .

������ �� ���� �Է�(���� ����) : 100 88
������ ������ (+ - * /) : -

>> 100 - 88 = 12
����Ϸ��� �ƹ� Ű�� �����ʽÿ� . . .


������ �� ���� �Է�(���� ����) : 10 31
������ ������ (+ - * /) : *

>> 10 * 31 = 310
����Ϸ��� �ƹ� Ű�� �����ʽÿ� . . .

*/


// �Բ� Ǯ� �ڵ� ----------------------------------------------------------------------------------------------------------------------------------

import java.util.Scanner;
import java.io.IOException;

class Calculate
{
	//�ֿ� ���� ����
	int su1, su2;					//-- ����ڷκ��� �Է¹��� �� ������ ��Ƴ� ����
	char op;						//-- ����ڷκ��� �Է¹��� �����ڸ� ��Ƴ� ����

	//�޼ҵ� ���� (���: �Է�)
	void input()	throws IOException
	{
		Scanner sc = new Scanner(System.in);

		System.out.print("������ �� ���� �Է�(���� ����) : ");
		su1 = sc.nextInt();
		su2 = sc.nextInt();

		System.out.print("������ ������ (+ - * /) : ");
		op = (char)System.in.read();
	}

	// �޼ҵ� ����(��� : ����) �� ������ ���굵 ���� ������� ó��
	int cal()
	{
		int result = -1;

		switch (op)
		{
		case '+': result = su1 + su2; break;
		case '-': result = su1 - su2; break;
		case '*': result = su1 * su2; break;
		case '/': result = su1 / su2; break;
		//default : result = -1 

		
		}

		return result;
	}

	// �޼ҵ� ���� (���: ���)
	void print(int s)
	{
		System.out.printf("\n >> %d %c %d = %d\n", su1, op, su2, s);
	}

}

public class Test073  
{
	public static void main(String[] args) throws IOException
	{
		//Calculate �ν��Ͻ� ����
		Calculate cal = new Calculate();

		cal.input();		// -- ������ �ν��Ͻ��� ���� �Է� �޼ҵ� ȣ��
		int r = cal.cal();	// -- ������ �ν��Ͻ��� ���� ���� �޼ҵ� ȣ��
		cal.print(r);		// -- ������ �ν��Ͻ��� ���� ��� �޼ҵ� ȣ��
	}

}

//���� ���
/*
������ �� ���� �Է�(���� ����) : 100 89
������ ������ (+ - * /) : +

 >> 100 + 89 = 189
����Ϸ��� �ƹ� Ű�� �����ʽÿ� . . .

������ �� ���� �Է�(���� ����) : 50 3
������ ������ (+ - * /) : /

 >> 50 / 3 = 16
����Ϸ��� �ƹ� Ű�� �����ʽÿ� . . .

*/