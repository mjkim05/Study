/*=============================================
  ���� �ڹ��� �⺻ ���α׷��� ����
  - �ڹٿ��� �⺻������ �����ϴ� �ֿ� Ŭ����
  - Calendar Ŭ����
==============================================*/

// �� ������ �������� �Է¹޴� ��¥��ŭ ���� ��, ��, ��, ������
//	  Ȯ���Ͽ� ����� ����ϴ� ���α׷��� �����Ѵ�.

// ���� ��)
// ���� ��¥ : 2023-9-19 ȭ����
// �� �� ���� ��¥�� Ȯ���ϰ��� �Ͻʴϱ�? : 200

// ===============[Ȯ�� ���]=============== 
// 200�� �� : XXXX. XX. XX. X����
// =========================================

// Calendar�� ���� �� API Document ����~~~
// ��add()��
//  : ���� ��¥�� �������� �� �� ���ϴ� ���� �޼ҵ�
//   �� ����ü.add(Calendar.DATE, ����);��

import java.util.Calendar;
import java.util.Scanner;

public class Test144
{
	public static void main(String[] args)
	{
		/*

		// Calendar Ŭ���� �ν��Ͻ� ����
		Calendar cal = Calendar.getInstance();

		Scanner sc = new Scanner(System.in);
		
		int n;				//��¥ ����
		
		int y = cal.get(Calendar.YEAR);
		int m = cal.get(Calendar.MONTH)+1;
		int d = cal.get(Calendar.DATE);
		int w = cal.get(Calendar.DAY_OF_WEEK);
		
		String[] strArr = {"�Ͽ���", "������", "ȭ����","������","�����","�ݿ���","�����"};
		
		System.out.printf(" ���� ��¥ : %d %d %d %s\n", y , m, d, strArr[w-1]);	

		System.out.print(" �� �� ���� ��¥�� Ȯ���ϰ��� �Ͻʴϱ�? :");
		n = sc.nextInt();

		//�׽�Ʈ(Ȯ��)
		//System.out.print(n);

		cal.add(Calendar.DATE, n);

		// ��� �� �ۼ�
		// 200�� �� : XXXX. XX. XX. X����
		System.out.println();
		System.out.println(" ===============[Ȯ�� ���]=============== ");
		System.out.printf(" %d�� �� : %d - %d - %d %s\n", n, cal.get(Calendar.YEAR),cal.get(Calendar.MONTH)+1,cal.get(Calendar.DATE),strArr[cal.get(Calendar.DAY_OF_WEEK)-1]);
		System.out.println(" ========================================= ");
		*/

		//Scanner �ν��Ͻ� ����
		Scanner sc = new Scanner(System.in);

		//Calendar �ν��Ͻ� ����
		Calendar now = Calendar.getInstance();

		//�ֿ� ���� ����
		int nalsu;
		int y,m,d,w;
		String[] week = {"��","��","ȭ","��","��","��","��"};

		//������ ��, ��, ��, ����(�� �������� : get())
		y = now.get(Calendar.YEAR);
		m = now.get(Calendar.MONTH)+1;
		d = now.get(Calendar.DATE);
		w = now.get(Calendar.DAY_OF_WEEK);

		// ������ �� , ��, ��, ���� Ȯ�� ��� ���
		System.out.println(" ���� ��¥ : " + y +"-"+ m +"-"+ d + "-" + " " + week[w-1]+ "����");
		
		do
		{
			System.out.print(" �� �� ���� ��¥�� Ȯ���ϰ��� �Ͻʴϱ�? : ");
			nalsu = sc.nextInt();
		}
		while (nalsu<1);
		
		//check~~!!
		now.add(Calendar.DATE, nalsu);
		
		// ��� ���
		System.out.println();
		System.out.println(" ===============[Ȯ�� ���]=============== ");
		System.out.printf(" %d�� ��: %tF %tA\n" , nalsu, now,now);
		System.out.println(" ========================================= ");
		
			
		// %t�� ��ü�� ��¥ ��ü��� �����ϸ� ��

		//String.format("%tF", �޷°�ü);
		// �� ����-��-�ϡ� ������ ���ڿ� ��ȯ
		//String format("%tA", �޷� ��ü)
		// �� ���� ������ ���ڿ� ��ȯ


		
	}
}

//���� ���
/*
 ���� ��¥ : 2023 9 19 ȭ����
 �� �� ���� ��¥�� Ȯ���ϰ��� �Ͻʴϱ�? :200

 ===============[Ȯ�� ���]===============
 200�� �� : 2024 - 4 - 6 �����
 =========================================
����Ϸ��� �ƹ� Ű�� �����ʽÿ� . . .

 ���� ��¥ : 2023-9-19- ȭ����
 �� �� ���� ��¥�� Ȯ���ϰ��� �Ͻʴϱ�? : -4
 �� �� ���� ��¥�� Ȯ���ϰ��� �Ͻʴϱ�? : 5

 ===============[Ȯ�� ���]===============
 5�� ��: 2023-09-24 �Ͽ���
 =========================================
����Ϸ��� �ƹ� Ű�� �����ʽÿ� . . .


*/