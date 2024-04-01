package myproject;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.mysql.cj.jdbc.Driver;

public class myclass extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		ServletContext sc=getServletContext();
		String user1=sc.getInitParameter("user");
		String password1=sc.getInitParameter("password");
		
		int id=Integer.parseInt(req.getParameter("userid"));
		String name=req.getParameter("username");
		long contact=Long.parseLong(req.getParameter("usercontact"));
		double salary=Double.parseDouble(req.getParameter("usersalary"));
		res.getWriter().print("Records Updated");
		try {
		     Driver d=new Driver();
		     DriverManager.registerDriver(d);
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee",user1,password1);
			PreparedStatement pt=conn.prepareStatement("insert into formtable values(?,?,?,?)");
			pt.setInt(1, id);
			pt.setString(2, name);
			pt.setLong(3, contact);
			pt.setDouble(4, salary);
			
		pt.executeUpdate();
		
		
		
		conn.close();
	} catch ( SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

}
