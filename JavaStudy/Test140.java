/*============================================
  ���� �ڹ��� �ֿ�(�߿�) Ŭ���� ����
  - �ڹٿ��� �⺻������ �����ϴ� �ֿ� Ŭ������
  - StringTokenizer Ŭ���� (���丸 ����~~!!)
==============================================*/

/*
��  StringTokenizer Ŭ������ 
	
	���ڿ� �Ľ�(parsing)�� ���� ������ �����ϴ� Ŭ������
	�Ľ�(parsing)�ϰ��� �ϴ� ���ڿ��� ���ڷ� �޾� �����ϴµ�,
	���⿡ ���Ǵ� �Ľ�(parsing) �̶�� ������
	�ϳ��� ���ڿ��� ���� ���ڿ��� ������ �۾��� �ǹ��ϰ� �Ǹ�,
	�� �� ������ ������ �Ǵ� ���ڿ��� ��ū(token)�̶�� �Ѵ�.
	
	StingTokenizer Ŭ������ ����ϱ� ���ؼ���
	java.util ��Ű���� StringTokenizer �� import�ؾ��Ѵ�.

	StringTokenizer Ŭ������ ȣȯ���� �����ϴ� ��������								// ȣȯ�� �����Ѵٴ� ���� ������ �������� ���ϰ� �׳� �дٰ� �����ϸ� ��! �ִ��� ��� ��
	���� ���� �ǰ� ������, ���ڿ��� �Ľ�(parsing)�ϱ� ���ؼ���
	String zmffotmdml split() �޼ҵ峪, javax.util.regex ��Ű���� 
	����� ���� �����ϰ� �ִ�.

�� ������
   
   - ����
     StringTokenizer(String str)
	 StringTokenizer(String str, String delim)
	 StringTokenizer(String strm String delim, boolean returnDelims)
	 : �־��� ���ڿ� srt�� �ܾ�� �и��ϴ� ��ü�� �����ϸ�
	   ����(����) ���ڴ� delim�� ���Ե� ���ڷ� ó���ϰ� �ȴ�.
	   ���� returnDelim �� true�̸� 
	   ���� ���ڵ� �и��� �����ͷ� ó���ϰ� �ȴ�.

*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Test140
{
	public static void main(String[] args)	throws IOException
	{
		String strTemp;
		String[] strArr;
		int n;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("�Ľ��� ���ڿ� �Է�(�ĸ� ����) : ");
		strTemp = br.readLine();
		//--==> ����, �ٳ���, ����

		//StringTokenizerŬ���� �ν��Ͻ� ����
		StringTokenizer st = new StringTokenizer(strTemp, ",");
		//-- strTemp �� ��� ���ڿ���... ("���, ����,�ٳ���,����");
		//-- ��","���� �����ڷ�...

		//�׽�Ʈ(Ȯ��)
		//System.out.println(st.countTokens());
		//--==>> 4 
		// -- StringTokenizer �� ��int countTokens()���޼ҵ� �� int �� ��ȯ
		// : �Ľ̵� ���ڿ��� ������ ��ȯ �����Ѵ�.
		
		strArr = new String[st.countTokens()];
		//					----------------
		//						 4
		//	�� strArr = new String[4];
		
		n=0;

		// hasMoreTokens() �� ������ �� ���� ���� �ִ��� �ƴ��� �˷���
		// st.nextToken(); �� �����ϴ� �� �������� �����ð�
		// ���� �� ��Ʈ
		while (st.hasMoreTokens())					// true true true true false			
		{
			strArr[n++] = st.nextToken();			
			//strArr[0] = "���";
			//strArr[1] = "����";
			//strArr[2] = "�ٳ���";
			//strArr[3] = "����";
		}

		// ��hasMoreTokens()��
		//	����� �� �մ� ��ū�� �����ִ� ��� true�� ��ȯ
		//	�� �̻� ����� ��ū�� ���� ��� false�� ��ȯ.
		//	Ȯ�ο� ���� ����� ��ȯ�һ�
		//	���� ������ �о�������� �ʰ�,
		//	���� ������ �о���̴� ��带 �̵���Ű���� �ʴ´�.

		// ��nextToken()��
		//	���� ��ū�� ���´�.
		//	���� ��ū�� ������ ��带 �̵���Ű�� �ȴ�.
		//	�����ڸ� �ٲپ��� ��� ���� ȣ�⿡�� 
		//	�ٲ� �����ڸ� �̿��Ͽ� ��ū�� �и��Ѵ�.

		System.out.print("�Ľ̵� ��ū(���ڿ�) : ");
		for (String str : strArr)
			System.out.print(str + " ");
		System.out.println();
		//--==>> �Ľ��� ���ڿ� �Է�(�ĸ� ����) : ���,����,�ٳ���,����
		//		 �Ľ̵� ��ū(���ڿ�) : ��� ���� �ٳ��� ����
		
		

		
			
	

	}
}