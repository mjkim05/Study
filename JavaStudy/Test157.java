/*================================
  ■■■ 컬렉션(Collection) ■■■		→ 컬렉션 프레임워크랑 같은거임
=================================*/

import java.util.Queue;
import java.util.LinkedList;

public class Test157
{
	// 정적 문자열 배열 선언 및 초기화 
	private static final String[] colors	= {"검정", "노랑", "초록", "파랑", "빨강", "연두"};

	public static void main(String[] args)
	{
		//Queue 자료구조 생성
		Queue<String> qu = new LinkedList<String>();
		//-- queue 인터페이스 기반의 인스턴스를 생성하기 위해서는 
		//   new 연산자를 이용하여 queue 인터페이스를 implements 한 
		//   하위 클래스의 생성자를 호출해야한다.
		
		// qu라는 Queue자료구조에 
		// colors 배열의 데이터 모두 입력

		for(String color : colors)
			qu.offer(color);			// = 좀 쓰지마~~!!!

		// qu 라는 Queue 자료구조의 모든 데이터 전체 출력
		// peek()
		// : 큐의 head 요소를 반환하고 삭제하지 않으며
		//   큐의 자료 구조가 비어 있는 상태가 되면 null 반환
		// poll()
		// : 큐의 head 요소를 반환하고 삭제
		//   큐의 자료 구조가 비어 있는 상태가 되면 null 반환

		while (qu.peek() !=null )				// 위에서 스트링 제네릭 했으니까 여기서는 안써도 된다~~!!
		{
			String val = qu.poll();
			System.out.print(val + " ");
		}
		System.out.println();
		
	}
}
//실행 결과
/*
검정 노랑 초록 파랑 빨강 연두
계속하려면 아무 키나 누르십시오 . . .
*/