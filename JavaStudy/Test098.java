/*====================================================================================
   ���� Ŭ������ �ν��Ͻ� ����
   - ���� ���а� �������������� (����������, ���� ������, ���� ������, ���� ������ ��)
  ===================================================================================*/

// ���� CireleTest2 �� Test098�� ���� ����Ű���� �ȿ� �ִ�.

import java.util.Scanner;

class CircleTest2
{	
	// ��� ����, �ν��Ͻ� ����, ���� ����
	//int num;

	//	��

	// ���� ����(information Hiding)
	// ��private���̶�� ���������������� ������
	// Ŭ���� ���ο����� ���� �� ������ �����ϰ� �ϰڴٴ� �ǹ�
	// int�� ���� ���� �� �ڵ����� 0���� �ʱ�ȭ ����

	private int num;

	//getter / setter ����

	/*
	public int getNum()
	{
		return num;
	}


	public setNum(int num)
	{
		this.num = num;
	}
	
	*/

	public void input()
	{
		Scanner sc = new Scanner(System.in);

		System.out.print("������ �Է� : ");
		num = sc.nextInt();
	}

	public double calArea()
	{
		return num * num * 3.141592;
	}

	public void write(double area)
	{
		System.out.println(">> ������ : " + num);
		System.out.println(">> ���� : " + area);
	}
}


public class Test098
{
	public static void main(String[] args)
	{	
		//CircleTest2�� �ν��Ͻ� ����
		CircleTest2 ob1 = new CircleTest2();

		//ob1.num = 10;
		//	  ��
		//ob1.setNum(10);
		
		//System.out.println("���� ������ : " + ob1.num);
		//			   ��
		//System.out.println("���� ������ : " + ob1.getNum());


		// �� ����ν�� �����ϰ� 
		//	  CircleTest2�� num ���̷��� ������ �� �ִ� ���
		ob1.input();
		//--==>> ������ �Է� : 500
		//		 ��ob1.num = 500;��
	
		double result = ob1.calArea();

		ob1.write(result);
		
	}
}

//���� ���
/*
������ �Է� : 500
>> ������ : 500
>> ���� : 785398.0
����Ϸ��� �ƹ� Ű�� �����ʽÿ� . . .
*/