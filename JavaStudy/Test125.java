/*==========================
  ���� Ŭ���� ��� ����
  - ��ø Ŭ����
============================*/

/*
�� annonymous Ŭ���� (�͸��� Ŭ���� : ���� Ŭ����)

	- AWT�� �ȵ���̵� �̺�Ʈ ó������ �Ϲ������� ���					// �̺�Ʈ ��  �Ͼ�� ��� ���� ex) Ű���带 ������ ����, ȭ���� ��ġ�ϴ� ���� ���� �̺�Ʈ! 
	- ������ Ŭ���� �޼ҵ带 �ϳ� ���� �����ǡ��� �ʿ伺�� ���� �� ���
	- Ŭ������ ��ü�� �ʿ��ϸ� �� �ٽ� Ŭ������ �����ؾ� �ϴ� 
	  ���ŷο����� ���� ����ϰ� ��ü ������ �ʿ��� ���
	  �͸��� Ŭ������ �����Ͽ� ó���� �� �ִ�.

	  Ŭ������ �̸��� ���δٴ°� �� ������ �� �͸��� Ŭ������ �ѹ� ���� �����Ŵϱ� �̸� ��

�� ���� �� ���� 
	
	new ���� Ŭ������ ������()
	{
		�������������� �ڷ��� �޼ҵ�()
		{
			.....;
		}
	};						�� check~~!! �����ݷ�
*/


// ��� Ŭ������ extends Object �� �ڿ� �پ�����!
// ���߻���� �ȵǴµ� �ڽ�Ŭ������ extends Object �� ��� ���� �� ������?
// ���� ��Ӹ� �����Ѱ� ����! �� �θ� Ŭ���� ���󰡸� �θ� Ŭ������ extends Object�� ��� ���� �� ���� �ڽĵ� ��ӹ޴´�.
// Object Ŭ������ Ŭ������ ����(�ֻ��� Ŭ����) �� Ŭ���� ���赵 �� ����⿡ Object�� ����! 

//import java.lang.Object;
//import java.lang.*; 
// �츮�� ���� ��� Ŭ������ �ڵ� ����

class TestObj //extends Object
{

	/*
	Object �� �����~~!! 
	...;

	public String toString()
	{
		...;
	}
	...;

	*/
	
	/*
	@Override							//Object �� ��ӹ޾ұ⶧���� �������̵� ����!
	public String toString()
	{
		...;
	}
	*/

	public Object getString()
	{
		/*
		Object ob = new Object();
		ob.xx()
		ob.yy()
		ob.xxx()

		return ob;
		*/

		//return new Object();
		//			----------- Object ��

		return new Object()
		{
			// Ư�� �޼ҵ� �籸�� �� ������
			@Override							
			public String toString()
			{
				return "�͸��� Ŭ����...";
			}

		};
	}

}

//import java.lang.*;

public class Test125 //extends Object
{
	/*
	Object�� ����� ���~~!! 
	*/
	
	public static void main(String[] args)
	{
		TestObj ob = new TestObj();
		System.out.println(ob.toString());
		//--==>> TestObj@15db9742

		System.out.println(ob.getString());
		//--==>> �͸��� Ŭ����...

	}
}