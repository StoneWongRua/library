package com.tong.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.tong.util.DbConnection;

public class BooksBorrowDao {
public static int save(String name,String author,String locate,int quantity, int rest){
	int status=0;
	try{
		Connection con=DbConnection.getConn();
		PreparedStatement ps=con.prepareStatement("insert into borrowbook(callno,name,author,quantity) values(?,?,?,?)");
		ps.setString(2,author);
		ps.setString(3,locate);
		ps.setInt(4,quantity);
		status=ps.executeUpdate();
		con.close();
	}catch(Exception e){
		e.printStackTrace();
		System.out.println(e);}
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
	}catch(Exception e){System.out.println(e);}
	return status;
}
}
