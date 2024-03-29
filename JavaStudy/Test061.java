/*==========================================
  ■■■ 실행 흐름의 컨트롤 (제어문) ■■■
  - 반복문(for문) 실습 및 관찰 
  ==========================================*/

// ○ 다중 for문(반복문의 중첩)을 활용한 별찍기 실습

// ○ 과제 
//     다음과 같은 내용이 출력 될 수 있도록
//     반복문의 중첩 구문을 작성하여 프로그램을 구현한다.

//실행 예)
/*
    *
   ***
  *****
 *******
*********

*/

public class Test061
{
   public static void main(String[] args)
   {

      //주요 변수 선언 

      int i, j, k=1;      
      
      // 연산 및 출력 
      for (i=1; i<=5; i++)              
      {
         for (j=6; j>k; j-- )				//공백이 점점 줄어들게 하는 반복문
         {
            System.out.print(" ");         
         }

         for (j=1; j<=k; j++)            
         {
            System.out.print("*");          // 화면의 별을 출력 하기 위한 출력문

         }

         for (j=2; j<=k; j++)
         {
            System.out.print("*");          // 별 모양이 삼각형이 되도록 하는 출력문
         }

         k++;								// 별이 하나씩 늘어날 수 있게 한다. 
         System.out.println();				// 개행
      } 
   
   }
}

//실행 결과
/*


     *
    ***
   *****
  *******
 *********
계속하려면 아무 키나 누르십시오 . . .


*/