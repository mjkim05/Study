/*====================================================================
  ���� Ŭ������ �ν��Ͻ� ����
- �޼ҵ� �����ε�(Method Overloading)�� ������ ���¿� �Ұ����� ����
====================================================================*/

public class Test104
{
	public static void main(String[] args)
	{
		print('A');

		print(20);


		print(3.14);

		double result = print(3.14);
	}

	public static void print() {}
	//public static void print() {}							//--(��)
	public static void print(int i) {}	
	//public static void print(int j) {}					//--(��)
	public static void print(char c) {}						//-- �ڵ� �� ��ȯ ��Ģ check~!!! �� char���� int�� �ڵ� �� ��ȯ�� �� �־� �����ؼ� �����
	public static void print(int i, int j) {}
	public static void print(double d) {}					//-- �ڵ� �� ��ȯ ��Ģ check~!!! �� int���� double�� �ڵ� �� ��ȯ�� �� �־� �����ؼ� �����
	//public static void print(double e) {return 10.0}		//--(��) �� return���� �Ǽ����� ��ȯ�ϴµ� void�� ���� ��ü�� �Ұ�
	//public static double print(double e) {return 10.0}	//--(��) check~!!! �� ����ȣ25

}