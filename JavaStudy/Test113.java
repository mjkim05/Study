/*==========================
  ���� Ŭ���� ��� ����
  - ��� (Inheritance)
=============================*/

// ������ ���� ���α׷��� �����Ѵ�.
// ��, ����� ������ �����Ͽ� �ۼ� �� �� �ֵ��� �Ѵ�.

// ���� ��)
// ������ �� ���� �Է� (���鱸��) : 
// ������ �Է� (+ - * /) :
// >> 20 - 10 = 10.00
// ����Ϸ��� �ƹ�Ű�� ��������

import java.util.Scanner;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Aclass
{
	protected int x, y;
	protected char op;

	Aclass()
	{
		
	}

	void write(double result)
	{
		System.out.printf("\n >> %d %c %d = %.2f\n", x, op, y, result);
	}
}

/*
//Aclass�� ��� �޴� Ŭ������ ����
class Bclass extends Aclass
{	

	// ������� ���� �Է� �޴� ����� �ϴ� �޼ҵ�
	void input() throws IOException
	{	
		// Scanner Ŭ���� �ν��Ͻ� ����
		Scanner sc = new Scanner(System.in);
		System.out.print("������ �� ���� �Է�(���鱸��) : ");
		x = sc.nextInt();
		y = sc.nextInt();
		System.out.print("������ �Է� (+ - * /) : ");
		op = (char)System.in.read();
	}

	double result()
	{
		double r=0;
		if (op == '+')
			r = x + y;
		else if (op == '-')
			r = x - y;
		else if (op == '*')
			r = x * y;
		else if (op == '/')
			r = (double)x / y;
		else 
			System.out.println("�߸��� ������ �Դϴ�!!");

		return r;
	}
	
	void print(double r)
	{
		write(r);
	}
	
}
*/

//Aclass�� ��� �޴� Ŭ������ ����
class Bclass extends Aclass
{
	/* ��� ����
	
	protected int x, y;
	protected char op;

	void write(double result)
	{
		System.out.printf("\n >> %d %c %d = %.2f\n", x, op, y, result);
	}
	
	*/

	Bclass()
	{
		// super();								// �ڽ����ν� �θ�Ŭ������ �޸𸮿� �ִ� å�� �� �ϳ�
	}
	
	//void input()								// ���� ���� ��
	boolean input()	throws IOException			// �̷��Ե� �����ϴ�~ ��� �� ����
	{
		//Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("������ �� ���� �Է�(���鱸��) :");				// "20 10"
		String temp = br.readLine();

		// �� ���ڿ�.split("������");
		//	  ���ڿ�.split("\\s");			// -- ������ �� ����(\s)
		//
		//	ex) "10 20 30 40 50".split("\\s");
		//		�� ��ȯ ��{"10", "20", "30", "40", "50"}
		//	ex) "010-1234-5678".split("-");
		//		�� ��ȯ ��{"010", "1234", "5678"};

		String[] strArr = temp.split("\\s");				// "20 10" �� String[] strArr = {"20", "10"};

		//if (temp.length() != 2)
		if (strArr.length != 2)
			return false;
		
		// -- false �� ��ȯ�Ͽ� input() �޼ҵ� ����
		//	  �� ������ �����Ͽ� if���� �����ϰ� �� ���
		//	  �Ʒ� �����ؾ� �� �ڵ尡 �����ִ���
		//	  �����(��false)�� ��ȯ�Ͽ� �޼ҵ�� ����ȴ�.

		x = Integer.parseInt(strArr[0]);
		y = Integer.parseInt(strArr[1]);

		// this.x = Integer.parseInt(strArr[0]);
		// super.x = Integer.parseInt(strArr[0]);
		// �� ���� �ǹ��̴�.

		System.out.print("������ �Է� (+ - * /) : ");
		op = (char)System.in.read();
		
		/*
		if (op != '+' && op != '-' && op != '*' && op != '/')
		{
			return false;
		}
	
		return true;
		*/
		
		if (op =='+' || op == '-' || op == '*' || op == '/')
		{
			return true;
		}
		return false;

	}// and input()

	double calc()
	{
		double result = 0;
	
		switch (op)
		{
		case '+': result = x + y; break;
		case '-': result = x - y; break;
		case '*': result = x * y; break;
		//case '/': result = x / y; break;
		//case '/': result = x / y; 
		case '/': result = (double)x / y; 

		}
		
		return result;
	}// end calc()

	/*	 ���� ���� ��¹��� �����ϱ� ��¹� ���� ���ص� ��
	print()
	{
		
	}
	*/
}

//main() �޼ҵ带 �����ϰ� �ִ� �ܺ��� �ٸ� Ŭ����
public class Test113
{
	public static void main(String[] args) throws IOException
	{	
		/*
		// Bclass Ŭ���� �ν��Ͻ� ����
		Bclass ob = new Bclass();
		ob.input();
		double a = ob.result();
		ob.print(a);
		*/

		//Bclass Ŭ���� �ν��Ͻ� ����
		Bclass ob = new Bclass();
		
		// �� ������ �ڵ�� ��� ���� �ǹ� 
		//ob.input();
		/*
		boolean resp = ob.input();
		
		if (resp != true)
		{
			System.out.println("Error....");
			return;								//-- ���α׷� ����
		}
		*/
		/*
		boolean resp = ob.input();
		
		if (!resp)
		{
			System.out.println("Error....");
			return;								//-- ���α׷� ����
		}
		*/
		
		if (!ob.input())
		{
			System.out.println("Error....");
			return;								//-- ���α׷� ����
		}

		double result = ob.calc();

		ob.write(result);
		
		


	}
}

//������
/*
������ �� ���� �Է�(���鱸��) : 3 5
������ �Է� (+ - * /) : +

 >> 3 + 5 = 8.00
����Ϸ��� �ƹ� Ű�� �����ʽÿ� . . .

������ �� ���� �Է�(���鱸��) :86 52
������ �Է� (+ - * /) : /

 >> 86 / 52 = 1.65
����Ϸ��� �ƹ� Ű�� �����ʽÿ� . . .

������ �� ���� �Է�(���鱸��) :50 8
������ �Է� (+ - * /) : =
Error....
����Ϸ��� �ƹ� Ű�� �����ʽÿ� . . .




*/