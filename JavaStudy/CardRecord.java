class CardRecord
{	
	private String name;	// 이름을 입력받을 변수
	private int idNum;		// 주민 번호를 입력 받을 변수
	private int telNum;		// 전화 번호를 입력 받을 변수

	// 생성자
	CardRecord(String name, int idNum, int telNum)
	{
		this.name = name;
		this.idNum = idNum;
		this.telNum = telNum;
	}

	// getter 메소드
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

	// setter 메소드
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