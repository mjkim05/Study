/*========================================
  ���� ���� �帧�� ��Ʈ�� (���) ����
  - �ݺ��� �ǽ� �� ���� 
  ==========================================*/ 

  // 1/2 + 2/3+ 3/4+ �� + 9/10
  // �� ���� ó������� ����ϴ� ���α׷��� �����Ѵ�.
  
  // ���� ��)
  // ���� ��� : ?????		�� �Ǽ� ��� ����
  // ����Ϸ��� �ƹ��ų�...

public class Test048
{
	public static void main(String[] args)
	{

		// ���� Ǭ �ڵ� --------------------------------------------------------------------------------
		//�ֿ� ���� ����
		/*
		//double n=1;	
		int n=1;
		double sum=0;

		//���� �� ó�� 
		
		while (n<10)
		{
			sum += (double)n/(n+1);
			n++;
		}
		
		//��� ���

		System.out.printf("���� ��� : %f\n" , sum);

		//���� ��� : 7.071032
		//����Ϸ��� �ƹ� Ű�� �����ʽÿ� . . .
		*/
		//----------------------------------------------------------------------------------------------

		// ¦���� Ǭ �ڵ� ------------------------------------------------------------------------------
		/*
		int a=0,b=1;
		double res, sum=0;

		while (b<10)
        {
         a++;
         b++;
         res = (double)a/b;
         sum += res;
        }


		 //System.out.println("���� ��� : " +sum);            >> ���� ��� : 7.071031746031746
		 System.out.printf("���� ��� : %.3f\n", sum);   //--==>> ���� ��� : 7.071
		*/

		//----------------------------------------------------------------------------------------------

		// �����ϸ� �Բ� Ǭ �ڵ� -----------------------------------------------------------------------

		int n=0;						// -- 1���� 1�� �����ϰ� �� ����
		double sum=0;					// -- �������� ��Ƴ� ����(�Ǽ� ���·� ó��)
		
		// ���� �� ó��
		while (n<9)						// -- 0 1 2 3 4 5 6 7 8
		{
			//������ ����
			// -- ���������� �ݺ����� ������ ���ʶ߸��� �Ǵ� ���谡 �Ǵ� ����
			n++;						// -- 1 2 3 4 5 6 7 8 9

			sum += (double)n/(n+1);		// �ݵ�� ��ȣ �ʿ�	, n�� ������ ��ȯ �ϴ� ����! ���� ����
			//	   1.0/2 2.0/3 3.0/4 4.0/5 �� 9.0/10
			// -- ���� ��� ������ ������ ���� ��ȯ�ϱ� ������
			//	  �Ǽ� ��� ������ �����ϵ��� ó���ϱ� ������
			//	  ������ �����ڸ� �߽����� �ǿ����� �� �ϳ��� 
			//    �Ǽ� ���·� ������ִ� ���� �߿��ϴ�. 

		}
		
		//��� ���
		System.out.printf("���� ��� : %f\n" , sum);	//--==>> ���� ��� : 7.071032
		System.out.println("���� ��� : " + sum);		//--==>> ���� ��� : 7.071031746031746

		//----------------------------------------------------------------------------------------------
	}
}

//������

/*

���� ��� : 7.071032
����Ϸ��� �ƹ� Ű�� �����ʽÿ� . . .


*/