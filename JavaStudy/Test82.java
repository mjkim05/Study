import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

public class Test82
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str;
		int n =	0;
		do
		{
		
		System.out.print("입력 처리할 학생 수 입력(명, 1~10) : ");
		n = Integer.parseInt(br.readLine());										// 학생 수 n
		
		}
		while (n < 1 || n > 10);
		
		
		String[] name = new String[n];							// 이름을 담을 문자열 배열
		String[] number = new String[n];						// 번호를 담을 문자열 배열


		for(int i = 0; i < n; i++)
		{
			System.out.printf("이름 전화번호 입력[%d](공백 구분 ) : ", i + 1);
			str = br.readLine();
			StringTokenizer st = new StringTokenizer(str);

			name[i] = st.nextToken();
			number[i] = st.nextToken();
		}



		System.out.println("--------------------");
		System.out.printf("전체 학생 수 : %d\n",n);
		System.out.println("--------------------");
		System.out.println("이름    전화번호");
		
		for(int i = 0; i < n; i++)
		{
			System.out.print(name[i]+ " ");
			System.out.print(number[i] + " \n");
		}
		System.out.println("--------------------");
		
	}
}