package com.test;

public class FriendDTO
{
	private String name,age,gender;
	//private String love;
	//-- 이상형은 여러 개의 데이터가 동시에 전달되므로 
	//   즉, 다중 선택이 가능하도록 구성하였기 때문에
	//   배열로 처리할 수 있다.
	private String[] love;

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getAge()
	{
		return age;
	}

	public void setAge(String age)
	{
		this.age = age;
	}

	public String getGender()
	{
		return gender;
	}

	public void setGender(String gender)
	{
		this.gender = gender;
	}

	public String[] getLove()				// 배열로 나오는거 확인~~ check~~!!
	{
		return love;
	}

	public void setLove(String[] love)		// 배열로 나오는거 확인~~ check~~!!
	{
		this.love = love;
	}

	/*
	 * public String getLove() { return love; }
	 * 
	 * public void setLove(String love) { this.love = love; }
	 */
	
}
