/*===============================
  ���� ������(Operator) ����
  - ���� ������ == ���� ������ 
=================================*/

// ����ڷκ��� ������ ���� �ϳ��� �Է¹޾�
// ���ĺ� �빮���̸� �ҹ��ڷ�
// ���ĺ� �ҹ����̸� �빮�ڷ� 
// ���ĺ��� �ƴ� ��Ÿ ���ڶ�� �� ���� �״��
// ����ϴ� ���α׷��� �����Ѵ�.

//���� ��)
// �� ���� �Է� : A
// A �� a
// ����Ϸ��� �ƹ� Ű�� �Է��ϼ���.

// �� ���� �Է� : b
// b �� B
// ����Ϸ��� �ƹ� Ű�� �Է��ϼ���.

// �� ���� �Է� : 7
// 7 �� 7
// ����Ϸ��� �ƹ� Ű�� �Է��ϼ���.

//import java.io.BufferedReader;
//import java.io.InputStreamReader;
import java.io.IOException;

public class Test029
{
	public static void main(String[] args)	throws IOException
	{
		/*
		//�ֿ� ���� ����
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));      ����� �ʿ� ����

		int a;				//������� ���� �Է� ���� ����
		int Result;			//�Ǻ� ����� ��Ƶ� ����

		//���� �� ó��
		System.out.print("�� ���� �Է� : ");
		//a = Integer.parseInt(br.readLine());
		a = (char)System.in.read(); 
		
		//��System.in.read()�� �޼ҵ�� (�Է� ��⿭�κ���) �� ���ڸ� �����´�.
		//��, �Է¹��� �ϳ��� ���ڸ� ���� �״�� �������� ���� �ƴ϶�
		//ASCII code��(���� ����)���� ��ȯ�ϰ� �ȴ�.
		


		
		
		
		// a�� �빮���� ��� �ҹ��ڷ� ��� �ҹ����� ��� �빮�ڷ� ��� ���ĺ��� �ƴҰ�� �״�� ��� 
		Result = ( 65 <= a &&  a <= 90 ) ? ( a + 32 ) : ( a => 97 && 122 => a ) ? ( a - 32 ) : a;

		//��� ���
		System.out.println((char) a + " �� " + (char)Result);
		*/	


		// ���� Ǯ� ���� --------------------------------------------------------------------------------
		/*																	
																				���ĺ� �빮�ڵ� �ҹ��ڵ� �ƴ�

																							 ��

		//���ĺ� �빮�� ? ���ĺ� �ҹ��ڷ� ��ȯ : (���ĺ� �ҹ��� ? ���ĺ� �빮�ڷ� ��ȯ : �ִ� �״��) ; 
												 ---------------  ---------------------  ------------
														1				  2						3
		 --------------- ---------------------		
				1					2
		*/	
		/*
		char temp;
		System.out.print("�� ���� �Է� : ");
		temp = (char)System.in.read();

		System.out.println("�Է� ���� �� Ȯ�� : " + temp);
		
		//�빮�� ? �빮�� �ƴ�?
		//temp == 'A'				�� 65
		//temp == 'B'				�� 66
		//	    :
		//temp == 'Z'				�� 90

		// �� �ΰ� �̻��� ������ ������ ������ �� ������!!!!!!!!!
		//String result = temp >= 65 && temp<= 90 ? "�빮��" : "�빮�� �ƴ�";
		//System.out.println("��� : " + result);

		//String result = temp >= 'A' && temp <= 'Z' ? "�빮��" : "�빮�� �ƴ�"; 
		//System.out.println("��� : " + result);

		String result = temp >= 'a' && temp <= 'z' ? "�ҹ���" : "�ҹ��� �ƴ�"; 
		System.out.println("��� : " + result);
		*/

		// �빮��	 ��   �ҹ���
		//'A'(65)	 ��	 'a'(97)	==>> +32
		//'B'(66)	 ��	 'b'(98)	==>> +32
		//'C'(67)	 ��	 'c'(99)	==>> +32
		//		:
		//'Z'(90)	 ��	 'z'(122)	==>> +32

		// �ҹ���	 ��   �빮��
		//'a'(97)	 ��	 'A'(65)	==>> -32
		//'b'(98)	 ��	 'B'(66)	==>> -32
		//'c'(99)	 ��	 'C'(67)	==>> -32
		//		:
		//'z'(122)	 ��	 'Z'(90)	==>> -32
		// ��'a'(97), 'A' (65) , 'z'(122) 'Z'(90)�ΰ� ����ϴ°� ����! 

		char ch, result;
		
		System.out.print("�� ���� �Է� : "  );
		ch = (char)System.in.read();

		// result = () ? () : ();
		// result = (�Է� �� �빮��) ? (�ҹ��� ��ȯ) : (�Է� �� �ҹ���? �빮�ڷ� ��ȯ : �״��);

		result = (ch>='A' && ch<='Z') ? ((char)(ch+32)) : ( ch>='a' && ch<='z' ? ((char)(ch-32)) : ch);

		// 'Q' (�� 81)
		//	result = (81>=65 && ch<='Z') ? ((char)(ch+32)) : ( ch>='a' && ch<='z' ? ((char)(ch-32)) : ch);
		//	result = (true && 81<=90) ? ((char)(ch+32)) : ( ch>='a' && ch<='z' ? ((char)(ch-32)) : ch);
		//	result = (true && true) ? ((char)(ch+32)) : ( ch>='a' && ch<='z' ? ((char)(ch-32)) : ch);
		//	result = (true) ? ((char)(ch+32)) : ( ch>='a' && ch<='z' ? ((char)(ch-32)) : ch);
		//	result = ((char)(81+32));
		//	result = ((char)(113));
		//	result = 'q';

		// 'm' (�� 109)
		//	result = (109>=65 && ch<='Z') ? ((char)(ch+32)) : ( ch>='a' && ch<='z' ? ((char)(ch-32)) : ch);
		//	result = (true&& ch<='Z') ? ((char)(ch+32)) : ( ch>='a' && ch<='z' ? ((char)(ch-32)) : ch);
		//	result = (true&& 109<=90) ? ((char)(ch+32)) : ( ch>='a' && ch<='z' ? ((char)(ch-32)) : ch);
		//	result = (true&&false) ? ((char)(ch+32)) : ( ch>='a' && ch<='z' ? ((char)(ch-32)) : ch);
		//	result = ( ch>='a' && ch<='z' ? ((char)(ch-32)) : ch);
		//	result = ( 109>= 97 && ch<='z' ? ((char)(ch-32)) : ch);
		//	result = ( true && ch<='z' ? ((char)(ch-32)) : ch);
		//	result = ( true && 109<=122 ? ((char)(ch-32)) : ch);
		//	result = ( true && true ? ((char)(ch-32)) : ch);
		//	result = ( true ? ((char)(ch-32)) : ch);
		//	result = ((char)(ch-32));
		//	result = ((char)(109-32));
		//	result = ((char)(77);
		//	result = 'M';
		

		// '8' (�� 56)
		//	result = (56>=65 && ch<='Z') ? ((char)(ch+32)) : ( ch>='a' && ch<='z' ? ((char)(ch-32)) : ch);
		//	result = (false && ch<='Z') ? ((char)(ch+32)) : ( ch>='a' && ch<='z' ? ((char)(ch-32)) : ch);
		//	result = false ? ((char)(ch+32)) : ( ch>='a' && ch<='z' ? ((char)(ch-32)) : ch);
		//  result = (56>=97 && ch<='z' ? ((char)(ch-32)) : ch);
		//  result = (false && ch<='z' ? ((char)(ch-32)) : ch);
		//  result = (false ? ((char)(ch-32)) : ch);
		//  result = (ch);
		//  result = '8';

		System.out.println(ch + " �� " + result);

		//--------------------------------------------------------------------------------------------------


	}
}

//������ 

/*
�� ���� �Է� : 5
5 �� 5
����Ϸ��� �ƹ� Ű�� �����ʽÿ� . . .

�� ���� �Է� : a
a �� A
����Ϸ��� �ƹ� Ű�� �����ʽÿ� . . .

�� ���� �Է� : B
B �� b
����Ϸ��� �ƹ� Ű�� �����ʽÿ� . . .

*/