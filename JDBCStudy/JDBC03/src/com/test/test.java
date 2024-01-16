package com.test;

import java.sql.Connection;

import com.util.DBConn;

public class test
{
	public static void main(String[] args)
	{
		Connection conn = DBConn.getConnection();
		
		if (conn != null)
		{
			System.out.println("성공^_^");
		}
	}
}
