/*================================
  ���� �÷���(Collection) ����		
=================================*/

// Vector v = new Vector();
// -- ����ִ� Vetor �ڷᱸ�� v ���� 

// Vector v = new Vector(8);
// -- 8���� �ʱ� element �� ���� Vector �ڷᱸ�� v ����
//    �� �ڷᱸ���� Ȱ���ϴ� �������� 
//    8���� ��� ä������ �Ǹ�(��� ���Ǿ� ���ڶ�� �Ǹ�) �ڵ����� Ȯ��ȴ�.

// Vector v = new Vector(3,5);
// -- 3���� �ʱ� element �� ���� Vector �ڷᱸ�� v ����
//    �� �ڷᱸ���� Ȱ���ϴ� �������� 
//    3���� ��� ä������ �Ǹ�(��� ���Ǿ� ���ڶ�� �Ǹ�) �ڵ����� 5�� ����(Ȯ��)�ȴ�.

// �� ���ʹ� ������ ��ҷ� ������, �Ǽ���, ���ڿ�... ��� 
//    ��Ƴ��� ���� �����ϴ�. (�� ����������.)
//    �� ������ ������ Ȯ�� check~!! ���� �Ӹ� �ƴ϶� �÷��ǿ��� ����ϴ� ��� �ڷᱸ���� �� �׷���! 

import java.util.Vector;
import java.util.Iterator;

//MyVetor Ŭ���� ����
class MyVector extends Vector<Object>
{
	// ������ �� ����� ���� ������
	MyVector()
	{
		// Vector(����Ŭ����) ������ ȣ��
		// super();
		// �� vector();
		super(1,1);
		// ù ��° ���� : �־��� �뷮
		// �� ��° ���� : ������
	}

	void addInt(int i)
	{
		addElement(new Integer(i));
	}

	void addFloat(float f)
	{
		addElement(new Float(f));
	}

	void addString(String s)
	{
		addElement(s);
	}
	
	void addCharArray(char[] a)
	{
		addElement(a);
	}
	void addObject(Record rec)
	{
		addElement(rec);
	}
	
	void write()
	{	
	/*
		Iterator<Object> it = this.iterator();
		while (it.hasNext())
		{
			Object obj = it.next();
			System.out.println( obj + " ");
		}
		System.out.println();
	}
	*/
	/*
	void write()
	{	
		Iterator<Object> it = this.iterator();
		while (it.hasNext())
		{
			System.out.println(it.next());
		}
		//--==>> 5
		//		 3.14
		//		 �ȳ��ϼ���
		//		 [C@15db9742
		//		 ����Ϸ��� �ƹ� Ű�� �����ʽÿ� . . .
	}
	*/

	/*
	Object o;
	int length = size();

	//System.out.println("���� ����� ���� : " + length);

	for (int i =0; i<length; i++)
	{
		o = elementAt(i)
		System.out.println(o)
	}
	*/

	// ��instanceof�� ������		check~~!!
	// -- ó���ؾ� �ϴ� ����� ��ü Ÿ�� Ȯ��
	
	Object o;
	int length = size();

	System.out.println("���� ����� ����  : " + length);

	for (int i = 0 ;i<length ; i++)
	{
		o = elementAt(i);
		/*if (o instanceof char[] )
		{
			System.out.println("���� �迭");
		}
		else 
		{
			System.out.println("�ٸ� ����");
		}*/

		if (o instanceof char[])
		{
			System.out.println("���� �迭 " + String.copyValueOf((char[])o));
		}
		else if (o instanceof String)
		{
			System.out.println("���ڿ� :" +o.toString());
		}
		else if (o instanceof Integer)
		{
			System.out.println("������ : " + o);
		}
		else if (o instanceof Float)
		{
			System.out.println("�Ǽ��� :" + o);
		}
		else 
			System.out.println("Ÿ�� Ȯ�� ���~!!");

		}

	}
}

public class Test159
{
	public static void main(String[] args)
	{
		//MyVector Ŭ���� ��� �ν��Ͻ� ����
		MyVector v = new MyVector();

		// �ֿ� ���� ���� �� �ʱ�ȭ
		int digit = 5;
		float real = 3.14f;
		String s = new String("�ȳ��ϼ���");
		char[] letters = {'s','t','u','d','y'};

		v.addInt(digit);				// -- ���� �ڷᱸ���� ���� ����
		v.addFloat(real);				// -- ���� �ڷᱸ���� �Ǽ� ����
		v.addString(s);					// -- ���� �ڷᱸ���� ���ڿ� ����
		v.addCharArray(letters);		// -- ���� �ڷᱸ���� ���� �迭 ����
		
		v.write();


	}
}