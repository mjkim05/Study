/*================================
  ���� �÷���(Collection) ����		
=================================*/

/*
�� Enumeration �� Iterator �������̽�
   
   Collection �� Freamwork����
   Enumeration �� Iterator ��� �������̽��� �ִ�.
   �������� �ǹ̷δ� �ݺ�,, ��ȯ �̶�� �ǹ̸� ������ ������
   � ��ü���� ������ ���� ��, 
   �� ��ü���� � ������ ���� �ϳ��� �����Ͽ� ����ϱ� ���� 
   �������̽���� �� �� �ִ�.

   - java.util.Enumeration<E> �������̽� 
     : �� �������̽��� ���� �� ���� �޼ҵ常�� �����Ͽ�
	   ��hasMoreElement()�� �޼ҵ带 ���� 
	   �������̽� �ȿ� ���� ��Ұ� �ִ����� ���� ���Ǹ� �Ѵ�.
	   ���� true �� ��ȯ�Ǿ��ٸ� ���� �ε����� ��Ұ� �����Ѵٴ� �ǹ��̸�,
	   ��nextElement()���޼ҵ�� ���� ��ҿ� �����Ͽ� ����ϸ� �Ǵ� ���̴�.

	ex) // v��� ���� �ڷᱸ���� ����� ��� ��� ���
		   for (Enumeration e = v.element(); e.hasMoreElement();)
		   {
				System.out.println(e.nextElement());
		   }

	- java.util.Iterator<E> �������̽�
	  : Enumeration ���� �������� ���� ��remove()�� �޼ҵ尡 �߰��� �� ���̴�.
	    Iterator�� ������ �ִ� ��hasNext()���� ��next()�� �޼ҵ�� 
		�̸��� �ణ �ٸ� �� Enumeration �������̽��� ������ �ִ� 
		��hasMoreElements()���� �׸��� ��nextElement()���� 
		��Ȯ�� ��ġ�ϴ� ����� �����Ѵ�.
		Enumeration ��� Iterator�� JDK1.2���� �߰��Ͽ� ����ϰ� �� ������ 
		Enumeration �������̽��� ���� ������ ��Ҹ� ������ ����� ���� ������
		�̸� �����ϱ� ���� ���� ���� Itetator �������̽� �̴�.

		���̴� Ŭ������ �ٸ��� ������ �ΰ��� �� ����� �� �˾ƾ��Ѵ�!!


*/

import java.util.Vector;
import java.util.Enumeration;
import java.util.Iterator;

public class Test164
{
	public static void main(String[] args)
	{
		// ���� �ڷᱸ�� �ν��Ͻ� ����
		Vector<String> v = new Vector<String>();

		// ���� �ڷᱸ�� v�� ��� �߰�
		v.add("java");
		v.add("Oracle");
		v.add("Jsp");
		v.add("Servlet");
		v.add("Spring");

		// �� Enumeration
		//	  - hasMoreElements()
		//    - nextElement()
		Enumeration<String> e = v.elements();
		while (e.hasMoreElements())
		{
			System.out.println(e.nextElement());
		}
		System.out.println();
		//--==>> java
		//		 Oracle
		//		 Jsp
		//		 Servlet
		//		 Spring

		System.out.println("----------------------------");

		// �� Iterator
		//	  - hasNext();
		//	  - next();
		Iterator<String> it  = v.iterator();
		while (it.hasNext())
		{
			System.out.println(it.next());
		}
		System.out.println();
		//--==>> java
		//		 Oracle
		//		 Jsp
		//		 Servlet
		//		 Spring
		

	}
}