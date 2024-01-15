/* ==================================================
  	#10. DepartmentDAO.java
 	- 데이터베이스 액션 처리 클래스
 	- 부서 데이터 CRUD 액션
 	  (Create/Read/Updaye)
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

public class DepartmentDAO implements IDepartmentDAO
{	
	// 인터페이스 자료형을 속성으로 구성
	private DataSource dataSource;

	//setter 구성
	public void setDataSource(DataSource dataSource)
	{
		this.dataSource = dataSource;
	}

	// 부서 전체 데이터 조회
	@Override
	public ArrayList<Department> list() throws SQLException
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

	// 부서 데이터 등록(추가, 입력)
	@Override
	public int add(Department department) throws SQLException
	{
		int result =0;
		
		Connection conn = dataSource.getConnection();
		
		String sql = "INSERT INTO DEPARTMENT(DEPARTMENTID,DEPARTMENTNAME)"
				  + " VALUES(DEPARTMENTSEQ.NEXTVAL,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, department.getDepartmentName());
		
		result = pstmt.executeUpdate();
		
		pstmt.close();
		conn.close();
		
		return result;
	}

	// 부서 데이터 삭제
	@Override
	public int remove(String departmentId) throws SQLException
	{
		int result =0;
		
		Connection conn = dataSource.getConnection();
		String sql = "DELETE FROM DEPARTMENT WHERE DEPARTMENTID=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, Integer.parseInt(departmentId));
		
		result = pstmt.executeUpdate();
		pstmt.close();
		conn.close();
		
		return result;
	}

	// 부서 데이터 수정
	@Override
	public int modify(Department department) throws SQLException
	{
		int result = 0;
		
		Connection conn = dataSource.getConnection();
		String sql ="UPDATE DEPARTMENT SET DEPARTMENTNAME = ? WHERE DEPARTMENTID =?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, department.getDepartmentName());
		pstmt.setInt(2, Integer.parseInt(department.getDepartmentId()));
		
		result = pstmt.executeUpdate();
		
		pstmt.close();
		conn.close();
		
		return result;
	}
	
	

}
