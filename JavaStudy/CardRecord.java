class CardRecord
{	
	private String name;	// �̸��� �Է¹��� ����
	private int idNum;		// �ֹ� ��ȣ�� �Է� ���� ����
	private int telNum;		// ��ȭ ��ȣ�� �Է� ���� ����

	// ������
	CardRecord(String name, int idNum, int telNum)
	{
		this.name = name;
		this.idNum = idNum;
		this.telNum = telNum;
	}

	// getter �޼ҵ�
	public String getNmae()
	{
		return name;
	}

	public int getIdNum()
	{
		return idNum;
	}

	public int getTelNum()
	{
		return telNum;
	}

	// setter �޼ҵ�
	public void setName(String name)
	{
		this.name = name;
	}

	public void setIdNum(int idNum)
	{
		this.idNum = idNum;
	}

	public void setTelNum(int telNum)
	{
		this.telNum = telNum;
	}
}