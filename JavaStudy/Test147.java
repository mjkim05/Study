/*=============================================
  ���� ���� ó��(Exception Handling) ����
==============================================*/

/*
�� ���α׷����� �߻��ϴ� ����(Error)��
  
   �� �߸��� ������ ����ϰų� ���� ���� �������� ���� ���¿��� 
      ��������ν� ������ �ܰ迡�� �߻��ϴ� ������ ����(Error)�� 

   �� ���α׷��� �����ϴ� �������� �߻��Ǵ� ��Ÿ�� ����(Error)��
      ���� �� �ִ�. 

	  - �����ڰ� ���� �м��� �߸��ϰų� �Ǽ��� ����
	    ������ ����� �������� �Ǵ� ������ ����(Error)��

	  - �ý��� �̻󿡼� �߰� �Ǵ� �ý��� ����(Error), �׸���

	  - ���α׷� ������ �߻� �Ǵ� ���������� ��Ȳ�� �ǹ��ϴ� 
	    ���ǻ���(Exception)�� �ִ�. 

	    ���� ��� 
		�� � ���� 0���� �����ų�
		�� ������ �����ϴ� �������� ÷�ڸ� ����� ��Ȳ�� �߻��ϰų�...
		�� �������� �ʴ� ������ �����Ͽ� �о���δٰų�...

	==> �����ڰ� �̷� ���� ������ �߻��� ��츦 �̸� �����Ͽ� 
	    ������ �����ϱ� ���� ������ �����ϵ��� ������ ������ ���� ��.
		��.��.ó.��

�� ���� �س��� ���� ~~~!! (Exception Ŭ����)

   - ���ܴ� ���α׷� �����߿� �߻��� �� �ִ� 
     ��ɾ��� �������� �帧�� �����ϴ� �̺�Ʈ�� 
  �� �ڹٿ��� ���ܴ� �ϳ��� ������Ʈ(Object, ��ü)�̴�. ��		//Object ��� ����

   - ���α׷� ���� �߿� �޼ҵ� �ȿ��� ����(Error)�� �߻��ϰ� �� ���,
     �޼ҵ�� �� ������ �ش��ϴ�
	
   - �ڹٿ����� ��� ���� Ŭ������ Throwable Ŭ������ 
     Throwable Ŭ������ ���� Ŭ������ ��ӹ޾� ����Ѵ�.

   - Throwable Ŭ������ ���ܸ� �����ϴ� �����̳� 
     ���ܰ� �߻��� ���� ���α׷� ���¿� ���� ������ �����ϰ� �ִ�. 

  �� Exception Ŭ����
	 Exception ���� Ŭ������ �Ϲ������� ���α׷��ӿ� ����
	 ������ �� ���� ���� �������� 
	 �޼ҵ尡 �����߿� ������ ���ܸ� ����Ų��. 

  �� Error Ŭ���� 
	 �ɰ��� ������ ���·� �����ڰ� ���� �� �� ���� ������ �����̴�.

�� ������ ���� 

   - checked exception 
     �޼ҵ� ������ ���ܰ� �߻��� ��� 
	 �޼ҵ带 ������ �� throws ���� �޼ҵ� ������ �߻� �� �� �մ� 
	 ���ܵ��� ������ְų� �Ǵ� �� ���ܸ� ��try ~cetch�� �ؼ� 
	 ó���� �־�߸� �ϴ� �����̴�.
	 �����Ϸ��� ������ �ϴ� �������� ��checked exception �� �� 
	 ��throws�� �Ǵ� ���� ���� Ȥ�� ��try ~ cetch�� �Ǵ����� ���θ� �Ǵ��Ͽ�
	 ���α׷����� ���ܸ� � ������ε� ó������ ������ 
	 ������ ��ü�� �Ұ��� �ϴ�.

   - unchecked exception 
     ������ ó������ �ʾƵ� �����Ϸ��� üũ���� �ʴ� 
	 ��Ÿ�� �ÿ� �߻� �� �� �մ� �����̴�.


�� java.lang.Throwable Ŭ������ �ֿ� �޼ҵ�

  - String toString() // �������̵� ��
    : Throwable ������ ���� ������ ���ڿ� ���·� ��ȯ�Ѵ�.
  - void printStackTrace(PrintStream s)
  - void printStackTrace(PringWriter w)
	: ǥ�� ��� ��Ʈ���� ���� ȣ�� ����� ������ �޼ҵ���� ����Ѵ�.

�� �ֿ� ��Ÿ�� ���� �޼ҵ�
  
   - ArithmeticException
     : ��ġ ���� ����(0���� ������ ��)
   - ArrayStoreException
     : �迭�� �߸��� ������ ���� �����Ϸ� ���� ��� �߻��ϴ� ����
   - IndexOutOfBoundsException
     : �迭, ���ڿ� ���� ��� �ε���(÷��) ������ ��� ��� �߻��ϴ� ����
   - ClassCastException
     : Ŭ���� ��ȯ�� �߸��� ��� �߻��ϴ� ����
   - NullPointException
     : �� ��ü�� �����ϴ� ���(�ʱ�ȭ���� ���� ���� ��� ��)
	   �߻��ϴ� ����
   - SecurityException
     : �ڹ��� ���� ���� ������ �����Ͽ��� ��� �߻��ϴ� ����
							
							:

*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Test147
{										   // �� ù ��° ����ó�� ���
	public static void main(String[] args) // throws IOException
	{
		//BufferedReader Ŭ���� �ν��Ͻ� ����
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		//�ֿ� ���� ����
		int a, b, c;

		// �� �� ��° ����ó�� ���
		/*
		try
		{
			System.out.print("ù ��° ���� �Է� : ");
			a = Integer.parseInt(br.readLine());
			System.out.print("�� ��° ���� �Է� : ");
			b = Integer.parseInt(br.readLine());

			c = a + b;

			System.out.println("��� : " + c);

		}
		catch (IOException e)		// �̷��� ��Ȳ�� �߻��Ǹ�~ 
		{
			// IOException �� checkedException 
			// -- �޼ҵ带 �����ϴ� �������� throws �� ����,
			//    ��Ƴ��ų� ������ ���� ��� ������ ���� �߻�
			System.out.println(e.toString());	// �̷��� ó���� �ض�~
		}
		*/
		// �� �� ��° ����ó�� ���
		/*
		try
		{
			System.out.print("ù ��° ���� �Է� : ");
			a = Integer.parseInt(br.readLine());
			System.out.print("�� ��° ���� �Է� : ");
			b = Integer.parseInt(br.readLine());

			c = a + b;

			System.out.println("��� : " + c);

		}
		catch (IOException e)		// �̷��� ��Ȳ�� �߻��Ǹ�~ 
		{
			// IOException �� checkedException 
			// -- �޼ҵ带 �����ϴ� �������� throws �� ����,
			//    ��Ƴ��ų� ������ ���� ��� ������ ���� �߻�
			System.out.println(e.toString());	// �̷��� ó���� �ض�~
		}
		catch (NumberFormatException e)
		{	
			// NumberFormatException �� unchecked exception
			// -- ��Ÿ�ӽ� �߻� �� �� �ִ� ���ܷ�
			//    �ݵ�� ���� �ʿ䵵, ��Ƴ� �ʿ䵵 ����.
			//    �� ���� ó���� ������... ������ �������� ���� ���� ����.
			System.out.println(e.toString());
			System.out.println(">> ���� ������ �����͸� �Է��ؾ� �մϴ�~!! ");
		}
		// ù ��° ���� �Է� : abc
		// java.lang.NumberFormatException: For input string: "abc"
		// >> ���� ������ �����͸� �Է��ؾ� �մϴ�~!!
		*/


		// �� �� ��° ���� ó�� ���
		/*
		try
		{
			System.out.print("ù ��° ���� �Է� : ");
			a = Integer.parseInt(br.readLine());
			System.out.print("�� ��° ���� �Է� : ");
			b = Integer.parseInt(br.readLine());

			c = a + b;

			System.out.println("��� : " + c);

		}
		catch (Exception e)	
		{
			System.out.println("e.toString() : " + e.toString());
			System.out.println("e.getMessage(): "+ e.getMessage());
			System.out.println("printStackTrace..................");
			e.printStackTrace();
			
		}
		*/
		// 
		try
		{
			System.out.print("ù ��° ���� �Է� : ");
			a = Integer.parseInt(br.readLine());
			System.out.print("�� ��° ���� �Է� : ");
			b = Integer.parseInt(br.readLine());

			c = a + b;

			System.out.println("��� : " + c);

		}
		catch (Exception e)	
		{
			System.out.println("e.toString() : " + e.toString());
			System.out.println("e.getMessage(): "+ e.getMessage());
			System.out.println("printStackTrace..................");
			e.printStackTrace();
			
		}
		finally
		{
			// ���ܰ� �߻��ϰų� �߻����� �ʰ� ������ ����Ǵ� ����
			System.out.println("��� �����̽��ϴ�~ �����մϴ�~!!");
		}
		
	
		
	}
}