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
�� HashMap<K,V> Ŭ����
   
   - HashMAp Ŭ������ Hashtble Ŭ������ ����������
	 Map �������̽��� ��ӹ޾� �ֿ� ����� ������
	 SynchroniZation �� ���� ������ ���ü� ������ ���ٸ� 
	 (��, ��Ƽ ������ ���α׷��� �ƴ� �����)
	 HashMap�� ����ϴ� ���� ������ ����ų �� �ִ�.
   - ����, HashMap �� Hashtable �� �޸� null�� ����Ѵ�.

*/
import java.util.HashMap;
import java.util.Map;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Test171
{
	public static void main(String[] args) throws IOException
	{
		//HashMap �ڷᱸ�� ����
		//HashMap<String, String> map = new HashMap<String, String>();
		Map<String, String> map = new HashMap<String, String>();

		// map�̶�� HashMap�ڷᱸ���� ��� �߰�
		// - put();

		map.put("��ȭ", "�Ź���");
		map.put("���", "����");
		map.put("��ȭ", "������ũ");
		map.put("�Ҽ�","�������� �½�");

		// �׽�Ʈ(Ȯ��) �� ���� Ȯ��
		//System.out.println(map);
		//--==>> {�Ҽ�=�������� �½�, ���=����, ��ȭ=�Ź���, ��ȭ=������ũ}
		//-- ������ ���� ���� Ȯ��
		//-- ������ ��� �ݳ� ������ �߰� ������ ���� ����

		// �� null ���� ó��

		map.put(null,null);				//-- key �� value�� ��� null

		// �׽�Ʈ(Ȯ��) �� ���� Ȯ��
		System.out.println(map);
		//--==>> {�Ҽ�=�������� �½�, null=null, ���=����, ��ȭ=�Ź���, ��ȭ=������ũ}

		map.put("��ȭ", null);			//-- value�� null

		// �׽�Ʈ(Ȯ��) �� ����Ȯ��
		System.out.println(map);
		//--==>> {�Ҽ�=�������� �½�, null=null, ���=����, ��ȭ=�Ź���, ��ȭ=null, ��ȭ=������ũ}

		map.put(null, "�𳪸���");		//-- key �� null

		//�׽�Ʈ(Ȯ��) �� ���� Ȯ��
		System.out.println(map);
		//--==>> {�Ҽ�=�������� �½�, null=�𳪸���, ���=����, ��ȭ=�Ź���, ��ȭ=null, ��ȭ=������ũ}
		// null�� �ϳ��� key ���̸�, key ���� �ߺ� �ȵ�

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("ī�װ�, Ÿ��Ʋ �Է�(�ĸ�����) : ");
		String[] temp;

		for (String str;((str=br.readLine()) != null) ; )
		{
			temp = str.split(",");
			if (temp.length <2)
			{
				System.out.print("ī�װ�, Ÿ��Ʋ �Է�(�ĸ� ����) : ");
				continue;
			}

			map.put(temp[0].trim(), temp[1].trim());
			System.out.println(map);
		}
	


	}
}