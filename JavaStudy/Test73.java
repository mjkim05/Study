/*================================
   ���� Ŭ������ �ν��Ͻ� ����
=================================*/

import java.util.Scanner;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;



class Calculate
{
	int a,b,ans;		// �Է� ���� �� ���ڿ� ���� ���
	char c;
	String str;

	void input() throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("������ �� ���� �Է�(���� ����) : ");
		str = br.readLine();

		StringTokenizer st = new StringTokenizer(str);
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		
		System.out.print("������ ������(+ - * /)		: ");
		c = (char)System.in.read();
	}

	void cal()
	{
		if(c == '+')
			ans = a + b;
		else if(c == '-')
			ans = a - b;
		else if(c == '*')
			ans = a * b;
		else
			ans = a / b;
	}

	void print()
	{
		System.out.printf("\n>> %d %c %d = %d\n", a, c, b, ans);
	}


}

public class Test73
{
	public static void main(String[] args) throws IOException
	{
		Calculate cl = new Calculate();
		cl.input();
		cl.cal();
		cl.print();

	}
}