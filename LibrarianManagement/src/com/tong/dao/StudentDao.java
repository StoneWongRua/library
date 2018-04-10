package com.tong.dao;

import java.sql.*;

import com.tong.util.DbConnection;
public class StudentDao {


	public static boolean validate(String name,String password){
		boolean status=false;
		try{
			Connection con=DbConnection.getConn();
			PreparedStatement ps=con.prepareStatement("select * from student where name=? and password=?");
			ps.setString(1,name);
			ps.setString(2,password);
			ResultSet rs=ps.executeQuery();
			status=rs.next();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}

}
