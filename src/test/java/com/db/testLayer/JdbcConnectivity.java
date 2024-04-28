package com.db.testLayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class JdbcConnectivity {

	public static void main(String[] args) throws Exception {
//		Class.forName("com.sqlserver.jdbc.Driver");
		
		String url = "jdbc:sqlserver://DELL\\SQLEXPRESS/master;TCPENABLED=0";
		
//		String username = "root";
		
//		String password = "MySQL@3306";
		
		Connection connection = DriverManager.getConnection(url);
		
		String sql = "select*from EMPLOYEE";
		ResultSet r = connection.createStatement().executeQuery(sql); 
		int cc = r.getMetaData().getColumnCount(); 
		System.out.println(cc);
		System.out.println("============================================");
		for (int i = 1; i <= cc; i++) 
		{
			String cn = r.getMetaData().getColumnName(i); 
			System.out.print(cn + "|");
		}
		System.out.println();
		System.out.println("--------------------------------------------");
		while (r.next()) 
		{
			for (int i = 1; i <= cc; i++) 
			{ 
				String v = 
				r.getString(i);
				System.out.print(v+"	  ");
			}
			System.out.println();
			System.out.println("-----------------------------------------");
		
		connection.close();

	}
		
	}

}
