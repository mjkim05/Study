/* =========================================
 	MemberDAO.java
 	- 데이터베이스 액션 처리 전용 클래스
 ==========================================*/
package com.test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.xml.stream.events.StartElement;

import com.util.DBConn;

public class MemberDAO
{
	private Connection conn;
	
	// 데이터베이스 연결 메소드
	public void connection()
	{
		conn = DBConn.getConnection();
	}
	
	// 직원테이블 인원수 조회 메소드
	public int count() throws SQLException
	{
		int result = 0;
		
		// 작업 객체 생성
		Statement stmt = conn.createStatement();
		
		// 쿼리문 생성
		String sql = "SELECT COUNT(*) AS COUNT FROM TBL_EMP";
		
		// 쿼리문 실행
		ResultSet rs = stmt.executeQuery(sql);
		
		while (rs.next())
		{
			result = rs.getInt("COUNT");
		}
		// 리소스 반납
		rs.close();
		stmt.close();
		
		// 결과 반환 
		return result;
	}
	
	// 직원테이블 데이터 입력 메소드
	public int add(MemberDTO dto) throws SQLException
	{
		int result = 0;
		
		// 작업 객체 생성
		Statement stmt = conn.createStatement();
		
		// 쿼리문 생성
		String sql = String.format("INSERT INTO TBL_EMP (EMP_ID, EMP_NAME, SSN, IBSADATE, CITY_ID, TEL, BUSEO_ID, JIKWI_ID, BASICPAY, SUDANG) VALUES (EMPSEQ.NEXTVAL, '%s', '%s', '%s', %s, '%s', %s, %s, %d, %d)"
									,dto.getEmpName(), dto.getSsn(), dto.getIbsaDate(),dto.getCityId(),dto.getTel(),dto.getBuseoId(),dto.getJikwiId(),dto.getBasicPay(),dto.getSudang());	
		
		// 쿼리문 실행 
		result = stmt.executeUpdate(sql);
		
		// 리소스 반환
		stmt.close();
		
		return result;
	}
	
	// 직원 전체 출력 메소드 
	public ArrayList<MemberDTO> lists(int num) throws SQLException
	{
		ArrayList<MemberDTO> arrayList = new ArrayList<MemberDTO>();
		
		// 전체출력
		
		// 작업 객체 생성
		Statement stmt = conn.createStatement();
		String sql = "";
		
		// 쿼리문 생성 
		switch (num)
		{
		case 1:
			// 사원 정렬 
			sql = "SELECT EMP_ID, EMP_NAME, SSN, TO_CHAR(IBSADATE,'YYYY-MM-DD') AS IBSADATE, CITY_NAME, TEL, BUSEO_NAME, JIKWI_NAME ,BASICPAY, SUDANG, (BASICPAY + SUDANG)  FROM VIEW_EMP ORDER BY 1";
			break;
		case 2:
			// 이름 정렬 
			sql = "SELECT EMP_ID, EMP_NAME, SSN, TO_CHAR(IBSADATE,'YYYY-MM-DD') AS IBSADATE, CITY_NAME, TEL, BUSEO_NAME, JIKWI_NAME ,BASICPAY, SUDANG, (BASICPAY + SUDANG) FROM VIEW_EMP ORDER BY 2";
			break;
		case 3:
			// 부서 정렬 
			sql = "SELECT EMP_ID, EMP_NAME, SSN, TO_CHAR(IBSADATE,'YYYY-MM-DD') AS IBSADATE, CITY_NAME, TEL, BUSEO_NAME, JIKWI_NAME ,BASICPAY, SUDANG, (BASICPAY + SUDANG) FROM VIEW_EMP ORDER BY 7";
			break;
		case 4:
			// 직위 정렬 
			sql = "SELECT EMP_ID, EMP_NAME, SSN, TO_CHAR(IBSADATE,'YYYY-MM-DD') AS IBSADATE, CITY_NAME, TEL, BUSEO_NAME, JIKWI_NAME ,BASICPAY, SUDANG, (BASICPAY + SUDANG) FROM VIEW_EMP ORDER BY 8";
			break;
		case 5:
			// 급여 내림차순 정렬 
			sql = "SELECT EMP_ID, EMP_NAME, SSN, TO_CHAR(IBSADATE,'YYYY-MM-DD') AS IBSADATE, CITY_NAME, TEL, BUSEO_NAME, JIKWI_NAME ,BASICPAY, SUDANG, (BASICPAY + SUDANG) FROM VIEW_EMP ORDER BY (BASICPAY + SUDANG) DESC";
			break;
		}
		
		// 쿼리문 실행		
		ResultSet rs = stmt.executeQuery(sql);
		
		while (rs.next())
		{
			MemberDTO dto = new MemberDTO();
			
			dto.setEmpId(rs.getString("EMP_ID"));
			dto.setEmpName(rs.getString("EMP_NAME"));
			dto.setSsn(rs.getString("SSN"));
			dto.setIbsaDate(rs.getString("IBSADATE"));
			dto.setCityName(rs.getString("CITY_NAME"));
			dto.setTel(rs.getString("TEL"));
			dto.setBuseoName(rs.getString("BUSEO_NAME"));
			dto.setJikwiName(rs.getString("JIKWI_NAME"));
			dto.setBasicPay(rs.getInt("BASICPAY"));
			dto.setSudang(rs.getInt("SUDANG"));
			
			arrayList.add(dto);
		}
		
		// 리소스 반환	
		rs.close();
		stmt.close();
		
		return arrayList;
	}
	

	// 직원 검색 출력 메소드 (사번)
	public ArrayList<MemberDTO> researchId(String empId) throws SQLException
	{
		ArrayList<MemberDTO> arrayList = new ArrayList<MemberDTO>();
		
		// 작업 객체 생성
		Statement stmt = conn.createStatement();
		
		// 쿼리문 생성
		String sql = String.format("SELECT EMP_ID, EMP_NAME, SSN, TO_CHAR(IBSADATE,'YYYY-MM-DD') AS IBSADATE, CITY_NAME, TEL, BUSEO_NAME, JIKWI_NAME ,BASICPAY, SUDANG, (BASICPAY + SUDANG) FROM VIEW_EMP WHERE EMP_ID = %s", empId);
		
		// 쿼리문 실행 
		ResultSet rs = stmt.executeQuery(sql);	
		
		while (rs.next())
		{
			MemberDTO dto = new MemberDTO();
			
			dto.setEmpId(rs.getString("EMP_ID"));
			dto.setEmpName(rs.getString("EMP_NAME"));
			dto.setSsn(rs.getString("SSN"));
			dto.setIbsaDate(rs.getString("IBSADATE"));
			dto.setCityName(rs.getString("CITY_NAME"));
			dto.setTel(rs.getString("TEL"));
			dto.setBuseoName(rs.getString("BUSEO_NAME"));
			dto.setJikwiName(rs.getString("JIKWI_NAME"));
			dto.setBasicPay(rs.getInt("BASICPAY"));
			dto.setSudang(rs.getInt("SUDANG"));
			
			arrayList.add(dto);
		}
		
		
		// 리소스 반환
		rs.close();
		stmt.close();
		
		return arrayList;
	}
	
	// 직원 검색 출력 메소드 (이름)
	public ArrayList<MemberDTO> researchName(String name) throws SQLException
	{
		ArrayList<MemberDTO> arrayList = new ArrayList<MemberDTO>();
		
		// 작업 객체 생성 
		Statement stmt = conn.createStatement();
		// 쿼리문 생성
		String sql = String.format("SELECT EMP_ID, EMP_NAME, SSN, TO_CHAR(IBSADATE,'YYYY-MM-DD') AS IBSADATE, CITY_NAME, TEL, BUSEO_NAME, JIKWI_NAME ,BASICPAY, SUDANG, (BASICPAY + SUDANG) FROM VIEW_EMP WHERE EMP_NAME = '%s'", name);
		
		// 쿼리문 실행
		ResultSet rs = stmt.executeQuery(sql);
		
		while (rs.next())
		{
			MemberDTO dto = new MemberDTO();
			
			dto.setEmpId(rs.getString("EMP_ID"));
			dto.setEmpName(rs.getString("EMP_NAME"));
			dto.setSsn(rs.getString("SSN"));
			dto.setIbsaDate(rs.getString("IBSADATE"));
			dto.setCityName(rs.getString("CITY_NAME"));
			dto.setTel(rs.getString("TEL"));
			dto.setBuseoName(rs.getString("BUSEO_NAME"));
			dto.setJikwiName(rs.getString("JIKWI_NAME"));
			dto.setBasicPay(rs.getInt("BASICPAY"));
			dto.setSudang(rs.getInt("SUDANG"));
			
			arrayList.add(dto);
		}
		
		// 리소스 반환
		rs.close();
		stmt.close();
		
		return arrayList;
	}
	
	// 직원 검색 출력 메소드 (부서)
	public ArrayList<MemberDTO> researchBuseo(String buseo) throws SQLException
	{
		ArrayList<MemberDTO> arrayList = new ArrayList<MemberDTO>();

		// 작업 객체 생성 
		Statement stmt = conn.createStatement();
		
		// 쿼리문 생성
		String sql = String.format("SELECT EMP_ID, EMP_NAME, SSN, TO_CHAR(IBSADATE,'YYYY-MM-DD') AS IBSADATE, CITY_NAME, TEL, BUSEO_NAME, JIKWI_NAME ,BASICPAY, SUDANG, (BASICPAY + SUDANG) FROM VIEW_EMP WHERE BUSEO_NAME = '%s'", buseo);

		// 쿼리문 실행
		ResultSet rs = stmt.executeQuery(sql);

		while (rs.next())
		{
			MemberDTO dto = new MemberDTO();

			dto.setEmpId(rs.getString("EMP_ID"));
			dto.setEmpName(rs.getString("EMP_NAME"));
			dto.setSsn(rs.getString("SSN"));
			dto.setIbsaDate(rs.getString("IBSADATE"));
			dto.setCityName(rs.getString("CITY_NAME"));
			dto.setTel(rs.getString("TEL"));
			dto.setBuseoName(rs.getString("BUSEO_NAME"));
			dto.setJikwiName(rs.getString("JIKWI_NAME"));
			dto.setBasicPay(rs.getInt("BASICPAY"));
			dto.setSudang(rs.getInt("SUDANG"));

			arrayList.add(dto);
		}

		// 리소스 반환
		rs.close();
		stmt.close();

	 return arrayList;
	}
	
	// 직원 검색 출력 메소드 (직위)
	public ArrayList<MemberDTO> researchJikwi(String jikwi) throws SQLException
	{	
		ArrayList<MemberDTO> arrayList = new ArrayList<MemberDTO>();

		// 작업 객체 생성 
		Statement stmt = conn.createStatement();
		
		// 쿼리문 생성
		String sql = String.format("SELECT EMP_ID, EMP_NAME, SSN, TO_CHAR(IBSADATE,'YYYY-MM-DD') AS IBSADATE, CITY_NAME, TEL, BUSEO_NAME, JIKWI_NAME ,BASICPAY, SUDANG, (BASICPAY + SUDANG) FROM VIEW_EMP WHERE JIKWI_NAME = '%s'", jikwi);

		// 쿼리문 실행
		ResultSet rs = stmt.executeQuery(sql);

		while (rs.next())
		{
			MemberDTO dto = new MemberDTO();

			dto.setEmpId(rs.getString("EMP_ID"));
			dto.setEmpName(rs.getString("EMP_NAME"));
			dto.setSsn(rs.getString("SSN"));
			dto.setIbsaDate(rs.getString("IBSADATE"));
			dto.setCityName(rs.getString("CITY_NAME"));
			dto.setTel(rs.getString("TEL"));
			dto.setBuseoName(rs.getString("BUSEO_NAME"));
			dto.setJikwiName(rs.getString("JIKWI_NAME"));
			dto.setBasicPay(rs.getInt("BASICPAY"));
			dto.setSudang(rs.getInt("SUDANG"));

			arrayList.add(dto);
		}

		// 리소스 반환
		rs.close();
		stmt.close();
		
		return arrayList;
	}
	
	// 직원 정보 수정 메소드
	public int modify(MemberDTO dto) throws SQLException
	{
		int result = 0;
		
		// 작업 객체 생성
		Statement stmt = conn.createStatement();
		
		// 쿼리문 생성 
		String sql = String.format("UPDATE TBL_EMP SET EMP_NAME = '%s', SSN = '%s', IBSADATE = '%s' , CITY_ID = %s , TEL = '%s', BUSEO_ID = %s, JIKWI_ID = %s, BASICPAY = %d, SUDANG = %d WHERE EMP_ID = '%s'"
									,dto.getEmpName(),dto.getSsn(),dto.getIbsaDate()
									,dto.getCityId(),dto.getTel(),dto.getBuseoId(),dto.getJikwiId(),dto.getBasicPay(),dto.getSudang(),dto.getEmpId());
		
		// 쿼리문 실행
		result = stmt.executeUpdate(sql);
		
		// 리소스 반납
		stmt.close();
	
		return result;
	}
	// 직원 정보 삭제 메소드
	public int remove(String empId) throws SQLException
	{
		int result = 0;
		
		// 작업 객체 생성 
		Statement stmt = conn.createStatement();
		
		// 쿼리문 생성
		String sql = String.format("DELETE FROM TBL_EMP WHERE EMP_ID = %s", empId); 
				
		// 쿼리문 실행 
		result = stmt.executeUpdate(sql);
		
		// 리소스 반납
		stmt.close();
		
		return result;
	}

	// 지역 조회 메소드
	public ArrayList<MemberDTO> city() throws SQLException
	{
		ArrayList<MemberDTO> arrayList = new ArrayList<MemberDTO>();
		
		Statement stmt = conn.createStatement();
		
		String sql = "SELECT CITY_NAME , CITY_ID FROM TBL_CITY";
		
		ResultSet rs = stmt.executeQuery(sql);
		
		while (rs.next())
		{
			MemberDTO dto = new MemberDTO();
			
			dto.setCityName(rs.getString("CITY_NAME"));
			dto.setCityId(rs.getNString("CITY_ID"));
			
			arrayList.add(dto);		
		}
		
		return arrayList;
	}	
	
	// 지역 조회 메소드 오버로딩
	public ArrayList<MemberDTO> city(String city) throws SQLException
		{
			ArrayList<MemberDTO> arrayList = new ArrayList<MemberDTO>();
			
			Statement stmt = conn.createStatement();
			String sql = String.format("SELECT CITY_ID FROM TBL_CITY WHERE CITY_NAME = '%s' ", city);
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next())
			{
				MemberDTO dto = new MemberDTO();
				
				dto.setCityId(rs.getNString("CITY_ID"));
				
				arrayList.add(dto);		
			}
			
			return arrayList;
		}	
	
	// 부서 조회 메소드 
	public ArrayList<MemberDTO> buseo() throws SQLException
	{

		ArrayList<MemberDTO> arrayList = new ArrayList<MemberDTO>();
		
		Statement stmt = conn.createStatement();
		String sql = "SELECT BUSEO_ID , BUSEO_NAME FROM TBL_BUSEO";
		ResultSet rs = stmt.executeQuery(sql);
		
		while (rs.next())
		{
			MemberDTO dto = new MemberDTO();
			
			dto.setBuseoId(rs.getString("BUSEO_ID"));
			dto.setBuseoName(rs.getString("BUSEO_NAME"));
			
			arrayList.add(dto);		
		}
		
		rs.close();
		stmt.close();
		
		return arrayList;
	}
	
	// 부서 조회 오버로딩
	public ArrayList<MemberDTO> buseo(String buseo) throws SQLException
	{

		ArrayList<MemberDTO> arrayList = new ArrayList<MemberDTO>();
		
		Statement stmt = conn.createStatement();
		String sql = String.format("SELECT BUSEO_ID FROM TBL_BUSEO WHERE BUSEO_NAME = '%s'", buseo);
		ResultSet rs = stmt.executeQuery(sql);
		
		while (rs.next())
		{
			MemberDTO dto = new MemberDTO();
			
			dto.setBuseoId(rs.getString("BUSEO_ID"));
			
			arrayList.add(dto);		
		}
		
		rs.close();
		stmt.close();
		
		return arrayList;
	}
	
	// 직위 조회 메소드 
	public ArrayList<MemberDTO> jikwi() throws SQLException
	{

		ArrayList<MemberDTO> arrayList = new ArrayList<MemberDTO>();
		
		Statement stmt = conn.createStatement();
		String sql = "SELECT JIKWI_ID, JIKWI_NAME FROM TBL_JIKWI";
		ResultSet rs = stmt.executeQuery(sql);
		
		while (rs.next())
		{
			MemberDTO dto = new MemberDTO();
			
			dto.setJikwiId(rs.getString(1));
			dto.setJikwiName(rs.getString(2));
			
			arrayList.add(dto);		
		}
		
		rs.close();
		stmt.close();
		
		return arrayList;
	}

	
	//직위 조회 오버로딩
	public ArrayList<MemberDTO> jikwi(String jikwi) throws SQLException
	{
		ArrayList<MemberDTO> arrayList = new ArrayList<MemberDTO>();

		Statement stmt = conn.createStatement();
		String sql = String.format("SELECT MIN_BASICPAY, JIKWI_ID FROM TBL_JIKWI WHERE JIKWI_NAME = '%s'", jikwi);
		ResultSet rs = stmt.executeQuery(sql);

		while (rs.next())
		{
			MemberDTO dto = new MemberDTO();
			
			dto.setMinBasic(rs.getInt(1));
			dto.setJikwiId(rs.getString(2));
			
			arrayList.add(dto);		
		}

		rs.close();
		stmt.close();

		return arrayList;
	}
	
	// 데이터베이스 연결 해제 메소드
	public void close()
	{
		DBConn.close();
	}
	
	
}
