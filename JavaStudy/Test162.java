/*================================
  ���� �÷���(Collection) ����		
=================================*/

// �ڷᱸ�� ��ü ���� �� ���� �� 
// ����� ���� Ŭ���� Ȱ��
// �� �ڷ��� 

// Ŭ���� �� ����� ���� �ڷ������� Ȱ��
// �߿��� �����̹Ƿ� ���� �ʼ�!

import java.util.Vector;


class MyData
{
	// �ֿ� �Ӽ� ���� �� �ֿ� ���� ����(�������)
	private String name;		 //-- �̸�
	private int age;			 //-- ����

	// getter �� getXxx()
	// setter �� SetXxx()
	
	// getter / setter ����
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}

	public int getAge()
	{
		return age;
	}

	public void setAge(int age)
	{
		this.age = age;
	}

	// ������ �� ����� ���� ������(�Ű����� 2���� ������)

	public MyData(String name, int age)
	{
		this.name = name;
		this.age = age;
	}

	// ����� ���� �����ڰ� ������ ���
	// default �����ڰ� �ڵ����� ���Ե��� �ʱ� ������
	// default ������ �����ǻ����ڸ� ����� ���ǻ����ڷ� 
	// �߰� �����ϰ� �Ǵ� ���� �Ϲ����� Ŭ���� ���� ����
	// (�ݵ�� ���� �ؾ��Ѵٴ� �������� ��Ģ�� ����.)

	// ������ �� ����� ���� ������
	public MyData()
	{
		//this(" ",0); �Ʒ��� ���� ��
		name = "";
		age =0;
	}


}

public class Test162
{
	public static void main(String[] args)
	{
		//���� �ڷᱸ�� ����
		Vector<MyData> v = new Vector<MyData>();			// V��� ������ ����ǵ� MyData Ÿ�Ը� ����� �� �־�!

		//���� �ڷᱸ�� v��
		// ���ȯ 73�� / ������ 7�� / ������ 3�� 
		// ��Ƴ���	

		// ��
		/*
		   MyData st1 = new MyData();
		   st1.setName("���ȯ");
		   str1.setAge(73);
		   v.add(st1);

		   MyData st2 = new MyData();
		   str.setName("������");
		   str.setAge(7);
		   v.add(st2);

		   MyData st3 = new MyData();
		   str.setName("������");
		   str.setAge(3);
		   v.add(st3);
		*/

		// �� 
		/*
		   MyData st1 = new MyData("���ȯ" , 73);
		   v.add(st1);

		   MyData st2 = new MyData("������", 7);
		   v.add(st2);

		   MyData st3 = new MyData("������" , 3);
		   v.add(st3);
		 */

	    // ��
		  
		   v.add(new MyData("���ȯ" , 73));
		   v.add(new MyData("������" , 7));
		   v.add(new MyData("������" , 3));

		 // ���� �ڷᱸ�� v�� ��� ����(���) ��ü ����ϱ�
		 // ���� ��)
		 // �̸� : ���ȯ , ����: 73��
		 // �̸� : ������ , ����: 7��
		 // �̸� : ������ , ����: 3��
		
		/*
		 for( MyData data : v)
			System.out.print(data);
		 System.out.println();
		*/
		/*
		for (int i =0; i<v.size(); i++)
		{
			System.out.printf("�̸� : %s , ���� : %d�� \n" , v.get(i).getName() , v.get(i).getAge());
		}
		System.out.println();
		*/

		//�� 
		/*
		for (MyData obj : v)
			System.out.printf("�̸� : %s , ���� : %d��\n" , obj.getName() , obj.getAge());
		System.out.println();
		*/

		// ��
		/*
		for (int i = 0 ; i<v.size(); i++)
		{
			System.out.printf("�̸� : %s , ���� : %d�� \n" , v.elementAt(i).getName() , v.elementAt(i).getAge());
		}
		System.out.ptintln();

		// ��
		for (int i =0; i<v.size(); i++)
		{
			System.out.printf("�̸� : %s , ���� : %d�� \n" , v.get(i).getName() , v.get(i).getAge());
		}
		System.out.println();
		*/

		// ��
		for(Object obj: v)
			System.out.printf("�̸� : %s , ���� : %d�� \n" , ((MyData)obj).getName(), ((MyData)obj).getAge());
		System.out.println();
		//--==>> �̸� : ���ȯ , ���� : 73��
		//		 �̸� : ������ , ���� : 7��
		//		 �̸� : ������ , ���� : 3��

	}	

}