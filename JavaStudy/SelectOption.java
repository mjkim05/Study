

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.Calendar;


public class SelectOption
{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	Passenger pass = new Passenger();
	Calendar cd = Calendar.getInstance();

	public void reserveDay() throws IOException		// 출발일(년월일) 입력 메소드
	{
		int y, m, d, t;

		System.out.println("▶ 예매하실 열차의 출발 일을 선택하세요.");
		System.out.print("[ ");
		for (int i=0;i<7; i++)
		{	
			System.out.printf("%d:%d/%02d/%02d", i+1, cd.get(cd.YEAR), cd.get(cd.MONTH)+1, cd.get(cd.DATE));
			cd.add(Calendar.DATE, 1);
			if (i!=6)
			{
				System.out.print(", ");
			}
		}
		System.out.println(" ]");

		int selectDay=0;
		do
		{
			selectDay = Integer.parseInt(br.readLine());
			if (selectDay<1 || selectDay>7)
			{
				System.out.println("정해진 예매일 외에는 예매가 불가능합니다.");
			}
		}
		while (selectDay<1 || selectDay>7);


		Calendar select = Calendar.getInstance();
		select.add(Calendar.DATE, selectDay-1);
		y = select.get(Calendar.YEAR);
		m = select.get(Calendar.MONTH)+1;
		d = select.get(Calendar.DATE);
		t = select.get(Calendar.HOUR_OF_DAY);
		

		System.out.printf("선택한 날짜 : %d/%02d/%02d\n", y, m, d);

		pass.setDepartureYear(y);						// 고객이 선택한 날짜 저장
		pass.setDepartureMonth(m);
		pass.setDepartureDate(d);

	}// 출발일(년월일) 입력 종료

	public int reserveDepartureStation() throws IOException	// 출발역 입력 메소드
	{
		System.out.println();
		System.out.println();

		System.out.println("▶ 출발역을 선택하세요.");
		System.out.println("[ 1. 서울역,	2. 평양역 ]");
		
		int selectDepartureStation = 0;
		do
		{
			selectDepartureStation = Integer.parseInt(br.readLine());
			if (selectDepartureStation<1 || selectDepartureStation>2)
			{
				System.out.println("정해진 역 외에는 선택할 수 없습니다.");
			}
		}
		while (selectDepartureStation<1 || selectDepartureStation>2);

		switch (selectDepartureStation)										//출발역 저장
		{
		case 1 : pass.setDepartureStation("서울역"); break;
		case 2 : pass.setDepartureStation("평양역"); break;
		}

		return selectDepartureStation;
		

	}// 출발역입력 종료




	public void reserveArrivalStation() throws IOException	// 도착역 입력 메소드
	{
		
		System.out.println();
		System.out.println();
		if (pass.getDepartureStation().equals("서울역"))							//-- 출발역이 서울이었을 경우 
		{
			System.out.println("▶ 도착역을 선택하세요.");
			System.out.println("[ 1. 평양역,	2. 모스크바역 ]");
			
			int selectArrivalStation = 0;
			do
			{
				selectArrivalStation = Integer.parseInt(br.readLine());
				if (selectArrivalStation<1 || selectArrivalStation>2)
				{
					System.out.println("정해진 역 외에는 선택할 수 없습니다.");
				}
			}
			while (selectArrivalStation<1 || selectArrivalStation>2);				// 도착역 저장

			switch (selectArrivalStation)
			{
			case 1 : pass.setArrivalStation("평양역"); break;							
			case 2 : pass.setArrivalStation("모스크바역"); break;
			}

		}
		else														//-- 출발역이 평양이었을 경우
		{
			pass.setArrivalStation("모스크바역");
			System.out.println("▶ 도착역은 모스크바역입니다.");
		}


	}//도착역 입력 종료

	public void reservePerson() throws IOException		// 예매 인원수 지정
	{
		System.out.println();							
		System.out.println();
		System.out.println("▶ 인원수를 입력해주세요. (1~10명) : ");
		int selectPerson =0;
		do
		{
			selectPerson = Integer.parseInt(br.readLine());
			if (selectPerson<1 || selectPerson>10)
			{
				System.out.println("인원수를 확인해주세요.");
			}

		}
		while (selectPerson<1 || selectPerson>10);

		pass.setNumberOfPeople(selectPerson);								// 총 인원수/성인/고령자 인원수 저장


	}// 예매 인원수 지정 종료 



	public void reserveOld() throws IOException // 고령자 인원수 확인/검증 메소드
	{
		int old;
		int oldMember = 0;

		System.out.println();							
		System.out.println();
		System.out.println("▶ 탑승객 중 만 70세 이상 고령자가 있으십니까?");
		System.out.print("[1: 예 , 2. 아니오] : ");
		do
		{		
			old = Integer.parseInt(br.readLine());
			if (old<1 || old>2)
				System.out.println("답변을 정확히 입력해주세요.");
		}
		while (old<1 || old>2);
		
		if (old==1)									//-- 고령자가 있을 경우
		{	
			
			for (int i=0;i<pass.getNumberOfPeople() ;i++ )
			{	
				String str;
				System.out.println("\n▶ 경로우대할인을 받을 탑승객의 주민등록번호를 입력해주세요.(xxxxxx-xxxxxxx)");
				skip:
				do
				{
					str = br.readLine();				
					if (str.equalsIgnoreCase("exit"))						//무한입력이 될 수 있어서 입력 취소할 수 있는 값 추가
					{
						break;
					}
					if (str.length()!=14)
					{
						System.out.println("입력 오류!");
						System.out.println("입력을 원하지 않을 경우 exit 를 입력해주세요.");
						continue skip;
												
					}
				
				int realOld = pass.getDepartureYear() - (1900 +(Integer.parseInt(str.substring(0,2))));					//-- 70세 이상인지 확인

				if (realOld<70)
				{
					System.out.println("나이가 만 70세 미만입니다. 확인 후 다시 입력해주세요.");
					--i;
					continue;
				}//70세 미만 확인 종료 
				else
				{
					int[] chk = {2,3,4,5,6,7,0,8,9,2,3,4,5};					
					int chkTot=0;
					for (int a=0;a<13;a++ )
					{
						if (a==6)
						{
							continue;
						}
						chkTot += chk[a] * Integer.parseInt(str.substring(a,(a+1)));
					}

					int su = 11 - chkTot%11;
					su = su%10;

					if (su == Integer.parseInt(str.substring(13)))						//주민번호 인증 완료
					{
						++oldMember;
						System.out.printf("확인되었습니다. (경로우대할인 인원 : %d)\n", oldMember);
						
						
					}
					else																// 주민번호 인증 오류
					{
						System.out.println("확인 후 다시 입력해주세요.");
						--i;
					}

					
				}

				}
				while (str.length()!=14);											//주민번호 입력받기 종료

		
				if (pass.getNumberOfPeople()-1>i)							
				{
					System.out.println("\n ▶ 추가하실 만 70세 탑승객이 있으십니까?");
					System.out.print("[1: 예 , 2. 아니오] : ");
					int j=0;
					do
					{
						j = Integer.parseInt(br.readLine());
							if (j<1 || j>2)
								System.out.println("답변을 정확히 입력해주세요.");
					}
					while (j<1 || j>2);
					if (j==2 )
					{
						break;
					}

				}
			}// 고령자가 있을 경우의 for문 (최대 : 전체인원수)

			System.out.printf("\n경로우대 할인이 적용되었습니다. (일반 성인 : %d, 경로우대 할인 : %d)", pass.getNumberOfPeople()-oldMember, oldMember);
		}//--고령자가 있을 경우의 if문 종료
		else										//-- 고령자가 없을 경우
		{
			System.out.println("\n모든 인원이 일반 성인으로 확인되었습니다.");
			System.out.println("경로우대 할인이 적용되지 않습니다.");

		}
		
		pass.setNumberOfAdults(pass.getNumberOfPeople()-oldMember);
		pass.setNumberOfOld(oldMember);

	} // 고령자 입력 및 확인/검증 종료 

	public void reserveNumber() throws IOException // 좌석 번호 입력받기 
	{
		System.out.println();
		System.out.println();
		
		String[] numPeople = new String[pass.getNumberOfPeople()];

		for (int i=0 ; i<pass.getNumberOfPeople() ; i++)
		{
			System.out.printf("▶ %d번째 좌석 번호를 입력해 주십시오.\n", i+1);
			System.out.print("좌석 번호 : ");
			numPeople[i] = br.readLine();
			String temp = numPeople[i];

			String first = temp.substring(0,1);									//-- 좌석 등급 추출
			int second = Integer.parseInt(temp.substring(1));					//-- 좌석 번호 추출

			if (!first.equalsIgnoreCase("A") && !first.equalsIgnoreCase("B") && !first.equalsIgnoreCase("C"))
			{
				System.out.println("좌석 번호를 확인해주십시오.\n");
				--i;
				continue;
			}
			
			if (first.equals("A"))
			{
				if (second<1 || second>4)
				{
				System.out.println("좌석 번호를 확인해주십시오.");
				--i;
				}
			}
			else if (first.equals("B"))
			{
				if (second<1 || second>16)
				{
				System.out.println("좌석 번호를 확인해주십시오.");
				--i;
				}
			}
			else
			{
				if (second<1 || second>32)
				{
				System.out.println("좌석 번호를 확인해주십시오.");
				--i;
				}
			}
			

		}	 
		
		pass.setSeatNumber(numPeople);														//-- 좌석번호 저장한 배열을 seatNumber 저장 (31행)

	}// 좌석 번호 입력받기 종료

	public void reservationConfirm()
	{
		System.out.println();
		System.out.println();
		System.out.println("▶ 예매 정보를 확인합니다.");
		System.out.printf("\t· 출발일    : %d/%d/%d\n",pass.getDepartureYear(), pass.getDepartureMonth(), pass.getDepartureDate());
		System.out.printf("\t· 출발역    : %s\n",pass.getDepartureStation());
		System.out.printf("\t· 출발 시간 : %s\n",pass.getDepartureTime());
		System.out.printf("\t· 도착역    : %s\n",pass.getArrivalStation());
		System.out.printf("\t· 인원 수   : 총 %d 명 (일반 성인 : %d 명, 경로우대 : %d 명)\n", pass.getNumberOfPeople(), pass.getNumberOfAdults(), pass.getNumberOfOld());
		System.out.print("\t· 좌석 번호 : ");
			for(String str : pass.getSeatNumber())
			{	
				System.out.print(str + " ");
			}	
		System.out.println();

		//String temp1 = pass.getSeatNumber[0];
		//System.out.println(temp1);
		//System.out.println(pass.getSeatNumber()[0]);

		//for (int i=0;i<pass.getNumberOfPeople() ; i++)
		//{																					// ** 참고삼아 주석처리 해둠
		//	System.out.printf("확인 : %d번째 %s", (i+1), pass.getSeatNumber()[i]);			// 좌석번호의 배열 잘 입력되었는지 get으로 확인 해본 것! 
		//}																					// get으로 i번째 좌석번호 불러오고 싶을 때는 pass.getSeatNumber()[i]


	}









}

/* 임시!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! 표값 계산식 만들던 흔적
class Calculate
{
	int calA(String str)				// 1등급좌석(A)일 경우 
	{
		int coin=0;
		if (str.equals("서울"))
		{
			if (pass.getDepartureStation().equals("평양"))
			{ 
				int n=1;
			}
			else 
			{
				int n=2;
			}

			switch (n)
			{
			case 1 : coin += 800,000;
			case 2 : coin += 1,500,000;
			
			}
		}

		return coin;
	}

	int calB(String str)
	{
		int coin=0;
		if (str.equals("서울"))
		{
			if (pass.getDepartureStation().equals("평양"))
			{ 
				int n=1;
			}
			else 
			{
				int n=2;
			}

			switch (n)
			{
			case 1 : coin += 800,000;
			case 2 : coin += 1,500,000;
			
			}
		}

		return coin;
	}
}
*/
class SelectOption2
{
	public static void main(String[] args) throws IOException
	{
		SelectOption sel = new SelectOption();
		sel.reserveDay();
		sel.reserveDepartureStation();
		sel.reserveArrivalStation();
		sel.reservePerson();
		sel.reserveOld();
		sel.reserveNumber();
		sel.reservationConfirm();
		

 
	}
}