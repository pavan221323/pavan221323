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

public class myclass2 extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ServletContext sc=getServletContext();
		String user1=sc.getInitParameter("user");
		String password1=sc.getInitParameter("password");
		
		int id=Integer.parseInt(req.getParameter("userid"));
		double salary=Double.parseDouble(req.getParameter("usersalary"));
		res.getWriter().print("Records Updated");
		try {
		     Driver d=new Driver();
		     DriverManager.registerDriver(d);
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee",user1,password1);
			PreparedStatement pt=conn.prepareStatement("update formtable set salary=? where id=?");
			pt.setDouble(1, salary);
			pt.setInt(2, id);
			
		pt.executeUpdate();
		
		
		
		conn.close();
	} catch ( SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	}

}
