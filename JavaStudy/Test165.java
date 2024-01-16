/*================================
  ■■■ 컬렉션(Collection) ■■■		
=================================*/

// List → Vectorm, ArrayList, LinkedList,	.....
// ·순서 의미 있음
// ·배열과 유사
// ·중복 허용

/*
○ ArrayList 클래스
   
   - ArrayList 와 Vector 클래스는 
     List를 크기 변경이 가능한 배열로 구성한 것으로 
	 차이점은 Vector 클래스의 객체는 기본적으로 동기화 되지만,
	 ArrayList는 그렇지 않다는 점이다. → 비동기화 컬렉션

   - 비동기화 컬렉션은 동기화된 컬렉션보다 더 나은 성능을 제공하며
     스레드들이 컬렉션을 공유할 필요가 없는 프로그램에서는
	 일반적으로 ArrayList를 Vector보다 더 선호하며,
	 스레드 동기화에 따르는 부담을 가지지 않기 때문에
	 Vector보다 더 빠르게 실행된다.

   - null을 포함한 모든 요소를 허용하며
     List 인터페이스를 구현하는 것외에 리스트에 격납하기 위해
	 내부적으로 사용되는 배열의 사이즈를 조작하는 메소드를 제공한다.
	

*/

import java.util.ArrayList;
import java.util.Vector;
import java.util.List;
import java.util.ListIterator;

public class Test165
{
	public static void main(String[] args)
	{
		//ArrayList 인스턴스 생성
		//ArrayList<String>list = new ArrayList<String>();

		//List<String> list - new List<String>(); 불가능하다. 왜냐면 인터페이스 → 추상클래스

		//Vector<String> list  = new Vector<String>(); 
		//List<String> list = new Vector<String>();
		List<String> list1 = new ArrayList<String>();

		//list1 자료구조에 요소 추가 → add()
		list1.add("오펜하이머");
		list1.add("엘리멘탈");
		list1.add("알라딘");

		List<String> list2 = new ArrayList<String>(list1);

		//list2 자료구조에 요소 추가 → add()
		list2.add("스파이더맨");		// 존잼~^.^

		List<String> list3 = new ArrayList<String>();

		// list3 에 list2 의 전체 요소를 추가 → addAll()
		list3.addAll(list2);

		// "알라딘" 앞에 "탑건" 추가
		// → [오펜하이머, 엘리멘탈, 알라딘, 스파이더맨]
		// → [오펜하이머, 엘리멘탈, 탑건, 알라딘, 스파이더맨]

		// ① "알라딘" 찾기 → indexOf() → 위치 인덱스 반환
		int n = list3.indexOf("알라딘");

		// 테스트 (확인)
		//System.out.println( "n :" + n);
		//--==>> n :2

		// ② "알라딘" 찾은 인덱스 위치에 "탑건" 삽입 → add()
		list3.add(n, "탑건");
		


		// 출력 → 더미데이터 확인
		System.out.println("=======================================");
		System.out.println(list1);
		//--==>> [오펜하이머, 엘리멘탈, 알라딘]
		System.out.println(list2);
		//--==>> []	
		// list2 생성자한테 list1을 매개변수로 넘겨주고 난 후 결과
		//--==>> [오펜하이머, 엘리멘탈, 알라딘]
		// 요소 추가 후 결과
		//--==>> [오펜하이머, 엘리멘탈, 알라딘, 스파이더맨]
		System.out.println(list3);
		//--==>> [오펜하이머, 엘리멘탈, 알라딘, 스파이더맨]
		// 탑건 추가 후 결과
		// --==>> [오펜하이머, 엘리멘탈, 탑건, 알라딘, 스파이더맨]

		// 출력 → listIterator() 메소드를 활용하여 출력
		System.out.println("=======================================================\n");

		ListIterator<String> li = list3.listIterator();
		while (li.hasNext())
		{
			System.out.print(li.next()  + " ");
		}
		System.out.println();
		//--==>> 오펜하이머 엘리멘탈 탑건 알라딘 스파이더맨

		// 출력 → 역순으로 접근
		while (li.hasPrevious())
		{
			System.out.print(li.previous() + " ");
		}
		System.out.println();
		//--==>> 스파이더맨 알라딘 탑건 엘리멘탈 오펜하이머





	}
}