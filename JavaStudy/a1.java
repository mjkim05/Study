import java.util.Scanner;

public class a1
{
	public static void main(String[] args)
	{		
		
			Object[][] seats1 = new Object[2][2];
			Object[][] seats2 = new Object[4][4];
			Object[][] seats3 = new Object[8][4];

			int n = 0;
			int n2 = 0;
			String m = "□";

			for (int i = 0; i < seats1.length; i++) 
			{

				for (int j = 0; j < seats1[0].length; j++) 
				{
					seats1[i][j] = m;
				}

			}


			for (int k = 0; k < seats2.length; k++) 
			{

				for (int o = 0; o < seats2[0].length; o++) 
				{
					seats2[k][o] = m;
				}

			}


			for (int t = 0; t < seats3.length; t++) 
			{

				for (int y = 0; y < seats3[0].length; y++) 
				{
					seats3[t][y] = m;
				}

			}
		

		Scanner sc = new Scanner(System.in);
		
		System.out.print("몇등석 탑승하시겠습니까?(1, 2, 3) : ");
		n2= sc.nextInt();
		
		System.out.print("인원 수 입력 : ");
		n = sc.nextInt();

	
		
		for (int i=0; i<n; i++)
		{
			System.out.print("좌석번호 입력 : ");
			int mySeat = sc.nextInt();
			//[5][10]
			//int myRow = (mySeat % 10 == 0) ? mySeat / 10 - 1 : mySeat / 10;

			//int myCol = (mySeat % 10 == 0) ? 9 : mySeat % 10 - 1;

			//seats1[myRow][myCol] = "■";
			
			int myRow1 = (mySeat % 2 == 0) ? mySeat / (2-1) : mySeat / 2;
			int myCol1 = (mySeat % 2 == 0) ? (2-1) : mySeat % (2-1);
			
			seats1[myRow1][myCol1] = "■";

			int myRow2 = (mySeat % 4 == 0) ? mySeat / (4-1) : mySeat / 4;
			int myCol2 = (mySeat % 4 == 0) ? (4-1) : mySeat % (4-1);

			seats2[myRow2][myCol2] = "■";

			int myRow3 = (mySeat % 4 == 0) ? mySeat / (4-1) : mySeat / 4;
			int myCol3 = (mySeat % 4 == 0) ? (4-1) : mySeat % (4-1);

			seats3[myRow3][myCol3] = "■";
		}
						

		if (n2==1)
		{
		
		for (int i = 0; i < seats1.length; i++) 
		{

			for (int j = 0; j < seats1[0].length; j++) 
			{

				System.out.printf("%6s",seats1[i][j]);

			}

			System.out.println();
		}
		System.out.println();
		}


		if (n2==2)
		{
		for (int k = 0; k < seats2.length; k++) 
		{

			for (int o = 0; o < seats2[0].length; o++) 
			{

				System.out.printf("%3s",seats2[k][o]);

			}

			System.out.println();
		}
		System.out.println();
		}

		if (n2==3)
		{
		for (int t = 0; t < seats3.length; t++) 
		{

			for (int y = 0; y < seats3[0].length; y++) 
			{

				System.out.printf("%3s",seats3[t][y]);

			}

			System.out.println();
		}
		}
	}

}
	

