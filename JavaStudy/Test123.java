/*==========================
  ���� Ŭ���� ��� ����
  - ��ø Ŭ����
============================*/

//outer 
class Test2
{
	static int a =10;
	int b = 20;

	void write()									// -- ù ��° write()�޼ҵ�
	{
		System.out.println("write()....��");
		final int c = 20;
		int d = 40;
		
		//inner 
		// �޼ҵ� �ȿ� �����ϴ� �Ǵٸ� Ŭ����(���� Ŭ����, local class, ���� Ŭ����)
		class LocalTest
		{
			void write()							// -- �� ��° write()�޼ҵ�
			{
				System.out.println("write()....��");
				System.out.println("a : " + a);
				System.out.println("b : " + b);
				System.out.println("c : " + d);
				//System.out.println("d : " + d);		//�������� �������� (���� ��� ���� �� �� ����)
				//--==>> ���� �߻�(������ ����)

			}
		}

		// �� ���� c�� ���� d�� �Ѵ� ��������������
		//	  (ù��° write() �޼ҵ� �ȿ��� ����� �����̹Ƿ�)
		//	  c�� final �����̱� ������ 
		//	  �ι�° write() �޼ҵ忡�� ���� �����ϴ���
		//	  ������ �� 20�� ��� ������ ���� ���� �� �մ�.
		//	  �ݸ鿡 d�� �� ���� ���÷� ��ȭ�� �� �մ� ��Ȳ�̹Ƿ� 
		//	  LocalTest Ŭ������ �ν��Ͻ� ���� ������ 
		//	  ������ �� �� �� �� ���⶧���� 
		//    �̷� ���� �ν��Ͻ� ���� ������ d�� � ���� ����ִ�����
		//	  ������� �� ���� �ȴ�.
		//	  ���� d�� ���� �ϴ� ���� ���� �� �ֵ��� ���������� ó���ϴ� ���̴�.
		
		d++;

		// LocalTest Ŭ���� ��� �ν��Ͻ� ����(�� inner)
		LocalTest lt = new LocalTest();
		lt.write();								// -- �� ��° write() �޼ҵ� ȣ��
	}
}

public class Test123
{
	public static void main(String[] args)
	{
		//Test2 Ŭ���� ��� �ν��Ͻ� ����(��outer)
		Test2 ob = new Test2();
		ob.write();								// -- ù ��° write() �޼ҵ� ȣ��
	}
}