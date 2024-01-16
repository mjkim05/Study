/*================================
  ���� �÷���(Collection) ����		
=================================*/


//�� Set �� HashSet, TreeSet,...
//   - ������ ����
//   - �ߺ��� ������� �ʴ� ����(�⺻)
  
/*
�� Tree Set<E> Ŭ����
   
   java.util.TreeSet<E> Ŭ������ 
   Set �������̽��� ����� SortedSet, �������̽��� ������ Ŭ������
   �����͸� �߰��ϸ� �����͵��� �ڵ����� �������� ������ �ȴ�.

   HashSet ���� ������ ������
*/

// VO  - Value Object
// DTO - Data Transfer Object			
// DAO - Data Access Object		

// DAO, DTO �ΰ��� ǥ���ϴ� ��찡 ���� ����. 
// �� ������ VO�� DAO�� ǥ���ϴ� ��찡 ����
// VO�� DAO�� ǥ���ϴ� ���� ���� ����.

import java.util.TreeSet;
import java.util.Iterator;
import java.util.Comparator;

class GradeVO
{
	//�ֿ� �Ӽ� ����
	private String hak;			//-- �й�
	private String name;		//-- �̸�
	private int kor, eng, mat;	//-- ����, ����, ����

	GradeVO(String hak, String name, int kor, int eng, int mat)
	{
		this.hak = hak;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;	
	}

	//�̿� ���� ��� default ������ �ڵ� ���Ե��� ����~~!!

	// ����� ���� ������ �� �Ű����� ���� ������(default ������ ����)
	GradeVO()
	{
		// ������ ���ο��� �Ǵٸ� ������ ȣ��
		// GradeVO("", "",0,0,0);
		this("","",0,0,0);
	}


	//getter / setter ����	
	
	
	public String getHak()
	{
		return this.hak;
	}
	
	public void setHak(String hak)
	{
		this.hak = hak;		
	}
			
	public String getName()
	{
		return this.name;
	}
	
	public void setName(String name)
	{
		this.name = name;		
	}

	
	public int getKor()
	{
		return this.kor;
	}
	
	public void setKor(int kor)
	{
		this.kor = kor;	
	}

	
	public int getEng()
	{
		return this.eng;
	}
	
	public void setEng(int eng)
	{
		this.eng = eng;		
	}

	
	public int getMat()
	{
		return this.mat;
	}
	
	public void setMat(int mat)
	{
		this.mat = mat;		
	}



	
	// �߰� �޼ҵ� ����(���� ����)
	public int tot()
	{
		return kor+eng+mat;
	}

}


class MyComparator<T> implements Comparator<T>				//Ȱ�� �� ����  <T> �� (Ÿ�� ����) � Ÿ���� �Ѱ��ְ� �Ǹ�...  / <E> �� Element
{
	//�� �޼ҵ� ������
	@Override
	public int compare(T o1, T o2)							//T Ÿ���� o1 , T Ÿ���� o2
	{
		GradeVO s1 = (GradeVO)o1;
		GradeVO s2 = (GradeVO)o2;

		// �й� ����(��������)
		//return Integer.parseInt(s1.getHak()) - Integer.parseInt(s2.getHak());
		// return Integer.parseInt(s1.getHak()) - Integer.parseInt(s2.getHak());
		// return Integer.parseInt("2308113") - Integer.parseInt("2308116");
		// return 2308113 - 2308116;
		// return -3;
		// �� o2�� �� ū ������ �� ��� ����~~!!

		//... return 5;
		// �� o1�� �� ū ������ �� ��� ����~~!!

		// ... return 0;
		// �� o1 �� o2�� ���� ������ �� ��� ����~~!!

		// �й� ����(��������)
		//return Integer.parseInt(s2.getHak()) - Integer.parseInt(s1.getHak());

		// ���� ����(��������)
		//return (s1.tot()) - (s2.tot());

		// ���� ����(��������)
		//return (s2.tot()) - (s1.tot());

		// �̸� ����(��������)
		// ���� ���ڿ� s1.getName() �� �� ��� s2.getName()
		//return (s1.getName().compareTo(s2.getName()));

		// �̸� ����(��������)
		return (s2.getName().compareTo(s1.getName()));



		
	}
}




public class Test169
{
	public static void main(String[] args)
	{

		//TreeSet �ڷᱸ�� ����
		TreeSet<String> set = new TreeSet<String>();

		//TreeSet �ڷᱸ�� set�� ��� �߰� �� add();
		set.add("¯���¸�����");
		set.add("������ũ");
		set.add("���ǽ�");
		set.add("�޺�õ��");
		set.add("�̴��߻�");
		set.add("�����̸���");
		set.add("����������");
		set.add("��Ʋ¯");
		set.add("������");

		//Iterator �� Ȱ���� Set ��� ��ü ���
		Iterator<String> it = set.iterator();
		while (it.hasNext())
		{
			System.out.print(it.next() + " ");
		}
		System.out.println();
		//--==>> �����̸��� �޺�õ�� ������ ��Ʋ¯ ���������� ������ũ ���ǽ� �̴��߻� ¯���¸�����
		// -- ��Ҹ� ���ڿ��� ������ ��� 
		// -- �����ټ� �� �������� ����
		
		//TreeSet �ڷᱸ�� ����
		//TreeSet<GradeVO>set2 = new TreeSet<GradeVO>();
		TreeSet<GradeVO>set2 = new TreeSet<GradeVO>(new MyComparator<GradeVO>());


		//TreeSet �ڷᱸ�� set2�� ��� �߰�
		set2.add(new GradeVO("2308113", "������", 90, 80, 70));
		set2.add(new GradeVO("2308116", "������", 91, 81, 71));
		set2.add(new GradeVO("2308120", "������", 88, 78, 68));
		set2.add(new GradeVO("2308103", "��ٽ�", 70, 95, 91));
		set2.add(new GradeVO("2308132", "������", 99, 82, 79));

		//Iterator Ȱ���� set2 ��� ��ü ���
		/* 
		Iterator<GradeVO> it2 = set2.iterator();
		while (it2.hasNext())
		{
			System.out.print(it2.next() + " ");
		}
		System.out.println();
		//--==>> ���� �߻�(��Ÿ�� ����)
		//		 java.lang.ClassCastException:
		//       GradeVO cannot be cast to java.lang.Comparable
		*/

		// �� MyComparator Ŭ�������� �����Ͽ�
		//    compare() �޼ҵ带 �������� �� �ٽ� ����
		/* ��ü ��ü�� ���
		Iterator<GradeVO> it2 = set2.iterator();
		while (it2.hasNext())
		{
			System.out.print(it2.next() + " ");
		}
		System.out.println();
		//--==>> GradeVO@15db9742 GradeVO@6d06d69c GradeVO@7852e922 GradeVO@4e25154f GradeVO@70dea
		*/
		
		// ��ü ��ü�� ���� ����ϴ� ���� �ƴ϶� 
		// ��ü�� ���� �ִ� �Ӽ��� �����Ͽ� ����� �� �ֵ��� ó�� 

		Iterator<GradeVO> it2 = set2.iterator();
		while (it2.hasNext())
		{	
			GradeVO gr = it2.next();
			System.out.printf("%s %s %d %d %d %d\n",gr.getHak(), gr.getName(), gr.getKor(), gr.getEng(),gr.getMat(),gr.tot());
		}
		System.out.println();








	}
}