/*==========================================
  ���� �޼ҵ��� ��� ȣ�� ����
  ==========================================*/
public class Test067
{
	public static void main(String[] args)
	{
		showHi(3);
	}
	
	//showHi() �޼ҵ� �ڵ峻���� �� ���� ��ġ �ٲٱ�

	public static void showHi(int cnt)
	{	
		//�� ģ���� �ǵ� hi�� ������ ���
		
		System.out.println("Hi~~");
		if (cnt==1)
		return;
		showHi(--cnt);
	}
}