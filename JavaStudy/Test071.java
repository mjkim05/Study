/*======================================
	���� Ŭ������ �ν��Ͻ� ����
	 �� 
  ======================================*/


// �� CircleTest.java ���ϰ� �Ѽ�Ʈ~~!!

// ���� ���̿� �ѷ� ���ϱ�
// ���� ���̿� �ѷ��� ���� �� �ִ� Ŭ������ �����Ѵ�.
// Ŭ������ (CircleTest)
// �Է��� BufferedReader �� readLine()

// ���� ���� = ������ * ������ * 3.141592
// ���� �ѷ� = ������ * 2 * 3.141592

// ���� ��) 
// ������ �Է� : 

// >> �������� xxx�� ����
// >> ���� : xxx.xx
// >> �ѷ� : xx.xx
// ����Ϸ��� �ƹ�Ű�� ��������


import java.io.IOException;

public class Test071
{
	public static void main(String[] args) throws IOException
	{
	/*
	//CircleTest Ŭ���� ����� �ν��Ͻ� ����(��ü����)
	CircleTest ob = new CircleTest();
	
	// �Է� �޼ҵ� ȣ��
	ob.input();

	// ���� �޼ҵ� ȣ��
	double area = ob.cirArea();

	// �ѷ� �޼ҵ� ȣ��
	double length = ob.cirLength();


	// ��� �޼ҵ� ȣ��
	ob.print(area, length);
	*/

	// CircleTest Ŭ���� ����� �ν��Ͻ� ����
	// CircleTest �ν��Ͻ� ����
	// CircleTest ��ü ����
	
		CircleTest ob = new CircleTest();

		ob.input();
		
		double num1 = ob.calArea();

		double num2 = ob.calLength();

		ob.print(num1, num2);
		


	}
 
}

//������

/*

������ �Է� : 5

 >> �������� 5�� ����
 >> ���� : 78.5398
 >> �ѷ� : 31.41592
����Ϸ��� �ƹ� Ű�� �����ʽÿ� . . .

������ �Է� : 256

 >> �������� 256�� ����
 >> ���� : 205887.373312
 >> �ѷ� : 1608.495104
 ����Ϸ��� �ƹ� Ű�� �����ʽÿ� . . .


*/