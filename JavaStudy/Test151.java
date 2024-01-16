/*=============================================
  ■■■ 예외 처리(Exception Handling) ■■■
==============================================*/

// Test150.java 파일과 비교~~!! 

// ※ 중요 키워드 throw 

class Demo
{
	private int value;

	public void setValue(int value) throws Exception
	{
		if (value<=0)
		{
			//return;
			throw new Exception("value 0보다 작거나 같을 수 없습니다.");
			// Exception 객체 생성
			// -- 예외 발생~~!!! 
		}
		this.value = value; 
	}

	public int getValue()
	{
		return value;
	}
	
}
public class Test151
{
	public static void main(String[] args) //throws Exception
	{
		Demo ob = new Demo();
	
		try
		{
			ob.setValue(-3);
			int result = ob.getValue();
			System.out.println(result);

		}
		catch (Exception e)
		{
			System.out.println(e.toString());
		}

	}
}

//실행결과
/*

java.lang.Exception: value 0보다 작거나 같을 수 없습니다.
계속하려면 아무 키나 누르십시오 . . .

*/