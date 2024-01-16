package com.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.util.DBConn;

public class ScoreDAO
{
	
	Connection conn;
	
	// 데이터베이스 연결 메소드
	public Connection connection()
	{
		conn = DBConn.getConnection();
		return conn;
	}
	
	// 성적 정보 입력 메소드
	public int insert(ScoreDTO dto)
	{
		int result = 0;
		
		try
		{
			// 쿼리문 생성 
			String sql = "INSERT INTO TBL_SCORE (SID,NAME,KOR,MAT,ENG) VALUES (SCORESEQ.NEXTVAL,?,?,?,?)";
			
			// 작업 객체 구성
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			// 작업 객체 실행?
			pstmt.setString(1,dto.getName());
			pstmt.setInt(2,dto.getKor());
			pstmt.setInt(3,dto.getEng());
			pstmt.setInt(4,dto.getMat());			
			
			result = pstmt.executeUpdate();
			
			// 리소스 반납
			pstmt.close();
			
		} catch (Exception e)
		{
			System.out.println(e.toString());
		}
		
		return result;
	}
	
	// 성적 전체 출력 메소드
	public ArrayList<ScoreDTO> lists()
	{
		ArrayList<ScoreDTO> arrayList = new ArrayList<ScoreDTO>();
		
		try
		{
			// 쿼리문 생성
			String sql = "SELECT SID, NAME,KOR,ENG,MAT"
					+ ",(KOR+ENG+MAT) AS TOT, (KOR+ENG+MAT)/3 AS AVG "
					+ ",RANK() OVER (ORDER BY (KOR+ENG+MAT) DESC) AS RANK FROM TBL_SCORE";
			// 작업 객체 생성
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			// 작업 객체 실행
			ResultSet rs = pstmt.executeQuery();
			while (rs.next())
			{
				ScoreDTO dto = new ScoreDTO();
				
				dto.setSid(rs.getInt("SID"));
				dto.setName(rs.getString("NAME"));
				dto.setKor(rs.getInt(3));
				dto.setEng(rs.getInt(4));
				dto.setMat(rs.getInt(5));
				dto.setTot(rs.getInt(6));
				dto.setAvg(rs.getDouble(7));
				dto.setRank(rs.getInt(8));
				
				arrayList.add(dto);				
			}
			
			// 리소스 반납
			rs.close();
			pstmt.close();
			
		} catch (Exception e)
		{
			System.out.println(e.toString());
		}
		
		return arrayList;
	}
	
	// 이름 검색 출력 메소드
	public ArrayList<ScoreDTO> searchList(String name)
	{
		ArrayList<ScoreDTO> arrayList = new ArrayList<ScoreDTO>();
		
		try
		{
			// 쿼리문 구성
			String sql = "SELECT SID, NAME,KOR,ENG,MAT, TOT, AVG , RANK"
					+ " FROM (SELECT SID, NAME,KOR,ENG,MAT,(KOR+ENG+MAT) AS TOT"
					+ ", (KOR+ENG+MAT)/3 AS AVG ,RANK() OVER (ORDER BY (KOR+ENG+MAT) DESC) AS RANK"
					+ " FROM TBL_SCORE)"
					+ " WHERE NAME = ?";
			
			// 작업 객체 생성
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			// 작업 객체 실행
			pstmt.setString(1, name);
			
			ResultSet rs = pstmt.executeQuery();
			while (rs.next())
			{
				ScoreDTO dto = new ScoreDTO();

				dto.setSid(rs.getInt("SID"));
				dto.setName(rs.getString("NAME"));
				dto.setKor(rs.getInt("KOR"));
				dto.setEng(rs.getInt("ENG"));
				dto.setMat(rs.getInt("MAT"));
				dto.setTot(rs.getInt("TOT"));
				dto.setAvg(rs.getDouble("AVG"));
				dto.setRank(rs.getInt("RANK"));

				arrayList.add(dto);		
			}
			
			// 리소스 반납
			rs.close();
			pstmt.close();
			
		} catch (Exception e)
		{
			System.out.println(e.toString());
		}
		return arrayList;
	}
	
	// 성적 정보 수정 메소드
	public int modify(ScoreDTO dto)
	{
		int result = 0;
		
		try
		{
			// 쿼리문 구성 
			String sql = "UPDATE TBL_SCORE SET NAME = ?,KOR = ?, ENG = ?, MAT = ? WHERE SID = ?";
			// 작업 객체 생성 
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			// 작업 객체 실행
			pstmt.setString(1, dto.getName());
			pstmt.setInt(2, dto.getKor());
			pstmt.setInt(3, dto.getEng());
			pstmt.setInt(4, dto.getMat());
			pstmt.setInt(5, dto.getSid());
			
			result = pstmt.executeUpdate();
			
			// 리소스 반납
			pstmt.close();
			
		} catch (Exception e)
		{
			System.out.println(e.toString());
		}
		
		return result;
	}
	
	// 성적 정보 삭제 메소드
	public int remove(int sid)
	{	
		int result = 0;
		try
		{
			//쿼리문 생성
			String sql = "DELETE FROM TBL_SCORE WHERE SID = ?";
			
			// 작업 객체 생성
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			// 작업 객체 실행
			pstmt.setInt(1, sid);
			result = pstmt.executeUpdate();
			
			// 리소스 반납
			pstmt.close();
			
		} catch (Exception e)
		{
			System.out.println(e.toString());
		}
		return result;
	}
	
	
	// 인원수 메소드 
	public int count()
	{
		int result = 0 ;
		
		try
		{
			// 쿼리문 생성
			String sql = "SELECT COUNT(*) AS COUNT FROM TBL_SCORE";
			// 작업 객체 생성
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			// 작업 객체 실행
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next())
				result = rs.getInt("COUNT");
			
			// 리소스 반납
			rs.close();
			pstmt.close();
			
		} catch (Exception e)
		{
			System.out.println(e.toString());
		}
		
		return result;
	}
	
	// 데이터베이스 연결 해제 메소드
	public void close()
	{
		DBConn.close();
	}
	
}
