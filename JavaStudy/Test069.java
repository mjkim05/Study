/*======================================
	���� ���������� �������� ����
  �� ���������� �ʱ�ȭ �׽�Ʈ �� ����
  ======================================*/

// Test 068.java�� ��~~!!!



public class Test069
{
	// Ŭ������ ����
	
	// ���� ���� a ���� //��� ����, �ν��Ͻ� ���� ������ �Ҹ�
	int a;
	// -- �ڵ����� 0���� �ʱ�ȭ ����
	
	boolean b;
	char c;
	double d;

	public static void main(String[] args)
	{
		//�޼ҵ� ����

		//System.out.println("a: " + a);
		//--==>> ���� �߻�(������ ����)
		//       non-static variable a cannot be referenced from a static context

		// Test069 Ŭ������ ������� �ν��Ͻ� ����
		Test069 ob = new Test069();

		System.out.println("ob.a : " + ob.a);
		//--==>> ob.a : 0

		System.out.println("ob.b : " + ob.b);
		System.out.println("ob.c : " + ob.c);
		System.out.println("ob.d : "+ ob.d);

		//--==>> ob.b : false
		//		 ob.c :
		//		 ob.d : 0.0

	}

}