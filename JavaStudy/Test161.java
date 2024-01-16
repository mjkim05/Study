/*================================
  ���� �÷���(Collection) ����		
=================================*/

import java.util.Vector;
import java.util.Collections;


public class Test161
{

	// ���� ���ڿ� �迭 ���� �� �ʱ�ȭ 
	private static final String[] colors	= {"����", "���", "�ʷ�", "�Ķ�", "����", "����"};


	public static void main(String[] args)
	{	

		Vector<String> v = new Vector<String>();

		// ���� �ڷᱸ�� v�� colors �迭 �����͸� ��ҷ� �߰�
		for(String color : colors)
			v.add(color);

		// ���� �ڷᱸ�� v�� ��ü ��� ���
		System.out.print("��ü ��� ��� : ");
		for(String str : v)
			System.out.print(str + " ");
		System.out.println();
		//--==>> ��ü ��� ��� : ���� ��� �ʷ� �Ķ� ���� ����

		String s1 = "��ȫ";
		
		//indexOf()
		int i = v.indexOf(s1);
		System.out.println(s1 + " �� index ��ġ " + i);
		System.out.println();
		//--==>> ��ȫ �� index ��ġ -1

		String s2 = "���";
		// ��v.contains(s)��
		// -- ���� �ڷᱸ�� v�� ã���� �ϴ� s�� ���ԵǾ� �ִ����� ���� Ȯ��
		//	  �� ���ԵǾ� �ִٸ� index ��ġ Ȯ�� 
		if (v.contains(s2))
		{
			i = v.indexOf(s2);
			System.out.println(s2 + " �� index ��ġ " + i);
			
			// �� �����ϴ����� ���θ� Ȯ���ϰ�
			// �� �����Ѵٸ� ��� �ִ��� Ȯ���ϰ�
			// �� Ȯ���� ��ġ�� ��Ҹ� �����ض�(�����ض�)
			v.remove(i);		//�ε��� i�� �Ѱ���
		}
		System.out.println();
		//--==>> ��� �� index ��ġ 1

		// ã�Ƽ� ������ �� ��ü ��� ���
		System.out.print("���� �� ��ü ��� ��� : ");
		for (String str: v )
			System.out.print(str + " ");
		System.out.println();
		//���� �� ��ü ��� ��� : ���� �ʷ� �Ķ� ���� ����

		System.out.println(v);
		//--==>> [����, �ʷ�, �Ķ�, ����, ����]

		// �� ���� Ȯ�ο� ���� �����ʹ� 
		//    ���� ���(������)�� �ƴϱ� ������
		//    �̸� Ȱ���Ͽ� ������ �����ϰ� ó���ؼ��� �ȵȴ�.			check~~!!!






	}
}