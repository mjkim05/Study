
/* ===============================================
 	MemberDTO.java
 	- 객체 전용(데이터 보관 및 전송) → JAVA Bean
 ================================================ */

package com.test;

public class MemberDTO
{
	// 프로퍼티 구성
	private String sid, name, tel;

	public String getSid()
	{
		return sid;
	}

	public void setSid(String sid)
	{
		this.sid = sid;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getTel()
	{
		return tel;
	}

	public void setTel(String tel)
	{
		this.tel = tel;
	}
		
}
