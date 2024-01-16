/*=================================================================
■■■ 클래스와 인스턴스 ■■■
- 메소드 오버로딩(Method Overloading)이 가능한 형태와 불가능한 형태
=================================================================*/

public class Test104
{
	public static void main(String[] args)
	{
		
	}

	public static void print() {}
	//public static void print() {}							//-- (X)
	public static void print(int i) {}
	//public static void print(int j) {}					//-- (X)
	public static void print(char c) {}						//-- 자동 형 변환 규칙 check~!!!
	public static void print(int i, int j) {}
	public static void print(double d) {}					//-- 자동 형 변화 규칙 check~!!!
	//public static void print(double e) {return 10.0;}		//-- 정의 불가(return 자료형 오류)
	//public static double print(double e) {return 10.0;}	//-- (X) check~!!! 메소드 리턴은 메소드 호출 이후에 관여하기 때문에 호출 자체에서 걸림
}