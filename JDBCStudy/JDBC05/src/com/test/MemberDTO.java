/* =======================================
 	MemberDTO.java
 	- 데이터 보관 및 전송 전용 클래스
 ========================================*/
package com.test;

public class MemberDTO
{
	
	private String empId, cityId, buseoId, jikwiId, empName , ssn, tel , ibsaDate, cityName, buseoName, jikwiName;
	private int basicPay,sudang,minBasic;
	
	public String getCityName()
	{
		return cityName;
	}
	public void setCityName(String cityName)
	{
		this.cityName = cityName;
	}
	public String getBuseoName()
	{
		return buseoName;
	}
	public void setBuseoName(String buseoName)
	{
		this.buseoName = buseoName;
	}
	public String getJikwiName()
	{
		return jikwiName;
	}
	public void setJikwiName(String jikwiName)
	{
		this.jikwiName = jikwiName;
	}
	public String getEmpId()
	{
		return empId;
	}
	public void setEmpId(String empId)
	{
		this.empId = empId;
	}
	public String getCityId()
	{
		return cityId;
	}
	public void setCityId(String cityId)
	{
		this.cityId = cityId;
	}
	public String getBuseoId()
	{
		return buseoId;
	}
	public void setBuseoId(String buseoId)
	{
		this.buseoId = buseoId;
	}
	public String getJikwiId()
	{
		return jikwiId;
	}
	public void setJikwiId(String jikwiId)
	{
		this.jikwiId = jikwiId;
	}
	public String getEmpName()
	{
		return empName;
	}
	public void setEmpName(String empName)
	{
		this.empName = empName;
	}
	public String getSsn()
	{
		return ssn;
	}
	public void setSsn(String ssn)
	{
		this.ssn = ssn;
	}
	public String getTel()
	{
		return tel;
	}
	public void setTel(String tel)
	{
		this.tel = tel;
	}
	public String getIbsaDate()
	{
		return ibsaDate;
	}
	public void setIbsaDate(String ibsaDate)
	{
		this.ibsaDate = ibsaDate;
	}
	public int getBasicPay()
	{
		return basicPay;
	}
	public void setBasicPay(int basicPay)
	{
		this.basicPay = basicPay;
	}
	public int getSudang()
	{
		return sudang;
	}
	public void setSudang(int sudang)
	{
		this.sudang = sudang;
	}
	public int getMinBasic()
	{
		return minBasic;
	}
	public void setMinBasic(int minBasic)
	{
		this.minBasic = minBasic;
	}
	
	
}
