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

	int selectdaparturestaion // 출발역 선택변수 

	String[] Seoultrain = {"10시 기차" , "14시 기차" , "18시 기차"};
	//String[] Seoultrain = {"10시 기차" , "14시 기차" ,};
	//String[] Seoultrain = {"10시 기차"};



	//String[] Pytrain = {"11시 기차" , "15시 기차" , "19시 기차"};


	
			public int nowtime		  // 현재시간 분으로 변환
			int timeleft;
			Calendar ca = Calendar.getInstance();

			departureTime = ca.get(Calendar.HOUR_OF_DAY);
			departureMin = ca.get(Calendar.MINUTE);

			nowtime = departureTime*60 + departureMin;
			
			/*
			if(newtrain[0] <= 9)
			System.out.printf("%s는 선택할 수 없습니다." , train[0]);
			remove.train[0];
			System.out.print("14시 열차, 18시 열차 선택가능");

			if(newtrain[1] <= 9)
			System.out.printf("%s는 선택할 수 없습니다." , train[1]);
			remove.train[1];
			System.out.print("18시 열차 선택가능");

			if(newtrain[2] <= 9)
			System.out.printf("%s는 선택할 수 없습니다." , train[2]);
			remove.train[2];
			System.out.print("금일 평양역 행 열차 끝. 내일 열차 예약하세요");
			*/
		public static void main(String[] args)		

	}
}

		// 서울역 출발 List 배열에 저장
		
		private void Seoul()
		{
			List<String> Seoultrainlist = new ArrayList<String>();

			Seoultrainlist.add("18시 출발");
			Seoultrainlist.add("14시 출발");
			Seoultrainlist.add("10시 출발");

			ListIterator<String> li = Seoultrainlist.listIterator();
			
			
			while (li.hasNext())
			{
				System.out.print(li.next() + " ");
			}
			System.out.println();
			
			
			// 출발 10분전까지만 발권가능
			for (int i=0; i<Seoultrainlist; i++ )
			{
				if (timeleft > 0 )
				Seoultrainlist.remove(0);
				
			}
			


			// 역순 출력
			for (int i=Seoultrainlist.size()-1; i>=0; i-- )
			{
				System.out.println(Seoultrainlist.get(i) + " ");
			}
		}
		
	
		// 평양역 출발 List 배열에 저장
		/*
		private void Py()
		{
			List<String> PytrainList = new ArrayList<String>();
			
			Pytrainlist.add("19시 출발");
			Pytrainlist.add("15시 출발");
			Pytrainlist.add("11시 출발");

			ListIterator<String> li = Pytrainlist.listIterator();

			// 출발 10분전까지만 발권가능	
			if (timeleft <= )
			{
				Pytrainlist.remove(0);
			}	
			// 역순 출력
			for (int i=Pytrainlist.size()-1; i>=0; i-- )
			{
				System.out.println(Ptrainlist.get(i) + " ");
			}

		 }*/





/*-------------------------------------------------------------------------------------------------------------------------
		timeleft = (기차 출발 시간 10시/ 14시/ 18시) - nowtime; 			
			    → String으로 받은 기차출발시간을 parseInt로 받아야한다.  // → 1 / 2 선택인데?
				String[] train = {"10시 기차" , "14시 기차" , "18시 기차"};

					int[] newtrain = new int[train.length];
        				for (int i = 0; i < train.length; i++) {
            				newtrain[i] = Integer.parseInt(trainarr[i]);
	}	

					   
 위의 trainlist에 저장
	// seoultrain 배열(int로 변환)을 List에 담아서 요소 삭제하는 메소드
	private void trainList()
	{
		List<String>trainList = new ArrayList<String>(Arrays.asList(newseoultrain));
		
		// 현재 시간을 받았을 때 trainList에서 해당 열차 하나씩 제거 ①②③ 
		for (int i=0;i<trainList.length ;i++ )
		{
			if (timeleft <= 9)
			{
				traintList.remove(0);
			}
		}
		
		// 테스트 
		newseoultrain = trainList.toArray(new String[0]);
		System.out.println("0번째 인덱스의 요소 삭제 후 : " + Arrays.toString(seoultrain));
		 
		List 요소 전체출력
		for(String s : trainList)
		System.out.print(s + "");
	}

