/*==================================
   ���� Ŭ������ �ν��Ͻ� ����
	- Ŭ������ �ν��Ͻ� Ȱ��
  ==================================*/
  
  // 1 ~ 3 ������ ������ �߻����Ѽ�
  // ����, ����, �� ���� ���α׷��� �����Ѵ�.
  // �� Ŭ������ ������ Ȱ���Ͽ� ó���� �� �ֵ��� �Ѵ�.
  // ���� �迭�� Ȱ���Ͽ� ó���� �� �ֵ��� �Ѵ�.
  // ���������� RpsGame Ŭ���� �ϼ� �� �� �ֵ��� �Ѵ�.
  
  // �� ���� ������ �� 1.���� 2.���� 3.��

  // ���� ��) 
  // 1.���� 2.���� 3.�� : 4
  // 1.���� 2.���� 3.�� : -2
  // 1.���� 2.���� 3.�� : 2

  // - ����	  : ���� 
  // - ��ǻ�� : ��

  // >> �º� ���� ��� : ��ǻ�� �̰���ϴ�~!!
  // ����Ϸ��� �ƹ� Ű�� ��������

import java.util.Random;
import java.util.Scanner;

class RpsGame
{
	// �ֿ� ���� ����		
	int n;										// ����ڰ� �Է��� ����
	int rd;										// ���� ���� ��Ƶ� ���� 
	String[] arr = {" ","����", "����", "��"};		// ����,����,�� ���� ���� 

	// �ֿ� ��� ����
	// �� ����ڷκ��� ���������� �Է� �޴� ���
	void input()
	{
		Scanner sc = new Scanner(System.in);
		do
		{
			System.out.print("1.���� 2.���� 3.�� : ");
			n = sc.nextInt();
		}
		while (3<n || n<1);
		
	}
		
	// �� ���� �߻� ��Ű��
	void RanInput()
	{
		Random rdc = new Random();
		rd = rdc.nextInt(3)+1;	
	}

	// �� ���ϰ� ����ϱ�
	void print()
	{
		System.out.println(" - ����   : " + arr[n]);
		System.out.println(" - ��ǻ�� : " + arr[rd]);

		/*if ( n < rd )
		{
			System.out.println("")
		}
		*/
	}
}

public class Test102
{
	public static void main(String[] args)
	{
		RpsGame rg = new RpsGame();
		rg.input();
		rg.print();
	}
}