/*=============================================
  ■■■ 예외 처리(Exception Handling) ■■■
==============================================*/

// 예외 다시 던지기
// 생기는 예외들을 제어하고 사후처리하기 위해서 예외처리가 필요하다.

public class Test152
{
	public static void main(String[] args) 
	{
		Test152 ob = new Test152();

		try
		{
			int a = ob.getValue(-2);			// ⑧ 예외 발생
			System.out.println("a : " + a);
		}
		catch (Exception e)						// ⑨ 예외 잡아내기 
		{	
			// ⑩ 잡아둔 예외에 대한 처리
			System.out.println("printStackTrace........");
			e.printStackTrace();
		}
	}
								 // ② 발생한 예외 던지기
	public int getData(int data) throws Exception
	{
		if (data < 0)
		{	
			// ① 예외 발생
			throw new Exception("data가 0보다 작습니다.");
		}

		return data + 10;
	}							   // check~~~!!
								   // ⑦ 잡아낸 예외를 다시 던질 수 있도록 처리
	public int getValue(int value) throws Exception		
	{
		int a = 0;

		try
		{	
			a = getData(-2);  // ③ 예외 발생
		}
		catch (Exception e)	  // ④ 예외 잡아내기
		{	
			// ⑤ 잡아낸 예외에 대한 처리
			System.out.println("printStackTrace,........");
			e.printStackTrace();
			
			// chcek~~!! 
			// ⑥ 잡아서 처리한 에외를 다시 발생
			throw e;
		}
		return a;
	}

}