/*================================
  ���� �÷���(Collection) ����		
=================================*/

// Map �� Hashtable, HashMap

/*
�� java.util.Map �������̽�
   Ű(key)�� ��(value)�� ����(mapping)�ϸ�
   ������ Ű�� ��� �� �� ����, �����ؾ� �ϸ�,
   �� Ű�� �Ѱ��� ������ �����ؾ��Ѵ�.
   ��, �ϳ��� Ű�� �����ϴ� �ϳ��� ���� ���� �����̴�.
*/

/*
�� Hashtable<K,V> Ŭ����
   - �ؽ� ���̺� ������ ��ü �𵨸�ȭ �� Ŭ������
     �˻��� �����ϱ� ������ ���󵵰� ���� �� ���Ѵ�.

	 �ؽ����̺��̶� Ű(key)�� �׿� �����ϴ� ������(value)�� 
	 ���е� ������ �����̴�.
	 �����͸� �����ϰ� �˻��ϱ� ���ؼ� Ű(key)�� �����ϸ�
	 �� ���������� Ű ���� �ο��ϸ� �ش� �����Ͱ� ��ȯ�ȴ�.
	 ����, Hashtable Ŭ������ key �Ǵ� value �� ������ null�� ������� �ʴ´�.
*/

import java.util.Hashtable;

public class Test170
{

	private static final String[] names = {"������", "������", "�����", "��ٽ�","�赿��", "�����"};

	private static final String[] tels = {"010-6380-7047", "010-6678-9867", "010-4012-6216", "010-8972-1901","010-4073-4940","010-7159-4231"};

	public static void main(String[] args)
	{
		// Hashtable �ڷᱸ�� ����
		Hashtable<String, String> ht = new Hashtable<String, String>();			//���׸��� ǥ���Ҷ� <key, value> �ΰ��� �� �����.

		// ht ��� Hashtable �ڷᱸ���� 
		// �迭(name ,tels)�� ����ִ� �����͸� ��ҷ� ��Ƴ��� 
		// �� put (k,v);		// add�� ���� ��Ҹ� �ִµ� ���!

		for (int i =0; i<names.length; i++)
		{
			//ht.put("������", "010-6380-7047");
			ht.put(names[i], tels[i]);
		}

		// ht��� Hashtable �ڷᱸ������
		// key �� �̿��Ͽ� ������ �˻�
		// �� get(k);

		String findName1 = "�赿��";
		//String findName1 = "������";
		String str = ht.get(findName1);

		if (str != null)
		{
			System.out.println(findName1 + " ��ȭ��ȣ: " + str);
		}
		//else 
		//{
		//	System.out.println("�׽�Ʈ");
		//}
		System.out.println();
		//--==>> �赿�� ��ȭ��ȣ: 010-4073-4940

		// ht��� Hashtable �ڷᱸ���� 
		// key�� �����ϴ����� ���� Ȯ��
		// �� containsKey()
		String findName2 = "������";
		if (ht.containsKey(findName2))
		{
			System.out.println(findName2 + " �����Ͱ� �����մϴ�.");
		}
		else
		{
			System.out.println(findName2 + " �����Ͱ� �������� �ʽ��ϴ�.");
		}
		System.out.println();
		//--==>> ������ �����Ͱ� �������� �ʽ��ϴ�.

		String findName3 = "�����";
		if (ht.containsKey(findName3))
		{
			System.out.println(findName3 + " �����Ͱ� �����մϴ�.");
		}
		else 
		{
			System.out.println(findName3+ " �����Ͱ� �������� �ʽ��ϴ�.");
		}
		//--==>> ����� �����Ͱ� �����մϴ�.

		// ht�� HashTable �ڷᱸ���� 
		// value�� �����ϴ����� ���� Ȯ��
		// �� contains
		String findTel1 = "010-4012-6216";		// ���� ��ȭ��ȣ
		if (ht.contains(findTel1))
		{
			System.out.println(findTel1 + " �����Ͱ� �����մϴ�.");
		}
		else
		{
			System.out.println(findTel1 + " �����Ͱ� �������� �ʽ��ϴ�.");
		}
		System.out.println();
		//--==>> 010-4012-6216 �����Ͱ� �����մϴ�.

		// ht��� Hashtable �ڷᱸ������ 
		// �������������� ����
		// �� remove ()
		ht.remove("������");

		// �� ��remove()���޼ҵ�� ���ڰ����� key�� �Ѱܹ�����
		//     �̶�, key�� �����Ǵ� ���� �ƴϴ�.
		//	   �ش� key�� ����Ǿ�(���εǾ�) �ִ� value�� �Բ� �����Ѵ�.

		// ����(remove())���� ht��� Hashtable�ڷᱸ����
		// �ش� key�� �����ϴ��� Ȯ��
		if (ht.containsKey("������"))
		{
			System.out.println("�����̰� �����մϴ�");
		}
		else
			System.out.println("������ ��𰫾�??");
		System.out.println();
		//--==>> ������ ��𰫾�??

		// ����(remove())���� ht��� Hashtable�ڷᱸ����
		// �ش� key�� �����ϴ��� Ȯ��
		if (ht.contains("010-6678-9867"))
		{
			System.out.println("�����̰� ��ȭ��ȣ�� �����մϴ�");
		}
		else
			System.out.println("������ ��ȭ��ȣ ��𰫾�??");
		System.out.println();
		//--==>> ������ ��ȭ��ȣ ��𰫾�??

		// �� null ���� ó��
		
		//ht.put(null,null);					//-- key�� value�� ��� null�� ����
		// --==>> ���� �߻�(��Ÿ�� ����)
		//		  java.lang.NullPointerException

		//ht.put("���ȯ", null);				//-- value�� null�� ����
		// --==>> ���� �߻�(��Ÿ�� ����)
		//--==>> java.lang.NullPointerException

		//ht.put(null, "010-1234-5678");		//-- key�� null�� ����
		// --==>> ���� �߻�(��Ÿ�� ����)
		//--==>> java.lang.NullPointerException

		// �ߺ��� key �Է�
		ht.put("������","010-1111-1111");

		System.out.println(ht.get("������"));
		System.out.println();
		//--==>> 010-1111-1111		
		//-- �ߺ��� key�� Ȱ���Ͽ� �����͸� �Է��� ��� 
		//   ����"010-6380-7047"���� "010-1111-1111"�� ����Ǿ����� Ȯ��
		//   (����� ����)

		// �ߺ��� value �Է�
		ht.put("������","010-8972-1901");

		System.out.println(ht.get("��ٽ�"));
		System.out.println(ht.get("������"));
		//--==>> 010-8972-1901
		//		 010-8972-1901
		//-- value�� �ߺ��� ���� �ԷµǴ����
		//   ���� �����ʹ� �ƹ��� ������ ��ġ�� ����.

	}		
}