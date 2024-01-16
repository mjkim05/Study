/*=============================================
  ■■■ 예외 처리(Exception Handling) ■■■
==============================================*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Test148
{
	private String[] data = new String[3];

	public void proc() throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str;
		int n = 0;

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

	}
		
		

	public static void main(String[] args) throws IOException
	{
		Test148 ob = new Test148();
		ob.proc();
	}
}

// 도미노 처럼 휙휙 하기 때문에 readLine()에도 throws IOException이 있다는 것을 알 수 있다.