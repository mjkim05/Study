
import java.util.Vector;
import java.util.Scanner;

public class LostCard										// �нǽŰ� �� ���� Ŭ����
{
	String ca;
	public static final String[] cardNumber	= {"1111-1111-1111", "2222-2222-2222","3333-3333-3333"};			// Ȯ�� �� �ӽ� ��
	
	Vector<String> vt = new Vector<String>();	

	
	 // ī�� ���ϰ� Ȯ�� �ϴ� �޼ҵ� �ۼ�
	 public void cardCheck()
	{	
		for (String cn : cardNumber)				// vt�� ���� �ֱ�
		{
			vt.add(cn);
		}

		Scanner sc = new Scanner(System.in);																								
		System.out.print("�нǽŰ� �Ͻ� ī�� ��ȣ�� �Է� ���ּ��� (- ����) : ");
		ca = sc.next(); 
		
		
		 if (vt.contains(ca))						//ī�尡 ������ ���
		 {
			System.out.print("�н� �Ű��Ͻ� ī��� ������ �Ұ��մϴ� �нǽŰ� �Ͻðڽ��ϱ�?(y/n) : ");
			String yes = sc.next(); 

			if (yes.equals("y") || yes.equals("Y"))	// �нǽŰ� Ȯ��
			{
				System.out.println("�н� �Ű� �Ϸ� �Ǿ����ϴ�.");	
				vt.remove(vt.indexOf(ca));
			}
			else									// �нǽŰ� ���
			{
				System.out.println("�н� �Ű� ��� �Ǿ����ϴ�.");	
			}
		 }
		 else
		{
			System.out.println("�Է��Ͻ� ī�尡 �����ϴ�. �ٽ� �Է����ּ���");
		}
			
	}
 	 // ī�� �����ϴ� �޼ҵ� �ۼ�
	public void removeCard()
	{
		int i = vt.indexOf(ca);
		vt.remove(i);
	}
	
	//�׽�Ʈ public void write()
	/*
	{
		System.out.println(vt);
	}
	*/
	

	public static void main(String[] args)			// �׽�Ʈ �� ���� �޼ҵ�
	{
		LostCard lc = new LostCard();
		lc.cardCheck();
		//�׽�Ʈ(Ȯ��)lc.write();
		
	}
	
}