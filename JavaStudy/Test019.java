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

public class Test019
{
	public static void main(String[] args)
	{
		//�ֿ� ���� ����
			
		Scanner sc = new Scanner(System.in);
		String name;
		int kor, eng, mat, tot;

		//���� �� ó��
		System.out.print("�̸�,����,����,���� �Է� (��,������):");
		//�̸�,����,����,���� �Է� (��,������) : ä�ټ�,80,90,90

		sc = new Scanner(sc.next()).useDelimiter("\\s*,\\s*");
		//				 ---------
		//		     "ä�ټ�,80,90,90"
		//new Scanner(sc(next()).useDelimiter("\\s*,\\s*");
		//						.�����ڻ��();
		//									  "\\s*,\\s*"	
		//										\s*,\s*
		//

		name = sc.next();
		kor = sc.nextInt();
		eng = sc.nextInt();
		mat = sc.nextInt();
		
		tot = kor + eng + mat;


		//��� ���
		System.out.println("\n>>�̸� : " + name);
		System.out.println(">> ���� : "+ tot);
	
	}
}