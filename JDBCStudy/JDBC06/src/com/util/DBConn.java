/* ===========================
  DBConn.java
  - 예외처리 : try ~ catch 
 =============================*/


package com.util;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;

public class DBConn
{
	private static Connection dbConn;
	
	public static Connection getConnection()
	{
		if (dbConn == null)
		
			try
			{
				String url = "jdbc:oracle:thin:@localhost:1521:xe";
				String user = "scott";
				String pwd = "tiger";
				
				Class.forName("oracle.jdbc.driver.OracleDriver");
				dbConn = DriverManager.getConnection(url,user,pwd);
				
			} catch (Exception e)
			{
					System.out.println(e.toString());
			}
		
		return dbConn;
	}
	
	public static Connection getConnection(String url, String user, String pwd)
	{
		if (dbConn == null)
		
			try
			{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				dbConn = DriverManager.getConnection(url,user,pwd);
				
			} catch (Exception e)
			{
				// TODO: handle exception
			}
		
		return dbConn;
			
	}
	
	public static void close()
	{
			
		try
		{
			if (dbConn != null)
			{
				if(!dbConn.isClosed())
				{
					dbConn.close();
				}
			}
			
		} catch (Exception e)
		{
			System.out.println(e.toString());
		}
		
		dbConn = null;
	}
	
	
	
}















