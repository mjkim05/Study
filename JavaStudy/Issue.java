import java.util.*;
public class Issue
{

   Vector<String> vname = new Vector<String>();		// ī�� �̸� 
   Vector<String> vnum  = new Vector<String>();		// ī�� ��ȣ
   Vector<String> vtraffic  = new Vector<String>(); // �ĺ� ���� ����
   Vector<String> vpay      = new Vector<String>(); // �ؿܰ��� ����
   Vector<String> vcvc      = new Vector<String>(); // cvc

   User ob2 = new User();
   int a;

   public void Infor()
   {
      Scanner sc = new Scanner(System.in);
      System.out.print("1. �ű� �߱� 2. ��߱� (1�� 2�� �Է�): ");
      a = sc.nextInt();
      do
      {
         if (a==1)
         {
            // �ű�
            System.out.print("1.�ſ�ī�� 2. üũī��");
            a= sc.nextInt();
            // �������� �Է��ϴ� �Լ��� �̵� 
            Setting();
         }
      else if (a==2)
         {
            //��߱�
            System.out.print("������ �־��� ī���ȣ�� �Է��ϼ���");
         }

      }
         while (a!=1 && a!=2);
   }


   public void Setting()
   {   
      Scanner sc = new Scanner(System.in);
      
      // �����̸� �Է�
         System.out.println("�����̸��� �Է����ּ���");
         String name = sc.nextLine();
		 ob2.setUserName(name);
         vname.add(ob2.getUserName());
      
      // �ĺ� ���� �̿��Ұ��� �� ��
      do {
            System.out.println("�ĺ� �������� �̿��Ͻðڽ��ϱ�?(y/n): ");
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
               System.out.println("�߸��� �Է��Դϴ�. �ٽ� �Է����ּ���.");
            }
        } while (true);   
      
      		// �ؿܰ��� �̿��Ұ��� �� ��
			do {
				System.out.println("�ؿܰ����� �̿��Ͻðڽ��ϱ�?(y/n): ");
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
						System.out.println("�߸��� �Է��Դϴ�. �ٽ� �Է����ּ���.");
					}
        }  while (true);	
		      
   }

   public void CardNum()  // ī�� ��ȣ ���� 
   {
      Random rd =new Random();
      
      String cardNumber = "";

    for (int i = 1; i <= 16; i++) 
      {
       cardNumber += rd.nextInt(10);
        // 4�ڸ����� "-" �߰�
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
			System.out.println(">> ī�尡 ���������� �߱޵Ǿ����ϴ�.\n");
			System.out.println("��������������������������������������������������������������������������������������������������");
			System.out.println("���� SS�ֿ�ī�� �ſ�                   ��������������   ��  ");
			System.out.println("��                                     �� VISA��   ��  ");
			System.out.println("��                                     ��������������   ��  ");
			System.out.println("�� ����������������                                      ��  ");
			System.out.println("�� ���� ��   ��     ���������������������������������������������������������������� ��  ");
			System.out.println("�� ���Ѧ� ��  ��	                                ��  ");
			System.out.println("�� ����������������                                      ��  ");
			System.out.println("��                                               ��  ");
			System.out.printf("��   %14s    28/10                ��  \n" ,cardNum);
			System.out.printf("��   %12s          CVC %d%d%d               ��  \n", name, 1,2,3);
			System.out.println("��                                        [����] ��  ");
			System.out.println("��������������������������������������������������������������������������������������������������");
		}
		else 
		{
			System.out.println(">> ī�尡 ���������� �߱޵Ǿ����ϴ�.\n");
			System.out.println("��������������������������������������������������������������������������������������������������");
			System.out.println("���� SS�ֿ�ī�� üũ                   ��������������   ��  ");
			System.out.println("��                                     �� VISA��   ��  ");
			System.out.println("��                                     ��������������   ��  ");
			System.out.println("�� ����������������                                      ��  ");
			System.out.println("�� ���� ��   ��     ���������������������������������������������������������������� ��  ");
			System.out.println("�� ���Ѧ� ��  ��	                                ��  ");
			System.out.println("�� ����������������                                      ��  ");
			System.out.println("��                                               ��  ");
			System.out.printf("��   %14s    28/10                  ��  \n" ,cardNum);
			System.out.printf("��   %12s          CVC %d%d%d               ��  \n", name, 1,2,3);
			System.out.println("��                                        [����] ��  ");
			System.out.println("��������������������������������������������������������������������������������������������������");
		}
		
	}


   public static void main(String [] args)
   {
	 // User ob2 = new User();
      Issue ob = new Issue();
      ob.Infor();
	  ob.write();
	  
	  //System.out.println("ī���ȣ��: " + vnum + "�Դϴ�.");
	  //System.out.println("������� �̸��� :" + vname +  "�Դϴ�.");
	  
   }
   

}