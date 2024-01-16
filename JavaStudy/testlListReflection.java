import java.io.File;
import java.util.List;

public class testlListReflection
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
				
			System.out.println("passDate : " + passDate + ", reservDate : " + reservDate);
			
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
		testlListReflection tlr = new testlListReflection();
		
		
		String appDir = System.getProperty("user.dir");
		File seatListFile = new File(appDir, "seatArrayListSerialTest.ser");

		
		List<Seat> seatList = ssl.isExists(seatListFile, appDir);
		
		// 고객의 출발 날짜 선택 완료.
		so3.reserveDay(tlr.pass);
		
		ssl.addSeatList(seatList, 2, "202310122-P0934", "B3", 2023, 10, 12, 2);
		ssl.addSeatList(seatList, 2, "202310121-S0421", "A2", 2023, 10, 12, 1);
		ssl.addSeatList(seatList, 2, "202310123-A0139", "B3", 2023, 10, 12, 3);
		
		File seatListFile2 = ssl.writeList(seatList);
		
		ssl.seatList = ssl.readList(seatListFile2);
		
		for (Seat s : seatList)
		{
			System.out.println(s);
		}
	
		
		int selectTime = 2;
		
		tlr.pass.setDepartureTime(2);
		
		for (int i = 0; i < seatList.size(); i++)
		{
			int reservY = seatList.get(i).getDepartureYear();
			int reservM = seatList.get(i).getDepartureMonth();
			int reservD = seatList.get(i).getDepartureDate();
			int reservT = seatList.get(i).getDepartureTime();
			
			if (tlr.reservDateInforIsSame(tlr.pass, reservY, reservM, reservD, reservT))
			{
				System.out.println("\n========[현재 사용자가 선택하신 출발날짜, 출발 시간과 동일한 예약 정보를 갖는 Seat객체는 아래와 같습니다.]========");
				System.out.println(seatList.get(i));
				System.out.println("==========================================================================================");
			}
		}
			
		
	}
}