/*================================
  ���� �÷���(Collection) ����		
=================================*/

// List �� Vectorm, ArrayList, LinkedList,	.....
// ������ �ǹ� ����
// ���迭�� ����
// ���ߺ� ���

/*
�� ArrayList Ŭ����
   
   - ArrayList �� Vector Ŭ������ 
     List�� ũ�� ������ ������ �迭�� ������ ������ 
	 �������� Vector Ŭ������ ��ü�� �⺻������ ����ȭ ������,
	 ArrayList�� �׷��� �ʴٴ� ���̴�. �� �񵿱�ȭ �÷���

   - �񵿱�ȭ �÷����� ����ȭ�� �÷��Ǻ��� �� ���� ������ �����ϸ�
     ��������� �÷����� ������ �ʿ䰡 ���� ���α׷�������
	 �Ϲ������� ArrayList�� Vector���� �� ��ȣ�ϸ�,
	 ������ ����ȭ�� ������ �δ��� ������ �ʱ� ������
	 Vector���� �� ������ ����ȴ�.

   - null�� ������ ��� ��Ҹ� ����ϸ�
     List �������̽��� �����ϴ� �Ϳܿ� ����Ʈ�� �ݳ��ϱ� ����
	 ���������� ���Ǵ� �迭�� ����� �����ϴ� �޼ҵ带 �����Ѵ�.
	

*/

import java.util.ArrayList;
import java.util.Vector;
import java.util.List;
import java.util.ListIterator;

public class Test165
{
	public static void main(String[] args)
	{
		//ArrayList �ν��Ͻ� ����
		//ArrayList<String>list = new ArrayList<String>();

		//List<String> list - new List<String>(); �Ұ����ϴ�. �ֳĸ� �������̽� �� �߻�Ŭ����

		//Vector<String> list  = new Vector<String>(); 
		//List<String> list = new Vector<String>();
		List<String> list1 = new ArrayList<String>();

		//list1 �ڷᱸ���� ��� �߰� �� add()
		list1.add("�������̸�");
		list1.add("������Ż");
		list1.add("�˶��");

		List<String> list2 = new ArrayList<String>(list1);

		//list2 �ڷᱸ���� ��� �߰� �� add()
		list2.add("�����̴���");		// ����~^.^

		List<String> list3 = new ArrayList<String>();

		// list3 �� list2 �� ��ü ��Ҹ� �߰� �� addAll()
		list3.addAll(list2);

		// "�˶��" �տ� "ž��" �߰�
		// �� [�������̸�, ������Ż, �˶��, �����̴���]
		// �� [�������̸�, ������Ż, ž��, �˶��, �����̴���]

		// �� "�˶��" ã�� �� indexOf() �� ��ġ �ε��� ��ȯ
		int n = list3.indexOf("�˶��");

		// �׽�Ʈ (Ȯ��)
		//System.out.println( "n :" + n);
		//--==>> n :2

		// �� "�˶��" ã�� �ε��� ��ġ�� "ž��" ���� �� add()
		list3.add(n, "ž��");
		


		// ��� �� ���̵����� Ȯ��
		System.out.println("=======================================");
		System.out.println(list1);
		//--==>> [�������̸�, ������Ż, �˶��]
		System.out.println(list2);
		//--==>> []	
		// list2 ���������� list1�� �Ű������� �Ѱ��ְ� �� �� ���
		//--==>> [�������̸�, ������Ż, �˶��]
		// ��� �߰� �� ���
		//--==>> [�������̸�, ������Ż, �˶��, �����̴���]
		System.out.println(list3);
		//--==>> [�������̸�, ������Ż, �˶��, �����̴���]
		// ž�� �߰� �� ���
		// --==>> [�������̸�, ������Ż, ž��, �˶��, �����̴���]

		// ��� �� listIterator() �޼ҵ带 Ȱ���Ͽ� ���
		System.out.println("=======================================================\n");

		ListIterator<String> li = list3.listIterator();
		while (li.hasNext())
		{
			System.out.print(li.next()  + " ");
		}
		System.out.println();
		//--==>> �������̸� ������Ż ž�� �˶�� �����̴���

		// ��� �� �������� ����
		while (li.hasPrevious())
		{
			System.out.print(li.previous() + " ");
		}
		System.out.println();
		//--==>> �����̴��� �˶�� ž�� ������Ż �������̸�





	}
}