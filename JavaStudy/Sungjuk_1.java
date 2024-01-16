/*==================================
   ���� Ŭ������ �ν��Ͻ� ����
	- Ŭ������ �ν��Ͻ� Ȱ��
  ==================================*/
  
  // 2. sungjuk Ŭ����
  //    - �ο� ���� �Է� �޾� 
  //      �Է¹��� �ο� �� ��ŭ �̸�, ��������, ��������, ���������� �Է¹ް�
  //      ������ ����� �����ϴ� Ŭ������ ������ �� 
  //	  �Ӽ� : �ο���, Record Ÿ���� �迭 �� �л����� �迭
  //	  ��� : �ο��� �Է�, �� ������ �Է�, ���� �� ��� ����, ��� ���


  // �����ϸ� ���� Ǯ� ���� 

import java.util.Scanner;

public class Sungjuk_1
{
	
	// �ֿ� �Ӽ� ����

	int inwon;						//-- �ο���
	Record[] rec;					//-- Record Ÿ���� �迭(�л� �� �� �� Record �迭 �� �� �� Ȱ��)
									//   Record �� ������� ������ ��ü�� ��Ƴ� �� �ִ� �迭
	String[] subTitle = {"���� ���� : ", "���� ���� : ", "���� ���� : "};	

	// �ֿ� ��� ����
	// �� �ο� �� �Է�
	public void set()
	{
		Scanner sc = new Scanner(System.in);

		do
		{
			System.out.print("�ο� �� �Է� (1~100) : ");
			inwon = sc.nextInt();
		}
		while (1>inwon || 100<inwon);
		
		// check~~!!
		// Record Ŭ������ ������� ������ ��ü(�ν��Ͻ�)�� ���� �� �ִ� 
		// �迭���� inwon ��ŭ ������ �� �ϻ�
		// Record Ŭ������ �ν��Ͻ��� ������ ���� �ƴϴ�~~!!  
		rec = new Record[inwon];
	}
		
	// �� �� ������ �Է� + �� ���� �� ��� ����
	public void input()
	{
		Scanner sc = new Scanner(System.in);

		// �ο� �� ��ŭ �ݺ� �� �ο� ���� ����Ͽ� ������� �迭�� ���̸�ŭ �ݺ� 
		//for (int i=0; i<inwon; i++)
		for (int i=0;i<rec.length;i++)
		{
			// check~~!! 
			// Record Ŭ���� ����� �ν��Ͻ� ����
			//Record ob = new Record();
			//rec[i] = ob;
			rec[i] = new Record();

			System.out.printf("%d��° �л��� �̸� �Է� : ", (i+1));
			rec[i].name = sc.next();

			/*
			
			System.out.printf("���� ���� �Է� : ");
			rec[i].score[0] = sc.nextInt();
			System.out.printf("���� ���� �Է� : ");
			rec[i].score[1] = sc.nextInt();
			System.out.printf("���� ���� �Է� : ");
			rec[i].score[2] = sc.nextInt();
			
			*/
		
			for (int j=0; j<subTitle.length; j++)
			{
				//�ȳ� �޼��� ���
				System.out.print(subTitle[j]);
				rec[i].score[j] = sc.nextInt();

				// ����, ����, ���� ���� �����͸� �ݺ������� �Է¹޴� ���� 
				// ������ ���� ���� ����
				rec[i].tot += rec[i].score[j];
			}

			// ��� �����ϱ� 
			 rec[i].avg = rec[i].tot / 3.0;
		}// end outer for 

	
	}//end outer input()

	// �� ��� ���
	// ������ 90 80 70 240 XX.XX 2
	// ������ 92 82 72 XXX XX.XX 1
	// ����� 82 72 62 XXX XX.XX 3

	public void print()
	{
		//���� ���� ���� �޼ҵ� ȣ��
		ranking();

		//����
		System.out.println();

		// �л� �� �� �� �ݺ� ��� ���� ����
		// for (int i=0; i<inwon; i++)
		for (int i=0; i<rec.length; i++)
		{
			// �̸� ���
			System.out.printf("%s", rec[i].name);
			
			//����(����, ����, ����) �ݺ� ���
			for (int j=0; j<3; j++)
			{
				System.out.printf("%4d", rec[i].score[j]);
			}
			
			// ����, ��� ���
			System.out.printf("%5d", rec[i].tot);
			System.out.printf("%8.2f", rec[i].avg);

			// + ���� �߰�	
			System.out.printf("%4d",rec[i].rank);

			//����
			System.out.println();
		
		}
			
		
	}

	// + �� ���� ���� 
	//		- ���� �������� ���꿡 �ʿ��� �����Ͱ� �̹� �����ϴ� ��Ȳ �� �Ű����� �Ѱ��� �ʿ� ����
	//		- Record �迭�� rank �Ӽ��� ���� ��� ���� ��� ���� �� ��ȯ �ڷ��� void
	//		- Ŭ���� ���ο��� Ȱ���� �޼ҵ�� ���� �� �������� ������ private
	private void ranking()
	{
		// ��� �л����� ���(����, rank)�� 1�� �ʱ�ȭ
		for (int i=0; i<inwon; i++)
		{
			rec[i].rank = 1;
		}

		// ��� ���� �� �Է� �ο��� 5���̶� �����ϸ�...  
		for (int i =0; i<inwon-1; i++)						// ��	�� �񱳱��� �� 0     1    2   3
		{
			for (int j=i+1; j<inwon; j++)					// ���� �� �񱳴�� �� 1234  234  34  4
			{
				if (rec[i].avg > rec[j].avg)				// �񱳱����� ����� �񱳴���� ��պ��� ũ�ٸ�
				{
					// �񱳴���� rank�� 1��ŭ ����
					rec[j].rank ++;
				}
				else if(rec[i].avg < rec[j].avg)				// �񱳴���� ����� �񱳱����� ��պ��� ũ�ٸ�
				{
					// �񱳱����� rank�� 1��ŭ ����
					rec[i].rank++;
				}

			}//end outer for


		}//end outer for
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	public void ranking()	
	{			
		
		for (int i=0; i<rec.length; i++)
		{
			rec[i] = new Record();
		
			if (rec[i].avg<rec[i+1].avg)
			{
				rec[i].rank ++;
			}

			//return rec[i].rank;
		}

	}
	*/


	
}