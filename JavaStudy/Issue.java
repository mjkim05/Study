import java.util.*;
public class Issue
{

   Vector<String> vname = new Vector<String>();		// 카드 이름 
   Vector<String> vnum  = new Vector<String>();		// 카드 번호
   Vector<String> vtraffic  = new Vector<String>(); // 후불 교통 유무
   Vector<String> vpay      = new Vector<String>(); // 해외결제 유무
   Vector<String> vcvc      = new Vector<String>(); // cvc

   User ob2 = new User();
   int a;

   public void Infor()
   {
      Scanner sc = new Scanner(System.in);
      System.out.print("1. 신규 발급 2. 재발급 (1와 2만 입력): ");
      a = sc.nextInt();
      do
      {
         if (a==1)
         {
            // 신규
            System.out.print("1.신용카드 2. 체크카드");
            a= sc.nextInt();
            // 개인정보 입력하는 함수로 이동 
            Setting();
         }
      else if (a==2)
         {
            //재발급
            System.out.print("가지고 있었던 카드번호를 입력하세요");
         }

      }
         while (a!=1 && a!=2);
   }


   public void Setting()
   {   
      Scanner sc = new Scanner(System.in);
      
      // 영어이름 입력
         System.out.println("영어이름을 입력해주세요");
         String name = sc.nextLine();
		 ob2.setUserName(name);
         vname.add(ob2.getUserName());
      
      // 후불 교통 이용할건지 유 무
      do {
            System.out.println("후불 교통기능을 이용하시겠습니까?(y/n): ");
            String answer = sc.next();
            if (answer.equalsIgnoreCase("y")) 
            {
			   vtraffic.add(answer);
               CardNum();
                
               break;
            } 
         else if (answer.equalsIgnoreCase("n")) 
            {	
			 	vtraffic.add(answer);
				CardNum()

                break;
            } 
         else
            {
               System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
            }
        } while (true);   
      
      		// 해외결제 이용할건지 유 무
			do {
				System.out.println("해외결제를 이용하시겠습니까?(y/n): ");
				String answer2 = sc.next();
				if (answer2.equalsIgnoreCase("y")) 
					{
						vpay.add(answer2);
						CardNum();
					
						break;
					} 
				else if (answer2.equalsIgnoreCase("n")) 
					{
						vpay.add(answer2);
						CardNum();

						 break;
					} 
				else
					{
						System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
					}
        }  while (true);	
		      
   }

   public void CardNum()  // 카드 번호 생성 
   {
      Random rd =new Random();
      
      String cardNumber = "";

    for (int i = 1; i <= 16; i++) 
      {
       cardNumber += rd.nextInt(10);
        // 4자리마다 "-" 추가
        if (i % 4 == 0 && i != 16) 
         {
            cardNumber += "-";
         }
       }
	
		ob2.setCardNum(cardNumber);
		vnum.add(ob2.getCardNum()); 
	
		

   }

	public void write()
	{	
		for (String name : vname)
			
		for (String cardNum : vnum)	


		if (a==1)
		{
			System.out.println(">> 카드가 정상적으로 발급되었습니다.\n");
			System.out.println("┌───────────────────────────────────────────────┐");
			System.out.println("│◀ SS쌍용카드 신용                   ┌─────┐   │  ");
			System.out.println("│                                     │ VISA│   │  ");
			System.out.println("│                                     └─────┘   │  ");
			System.out.println("│ ┌──────┐                                      │  ");
			System.out.println("│ │┙ ━   │     ──────────────────────────────── │  ");
			System.out.println("│ │┭┼ ┐  │	                                │  ");
			System.out.println("│ └──────┘                                      │  ");
			System.out.println("│                                               │  ");
			System.out.printf("│   %14s    28/10                │  \n" ,cardNum);
			System.out.printf("│   %12s          CVC %d%d%d               │  \n", name, 1,2,3);
			System.out.println("│                                        [교통] │  ");
			System.out.println("└───────────────────────────────────────────────┘");
		}
		else 
		{
			System.out.println(">> 카드가 정상적으로 발급되었습니다.\n");
			System.out.println("┌───────────────────────────────────────────────┐");
			System.out.println("│◀ SS쌍용카드 체크                   ┌─────┐   │  ");
			System.out.println("│                                     │ VISA│   │  ");
			System.out.println("│                                     └─────┘   │  ");
			System.out.println("│ ┌──────┐                                      │  ");
			System.out.println("│ │┙ ━   │     ──────────────────────────────── │  ");
			System.out.println("│ │┭┼ ┐  │	                                │  ");
			System.out.println("│ └──────┘                                      │  ");
			System.out.println("│                                               │  ");
			System.out.printf("│   %14s    28/10                  │  \n" ,cardNum);
			System.out.printf("│   %12s          CVC %d%d%d               │  \n", name, 1,2,3);
			System.out.println("│                                        [교통] │  ");
			System.out.println("└───────────────────────────────────────────────┘");
		}
		
	}


   public static void main(String [] args)
   {
	 // User ob2 = new User();
      Issue ob = new Issue();
      ob.Infor();
	  ob.write();
	  
	  //System.out.println("카드번호는: " + vnum + "입니다.");
	  //System.out.println("사용자의 이름은 :" + vname +  "입니다.");
	  
   }
   

}