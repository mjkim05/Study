/*========================================
  ���� ���� �帧�� ��Ʈ�� (���) ����
  - switch�� �ǽ� 
  ==========================================*/

// ����ڷκ��� 1���� 3������ ���� �� �ϳ��� �Է� ������
// �Է¹��� ������ŭ�� ������(��)�� ��µǴ� ���α׷��� �ۼ��Ѵ�.
// ��, �ΰ��� ������� ������ �� �ֵ��� �Ѵ�.

// �� switch ���� �Ϲ� ���� ����Ͽ� �����Ѵ�.		// ������ ���ϰ� �ϱ�
// �� switch ���� �⺻ ���� ����ϵ�, 
//		break �� �� �ѹ� �� ����� �� �ֵ��� �����Ѵ�.  // �Է� �����Ҷ� �� �ѹ� ���

// ���� �� )
// ������ ���� �Է� (1~3): 3
// �ڡڡ�
// ����Ϸ��� �ƹ�Ű�� ��������...

// ���� �� )
// ������ ���� �Է� (1~3): 1
// ��
// ����Ϸ��� �ƹ�Ű�� ��������...

// ���� �� )
// ������ ���� �Է� (1~3): 7
// �Է¿���~!!
// ����Ϸ��� �ƹ�Ű�� ��������...


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Test041
{
	public static void main(String[] args) throws IOException
	{
		
		//�ֿ� ���� ����
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		/*int a;				//���� �Է� ��
		String b;			//��� �� ��ȯ
		
		//���� �� ó��
		System.out.print("������ ���� �Է� (1~3) : ");
		a = Integer.parseInt(br.readLine());
		*/
		
		// switch�� �Ϲ� ���� ����Ͽ� ����
		/*
		switch (a)
		{

		case 1: b = "��";		break;
		case 2: b = "�ڡ�";		break;
		case 3: b = "�ڡڡ�";	break;
		default: b = "�Է� ����~~!!";

		}
		
		// switch�� �⺻ ���� ����Ͽ� ���� (��, break ���� �ѹ��� ����� ��!)  

		switch (a)
		{
		case 1: b = "��"; 	
		case 2: b = "�ڡ�"; 
		case 3:	b = "�ڡڡ�"; break;
		default: b = "�Է� ����~~!!"; 
		
		}
			
		System.out.printf("%s\n" , b);
		*/

		//------------------------------------------------------------------------------------------------------------------
		
		int n;				//���� �Է� ��
		
		System.out.print("������ ���� �Է� (1~3) : ");
		n = Integer.parseInt(br.readLine());
		
	
		//��
		/*
		switch (n)
		{
		case 1: System.out.println("��"); break;
		case 2: System.out.println("�ڡ�"); break;
		case 3: System.out.println("�ڡڡ�"); break;
		default: System.out.println("�Է� ����~~!!");
		}
		*/
		//��
		switch (n)
		{
		
		case 3: System.out.print("��"); 
		case 2: System.out.print("��");
		case 1: System.out.print("��"); break;

		default: System.out.println("�Է� ����~~!!");
		}

		System.out.println();
		//------------------------------------------------------------------------------------------------------------------
	}
}

//���� ���

/*
������ ���� �Է� (1~3) : 1
��
����Ϸ��� �ƹ� Ű�� �����ʽÿ� . . .
*/

/*
������ ���� �Է� (1~3) : 2
�ڡ�
����Ϸ��� �ƹ� Ű�� �����ʽÿ� . . .
*/

/*
������ ���� �Է� (1~3) : 3
�ڡڡ�
����Ϸ��� �ƹ� Ű�� �����ʽÿ� . . .
*/

/*
������ ���� �Է� (1~3) : 4
�Է� ����~~!!

����Ϸ��� �ƹ� Ű�� �����ʽÿ� . . .
*/