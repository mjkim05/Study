import java.util.Calendar;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.List;
import java.util.Vector;

public class Test_self2
{
	public static void main(String[] args)
	{
		Calendar ca = Calendar.getInstance();
		//DatePrinter.printDateTime(ca);
		
		
		int y = ca.get(Calendar.YEAR);
		int m = ca.get(Calendar.MONTH)+1;
		int d = ca.get(Calendar.DATE);
		/* �����
		int hour = ca.get(Calendar.HOUR_OF_DAY); 
		int min = ca.get(Calendar.MINUTE);
		int sec = ca.get(Calendar.SECOND);
		*/
		
		// �׽�Ʈ��
		ca.set(Calendar.HOUR_OF_DAY, 7);
		ca.set(Calendar.MINUTE, 59);
		ca.set(Calendar.SECOND, 0);
		//DatePrinter.printDateTime(ca);

		int hour = ca.get(Calendar.HOUR_OF_DAY);
		int min = ca.get(Calendar.MINUTE);
		int sec = ca.get(Calendar.SECOND);
		
		System.out.printf("���� ��¥ : %d�� %d�� %d��\n", y ,m, d);
		System.out.printf("���� �ð� : %d�� %d�� %d��\n", hour, min, sec);

		List<String> trainlist = new ArrayList<String>();

		trainlist.add("18�� ���");
		trainlist.add("14�� ���");
		trainlist.add("10�� ���");

		ListIterator<String> li = trainlist.listIterator();
		
		
		/*while (li.hasNext())
		{
			System.out.print(li.next() + " ");
		}
		System.out.println();
		*/
		
		// ��� �� 2�ð� �������� �߱ǰ���
		
		if (hour > 7)
		{
			trainlist.remove(2);			// 10�� ��� ���� ����
		}
		
		if (hour>=12)
		{
			trainlist.remove(1);			// 14�� ��� ���� ����
		}

	
		
		// ���� ���
		for (int i=trainlist.size()-1; i>=0; i-- )
		{	
			System.out.println(trainlist.get(i) + " ");
		}

		if (hour >= 16)
		{
			trainlist.remove(0);
			System.out.println("���� ���� ����");
		}
		

/*
			if (hour >= 7)
			{
				trainlist.remove(2);
			}
			
			else if(hour >= 11)
			{
				trainlist.remove(1);
			}

		if (hour>=16)
		{	
			trainlist.remove(0);
		}
		System.out.println("������ ������ ��� ���� �����Դϴ�.");
		System.out.println("���� �ٽ� �湮�� �ֽʽÿ�");
		*/
	
		

		/*
		for (int i=0;i<trainlist.size() ;i++ )
		{
			if (hour>0)
			trainlist.remove(0);
		}
		System.out.print(trainlist);
		*/
	

		/*
			if (hour>= 0 && hour<=2)
			{
				System.out.print("���� �ð� �Դϴ�");
			}
			if (hour>=8)
			{
				trainlist.remove(0);
			}
			else if (hour>=12)
			{
				trainlist.remove(1);
			}
			else if (hour>=16)
			{
				trainlist.remove(2);
			}
		
		System.out.print(trainlist);
		*/
		

		

/*
		for(int i=0;i<trainlist.size();i++)
		{
            String str = trainlist.get(i);
            if(hour >= 8) 
			trainlist.remove(i+1);
        }
		System.out.print(trainlist);
*/
		

	

		/*
		if (hour >= 18)
		{
			System.out.print("���� ������ ����Ǿ����ϴ�.");
		}
		*/


		
		

	}

}