package LastSemiTest01;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class SeatListDeserialize
{
	
	Passenger pass = new Passenger();
	
	
	public boolean reservDateInforIsSame(Passenger pass, int reservY, int reservM, int reservD, int reservT)
	{
		boolean flag = false;
				
		int passY = pass.getDepartureYear();
		int passM = pass.getDepartureMonth();
		int passD = pass.getDepartureDate();
		int passT = pass.getDepartureTime();
				
		int passDate = Integer.parseInt(String.format("%d%d%d%d", passY, passM, passD, passT));
		int reservDate = Integer.parseInt(String.format("%d%d%d%d", reservY, reservM, reservD, reservT));
				
			//System.out.println("passDate : " + passDate + ", reservDate : " + reservDate);
			
			if (passDate == reservDate)
			{
				flag = true;
			}
				
		return flag;
	}

	
	public static void main(String[] args) throws Exception
	{
		SerialSeatList ssl = new SerialSeatList();
		SelectOption3 so3 = new SelectOption3();
		SeatListDeserialize tlr = new SeatListDeserialize();
		SelectSeatObject sso = new SelectSeatObject();
		
		
		String appDir = System.getProperty("user.dir");
		File seatListFile = new File(appDir, "seatArrayListSerialTest.ser");

		
		List<Seat> seatList = ssl.listIsExists(seatListFile, appDir);
		
		// 고객의 출발 날짜 선택 완료.
		so3.reserveDay(tlr.pass);
		
		// 임의의 좌석 예약 정보를 List 요소에 추가했다.
		ssl.addSeatList(seatList, 2, "202310122-W0313", "A3", 2023, 10, 13, 2);
		ssl.addSeatList(seatList, 2, "202310122-W0313", "B10", 2023, 10, 13, 2);
		ssl.addSeatList(seatList, 2, "202310121-A0376", "A2", 2023, 10, 13, 2);
		ssl.addSeatList(seatList, 2, "202310123-U08719", "C4", 2023, 10, 13, 2);
		
		// 리스트를 객체 직렬화로 내보낸다.
		File seatListFile2 = ssl.writeList(seatList);
		
		// 인스턴스 변수 seatList에 객체 역직렬화로 읽어들였던  
		ssl.seatList = ssl.readList(seatListFile2);
		
		int selectTime = 2;
		
		tlr.pass.setDepartureTime(2);
		
		// 1. 고객이 선택한 시간대에 맞게, 빈 좌석배열을 반환하는 메소드 호출
		Seat[] firstClassSeat = sso.selectTrainSeat(selectTime, 'A');
		Seat[] secondClassSeat = sso.selectTrainSeat(selectTime, 'B');
		Seat[] thirdClassSeat = sso.selectTrainSeat(selectTime, 'C');
		
		List<Seat> reservDaySeatList = new ArrayList<Seat>();
		
		for (int i = 0; i < seatList.size(); i++)
		{
			int reservY = seatList.get(i).getDepartureYear();
			int reservM = seatList.get(i).getDepartureMonth();
			int reservD = seatList.get(i).getDepartureDate();
			int reservT = seatList.get(i).getDepartureTime();
			
			// 출발 날짜가 같다면... 새로운 리스트에 추가한다.
			if (tlr.reservDateInforIsSame(tlr.pass, reservY, reservM, reservD, reservT))
			{
				reservDaySeatList.add(seatList.get(i));
			}
		}

		// 새로운 리스트에 추가한 좌석 객체들의 좌석 번호, 열차 출발 시간과 맞게 예약된 좌석 객체를 넣는다.
		
		
		// 1. 0~3까지는 A등급 좌석을 돌고...
		// 2. 4~19까지는 B등급 좌석을 돌고...
		// 3. 20~51까지는 C등급 좌석을 돈다...
		
		// 4. 좌석 번호가 같은지 확인하고, 예약된 좌석의 예약 정보를 대입한다.
		// 5. 이때, 좌석
		
		
		// 1. 좌석번호의 등급 확인
		// 2. 좌석 번호가 'A' 이면... 반복횟수 4, 반복 대상 firstClassSeat
		// 3. 좌석 번호가 'B' 이면... 반복횟수 16, 반복 대상 secondClassSeat
		// 4. 좌석 번호가 'C' 이면... 반복횟수 32, 반복 대상 thirdClassSeat
		
		
		
		for (int i = 0; i < reservDaySeatList.size(); i++)
		{
			char classAlpha = reservDaySeatList.get(i).getSeatNumber().charAt(0);
			Seat[] selectClassSeat = sso.returnCreateSeat('A');
			
			switch(classAlpha)
			{
				case 'A' : selectClassSeat = firstClassSeat; break;	// 얕은 복사
				case 'B' : selectClassSeat = secondClassSeat; break;	// 얕은 복사
				case 'C' : selectClassSeat = thirdClassSeat; break; // 얕은 복사
			
			}
			
			for (int j = 0; j < selectClassSeat.length; j++)
			{
				if (reservDaySeatList.get(i).getSeatNumber().equals(selectClassSeat[j].getSeatNumber()))
				{
					System.out.println("찾았다!");
					System.out.println("reservDaySeatList 의 좌석 번호 : " + reservDaySeatList.get(i).getSeatNumber());
					System.out.println("selectClassSeat 의 좌석 번호 : " + selectClassSeat[j].getSeatNumber());
					
					System.out.println("예약된 좌석의 소요 시간 : " + reservDaySeatList.get(i).getTimeTaken());
					System.out.println("선택한 좌석의 소요 시간 : " + selectClassSeat[j].getTimeTaken());
					selectClassSeat[j] = reservDaySeatList.get(i);
					
					// 비어있는 좌석의 j번쨰 객체가 소요시간이 0이 아닌 경우. (좌석에 이미 예약이 차있는 경우...)
					if (selectClassSeat[j].getTimeTaken() != 0)
					{
						selectClassSeat[j].setTimeTaken(-1);
					}
		
					
				}
			}
			
		}
		
		
		for (Seat s : firstClassSeat)
		{
			if (s.getTimeTaken() != 0)
			{
				System.out.println(s);
			}
		
		}
		for (Seat s : secondClassSeat)
		{
			if (s.getTimeTaken() != 0)
			{
				System.out.println(s);
			}
		}
		for (Seat s : secondClassSeat)
		{
			if (s.getTimeTaken() != 0)
			{
				System.out.println(s);
			}
		}
		

		
	}
}
