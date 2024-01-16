/*=============================================
  ���� �ڹ��� �⺻ ���α׷��� ����
  - �ڹٿ��� �⺻������ �����ϴ� �ֿ� Ŭ����
  - ���ڿ� ���� Ŭ���� 
  - ĳ���� ��(characterSet)
==============================================*/

/*

�� ĳ���� ��(characterSet)

   �� �����ڵ�(unicode)
   	  ���� ǥ������ ������ 2����Ʈ���� ���� ������ ���� ���� ��ȣ
	  ü��(UCS : Universal Code System)�� ���Ѵ�.
	  ������ǻ��, IBM, ����ũ�μ���Ʈ ���� ���ҽþ����� ������
	  �����ڵ�(UniCode)�� 1999�⿡ ù ������ ��ǥ�Ͽ���
	  ISO/IEC JTC1���� 1995�� 9�� ����ǥ������ �����Ͽ���.
	  ���� ��Ī�� ISO/IEC 10646-1(Univarsal Multiple-Octet Coded Character Set)�̴�.

	  ������ ��ȯ�� �����ϰ� �ϱ� ���Ͽ� ���� 1���� �ο��Ǵ� ���� 16��Ʈ�� �����Ͽ���
	  �ڵ��� 1���ڴ� ����� 7��Ʈ, �� ����� 8��Ʈ
	  �ѱ��̳� �Ϻ���� 16��Ʈ�� ���� ������ �Ǵµ� 
	  �̵��� ��� 16��Ʈ�� ���� �� ���̴�.
 
   �� UTF-8 �� UTF-16
		
	  UTF-8 �� UTF-16�� ���̸� �Ѹ���� ���ϸ� 
	  ���ڸ� ǥ���Ҷ��� ������ �ٸ��ٴ� ���̴�.
	  UTF-8 �� 8��Ʈ ������ ��Ƽ����Ʈ���� ���ڸ� ǥ���ϰ�,
	  UTF-16 �� 16��Ʈ ������ ��Ƽ����Ʈ���� ���ڸ� ǥ���Ѵ�.

	  - UTF-8 (8bit UCS Transformation Format)
	  	������ �⺻������ ����ϴ� �ڵ�
		UCS-2�� ���ǵǴ� ���� ������ �̿��Ͽ� ����� ���ڿ���
		����Ʈ ���� ��ȯ�ϴ� ����� 1�� 1���ڸ� 1-6����Ʈ ������
		��Ƽ ����Ʈ�� ��ȯ�Ѵ�.

	  - UTF-16 (16bit UCS Transformation Format)
		�ڹ��� �⺻ �ڵ�, 
		�ڹٿ����� ���� �ϳ��� �����ϸ� ����Ʈ ���� 
		�����ڵ�, �ѹ��ڵ�, 2����Ʈ�� �����ϰ� �ȴ�.
		UCS-2�� ���ǵǴ� ���� ������ �̿��Ͽ� ����� ���ڿ���
		UCS-4�� �Ϻ��� ���ڸ� ä���ֱ� ���� ���ڵ� ���,
		UTF-8�� ������ �� �ִ�.
		UCS-2�� �̿��� �� �ִ� ���� ���� ���� �ø� �� �ִ�.

	 �� �ڹٴܿ����� UTF-16�� ����ϰ� �������� UTF-8�� ����ϱ� ������
	    ��쿡 ���� ��ȯ�ؾ� �ϴ� ��Ȳ�� �߻� �� �� �մ�.

 �� ���� �ڵ��� ����
    
	�� KSC5601 
	   �ѱ� �ϼ��� ǥ��(�ѱ� 2,3050�� ǥ��)
	   �ѱ�����ǥ�� ����ó���о�(c)�� 5601�� ǥ�ؾ�.

	�� KSC5636
	   �����ڿ� ���� ǥ�� 
	   �ѱ�����ǥ�� ����ó���о�(c)�� 5636�� ǥ�ؾ�.
	   ���� ASCII Code ���� ��������(\)�� ��(��) ǥ�÷� ��ü

	�� EUC-KR(MS949)
	   Bell-Laboratories ���� ���н� �󿡼� ������ �̿��� ���ڸ� 
	   �����ϱ� ���� ������ Ȯ�� �����ڵ�(Extend UNIX Code) ��
	   �ѱ� ���ڵ� ���
	   ������ KSC5636���� ó���ϰ�, �ѱ��� KSC5601�� ó��;
	   ��, EUC-KR(MS949) = KSC5636 + KSC5601

	�� UTF-8
	   ������ ���ڴ� 1����Ʈ, �ѱ��� 3����Ʈ�� ǥ��
	   (������ ���� ��� , UTF-8 �������� JSP�� �ۼ��Ҷ�������
	   ���ϵ� UTF-8 �������� �����ؾ� �Ѵ�.)
	
	�� UTF-16
	   �ڹ��� �⺻ ���� �ڵ�
	   ������ ���ڴ� 1����Ʈ, �ѱ��� 2����Ʈ�� ǥ��.

	�� IS0-8859-1
	   ������ ��� ǥ�⿡ �ʿ��� US-ASCII �� ���� 
	   94�� ������ ������ ����. 

*/

import java.io.UnsupportedEncodingException;

public class Test141
{
	public static void main(String[] args)	throws UnsupportedEncodingException
	{
		byte[] buf;
		String name = new String("������");

		System.out.println("������ ĳ���� �� : " +System.getProperty("file.encoding"));
		//--==>> ������ ĳ���� �� : MS949

		// ��String.getBytes()��		
		//	����Ʈ ĳ���� ������(�ý��ۿ� ������ ���ڵ� ����� Ȱ���ؼ�)
		//  ����Ʈ �迭�� ��ȯ�ϴ� �ý���
			
		buf = name.getBytes();
		System.out.println("Length : " + buf.length);
		//--==>> Length : 6
		
		for (byte b: buf )
			System.out.println("[" + b + "]");
		System.out.println();
		//--==>> [-65]
		//		 [-64]
		//		 [-68]
		//		 [-10]
		//		 [-80]
		//		 [-26]

		// "UTF-8" ĳ���� ������ ����Ʈ �迭�� ��ȯ
		// ��String.getBytes("utf-8")��		
		//	��� ���忭�� �Ű������� �Ѱܹ��� ���ڵ� ����� Ȱ���ؼ�
		//  ����Ʈ �迭�� ��ȯ�ϴ� �ý���
		buf = name.getBytes("utf-8");
		// ���� �߻� (������ ����) �� throws UnsupportedEncodingException ��� �� ���� �۵�
		
		System.out.println("Length : " + buf.length);
		//--==>> Length : 9

		for(byte b :buf)
			System.out.println("[" + b +  "]");
		System.out.println();
		/*
		[-20]
		[-104]
		[-92]
		[-20]
		[-120]
		[-104]
		[-22]
		[-78]
		[-67]
		*/

		//new String("������")

		//new String(����Ʈ �迭 , ���ڵ� ���);
		//String(byte[] bytes, Charset charset)
		//Constructs a new String by decoding the specified array of bytes using the specified charset.

		//new String(buf , "utf-8");

		// utf-8 ���·� ����� ����Ʈ �迭��
		// String ��ü�� �Ķ���� �� ��utf-8���� �ο��Ͽ� ����
		// �� ��, utf-8 ������� buf ����Ʈ �迭�� ���ļ� ���ڿ� ��ü�� ������ �� ���
		System.out.println("Value 1 : " + new String(buf , "utf-8"));
		//--==>> Value 1 : ������

		System.out.println();		//  ����

		
		// new String(����Ʈ�迭[,�⺻���ڵ����])
		//String(byte[] bytes)
		//Constructs a new String by decoding the specified array of bytes using the platform's default charset.
		// utf-8 ���·� ����� ����Ʈ �迭��
		// String ��ü�� �Ķ���� �� ���� �ο��Ͽ� ����
		// �� ��, ms949(default charset)������� buf ����Ʈ �迭�� ���ļ� ���ڿ� ��ü�� ������ �� ���
		System.out.println("Value 2 : " + new String(buf));
		//--==>> Value 2 : ?��?���?

		System.out.println();		//  ����
		System.out.println("------------------------------------------------------");

		String convert = new String(name.getBytes("euc-kr"), "utf-8");

		System.out.println("Value3 : " + convert);
		//--==>> Value3 : ??????

		buf = convert.getBytes();
		System.out.println("Langth : " + buf.length);
		//--==>> Langth : 6

		buf = convert.getBytes("utf-8");
		System.out.println("Length : " + buf.length);
		//--==>> Length : 18

		/*
		�� check~~!!!
		
		���ڿ��� euc-kr ���ڵ� ��Ŀ��� utf-8 ������� ��ȯ�ϰڴٴ� �ǵ��� 
		���� ���� �ڵ��� �ع�����... 
		�̷��� ��ȯ(�߸��� ��ȯ)���� ���� �迭�� ������ 
		�� ���Ŀ���... euc-kr �̵� utf-8�̵� ...
		��� ����Ʈ �迭�� �о����
		������� �����ִ� �� Ȯ�� �� �� �ִ�.

		�̹� ������ ������ String ��ü�� ����Ʈ �迭�� 
		� ������ε� ������ �Ұ��� �ϴ�.
		*/


	
		

		
		
	}
}