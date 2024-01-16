/*=============================================
  ���� ���� ó��(Exception Handling) ����
==============================================*/

// �ٸ� ���� �ٽ� ������
// ������ ������ �޶����ٰ� ����!

public class Test153
{
	public int getValue(int Value)	throws Exception				// �� ���� ������ (�Ķ� ��ź)
	{
		int a = 0;
		try
		{
			a = getData(-2);										// �� ���� �߻� (���� ��ź)

		}
		catch (Exception e)											// �� ���� ��Ƴ��� (���� ��ź )
		{	
			// �� ���� ó�� (���� ��ź)
			System.out.println("printStackTrace...........");		
			e.printStackTrace();
			
			//check~~!! 
			// �� ���� �߻�(�Ķ� ��ź)
			throw new Exception("value �� �����Դϴ�.");				
		}
		return a;
	}	

	public int getData(int data) throws Exception					// �� ���� ������ (������ź)
	{
		if (data < 0 )
		{
			throw new Exception("data�� 0���� �۽��ϴ�.");			// �� ���� �߻�
																	// (���� ��ź)
		}
		return data +10;
	}	

	public static void main(String[] args)
	{
		Test153 ob = new Test153();

		try
		{
			int a = ob.getValue(-2);								// �� ���� �߻� (�Ķ� ��ź)
			System.out.println("a : " + a);
	
		}
		catch (Exception e)											// �� ���� ��Ƴ��� (�Ķ� ��ź)
		{	
			// �� ���� ó��
			System.out.println("printStackTrace..............");
			e.printStackTrace();
		}
	}
	
}

// ������
/*

printStackTrace...........
java.lang.Exception: data�� 0���� �۽��ϴ�.
        at Test153.getData(Test153.java:35)
        at Test153.getValue(Test153.java:15)
        at Test153.main(Test153.java:47)
printStackTrace..............
java.lang.Exception: value �� �����Դϴ�.
        at Test153.getValue(Test153.java:26)
        at Test153.main(Test153.java:47)
����Ϸ��� �ƹ� Ű�� �����ʽÿ� . . .

*/