/*=============================================
  ���� �ڹ��� �⺻ ���α׷��� ����
  - ������ �ڷ���
  - �ڹ��� �⺻ ����� : System.util.Scanner
==============================================*/

// �� java.util.Scanner
//    �ܶ� ���� ������ ����Ͽ� �Է��� ��ū�� ���� �����ϸ�
//	  ����Ʈ(default)�� ���Ǵ� �ܶ����ڴ� �����̴�.
//	  �ۼ��� ���� ��ū�� ��next()���޼ҵ� ���
//    �ٸ� ����(�ڷ���)�� ������ ��ȯ�� �� �ִ�.

import java.util.Scanner;


public class Test017
{
	public static void main(String[] args) //throws IOException ��ĳ�ʴ� ��� ���ص� �� �̹� ����
	{
		//�ֿ� ���� ����

		//Scanner Ŭ���� ����� �ν��Ͻ� ����
		Scanner sc = new Scanner(System.in);

		String name;			//-- �̸�
		int kor, eng, mat;		//-- ����, ����, ���� ����


		//���� �� ó��
		System.out.print("�̸��� �Է��ϼ��� : ");
		name = sc.next();
		
		// �׽�Ʈ(Ȯ��)
		//System.out.println("�Է��� �̸� : " + name);

		System.out.print("���� ���� �Է� : ");			//"90"
		//kor = Integer.parseInt(br.readLine());
		//kor = Integer.parseInt(sc.next());
		kor = sc.nextInt();

		System.out.print("���� ���� �Է� : ");
		eng = sc.nextInt();

		System.out.print("���� ���� �Է� : ");
		mat = sc.nextInt();

	

		//��� ���

		System.out.println();											// ����
		System.out.println(" >> �̸� : " + name);
		//System.out.println(" >> ���� : " + kor + eng + mat );			// 80 90 80 �̷������� ����
		System.out.println(" >> ���� : " + (kor + eng + mat));

	}
}
// ���� ���

/*
�̸��� �Է��ϼ��� : �����
���� ���� �Է� : 80
���� ���� �Է� : 90
���� ���� �Է� : 70

 >> �̸� : �����
 >> ���� : 240
����Ϸ��� �ƹ� Ű�� �����ʽÿ� . . .
*/