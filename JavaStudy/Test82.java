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
		
		System.out.print("�Է� ó���� �л� �� �Է�(��, 1~10) : ");
		n = Integer.parseInt(br.readLine());										// �л� �� n
		
		}
		while (n < 1 || n > 10);
		
		
		String[] name = new String[n];							// �̸��� ���� ���ڿ� �迭
		String[] number = new String[n];						// ��ȣ�� ���� ���ڿ� �迭


		for(int i = 0; i < n; i++)
		{
			System.out.printf("�̸� ��ȭ��ȣ �Է�[%d](���� ���� ) : ", i + 1);
			str = br.readLine();
			StringTokenizer st = new StringTokenizer(str);

			name[i] = st.nextToken();
			number[i] = st.nextToken();
		}



		System.out.println("--------------------");
		System.out.printf("��ü �л� �� : %d\n",n);
		System.out.println("--------------------");
		System.out.println("�̸�    ��ȭ��ȣ");
		
		for(int i = 0; i < n; i++)
		{
			System.out.print(name[i]+ " ");
			System.out.print(number[i] + " \n");
		}
		System.out.println("--------------------");
		
	}
}