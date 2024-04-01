package dao;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.rowset.serial.SerialBlob;


import dto.user;

public class dao {
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/todobatabase","root","root");
		return conn;
	}
	
	public static int saveuser(user user) throws ClassNotFoundException, SQLException {
		Connection con=getConnection();
		PreparedStatement pt=con.prepareStatement("insert into usertable values(?,?,?,?,?,?)");
		
		pt.setInt(1, user.getUserid());
		pt.setString(2, user.getUsername());
		pt.setString(3,user.getUseremail());
		pt.setLong(4, user.getUsercontact());
		pt.setString(5,user.getUserpassword());
		
		Blob imageBlob=new SerialBlob(user.getUserimage());
		pt.setBlob(6,imageBlob);
		int res=pt.executeUpdate();
		return res;
		
	}
	public user findbyemail(String email) throws ClassNotFoundException, SQLException {
		Connection conn=getConnection();
		PreparedStatement pst=conn.prepareStatement("select * from usertable where useremail=?");
		pst.setString(1, email);
		ResultSet rs=pst.executeQuery();
		
		if(rs.next()) {
			user u=new user();
			u.setUserid(rs.getInt(1));
			u.setUsername(rs.getString(2));
			u.setUseremail(rs.getString(3));
			u.setUsercontact(rs.getLong(4));
			u.setUserpassword(rs.getString(5));
			
			//convert bllog img to byt[]
			
			Blob imageBlob=rs.getBlob(6);
			byte[] image=imageBlob.getBytes(1, (int)imageBlob.length());
			
			u.setUserimage(image);
			
			return u;
		}
		else {
			return null;
		}
	}
	

}
