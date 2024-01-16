/*============================================
  ���� �ڹ��� �ֿ�(�߿�) Ŭ���� ����
  - �ڹٿ��� �⺻������ �����ϴ� �ֿ� Ŭ������
  - Wrapper Ŭ����
==============================================*/

public class Test134
{
	public static void main(String[] args)
	{
		byte b = 3;
		int i = 256;

		Byte b2 = new Byte(b);
		Integer i2 = new Integer(i);

		System.out.println(b2);
		System.out.println(i2);
		//--==>> 3
		//		 256

		print(b2);
		print(i2);
	}
	
	// Number n = new Integer();
	// java.lang.Number Ŭ���� (�߻� Ŭ����)�� 
	// ��� ������ Wrapper Ŭ������ �θ� Ŭ����
	// (���� Ŭ����. ���� Ŭ����)�̴�.
	// b2,i2�� �ش��ϴ� �ڷ����� Number �� �Ѿ���鼭
	// �� ĳ������ �Ͼ�� �ȴ�. 
	static void print(Number n)
	{
		System.out.println(n);
		
		if (n instanceof Integer)			//n�� Number�� �Ѿ������ ���� Integr���� �Ѿ�Դٸ�
		{
			System.out.println(n.intValue());
		}
	}

}