  /*==================================
   ���� Ŭ������ �ν��Ͻ� ����
	- Ŭ������ �ν��Ͻ� Ȱ��
  ==================================*/
  
  // 2. sungjuk Ŭ����
  //    - �ο� ���� �Է� �޾� 
  //      �Է¹��� �ο� �� ��ŭ �̸�, ��������, ��������, ���������� �Է¹ް�
  //      ������ ����� �����ϴ� Ŭ������ ������ �� 
  //	   ��� : �ο��� �Է�, �� ������ �Է�, ���� �� ��� ����, ��� ���

import java.util.Scanner;

public class Sungjuk
{
	int n; 
	

	// �ο� �� �Է� ��� �޼ҵ�
	void input()	
	{
		//Scanner Ŭ���� �ν��Ͻ� ����
		Scanner sc = new Scanner(System.in);

		do
		{
			System.out.print("�ο� �� �Է� (1~100) : ");
			n = sc.nextInt();
		}
		while (1>n || n>100);

		// �׽�Ʈ(Ȯ��)
		//System.out.print("n : " + n);
	}

	//���� �Է� �޴� ����� �ϴ� �޼ҵ� 
	Record[] reinput() 
	{
		//Scanner Ŭ���� �ν��Ͻ� ����
		Scanner sc = new Scanner(System.in);
			
		Record[] arr = new Record[n];											// Record Ŭ������ �迭 ���·� ���� ��ũ��� �л� �� ��ŭ! 							

		for (int i=0; i<n; i++)
		{
			arr[i] = new Record();												// Record �迭�� arr i��° �濡 / Record Ŭ���� ���·� ���赵�� ����?

			System.out.printf("%d��° �л��� �̸� �Է� : " , i+1);
			arr[i].name = sc.next();
			System.out.printf("���� ���� �Է� : ");
			arr[i].score[0] = sc.nextInt();
			System.out.printf("���� ���� �Է� : ");
			arr[i].score[1] = sc.nextInt();
			System.out.printf("���� ���� �Է� : ");
			arr[i].score[2] = sc.nextInt();
			System.out.println();

			arr[i].tot = arr[i].score[0] + arr[i].score[1] + arr[i].score[2];	// ����, ����, ���� ���� ����

			arr[i].avg = arr[i].tot/3.0;										// ���	double �� �� ����!!!

		}

		return arr;																// Record[]�� arr�� ��ȯ
		
	}
	
	
	// ��� ����� ���� �޼ҵ�
	void print(Record[] arr)			
	{
		for (int i=0; i<n; i++) // �л� �� ��ŭ
		{
			System.out.printf(" %s %d %d %d %d %.2f \n",arr[i].name, arr[i].score[0], arr[i].score[1], arr[i].score[2], arr[i].tot, arr[i].avg);
		}
	
	}
	

/*

	// �׽�Ʈ�� main() �޼ҵ�
	public static void main(String[] args) 
	{
		Sungjuk sj =  new Sungjuk();
		sj.input();
		Record[] arr = sj.reinput();
		sj.print(arr);

}
*/
	
}