package com.tong.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection{
	private static Connection conn = null;
	public static Connection getConn() {
	try {
		Class.forName("com.mysql.jdbc.Driver");
	}catch(ClassNotFoundException e) {
		e.printStackTrace();
	}
	String url = "jdbc:mysql://localhost:3306/db_library?useSSL=false";
	String user = "root";
	String password = "root";
	try {
		conn = DriverManager.getConnection(url, user, password);
		if(conn != null) {
			System.out.println("数据库连接成功XD");
		}
	}catch(SQLException e) {
		e.printStackTrace();
	}
	return conn;
}
}