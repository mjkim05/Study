/*=================================
���� Ŭ������ �ν��Ͻ� ����
- Ŭ������ �ν��Ͻ� Ȱ��
=================================*/

// 1 ~ 3 ������ ������ �߻����Ѽ�
// ����, ����, �� ���� ���α׷��� �����Ѵ�.
// ��, Ŭ������ ������ Ȱ���Ͽ� ó���� �� �ֵ��� �Ѵ�.
// ����, �迭�� Ȱ���Ͽ� ó���� �� �ֵ��� �Ѵ�.
// ���������� RpsGame Ŭ������ �ϼ��� �� �ֵ��� �Ѵ�.

// �� ���� ������ �� 1:����, 2:����, 3:��

// ���� ��)
// 1:����, 2:����, 3:�� �� �Է�(1~3) : 4
// 1:����, 2:����, 3:�� �� �Է�(1~3) : -2
// 1:����, 2:����, 3:�� �� �Է�(1~3) : 2

// - ����   : ����
// - ��ǻ�� : ��

// >> �º� ���� ��� : ��ǻ�Ͱ� �̰���ϴ�~!!!
// ����Ϸ��� �ƹ� Ű��...

import java.util.Scanner;
import java.util.Random;

class RpsGame
{
	private int user;
	private int com;

	// ��ǻ���� ����������
	private void runCom()
	{
		Random rd = new Random();
		com = rd.nextInt(3) + 1;
	}

	// ������ ����������
	public void input()
	{
		// ����ڰ� ���������� �ϱ� ����... ��ǻ��(������) ���� ����������
		runCom();
		Scanner sc = new Scanner(System.in);
		do
		{			
			System.out.print("1: ����, 2: ����, 3: �� �� �Է�(1~3) : ");
			user = sc.nextInt();
		}
		while (user>3 || user<1);
	}

	// �߰� ��� ���
	public void middleCalc()
	{
		String[] str = {"����", "����", "��"};	//-- 1 2 3 �� 0 1 2

		System.out.println();
		System.out.println("- ����   : " + str[user-1]);
		System.out.println("- ��ǻ�� : " + str[com-1]);
	}

	// �ºο� ���� ���� ��� ����
	// - �����ϴ�~!!!
	// - ����� �¸��߽��ϴ�~!!!
	// - ��ǻ�Ͱ� �¸��߽��ϴ�~!!!
	public String resultCalc()
	{
		String result = "���º� ��Ȳ�Դϴ�~!!!";

		// ���� ó������ ������� ��Ģ�� ã���� ���� �ʾƵ� �˴ϴ�~ �ֳ��ϸ� �츮�� ���� ���� �ܰ�ϱ�!!

		// (����=="����" ��=="��") (����=="����" ��=="����") (����=="��" ��=="����")
		// (����=="����" && ��=="��") || (����=="����" && ��=="����") || (����=="��" && ��=="����")
		if ((user==1 && com==3) || (user==2 && com==1) || (user==3 && com==2))
		{
			result = "����� �¸��߽��ϴ�~!!!";
		}

		// (����=="����" ��=="����") (����=="����" ��=="��") (����=="��" ��=="����")
		// (����=="����" && ��=="����") || (����=="����" && ��=="��") || (����=="��" && ��=="����")
		else if ((user==1 && com==2) || (user==2 && com==3) || (user==3 && com==1))
		{
			result = "��ǻ�Ͱ� �¸��߽��ϴ�~!!!";
		}

		return result;
	}

	// ��� �߷�
	public void print(String str)
	{
		System.out.printf("%n>> �º� ���� ��� : %s%n", str);
	}

	/*�����Ѱ�
	int num, com;
	String[] rps = {"����", "����", "��"};

	public void play()
	{
		Scanner sc = new Scanner(System.in);
		do
		{
			System.out.print("1:����, 2:����, 3:�� �� �Է�(1~3) : ");
			num = sc.nextInt();
		}
		while (num>3 || num<1);
		random();
	}

	private void random()
	{
		Random rd = new Random();
		com = rd.nextInt(3);
	}

	public void result()
	{
		System.out.println();
		System.out.println("- ����   : " + rps[num-1]);
		System.out.println("- ��ǻ�� : " + rps[com]);
		System.out.println();

		if (num-1 == com)
		{
			System.out.print(">> �º� ���� ��� : ���̽��ϴ�!\n");
		}
		else if ((num-1)-com==1 || (num-1)-com==-2)
		{
			System.out.print(">> �º� ���� ��� : ����ڰ� �̰���ϴ�~!!\n");
		}
		else
			System.out.print(">> �º� ���� ��� : ��ǻ�Ͱ� �̰���ϴ�~!!\n");

	}*/
}


public class Test102
{
	public static void main(String[] args)
	{
		RpsGame ob = new RpsGame();
		/*ob.play();
		ob.result();*/
		
		ob.input();
		ob.middleCalc();
		String result = ob.resultCalc();
		ob.print(result);
	}
}

/*
1: ����, 2: ����, 3: �� �� �Է�(1~3) : 2

- ����   : ����
- ��ǻ�� : ����

>> �º� ���� ��� : ����� �¸��߽��ϴ�~!!!
����Ϸ��� �ƹ� Ű�� �����ʽÿ� . . .
*/