/*========================
	���� �迭 ����
	�� �迭�� �⺻�� Ȱ��
  =======================*/

// ������ �������� ����մ� �迭�� ���� �����͵� ��
// ¦���� ��Ҹ� ��� ����ϰ�, 3�� ����� ��Ҹ� ��� ����ϴ� 
// ���α׷��� �����Ѵ�.

// �迭�� �����ϴ� ������ ���� = 4 7 9 1 3 2 5 6 8

// ���� �� 
// �迭 ��� ��ü ���
// 4 7 9 1 3 2 5 6 8
// ¦�� ������ ���
// 4 2 6 8
// 3�� ��� ������ ���
// 9 3 6
// ����Ϸ��� �ƹ�Ű�� ��������....

public class Test080
{
	public static void main(String[] args)
	{
		/*
		int[] arr = {4, 7, 9, 1, 3, 2, 5, 6, 8};
		
		System.out.println("�迭 ��� ��ü ���");

		for (int i=0; i<9; i++)
		{
			System.out.printf("%d ", arr[i]);
		}

		System.out.println("\n¦�� ������ ���");

		for (int i=0 ; i<9; i++)
		{
			while (i == 0 || i==5 || i==7 || i==8)
			{
				System.out.printf("%d " ,arr[i]); 
				break;
			} 	
		}

		System.out.println("\n3�� ��� ������ ���");

		for (int i=0; i<9; i++)
		{
			if (i==2 || i==4 || i==7)
			{
				System.out.printf("%d ",arr[i]);
			}
		}

		System.out.println();
		*/

		// ¦���� Ǯ� �ڵ� ----------------------------------------------------------------------------------------------
		 /*  
		  int[] arr = {4, 7, 9, 1, 3, 2, 5, 6, 8};
      
		  System.out.println("�迭 ��� ��ü ���");
		  for (int i=0; i<9; i++)
		  {
			 System.out.printf("%d ", arr[i]);
		  }
		  System.out.println("\n¦�� ������ ���");
		  for (int i=0; i<9; i++)
		  {
			 if (arr[i]%2==0)
				System.out.printf("%d ", arr[i]);
		  }
		  System.out.println("\n3�� ��� ������ ���");
		  for (int i=0; i<9; i++)
		  {
			 if (arr[i]%3==0)
				System.out.printf("%d ", arr[i]);
		  }
		  System.out.println();
		*/
		// �����ϸ� ���� Ǯ�̺� �ڵ� ------------------------------------------------------------------------------------------

			//�迭 ���� �� �ʱ�ȭ
			// ��� ��
			/*
			int[] arr = new int[9];
			arr[0] = 4;
			arr[1] = 7;
			arr[2] = 9;
			arr[3] = 1;
			arr[4] = 3;
			arr[5] = 2;
			arr[6] = 5;
			arr[7] = 6;
			arr[8] = 8;
			*/

			// ��� ��
			
			int[] arr = {4,7, 9, 1, 3, 2, 5, 6, 8};
			
			//System.out.println(arr);

			// �Ϲ����� ������ ��� ������ ����ϴ� ����(���)���δ� 
			//	�迭�� ��� �����͵��� ��� �� �� ����.
			/*
			System.out.println("�迭 ��� ��ü ���");

			for (int i=0; i<9; i++)
			{
				System.out.print(arr[i] + " ");
			}

			System.out.println();
			//--==>> �迭 ��� ��ü ���
			//		  4 7 9 1 3 2 5 6 8
			*/
			
			// �� �迭 arr�� ���� (���� ����) Ȯ��
			//	  : arr.length

			System.out.println("�迭 ��� ��ü ���");
			for (int i=0; i<arr.length; i++)
			{
				System.out.print(arr[i] + " ");
			}
			System.out.println();
			//--==>> �迭 ��� ��ü ���
			//		 4 7 9 1 3 2 5 6 8

			System.out.println("¦�� ������ ���");
			for (int i=0; i<arr.length; i++ )
			{
				/*
				if (i%2==0)						//-- i�� ¦�����... �� ¦�� ��°�� �ش��ϴ� ��Ҷ��...
				{
					//�����~~!! // �ش� �ε�����...
					//System.out.print(i + " ");
					
					//�����~~!! �� �ε����� �ش��ϴ� ����...
					//System.out.print(arr[i] + " ");
				}
				*/

				if (arr[i]%2==0)				//-- i��° ����� ���� ¦�����....
				{
					System.out.print(arr[i] + " ");
				}
				
			}
			System.out.println();
			//--==>> ¦�� ������ ���
			//		 4 2 6 8
	
			System.out.println("3�� ��� ������ ���");
			for (int i=0 ; i<arr.length; i++)
			{
				if (arr[i]%3==0)
				{
					System.out.print(arr[i] + " ");
				}

			}
			System.out.println();
			//--==>>3�� ��� ������ ���
			//		9 3 6


	}	
}

//���� ���
/*
�迭 ��� ��ü ���
4 7 9 1 3 2 5 6 8
¦�� ������ ���
4 2 6 8
3�� ��� ������ ���
9 3 6
����Ϸ��� �ƹ� Ű�� �����ʽÿ� . . .
*/