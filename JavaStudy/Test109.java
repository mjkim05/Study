/*========================================
  ���� ����(sort) �˰��� ����
=========================================*/

// ���� ���� ����(Bobble Sort)

// �� �տ��� �� Selection Sort(Test107.java)�� Bubble Sort(Test108.java)�� ������ ����.
//    (��  ���ɿ� ���� ���� �ٰ� : �ݺ����� ������ Ƚ��)
//	  ������, ���� Bubble Sort�� ��� �������� ������ ����
//    �Ϲ� Bubble Sort �� Selection Sort�� ���� ������ ���� �� �ִ�.

// ���� ������ : 61 15 20 22 30
//			   : 15 20 22 30 61				- 1ȸ�� (���� �߻� �� true) �� ���� ȸ�� ���� ��
//			   : 15 20 22 30 61				- 2ȸ�� (���� �߻� �� false) �� ���� ȸ�� ���� X

// ==>> 1ȸ�� ����... 2ȸ�� ����... �� �� ���Ҵ��� 
//		2ȸ������ ����(�ڸ��ٲ�)�� ���� �Ͼ�� �ʾұ� ������
//      ���ʿ��� �߰� ����(���̻��� ȸ��)�� ���ǹ��� ������ �Ǵ��Ͽ�
//      �������� �ʴ´�. 

public class Test109
{
	public static void main(String[] args)
	{
		int[] a = {10, 50, 20, 30, 40};
		/*
		10, 50, 20, 30, 40
		==  --

		10, 20, 50, 30, 40
		    ==  --

		10, 20, 30, 50, 40
		        ==  --

		10, 20, 30, 40, 50
					==  --
		---------------------------------------------------- 1ȸ�� �� ���� �߻�

		10, 20, 30, 40, 50
		==  --
		
		10, 20, 30, 40, 50
			==  --
		
		10, 20, 30, 40, 50
				==  --
		---------------------------------------------------- 2ȸ�� �� ���� �߻����� ����
				
				X

				X
		
		---------------------------------------------------- 3ȸ�� �� ���� �߻����� ����
			
				X

		---------------------------------------------------- 4ȸ�� �� ���� �߻����� ����
		*/
		
		/*
		int i,j;
		boolean bl= false;							// ������ �Ͼ���� �ƴ��� �Ǻ��ϴ� ����
		
		// �ʱ� �� ���
		System.out.print("Source Data : " );
		for ( int n : a )
			System.out.print(n + " ");
		System.out.println();

		// ����

		for (i=1; i<a.length; i++)
		{
			for (j=0; j<a.length - i ; j++)
			{
				if (a[j] > a[j+1])
				{
					a[j] = a[j]^a[j+1];
					a[j+1] = a[j+1]^a[j];
					a[j] = a[j]^a[j+1];
					bl= true;							// ������ �Ͼ ��� Ʈ�� 
				}

				//�׽�Ʈ
				for (int n : a )
				{
					System.out.printf("%3d" , n);
				}
				System.out.println();
			}
			System.out.println("-----------------------------");
			
			if (bl == false)						// false ��� break;
			{
				break;
			}
			bl = false;								// bl ���� �ٽ� �ѹ� ��  false �� �ʱ�ȭ
				
		}
	
		// ��� ���
		System.out.print("Sorted Data : ");
		for(int n : a)
			System.out.print(n + " ");
		System.out.println();
		*/
	

		System.out.print("Source Data : ");
		for (int n : a )
			System.out.print( n + " ");
		System.out.println();

		// ����
		// ���� Bubble sort
		boolean flag;
		int pass = 0;

		do
		{
			flag = false;				// -- �̹� ȸ������ �ڸ��ٲ��� �߻����� ���� ���̴�. 
			pass++;

			for (int i=0; i<a.length-pass; i++)
			{
				// �׽�Ʈ
				//System.out.println("��");
				if (a[i] > a[i+1])
				{
					a[i] = a[i]^a[i+1];
					a[i+1] = a[i+1]^a[i];
					a[i] = a[i]^a[i+1];
					
					flag = true;
					// -- �� �ѹ��̶� ������(�ڸ��ٲ�)�� �߻��ϰ� �Ǹ�
					//	  flag ������ true�� ���� ~~!!
				}
			}
		}
		while (flag);
		// -- flag������ false ��� ����
		//    ȸ���� ���������� �߻��ϴ� ���� ������ �Ͼ�� ���� ����
		//    �� �̻� �ݺ��� ������ ���ǹ��� ������ �Ǵ� ����~~!!
	
		System.out.print("Sorted Data : ");
		for (int n : a )
			System.out.print( n + " ");
		System.out.println();

	}
}

//������
/*

Source Data : 10 50 20 30 40
Sorted Data : 10 20 30 40 50
����Ϸ��� �ƹ� Ű�� �����ʽÿ� . . .

*/