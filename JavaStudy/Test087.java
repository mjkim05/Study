/*========================
	���� �迭 ����
  �� �迭�� �迭
  =======================*/

// �迭�� �迭(�������迭)�� Ȱ���Ͽ�
// ������ ���� �����͸� ��ҷ� ���ϴ� �迭 (5*5)�� �����ϰ�
// �� ����� ����ϴ� ���α׷��� �����Ѵ�.

// ���� ��)
/*
1 2 3 4 5	 
2 3 4 5 6
3 4 5 6 7
4 5 6 7 8
5 6 7 8 9
//��� �Ϸ��� �ƹ�Ű�� ��������
*/

public class Test087
{
	public static void main(String[] args)
	{
		/*
		//�迭�� �迭 ���� �� �޸� �Ҵ�
		int[][] arr = new int[5][5];
		
		
		// �迭�� �迭�� �ݺ����� ��ø ������ Ȱ���Ͽ� ����ȭ
		for (int i=0; i<arr.length; i++)
		{
			int n=(1+i);								// n ���� �ʱ�ȭ ���Ѽ� ���� �̾����� �ʰ� �Ѵ�.
			 
			for (int j=0; j<arr[i].length; j++)
			{
				arr[i][j] = n;
				n++;
			}
		}
		
		// ��ü��� ���
		for (int i=0; i<arr.length; i++)
		{
			for (int j=0 ;j<arr[i].length; j++)
			{
				System.out.printf("%3d" , arr[i][j]);
			}

			System.out.println();
		}
		*/

		int[][] arr = new int[5][5];
		
		int n=0;
		
		for (int i=0; i<arr.length; i++)					//��~~~
		{
				n= i+1;
			
			for (int j=0; j<arr[i].length; j++)				//������
			{
				//�׽�Ʈ(Ȯ��)
				//System.out.println("i : " + i + " j: " +j);
				//System.out.print("[" + n + "]");

				arr[i][j] = n;
				n++;
			}
			//System.out.println();
		}

		//�迭 ��ü ��� ���
		for (int i=0; i<arr.length; i++)
		{
			for (int j=0; j<arr[i].length; j++)
			{
				System.out.printf("%3d" , arr[i][j]);
			}
			System.out.println(); 
		}



	}
}
//������
/*
  1  2  3  4  5
  2  3  4  5  6
  3  4  5  6  7
  4  5  6  7  8
  5  6  7  8  9
����Ϸ��� �ƹ� Ű�� �����ʽÿ� . . .

*/