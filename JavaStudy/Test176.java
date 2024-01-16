/*======================================
  ���� �ڹ��� �⺻ �����(I/O) ����	
  - Reader Writer �ǽ�
=======================================*/

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.io.Writer;

public class Test176
{
	public void process(InputStream is)					// ��System.in�� ����~~ !!
	{
		int data; 
		
		System.out.println("���ڿ� �Է�(���� ctrl + Z) : ");	

		try
		{	
			// �Ű����� is ��� ����Ʈ ��� ��Ʈ�� ��ü (InputStream)��
			// ���� ��Ʈ������ ��ȯ�Ͽ� (�� InputStreamReader �� ���� ����)
			// Reader Ÿ���� rd���� ������ �� �ֵ��� ó��
			Reader rd = new InputStreamReader(is);
			//==>> ���� ��� �Է� ��Ʈ�� rd~~!! 
			
			// ����Ʈ ��� ��Ʈ�� ��ü�� �ڹ� �⺻ ��� ��Ʈ��(System.out)�� 
			// ���� ��Ʈ������ ��ȯ�Ͽ� (�� OutputStreamWriter �� ���� ����)
			// Writer Ÿ���� wt���� ������ �� �ֵ��� ó��
			Writer wt = new OutputStreamWriter(System.out);
			//==>> ���� ��� ��� ��Ʈ�� wt
			
			// �о���̴� ��Ʈ�����κ��� �ϳ��� ����
			while ( (data = rd.read()) != -1)
			{
				wt.write(data);				//-- �������� ��Ʈ��(���ٱ�)���� data�� �ϳ��� ���
				wt.flush();					//-- ����� ��Ʈ��(���ٱ�)�� �о�� ������	
			}
			
		}
		catch (IOException e)
		{
			System.out.println(e.toString());
		}
		
	}
	public static void main(String[] args)
	{
		Test176 ob = new Test176();
		ob.process(System.in);
	}
}


//���� ���

/*

���ڿ� �Է�(���� ctrl + Z) :
1234567
1234567
abcdefg
abcdefg
�����ٶ󸶹ٻ�
�����ٶ󸶹ٻ�
^Z
����Ϸ��� �ƹ� Ű�� �����ʽÿ� . . .

*/