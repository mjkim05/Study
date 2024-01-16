/*==========================
  ���� Ŭ���� ��� ����
  - ��ø Ŭ����
============================*/

// Static ��ø Ŭ������ ���غ���!! 

class InnerOuterTest
{
	static int a = 10;
	int b = 20;

	class InnerNested
	{
		int c = 30;

		void write()
		{
			System.out.println("inner �� write()....");
			System.out.println("a : " + a);
			System.out.println("b : " + b);
			System.out.println("c : " + c);
		}

	}

	void write()
	{
		System.out.println("outer �� write()....");

		//InnerNested  Ŭ���� ��� �ν��Ͻ� ����(��inner)
		InnerNested ob1 = new InnerNested();
		ob1.write();						//-- inner�� write() �޼ҵ� ȣ��
	}



}

// main() �޼ҵ带 �����ϰ� �ִ� �ٸ� Ŭ����
public class Test124
{
	public static void main(String[] args)
	{
		// InnerOuterTest Ŭ���� ��� �ν��Ͻ� ���� (�� outer)
		InnerOuterTest ob2 = new InnerOuterTest();
		ob2.write();					// -- outer �� write() �޼ҵ� ȣ��
		//--==>> outer �� write()....
		//		 inner �� write()....
		//		 a : 10
		//		 b : 20
		//		 c : 30
		
		// InnerNested Ŭ���� ��� �ν��Ͻ� ����(�� inner)
		//InnerNested ob3  = new InnerNested();
		// --==>> ���� �߻� (������ ����)
		
		// check~~!! Test122.java���ϰ� ��~!!
		// InnerNested Ŭ���� ��� �ν��Ͻ� ���� (�� inner)
		//InnerOuterTest.InnerNested ob4 = new InnerOuterTest.InnerNested();
		// --==>> ���� �߻� (������ ����)

		// �� ��ø ���� Ŭ����(static ��ø Ŭ����)�ʹ� �޸�
		//	  �ܺ� Ŭ������ �ν��Ͻ�(��ü)�� ������� �ʰ�
		//	  �ܵ����� ���� Ŭ������ �ν��Ͻ��� �����ϴ� ���� �Ұ����ϴ�.
		//	  �� ��, �ܺ� Ŭ������ a��.ü.�� ����ϸ� 
		//	     ���� Ŭ������ ��ü�� �����ϴ� ���� �����ϴ�.

		// check~~!!! �� Test122.java ���ϰ� ��~~!!

		InnerOuterTest.InnerNested ob5 = ob2.new InnerNested();
		ob5.write();
		//--==>> inner �� write()....
		//		 a : 10
		//		 b : 20
		//		 c : 30
		
		// check~~!!! �� Test122.java ���ϰ� ��~~!!
		InnerOuterTest.InnerNested ob6 = new InnerOuterTest().new InnerNested();
		ob6.write();

		// outer Ŭ������.inner Ŭ������ �������� = new outer ������().new inner ������();

		// cf) static �� ��ø ���� Ŭ����
		// outerŬ������.innerŬ������ �������� = new outerŬ������.new inner������();


	}
}