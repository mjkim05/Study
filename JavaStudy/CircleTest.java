
/*======================================
	���� Ŭ������ �ν��Ͻ� ����
  ======================================*/

//Test071.java�� �Ѽ�Ʈ~~!!!

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

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
/*
public class CircleTest	
{
	
	//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));			// ���� ������ �ȵ�!!! �߸� �Ȱ���!!!!
	int n;			// ���� ������
		
	
	void input() throws IOException			//IOException ��ġ check~~~~!!!!!!!!!!�ڡ�
	{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	System.out.print("������ �Է� : ");
	n = Integer.parseInt(br.readLine());
	}

	double cirArea()						// ���� ����
	{
		return  ((n * n) * 3.141592);
	}

	double cirLength()						// ���� �ѷ�
	{
		return  ((n * 2) * 3.141592);
	}
	
	//��� ���
	void print(double a, double b)
	{
	System.out.println();
	System.out.printf(" >> �������� %d�� ����\n" , n );
	System.out.println(" >> ���� : " + a);
	System.out.println(" >> �ѷ� : " + b);
	}

	
}
*/


public class CircleTest	
{
	// �ֿ� �Ӽ�(������, ����)  ��	��� ����
	int r;						// -- ������
	final double PI = 3.141592;	// -- ������(������ ���ȭ)

	// �ֿ� ��� (����, ����)	��	��� �޼ҵ�
	
	//������ �Է� ���
	void input() throws IOException
	{	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("������ �Է� : ");
		r = Integer.parseInt(br.readLine());
	}

	// ���� ��� ���
	double calArea()
	{
		//���� ���� = ������ * ������ * 3.141592
		return r * r * PI;
	}

	// �ѷ� ��� ���
	double calLength()
	{
		double result;

		//���� �ѷ� = ������ * 2 * 3.141592
		result = r * 2 * PI;

		return result;
	}

	// ��� ��� ��� 
	void print(double a, double l)
	{

	// >> �������� xxx�� ����
	// >> ���� : xxx.xx
	// >> �ѷ� : xx.xx

	System.out.printf("\n >> �������� %d�� ���� \n", r);
	System.out.printf(" >> ���� : %2f \n" , a);
	System.out.printf(" >> �ѷ� : %2f \n ", l);
	}

}