package com.tong.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.tong.util.DbConnection;

public class BookDao {
	public static int save(String callno,String name,String author,int quantity,int rest){
		int status=0;
		try{
			Connection con=DbConnection.getConn();
			PreparedStatement ps=con.prepareStatement("insert into books(callno,name,author,quantity,rest) values(?,?,?,?,?)");
			ps.setString(1,callno);
			ps.setString(2,name);
			ps.setString(3,author);
			ps.setInt(4,rest);
			ps.setInt(5,rest);
			status=ps.executeUpdate();
			con.close();
		}catch(Exception e){
			e.printStackTrace();
			System.out.println(e);
			}
		return status;
	}
public static int delete(String name){
	int status=0;
	try{
		Connection con=DbConnection.getConn();
		PreparedStatement ps=con.prepareStatement("delete from books where name=?");
		ps.setString(1,name);
		status=ps.executeUpdate();
		con.close();
	}catch(Exception e){
		e.printStackTrace();
		System.out.println(e);
	}
	return status;
}
}
