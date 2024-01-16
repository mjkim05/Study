/*==========================================================
	���� Ŭ������ �ν��Ͻ� ����
	�� ������ (Constructor)�� �ʱ�ȭ ��(Initialized Block)
  =========================================================*/



public class Test078
{
	
	// ������ �� ����
	/*
	int n;
	int m;

	n=100;
	m=200;
	*/

	// ���� ���� 
	/*
	int n = 100;
	int m = 200;
	*/

	int n;
	int m;

	// ������(Constructor)
	Test078()
	{
		n = 100;
		m = 200;
		System.out.println("������ ����... ");
	}
	

	// �ʱ�ȭ ��(Initialized Block)	
	{
		n = 10;
		m = 20;
		System.out.println("�ʱ�ȭ �� ����...");
	}

	Test078(int n , int m)
	{
		this.n = n;
		this.m = m;
		System.out.println("�Ű����� �ִ� ������ ����...");
	}

	// ��� ��� �޼ҵ�
	void write()
	{
	System.out.println("n: " + n + ", m: " + m);
	}

	public static void main(String[] args)
	{
		Test078 ob1 = new Test078();
		ob1.write();
		//--==>> �ʱ�ȭ �� ����...
		//		 ������ ����...
		//		 n: 100, m: 200
		//		 ����Ϸ��� �ƹ� Ű�� �����ʽÿ� . . .
		Test078 ob2 = new Test078(222, 333);
		ob2.write();

		//--==>> �ʱ�ȭ �� ����...
		//		 �Ű����� �ִ� ������ ����...
		//		 n: 222, m: 333
	}
}