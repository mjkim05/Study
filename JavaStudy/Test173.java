/*======================================
  ���� �ڹ��� �⺻ �����(I/O) ����	
  - OutputStream �ǽ�
=======================================*/

import java.io.OutputStream;
import java.io.IOException;

public class Test173
{
	public static void main(String[] args) throws IOException
	{

		// �� ��System.in��  : �ڹ��� ǥ�� �Է� ��Ʈ��
		//    ��system.out�� : �ڹ��� ǥ�� ��� ��Ʈ�� 
		OutputStream out = System.out;

		// �迭 ����
		byte[] ch = new byte[3];

		ch[0] = 65;					// A
		ch[1] = 97;					// a
		ch[2] = 122;				// z
		
		/*
		out.write(65);
		//out.write(ch[0]);
		out.write(97);
		out.write(122);
		*/
	

		out.write(ch);				//-- ������ ������ ������(����)�� ��Ʈ��(���ٱ�)�� ���
		
		out.flush();				//-- ��ϵ� ��Ʈ���� ��������(�о��) ����� ����
									//   ������ Buffer�� Ȱ������ �ʰ� �ִ� ��Ȳ�̱� ������
									//   ������ ������ �ڵ�
									//   (Buffered �Ǿ��ִ� ��Ʈ��(Stream)�� ��� �����Ұ�)

		out.close();				// close() �� ���ҽ� �ݳ��ǹ� ���̻� �� ���ҽ��� ���� �ʰڴ�~	
									// ��� ��Ʈ��(���ٱ�)�� ���� ���ҽ� �ݳ�
									// (out ��Ʈ����(���ٱ� ����������)�ᰡ���� ��Ȳ)

		System.out.println("�������� �ŷڸ� �����ִ� ����");
		//-- ��out.close()���� �ۼ��� ���� ��µ��� �ʴ� ����.
		//    ��µǴ� ��Ʈ��(���ٱ�)�� �ݾұ� ������...
		

	}
}