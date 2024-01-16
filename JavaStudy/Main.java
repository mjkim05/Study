import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int count = 0;
		
		while(N != 1)
		{
			if(N % 3 == 0)
			{
				N = N / 3;
				count++;
			}
			else if((N - 1) % 3 == 0)
			{
				N = N / 3;
				count = count + 2;
			}
			else if(N % 2 == 0)
			{
				N = N / 2;
				count++;
			}
			else if((N - 1) % 2 == 0)
			{
				N = N / 2;
				count = count + 2;
			}
			else
			{
				N = N - 1;
				count++;
			}
		}
		System.out.print(count);
	}
}


