/*=============================================
  ■■■ 예외 처리(Exception Handling) ■■■
==============================================*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Test149
{	
	private String[] data = new String[3];

	public void proc() //throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str;
		int n = 0;

		try
		{
			System.out.print("이름 입력(종료 Ctrl+Z) : ");
			while ((str=br.readLine()) != null )					//ctrl + Z 가 null이다.
			{
				data[n++] = str;
				System.out.print("이름 입력(종료 Ctrl+Z) : ");
			}

			System.out.println("입력된 내용 .............................");
			for (String s :  data)
			{
				if (s !=null)
				{
					System.out.println(s);
				}

			} 

		} // end try
		catch (IOException e)
		{
			System.out.println(e.toString());
			System.out.println("checked exception 에 대한 처리");
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			System.out.println("배열 인덱스 관련 예외 발생~~!!");
			System.out.println("e.getMessage() : " + e.getMessage());
			System.out.println("e.toString() : " + e.toString());
			System.out.println("PrintStackTrace");
			e.printStackTrace();
		}
		

	}		

	public static void main(String[] args) // 더이상 main에서 throws IOException 를 사용할 필요 Ⅹ
	{
		Test149 ob = new Test149();
		ob.proc();
	}
}

//실행 결과
/*
이름 입력(종료 Ctrl+Z) :
이름 입력(종료 Ctrl+Z) : ㅁ
이름 입력(종료 Ctrl+Z) :
이름 입력(종료 Ctrl+Z) : ㅁ
배열 인덱스 관련 예외 발생~~!!
e.getMessage() : 3
e.toString() : java.lang.ArrayIndexOutOfBoundsException: 3
PrintStackTrace
java.lang.ArrayIndexOutOfBoundsException: 3
        at Test149.proc(Test149.java:25)
        at Test149.main(Test149.java:60)
*/