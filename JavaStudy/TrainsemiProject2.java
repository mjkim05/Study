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
		//String[] Seoultrain = {"10시 기차" , "14시 기차" , "18시 기차"};
		int selectdaparturestaion; // 출발역 선택변수 (다슬언니랑 같음)
		int nowtime;		  // 현재시간 분으로 변환
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
		

		//---------------------- 서울역 출발 List 배열에 저장-------------------------------
		List<String> Seoultrainlist = new ArrayList<String>();
			
		Seoultrainlist.add("10시 출발");
		Seoultrainlist.add("14시 출발");
		Seoultrainlist.add("18시 출발");

		 /*
		 캘린더클래스의 hour, min을 분으로 바꿈 (nowtime = departureTime*60 + departureMin;)
		 남은 시간 = 현재시간  -   각 열차 출발시간 
					 09:51(589)     10:00(600)      = -12   : 불가
					 09:50(590)      	            = -10   : 가능
					 09:48(592)                     = -8    : 가능
		==>> 남은 시간이 -10 이하일때만 해당 열차 탑승가능
		*/
		
		// 10시 기차의 timeleft = nowtime - 600
		// 14시 기차의 timeleft = nowtime - 840
		// 16시 기차의 timeleft = nowtime - 1080

		// remove() 요소 삭제 완료 확인
		//10시 기차 삭제
		if (stimeleft1 > -10 )
		{
			Seoultrainlist.remove(0);
			System.out.printf("출발시간이 10분이상 남지 않은 열차는 선택할 수 없습니다.\n");
			System.out.printf("다음 열차를 선택하세요\n");
		}
		
		// 14시 기차 삭제
		if (stimeleft2 > -10)
		{
			Seoultrainlist.remove(0);
			System.out.printf("출발시간이 10분이상 남지 않은 열차는 선택할 수 없습니다.\n");
			System.out.printf("다음 열차를 선택하세요\n");
		}
		
			
		// 18시 기차 삭제
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

		


		//---------------------- 평양역 출발 List 배열에 저장-------------------------------
		
		List<String> Pytrainlist = new ArrayList<String>();
			
		Pytrainlist.add("11시 출발");
		Pytrainlist.add("15시 출발");
		Pytrainlist.add("19시 출발");

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

