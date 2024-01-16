/*==========================
  ���� Ŭ���� ��� ����
  - �������̽�(Interface)
============================*/

// �� �ǽ� ����
//	  ���� ó�� ���α׷��� �����Ѵ�.
//	  ��, �������̽��� Ȱ���� �� �ֵ��� �Ѵ�.

// ���� ��)
// �ο� �� �Է�(1~10) : 11
// �ο� �� �Է�(1~10) : 0
// �ο� �� �Է�(1~10) : 2

// 1��° �л��� �й� �̸� �Է�(���� ����) : 2309123 ��ٽ�
// ���� ���� ���� ���� �Է�   (���� ����) : 90 100 85
// 2��° �л��� �й� �̸� �Է�(���� ����) : 2309125 �赿��
// ���� ���� ���� ���� �Է�   (���� ����) : 85 70 60

// 2309123 ��ٽ� 90 100  85		xxx(����) xx.xx(���)
//				  ��  ��  ��
// 2309125 �赿�� 90 100  85		xxx(����) xx.xx(���)
//				  ��  ��  ��

// ����̾簡

// 90 �̻�		   �� ��
// 80 �̻� 90 �̸� �� ��
// 70 �̻� 80 �̸� �� �� 
// 60 �̻� 70 �̸� �� ��
// 60 �̸�(�׿�)   �� �� 

import java.util.Scanner;
import java.io.IOException;

class Record
{
	String hak, name;				//-- �й�, �̸�
	int kor, eng, mat;				//-- ����, ����, ���� ����
	int tot;						//-- ����
	double avg;						//-- ���
}

interface Sungjuk
{
	public void set();				//-- �ο� ����
	public void input();			//-- ������ �Է�
	public void print();			//-- ��� ���
}

// ���� �ذ� �������� �����ؾ��� Ŭ���� �� Sungjuk �������̽��� �����ϴ� Ŭ����
class SungjukImpl implements Sungjuk
{
	private int inwon;
	private Record[] rec;

	// �ο� �� �Է� �޴� �޼ҵ� ����
	@Override
	public void set()
	{
		Scanner sc = new Scanner(System.in);
		do
		{
			System.out.print("�ο� �� �Է�(1~10) : ");
			inwon = sc.nextInt();
		}
		while (1 > inwon || 10 < inwon);
	}	

	// �й�, �̸�, ���� �� �����͸� �Է� �޴� �޼ҵ� ����
	@Override
	public void input()	
	{
		Scanner sc = new Scanner(System.in);
		rec = new Record[inwon];			//�迭 ���� inwon �� ��ŭ ����

		for (int i=0; i<inwon; i++)
		{
			rec[i] = new Record();			//rec[i]��°�� �濡 Record Ŭ���� �ν��Ͻ� ����!


			System.out.printf("%d��° �л��� �й� �̸� �Է�(���鱸��) : ", i+1);
			rec[i].hak = sc.next();
			rec[i].name = sc.next();

			System.out.print("���� ���� ���� ���� �Է�(���� ����) : ");
			rec[i].kor = sc.nextInt();
			rec[i].eng = sc.nextInt();
			rec[i].mat = sc.nextInt();

			rec[i].tot = rec[i].kor + rec[i].eng + rec[i].mat;
			rec[i].avg = rec[i].tot / 3.0;
		}	
		
		System.out.println();
	}
	
	// ��ü ����� ����ϴ� �޼ҵ� ����
	@Override
	public void print()
	{
		for (int i = 0; i< inwon; i++)
		{
			System.out.printf("%8s %s %d %d %d %d %.2f\n",rec[i].hak, rec[i].name, rec[i].kor, rec[i].eng, rec[i].mat, rec[i].tot, rec[i].avg);
			System.out.printf("%17s %s %s\n", panjung(rec[i].kor), panjung(rec[i].eng), panjung(rec[i].mat));
		}
	}
	
	// ���������� ��޿� ���� ������ ������ �޼ҵ�
	private String panjung(int score)
	{
		String str;
		
		if (score >= 90)
			str = "��";
		else if (score >= 80)
			str = "��";
		else if (score >=70)
			str = "��";
		else if (score >=60)
			str = "��";
		else 
			str = "��";
		
		return str;	
	}
	
}


public class Test121
{
	public static void main(String[] args)
	{
		Sungjuk ob = new SungjukImpl();

		ob.set();
		ob.input();
		ob.print();

	}
}
//������
/*

�ο� �� �Է�(1~10) : 3
1��° �л��� �й� �̸� �Է�(���鱸��) : 17234006 �����
���� ���� ���� ���� �Է�(���� ����) : 80 75 95
2��° �л��� �й� �̸� �Է�(���鱸��) : 23234021 ä�ټ�
���� ���� ���� ���� �Է�(���� ����) : 85 65 50
3��° �л��� �й� �̸� �Է�(���鱸��) : 18234008 ������
���� ���� ���� ���� �Է�(���� ����) : 75 85 91

17234006 ����� 80 75 95 250 83.33
                �� �� ��
23234021 ä�ټ� 85 65 50 200 66.67
                �� �� ��
18234008 ������ 75 85 91 251 83.67
                �� �� ��
����Ϸ��� �ƹ� Ű�� �����ʽÿ� . . .



*/