/*=================================================================
���� Ŭ������ �ν��Ͻ� ����
- �޼ҵ� �����ε�(Method Overloading)�� ������ ���¿� �Ұ����� ����
=================================================================*/

public class Test104
{
	public static void main(String[] args)
	{
		
	}

	public static void print() {}
	//public static void print() {}							//-- (X)
	public static void print(int i) {}
	//public static void print(int j) {}					//-- (X)
	public static void print(char c) {}						//-- �ڵ� �� ��ȯ ��Ģ check~!!!
	public static void print(int i, int j) {}
	public static void print(double d) {}					//-- �ڵ� �� ��ȭ ��Ģ check~!!!
	//public static void print(double e) {return 10.0;}		//-- ���� �Ұ�(return �ڷ��� ����)
	//public static double print(double e) {return 10.0;}	//-- (X) check~!!! �޼ҵ� ������ �޼ҵ� ȣ�� ���Ŀ� �����ϱ� ������ ȣ�� ��ü���� �ɸ�
}