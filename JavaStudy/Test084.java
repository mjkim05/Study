/*========================
   ���� �迭 ����
   �� �迭�� ����� �ʱ�ȭ
   �� �迭�� �⺻�� Ȱ��
  =======================*/

// �� ���� 
//     ����ڷκ��� ������ �л� ���� �Է¹ް�
//     �׸�ŭ�� ����(��������)�� �Է¹޾� 
//    ��ü �л� ������ ��, ���, ������ ���ؼ�
//    ����� ����ϴ� ���α׷��� �����Ѵ�.

// ���� ��)
// �л� �� �Է� : 5
// 1�� �л��� ���� �Է� : 80
// 2�� �л��� ���� �Է� : 92
// 3�� �л��� ���� �Է� : 64
// 4�� �л��� ���� �Է� : 36
// 5�� �л��� ���� �Է� : 98

// >> ��   : 370
// >> ���   : 74.0
// >> ����  
// 90 : - 16.0
// 82 : - 8.0
// 64 : 10.0
// 36 : 38.0
// 98 : - 24.0
//����Ϸ��� �ƹ�Ű�� ��������...

import java.util.Scanner;
import java.io.IOException;


public class Test084
{
   public static void main(String[] args) throws IOException
   {

      // Scanner �ν��Ͻ� ����
      Scanner sc = new Scanner(System.in);


      // �ֿ� ���� ���� 
      int studentCount;                     // �л����� ��
      int tot=0;
      double avg=0;                        // �л����� ���

      //����ڷκ��� �л� �� �Է� �ޱ�
      System.out.print("�л� �� �Է� :");
      studentCount = sc.nextInt();

      //�ڷ����� int�� �л� ���� �迭 ����
      int[] arr1 = new int[studentCount];

      //�л��� ���� �Է� �ޱ�
      for (int i=0; i<arr1.length; i++)
      {
         System.out.printf("%d�� �л��� ���� �Է� : ", (i+1));
         arr1[i] = sc.nextInt();

       //�׽�Ʈ(Ȯ��)
       //System.out.println("�л��� ���� ��� : " + arr[i]);       //���������� ��� �Ǵ� ���� Ȯ��   
       }

      // �л����� ���� ��, ��� ���ϱ�
      
      // ���� ������ ����
       for (int i=0; i<arr1.length; i++)
       {
          tot +=arr1[i];
       } 

       // ��� ����
         
       avg = tot / studentCount;

       //�׽�Ʈ(Ȯ��)
       //System.out.printf("���� : %d, ��� : %.2f\n", tot, avg);      //���������� ��� �Ǵ� ���� Ȯ��
         
      
      // �ڷ����� double�� ���� �迭 ����
      double[] arr2 = new double[arr1.length];

      // ���� ���ϱ�
      for (int i=0; i<arr1.length; i++)
      {
         arr2[i] = avg - arr1[i]; 
      }

      // ���� ���
      System.out.println();                  // ����
      System.out.println(" >> �� : " + tot);
      System.out.printf(" >> ��� : %.2f \n" , avg );
      System.out.println(" >> ����  ");
      for (int i=0; i<arr2.length; i++)
      {
         System.out.println(arr1[i]+ " : " +arr2[i]);
      }
      




      
   }
}

//���� ���
/*

�л� �� �Է� :4
1�� �л��� ���� �Է� : 90
2�� �л��� ���� �Է� : 55
3�� �л��� ���� �Է� : 66
4�� �л��� ���� �Է� : 89

 >> �� : 300
 >> ��� : 75.00
 >> ����
90 : -15.0
55 : 20.0
66 : 9.0
89 : -14.0
����Ϸ��� �ƹ� Ű�� �����ʽÿ� . . .
*/