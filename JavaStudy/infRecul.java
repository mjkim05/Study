/*==========================================
  ���� �޼ҵ��� ��� ȣ�� ����
  ==========================================*/
public class infRecul
{
	public static void main(String[] args)
	{
		showHi(3);
	}
	
	//showHi() �޼ҵ� �ڵ峻���� �� ���� ��ġ �ٲٱ�

	public static void showHi(int cnt)
	{	

		showHi(cnt--);
		System.out.println("Hi~~");
		if (cnt==1)
			return;
	

	}
}