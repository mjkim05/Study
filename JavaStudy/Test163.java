/*================================
  ���� �÷���(Collection) ����		
=================================*/

// Test163 Ŭ������ �ϼ��Ͽ� ���� ����� ���� ���α׷��� �����Ѵ�.

/*
���� ��)
	
	[�޴� ����]==============
	1. ��� �߰� 
	2. ��� ���
	3. ��� �˻�
	4. ��� ����
	5. ��� ����
	6. ���� 
	=========================
 >> �޴� ����(1~6) : 1
 
 1��° ��� �Է� : ������
 1��° ��� �Է� ����~!!!
 ��� �Է� ���(Y/N)? : y

 2��° ��� �Է� : ä�ټ�
 2��° ��� �Է� ����~!!
 ��� �Է� ���(Y/N)? : n

 	[�޴� ����]==============
	1. ��� �߰� 
	2. ��� ���
	3. ��� �˻�
	4. ��� ����
	5. ��� ����
	6. ���� 
	=========================
 >> �޴� ����(1~6) : 2
 
 [���� ��ü ���]
 ������
 ä�ټ�
 ���� ��ü ��� �Ϸ�~!!

  	[�޴� ����]==============
	1. ��� �߰� 
	2. ��� ���
	3. ��� �˻�
	4. ��� ����
	5. ��� ����
	6. ���� 
	=========================
 >> �޴� ����(1~6) : 3

 �˻��� ��� �Է� : ä�ټ�

 [�˻� ��� ���]
 �׸��� �����մϴ�.

  	[�޴� ����]==============
	1. ��� �߰� 
	2. ��� ���
	3. ��� �˻�
	4. ��� ����
	5. ��� ����
	6. ���� 
	=========================
 >> �޴� ����(1~6) : 3

 �˻��� ��� �Է� : ������
 
 [�˻� ��� ���]
 �׸��� �������� �ʽ��ϴ�.

   	[�޴� ����]==============
	1. ��� �߰� 
	2. ��� ���
	3. ��� �˻�
	4. ��� ����
	5. ��� ����
	6. ���� 
	=========================
 >> �޴� ����(1~6) : 4

 ������ ��� �Է� : ���ѿ�

 [���� ��� ���]
 �׸��� �������� �ʾ� ������ �� �����ϴ�.

   	[�޴� ����]==============
	1. ��� �߰� 
	2. ��� ���
	3. ��� �˻�
	4. ��� ����
	5. ��� ����
	6. ���� 
	=========================
 >> �޴� ����(1~6) : 4

 ������ ��� �Է� : ������

 [���� ��� ���]
 ������ �׸��� ���� �Ǿ����ϴ�.

   	[�޴� ����]==============
	1. ��� �߰� 
	2. ��� ���
	3. ��� �˻�
	4. ��� ����
	5. ��� ����
	6. ���� 
	=========================
 >> �޴� ����(1~6) : 5

 ������ ��� �Է� : ���ϼ�

 [���� ��� ���]
 ������ ����� �������� �ʽ��ϴ�.

   	[�޴� ����]==============
	1. ��� �߰� 
	2. ��� ���
	3. ��� �˻�
	4. ��� ����
	5. ��� ����
	6. ���� 
	=========================
 >> �޴� ����(1~6) : 5

 ������ ��� �Է� : ä�ټ�
 ������ ���� �Է� : ������

 [���� ��� ���]
 ������ �Ϸ�Ǿ����ϴ�.

   	[�޴� ����]==============
	1. ��� �߰� 
	2. ��� ���
	3. ��� �˻�
	4. ��� ����
	5. ��� ����
	6. ���� 
	=========================
 >> �޴� ����(1~6) : 2

 [���� ��ü ���]
 ������
 ���� ��ü ��� �Ϸ�~~!!

   	[�޴� ����]==============
	1. ��� �߰� 
	2. ��� ���
	3. ��� �˻�
	4. ��� ����
	5. ��� ����
	6. ���� 
	=========================
 >> �޴� ����(1~6) : 6

 ���α׷� ����~~!! 
 ����Ϸ��� �ƹ�Ű�� ��������...

*/

import java.util.Vector;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Enumeration;

class Menus			// �� �ϼ� / Menus.E_ADD ���? �̷������� ���ʼ�~~~
{
	public static final int E_ADD  = 1;		// ��� �߰�
	public static final int E_DISP = 2;		// ��� ���
	public static final int E_FIND = 3;		// ��� �˻�
	public static final int E_DEL  = 4;		// ��� ����
	public static final int E_CHA  = 5;		// ��� ����
	public static final int E_EXIT = 6;		// ���� 

}


public class Test163
{

	// �ֿ� �Ӽ� ���� �� �Ϸ� 
	private static final Vector<Object> vt; // �ڷᱸ��
	private static  BufferedReader br;      // �Է� �� Ȱ��
	private static  Integer sel;		    // ���� ��
	private static  String con;		        // ��� ���� ����
		
	
	// static �ʱ�ȭ �� �ϼ�
	static			
	{
		// -- Vector �ڷᱸ�� ����
		vt = new Vector<Object>();
		
		// BufferedReader ��ü ����
		br = new BufferedReader(new InputStreamReader(System.in));

		//����� �Է� �� �ʱ�ȭ
		sel = 1; 
		con = "Y";
	}
	
	// �޴� ��� �޼ҵ�
	public static void menuDisp()
	{
		// ����ڿ��� �ȳ��ϱ� ���� �޼������� ����ϴ� ���
		// �޴��� �����ϴ� ����� �޼ҵ�(menuSelect())�� ������ �����߱� ������
		// �� ���������� ������� ���ð��� �޾ƿ��� �ʾƵ� ������
		System.out.println("\n	[�޴� ����]==============");
		System.out.println("	1. ��� �߰� ");
		System.out.println("	2. ��� ��� ");
		System.out.println("	3. ��� �˻� ");
		System.out.println("	4. ��� ���� ");
		System.out.println("	5. ��� ���� ");
		System.out.println("	6. ���� ");
		System.out.println("	=========================");
	
	}
	
	// �޴� ���� �޼ҵ�
	public static void menuSelect() throws IOException, NumberFormatException
	{		
			
			// ������ �޴��� ���� ��� �б�� 
			// menuRun���� ó���� �����̱� ������ 
			// �Է� ���� �޾ƿ��� ��ɸ� ����

			
			try
			{
				System.out.print("\n\t >> �޴� ����(1~6) : ");
				sel = Integer.parseInt(br.readLine());
				//System.out.println();
			}
			catch (NumberFormatException e)
			{
				//System.out.println(e.toString());
				//System.out.println("���ڷ� �Է��ϼ���!!");
				sel = 0;
			}
			
			
	}
	
	//���õ� �޴� ���࿡ ���� ��� ȣ�� �޼ҵ�
	public static void menuRun() throws IOException
	{
		switch (sel)
		{
			case Menus.E_ADD : addElement(); break;
			case Menus.E_DISP: dispElement(); break;
			case Menus.E_FIND: findElement(); break;
			case Menus.E_DEL : delElement(); break;
			case Menus.E_CHA : chaElement(); break;
			case Menus.E_EXIT: exit(); break;
			default : System.out.println("\n\t �޴� ���� ����~");
		}
	}

	// �ڷᱸ���� ��� �߰�(�Է�) �޼ҵ�
	public static void addElement() throws IOException
	{
		/*	�� �ڵ�
		do
		{		
				System.out.printf("%d��° ��� �Է� : " , vt.size()+1);
				String str = br.readLine();
				vt.add(str); 
				System.out.printf("%d��° ��� �Է� ����~~!!\n" , vt.size());
				System.out.print("��� �Է� ��� (Y/N) : ");
				con = br.readLine();	
				System.out.println();
		
		}
		while (con.equals("Y")  || con.equals("y"));
		*/

		// ���� �ڵ�
		do
		{	System.out.printf("\n\t%d��° ��� �Է� : " , vt.size()+1);
			String element = br.readLine();
			boolean b = vt. add(element);
			if (b)
			{
				System.out.printf("\n\t %d��° ��� �Է� ����~~!!\n" , vt.size());
			}
			System.out.print("\n\t ��� �Է� ��� (Y/N) : ");
			con = br.readLine().toUpperCase();		// br.readLine.toUpperCase() �� String Ŭ���� �޼ҵ� �� toUpperCase - �ҹ��ڰ� ���͵� �빮�ڷ� �ٲ���!! 
		}
		while (con.equals("Y"));		// �빮�� Y�� �־ ���� why? �� toUpperCase()�� �빮�ڷ� �ٲ��ִϱ�~
		
	
	}
	
	// �ڷᱸ�� ��ü ��� ��� �޼ҵ�
	public static void dispElement() 
	{	
		/* �� �ڵ�
		System.out.println("\n [���� ��ü ���]");
		for(Object obj : vt)
			System.out.println(" " + obj);
		System.out.println(" ���� ��ü ��� �Ϸ�~!!");	
		*/
		// ���� �ڵ�
		System.out.println("\n\t [���� ��ü ���]");
		for (Enumeration e = vt.elements(); e.hasMoreElements(); )				// hasMoreElements() �� hasNext() ��� �Ȱ���!!!
		{
			System.out.printf("\t%10s\n", e.nextElement());						// nextElement() �� next() ��� �Ȱ���!! 
		}
		System.out.println("\n\t ���� ��ü ��� �Ϸ�~!!");

	}

	// �ڷᱸ�� �� ��� �˻� �޼ҵ�
	public static void findElement() throws IOException
	{	
		System.out.print("\n\t �˻��� ��� �Է� :");
		String str = br.readLine();
		
		//System.out.println("[�˻� ��� ���]"); ���⿡ �ᵵ ��!! 
	

		if (vt.contains(str))
		{
			System.out.println("\n\t [�˻� ��� ���]");
			System.out.println("\n\t �׸��� �����մϴ�.");

			// ���� �ڵ� 
			// �߰� Ȯ��!!
			System.out.println("\n\t"+ str + " �ε��� ��ġ :" + vt.indexOf(str));
		}
		else
		{
			System.out.println("\n\t[�˻� ��� ���]");
			System.out.println("\n\t �׸��� �������� �ʽ��ϴ�.");
		}

	}	

	// �ڷᱸ�� �� ��� ���� �޼ҵ�
	public static void delElement() throws IOException
	{
		System.out.print("\n\t ������ ��� �Է� : ");
		String str = br.readLine();

		int i = vt.indexOf(str);
		
		//System.out.prtinln("\n [���� ��� ���]");		// ���� �ᵵ �� �׷��� �ؿ� �Ƚᵵ ���� 

		if (vt.contains(str))
		{			
			System.out.println("\n\t [���� ��� ���]");

			//int i = vt.indexOf(str);						// ���⿡ �ᵵ �ȴ�!!
			vt.remove(i);

			System.out.printf("\n\t%s �׸��� ���� �Ǿ����ϴ�.\n" , str);
		}
		else
		{
			System.out.println("\n\t [���� ��� ���]");
			System.out.println("\n\t �׸��� �������� �ʾ� ������ �� �����ϴ�.");
		}
		
	}
	
	// �ڷᱸ�� �� ��� ����(����) �޼ҵ�
	public static void chaElement() throws IOException
	{		
		System.out.print("\n\t ������ ��� �Է� : ");
		String str = br.readLine();
		int i = vt.indexOf(str);
		System.out.println();

		if (vt.contains(str))
		{
			System.out.print("\n\t ������ ���� �Է� : ");
			String str2 = br.readLine();
			vt.set(i, str2);
			System.out.println();
			
			System.out.println("\n\t [���� ��� ���]");
			System.out.println("\n\t ������ �Ϸ�Ǿ����ϴ�.");
		}
		else
		{
			System.out.println("\n\t [���� ��� ���]");
			System.out.println("\n\t ������ ����� �������� �ʽ��ϴ�.");
		}
	}
	
	// ���α׷� ���� �޼ҵ� �� �ϼ�
	public static void exit()
	{
		System.out.println("\n\t���α׷��� ����");
		System.exit(-1);
	}
	
	// main() �޼ҵ�	�� �ϼ�
	public static void main(String[] args) throws IOException, NumberFormatException
	{

		do
		{
			menuDisp();
			menuSelect();
			menuRun();
		}
		while (true);
		
	}
}