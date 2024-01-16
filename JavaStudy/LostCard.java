
import java.util.Vector;
import java.util.Scanner;

public class LostCard										// 분실신고 및 해지 클래스
{
	String ca;
	public static final String[] cardNumber	= {"1111-1111-1111", "2222-2222-2222","3333-3333-3333"};			// 확인 용 임시 값
	
	Vector<String> vt = new Vector<String>();	

	
	 // 카드 비교하고 확인 하는 메소드 작성
	 public void cardCheck()
	{	
		for (String cn : cardNumber)				// vt에 값을 넣기
		{
			vt.add(cn);
		}

		Scanner sc = new Scanner(System.in);																								
		System.out.print("분실신고 하실 카드 번호를 입력 해주세요 (- 포함) : ");
		ca = sc.next(); 
		
		
		 if (vt.contains(ca))						//카드가 존재할 경우
		 {
			System.out.print("분실 신고하신 카드는 재사용이 불가합니다 분실신고 하시겠습니까?(y/n) : ");
			String yes = sc.next(); 

			if (yes.equals("y") || yes.equals("Y"))	// 분실신고 확정
			{
				System.out.println("분실 신고가 완료 되었습니다.");	
				vt.remove(vt.indexOf(ca));
			}
			else									// 분실신고 취소
			{
				System.out.println("분실 신고가 취소 되었습니다.");	
			}
		 }
		 else
		{
			System.out.println("입력하신 카드가 없습니다. 다시 입력해주세요");
		}
			
	}
 	 // 카드 삭제하는 메소드 작성
	public void removeCard()
	{
		int i = vt.indexOf(ca);
		vt.remove(i);
	}
	
	//테스트 public void write()
	/*
	{
		System.out.println(vt);
	}
	*/
	

	public static void main(String[] args)			// 테스트 용 메인 메소드
	{
		LostCard lc = new LostCard();
		lc.cardCheck();
		//테스트(확인)lc.write();
		
	}
	
}