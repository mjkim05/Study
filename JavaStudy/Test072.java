/*======================================
	���� Ŭ������ �ν��Ͻ� ����
  ======================================*/

// ����ڷκ��� ������ ������ �Է� �޾�
// 1���� �Է¹��� �� ������ ���� �����Ͽ�
// ������� ����ϴ� ���α׷��� �����Ѵ�.

// ��, ���ݱ���ó�� main()�޼ҵ忡 ��� ����� �����ϴ� ���� �ƴ϶�
// Ŭ������ �ν��Ͻ��� ������ Ȱ���Ͽ� ó�� �� �� �ֵ��� �Ѵ�.
// Hap Ŭ���� ����
// ����, ������ �Է� ó�� �������� BufferedReader �� redaLine()�� ����ϸ�,
// �Է� �����Ͱ� 1���� �۰ų� 1000���� ū ���
// �ٽ� �Է� ���� �� �ִ� ó���� �����Ͽ� ���α׷��� ������ �� �ֵ��� �Ѵ�

// ���� ��)
// ������ ���� �Է� (1~1000) : 1200
// ������ ���� �Է� (1~1000) : -500
// ������ ���� �Է� (1~1000) : 100
// >> 1���� 100������ ��  : 5050
// ��� �Ϸ��� �ƹ�Ű�� ��������...

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/*
class Hap
{
	int n;												//������ ����
											
	// �Է� ���
	void input() throws IOException
	{
		
		do
		{	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("������ ���� �Է� : ");
			n = Integer.parseInt(br.readLine());
		}
		while (1>n || 1000<n);							//������ ������ 1���� ũ�� 1000���� ���������� �ݺ�
	}

	
	// ������ ��� ���
	int sum()
	{
		int s=0;										//������ �������� �� �ʱ�ȭ

		for (int i=1; i<=n ; i++)
		{
		
			s +=i;
		}

		return s;
	}
	
	// ��� ��� ���
	void print(int a)
	{
		System.out.printf("\n>> 1���� %d������ �� : %d\n" ,n, a);
	}

}


public class Test072
{
	public static void main(String[] args) throws IOException
	{
		// HapŬ���� �ν��Ͻ� ����
		Hap ob = new Hap();
		
		// �Է� �޼ҵ� ȣ��
		ob.input();
		
		// ������ �޼ҵ� ȣ��
		int result = ob.sum();
		
		// ��� �޼ҵ� ȣ��
		ob.print(result);

		
	}
}
*/

class Hap
{
	//�ֿ� ���� ����(������� �Է� ���� ��Ƴ� ����)
	int su;

	// �Է� �޼ҵ� ����
	void input() throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		do
		{
			System.out.print("������ ���� �Է� (1~1000) : ");
			su = Integer.parseInt(br.readLine());
		}
		while (su<1 || su>1000);

	}

	// ���� ó�� �޼ҵ� ����
	int calculate()
	{
		int result = 0;
		for (int i=1; i<=su; i++)
		{
			result +=i;
		}

		return result;
	}

	// ��� ó�� �޼ҵ� ����

	void print(int sum)
	{
		System.out.printf("\n >> 1���� %d������ �� : %d\n", su, sum);
	}
}


public class Test072
{
	public static void main(String[] args) throws IOException
	{
		//Hap �ν��Ͻ� ����
		Hap ob = new Hap();

		//������ �ν��Ͻ��� ���� �Է� �޼ҵ� ȣ��
		//-----------------------
		//     ���� ���� Ȱ��
		
		ob.input();							//-- new Hap().input(); �̷��Ե� ����~~ 

		// ������ �ν��Ͻ��� ���� ���� �޼ҵ� ȣ��
		int s = ob.calculate();

		// ������ �ν��Ͻ��� ���� ��� �޼ҵ� ȣ��
		//ob.print(ob.calculate.());
		ob.print(s);
	}
}


//������

/*
������ ���� �Է� : 100

>> 1���� 100������ �� : 5050
����Ϸ��� �ƹ� Ű�� �����ʽÿ� . . .

������ ���� �Է� (1~1000) : 1999
������ ���� �Է� (1~1000) : 665

 >> 1���� 665������ �� : 221445
����Ϸ��� �ƹ� Ű�� �����ʽÿ� . . .


*/