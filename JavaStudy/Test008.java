/*====================================
  ���� �ڹ��� ���� �� Ư¡ ����
  - ������ �ڷ���
  - ������ �ڷ��� �ǽ� �� �׽�Ʈ : char
======================================*/

public class Test008
{
	public static void main(String[] args)
	{
		// �ֿ� ���� ����
		char ch1, ch2, ch3;

		int a;					// ~check~!!!!

		// ���� �� ó��
		ch1 = 'A';
		//ch2 = 'B';
		//ch2 = 'BB'; 
		ch2 = '��';
		ch3 = '\n';				// ���� ����

		//a = 10;
		//a = ch1;				// ~check~!!!!
		a = (int)ch1;			// !check~!!!!
		// -- ����� �� ��ȯ(���� �� ��ȯ)


		// ��� ���
		System.out.println(" ch1 : " + ch1);
		System.out.println(" ch2 : " + ch2);
		System.out.println(" ch3 : " + ch3);


		System.out.println(" a : " + a);


		// ��� ��� 
		//System.out.println(" �� �� �� ��%n" ,ch1, ch2,ch3,a);
		System.out.printf("%c %c %c %d%n" ,ch1, ch2,ch3,a);


	}
}

//������
/*
 ch1 : A
 ch2 : ��
 ch3 :

 a : 65
A ��
 65
����Ϸ��� �ƹ� Ű�� �����ʽÿ� . . .

*/