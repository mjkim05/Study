/*============================================
  ���� �ڹ��� �ֿ�(�߿�) Ŭ���� ����
  - �ڹٿ��� �⺻������ �����ϴ� �ֿ� Ŭ������
  - StringBuffer Ŭ����
==============================================*/

/*
�� StringBuffer Ŭ����
	
   ���ڿ��� ó���ϴ� Ŭ������ String Ŭ�������� ��������
   String Ŭ������ ���� ���ڿ� �������� ������ �Ұ���������
   StringBuffer Ŭ������ ���ڿ��� ��� �� �� 
   ���� ���ڿ��� ���� �ܰ迡�� ������ �� �ִ�.

   ��, StringBuffer ��ü�� �������� ���̸� �����Ƿ� 
   ��ü�� �����ϴ� �������� �̸� �� ũ�⳪ ���� �����ϰų�
   ���� ������ ������ ũ�⸦ �ٲ� �� �ִ� ����� �����Ѵ�.

   ���� JDK1.5 ���ĺ��ʹ�
   ���ڿ��� ó���ϴ� StringBuilder ��� Ŭ������ �����Ѵ�.
   StringBuilder Ŭ������ ����� StringBuffer Ŭ������ ����������
   ���� ū �������� multi - thread unsafe ��� ���̴�.					// ���� �۾��ڰ� �ִ� ���� ���� �� �� StringBuffer�� �� �����ϴ�.
   ��, Syncronization �� ���⶧����
   StringBuffer ���� ������, ���ü�(����ȭ) ������ ���ٸ�
   StringBuilder �� ����ϴ� ���� ������ ����ų �� �ִ�.

   ����� StringBuffer �� �� ���� ���������� StringBuilder�� �� ������ ������ ����.
*/

public class Test138
{
	public static void main(String[] args)
	{
		String str1 = new String("seoul");
		String str2 = new String("seoul");

		System.out.println(str1 == str2);			// �ּҰ� ��
		System.out.println(str1.equals(str2));		// ������ ��
		//--==>> false
		//		 true

		StringBuffer sb1 = new StringBuffer("korea");
		StringBuffer sb2 = new StringBuffer("korea");

		System.out.println(sb1 == sb2);
		System.out.println(sb1.equals(sb2));
		//--==>> false
		//		 false
		// StringBuffer������ equals �� �������̵� ���� �� �ּҰ� ��

		System.out.println("-----------------------------------------------------------------");

		System.out.println(sb1);
		//--==>> korea	�� StringBuffer ��ü ���
		//-- toString() �޼ҵ� �������̵�

		System.out.println(sb1.toString());
		//--==>> korea �� String ���
		
		System.out.println(sb1.toString().equals(sb2.toString()));
		//--==>> true
		//--==>> String equals String�̱⶧���� ������ �񱳷� true�� ����

		System.out.println("-----------------------------------------------------------------");

		StringBuffer sb3 = new StringBuffer();
		// -- StringBuffer �⺻ ������ ȣ��(�ν��Ͻ� ���� ����)
		//	  �⺻������ �����Ǵ� ���� ũ��� ��16��

		// capacity()	�� ���� ũ�⸦ �˷��ִ� �޼ҵ�
		System.out.println("���� ũ�� : " + sb3.capacity());
		//--==>> ���� ũ�� : 16

		System.out.println(sb3);
		//--==> �ƹ��͵� �ȳ��� ��
		//-- �ȿ� ������ �����~ 
		//Returns a string representing the data in this sequence.

		/*
		String name = "�ڰ���";
		name += "�ڳ���";
		name += "�ڹ���";
		name += "�����";

		System.out.println(name);
		//--==>> �ڰ����ڳ����ڹ��������
		*/

		sb3.append("seoul");					// sb3 += "seoul";
		sb3.append("korea");					// sb3 += "korea";
		sb3.append("�츮����");					// sb3 += "�츮����";
		sb3.append("���ѹα�");					// sb3 += "���ѹα�";
		// �޸� ���� �Ƹ���~? 

		System.out.println(sb3);
		//--==>> seoulkorea�츮������ѹα�		//StringBuffer Ÿ��
		System.out.println(sb3.toString());
		//--==>> seoulkorea�츮������ѹα�		//StringŸ��

		//���� ũ�� �ٽ� Ȯ��
		System.out.println("����ũ�� : " + sb3.capacity());
		//--==>> ����ũ�� : 34



		//////////////////////////////////////////////////////////////////////////////////////////////

		String temp1 = "java and oracle";

		System.out.println(temp1.toUpperCase());
		//--==>> JAVA AND ORACLE	
		//		 �ҹ��ڸ� ��� �빮�ڷ� ��ȯ

		String temp2 = "JAVA AND ORACLE";
		System.out.println(temp1.toLowerCase());
		//--==>> java and oracle
		//		 �빮�� �� �ҹ���

		//System.out.println(sb3.toUpperCase());
		//System.out.println(sb3.toLowerCase());
		// ���� �߻�(������ ����)
		// �ֳĸ� StringBuffer ���� toUpperCase() �޼ҵ�� toLowerCase() �޼ҵ尡 ����~
		
		// seoulkorea�츮������ѹα�
		String temp3 = sb3.toString();
		System.out.println(temp3.toUpperCase());
		//--==>> SEOULKOREA�츮������ѹα�

		System.out.println(sb3.toString().toUpperCase());
		//--==>> SEOULKOREA�츮������ѹα�
		// seoulkorea�츮������ѹα�
		// sb3���� ������ �� ������ �������! �򰥸��� ����!
		// sb3�� �빮�ڷ� ��ȯ�� ���� ������ ���� �����ڸ� ����� �־�����Ѵ�.

		
		// seoulkorea�츮������ѹα�
		// �� ��� ���ڿ�("seoulkorea�츮������ѹα�")��
		//	  "seoul" ���ڿ� �տ� "�ѱ�"�̶�� ���ڿ� �߰�
		//	  ��, ���ѱ�seoulkorea�츮������ѹα��� ���� ����
		sb3.insert(0,"�ѱ�");
		System.out.println("seoul �տ� ���ѱ����߰� :" + sb3);
		//--==>> seoul �տ� ���ѱ����߰� : �ѱ�seoulkorea�츮������ѹα�
		System.out.println("seoul �տ� ���ѱ����߰� : " + sb3.toString());
		//--==>> seoul �տ� ���ѱ����߰� : �ѱ�seoulkorea�츮������ѹα�

		// �� ��� ���ڿ�(sb3 �� "�ѱ�seoulkorea�츮������ѹα�")��
		//	  "korea"���ڿ� �ڿ� "���"�̶�� ���ڿ� �߰�
		//	  ��, ��� ���ڿ��� �ε����� ������ ���� Ȯ������ �ʰ�...
		//	  ��, ��"�ѱ�seoulkorea����츮������ѹα�"������ ����
		
		//sb3 = sb3.append("���");
		//System.out.println(sb3);
		

		//�׽�Ʈ ��
		System.out.println(sb3.toString());
		//--==>> �ѱ�seoulkorea�츮������ѹα�

		//�׽�Ʈ ��
		//sb3.insert(12,"���");
		//System.out.println("korea�ڿ� ������� �߰� : " + sb3);
		//korea�ڿ� ������� �߰� : �ѱ�seoulkorea����츮������ѹα�
		//System.out.println("korea�ڿ� ������� �߰� : " + sb3.toString());
		//korea�ڿ� ������� �߰� : �ѱ�seoulkorea����츮������ѹα�

		//�׽�Ʈ��
		sb3.indexOf("korea");
		System.out.println(sb3.indexOf("korea"));
		//--==>> 7

		//�׽�Ʈ 4
		//System.out.println(sb3.insert(sb3.indexOf("korea"), "���"));
		//--==>> �ѱ�seoul���korea�츮������ѹα�

		//�׽�Ʈ �� 
		//System.out.println(sb3.insert(sb3.indexOf("korea") +5, "���"));
		//--==>> �ѱ�seoulkorea����츮������ѹα�

		//�׽�Ʈ �� 
		System.out.println(sb3.insert(sb3.indexOf("korea")+"korea".length(), "���"));
		//--==>> �ѱ�seoulkorea����츮������ѹα�

		System.out.println(sb3.toString());
		//--==>> �ѱ�seoulkorea����츮������ѹα�

		// �� ��� ���ڿ�(sb3)���� 
		//	  ��"�츮����"�����ڿ� ����

		//sb3.delete(14,18);
		//System.out.println(sb3);
		//--==>> �ѱ�seoulkorea������ѹα�
		
		sb3.delete(sb3.indexOf("�츮����"),sb3.indexOf("�츮����")+"�츮����".length());
		System.out.println(sb3);
		//--==>> �ѱ�seoulkorea������ѹα�

		//sb3.delete(14,18);
		//			 --	-- 
		//			 ��	����������������������
		//	sb3.indexOf("�츮����")		 sb3.indexOf("�츮����")+"�츮����".length()


		// �� ��� ���ڿ�(sb3)����
		//	  ��"korea"������ ��� ���ڿ� ����(korea����)
		//	  �ѱ�seoulkorea������ѹα� �� �ѱ�seoul

		//sb3.delete(sb3.indexOf("korea"), sb3.length());
		//System.out.println(sb3);
		//--==>> �ѱ�seoul

		//sb3.delete(7,18);
		//System.out.println(sb3);

		//sb3.delete(7);
		//System.out.println(sb3);

		//sb3.delete(7,18);
		//			-- -- 
		//			�� ��������������ab3.length()
		//			��
		//	sb3.indexOf("korea")	
		
		sb3.delete(sb3.indexOf("korea"), sb3.length());
		System.out.println(sb3);
	
		/////////////////////////////////////////////////////////////////////////
		
		//����ũ�� �ٽ� Ȯ��
		System.out.println("����ũ�� : " + sb3.capacity());
		//--==>> ����ũ�� : 34
		//		 ���빰�� �پ�� ����ũ��� �پ���� �ʴ´�. 
		//		 ������ �ڵ����� ���Ҵ� �ڵ� ������

		// ���ڿ�(sb3)�� ���� Ȯ��
		System.out.println("���ڿ��� ����  : " + sb3.length());
		//--==>> ���ڿ��� ����  : 7

		// ���� ũ�� ����
		// �� ���� ���ڿ��� ��Ƶ� �� �ִ� ������ ũ���....
		// trimToSize()
		sb3.trimToSize();		

		//���� ũ�� ���� ���� ���� ũ�� �ٽ� Ȯ��
		System.out.println("����ũ�� : " + sb3.capacity());
		//--==>> ����ũ�� : 7
	
	
		

	
	}
}