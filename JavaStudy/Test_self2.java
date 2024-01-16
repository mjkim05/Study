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
		/* 제출용
		int hour = ca.get(Calendar.HOUR_OF_DAY); 
		int min = ca.get(Calendar.MINUTE);
		int sec = ca.get(Calendar.SECOND);
		*/
		
		// 테스트용
		ca.set(Calendar.HOUR_OF_DAY, 7);
		ca.set(Calendar.MINUTE, 59);
		ca.set(Calendar.SECOND, 0);
		//DatePrinter.printDateTime(ca);

		int hour = ca.get(Calendar.HOUR_OF_DAY);
		int min = ca.get(Calendar.MINUTE);
		int sec = ca.get(Calendar.SECOND);
		
		System.out.printf("오늘 날짜 : %d년 %d월 %d일\n", y ,m, d);
		System.out.printf("현재 시각 : %d시 %d분 %d초\n", hour, min, sec);

		List<String> trainlist = new ArrayList<String>();

		trainlist.add("18시 출발");
		trainlist.add("14시 출발");
		trainlist.add("10시 출발");

		ListIterator<String> li = trainlist.listIterator();
		
		
		/*while (li.hasNext())
		{
			System.out.print(li.next() + " ");
		}
		System.out.println();
		*/
		
		// 출발 전 2시간 전까지만 발권가능
		
		if (hour > 7)
		{
			trainlist.remove(2);			// 10시 출발 기차 삭제
		}
		
		if (hour>=12)
		{
			trainlist.remove(1);			// 14시 출발 기차 삭제
		}

	
		
		// 역순 출력
		for (int i=trainlist.size()-1; i>=0; i-- )
		{	
			System.out.println(trainlist.get(i) + " ");
		}

		if (hour >= 16)
		{
			trainlist.remove(0);
			System.out.println("열차 운행 종료");
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
		System.out.println("오늘의 열차가 모두 떠난 상태입니다.");
		System.out.println("내일 다시 방문해 주십시오");
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
				System.out.print("점검 시간 입니다");
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
			System.out.print("열차 운행이 종료되었습니다.");
		}
		*/


		
		

	}

}