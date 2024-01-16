

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.Calendar;


public class SelectOption
{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	Passenger pass = new Passenger();
	Calendar cd = Calendar.getInstance();

	public void reserveDay() throws IOException		// �����(�����) �Է� �޼ҵ�
	{
		int y, m, d, t;

		System.out.println("�� �����Ͻ� ������ ��� ���� �����ϼ���.");
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
				System.out.println("������ ������ �ܿ��� ���Ű� �Ұ����մϴ�.");
			}
		}
		while (selectDay<1 || selectDay>7);


		Calendar select = Calendar.getInstance();
		select.add(Calendar.DATE, selectDay-1);
		y = select.get(Calendar.YEAR);
		m = select.get(Calendar.MONTH)+1;
		d = select.get(Calendar.DATE);
		t = select.get(Calendar.HOUR_OF_DAY);
		

		System.out.printf("������ ��¥ : %d/%02d/%02d\n", y, m, d);

		pass.setDepartureYear(y);						// ���� ������ ��¥ ����
		pass.setDepartureMonth(m);
		pass.setDepartureDate(d);

	}// �����(�����) �Է� ����

	public int reserveDepartureStation() throws IOException	// ��߿� �Է� �޼ҵ�
	{
		System.out.println();
		System.out.println();

		System.out.println("�� ��߿��� �����ϼ���.");
		System.out.println("[ 1. ���￪,	2. ��翪 ]");
		
		int selectDepartureStation = 0;
		do
		{
			selectDepartureStation = Integer.parseInt(br.readLine());
			if (selectDepartureStation<1 || selectDepartureStation>2)
			{
				System.out.println("������ �� �ܿ��� ������ �� �����ϴ�.");
			}
		}
		while (selectDepartureStation<1 || selectDepartureStation>2);

		switch (selectDepartureStation)										//��߿� ����
		{
		case 1 : pass.setDepartureStation("���￪"); break;
		case 2 : pass.setDepartureStation("��翪"); break;
		}

		return selectDepartureStation;
		

	}// ��߿��Է� ����




	public void reserveArrivalStation() throws IOException	// ������ �Է� �޼ҵ�
	{
		
		System.out.println();
		System.out.println();
		if (pass.getDepartureStation().equals("���￪"))							//-- ��߿��� �����̾��� ��� 
		{
			System.out.println("�� �������� �����ϼ���.");
			System.out.println("[ 1. ��翪,	2. ��ũ�ٿ� ]");
			
			int selectArrivalStation = 0;
			do
			{
				selectArrivalStation = Integer.parseInt(br.readLine());
				if (selectArrivalStation<1 || selectArrivalStation>2)
				{
					System.out.println("������ �� �ܿ��� ������ �� �����ϴ�.");
				}
			}
			while (selectArrivalStation<1 || selectArrivalStation>2);				// ������ ����

			switch (selectArrivalStation)
			{
			case 1 : pass.setArrivalStation("��翪"); break;							
			case 2 : pass.setArrivalStation("��ũ�ٿ�"); break;
			}

		}
		else														//-- ��߿��� ����̾��� ���
		{
			pass.setArrivalStation("��ũ�ٿ�");
			System.out.println("�� �������� ��ũ�ٿ��Դϴ�.");
		}


	}//������ �Է� ����

	public void reservePerson() throws IOException		// ���� �ο��� ����
	{
		System.out.println();							
		System.out.println();
		System.out.println("�� �ο����� �Է����ּ���. (1~10��) : ");
		int selectPerson =0;
		do
		{
			selectPerson = Integer.parseInt(br.readLine());
			if (selectPerson<1 || selectPerson>10)
			{
				System.out.println("�ο����� Ȯ�����ּ���.");
			}

		}
		while (selectPerson<1 || selectPerson>10);

		pass.setNumberOfPeople(selectPerson);								// �� �ο���/����/����� �ο��� ����


	}// ���� �ο��� ���� ���� 



	public void reserveOld() throws IOException // ����� �ο��� Ȯ��/���� �޼ҵ�
	{
		int old;
		int oldMember = 0;

		System.out.println();							
		System.out.println();
		System.out.println("�� ž�°� �� �� 70�� �̻� ����ڰ� �����ʴϱ�?");
		System.out.print("[1: �� , 2. �ƴϿ�] : ");
		do
		{		
			old = Integer.parseInt(br.readLine());
			if (old<1 || old>2)
				System.out.println("�亯�� ��Ȯ�� �Է����ּ���.");
		}
		while (old<1 || old>2);
		
		if (old==1)									//-- ����ڰ� ���� ���
		{	
			
			for (int i=0;i<pass.getNumberOfPeople() ;i++ )
			{	
				String str;
				System.out.println("\n�� ��ο�������� ���� ž�°��� �ֹε�Ϲ�ȣ�� �Է����ּ���.(xxxxxx-xxxxxxx)");
				skip:
				do
				{
					str = br.readLine();				
					if (str.equalsIgnoreCase("exit"))						//�����Է��� �� �� �־ �Է� ����� �� �ִ� �� �߰�
					{
						break;
					}
					if (str.length()!=14)
					{
						System.out.println("�Է� ����!");
						System.out.println("�Է��� ������ ���� ��� exit �� �Է����ּ���.");
						continue skip;
												
					}
				
				int realOld = pass.getDepartureYear() - (1900 +(Integer.parseInt(str.substring(0,2))));					//-- 70�� �̻����� Ȯ��

				if (realOld<70)
				{
					System.out.println("���̰� �� 70�� �̸��Դϴ�. Ȯ�� �� �ٽ� �Է����ּ���.");
					--i;
					continue;
				}//70�� �̸� Ȯ�� ���� 
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

					if (su == Integer.parseInt(str.substring(13)))						//�ֹι�ȣ ���� �Ϸ�
					{
						++oldMember;
						System.out.printf("Ȯ�εǾ����ϴ�. (��ο������ �ο� : %d)\n", oldMember);
						
						
					}
					else																// �ֹι�ȣ ���� ����
					{
						System.out.println("Ȯ�� �� �ٽ� �Է����ּ���.");
						--i;
					}

					
				}

				}
				while (str.length()!=14);											//�ֹι�ȣ �Է¹ޱ� ����

		
				if (pass.getNumberOfPeople()-1>i)							
				{
					System.out.println("\n �� �߰��Ͻ� �� 70�� ž�°��� �����ʴϱ�?");
					System.out.print("[1: �� , 2. �ƴϿ�] : ");
					int j=0;
					do
					{
						j = Integer.parseInt(br.readLine());
							if (j<1 || j>2)
								System.out.println("�亯�� ��Ȯ�� �Է����ּ���.");
					}
					while (j<1 || j>2);
					if (j==2 )
					{
						break;
					}

				}
			}// ����ڰ� ���� ����� for�� (�ִ� : ��ü�ο���)

			System.out.printf("\n��ο�� ������ ����Ǿ����ϴ�. (�Ϲ� ���� : %d, ��ο�� ���� : %d)", pass.getNumberOfPeople()-oldMember, oldMember);
		}//--����ڰ� ���� ����� if�� ����
		else										//-- ����ڰ� ���� ���
		{
			System.out.println("\n��� �ο��� �Ϲ� �������� Ȯ�εǾ����ϴ�.");
			System.out.println("��ο�� ������ ������� �ʽ��ϴ�.");

		}
		
		pass.setNumberOfAdults(pass.getNumberOfPeople()-oldMember);
		pass.setNumberOfOld(oldMember);

	} // ����� �Է� �� Ȯ��/���� ���� 

	public void reserveNumber() throws IOException // �¼� ��ȣ �Է¹ޱ� 
	{
		System.out.println();
		System.out.println();
		
		String[] numPeople = new String[pass.getNumberOfPeople()];

		for (int i=0 ; i<pass.getNumberOfPeople() ; i++)
		{
			System.out.printf("�� %d��° �¼� ��ȣ�� �Է��� �ֽʽÿ�.\n", i+1);
			System.out.print("�¼� ��ȣ : ");
			numPeople[i] = br.readLine();
			String temp = numPeople[i];

			String first = temp.substring(0,1);									//-- �¼� ��� ����
			int second = Integer.parseInt(temp.substring(1));					//-- �¼� ��ȣ ����

			if (!first.equalsIgnoreCase("A") && !first.equalsIgnoreCase("B") && !first.equalsIgnoreCase("C"))
			{
				System.out.println("�¼� ��ȣ�� Ȯ�����ֽʽÿ�.\n");
				--i;
				continue;
			}
			
			if (first.equals("A"))
			{
				if (second<1 || second>4)
				{
				System.out.println("�¼� ��ȣ�� Ȯ�����ֽʽÿ�.");
				--i;
				}
			}
			else if (first.equals("B"))
			{
				if (second<1 || second>16)
				{
				System.out.println("�¼� ��ȣ�� Ȯ�����ֽʽÿ�.");
				--i;
				}
			}
			else
			{
				if (second<1 || second>32)
				{
				System.out.println("�¼� ��ȣ�� Ȯ�����ֽʽÿ�.");
				--i;
				}
			}
			

		}	 
		
		pass.setSeatNumber(numPeople);														//-- �¼���ȣ ������ �迭�� seatNumber ���� (31��)

	}// �¼� ��ȣ �Է¹ޱ� ����

	public void reservationConfirm()
	{
		System.out.println();
		System.out.println();
		System.out.println("�� ���� ������ Ȯ���մϴ�.");
		System.out.printf("\t�� �����    : %d/%d/%d\n",pass.getDepartureYear(), pass.getDepartureMonth(), pass.getDepartureDate());
		System.out.printf("\t�� ��߿�    : %s\n",pass.getDepartureStation());
		System.out.printf("\t�� ��� �ð� : %s\n",pass.getDepartureTime());
		System.out.printf("\t�� ������    : %s\n",pass.getArrivalStation());
		System.out.printf("\t�� �ο� ��   : �� %d �� (�Ϲ� ���� : %d ��, ��ο�� : %d ��)\n", pass.getNumberOfPeople(), pass.getNumberOfAdults(), pass.getNumberOfOld());
		System.out.print("\t�� �¼� ��ȣ : ");
			for(String str : pass.getSeatNumber())
			{	
				System.out.print(str + " ");
			}	
		System.out.println();

		//String temp1 = pass.getSeatNumber[0];
		//System.out.println(temp1);
		//System.out.println(pass.getSeatNumber()[0]);

		//for (int i=0;i<pass.getNumberOfPeople() ; i++)
		//{																					// ** ������ �ּ�ó�� �ص�
		//	System.out.printf("Ȯ�� : %d��° %s", (i+1), pass.getSeatNumber()[i]);			// �¼���ȣ�� �迭 �� �ԷµǾ����� get���� Ȯ�� �غ� ��! 
		//}																					// get���� i��° �¼���ȣ �ҷ����� ���� ���� pass.getSeatNumber()[i]


	}









}

/* �ӽ�!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! ǥ�� ���� ����� ����
class Calculate
{
	int calA(String str)				// 1����¼�(A)�� ��� 
	{
		int coin=0;
		if (str.equals("����"))
		{
			if (pass.getDepartureStation().equals("���"))
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
		if (str.equals("����"))
		{
			if (pass.getDepartureStation().equals("���"))
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