/*================================
  ■■■ 컬렉션(Collection) ■■■		
=================================*/

// Map → Hashtable, HashMap

/*
○ java.util.Map 인터페이스
   키(key)를 값(value)에 매핑(mapping)하며
   동일한 키를 등록 할 수 없고, 유일해야 하며,
   각 키는 한개의 값만을 매핑해야한다.
   즉, 하나의 키에 대응하는 하나의 값을 갖는 구조이다.
*/

/*
○ Hashtable<K,V> 클래스
   - 해시 테이블 구조를 객체 모델링화 한 클래스로
     검색이 용이하기 때문에 사용빈도가 높은 편에 속한다.

	 해시테이블이랑 키(key)와 그에 상응하는 데이터(value)로 
	 구분된 데이터 구조이다.
	 데이터를 저장하고 검색하기 위해서 키(key)로 접근하며
	 이 구조에서는 키 값을 부여하면 해당 데이터가 변환된다.
	 또한, Hashtable 클래스는 key 또는 value 의 값으로 null을 허용하지 않는다.
*/

import java.util.Hashtable;

public class Test170
{

	private static final String[] names = {"강혜성", "길현욱", "김경태", "김다슬","김동민", "김민지"};

	private static final String[] tels = {"010-6380-7047", "010-6678-9867", "010-4012-6216", "010-8972-1901","010-4073-4940","010-7159-4231"};

	public static void main(String[] args)
	{
		// Hashtable 자료구조 생성
		Hashtable<String, String> ht = new Hashtable<String, String>();			//제네릭을 표현할때 <key, value> 두가지 다 써야함.

		// ht 라는 Hashtable 자료구조에 
		// 배열(name ,tels)에 담겨있는 데이터를 요소로 담아내기 
		// → put (k,v);		// add와 같이 요소를 넣는데 사용!

		for (int i =0; i<names.length; i++)
		{
			//ht.put("강혜성", "010-6380-7047");
			ht.put(names[i], tels[i]);
		}

		// ht라는 Hashtable 자료구조에서
		// key 를 이용하여 데이터 검색
		// → get(k);

		String findName1 = "김동민";
		//String findName1 = "이윤수";
		String str = ht.get(findName1);

		if (str != null)
		{
			System.out.println(findName1 + " 전화번호: " + str);
		}
		//else 
		//{
		//	System.out.println("테스트");
		//}
		System.out.println();
		//--==>> 김동민 전화번호: 010-4073-4940

		// ht라는 Hashtable 자료구조에 
		// key가 존재하는지의 여부 확인
		// → containsKey()
		String findName2 = "이주형";
		if (ht.containsKey(findName2))
		{
			System.out.println(findName2 + " 데이터가 존재합니다.");
		}
		else
		{
			System.out.println(findName2 + " 데이터가 존재하지 않습니다.");
		}
		System.out.println();
		//--==>> 이주형 데이터가 존재하지 않습니다.

		String findName3 = "김민지";
		if (ht.containsKey(findName3))
		{
			System.out.println(findName3 + " 데이터가 존재합니다.");
		}
		else 
		{
			System.out.println(findName3+ " 데이터가 존재하지 않습니다.");
		}
		//--==>> 김민지 데이터가 존재합니다.

		// ht가 HashTable 자료구조에 
		// value가 존재하는지의 여부 확인
		// → contains
		String findTel1 = "010-4012-6216";		// 경태 전화번호
		if (ht.contains(findTel1))
		{
			System.out.println(findTel1 + " 데이터가 존재합니다.");
		}
		else
		{
			System.out.println(findTel1 + " 데이터가 존재하지 않습니다.");
		}
		System.out.println();
		//--==>> 010-4012-6216 데이터가 존재합니다.

		// ht라는 Hashtable 자료구조에서 
		// 『길현욱』데이터 삭제
		// → remove ()
		ht.remove("길현욱");

		// ※ 『remove()』메소드는 인자값으로 key를 넘겨받지만
		//     이때, key만 삭제되는 것이 아니다.
		//	   해당 key와 연결되어(매핑되어) 있는 value도 함께 제거한다.

		// 삭제(remove())이후 ht라는 Hashtable자료구조에
		// 해당 key가 존재하는지 확인
		if (ht.containsKey("길현욱"))
		{
			System.out.println("현욱이가 존재합니다");
		}
		else
			System.out.println("현욱이 어디갓어??");
		System.out.println();
		//--==>> 현욱이 어디갓어??

		// 삭제(remove())이후 ht라는 Hashtable자료구조에
		// 해당 key가 존재하는지 확인
		if (ht.contains("010-6678-9867"))
		{
			System.out.println("현욱이가 전화번호가 존재합니다");
		}
		else
			System.out.println("현욱이 전화번호 어디갓어??");
		System.out.println();
		//--==>> 현욱이 전화번호 어디갓어??

		// ※ null 관련 처리
		
		//ht.put(null,null);					//-- key와 value가 모두 null인 상태
		// --==>> 에러 발생(런타임 에러)
		//		  java.lang.NullPointerException

		//ht.put("김수환", null);				//-- value가 null인 상태
		// --==>> 에러 발생(런타임 에러)
		//--==>> java.lang.NullPointerException

		//ht.put(null, "010-1234-5678");		//-- key가 null인 상태
		// --==>> 에러 발생(런타임 에러)
		//--==>> java.lang.NullPointerException

		// 중복된 key 입력
		ht.put("강혜성","010-1111-1111");

		System.out.println(ht.get("강혜성"));
		System.out.println();
		//--==>> 010-1111-1111		
		//-- 중복된 key를 활용하여 데이터를 입력할 경우 
		//   기존"010-6380-7047"에서 "010-1111-1111"로 변경되었음을 확인
		//   (덮어쓰기 개념)

		// 중복된 value 입력
		ht.put("김지민","010-8972-1901");

		System.out.println(ht.get("김다슬"));
		System.out.println(ht.get("김지민"));
		//--==>> 010-8972-1901
		//		 010-8972-1901
		//-- value는 중복된 값이 입력되더라고
		//   기존 데이터는 아무런 영향을 미치지 않음.

	}		
}