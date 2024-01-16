/*================================
  ���� �÷���(Collection) ����		
=================================*/

/*
�� List 
   - ������ ����, �迭�� ����,  �ߺ��� ���
   - �ֿ� ���� Ŭ����
   	 �� Vector (����ȭ ����)
	 �� ArrayList (����ȭ ���� ����)
	 �� LinkedList (ü��, ��ũ, ����, ť)


*/

import java.util.List;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Iterator;

public class Test166
{
	public static void main(String[] args)
	{
		List<String> list = new ArrayList<String>();

		list.add("����");
		list.add("�λ�");
		list.add("��õ");
		list.add("�뱸");
		list.add("����");
		list.add("����");	
		list.add("���");
		list.add("����");

		// Ȯ�� �� ���� Ȯ��
		//System.out.println(list);
		//--==>> [����, �λ�, ��õ, �뱸, ����, ����, ���, ����]

		System.out.println("��ü ����  : " + list.size());
		//--==>> ��ü ����  : 8

		// ù��° ��� ��� 
		System.out.println("ù ��° ��� ��� : " + list.get(0));
		//--==>> ù ��° ��� ��� :  ����

		// ������ ��� ���
		System.out.println("������ ��� ��� : " + list.get(list.size()-1));
		//--==>> ������ ��� ��� : ����

		// ó�� ��ġ�� �ѱ� �߰�
		list.add(0, "�ѱ�");
		
		// ���� Ȯ��
		//System.out.println(list);
		//--==>> [�ѱ�, ����, �λ�, ��õ, �뱸, ����, ����, ���, ����]

		// ó�� ��ġ�� ������ ��Ҹ� "���ѹα�"���� ����
		list.set(0, "���ѹα�");
		
		// ���� Ȯ��
		//System.out.println(list);
		//--==>> [���ѹα�, ����, �λ�, ��õ, �뱸, ����, ����, ���, ����]

		// "����" ���翩�� Ȯ��
		if (list.contains("����"));
		{
			System.out.println("������ ���� �մϴ�.");
		}
		//--==>> ������ ���� �մϴ�.
		
		// "������ ���° �ε����� ��ġ�ϴ��� Ȯ��" 
		int i = list.indexOf("����");
		System.out.println("���� �ε��� ��ġ : " + i);
		//--==>> ���� �ε��� ��ġ : 1
		
		// "���ѹα�" ����� �� �������	
		list.remove("���ѹα�");					//-- (��)
		//list.remove(0);							//-- (��) ���ѹα� �ε��� �� ���Ե� ����
		//�׽�Ʈ (Ȯ��)
		System.out.println(list);
		
		
		System.out.println("===========================================================================");


		//list�� ��ü ��� ���
		System.out.println("��ü ���... MJ");
		ListIterator<String> li = list.listIterator();
		while (li.hasNext())
		{
			System.out.print(li.next() + " ");
		}
		System.out.println();

		System.out.println();
		
		System.out.println("��ü ���... ������");
		for (int idx = 0; idx<list.size(); idx++)
		{
			System.out.print(list.get(idx) +  " ");
		}
		System.out.println();
		//--==>> ��ü ���... ����
		//		 ���� �λ� ��õ �뱸 ���� ���� ��� ����
		
		System.out.println();

		System.out.println("���� ���....��");
		for (int idx = list.size()-1;idx>=0 ; idx--)
		{
			System.out.print(list.get(idx) + " ");
		}
		System.out.println();
		
		System.out.println();

		System.out.println("��ü ���.... ������");
		for (String s : list)
			System.out.print(s  + " ");
		System.out.println();
		
		System.out.println();

		System.out.println("��ü ���... ������");
		Iterator<String> itr = list.iterator();
		while (itr.hasNext())
		{
			System.out.print(itr.next() + " ");
		}
		System.out.println();
		
		System.out.println();

		System.out.println("���� ���...��");
		while (li.hasPrevious())
		{
			String s = li.previous();
			System.out.print(s+" ");
		}
		System.out.println();


		
		
		



	}
}