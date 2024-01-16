/*================================
  ■■■ 컬렉션(Collection) ■■■		
=================================*/

/*
○ List 
   - 순서가 있음, 배열과 유사,  중복을 허용
   - 주요 구현 클래스
   	 · Vector (동기화 지원)
	 · ArrayList (동기화 지원 안함)
	 · LinkedList (체인, 링크, 결합, 큐)


*/

import java.util.List;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Iterator;

public class Test166
{
	public static void main(String[] args)
	{
		List<String> list = new ArrayList<String>();

		list.add("서울");
		list.add("부산");
		list.add("인천");
		list.add("대구");
		list.add("광주");
		list.add("대전");	
		list.add("울산");
		list.add("세종");

		// 확인 → 더미 확인
		//System.out.println(list);
		//--==>> [서울, 부산, 인천, 대구, 광주, 대전, 울산, 세종]

		System.out.println("전체 갯수  : " + list.size());
		//--==>> 전체 갯수  : 8

		// 첫번째 요소 출력 
		System.out.println("첫 번째 요소 출력 : " + list.get(0));
		//--==>> 첫 번째 요소 출력 :  서울

		// 마지막 요소 출력
		System.out.println("마지막 요소 출력 : " + list.get(list.size()-1));
		//--==>> 마지막 요소 출력 : 세종

		// 처음 위치에 한국 추가
		list.add(0, "한국");
		
		// 더미 확인
		//System.out.println(list);
		//--==>> [한국, 서울, 부산, 인천, 대구, 광주, 대전, 울산, 세종]

		// 처음 위치의 데이터 요소를 "대한민국"으로 변경
		list.set(0, "대한민국");
		
		// 더미 확인
		//System.out.println(list);
		//--==>> [대한민국, 서울, 부산, 인천, 대구, 광주, 대전, 울산, 세종]

		// "서울" 존재여부 확인
		if (list.contains("서울"));
		{
			System.out.println("서울이 존재 합니다.");
		}
		//--==>> 서울이 존재 합니다.
		
		// "서울이 몇번째 인덱스에 위치하는지 확인" 
		int i = list.indexOf("서울");
		System.out.println("서울 인덱스 위치 : " + i);
		//--==>> 서울 인덱스 위치 : 1
		
		// "대한민국" 지우기 → 요소제거	
		list.remove("대한민국");					//-- (○)
		//list.remove(0);							//-- (○) 대한민국 인덱스 값 삽입도 가능
		//테스트 (확인)
		System.out.println(list);
		
		
		System.out.println("===========================================================================");


		//list의 전체 요소 출력
		System.out.println("전체 출력... MJ");
		ListIterator<String> li = list.listIterator();
		while (li.hasNext())
		{
			System.out.print(li.next() + " ");
		}
		System.out.println();

		System.out.println();
		
		System.out.println("전체 출력... 수업①");
		for (int idx = 0; idx<list.size(); idx++)
		{
			System.out.print(list.get(idx) +  " ");
		}
		System.out.println();
		//--==>> 전체 출력... 수업
		//		 서울 부산 인천 대구 광주 대전 울산 세종
		
		System.out.println();

		System.out.println("역순 출력....①");
		for (int idx = list.size()-1;idx>=0 ; idx--)
		{
			System.out.print(list.get(idx) + " ");
		}
		System.out.println();
		
		System.out.println();

		System.out.println("전체 출력.... 수업②");
		for (String s : list)
			System.out.print(s  + " ");
		System.out.println();
		
		System.out.println();

		System.out.println("전체 출력... 수업③");
		Iterator<String> itr = list.iterator();
		while (itr.hasNext())
		{
			System.out.print(itr.next() + " ");
		}
		System.out.println();
		
		System.out.println();

		System.out.println("역순 출력...②");
		while (li.hasPrevious())
		{
			String s = li.previous();
			System.out.print(s+" ");
		}
		System.out.println();


		
		
		



	}
}