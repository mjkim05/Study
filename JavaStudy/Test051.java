/*========================================
  ���� ���� �帧�� ��Ʈ�� (���) ����
  - �ݺ���(while��) �ǽ� �� ���� 
  ==========================================*/

  // ����ڷκ��� ������ �� ������ �Է¹޾�
  // �Է¹��� �� ������
  // ���� �� ���� ū �������� ���� ���Ͽ�
  // ����� ����ϴ� ���α׷��� �����Ѵ�.
  
  // ���� ��)
  // ù��° ���� �Է� : 100
  // �ι�° ���� �Է� : 200
  //  >> 100 ~ 200 ������ �� : xxxx 
  // ����Ϸ��� �ƹ�Ű�� ��������

  // ù��° ���� �Է� : 1000
  // �ι�° ���� �Է� : 2
  //  >> 2 ~ 1000 ������ �� : xxxxx
  // ����Ϸ��� �ƹ�Ű�� ��������

  
  // ù��° ���� �Է� : 10
  // �ι�° ���� �Է� : 10
  //  >> 10 ~ 10 ������ �� : 10
  // ����Ϸ��� �ƹ�Ű�� ��������

  import java.io.BufferedReader;
  import java.io.InputStreamReader;
  import java.io.IOException;

public class Test051
{
	public static void main(String[] args) throws IOException
	{	
		//�ֿ� ���� ����
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num1 , num2;				//����ڰ� �Է��� ����
		int n=0;
		int sum=0;						//�������� ���� ����

		//����ڷκ��� ���� �ޱ�
		System.out.print("ù��° ���� �Է� : ");
		num1 = Integer.parseInt(br.readLine());
		System.out.print("�ι�° ���� �Է� : ");
		num2 = Integer.parseInt(br.readLine());

		// �׽�Ʈ
		//System.out.println("�Է¹��� �� Ȯ�� : " + num1 + " " + num2);

		// �����غ� �� 
		// ���������� ������ �� 
		// ū���� ���� ���� �����ϴ� ����� �����غ���!
		// ��� �ΰ��� ���غ���

		if (num1>num2)				//num2�� num1���� ũ�ų� ���� ���
		{
			num1= num1^num2;
			num2= num2^num1;
			num1= num1^num2;

		}
	

		//�׽�Ʈ ���� �ΰ��� �� �ٲ���� Ȯ��
		//
		System.out.printf("\n ���� num1�� �� : %d, num2�� �� : %d",num1,num2 );

		while (n<=num2)
		{

				sum +=n;
				
				n++;
		
		}

		System.out.printf("\n%d���� %d������ �� : %d\n" ,num1,num2, sum);
	
		

		//----------------------------------------------------------------------------------
		/*

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n;
		int su1,su2;				//ù ��°, �� ��° ����� �Է� ���� ���� ����
		int result=0;


		//���� �� ó�� 
		System.out.print("ù ��° ���� �Է� : ");
		su1 = Integer.parseInt(br.readLine());
		System.out.print("�� ��° ���� �Է� : ");
		su2 = Integer.parseInt(br.readLine());

		if (su1 > su2)
		{	
			//�ڸ��ٲ�
			su1= su1^su2;
			su2= su2^su1;
			su1= su1^su2;
		}

		// �ݺ� ���� ����
		// �ݺ� ������ �����ϱ� ���� 
		// ���� ���� ���� �����Ͽ� ���� ������ Ȱ���Ѵ�.
		// (��� ��� �������� �Է¹��� ���� ���� �ʿ��ѵ�...)
		// �� ���� �ݺ� �������� ����ϰ� �Ǹ�..
		// ���� ó�� �Էµ� ���� Ȯ�� �� �� ���⶧����..

		n = su1;
		while (n<=su2)
		{
			result +=n;
			n++;
		}
		//��� ���
		System.out.printf("%d ~ %d ������ �� : %d\n", su1, su2, result);
		*/
	}
}