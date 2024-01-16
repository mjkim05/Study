/*============================================
  ���� �ڹ��� �ֿ�(�߿�) Ŭ���� ����
  - �ڹٿ��� �⺻������ �����ϴ� �ֿ� Ŭ������
  - String Ŭ����
==============================================*/


public class Test137
{
	public static void main(String[] args)
	{
		String s = "seoul korea";
		System.out.println("s : " + s);
		//--==>> s : seoul korea

		// �� ���ڿ� ����
		System.out.println(s.substring(6,9));
		//--==>> kor

		// �� ��String.substring(s,e)��
		//	   String ���ڿ��� ������� 
		//	   s��°���� e-1��°���� ����
		//	   (��, �ε����� 0���� ����)

		System.out.println(s.substring(7));
		//--==>> orea

		// �� ��String.substring(s)��
		//	   String ���ڿ��� �������
		//	   s��°����... ������ ����
		//	   (��, ���ڿ��� ���� ���̸�ŭ...)


		// �� ���ڿ��� ������(��) ��
		System.out.println(s.equals("seoul korea"));
		System.out.println(s.equals("seoul Korea"));
		//--==>> true
		//		 false
		//-- ��ҹ��� ������ ����

		System.out.println(s.equalsIgnoreCase("SEOUL KOREA"));
		//--==>> true
		//-- equalsIgnoreCase() ��ҹ��� ���� ����

		// �� ã���� �ϴ� ��� ���ڿ�(s)�� 
		//	  ��kor�����ڿ��� �����ұ�?
		//    �����Ѵٸ�... �� ��ġ�� ��� �ɱ�?

		//"seoul korea"
		// 0123456789
		
		// ã���� �ϴ� ���ڿ� ù��° �ε����� �˷���
		System.out.println(s.indexOf("kor"));
		//--==>> 6	

		System.out.println(s.indexOf("ea"));
		//--==>> 9

		System.out.println(s.indexOf("e"));
		//--==>> 1
		//-- ���� ã�� ���ڿ��� �ε����� ��ȯ�ϰ� ����.

		System.out.println(s.indexOf("tt"));
		//--==>> -1	
		//-- ã���� �ϴ� ���ڿ��� ��� ���ڿ��� ������ ���
		//	 �� ���ڿ��� �ε����� ��ȯ������
		//	 �������� ���� ��� ������ ��ȯ�ϰ� �ȴ�. �� (-1)

		// �� ��� ���ڿ�(s)�� ��rea���� ���������� ���� Ȯ��
		//	  (true / false)
		System.out.println(s.endsWith("rea"));
		System.out.println(s.endsWith("oul"));
		//--==>> true
		//		 false
		
		// �� ã���� �ϴ� ��� ���ڿ�(s)�� 
		//	  ��e�����ڿ��� �����ұ�?
		//    �����Ѵٸ�... �� ��ġ�� ��� �ɱ�?	
		//	  ��, �ڿ��� ���� �˻�

		//seoul korea
		System.out.println(s.indexOf("e"));
		System.out.println(s.indexOf("o"));
		//--==>> 1
		//		 2
		
		// seoul korea
		// �ڿ��� ���� ã���� �ε����� �տ��� ���� ����.
		System.out.println(s.lastIndexOf("e"));
		System.out.println(s.lastIndexOf("o"));
		//--==>> 9
		//		 7

		// �� ��� ���ڿ�(s)��
		//    ��6����° �ε��� ��ġ�� ���ڴ�?

		// seoul korea
		System.out.println(s.charAt(6));
		//--==>> k

		// seoul korea
		//System.out.println(s.charAt(22));
		//--==>> ���� �߻�(��Ÿ�� ����)
		// StringIndexOutOfBoundsException

		// �� ��� ���ڿ�(s)�� �� ���ڿ� ��seoul corea���� 
		//    � ���ڿ��� �� ū��?		�� ���ڿ��� ���� ũ�� ��?
		//	  ==> �� ���ڿ��� ���ٸ�		�� 0
		//    ==> �� ���ڿ��� �ٸ��ٸ�		�� ???

		System.out.println(s.compareTo("seoul korea"));
		//--==>> 0 �� �� ���ڿ��� ���� (s�� ���� "seoul korea" �� ����..)
		System.out.println(s.compareTo("seoul corea"));
		//--==>> 8
		//-- c ~ k defghijk �� 8 �ƽ�Ű �ڵ� ���̸� �˷���

		// �� ��� ���ڿ�(s)��
		//    �ش� ���ڿ��� ã�Ƽ� ���ϴ� ���·� ������ ���ڿ� ��ȯ
		s = "�츮���� ���ѹα� ���ѵ��� ����";
		s = s. replaceAll("����", "����");
		System.out.println("ó�� ��� : " + s);
		//--==>> ó�� ��� : �츮���� ���ֹα� ���ֵ��� ����

		// �� ���� ����
		s = "			��			��			";
		//System.out.println(s);
		//--==>>                         ��                      ��
		System.out.println("|" + s + "|");
		//--==>> |                       ��                      ��                      |
		System.out.println("|" + s.trim() + "|");
		//--==>> |��                     ��|		
		// �� �����ڸ��� �ִ� ���鸸 ���ŵ� �� ������ ������ ������. 
		//-- ���� �����ڸ� ���� ���� 
		System.out.println("|" + s.replaceAll("	","") + "|");
		//--==>> |���|

		int temp = Integer.parseInt("50");
		System.out.printf("%d\n" , temp);
		//--==>> 50

		s = Integer.toString(30);
		System.out.printf("%s\n" , s);
		//--==>> 30

		int n = 2345678;
		System.out.printf("%d",n);
		System.out.format("%d" ,n);
		//--==>> 23456782345678

		System.out.println();			// ����

		 s = String.format("%d",n);
		 System.out.println(s);
		 //--==>> 2345678

		 s = String.format("%.2f", 123.456);
		 System.out.println(s);
		 //--==>> 123.46

		 s = String.format("Ȯ�� : %b" , true);
		 System.out.println(s);
		 //--==>> Ȯ�� : true

		 s = String.format("��� : %,d" , n);
		 System.out.println(s);
		 //--==>> ��� : 2,345,678

		//String str = "�⺻,����,���";
		//String[] strArr = str.split(","); 

		// line 168~ 169�� ������ ����
		String[] strArr = "�⺻, ����, ���".split(",");

		for ( String str : strArr )
			System.out.print(str + " ");
		System.out.println();
		//--==>> �⺻  ����  ���




	}
}