/*============================================
  ���� �ڹ��� �ֿ�(�߿�) Ŭ���� ����
  - �ڹٿ��� �⺻������ �����ϴ� �ֿ� Ŭ������
  - Wrapper Ŭ����
==============================================*/

/*
�� Wrapper Ŭ����

	1. �ڹٿ����� ��� ���ؿ��� �����ϴ� �⺻�� �����͸� ������
	   �������� Ŭ������ �����Ͽ� ��ü ������ ó���Ѵ�.
	   ���� �ڹٿ����� �̷��� �⺻�� �����͸� 
	   ��ü ������ ó���� �� �ֵ��� Ŭ������ ������ �� �ۿ� ���µ� 
	   �̷��� Ŭ�������� ������ Whapper Ŭ������ �Ѵ�.

	2. �⺻ �ڷ�����
	   byte, short, int,     long, float, double, char      ,boolean ���� �����ϴ�
	   Byte, Short, Integer, Long, Float, Double, Character ,Boolean ��				 // �⺻ �ڷ������� ��ü�� ����ϱ� ���� Wrapper Ŭ�����̴�. 1 : 1 ¦���� �ִ�!
	   Wrapper Ŭ���� �� ū ���ڵ��� �ٷ�� ����
	   Java.math.BigInteger �� java.math.BigDecimal Ŭ������ �����Ѵ�.				 // ��û���� ū ������ �ٷ� �� �ִ� Ŭ����
	  
	   Wrapper Ŭ������ java.lang ��Ű���� ���ԵǾ� �����Ƿ� 
	   ������ import ���� ���� �ٷ� ����ϴ� ���� �����ϸ�
	   �⺻���� ���������� WrapperŬ������ ���� �޼ҵ带 ����
	   �� ��ȯ�� �����ϴ� ���� �񱳿� ���� ���굵 �����ϴ�.

	   ex) java.lang.Integer Ŭ����
	   	   int �⺻ �ڷ����� Wrapper Ŭ������ 
		   ������ �ٷ�µ� �ʿ��� ����� �޼ҵ�, ��� ��ȯ� �ʿ���
		   �޼ҵ� ���� �����ϰ� �մ�.

		   Static Integer valueOf(int i)
		   int ���� Integer������ ��ȯ�Ѵ�.

		   Static Integer parseInt(String s)
		   ���ڿ� �������� ����� ���ڸ� ���� ���·� ��ȯ�Ͽ� ��ȯ�Ѵ�.
		   
			Integer.parseInt("���������ǹ��ڿ�");
			1. java.lang.Integer 	
			2. �ν��Ͻ� ���� ���� x �� static ���±��� Ŭ�����޼ҵ屸��
			��� ����� �� �� �ִ�!
			���� �翬�ϰ� �����ؾ� �Ѵ�!

		   byte byteValue()	, Int intValue()
		   short shortValue(), long ongValue()
		   float floatValue(), double doubleValue()
		   �ش� �⺻ �ڷ������� �� ��ȯ�� ���� ��ȯ�Ѵ�.

*/

/*
�� ���� �ڽ�(Auto-Boxing)�� ���� ��ڽ�(Auto-UnBoxing)

	�Ϲ������� ���۷��� ���� �⺻�ڷ����� ȣȯ���� ������
	�� ��� �߻��ϴ� ���� �ذ��� ���� �ڹٿ����� Wrapper Ŭ������ �����ϰ� �Ǿ���.
	������ JDK 1.5���� ���۷��� ���� �⺻ �ڿ����� 
	������ ���� �� ��ȯ�� �����ϵ��� �������� ������ �̷������ �Ǿ���.

	int a=10,b;
	Integer ob;
	ob = a;
	//-- �⺻ �ڷ���(int)�� Integer ������ �ڵ� ��ȯ(���� �ڽ�)
	//   �����δ�... ��ob = new Integer(a);�� �� �̰� �ڽ�

	b = ob;
	//-- Integer(��ü)�� �⺻ �ڷ��� int������ �ڵ� ��ȯ(���� ��ڽ�)
	//   �����δ� ... ��b = ob.intValue();�� �� �̰� ��ڽ� 
	�� 
	�̴� JDK1.5 ���� �߰��� ���� �ڽ� / ���� ��ڽ��̶�� 
	������� ���� �������� ���̴�. 


*/

public class Test130
{
	public static void main(String[] args)
	{
		int a= 10, b;
		Integer c;
		Object d;

		b = a;					//-- int �� ������(�ڷ�) �� int �� ����
		c = new Integer(0);		//-- ��ü ����

		// �� �⺻������ ���۷��� ��(���� Ÿ��)�� �⺻ �ڷ���(�⺻ Ÿ��)�� ȣȯ���� �ʴ´�. 
		
		b = c;					//-- Integer �� ������(��ü) �� int �� ����(���� ��ڽ�)
		b = c.intValue();		//-- ��ü�� �޼ҵ� ȣ���� ���� ����� ��ȯ(��ڽ�)

		d = new Object();		//-- ��ü ����
		System.out.println("d.toString() : " + d.toString());
		//--==>> d.toString() : java.lang.Object@15db9742				// ����ڿ��� ��� �ִ��� �˷��ٷ��� java.lang�� ����

		d = new Integer(10);	//-- �� ĳ����
		System.out.println("d.toString() : " + d.toString());
		//--==>> d.toString() : 10
		//		 Integer Ŭ�������� Object�κ��� ��ӹ��� toString()�޼ҵ带 �������̵� �ߴ�.
		
		d = new Double(12.345);	//-- �� ĳ����
		System.out.println("d.toString() : " + d.toString());
		//--==>> d.toString() : 12.345
		// 		  double Ŭ�������� Object�κ��� ��ӹ��� toString()�޼ҵ带 �������̵� �ߴ�.

		// Object d = 10
		d = 10;					//-- ���� �ڽ� �� �� ĳ����
		System.out.println("d.toString() : " + d.toString());
		//--==>> d.toString() : 10
		//		 ���� ����� ���� Object�� toString()�޼ҵ尡 �������̵� �ƴٴ� ���� �� �� �ִ�. �� Integer�� �������̵� ��Ŵ!!
		//		 
		

	}
}