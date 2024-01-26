/* ========================================
   StudentDTO.java
   - 데이터 전송 객체 자료형 클래스(DTO)
   - 학생 데이터 저장 및 전송
========================================== */

package com.test.mybatis;

public class StudentDTO
{
	// 주요 속성 구성
	private String sid, name, tel, sub;

	// getter/setter 구성
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

	public String getSub()
	{
		return sub;
	}

	public void setSub(String sub)
	{
		this.sub = sub;
	}
	
	
}
