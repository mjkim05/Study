/*=============================================
  ���� �ڹ��� �⺻ ���α׷��� ����
  - �ڹٿ��� �⺻������ �����ϴ� �ֿ� Ŭ����
  - Math Ŭ����
==============================================*/
/*
�� java,lang.Math Ŭ������ 

   ����(Mathmatics)�� ���õ� ������ �Ӽ��� �޼ҵ带 �����ϴ� Ŭ������ 
   �����ڰ� �ֱ� ������... ��private������ ����Ǿ� �ֱ� ������
   �ܺο��� ��ü(�ν��Ͻ�)�� ���� �� �� ����.
   ��, ��� �޼ҵ尡 static���� ���ǵǾ� �����Ƿ� 
   ��ü�� �������� �ʰ� �ٷ� �����Ͽ� ����ϴ� ���� �����ϴ�.

�� java.lang.Math Ŭ������ �ֿ� ��� �� �޼ҵ�

  - public static final double E = 2.17...;
  : �ڿ� �α� �Լ�
  - public static flnal double PI = 3.141592...;
  : ������(��)

  -public static double sin(double a)
  -public static double cos(double a)
  -public static double tan(double a)

  -public static double asin(double a)
  -public static double acos(double a)
  -public static double atan(double a)
  : asin(a) , acos(a), atan(a) ���� ��ȯ�Ѵ�. (�ﰢ�Լ��� ���Լ�)

  - public static double toRadians(double angdeg)
   : ����(angdeg)�� ����(radian)���� �ٲپ� ��ȯ�Ѵ�.
  - public static double angdeg(double Radians)
   : ����(radian)�� ����(angdeg)���� �ٲپ� ��ȯ�Ѵ�.

  - public static double exp(double a)
   : a�� e���� ���Ͽ� ��ȯ�Ѵ�. 

  - public static double log(double a)
   : �α� ���� ���Ͽ� ��ȯ�Ѵ�. 

  - public static double sqlt(double a)
   : a�� �������� ���Ͽ� ��ȯ�Ѵ�.
  
  - public static double ceil(double a)
   : a ���� ũ�ų� ���� ������ ��ȯ�Ѵ�. 

  - public static double floor(double a)
   : a���� �۰ų� ���� ������ ��ȯ�Ѵ�. 

  - public static double pow(double a)
   : a�� b���� ���Ͽ� ��ȯ�Ѵ�.

  - public static int round(float a)
  - public static long round(double a)
    : a �� �ݿø��Ͽ� ������� ��ȯ�Ѵ�.

  - public static double random()
    :0.0 ~ 1.0 ������ ����(������ ����)�� �߻����� ��ȯ�Ѵ�. 

*/

public class Test145
{
	public static void main(String[] args)
	{
		System.out.println("������ : " + Math.PI);
		//--==>> ������ : ������ : 3.141592653589793
		System.out.println("2�� ������" + Math.sqrt(2));
		//--==>> 2�� ������1.4142135623730951

		System.out.println("���̿� ���� Degree : " + Math.toDegrees(Math.PI));
		System.out.println("2���̿� ���� Degree : " + Math.toDegrees(2.0*Math.PI));
		//--==>> ���̿� ���� Degree : 180.0
		//		 2���̿� ���� Degree : 360.0
		
		
		//������ �������� ��ȯ~~!! 
		double radian45 = Math.toRadians(45);

		System.out.println("���� 45 : " + radian45);
		System.out.println("���� 45 : " + Math.sin(radian45));
		System.out.println("�ڽ��� 45 : "+ Math.cos(radian45));
		System.out.println("ź��Ʈ 45 : "+ Math.tan(radian45));
		//--==>> ���� 45 : 0.7853981633974483
		//		 ���� 45 : 0.7071067811865475
		//		 �ڽ��� 45 : 0.7071067811865476
		//		 ź��Ʈ 45 : 0.9999999999999999

		System.out.println("�α�25 : " + Math.log(25));
		//--==>> �α�25 : 3.2188758248682006
		
		System.out.println("2�� 4�� : " + Math.pow(2,4));
		//--==>> 2�� 4�� : 16.0

		System.out.println("0.0~1.0 ������ ���� : " + Math.random());
		//--==>> 0.0~1.0 ������ ���� : 0.716543982712375
		//       0.0~1.0 ������ ���� : 0.8621539017162438
		//		 0.0~1.0 ������ ���� : 0.044482661324200645
		//		 0.0~1.0 ������ ���� : 0.415530022141826
		//		 0.0~1.0 ������ ���� : 0.4222313766433343
	}
}