package com.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.util.DBConn;

public class ScoreDAO
{
	private Connection conn;
	
	public ScoreDAO() throws ClassNotFoundException, SQLException
	{
		conn = DBConn.getConnection();
	}
	
	// 성적 입력 메소드
	public int add(ScoreDTO dto) throws SQLException
	{
		int result =0;
		
		// 쿼리문 구성
		String sql = "INSERT INTO TBL_SCORE(SID, NAME, KOR,ENG,MAT) VALUES(SCORESEQ.NEXTVAL,?,?,?,?)";
		
		// 작업 객체 생성 
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, dto.getName());
		pstmt.setInt(2, dto.getKor());
		pstmt.setInt(3, dto.getEng());
		pstmt.setInt(4, dto.getMat());
		
		result = pstmt.executeUpdate();
		
		if (result >= 1)
			System.out.println("입력이 완료 되었습니다.");
		else
			System.out.println("입력 실패ㅠ");
		
		// 리소스 반납
		pstmt.close();
		
		return result;
	}
	
	
	// 성적 출력 메소드 
	public ArrayList<ScoreDTO> lists() throws SQLException
	{
		ArrayList<ScoreDTO> result = new ArrayList<ScoreDTO>();
		
		// 쿼리문 구성
		String sql = "SELECT SID, NAME, KOR, ENG, MAT, (KOR+ENG+MAT) AS TOT, (KOR+ENG+MAT)/3 AS AVG FROM TBL_SCORE ORDER BY SID";
		
		// 작업 객체 생성
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		// 실행 
		while (rs.next())
		{
			ScoreDTO dto = new ScoreDTO();
			
			dto.setSid(rs.getString("SID"));
			dto.setName(rs.getString("NAME"));
			dto.setKor(rs.getInt("KOR"));
			dto.setEng(rs.getInt("ENG"));
			dto.setMat(rs.getInt("MAT"));
			dto.setAvg(rs.getDouble("AVG"));
			dto.setTot(rs.getInt("TOT"));
			
			result.add(dto);
				
		}
	
		// 리소스 반납
		rs.close();
		pstmt.close();
		
		return result;
	}
	
	
	// 인원수 확인 메소드
	public int count() throws SQLException
	{
		int result =0;
		
		// 쿼리문 구성
		String sql = "SELECT COUNT(*) AS COUNT FROM TBL_SCORE";
		
		// 작업 객체 생성
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		// 실행
		if (rs.next())
			result = rs.getInt("COUNT");
		
		// 리소스 반납
		rs.close();
		pstmt.close();
		
		return result;
	}
	
	
	
	
	// 데이터베이스 종료 메소드
	public void close() throws SQLException
	{
		DBConn.close();
	}
	
	
	
}
