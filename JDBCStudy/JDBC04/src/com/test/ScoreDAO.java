/* ======================================
 	ScoreDAO.java
 	- 데이터베이스 액션 처리 전용 객체
 ======================================== */

package com.test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.util.DBConn;

public class ScoreDAO
{
	// 주요 속성 구성
	private Connection conn;
	
	// 데이터베이스 연결 담당 메소드
	public Connection connection() throws ClassNotFoundException, SQLException
	{
		conn = DBConn.getConnection();
		return conn;
	}
	
	// 데이터 입력 담당 메소드
	public int add(ScoreDTO dto) throws SQLException
	{
		int result = 0;
		
		// 작업 객체 생성
		Statement stmt = conn.createStatement();
		
		// 쿼리문 생성
		String sql = String.format("INSERT INTO TBL_SCORE(SID,NAME,KOR,ENG,MAT) VALUES(SCORESEQ.NEXTVAL,'%s',%d,%d,%d)",dto.getName(), dto.getKor(),dto.getEng(),dto.getMat());
		
		// 쿼리문 실행
		result = stmt.executeUpdate(sql);
		
		// 리소스 반납
		stmt.close();
		
		return result;
	}
	
	// 전체 리스트 출력 담당 메소드
	public ArrayList<ScoreDTO> lists() throws SQLException
	{
		ArrayList<ScoreDTO> result = new ArrayList<ScoreDTO>();
		
		// 작업 객체 생성
		 Statement stmt  = conn.createStatement();
		
		// 쿼리문 생성 
		String sql = "SELECT  SID, NAME, KOR,ENG,MAT ,(KOR + ENG + MAT) AS TOT ,(KOR + ENG + MAT)/3 AS AVG ,RANK() OVER(ORDER BY (KOR + ENG + MAT) DESC) AS RANK FROM TBL_SCORE ORDER BY SID ASC"; 
				
		// 쿼리문 실행
		ResultSet rs = stmt.executeQuery(sql);
		
		while (rs.next())
		{
			ScoreDTO dto = new ScoreDTO();
			
			dto.setSid(rs.getString(1));
			dto.setName(rs.getString(2));
			dto.setKor(rs.getInt(3));
			dto.setEng(rs.getInt(4));
			dto.setMat(rs.getInt(5));
			dto.setTot(rs.getInt(6));
			dto.setAvg(rs.getDouble(7));
			dto.setRank(rs.getInt(8));
			
			result.add(dto);
		}
		
		// ★ 리소스 반납 ★
		rs.close();
		stmt.close();
		
		return result;
	}
	
	// 이름 검색 담당 메소드
	public ArrayList<ScoreDTO> lists(String name) throws SQLException
	{
		ArrayList<ScoreDTO> result = new ArrayList<ScoreDTO>();
		
		// 작업 객체 생성 
		Statement stmt = conn.createStatement();

		// 쿼리문 생성 
		String sql = String.format("SELECT SID, NAME, KOR, ENG, MAT, TOT, AVG, RANK FROM(SELECT SID, NAME, KOR, ENG, MAT, (KOR+ENG+MAT) AS TOT, (KOR+ENG+MAT)/3 AS AVG, RANK() OVER(ORDER BY (KOR+ENG+MAT) DESC) AS RANK FROM TBL_SCORE) WHERE NAME = '%s'"
									, name);
		
		// 쿼리문 실행 
		ResultSet rs = stmt.executeQuery(sql);
		
		while (rs.next())
		{
			ScoreDTO dto = new ScoreDTO();
			
			dto.setSid(rs.getString("SID"));
			dto.setName(rs.getString("NAME"));
			dto.setKor(rs.getInt("KOR"));
			dto.setEng(rs.getInt("ENG"));
			dto.setMat(rs.getInt("MAT"));
			dto.setTot(rs.getInt("TOT"));
			dto.setAvg(rs.getDouble("AVG"));
			dto.setRank(rs.getInt("RANK"));
			
			result.add(dto);
		}
		
		// 리소스 반납
		rs.close();
		stmt.close();
		
		return result;
	}
	
	// 번호 검색 담당 메소드
	public ArrayList<ScoreDTO> lists(int sid) throws SQLException
	{
		ArrayList<ScoreDTO> result = new ArrayList<ScoreDTO>();
		
		// 작업 객체 생성
		Statement stmt = conn.createStatement();
		
		// 쿼리문 생성
		String sql = String.format("SELECT SID, NAME,KOR,ENG,MAT,TOT,AVG,RANK FROM (SELECT SID, NAME, KOR, ENG, MAT, (KOR+ENG+MAT) AS TOT,  (KOR+ENG+MAT)/3 AS AVG, RANK() OVER(ORDER BY (KOR+ENG+MAT) DESC) AS RANK FROM TBL_SCORE) WHERE SID = %d" 
							, sid);
		
		// 쿼리문 실행 
		ResultSet rs = stmt.executeQuery(sql);
		
		while (rs.next())
		{
			ScoreDTO dto = new ScoreDTO();
			
			dto.setSid(rs.getString(1));
			dto.setName(rs.getString(2));
			dto.setKor(rs.getInt(3));
			dto.setEng(rs.getInt(4));
			dto.setMat(rs.getInt(5));
			dto.setTot(rs.getInt(6));
			dto.setAvg(rs.getDouble(7));
			dto.setRank(rs.getInt(8));
			
			result.add(dto);
		}
	
		
		// 리소스 반납
		rs.close();
		stmt.close();

		return result;
	}
	
	// 인원 수 확인 담당 메소드
	public int count() throws SQLException
	{
		int result = 0; 
		
		// 작업 객체 생성
		Statement stmt = conn.createStatement();
		
		// 쿼리문 생성
		String sql = "SELECT COUNT(*) AS COUNT FROM TBL_SCORE";
		
		// 쿼리문 실행
		 ResultSet rs = stmt.executeQuery(sql);
		 
		 while (rs.next())
			 result = rs.getInt(1);		// result = rs.getInt("COUNT");
	
		 // 리소스 반납
		 rs.close(); 
		 stmt.close();

		return result;
	}
	
	// 데이터 수정 담당 메소드 → 매개변수의 유형 check~~!!! (수정되는 내용을 매개변수로 넘겨줌!!)
	public int modify(ScoreDTO dto) throws SQLException
	{
		int result = 0;
		
		// 작업 객체 생성 
		Statement stmt = conn.createStatement();
		
		// 쿼리문 생성
		String sql = String.format("UPDATE TBL_SCORE SET NAME = '%s', KOR = %d, ENG = %d, MAT = %d WHERE SID = %s"
								 , dto.getName(), dto.getKor(),dto.getEng(), dto.getMat(),dto.getSid());
		
		// 쿼리문 실행
		result = stmt.executeUpdate(sql);
		
		// 리소스 반납
		stmt.close();
		
		return result;
	}
	
	// 데이터 삭제 담당 메소드
	public int remove(int sid) throws SQLException
	{
		int result = 0;
		
		// 작업 객체 생성
		Statement stmt = conn.createStatement();
		
		// 쿼리문 생성 
		String sql = String.format("DELETE FROM TBL_SCORE WHERE SID = %d", sid);
		
		// 쿼리문 실행
		result = stmt.executeUpdate(sql);
		
		// 리소스 반납
		stmt.close();
		
		return result;
	}
	
	// 데이터베이스 연결 종료 담당 메소드
	public void Close() throws SQLException
	{
		DBConn.close();
	}
	
}


















