/*=============================================
  ■■■ 예외 처리(Exception Handling) ■■■
==============================================*/

/*
○ 프로그램에서 발생하는 오류(Error)는
  
   ① 잘못된 문법을 사용하거나 변수 등을 정의하지 않은 상태에서 
      사용함으로써 컴파일 단계에서 발생하는 문법적 오류(Error)와 

   ② 프로그램을 실행하는 과정에서 발생되는 런타임 오류(Error)로
      나눌 수 있다. 

	  - 개발자가 문제 분석을 잘못하거나 실수에 의해
	    엉뚱한 결과를 가져오게 되는 논리적인 오류(Error)와

	  - 시스템 이상에서 발견 되는 시스템 오류(Error), 그리고

	  - 프로그램 실행중 발생 되는 비정상적인 상황을 의미하는 
	    예의사항(Exception)이 있다. 

	    예를 들어 
		→ 어떤 수를 0으로 나누거나
		→ 베열을 제어하는 과정에서 첨자를 벗어나는 상황이 발생하거나...
		→ 존재하지 않는 파일을 오픈하여 읽어들인다거나...

	==> 개발자가 이런 예외 사항이 발생할 경우를 미리 예측하여 
	    적절히 대응하기 위한 절차를 구현하도록 문법을 정리해 놓은 것.
		에.외.처.리

※ 정리 해놓은 문법 ~~~!! (Exception 클래스)

   - 예외는 프로그램 실행중에 발생할 수 있는 
     명령어의 정상적인 흐름을 방해하는 이벤트로 
  ★ 자바에서 예외는 하나의 오브젝트(Object, 객체)이다. ★		//Object 상속 받음

   - 프로그램 실행 중에 메소드 안에서 오류(Error)가 발생하게 될 경우,
     메소드는 그 오류에 해당하는
	
   - 자바에서의 모든 예외 클래스는 Throwable 클래스나 
     Throwable 클래스의 하위 클래스를 상속받아 사용한다.

   - Throwable 클래스는 예외를 설명하는 문장이나 
     예외가 발생할 때의 프로그램 상태에 관한 정보를 포함하고 있다. 

  · Exception 클래스
	 Exception 예외 클래스는 일반적으로 프로그래머에 의해
	 복원될 수 없는 예외 사항으로 
	 메소드가 실행중에 던지는 예외를 가리킨다. 

  ˚ Error 클래스 
	 심각한 예외의 형태로 개발자가 복원 할 수 없는 형태의 예외이다.

※ 예외의 종류 

   - checked exception 
     메소드 내에서 예외가 발생한 경우 
	 메소드를 정의할 때 throws 문에 메소드 내에서 발생 할 수 잇는 
	 예외들을 명시해주거나 또는 그 예외를 『try ~cetch』 해서 
	 처리해 주어야만 하는 예외이다.
	 컴파일러가 컴파일 하는 과정에서 『checked exception 』 이 
	 『throws』 되는 가의 여부 혹은 『try ~ cetch』 되는지의 여부를 판단하여
	 프로그램에서 예외를 어떤 방식으로든 처리하지 않으면 
	 컴파일 자체가 불가능 하다.

   - unchecked exception 
     사전에 처리하지 않아도 컴파일러가 체크하지 않는 
	 런타임 시에 발생 할 수 잇는 예외이다.


○ java.lang.Throwable 클래스의 주요 메소드

  - String toString() // 오버라이딩 함
    : Throwable 각각에 대한 설명을 문자열 형태로 반환한다.
  - void printStackTrace(PrintStream s)
  - void printStackTrace(PringWriter w)
	: 표준 출력 스트림에 스택 호출 목록을 마지막 메소드부터 출력한다.

○ 주요 런타임 예외 메소드
  
   - ArithmeticException
     : 수치 계산상 오류(0으로 나누기 등)
   - ArrayStoreException
     : 배열에 잘못된 데이터 형을 저장하려 했을 경우 발생하는 오류
   - IndexOutOfBoundsException
     : 배열, 문자열 벡터 등에서 인덱스(첨자) 범위가 벗어난 경우 발생하는 오류
   - ClassCastException
     : 클래스 변환을 잘못한 경우 발생하는 오류
   - NullPointException
     : 빈 객체를 참조하는 경우(초기화되지 않은 변수 사용 등)
	   발생하는 오류
   - SecurityException
     : 자바의 내부 보안 사항을 위반하였을 경우 발생하는 오류
							
							:

*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Test147
{										   // ① 첫 번째 예외처리 방법
	public static void main(String[] args) // throws IOException
	{
		//BufferedReader 클래스 인스턴스 생성
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		//주요 변수 선언
		int a, b, c;

		// ② 두 번째 예외처리 방법
		/*
		try
		{
			System.out.print("첫 번째 정수 입력 : ");
			a = Integer.parseInt(br.readLine());
			System.out.print("두 번째 정수 입력 : ");
			b = Integer.parseInt(br.readLine());

			c = a + b;

			System.out.println("결과 : " + c);

		}
		catch (IOException e)		// 이러한 상황이 발생되면~ 
		{
			// IOException → checkedException 
			// -- 메소드를 정의하는 과정에서 throws 한 예외,
			//    잡아내거나 던지지 않을 경우 컴파일 에러 발생
			System.out.println(e.toString());	// 이러한 처리를 해라~
		}
		*/
		// ③ 세 번째 예외처리 방법
		/*
		try
		{
			System.out.print("첫 번째 정수 입력 : ");
			a = Integer.parseInt(br.readLine());
			System.out.print("두 번째 정수 입력 : ");
			b = Integer.parseInt(br.readLine());

			c = a + b;

			System.out.println("결과 : " + c);

		}
		catch (IOException e)		// 이러한 상황이 발생되면~ 
		{
			// IOException → checkedException 
			// -- 메소드를 정의하는 과정에서 throws 한 예외,
			//    잡아내거나 던지지 않을 경우 컴파일 에러 발생
			System.out.println(e.toString());	// 이러한 처리를 해라~
		}
		catch (NumberFormatException e)
		{	
			// NumberFormatException → unchecked exception
			// -- 런타임시 발생 할 수 있는 예외로
			//    반드시 던질 필요도, 잡아낼 필요도 없다.
			//    → 별도 처리가 없더라도... 컴파일 과정에서 문제 삼지 않음.
			System.out.println(e.toString());
			System.out.println(">> 숫자 형태의 데이터를 입력해야 합니다~!! ");
		}
		// 첫 번째 정수 입력 : abc
		// java.lang.NumberFormatException: For input string: "abc"
		// >> 숫자 형태의 데이터를 입력해야 합니다~!!
		*/


		// ④ 네 번째 예외 처리 방법
		/*
		try
		{
			System.out.print("첫 번째 정수 입력 : ");
			a = Integer.parseInt(br.readLine());
			System.out.print("두 번째 정수 입력 : ");
			b = Integer.parseInt(br.readLine());

			c = a + b;

			System.out.println("결과 : " + c);

		}
		catch (Exception e)	
		{
			System.out.println("e.toString() : " + e.toString());
			System.out.println("e.getMessage(): "+ e.getMessage());
			System.out.println("printStackTrace..................");
			e.printStackTrace();
			
		}
		*/
		// 
		try
		{
			System.out.print("첫 번째 정수 입력 : ");
			a = Integer.parseInt(br.readLine());
			System.out.print("두 번째 정수 입력 : ");
			b = Integer.parseInt(br.readLine());

			c = a + b;

			System.out.println("결과 : " + c);

		}
		catch (Exception e)	
		{
			System.out.println("e.toString() : " + e.toString());
			System.out.println("e.getMessage(): "+ e.getMessage());
			System.out.println("printStackTrace..................");
			e.printStackTrace();
			
		}
		finally
		{
			// 예외가 발생하거나 발생하지 않고나 언제나 실행되는 영역
			System.out.println("고생 많으셨습니다~ 감사합니다~!!");
		}
		
	
		
	}
}