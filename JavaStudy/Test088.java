/*========================
	���� �迭 ����
  �� �迭�� �迭
  =======================*/

// �迭�� �迭(�������迭)�� Ȱ���Ͽ�
// ������ ���� �����͸� ��ҷ� ���ϴ� �迭�� �����ϰ�
// �� ����� ����ϴ� ���α׷��� �����Ѵ�.

// ���� ��)
/*
2,4
1,4

1 2 3 4 5
5 1 2 3 4
4 5 1 2 3
3 4 5 1 2
2 3 4 5 1
//��� �Ϸ��� �ƹ�Ű�� ��������
*/


/*
1    2   3   4   5

���� i �ڿ��� j 
i�� �ϳ��� ����

0:0 0:1 0:2 0:3 0:4 
1:1 1:2 1:3 1:4 1:0 
2:2 2:3 2:4 2:0 2:1
3:3 3:4 3:0 3:1 3:2
4:4 4:0 4:1 4:2 4:3

*/


public class Test088
{
	public static void main(String[] args)
	{
		/*
		//�迭�� �迭 ����
		int arr[][] = new int[5][5];
		int n=1;
		
			for (int i=0; i<arr.length; i++)
			{	
				for (int j=0; j<arr[i].length; j++)
				{
					if (n>5)
					{
					  n = 1;	
					}
					arr[i][j] = n;
					n++;
				}
				n--;
				
			}
		

		//���� ��� ���
		
		for (int i=0; i<arr.length; i++)
		{
			for (int j=0; j<arr[i].length; j++)
			{
				System.out.printf("%2d",arr[i][j]);
			}

			System.out.println();
		}
		*/
		
		// ������ ����.........................�̤�.....
		
		int arr[][] = new int[5][5];
		int a;
		

		for (int i=0; i<arr.length; i++)
		{	
			int n=1;

			for (int j=0; j<arr[i].length; j++)
			{
				if (i==j)					//1 �ִ� ��
				{
					arr[i][j] = n;
					n++;
				}
				if (j>i)					//1���� ��
				{
					arr[i][j] = n;
					n++;
				}

				if
				{
					a = arr[i-1][4];
					for (j=0; j<i; j++)
					{
						arr[i][j] = a;
						a++;
					}	
				}

			}
		}

		//���� ��� ���

		for (int i=0; i<arr.length; i++)
		{
			for (int j=0; j<arr[i].length; j++)
			{
				System.out.printf("%2d",arr[i][j]);
			}

			System.out.println();
		}
		

		//------------------------------------------------------------------------------------------------
		/*
		int arr[][] = new int[5][5];
		int n;
		int j=0;
	
		//�迭�� �迭 ���� �� �޸� �Ҵ� 
		for (int i=0; i<arr.length; i++)
		{
			for (n=1, j=i; n<=5; n++)
			{	
				//�׽�Ʈ(Ȯ��)
				//System.out.print(i+ "," +j +"[" + n + "]");

				arr[i][j]=n;
				j++;

				if (j==5)
				{
					j=0;
				}
			}
		
		}
		
		
		//�迭 ��ü ��� ���
		for (int i=0; i<arr.length; i++)
		{
			for (j=0; j<arr[i].length; j++)
			{
				System.out.printf("%3d" , arr[i][j]);
			}
			System.out.println(); 
		}
		*/


	}

}

//������
/*
 1 2 3 4 5
 5 1 2 3 4
 4 5 1 2 3
 3 4 5 1 2
 2 3 4 5 1
����Ϸ��� �ƹ� Ű�� �����ʽÿ� . . .



*/