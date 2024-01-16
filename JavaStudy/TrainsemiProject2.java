import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.Calendar;

import java.util.ListIterator;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class TrainsemiProject2
{
	public static void main(String[] args)
	{
		//String[] Seoultrain = {"10�� ����" , "14�� ����" , "18�� ����"};
		int selectdaparturestaion; // ��߿� ���ú��� (�ٽ���϶� ����)
		int nowtime;		  // ����ð� ������ ��ȯ
		//int timeleft1, timeleft2, timeleft3;
		Calendar ca = Calendar.getInstance();

		int departureTime = ca.get(Calendar.HOUR_OF_DAY);
		int departureMin = ca.get(Calendar.MINUTE);

		nowtime = departureTime*60 + departureMin;
		int stimeleft1 = nowtime - 600;  
		int stimeleft2 = nowtime - 840;
		int stimeleft3 = nowtime - 1080;
		
		
		int ptimeleft1 = nowtime - 660;
		int ptimeleft2 = nowtime - 900;
		int ptimeleft3 = nowtime - 1140;
		

		//---------------------- ���￪ ��� List �迭�� ����-------------------------------
		List<String> Seoultrainlist = new ArrayList<String>();
			
		Seoultrainlist.add("10�� ���");
		Seoultrainlist.add("14�� ���");
		Seoultrainlist.add("18�� ���");

		 /*
		 Ķ����Ŭ������ hour, min�� ������ �ٲ� (nowtime = departureTime*60 + departureMin;)
		 ���� �ð� = ����ð�  -   �� ���� ��߽ð� 
					 09:51(589)     10:00(600)      = -12   : �Ұ�
					 09:50(590)      	            = -10   : ����
					 09:48(592)                     = -8    : ����
		==>> ���� �ð��� -10 �����϶��� �ش� ���� ž�°���
		*/
		
		// 10�� ������ timeleft = nowtime - 600
		// 14�� ������ timeleft = nowtime - 840
		// 16�� ������ timeleft = nowtime - 1080

		// remove() ��� ���� �Ϸ� Ȯ��
		//10�� ���� ����
		if (stimeleft1 > -10 )
		{
			Seoultrainlist.remove(0);
			System.out.printf("��߽ð��� 10���̻� ���� ���� ������ ������ �� �����ϴ�.\n");
			System.out.printf("���� ������ �����ϼ���\n");
		}
		
		// 14�� ���� ����
		if (stimeleft2 > -10)
		{
			Seoultrainlist.remove(0);
			System.out.printf("��߽ð��� 10���̻� ���� ���� ������ ������ �� �����ϴ�.\n");
			System.out.printf("���� ������ �����ϼ���\n");
		}
		
			
		// 18�� ���� ����
		if (stimeleft3 > -10)
		{
			Seoultrainlist.remove(0);
		}
		
		
		ListIterator<String> li = Seoultrainlist.listIterator();
		
		while (li.hasNext())
		{
			System.out.println(li.next() + " ");
		}
		System.out.println();

		


		//---------------------- ��翪 ��� List �迭�� ����-------------------------------
		
		List<String> Pytrainlist = new ArrayList<String>();
			
		Pytrainlist.add("11�� ���");
		Pytrainlist.add("15�� ���");
		Pytrainlist.add("19�� ���");

		if (ptimeleft1 > -10)
		{
			Pytrainlist.remove(0);
		}

		if (ptimeleft2 > -10)
		{
			Pytrainlist.remove(0);
		}

		if (ptimeleft3 > -10)
		{
			Pytrainlist.remove(0);
		}


		ListIterator<String> li2 = Seoultrainlist.listIterator();
		
		while (li2.hasNext())
		{
			System.out.println(li2.next() + " ");
		}
		System.out.println();
		
		

		
	}
}

