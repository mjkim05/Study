/*======================================
	���� Ŭ������ �ν��Ͻ� ����
	�� ������ (Constructor)
  ======================================*/

class NumberTest2
{
	int num;

	// ����Ʈ(default) ������
	/*
	NumberTest2()
	{
		
	}
	*/

	// �� ����� ���� �����ڰ� ���ǵǾ� �����Ƿ� 
	//	  default �����ڰ� �ڵ����� ���Ե��� ����~~!!1 
	
	//������ �� ����� ���� ������
	NumberTest2(int n)
	{
	num = n;
	System.out.println("������ ȣ�� �� �Ű����� ���� : "+n);
	}

	int getNum()
	{
		return num;
	}
}

public class Test075
{
	public static void main(String[] args)
	{
		//NumberTest2 �ν��Ͻ� ����
		//NumberTest2 ob = new NuberTest2();
		//--==>> ���� �߻�(������ ����)
		//-- NumberTest2 Ŭ��������
		//	 ����� ���� �����ڰ� �����ϰ� �ִ� ��Ȳ�̱� ������
		//	 ��default�������ڰ� �ڵ����� ���Ե��� ������ 
		//	 ����ڰ� ������ �����ڴ� �Ű������� ���� �����̹Ƿ� 
		//   �̿� ���� �Ű����� ���� �����ڸ� ȣ���ϴ� ������ ������
		//   ������ �߻���Ű�� �ȴ�.

		NumberTest2 ob2 = new NumberTest2(10);
		//--==>> ������ ȣ�� �� �Ű����� ���� : 10

		System.out.println("�޼ҵ� ��ȯ �� : " + ob2.getNum());
		//--==>> �޼ҵ� ��ȯ �� : 10
		System.out.println("ob2.num : " + ob2.num);
		//--==>> ob2.num : 10

		NumberTest2 ob3 = new NumberTest2(2000);
		System.out.println("�޼ҵ� ��ȯ �� : " + ob3.getNum());
		System.out.println("ob3.num : " + ob3.num);
		//--==>> �޼ҵ� ��ȯ �� : 2000
		//--==>> ob3.num : 2000
	
		
	}
}