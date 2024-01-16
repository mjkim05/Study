/*================================
  ���� �÷���(Collection) ����		
=================================*/

/*
�� Vecter(����)
   
   �ڹ��� �ڷᱸ�� ����� �����ϴ� Ŭ������ �� ���� �⺻���� Ŭ������ 
   �迭�� ��������� �迭�� �޸� �ٸ� ������ ������ ���� ���� 
   ������ ��ҵ��� ���� �� ������, �����Ͱ� �������� �ڵ����� ���� ������ 
   Ȯ�� ��Ű�� �ȴ�.

   ����, ��ü ���۷����� �����ϱ� ������ 
   JDK 1.5 �������� �ڹ� �⺻�� �����ʹ� ������ �� ��������
   JDK 1.5 ���ĺ��ʹ� ����ڽ� / ���� ��ڽ� ����� �����Ǹ鼭	
   �⺻ ���������� ���� �� �� �ְ� �Ǿ���
	=> int,double���� ���� �� �� Integer, Double Ÿ������ ��ȯ(����ڽ�, �����ڽ�)�Ǹ鼭 ����ȴ�.


   ���� Ŭ������ �⺻������ 
   ������(Sequence) ������ ������ ����ϸ�
   ������ ������ ������ �������� �ε��� ���� ���� ��ġ�� �����ϰ� �ȴ�
   ���� �ڷᱸ���� �� ���ܿ����� ������ ������ ť�� 
   ���� �������� ������ ������ ���ð� �޸� 
   ������ ������ �ε��� ���� �̿��Ͽ� �ڷ� ������ ������ �������� 
   ���� �� ������ �����ϴ�.

   ������ ������ ������ 
   List �������̽��� ���� �����ް��ֱ⶧����
   List �������̽��� ��� �޼ҵ带 ����� �� �մ�.

   - void add(int index , E element)
   - void insertElementAt(E obj, int index)
     �־��� ��ġ�� ��ü�� �����Ѵ�.
	 �־��� ��ġ�� ��ü�κ��� ���������� �ϳ��� �̵��Ѵ�.

   - void addElement(E object)
   - boolean add(E e)
     ��ü�� ���� ���� �߰��Ѵ�.

   - void removeElementAt(int index)
   - E reomve (int Index)
     �־��� ��ġ�� ��ü�� �����Ѵ�.
	 ���� �� �־��� ��ġ ������ ��ü���� �ϳ��� �������� �̵��Ѵ�.
	 E remove(int Index) �޼ҵ�� ����Ǿ��� ��ü�� ��ȯ�Ѵ�.

   - boolean removeElement(Object obj)
     boolean remove(Object obj)
     ��� ��ü�� �����Ѵ�.
	 ������ �־��� ��ġ ������ ��ü���� �ϳ��� �������� �̵��Ѵ�.
	 ��ü�� ���������� ���ŵǾ����� true�� ��ȯ�Ѵ�.

   - void removeAllElement
     void clear()
     ������ ��� ��Ҹ� �����Ѵ�.

   - void setElementAt(E obj, int index)
     E set(int index, E element)
	 ������ index ��ġ���� �־��� ��ü�� �����Ѵ�.
	 �־��� ��ġ�� ����Ǿ� �ִ� ��ü�� �Ҹ��Ѵ�. (�� ����� ����)
	
   - E elementAt(int index)
   - E get(int index)
     �־��� ��ġ�� ����� ��ü�� ��ȯ�Ѵ�.

   - E numeration(E) elements()
     ������ ��� ��Ҹ� ��ȯ�Ѵ�

	 int indexOf(object o)
	 �־��� ��ü�� ����� ��ġ�� ��ȯ�Ѵ�.
	 �������� ���� ��� ���������� ��ȯ�ȴ�.

	 int indexOf(Object p, inu index)
	 �־��� ��ü�� ����� ��ġ�� index��ġ���� ã�Ƽ� ��ȯ�Ѵ�.
	 ���⼭ index��ġ�� ��ĵ�� �����ϴ� ��ġ

	 boolean contains(Object o)
	 ���Ͱ� �־��� ��ü�� �����ϰ� �ִ����� ���θ� ��ȯ�Ѵ�.

	 void ensureCapacity(int minCapacity)
	 ������ �뷮�� �־��� ũ�⺸�� ũ���� �����Ѵ�.
	 (�־��� ũ�⸦ ������ �� �ֵ��� �����Ѵ�.)

	 E firstElement()
	 ������ ù ��° ����� �����͸� ��ȯ�Ѵ�.

	 E lastElement()
	 ������ ������ ����� �����͸� ��ȯ�Ѵ�.

	 void setSize(int newSize)
	 ������ ũ�⸦ �����Ѵ�.
	 ���� �־��� ũ�Ⱑ ���� ũ�⺸�� �۴ٸ� �������� ������.
	 ����� �־��� ũ�Ⱑ ���� ũ�⺸�� ũ�ٸ�
	 �� ������ null��ü�� ä��� �ȴ�.
	 (��ü�� �������� ������ �ǹ�)

	 int capacity()
	 ���� ������ �뷮�� ��ȯ�Ѵ�.

	 int size()
	 ���� ������ ����� ��ü�� ����(size)�� ��ȯ�Ѵ�.

	 trim trimToSize()
	 ������ �뷮�� ����� ��ü�� ������ �µ��� �ּ�ȭ�Ѵ�.

*/

import java.util.Vector;
import java.util.Iterator;

public class Test158
{	
	// ���� ���ڿ� �迭 ���� �� �ʱ�ȭ 
	private static final String[] colors	= {"����", "���", "�ʷ�", "�Ķ�", "����", "����"};



	public static void main(String[] args)
	{
		int i;
		String str;

		// Vector(����) �ڷᱸ�� V ����
		Vector<Object> v = new Vector<Object>();

		// v ��� ���� �ڷᱸ���� colors �迭�� ����ִ� ������ ��Ƴ���
		// add()

			for (i=0; i<colors.length; i++)
			{
					v.add(colors[i]);
			}

		// addElement()
		v.addElement("�Ͼ�");
				
		//firstElement()
		str = (String)v.firstElement();
		System.out.println("ù ��° ���  : " + str);
		//--==>> ù ��° ���  : ����

		//get()
		str = (String)v.get(1);
		System.out.println("�� ��° ���  : " +str);
		//--==>> �� ��° ���  : ���

		// get()
		str = (String)v.get(0);
		System.out.println("ù ��° ��� :" + str);
		//--==>> ù ��° ��� :����

		//elementAt();
		str = (String)v.elementAt(1);
		System.out.println("�� ��° ��� : " + str);
		//--==>> �� ��° ��� : ���  

		//lastElement()
		str = (String)v.lastElement();
		System.out.println("������ ��� : " + str);
		//--==>> ������ ��� : ����

		// �� line 134���� ��� �߰� �� �ٽ� Ȯ��
		//--==>> ������ ��� : �Ͼ�

		// �� ���� �ڷᱸ���� ��� �߰��� (��add() / addElement())
		//	  �ε��� ������(���� ��)�� ��ġ�� �߰��Ǵ� ���� Ȯ�� �� �� �ִ�.

		// ��ü ��� ���
		// ��Iterator(���ͷ����� or �����ͷ�����)��
		// ��hasNext()�� : ���� ������ ��Ұ� �ִ��� �������� ���θ� Ȯ��
		// ��next()��	 : ���� ������ ��Ҹ� ���������� ��ȯ

		Iterator<Object> it = v.iterator();	

		while (it.hasNext())				//true true true true true true true false
		{
			str = (String)it.next();		//���� ��� �ʷ� �Ķ� ���� ���� �Ͼ�
			System.out.print(str + " ");

		}
		System.out.println();

		
		

		/*
		                                  ��
		--------------------------------------
		���� ��� �ʷ� �Ķ� ���� ���� �Ͼ�
		--------------------------------------
		*/

	}
}
// ���� ���
/*

ù ��° ���  : ����
�� ��° ���  : ���
ù ��° ��� :����
�� ��° ��� : ���
������ ��� : �Ͼ�
���� ��� �ʷ� �Ķ� ���� ���� �Ͼ�
����Ϸ��� �ƹ� Ű�� �����ʽÿ� . . .


*/