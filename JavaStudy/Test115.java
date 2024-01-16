
/*==========================
  ���� Ŭ���� ��� ����
  - �߻� Ŭ����(abstract)
=============================*/

/*
�� �߻� Ŭ������(abstract)��
	
	���� �ְ� ���ǰ� ���� �ϳ� �̻��� �޼ҵ�(�߻� �޼ҵ�)�� ���� Ŭ������
	���� Ŭ����(�ڽ� Ŭ����)���� �������̵�(Overriding) �� ������ ����Ǵ� �޼ҵ忡 ���� 
	�޸� ���� ���� �̸� ȣ�� ��ȹ�� �����α� ���� �����..

��	���� �� ����
	
	[��������������] abstact class Ŭ������
	{
		[��������������] abstract �ڷ��� �޼ҵ��([�Ű�����],...);
	}
�� Ư¡

	Ŭ������ ��� �ϳ� �̻��� �߻� �޼ҵ带 �����Ҷ�
	�� Ŭ������ Ŭ���� �տ� ��abstract�� Ű���带 �ٿ�
	�߻� Ŭ������ ����ؾ� �ϸ�,
	�߻� Ŭ������ ������ ��쿡�� 
	�ҿ����� ������ Ŭ�����̹Ƿ� ��ü�� ������ �� ��̴�.
	�߻� �޼ҵ尡 �������� �ʴ� �߻� Ŭ���� ������ 
	Ĵü�� ������ �� ���� ���̴�.

	��, �߻� Ŭ������ ���������� ������ �� ���� ������
	����� ���ؼ��� �����ϸ� 
	�߻� Ŭ������ ��ӹ��� ���� Ŭ���������� 
	�ݵ�� �߻�޼ҵ带 �������̵�(Overriding) �ؾ��Ѵ�.


 ��	��abstract�� Ű����� 
	Ŭ������ �޼ҵ忡���� ����� �� ������
	��� ������ ���� ���������� ����� �� ����.
*/
// �߻� Ŭ����
//class SortInt115
abstract class SortInt115
{
	private int[] value;

	protected void sort(int[] value)
	{
		this.value = value;
		sorting();
	}
	
	//�߻� �޼ҵ�
	//protected void sorting();
	protected abstract void sorting();

	protected int dataLength()
	{
		return value.length; 
	}
	
	// ��final�� Ű����� ���� 
	// �� Ŭ����(SortInt115)�� ��ӹ޴� Ŭ��������
	// �� �޼ҵ带 ������(Mathord Overriding) �� �� ����. 
	protected final int compare(int i, int j)
	{
		int x = value[i];
		int y = value[j];

		if(x == y)
			return 0;
		else if (x>y)
			return 1;
		else
			return -1;
	}

	protected final void swap(int i, int j)
	{
		int temp = value[i];
		value[i] = value[j];
		value[j] = temp;
	}

}// end sortInt115


// public class Test115
//public class Test115 extends SortInt115

// SortInt115(�߻�Ŭ����)Ŭ������ ��ӹ��� Ŭ���� �� �ϴ��� �߻� Ŭ����
//public abstract class Test115 extends SortInt115
// SortInt115(�߻�Ŭ����)Ŭ������ ��ӹ��� Ŭ���� �� �ϴ��� �߻� Ŭ���� �� �߻�޼ҵ� ������ �� �Ϲ� ���� Ŭ����
public class Test115 extends SortInt115
{
	/*
	protected void sort(int[] value)
	{
		this.value = value;
		sorting();
	}
	
	//�߻� �޼ҵ�
	protected abstract void sorting();

	protected int detaLength()
	{
		return value.length; 
	}

	protected final int compare(int i, int j)
	{
		int x = value[i];
		int y = value[j];

		if(x == y)
			return 0;
		else if (x>y)
			return 1;
		else
			return -1;
	}

	protected final void swap(int i, int j)
	{
		int temp = value[i];
		value[i] = value[j];
		value[j] = temp;
	}
	*/
	
	int i, j;
	
	static int[] data = {7, 10, 3, 28, 7};

	//���� ���ķ� �ϱ�! ��������
	
	/*
	@Overriding
	protected void sorting()
	{
		for (i=0; i<data.length; i++)
		{
			for (j=0; j<data.length-1; j++)
			{
				if (data[j] > data[j+1])
				{
					data[j] = data[j]^data[j+1];
					data[j+1] = data[j+1]^data[j];
					data[j] = data[j]^data[j+1];
				}
			}
		}
	}
	*/

	/*
	@Override
	protected void sorting()
	{
		for (i = 0; i<dataLength(); i++)
		{
			for (j = i+1; j<dataLength(); j++)
			{
				int a = compare(i,j);

				if (a == 1)
				{
					swap(i,j);
				}
			}
		}
	}


	*/
	
	@Override
	protected void sorting()
	{
		for (i=0; i<dataLength()-1; i++)
		{
			for (j=i+1; j<dataLength(); j++)
			{
				// ũ���
				if (compare(i,j)>0)
				{
				
					// �ڸ� �ٲٱ�

					swap(i,j);
				}
			}
		}
	}


	public static void main(String[] args)
	{
		System.out.print("Source Data : ");
		for (int n : data )
			System.out.print(n + " ");
		System.out.println();
		//--==>> Source Data : 7 10 3 28 7

		Test115 ob = new Test115();
		ob.sort(data);

		System.out.print("Sorted Data : ");
		for (int n : data)
			System.out.print(n + " ");
		System.out.println();
		

	}
}

//���� ��� 
/*
Source Data : 7 10 3 28 7
Sorted Data : 3 7 7 10 28
����Ϸ��� �ƹ� Ű�� �����ʽÿ� . . .
*/