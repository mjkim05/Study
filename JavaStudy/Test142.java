/*=============================================
  ���� �ڹ��� �⺻ ���α׷��� ����
  - �ڹٿ��� �⺻������ �����ϴ� �ֿ� Ŭ����
  - Calendar Ŭ����
==============================================*/

/*
�� Calendar Ŭ������ �߻� Ŭ�����̱� ������ ��ü�� ������ �� ����.
   (�߻� Ŭ���� : �̿ϼ��� Ŭ���� �� ����� ���� �����ϴ� Ŭ����)

   Calendar ob = new Calendar();
   �� �̿� ���� ������ ���� �ν��Ͻ� ���� �Ұ�

�� Calendar Ŭ���� ��ü(�ν��Ͻ�)�� ������ �� �ִ� ���

   1. Calendar ob1 =  Calendar.getInstance();					// Ŭ���� �޼ҵ� static~~
   
   2. Calendar ob2 = new GregorianCalendar();					// �� ĳ���� GregorianCalendar �� �ڽ� Ŭ������� ���� �� �� �ִ�. 
   	  //GregorianCalendar gc = new GregorianCalendar();
	  //Calendar ob2 = gc;
	  //Calendar ob2 = (Calndar)gc;

   3. GregorianCalender ob3 = new GregorianCalendar();

   (�� GregorianCalendar : Calendar Ŭ������ ���� Ŭ����)
*/


// ��, ��, �� ������ Calendar ��ü�κ��� ������ ���

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Test142
{
	public static void main(String[] args)
	{
		//Calendar ��ü ����
		//Calendar ob = new Calendar();		// �̰� �ȵ�
		Calendar rightNow = Calendar.getInstance();

		// ������ �޷�(Calendar) �ν��Ͻ��� ����
		// ��¥ ���� ������ �� �� �ִ� �޼ҵ� �� ��get()��
		
		int y = rightNow.get(Calendar.YEAR);			// YEAR �� static final ����
		System.out.println("y : " + y); 
		//--==>> y : 2023

		int m = rightNow.get(Calendar.MONTH)+1;		//--��+1�� check~~!! 	
		System.out.println("m : " + m);
		//--==>> m : 9

		int d = rightNow.get(Calendar.DATE);
		System.out.println("d : " + d);
		//--==>> d : 19

		int w = rightNow.get(Calendar.DAY_OF_WEEK);
		System.out.println("w : " + w);
		//--==>> w : 3

		// �׽�Ʈ(Ȯ��)
		//System.out.println(Calendar.SUNDAY);		//--==>> 1 �� �Ͽ���
		//System.out.println(Calendar.MONDAY);
		//System.out.println(Calendar.TUESDAY);
		//System.out.println(Calendar.WEDNESDAY);
		//System.out.println(Calendar.THURSDAY);
		//System.out.println(Calendar.FRIDAY);
		//System.out.println(Calendar.SATURDAY);

		System.out.println(y + "-" + m +"-"+ d +"-" +w);
		//--==>> 2023-9-19-3

		String week="";
		switch(w)
		{
			//case Calendar.SUNDAY : week = "�Ͽ���"; break;
			//case Calendar.MONDAY : week = "������"; break;	
			//case Calendar.TUESDAY : week = "ȭ����"; break;	
			//case Calendar.WEDNESDAY : week = "������"; break;	
			//case Calendar.THURSDAY : week = "�����"; break;	
			//case Calendar.FRIDAY : week = "�ݿ���"; break;	
			//case Calendar.SATURDAY : week = "�����"; break;	

			case 1 : week = "�Ͽ���"; break;
			case 2 : week = "������"; break;	
			case 3 : week = "ȭ����"; break;	
			case 4 : week = "������"; break;	
			case 5 : week = "�����"; break;	
			case 6 : week = "�ݿ���"; break;	
			case 7 : week = "�����"; break;

		}
		
		System.out.println(y + "-" + m +"-"+ d +"-" +week);
		//--==>> 2023-9-19-ȭ����
		

		System.out.println("/////////////////////////////////////////////////");

		//Calendar ��ü ����
		Calendar rightNow2 = new GregorianCalendar();

		String[] week2 = {"�Ͽ���", "������", "ȭ����", "������","�����","�ݿ���","�����"};

		// �޷��� ��¥ ���� �� ��set()���޼ҵ� Ȱ��
		rightNow2.set(2024, 2, 19);		//2024�� 03�� 19��			//check~!!!

		System.out.println(rightNow2.get(Calendar.DAY_OF_WEEK));
		//--==>> 3

		System.out.println(week2[rightNow2.get(Calendar.DAY_OF_WEEK)-1]);
		//--==>> ȭ����


	}
}