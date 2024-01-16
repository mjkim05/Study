package com.test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.util.DBConn;

public class ScoreDAO
{
	Connection conn;
	
	// 데이터 베이스 연결 생성자
	public ScoreDAO() throws ClassNotFoundException, SQLException
	{
		conn = DBConn.getConnection();
	}
	
	// 입력 받은 값을 Score 테이블에 insert 하는 기능 메소드
	public int add(ScoreDTO dto) throws SQLException
	{
		// 값을 반환할 변수 생성
		int result;
		
		// 작업 객체 생성
		Statement stmt = conn.createStatement();
		
		// 쿼리문 생성
		String sql = String.format("INSERT INTO TBL_SCORE (SID,NAME,KOR,ENG,MAT) VALUES (SCORESEQ.NEXTVAL, '%s', %d, %d, %d)"
									,dto.getName(), dto.getKor() ,dto.getEng(), dto.getMat());
		// 쿼리문 실행
		result = stmt.executeUpdate(sql);
		
		// 값 반환
		return result;
	}
	
	// 인원수 조회하는 기능 메소드 
	public int count() throws SQLException
	{
		int result = 0;
		
		//작업 객체 생성
		Statement stmt = conn.createStatement();
		
		// 쿼리문 생성
		String sql = "SELECT COUNT(*) AS COUNT FROM TBL_SCORE";
		
		// 쿼리문 실행
		ResultSet rs = stmt.executeQuery(sql);
		
		while (rs.next())
		{
			result = rs.getInt(1); // 인덱스로 카운트 넣기!
		}

		// 리소스 반납
		rs.close();
		stmt.close();
	
		// 결과 반환
		return result;
	}

	// 전체 내용 출력하는 기능 메소드
	public ArrayList<ScoreDTO> print() throws SQLException
	{
		//반환할 변수 생성
		ArrayList<ScoreDTO> result = new ArrayList<ScoreDTO>();
		
		//작업 객체 생성
		Statement stmt = conn.createStatement();
		
		//쿼리문 생성
		String sql = "SELECT SID, NAME, KOR, ENG, MAT FROM TBL_SCORE";
		
		//쿼리문 실행
		ResultSet rs = stmt.executeQuery(sql);
		
		while (rs.next())
		{
			ScoreDTO dto = new ScoreDTO();
			
			dto.setSid(rs.getString(1));
			dto.setName(rs.getString(2));
			dto.setKor(rs.getInt(3));
			dto.setEng(rs.getInt(4));
			dto.setMat(rs.getInt(5));
			
			result.add(dto);
		}
		
		//결과반환
		return result;
	}
	
	
	//데이터베이스 연결 해제 하는 기능 메소드
	public void close()
	{
		DBConn.close();
	}
	
}


























