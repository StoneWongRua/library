package com.tong.dao;

import java.sql.*;

import com.tong.util.DbConnection;
public class LibrarianDao {

	
	public static int save(String name,String password,String contact){
		int status=0;
		try{
			Connection con=DbConnection.getConn();
			PreparedStatement ps=con.prepareStatement("insert into librarian(name,password,contact) values(?,?,?)");
			ps.setString(1,name);
			ps.setString(2,password);
			ps.setString(3,contact);
			status=ps.executeUpdate();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
	public static int delete(int id){
		int status=0;
		try{
			Connection con=DbConnection.getConn();
			PreparedStatement ps=con.prepareStatement("delete from librarian where id=?");
			ps.setInt(1,id);
			status=ps.executeUpdate();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}

	public static boolean validate(String name,String password){
		boolean status=false;
		try{
			Connection con=DbConnection.getConn();
			PreparedStatement ps=con.prepareStatement("select * from librarian where name=? and password=?");
			ps.setString(1,name);
			ps.setString(2,password);
			ResultSet rs=ps.executeQuery();
			status=rs.next();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}

}
