import java.util.*;

class User
{
   private  String userName;						// �̸�
   private  String telNum;						// ��ȭ��ȣ
   private  String idNum;							// �ֹι�ȣ
   private  String cardNum;						// ī�� ��ȣ

   
   User(String userName,String telNum,String idNum,String cardNum)
   {
      this.userName=userName;
      this.telNum=telNum;
      this.idNum=idNum;
      this.cardNum=cardNum;
   }

   User()
   {
      //������ ���ο��� �Ǵٸ� ������ ȣ��
      this("","","","");
   }

   public String getUserName()
   {
      return this.userName;
   }
   public void setUserName(String userName)
   {
      this.userName =userName;
   }

   public String getTelNum()
   {
      return this.telNum;
   }
   public void setTelNum(String telNum)
   {
      this.telNum=telNum;
   }
   
   public String getIdNum()
   {
      return this.idNum;
   }
   public void setIdNum(String idNum)
   {
      this.idNum=idNum;
   }
   
   public String getCardNum()
   {
      return this.cardNum;
   }
   public void setCardNum(String cardNum)
   {
      this.cardNum=cardNum;
   }
   
}

   
public class All
{
   public static void main(String [] args)
   {
      Scanner sc = new Scanner(System.in);
      Vector<User> vt = new Vector<User>();      

   }
}