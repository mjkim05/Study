//import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Test_self
{
	public static void main(String[] args) throws IOException
	{
		//Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


		int[] gob = {2,3,4,5,6,7,0,8,9,2,3,4,5};

		int tot = 0;

		System.out.print("�ֹι�ȣ�� �Է��ϼ��� : ");
		String id = br.readLine();

		if (id.length()!=14)
		{
			System.out.println("�ֹε�Ϲ�ȣ 14�ڸ��� �Է��ϼ���.");
			return;
		}

		for (int i=0;i<13 ;i++ )
		{
			if (i==6)
			{
				continue;
			}

			tot += gob[i] *  Integer.parseInt(id.substring(i, (i+1)));
		}

		int su = 11 - tot % 11;

		su = su % 10;	
		
		char underfour1 = id.charAt(0);
		char underfour2 = id.charAt(1);
		
		if (su == Integer.parseInt(id.substring(13)))	//--------------��ȿ�� ���� ��
			System.out.println();
		
		if (underfour1 == '1')
			{
				if (underfour2 == '8' || underfour2 == '9')
				{
					System.out.println("�� 4���Դϴ�.");
				}
			}
			else
			System.out.println("�� 4�� �̻��� �������� �����ؾ� �մϴ�.");

/*
		for (int i=0;i< ; )
		{
		}*/

		/*
		else 
			System.out.println("�ֹε�� ��ȣ�� �ٽ� �Է��ϼ���");*/



	}
}