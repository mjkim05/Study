/* ==================================================
  	#09. EmployeeDAO.java
 	- 데이터베이스 액션 처리 클래스
 	- 직원 데이터 CRUD 액션
 	  (Create/Read/Update/Delete)
 	- Connection 객체에 대한 의존성 주입을 위한 준비 
 	  → 인터페이스 형태의 속성 구성(DataSource)
 	  → setter 구성
 ===================================================*/

package com.test.mvc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

public class EmployeeDAO implements IEmployeeDAO
{	
	// 주요 속성 구성 → 인터페이스 구성
	private DataSource dataSource;

	// setter 구성
	public void setDataSource(DataSource dataSource)
	{
		this.dataSource = dataSource;
	}

	// 직원 리스트
	@Override
	public ArrayList<Employee> list() throws SQLException
	{
		ArrayList<Employee> result = new ArrayList<Employee>();
		Connection conn = dataSource.getConnection();
		
		String sql = "SELECT EMPLOYEEID, NAME, SSN, BIRTHDAY,LUNAR,LUNARNAME, TELEPHONE"
				+ ", DEPARTMENTID, DEPARTMENTNAME, POSITIONID, POSITIONNAME"
				+ ", REGIONID, REGIONNAME, BASICPAY,EXTRAPAY,PAY,GRADE FROM EMPLOYEEVIEW"
				+ " ORDER BY EMPLOYEEID";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next())
		{
			Employee emp = new Employee();
			
			emp.setEmployeeId(rs.getString("EMPLOYEEID"));
			emp.setName(rs.getString("NAME"));
			emp.setSsn(rs.getString("SSN"));
			emp.setBirthday(rs.getString("BIRTHDAY"));
			emp.setLunar(rs.getInt("LUNAR"));
			emp.setLunarName(rs.getString("LUNARNAME"));
			emp.setTelephone(rs.getString("TELEPHONE"));
			emp.setDepartmentId(rs.getString("DEPARTMENTID"));
			emp.setDepartmentName(rs.getString("DEPARTMENTNAME"));
			emp.setPositionId(rs.getString("POSITION"));
			emp.setPositionName(rs.getString("POSITIONNAME"));
			emp.setRegionId(rs.getString("REGIONID"));
			emp.setRegionName(rs.getString("REGIONNAME"));
			emp.setBasicPay(rs.getInt("BASICPAY"));
			emp.setExtraPay(rs.getInt("EXTRAPAY"));
			emp.setPay(rs.getInt("PAY"));
			emp.setGrade(rs.getInt("GRADE"));
			
			result.add(emp);			
			
		}
		
		rs.close();
		pstmt.close();
		conn.close();
		return result;		
		
	}

	// 지역 리스트
	@Override
	public ArrayList<Region> regionList() throws SQLException
	{
		ArrayList<Region> result = new ArrayList<Region>();
		
		Connection conn = dataSource.getConnection();
		
		String sql = "SELECT REGIONID, REGIONNAME, DELCHECK FROM REGIONVIEW";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next())
		{
			Region reg = new Region();
			
			reg.setRegionId(rs.getString("REGIONID"));
			reg.setRegionName(rs.getString("REGIONNAME"));
			reg.setDelCheck(rs.getInt("DELCHECK"));
			
			result.add(reg);
		}
		
		rs.close();
		pstmt.close();
		conn.close();
		
		return result;
	}
	
	// 부서 리스트
	@Override
	public ArrayList<Department> departmentList() throws SQLException
	{
		ArrayList<Department> result = new ArrayList<Department>();
		
		Connection conn = dataSource.getConnection();
		String sql = "SELECT DEPARTMENTID, DEPARTMENTNAME, DELCHECK FROM DEPARTMENTVIEW";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next())
		{
			Department dep = new Department();
			dep.setDepartmentId(rs.getString("DEPARTMENTID"));
			dep.setDepartmentName(rs.getString("DEPARTMENTNAME"));
			dep.setDelCheck(rs.getInt("DELCHECK"));
			
			result.add(dep);
		}
		rs.close();
		pstmt.close();
		conn.close();
		
		return result;
	}

	// 직위 리스트
	@Override
	public ArrayList<Position> positionList() throws SQLException
	{
		ArrayList<Position> result = new ArrayList<Position>();
		
		Connection conn = dataSource.getConnection();
		String sql = "SELECT POSITIONID, POSITIONNAME,MINBASICPAY, DELCHECK FROM POSITIONVIEW";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next())
		{
			Position pos = new Position();
			
			pos.setPositionId(rs.getString("POSITIONID"));
			pos.setPositionName(rs.getString("POSITIONNAME"));
			pos.setMinBasicPay(rs.getInt("MINBASICPAY"));
			pos.setDelCheck(rs.getInt("DELCHECK"));
			
			result.add(pos);
		}
		rs.close();
		pstmt.close();
		conn.close();
		
		return result;
	}

	// 
	@Override
	public int getMinBasicPay(String positionId) throws SQLException
	{
		int result = 0;
		
		Connection conn = dataSource.getConnection();
		
		String sql = "SELECT MINBASICPAY FROM POSITION WHERE POSITIONID = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, Integer.parseInt(positionId));
		ResultSet rs = pstmt.executeQuery();
		
		if (rs.next())
			result = rs.getInt("MINBASICPAY");
		
		rs.close();
		pstmt.close();
		conn.close();

		return result;
	}

	// 직원 데이터 추가
	@Override
	public int employeeAdd(Employee employee) throws SQLException
	{
		int result = 0;
		
		Connection conn = dataSource.getConnection();
		String sql = "INSERT INTO EMPLOYEE(EMPLOYEEID, NAME, BIRTHDAY, LUNAR, TELEPHONE"
				+ ", DEPARTMENTID, POSITIONID, REGIONID, BASICPAY, EXTRAPAY, SSN1, SSN2)"
				+ "	  VALUES (EMPLOYEESEQ.NEXTVAL,?,TO_DATE(?,'YYYY-MM-DD'),?,?"
				+ "	 ,?,?,?,?,?,?,CRYPTPACK.ENCRYPT(?,?))";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, employee.getName());
		pstmt.setString(2, employee.getBirthday());
		pstmt.setInt(3,employee.getLunar());
		pstmt.setString(4, employee.getTelephone());
		pstmt.setInt(5, Integer.parseInt(employee.getDepartmentId()));
		pstmt.setInt(6, Integer.parseInt(employee.getPositionId()));
		pstmt.setInt(7, Integer.parseInt(employee.getRegionId()));
		pstmt.setInt(8,employee.getBasicPay());
		pstmt.setInt(9, employee.getExtraPay());
		pstmt.setString(10, employee.getSsn1());
		pstmt.setString(11, employee.getSsn2());
		pstmt.setString(12, employee.getSsn2());
		
		result = pstmt.executeUpdate();
		pstmt.close();
		conn.close();
		
		return result;
	}

	// 직원 데이터 삭제
	@Override
	public int remove(String employeeId) throws SQLException
	{
		int result = 0;
		
		Connection conn = dataSource.getConnection();
		String sql = "DELETE FROM EMPLOYEE WHERE EMPLOYEEID = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, Integer.parseInt(employeeId));
		
		result = pstmt.executeUpdate();
		
		pstmt.close();
		conn.close();
		
		return result;
	}

	// 직원 데이터 수정
	@Override
	public int modify(Employee employee) throws SQLException
	{
		int result = 0;
		
		Connection conn = dataSource.getConnection();
		String sql = "UPDATE EMPLOYEE SET NAME=?,BIRTHDAY=TO_DATE(?,'YYYY-MM-DD')"
				  + ",LUNAR=?,TELEPHONE=?,DEPARTMENTID =?,POSITIONID =?,REGIONID=?"
				  + ",BASICPAY=?,EXTRAPAY=?,SSN1=?"
				  + ",SSN2=CRYPTPACK.ENCRYPT(?,?)"
				  + ",WHERE EMPLOYEEID = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, employee.getName());
		pstmt.setString(2, employee.getBirthday());
		pstmt.setInt(3, employee.getLunar());
		pstmt.setString(4, employee.getTelephone());
		pstmt.setInt(5, Integer.parseInt(employee.getDepartmentId()));
		pstmt.setInt(6, Integer.parseInt(employee.getPositionId()));
		pstmt.setInt(7, Integer.parseInt(employee.getRegionId()));
		pstmt.setInt(8,employee.getBasicPay());
		pstmt.setInt(9, employee.getExtraPay());
		pstmt.setString(10, employee.getSsn1());
		pstmt.setString(11, employee.getSsn2());
		pstmt.setString(12, employee.getSsn2());
		pstmt.setInt(13, Integer.parseInt(employee.getEmployeeId()));
		
		result = pstmt.executeUpdate();
		
		pstmt.close();
		conn.close();
		
		return result;
	}

	// 아이디로 직원 검색
	@Override
	public Employee searchId(String employeeId) throws SQLException
	{
		Employee result = new Employee();
		
		Connection conn = dataSource.getConnection();
		
		String sql = "SELECT EMPLOYEEID, NAME, SSN1 ,TO_CHAR(BIRTHDAY,'YYYY-MM-DD') AS BIRTHDAY"
				 + " ,LUNAR, TELEPHONE, DEPARTMENTID, POSITIONID, REGIONID"
				 + ", BASICPAY, EXTRAPAY FROM EMPLOYEE WHERE EMPLOYEEID=?";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, Integer.parseInt(employeeId));
		ResultSet rs = pstmt.executeQuery();
		
		if (rs.next())
		{
			result.setEmployeeId(rs.getString("EMPLOYEEID"));
			result.setName(rs.getString("NAME"));
			result.setSsn1(rs.getString("SSN1"));
			result.setBirthday(rs.getString("BIRTHDAY"));
			result.setLunar(rs.getInt("LUNAR"));
			result.setTelephone(rs.getString("TELEPHONE"));
			result.setDepartmentId(rs.getString("DEPARTMENTID"));
			result.setPositionId(rs.getString("POSITIONID"));
			result.setRegionId(rs.getString("REGIONID"));
			result.setBasicPay(rs.getInt("BASICPAY"));
			result.setExtraPay(rs.getInt("EXTRAPAY"));
		}
		
		rs.close();
		pstmt.close();
		conn.close();
		
		return result;
	}

	// 일반 직원 로그인
	@Override
	public String login(String id, String pw) throws SQLException
	{
		//String result = "";
		String result = null;
		
		Connection conn = dataSource.getConnection();
		
		String sql = "SELECT NAME FROM EMPLOYEE WHERE EMPLOYEEID=?"
			       + " AND SSN2 = CRYPTPACK.ENCRYPT(?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, Integer.parseInt(id));
		pstmt.setString(2, pw);
		pstmt.setString(3, pw);
		
		ResultSet rs = pstmt.executeQuery();
		
		if(rs.next())
			result = rs.getString("NAME");
		
		rs.close();
		pstmt.close();
		conn.close();
		
		return result;
	}
	
	// 관리자 로그인
	@Override
	public String loginAdmin(String id, String pw) throws SQLException
	{
		//String result = "";
		String result = null;
		
		Connection conn = dataSource.getConnection();
		
		String sql = "SELECT NAME FROM EMPLOYEE WHERE EMPLOYEEID=?"
				  + " AND SSN2 = CRYPTPACK.ENCRYPT(?,?) AND GRADE = 0";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, Integer.parseInt(id));
		pstmt.setString(2, pw);
		pstmt.setString(3, pw);
		
		ResultSet rs = pstmt.executeQuery();
		
		if(rs.next())
			result = rs.getString("NAME");
		
		rs.close();
		pstmt.close();
		conn.close();
		return result;
	}
	
	
	
	
	
}
