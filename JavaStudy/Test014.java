/*=============================================
  ���� �ڹ��� �⺻ ���α׷��� ����
  - ������ �ڷ���
  - �ڹ��� �⺻ ����� : BufferedReader Ŭ���� 
=============================================*/

// ����ڷκ��� �̸�, ��������, ��������, ���������� �Է¹޾�
// �̸��� ������ ����ϴ� ���α׷��� �����Ѵ�.

// ���� ��) 
// �̸��� �Է��ϼ��� : �����
// ���� ���� �Է� : 90
// ���� ���� �Է� : 80
// ���� ���� �Է� : 70

// === [���] ===
// �̸� : �����
// ���� : 240
// ����Ϸ��� �ƹ�Ű�� ��������...


		
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Test014
{
	public static void main(String[] args) throws IOException //throws IOException
	{
		// ���� Ǯ���� ���� -----------------------------------------------------------
		/*
		// �ֿ� ���� ���� �� �ʱ�ȭ 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String name;			//�̸� ���� 
		int kor;				//���� ����
		int eng;				//���� ����
		int mat;				//���� ����
		int a;					//����


		// ���� �� ó�� 
		System.out.print("�̸��� �Է��ϼ��� : ");
		name = br.readLine();
		System.out.print("���� ���� �Է� : ");
		kor = Integer.parseInt(br.readLine());
		System.out.print("���� ���� �Է� : ");
		eng = Integer.parseInt(br.readLine());
		System.out.print("���� ���� �Է� : ");
		mat = Integer.parseInt(br.readLine());
	
		a = kor + eng + mat;	

		// ��� ���
		System.out.println("\n ==== [���]==== ");
		System.out.println("�̸� : " + name);
		System.out.println("���� : " + a);
		*/
		//���� ��� 
		/*
		�̸��� �Է��ϼ��� : �����
		���� ���� �Է� : 100
		���� ���� �Է� : 100
		���� ���� �Է� : 100

		 ==== [���]====
		�̸� : �����
		���� : 300
		����Ϸ��� �ƹ� Ű�� �����ʽÿ� . . .
		*/	

		//---------------------------------------------------------------------------- 

		//------------¦���� �Է��� �ڵ�----------------------------------------------
		 /*
		 int a, b, c, sum;
		 String nm;

		 System.out.print("�̸��� �Է��ϼ��� : ");
		 nm = br.readLine();

		 System.out.print("���� ���� �Է� : ");
		 a = Integer.parseInt(br.readLine());
      
		 System.out.print("���� ���� �Է� : ");
		 b = Integer.parseInt(br.readLine());

		 System.out.print("���� ���� �Է� : ");
		 c = Integer.parseInt(br.readLine());

		 sum = a + b + c;

		 System.out.println();
		 System.out.println("===[���]===");
		 System.out.println("�̸� : " + nm);
		 System.out.printf("���� : %d%n", sum);

	  */

	  
      // ���� ���

      /*
      �̸��� �Է��ϼ��� : ä�ټ�
      ���� ���� �Է� : 90
      ���� ���� �Է� : 80
      ���� ���� �Է� : 70

      ===[���]===
      �̸� : ä�ټ�
      ���� : 240
      ����Ϸ��� �ƹ� Ű�� �����ʽÿ� . . .*/

	 //------------------------------------------------------------------------------

	 // �����ϸ� �Բ� Ǯ� ���� ---------------------------------------------------

	 //�ֿ� ���� ���� 

	 //BufferedReader �ν��Ͻ� ����
	 //BufferedReader br. new BufferedReader(new InputStreamReader(System.in));

	 //�� �̷������ε� ��� �� �� �ִٴ� ���� �˰��ֱ�!!!
	 InputStreamReader isr = new InputStreamReader(System.in);
	 BufferedReader br = new BufferedReader(isr);

	String strName;				// -- �̸� ���� 
	int nKor,nEng, nMat;		// -- ���� ����, ���� ����, ���� ���� ���� 
	int nTot;					// -- ���� ����
	String strTemp;				// -- ���ڿ� �ӽ� ���� ����

	// ���� �� ó��
	// - ����ڿ��� �ȳ� �޼��� ���(�̸� �Է� �ȳ�)
	System.out.print("�̸��� �Է��ϼ���: ");

	// - ����ڰ� �Է��� ��(�ܺ� ������)�� ������ ��Ƴ���
	strName = br.readLine();

	// - ����ڿ��� �ȳ� �޼��� ��� (���� �޼��� �Է�)
	System.out.print("���� ���� �Է� : ");

	// - ����ڰ� �Է��� ��(�ܺ� ������)�� ������ ��Ƴ��� 
	strTemp = br.readLine();

	// - ��Ƴ� �����͸� ��ȯ�� �� �ʿ��� ������ �ٽ� ��� 
	nKor = Integer.parseInt(strTemp);

	// - ����ڿ��� �ȳ� �޼��� ���(���� ���� �ȳ�)
	System.out.print("���� ���� �Է� : ");

	// - ����ڰ� �Է��� ��(�ܺ� ������)�� ������ ��Ƴ���
	strTemp = br.readLine();

	// - ��Ƴ� �����͸� ��ȯ�� �� �ʿ��� ������ �ٽ� ���
	nEng = Integer.parseInt(strTemp);

	// - ����ڿ��� �ȳ� �޼��� ���(���� ���� �ȳ�)
	System.out.print("���� ���� �Է� : ");

	// - ����ڰ� �Է��� ��(�ܺ� ������)�� ������ ��Ƴ���
	strTemp = br.readLine();

	// - ��Ƴ� �����͸� ��ȯ�� �� �ʿ��� ������ �ٽ� ���
	nMat = Integer.parseInt(strTemp);

	// - �� ���� ������ ����ִ� ������(����ڰ� �Է��� ������)����
	//	 �����Ͽ� ������ �����ϰ� �� ����� ���� ������ ��Ƴ���
	nTot = nKor + nEng + nMat;

	//������
	System.out.println("=====���=====");
	//System.out.println("�̸� : " + strName);
	System.out.printf("�̸� : %s\n" ,strName);
	System.out.println("���� : " + nTot);
	//System.out.ptintf("���� : %d\n " ,nTot);

	


	
	 //------------------------------------------------------------------------------
		
	}
}

//���� ���
/*
	�̸��� �Է��ϼ��� : �����
	���� ���� �Է� : 100
	���� ���� �Է� : 100
	���� ���� �Է� : 100

	 ==== [���]====
	�̸� : �����
		���� : 300
		����Ϸ��� �ƹ� Ű�� �����ʽÿ� . . .
*/