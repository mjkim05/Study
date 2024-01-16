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

		System.out.print("주민번호를 입력하세요 : ");
		String id = br.readLine();

		if (id.length()!=14)
		{
			System.out.println("주민등록번호 14자리를 입력하세요.");
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
		
		if (su == Integer.parseInt(id.substring(13)))	//--------------유효성 검증 끝
			System.out.println();
		
		if (underfour1 == '1')
			{
				if (underfour2 == '8' || underfour2 == '9')
				{
					System.out.println("만 4세입니다.");
				}
			}
			else
			System.out.println("만 4세 이상은 승차권을 구입해야 합니다.");

/*
		for (int i=0;i< ; )
		{
		}*/

		/*
		else 
			System.out.println("주민등록 번호를 다시 입력하세요");*/



	}
}