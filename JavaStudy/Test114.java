/*==========================
  ���� Ŭ���� ��� ����
  - ��� (Inheritance)
=============================*/

// �� �޼ҵ� �������̵�(Mathod Overriding)�� Ư¡

//	- �޼ҵ� �̸�, ���� Ÿ��, �Ķ���� ���� Ÿ���� ������ ��ġ�ؾ��Ѵ�.
//	- �ݵ�� ��� ���谡 �־���Ѵ�. 
//	- �����ǵ� ���� Ŭ������ �޼ҵ� �������������ڴ�
//	  ���� Ŭ������ �޼ҵ� �������� �����ں��� ������ ũ�ų� ���ƾ��Ѵ�.
//	  ���� ��� ���� Ŭ���� �޼ҵ��� �������������ڰ� ��protected���� ���
//	  ���� Ŭ������ �� �޼ҵ带 �������̵�(Overriding) �ϴ� ���
//	  �������� �����ڴ� ��public�� �Ǵ� ��protected�� �̾�� �Ѵ�.
//	- ��static�� ��final�� ��private�� �޼ҵ��
//	  �������̵�(Overriding) �� �� ����
//	- Exception �� �߰��� �Ұ����ϴ�.
//	  ��, ���� �޼ҵ尡 ������ �ִ� ������ ���� ���׿�
//	  ���ο� Exception�� �߰��ϴ� ���� �Ұ����ϴٴ� ���̴�. 

// �θ� Ŭ����(���� Ŭ����, super Ŭ����)
class SuperTest114
{
	private int a = 5;
	protected int b = 10;
	public int c = 20;

	public void write()
	{
		System.out.println("Super write()�޼ҵ� : " + a + " : " + b + " : " + c);
	}
}

// �ڽ� Ŭ����(���� Ŭ����, sub Ŭ����)
class SubTest114 extends SuperTest114
{
	protected int b = 100;

	public void print()
	{
		//System.out.println("sub print()�޼ҵ� : " + a  + " : " + b +  " : " + c);
		//--==>> ���� �߻� (������ ����)
		//-- ����Ŭ�������� ����� ���� a���� ������ �� ����.
		//	 �� private �����̱� ������
		System.out.println("sub print()�޼ҵ� : " + b +  " : " + c);
		//--==>> sub print()�޼ҵ� : 100 : 20

		System.out.println("Sub print()�޼ҵ� : " + b);
		System.out.println("Sub print()�޼ҵ� : " + this.b);		//SubTest114.b
		System.out.println("Sub print()�޼ҵ� : " + super.b);		//SuperTest114.b
		//--==>> Sub print()�޼ҵ� : 100
		//		 Sub print()�޼ҵ� : 100
		//		 Sub print()�޼ҵ� : 10
		// -- ���� b�� ���� ����� ���� �ٸ� b�� ���� �� ����� �̷������.
		//	  ����Ŭ�������� ����� b, ���� Ŭ�������� ����� b

		System.out.println("Sub print()�޼ҵ� : " + c);
		System.out.println("Sub print()�޼ҵ� : " + this.c);
		System.out.println("Sub print()�޼ҵ� : " + super.c);
		// --==>> Sub print()�޼ҵ� : 20
		//		  Sub print()�޼ҵ� : 20
		//		  Sub print()�޼ҵ� : 20
		// -- ���� c �� �����ϴµ� �ƹ��� ���װ� ������ ����.
		//	  ����Ŭ�������� ����� c
	
	} //end print()

		@Override
		public void write()
		{
			//System.out.println("Super write()�޼ҵ� : " + a + " : " + b + " : " + c);
			//--==>> ���� �߻� (������ ����)
			//-- ����Ŭ�������� ����� ���� a���� ������ �� ����.
			//	 �� private �����̱� ������

			System.out.println("Sub write()�޼ҵ� : " + b + " : " + c);
			
		}
}

public class Test114
{
	public static void main(String[] args)
	{
		// ���� Ŭ����(subTest114)�ν��Ͻ� ����
		SubTest114 ob = new SubTest114();

		ob.print();

		ob.write();
		//--==>> Super write()�޼ҵ� : 5 : 10 : 20
		//--==>> Sub write()�޼ҵ� : 100 : 20

		System.out.println("------------------------------------- ���м�");

		System.out.println(ob.b);
		//--==>> 100

		System.out.println(((SuperTest114)ob).b);
		//					 ------------
		//						����ȯ(�̶�� ����)
		//--==>> 10
		// �� ���� �θ�~~!!!
		
		ob.write();
		//--==>> Sub write()�޼ҵ� : 100 : 20

		((SuperTest114)ob).write();
		//--==>> Sub write()�޼ҵ� : 100 : 20
		
		// check~~!!
		// �� �޼ҵ�� ������~~ ��~~ �����Ͽ� ������ ��1!!1
		// �޼ҵ�� �ȵ�!!!
	}
}

//������
/*
sub print()�޼ҵ� : 100 : 20
Sub print()�޼ҵ� : 100
Sub print()�޼ҵ� : 100
Sub print()�޼ҵ� : 10
Sub print()�޼ҵ� : 20
Sub print()�޼ҵ� : 20
Sub print()�޼ҵ� : 20
Sub write()�޼ҵ� : 100 : 20
------------------------------------- ���м�
100
10
Sub write()�޼ҵ� : 100 : 20
Sub write()�޼ҵ� : 100 : 20
����Ϸ��� �ƹ� Ű�� �����ʽÿ� . . .

*/