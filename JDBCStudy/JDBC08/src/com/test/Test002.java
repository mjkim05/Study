/* ==================================================
	Test002.java
 	- CallableStatement 를 활용한 SQL 구문 전송 실습
 ===================================================*/

package com.test;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

import com.util.DBConn;

import oracle.jdbc.internal.OracleTypes;

public class Test002
{
	public static void main(String[] args)
	{
		try
		{
			Connection conn = DBConn.getConnection();
			
			if (conn != null)
			{
				System.out.println("데이터베이스 연결 성공~~!!!");
				
				try
				{
					// 쿼리문 준비 
					String sql = "{call PRC_MEMBERSELECT(?)}";
					
					// CallableStatement 작업 객체 생성
					CallableStatement cstmt = conn.prepareCall(sql);
					
					// check~~!!
					// 프로시저 내부에서 『sys_refcursor 』 를 사용하고 있기 때문에 
					// orcalTypes.CURSOR 를 사용하기 위한 등록과정이 필요한 상황.
					// 1. Project Explorer 상에서 해당 프로젝트 (JDBC08) 마우스 우클릭.
					// 2. Build path > configure Build Path 클릭.
					// 3. Libraries 클릭
					// 4. 우측 Add External JAR 버튼 클릭
					// 5. 『ojdbc6.jar』 파일 추가 등록 (외부 jar 파일 연결)
					// 6. 『import oracle.jdbc.OracleTypes; 』 구문 추가 등록
					cstmt.registerOutParameter(1, OracleTypes.CURSOR);
					cstmt.execute();		// 커서의 안전성이 위협받을 수 있기때문에 이걸 사용
					ResultSet rs = (ResultSet)cstmt.getObject(1);
					
					while (rs.next())
					{
						String sid = rs.getString("SID");
						String name = rs.getString("NAME");
						String tel = rs.getString("TEL");
						
						String str = String.format("%3s %7s %12s", sid, name, tel);
						
						System.out.println(str);
					}
					rs.close();
					cstmt.close();
					
				} catch (Exception e)
				{
					System.out.println(e.toString());
				}
			}
			
			DBConn.Close();
			
			System.out.println("\n데이터베이스 연결 닫힘~!!");
			System.out.println("프로그램 종료됨~!!");
			
		} catch (Exception e)
		{
			System.out.println(e.toString());
		}
	}
}

// 실행 결과 
/*
데이터베이스 연결 성공~~!!!
  1     김다슬 010-1111-1111
  2     김경태 010-2222-2222
  3     오수경 010-3333-3333
  4     박범구 010-4444-4444

데이터베이스 연결 닫힘~!!
프로그램 종료됨~!!
 */
