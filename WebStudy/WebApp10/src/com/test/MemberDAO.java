/* =========================================
   MemberDAO.java 
   - 데이터베이스 액션 처리 전용 객체 활용
 ============================================*/

package com.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.util.DBConn;

public class MemberDAO
{
	// 주요 속성 구성
	private Connection conn;
	
	// 데이터베이스 연결 → 생성자 형태로 정의
	public MemberDAO() throws ClassNotFoundException, SQLException
	{
		conn = DBConn.getConnection();
	}
	
	// 데이터 입력 메소드 정의
	public int add(MemberDTO dto) throws SQLException
	{
		int result = 0;
		
		// 쿼리문 구성
		//String sql = String.format("INSERT INTO TBL_MEMBER(SID, NAME, TEL) VALUES(MEMBERSEQ.NEXTVAL, '%s', '%s')"
		//			,dto.getName(), dto.getTel());
		// 작업 객체 생성 및 실행
		//Statement stmt = conn.createStatement();
		//result = stmt.executeUpdate(sql);
		
		String sql = "INSERT INTO TBL_MEMBER(SID, NAME, TEL) VALUES(MEMBERSEQ.NEXTVAL, ?, ?)";

		PreparedStatement pstmt = conn.prepareStatement(sql); 
		result = pstmt.executeUpdate();
		 
		pstmt.setString(1, dto.getName());
		pstmt.setString(2, dto.getTel());

		
		if (result >= 1)
			System.out.println("입력이 완료 되었습니다!");
		else 
			System.out.println("입력된 값이 없습니다.");
		// 리소스 반납
		pstmt.close();
		//stmt.close();
		
		return result;
		
	}
	
	// 리스트 출력 메소드 정의
	public ArrayList<MemberDTO> lists() throws SQLException
	{
		ArrayList<MemberDTO> arr = new ArrayList<MemberDTO>();
		
		// 쿼리문 구성
		String sql = "SELECT SID , NAME , TEL FROM TBL_MEMBER ORDER BY SID";

		// 작업 객체 생성 및 실행
		//Statement stmt = conn.createStatement();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next())
		{
			MemberDTO dto = new MemberDTO();
			
			dto.setSid(rs.getString("SID"));
			dto.setName(rs.getString("NAME"));
			dto.setTel(rs.getString("TEL"));
			
			arr.add(dto);
		}
		// 리소스 반납
		rs.close();
		pstmt.close();
		
		return arr;
	}
	
	// 인원수 확인을 위한 메소드 정의
	public int count() throws SQLException
	{
		int result =0;
		
		// 쿼리문 구성
		String sql = "SELECT COUNT(*) AS COUNT FROM TBL_MEMBER";
		// 작업 객체 생성 및 실행
		//Statement stmt = conn.createStatement();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();

		//while (rs.next())
		//	result = rs.getInt("COUNT");
		
		if (rs.next())
			result = rs.getInt("COUNT");
		
		// 리소스 반납
		rs.close();
		pstmt.close();

		return result;
	}
	
	// 데이터베이스 연결 종료 담당 메소드
	public void close() throws SQLException
	{
		DBConn.close();
	}

	
	
}
