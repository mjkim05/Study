/*================================
  ���� �÷���(Collection) ����		�� �÷��� �����ӿ�ũ�� ��������
=================================*/

import java.util.Queue;
import java.util.LinkedList;

public class Test157
{
	// ���� ���ڿ� �迭 ���� �� �ʱ�ȭ 
	private static final String[] colors	= {"����", "���", "�ʷ�", "�Ķ�", "����", "����"};

	public static void main(String[] args)
	{
		//Queue �ڷᱸ�� ����
		Queue<String> qu = new LinkedList<String>();
		//-- queue �������̽� ����� �ν��Ͻ��� �����ϱ� ���ؼ��� 
		//   new �����ڸ� �̿��Ͽ� queue �������̽��� implements �� 
		//   ���� Ŭ������ �����ڸ� ȣ���ؾ��Ѵ�.
		
		// qu��� Queue�ڷᱸ���� 
		// colors �迭�� ������ ��� �Է�

		for(String color : colors)
			qu.offer(color);			// = �� ������~~!!!

		// qu ��� Queue �ڷᱸ���� ��� ������ ��ü ���
		// peek()
		// : ť�� head ��Ҹ� ��ȯ�ϰ� �������� ������
		//   ť�� �ڷ� ������ ��� �ִ� ���°� �Ǹ� null ��ȯ
		// poll()
		// : ť�� head ��Ҹ� ��ȯ�ϰ� ����
		//   ť�� �ڷ� ������ ��� �ִ� ���°� �Ǹ� null ��ȯ

		while (qu.peek() !=null )				// ������ ��Ʈ�� ���׸� �����ϱ� ���⼭�� �Ƚᵵ �ȴ�~~!!
		{
			String val = qu.poll();
			System.out.print(val + " ");
		}
		System.out.println();
		
	}
}
//���� ���
/*
���� ��� �ʷ� �Ķ� ���� ����
����Ϸ��� �ƹ� Ű�� �����ʽÿ� . . .
*/