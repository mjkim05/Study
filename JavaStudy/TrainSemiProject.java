import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.Calendar;

import java.util.ListIterator;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class TrainsemiProject
{

	int selectdaparturestaion // ��߿� ���ú��� 

	String[] Seoultrain = {"10�� ����" , "14�� ����" , "18�� ����"};
	//String[] Seoultrain = {"10�� ����" , "14�� ����" ,};
	//String[] Seoultrain = {"10�� ����"};



	//String[] Pytrain = {"11�� ����" , "15�� ����" , "19�� ����"};


	
			public int nowtime		  // ����ð� ������ ��ȯ
			int timeleft;
			Calendar ca = Calendar.getInstance();

			departureTime = ca.get(Calendar.HOUR_OF_DAY);
			departureMin = ca.get(Calendar.MINUTE);

			nowtime = departureTime*60 + departureMin;
			
			/*
			if(newtrain[0] <= 9)
			System.out.printf("%s�� ������ �� �����ϴ�." , train[0]);
			remove.train[0];
			System.out.print("14�� ����, 18�� ���� ���ð���");

			if(newtrain[1] <= 9)
			System.out.printf("%s�� ������ �� �����ϴ�." , train[1]);
			remove.train[1];
			System.out.print("18�� ���� ���ð���");

			if(newtrain[2] <= 9)
			System.out.printf("%s�� ������ �� �����ϴ�." , train[2]);
			remove.train[2];
			System.out.print("���� ��翪 �� ���� ��. ���� ���� �����ϼ���");
			*/
		public static void main(String[] args)		

	}
}

		// ���￪ ��� List �迭�� ����
		
		private void Seoul()
		{
			List<String> Seoultrainlist = new ArrayList<String>();

			Seoultrainlist.add("18�� ���");
			Seoultrainlist.add("14�� ���");
			Seoultrainlist.add("10�� ���");

			ListIterator<String> li = Seoultrainlist.listIterator();
			
			
			while (li.hasNext())
			{
				System.out.print(li.next() + " ");
			}
			System.out.println();
			
			
			// ��� 10���������� �߱ǰ���
			for (int i=0; i<Seoultrainlist; i++ )
			{
				if (timeleft > 0 )
				Seoultrainlist.remove(0);
				
			}
			


			// ���� ���
			for (int i=Seoultrainlist.size()-1; i>=0; i-- )
			{
				System.out.println(Seoultrainlist.get(i) + " ");
			}
		}
		
	
		// ��翪 ��� List �迭�� ����
		/*
		private void Py()
		{
			List<String> PytrainList = new ArrayList<String>();
			
			Pytrainlist.add("19�� ���");
			Pytrainlist.add("15�� ���");
			Pytrainlist.add("11�� ���");

			ListIterator<String> li = Pytrainlist.listIterator();

			// ��� 10���������� �߱ǰ���	
			if (timeleft <= )
			{
				Pytrainlist.remove(0);
			}	
			// ���� ���
			for (int i=Pytrainlist.size()-1; i>=0; i-- )
			{
				System.out.println(Ptrainlist.get(i) + " ");
			}

		 }*/





/*-------------------------------------------------------------------------------------------------------------------------
		timeleft = (���� ��� �ð� 10��/ 14��/ 18��) - nowtime; 			
			    �� String���� ���� ������߽ð��� parseInt�� �޾ƾ��Ѵ�.  // �� 1 / 2 �����ε�?
				String[] train = {"10�� ����" , "14�� ����" , "18�� ����"};

					int[] newtrain = new int[train.length];
        				for (int i = 0; i < train.length; i++) {
            				newtrain[i] = Integer.parseInt(trainarr[i]);
	}	

					   
 ���� trainlist�� ����
	// seoultrain �迭(int�� ��ȯ)�� List�� ��Ƽ� ��� �����ϴ� �޼ҵ�
	private void trainList()
	{
		List<String>trainList = new ArrayList<String>(Arrays.asList(newseoultrain));
		
		// ���� �ð��� �޾��� �� trainList���� �ش� ���� �ϳ��� ���� ���� 
		for (int i=0;i<trainList.length ;i++ )
		{
			if (timeleft <= 9)
			{
				traintList.remove(0);
			}
		}
		
		// �׽�Ʈ 
		newseoultrain = trainList.toArray(new String[0]);
		System.out.println("0��° �ε����� ��� ���� �� : " + Arrays.toString(seoultrain));
		 
		List ��� ��ü���
		for(String s : trainList)
		System.out.print(s + "");
	}

