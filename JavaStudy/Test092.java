/*========================
   ���� �迭 ����
  �� �迭�� �迭
  =======================*/

// �迭�� �迭(�������迭)�� Ȱ���Ͽ�
// ������ ���� �����͸� ��ҷ� ���ϴ� �迭 (5*5)�� �����ϰ�
// �� ����� ����ϴ� ���α׷��� �����Ѵ�.

// ���� ��)
/*
A B C D   E
F G H I J
K L M N O
P Q R S T
U V W X Y
//��� �Ϸ��� �ƹ�Ű�� ��������
*/


public class Test092
{   
   public static void main(String[] args)
   {
      // �迭�� �迭 ���� �� �޸� �Ҵ�
      char[][] arr = new char[5][5];
      char ch = 'A';
      
      // �迭�� �迭 ����
      for (int i=0; i<arr.length; i++)
      {
         for (int j=0; j<arr[i].length; j++)
         {
            arr[i][j] = ch;							//�迭[i][j]�� ch���� ��´�.
            ch++;									//ch���� ������Ų��.
         }
      }
      

      
      //�迭 ��ü��� ��� ���� 
      for (int i=0; i<arr.length; i++)
      {
         for (int j=0; j<arr[i].length; j++)
         {
            System.out.printf("%2c", arr[i][j]);
         }

         System.out.println();
      }
      

   }
}
//���� ���
/*
 A B C D E
 F G H I J
 K L M N O
 P Q R S T
 U V W X Y
����Ϸ��� �ƹ� Ű�� �����ʽÿ� . . .
*/