/* ==================================================
  	#12. PositionDAO.java
 	- 데이터베이스 액션 처리 클래스
 	- 직위 데이터 CRUD 액션
 	  (Create/Read/Update)
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

public class PositionDAO implements IPositionDAO
{
	
	// 인터페이스 자료형을 속성으로 구성
	private DataSource dataSource;

	// setter 구성
	public void setDataSource(DataSource dataSource)
	{
		this.dataSource = dataSource;
	}

	// 직위 데이터 조회
	@Override
	public ArrayList<Position> list() throws SQLException
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

	// 직위 데이터 추가(입력)
	@Override
	public int add(Position position) throws SQLException
	{
		int result = 0;
		Connection conn = dataSource.getConnection();
		
		String sql = "INSERT INTO POSITION(POSITIONID, POSITIONNAME, MINBASICPAY)"
				   + " VALUES(POSITIONSEQ.NEXTVAL, ?, ?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, position.getPositionName());
		pstmt.setInt(2, position.getMinBasicPay());
		
		result = pstmt.executeUpdate();
		
		pstmt.close();
		conn.close();
		
		return result;
	}

	// 직위 데이터 삭제
	@Override
	public int remove(String positionId) throws SQLException
	{
		int result = 0;
		Connection conn = dataSource.getConnection();
		
		String sql = "DELETE FROM POSITION WHERE POSITIONID = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, Integer.parseInt(positionId));
		
		result = pstmt.executeUpdate();
		
		pstmt.close();
		conn.close();
		
		return result;
	}

	// 직위 데이터 변경(수정)
	@Override
	public int modify(Position position) throws SQLException
	{
		int result = 0;
		Connection conn = dataSource.getConnection();
		
		String sql = "UPDATE POSITION SET POSITIONNAME = ?, MINBASICPAY=? WHERE POSITIONID =?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, position.getPositionName());
		pstmt.setInt(2, position.getMinBasicPay());
		pstmt.setInt(3, Integer.parseInt(position.getPositionId()));
		
		result = pstmt.executeUpdate();
		
		pstmt.close();
		conn.close();
		
		return result;
	}
    
	
	
   
   
}
