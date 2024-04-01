package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.dao;
import dto.user;

public class login extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		
		dao dao=new dao();
		
		try {
			user u=dao.findbyemail(email);
			if(u!=null) {
				//verify the password
				if(u.getUserpassword().equals(password))
				{
					HttpSession session=req.getSession();
					session.setAttribute("user", u);
							
					req.getRequestDispatcher("home.jsp").include(req, resp);
				}
				else{
					req.getRequestDispatcher("login.jsp").include(req, resp);
				}
			}
			else {
				//email is wrong
				req.getRequestDispatcher("login.jsp").include(req, resp);
			}
			
			
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
